package seminar.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class CourseList {

	private static List<Course> _courses;

	static {
		initialize();
	}
	
	public static void initialize(){
		_courses = new ArrayList<Course>();
	}

	public static List<Course> getCourses() {		
		return _courses;
    }
	
	public static Course getCourse(int id) { // TODO store and get through map ??		
		for(Course s : _courses){
			if(s.getNumber() == id) return s;
		}		
		return null;
    }

	public static Map<String, String> storeCourse(Map<String, String> params){
		Map<String, String> errors = new HashMap<String, String>();
		
		if(params.get("name").isEmpty()) errors.put("name", "Please insert a valid name");
		
		if(params.get("location").isEmpty()) errors.put("location", "Please insert a valid location");
		
		int seats = 0;
		try {
			seats = Integer.valueOf(params.get("seats"));
			if(seats <= 0) throw new IllegalArgumentException();
		} catch (IllegalArgumentException e) {
			errors.put("seats", "Please insert a valid seats number");
		}

		Date startDate = new Date();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
			startDate = sdf.parse(params.get("startDate"));
		} catch (ParseException e) {
			errors.put("startDate", "Please insert a valid start date");
		}
		
		if(errors.isEmpty()){
			int nextId = _courses.size() + 1;
			Course aCourse = new Course(nextId, params.get("name"), startDate, params.get("description"), params.get("location"), seats);
			_courses.add(aCourse);
		}
		
		return errors;
	}
	
}

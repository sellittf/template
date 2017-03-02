package seminar.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public final class CourseList {

	private static List<Course> _courses = new ArrayList<Course>();
	
	public static List<Course> getCourses() {		
		return _courses;
    }

	public static Course getCourse(int id) {		
		for(Course s : _courses){
			if(s.getNumber() == id) return s;
		}		
		return null;
    }

	public static void storeCourse(String name, String startDateString){
		int nextId = _courses.size() + 1;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Course aCourse = new Course(name, nextId, sdf.parse(startDateString));
			_courses.add(aCourse);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}

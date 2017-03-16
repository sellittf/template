package seminar.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Course {

	private int _number;
	private String _name;
	private Date _startDate;
	private String _description;
	private String _location;
	private int _seats;

	private List<Enrollment> _enrollments = new ArrayList<Enrollment>();

	public Course(int number, String name, Date startDate, String description, String location, int seats) {
		_number = number;
		_name = name;
		_startDate = startDate;
		_description = description;
		_location = location;
		_seats = seats;
	}

	public int getNumber() {
		return _number; 
	}

	public Map<String, Object> getAttributes(){
		Map<String, Object> attributes = new HashMap<String, Object>();
		attributes.put("number", _number);
		attributes.put("name", _name);
		attributes.put("description", _description);
		attributes.put("startDate", _startDate);
		attributes.put("location", _location);
		attributes.put("seats", _seats);
		return attributes;
	}
	
	public int getSeatsLeft() {
		return _seats - _enrollments.size();
	}
	
	public void addEnrollment(Student student, String info){
		Enrollment enrollment = new Enrollment(student, info);
		_enrollments.add(enrollment);
	}
	
	public List<Student> getStudentList(){
		List<Student> list = new ArrayList<Student>();
		for(Enrollment enrollment : _enrollments){
			list.add(enrollment._student);
		}
		return list;
	}
	
	
}

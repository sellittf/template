package ch.gmtech.school.seminar;

import java.util.Date;

public class Course {

	private String _name;
	private int _number;
	private Date _startDate;

	public Course(String name, int number, Date startDate) {
		_name = name;
		_number = number;
		_startDate = startDate;
	}
	
	public String getName() {
		return _name; 
	}
	
	public int getNumber() {
		return _number; 
	}

	public Date getStartDate() {
		return _startDate; 
	}

}

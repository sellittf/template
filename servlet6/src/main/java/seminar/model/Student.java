package seminar.model;

public class Student {

	private String _firstName;
	private String _lastName;
	private String _info;
	
	public Student(String firstName, String lastName, String info) {
		_firstName = firstName;
		_lastName = lastName;
		_info = info;
	}
	
	public String getFullName() {
		return _firstName + " " + _lastName;
	}

	public String getFirstName() {
		return _firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public String getInfo(){
		return _info;
	}
}

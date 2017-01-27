package ch.gmtech.school.seminar;

public class Enrollment {
	public Student _student;
	private String _info;
	
	public Enrollment(Student student, String info){
		_student = student;
		_info = info;
	}
	
	public String getInfo(){
		return _info;
	}
}

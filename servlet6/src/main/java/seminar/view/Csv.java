package seminar.view;

import java.util.List;

import seminar.model.Course;
import seminar.model.Seminar;
import seminar.model.Student;

public class Csv extends OutputFormat {

	@Override
	public String render(Seminar seminar) {
		String csv = new String();

		String[] attributes = new String[] {String.valueOf(seminar.getNumber()),
											seminar.getName(),
											seminar.getDescription(),
											seminar.getLocation(),
											String.valueOf(seminar.getSeatsLeft())
											}; 				
		csv += toString(attributes);
		
		for(Student student : seminar.getStudentList()){
			attributes = new String[] {student.getFirstName(), student.getLastName()};
			csv += "\n" + toString(attributes);
		}
		return csv;
	}
	
	private String toString(String[] attributes){
		String s = new String();
		
		for (int i = 0; i < attributes.length; i++) {
			if(i > 0) s += ";";
			s += "\"" + attributes[i] + "\"";
		}

		return s;
	}

	@Override
	public String render(List<Course> courses) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String render(Course course) {
		// TODO Auto-generated method stub
		return null;
	}

}

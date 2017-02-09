package seminar.model;

import java.util.ArrayList;
import java.util.List;

public final class SeminarList {

	private static List<Seminar> _seminars = new ArrayList<Seminar>();

	static {
		buildSeminars();
	}
	
	public static Seminar getSeminar(int id) {		
		for(Seminar s : _seminars){
			if(s.getNumber() == id) return s;
		}
		
		return null;
    }

	private static void buildSeminars() {
		Seminar _seminar = new Seminar("Online Marketing", "Quick introduction", "Aula magna", 15);
		Student student1 = new Student("Pinco", "Pallino", "uno qualunque");
		_seminar.addEnrollment(student1, "marketing junior operator");
		Student student2 = new Student("Jorge", "Camacho", "olé");
		_seminar.addEnrollment(student2, "marketing advisor");		
		
		_seminars.add(_seminar);
	}	
}

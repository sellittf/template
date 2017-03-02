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
		Seminar aSeminar = new Seminar("Online Marketing", "Quick introduction", "Aula magna", 15);
		Student student1 = new Student("Pinco", "Pallino", "uno qualunque");
		aSeminar.addEnrollment(student1, "marketing junior operator");
		Student student2 = new Student("Jorge", "Camacho", "olé");
		aSeminar.addEnrollment(student2, "marketing advisor");		
		
		storeSeminar(aSeminar);
	}
	
	public static void storeSeminar(Seminar aSeminar){
		_seminars.add(aSeminar);
	}
}

package ch.gmtech.school.seminar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SeminarTest {

	private Seminar _seminar;
	
	@Before
	public void setUp() throws Exception {
		_seminar = new Seminar("Online Marketing", "Quick introduction", "Aula magna", 15);
	}

	@Test
	public void testGetName() {
		assertThat(_seminar.getName(), is("Online Marketing"));
	}

	@Test
	public void testGetDescription() {
		assertThat(_seminar.getDescription(), is("Quick introduction"));
	}

	@Test
	public void testGetLocation() {
		assertThat(_seminar.getLocation(), is("Aula magna"));
	}

	@Test
	public void testGetSeatsLeft() {
		assertThat(_seminar.getSeatsLeft(), is(15));
	}

	@Test
	public void testGetStudentList() {
		Student student1 = new Student("Pinco", "Pallino", "uno qualunque");
		_seminar.addEnrollment(student1, "marketing junior operator");
		Student student2 = new Student("Jorge", "Camacho", "olé");
		_seminar.addEnrollment(student2, "marketing advisor");		
		
		List<Student> students = Arrays.asList(student1, student2);
		assertThat(_seminar.getStudentList(), is(students));
	}

}

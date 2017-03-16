package seminar.model;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
	
	private Course _course;
	private SimpleDateFormat _sdf = new SimpleDateFormat("yyyy-MM-dd");

	@Before
	public void setUp() throws Exception {
		_course = new Course(1, "Crash course", _sdf.parse("2016-09-01"), "Quick introduction", "Aula magna", 12);
	}

	@Test
	public void testGetNumber() {
		assertThat(_course.getNumber(), is(1));
	}

	@Test
	public void testGetAttributes() throws ParseException {
		Map<String, Object> attributes = _course.getAttributes();

		assertThat(Integer.valueOf(attributes.get("number").toString()), is(1));
		assertThat(attributes.get("name").toString(), is("Crash course"));
		assertThat(attributes.get("description").toString(), is("Quick introduction"));
		assertThat(attributes.get("startDate").toString(), is(_sdf.parse("2016-09-01").toString()));
		assertThat(attributes.get("location").toString(), is("Aula magna"));
		assertThat(Integer.valueOf(attributes.get("seats").toString()), is(12));
	}

	@Test
	public void testGetSeatsLeft() {
		assertThat(_course.getSeatsLeft(), is(12));
	}

	@Test
	public void testGetStudentList() {
		Student student1 = new Student("Pinco", "Pallino", "uno qualunque");
		_course.addEnrollment(student1, "marketing junior operator");
		Student student2 = new Student("Jorge", "Camacho", "olé");
		_course.addEnrollment(student2, "marketing advisor");		
		
		List<Student> students = Arrays.asList(student1, student2);
		assertThat(_course.getStudentList(), is(students));
	}
	
}

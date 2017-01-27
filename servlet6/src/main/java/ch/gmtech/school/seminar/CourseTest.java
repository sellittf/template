package ch.gmtech.school.seminar;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

public class CourseTest {
	
	private Course _course;

	@Before
	public void setUp() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		_course = new Course("Crash course", 1, sdf.parse("2016-09-01"));
	}

	@Test
	public void testGetName() {
		assertThat(_course.getName(), is("Crash course"));
	}

	@Test
	public void testGetNumber() {
		assertThat(_course.getNumber(), is(1));
	}

	@Test
	public void testGetStartDate() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		assertThat(_course.getStartDate(), is(sdf.parse("2016-09-01")));
	}

}

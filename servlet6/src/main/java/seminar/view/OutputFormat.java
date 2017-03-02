package seminar.view;

import java.util.List;

import seminar.model.Course;
import seminar.model.Seminar;

public abstract class OutputFormat {

	public abstract String render(Seminar seminar);

	public abstract String render(List<Course> courses);

	public abstract String render(Course course);

}

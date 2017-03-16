package seminar.view;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import seminar.model.Course;
import seminar.model.CourseList;

public class HtmlTest {

	final String basePath = "/sources/git/gmtech_school/template/servlet6/src/main/webapp/templates/";
	String _indexExpectedHtml;
	String _showExpectedHtml;

	@Before
	public void setUp() throws Exception {
		for(int i = 1; i <= 3; i++){
			Map<String, String> params = new HashMap<String, String>();
			params.put("number", String.valueOf(i));
			params.put("name", "Crash course");
			params.put("startDate", "01.09.2016");
			params.put("description", "Quick introduction");
			params.put("location", "Aula magna");
			params.put("seats", String.valueOf(10 + i));			
			CourseList.storeCourse(params);		
		}
		_indexExpectedHtml = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title>Courses</title><link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\"><script src=\"/js/jquery.min.js\"></script><script src=\"/js/bootstrap.min.js\"></script></head><body><div class=\"container\"><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\"><div class=\"list-group\"><a href=\"/course?id=1\" class=\"list-group-item\"><div class=\"row\"><div class=\"col-sm-12\"><h2>Crash course</h2></div></div><div class=\"row\"><div class=\"col-sm-6\"><h4>Aula magna</h4></div><div class=\"col-md-6 text-right\">Thu Sep 01 00:00:00 CEST 2016<p>11 seats</p></div></div></a><a href=\"/course?id=2\" class=\"list-group-item\"><div class=\"row\"><div class=\"col-sm-12\"><h2>Crash course</h2></div></div><div class=\"row\"><div class=\"col-sm-6\"><h4>Aula magna</h4></div><div class=\"col-md-6 text-right\">Thu Sep 01 00:00:00 CEST 2016<p>12 seats</p></div></div></a><a href=\"/course?id=3\" class=\"list-group-item\"><div class=\"row\"><div class=\"col-sm-12\"><h2>Crash course</h2></div></div><div class=\"row\"><div class=\"col-sm-6\"><h4>Aula magna</h4></div><div class=\"col-md-6 text-right\">Thu Sep 01 00:00:00 CEST 2016<p>13 seats</p></div></div></a></div><a href=\"/course/create\" class=\"btn btn-primary\">Create course</a></div></div></div></body></html>";
		_showExpectedHtml = "<!DOCTYPE html><html><head><meta charset=\"utf-8\"><meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"><title>Course</title><link rel=\"stylesheet\" href=\"/css/bootstrap.min.css\"><script src=\"/js/jquery.min.js\"></script><script src=\"/js/bootstrap.min.js\"></script></head><body><div class=\"container\"><div class=\"row\"><div class=\"col-md-6 col-md-offset-3\"><div class=\"panel panel-info\"><div class=\"panel-heading\"><div class=\"row\"><div class=\"col-sm-12\"><h2></h2></div></div><div class=\"row\"><div class=\"col-sm-6\"><h4></h4></div><div class=\"col-md-6 text-right\"><p> seats</p></div></div></div><div class=\"panel-body\"><p></p></div></div><a href=\"/course\" class=\"btn btn-default\"><span class=\"glyphicon glyphicon-backward\"></span> Back to courses</a></div></div></div></body></html>";
	}
	
	@After
	public void tearDown(){
		CourseList.initialize();
	}

	@Test
	public void testIndex() throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();

		List<Map<String, Object>> courses_attributes = new ArrayList<Map<String, Object>>();
		for(Course course : CourseList.getCourses()){
			courses_attributes.add(course.getAttributes());
		}
		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/index");				
		model.put("courses", courses_attributes);				
		String output = Jade4J.render(template, model);

		assertThat(output, is(_indexExpectedHtml));	
	}

	@Test
	public void testShow() throws IOException {
		Map<String, Object> model = new HashMap<String, Object>();

		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/show");				
		model.put("courses", CourseList.getCourse(1).getAttributes());				
		String output = Jade4J.render(template, model);

		assertThat(output, is(_showExpectedHtml));	
	}

	@Test
	public void testIndexRequest() throws Exception {
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage("http://localhost:8080/course");
		
		assertThat(page.asText(), is(_indexExpectedHtml));	
	}

	@Test
	public void testShowRequest() throws Exception {
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage("http://localhost:8080/course?id=1");
		
		System.out.println(page.asText());
		
//		assertThat(page.asText(), is(_showExpectedHtml));	
	}

}

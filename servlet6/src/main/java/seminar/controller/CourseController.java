package seminar.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import seminar.model.Course;
import seminar.model.CourseList;
import de.neuland.jade4j.Jade4J;
import de.neuland.jade4j.template.JadeTemplate;

public class CourseController {

	final String basePath = "/sources/git/gmtech_school/template/servlet6/src/main/webapp/templates/";
	Map<String, Object> model = new HashMap<String, Object>();
	
	public String index() throws IOException{
		List<Map<String, Object>> courses_attributes = new ArrayList<Map<String, Object>>();
		for(Course course : CourseList.getCourses()){
			courses_attributes.add(course.getAttributes());
		}
		
		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/index");				
		model.put("courses", courses_attributes);				
		return Jade4J.render(template, model);
	}

	public String show(int id) throws IOException, Exception{
		String content;
		Course course = CourseList.getCourse(id);
		
		if(course == null) throw new Exception("Course");

		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/show");				
		model.put("course", course.getAttributes());				
		content = Jade4J.render(template, model);

		return content;
	}

	public String edit() throws IOException{
		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/edit");
		return Jade4J.render(template, model);		
	}

	public String update(Map<String, String> params) throws IOException{
		Map<String, String> errors = CourseList.storeCourse(params);
		
		if(errors.isEmpty()) return "";
		
		JadeTemplate template = Jade4J.getTemplate(basePath + "courses/edit");
		model.put("errors", errors);				
		model.put("course", params);				
		return Jade4J.render(template, model);		
	}

}

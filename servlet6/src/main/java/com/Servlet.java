package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seminar.model.Course;
import seminar.model.CourseList;
import seminar.view.*;

public class Servlet extends HttpServlet {

	HttpServletResponse _resp;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_resp = resp;
		
		String requestUri = req.getRequestURI();
		PrintWriter output = resp.getWriter();
		String content = "";
			
		if(requestUri.equals("/try/me")){
			content = tryMe();
		}else if(requestUri.equals("/course")){
			String idParam = req.getParameter("id");
			if(idParam == null){
				Html view = new Html();		
				content = view.render(CourseList.getCourses());
			}else{
				content = course(Integer.valueOf(idParam));
			}
		}else if(requestUri.equals("/course/create")){
			Html view = new Html();			
			content = view.newCourse();
		}else{
			content = notFound("Page");
		}
		
		output.write(content);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_resp = resp;
		
		String requestUri = req.getRequestURI();
		PrintWriter output = resp.getWriter();
		String content = "";
		
		if(requestUri.equals("/course/create")){
			CourseList.storeCourse(req.getParameter("name"), req.getParameter("startDate"));
			resp.sendRedirect("/course");
		}else{
			content = notFound("Page");
		}
		
		output.write(content);
	}

	private String tryMe(){
		return "<h1>you did it!</h1>";
	}

	private String notFound(String subject){
		_resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return "<h1>" + subject +" not found!</h1>";
	}
	
	private String course(int id){
		Course _course = CourseList.getCourse(id);
		if(_course == null) return notFound("Seminar");
		
		OutputFormat output;

		output = new Html();

		return output.render(_course);					
	}

}

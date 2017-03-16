package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seminar.controller.CourseController;

public class Servlet extends HttpServlet {

	HttpServletResponse _resp;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		_resp = resp;
		
		String requestUri = req.getRequestURI().replaceAll("/$", "");
		PrintWriter output = resp.getWriter();
		String content;

		if(requestUri.equals("/course")){
			String idParam = req.getParameter("id");
			if(idParam == null){
				content = new CourseController().index();
			}else{
				try {
					int courseId = Integer.valueOf(idParam);
					content = new CourseController().show(courseId);
				} catch (Exception e) {
					content = notFound(e.toString());
				}
			}
		}else if(requestUri.equals("/course/create")){
			content = new CourseController().edit();
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
		String content;

		if(requestUri.equals("/course/create")){
			content = new CourseController().update(flatten(req.getParameterMap()));
			if(content.isEmpty()) resp.sendRedirect("/course");
		}else{
			content = notFound("Page");
		}
		
		output.write(content);
	}

	private String notFound(String subject){
		_resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
		return "<h1>" + subject +" not found!</h1>";
	}

	private static Map<String, String> flatten(Map<String, String[]> arrayMap){
		Map<String, String> r = new HashMap<String, String>();
		for (Map.Entry<String, String[]> entry: arrayMap.entrySet()){
			String[] value = entry.getValue();
			if (value != null && value.length > 0) r.put(entry.getKey(), value[0]);
		}
		return r;
	}
}

package com;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.gmtech.school.seminar.Seminar;
import ch.gmtech.school.seminar.SeminarList;
import ch.gmtech.school.seminar.Student;
import ch.gmtech.school.seminar.view.*;

public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String requestUri = req.getRequestURI();
		PrintWriter output = resp.getWriter();
		String content = "";
			
		if(requestUri.equals("/try/me")){
			content = tryMe();
		}else if(requestUri.equals("/course/html")){
			content = course("html");
		}else if(requestUri.equals("/course/csv")){
			content = course("csv");		
			downloadResponse(resp, content, "course.csv");			
		}else if(requestUri.equals("/course/raw")){
			content = course("raw");
		}else{
			content = notFound("Page");
		}
		
		output.write(content);
	}
	
	private String tryMe(){
		return "<h1>you did it!</h1>";
	}

	private String notFound(String subject){
		return "<h1>" + subject +" not found!</h1>";
	}
	
	private String course(String format){
		Seminar _seminar = SeminarList.getSeminar(1);
		if(_seminar == null) return notFound("Seminar");
		
		OutputFormat output;
		
		if(format.equals("html")){
			output = new Html();
		}else if(format.equals("csv")){
			output = new Csv();
		}else if(format.equals("raw")){
			output = new Raw();
		}else{
			return notFound("Page");
		}

		return output.render(_seminar);					
	}

	private void downloadResponse(HttpServletResponse response, String content, String filename) {
	    response.setContentType("text/csv");
	    response.setHeader("Content-Disposition", "attachment; filename=\""+ filename +"\"");
	    try {
	        OutputStream outputStream = response.getOutputStream();
	        String outputResult = content;
	        outputStream.write(outputResult.getBytes());
	        outputStream.flush();
	        outputStream.close();
	    } catch(Exception e) {
	        System.out.println(e.toString());
	    }
	}
}

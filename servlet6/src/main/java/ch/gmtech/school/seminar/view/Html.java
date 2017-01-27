package ch.gmtech.school.seminar.view;

import ch.gmtech.school.seminar.Seminar;
import ch.gmtech.school.seminar.Student;

public class Html extends OutputFormat {

	@Override
	public String render(Seminar seminar) {
		String html_head = "<head><title>" + seminar.getName() + "</title></head>";

		String html_body = "<body>" +
							"<div>" + seminar.getName() + ":</div>" +
							"<ul>" +
					          "<li>" + seminar.getDescription() + "</li>" +
					          "<li>" + seminar.getLocation() + "</li>" +
					          "<li>" + seminar.getSeatsLeft() + "</li>" +
							"</ul>" +
					        "<div>partecipanti:</div>" +
							"<ul>";

		for(Student student : seminar.getStudentList()){
			html_body += "<li>" + student.getFullName() + "</li>";
		}

		html_body += "<body>";

		return "<html>" + html_head + html_body + "</html>";

	}

}

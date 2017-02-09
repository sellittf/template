package seminar.view;

import seminar.model.Seminar;
import seminar.model.Student;

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

	
	public String newCourse(){
		String html = "<!DOCTYPE html>                                                                                                                                 " +
			    "<html lang='en'>                                                                                                                                " +
			    "  <head>                                                                                                                                        " +
			    "    <meta charset='utf-8'>                                                                                                                      " +
			    "    <meta http-equiv='X-UA-Compatible' content='IE=edge'>                                                                                       " +
			    "    <meta name='viewport' content='width=device-width, initial-scale=1'>                                                                        " +
			    "    <title>Seminar</title>                                                                                      								 " +
			    "    <link rel='stylesheet' href='/css/bootstrap.min.css'>                                        												 " +
			    "  </head>                                                                                                                                       " +
			    "  <body>                                                                                                                                        " +
			    "  	<div class='container'>                                                                                                                      " +
			    "  		<div class='row'>                                                                                                                        " +
			    "  			<div class='col-md-6 col-md-offset-3'>                                                                                               " +
			    "  				<h1 class='page-header text-center'>New Course</h1>                                                                    " +
			    "				<form class='form-horizontal' role='form' method='post' action=''>                                                      		 " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='name' class='col-sm-2 control-label'>Name</label>                                                            " +
			    "						<div class='col-sm-10'>                                                                                                  " +
			    "							<input type='text' class='form-control' id='name' name='name' placeholder='Course name'>          " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<label for='start_date' class='col-sm-2 control-label'>Start date</label>                                                          " +
			    "						<div class='col-sm-10'>                                                                                                  " +
		        "							<input type='date' class='form-control' id='start_date' name='startDate' placeholder='Start date'>      " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "					<div class='form-group'>                                                                                                     " +
			    "						<div class='col-sm-10 col-sm-offset-2'>                                                                                  " +
			    "							<input id='submit' name='submit' type='submit' value='Send' class='btn btn-primary'>                                 " +
			    "						</div>                                                                                                                   " +
			    "					</div>                                                                                                                       " +
			    "				</form>                                                                                                                          " +
			    "			</div>                                                                                                                               " +
			    "		</div>                                                                                                                                   " +
			    "	</div>                                                                                                                                       " +
			    "    <script src='/js/jquery.min.js'></script>                                                   												 " +
			    "    <script src='/js/bootstrap.min.js'></script>                                                 												 " +
			    "</body> ";
		return html;
		
	}
}

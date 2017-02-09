package seminar.view;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.junit.Before;
import org.junit.Test;

import seminar.model.Seminar;
import seminar.model.SeminarList;

public class HtmlTest {

	Seminar _seminar;
	String _expectedHtml;
	OutputFormat output;
	
	@Before
	public void setUp() throws Exception {
		_seminar = SeminarList.getSeminar(1);
		_expectedHtml = "<html><head><title>Online Marketing</title></head><body><div>Online Marketing:</div><ul><li>Quick introduction</li><li>Aula magna</li><li>13</li></ul><div>partecipanti:</div><ul><li>Pinco Pallino</li><li>Jorge Camacho</li><body></html>";
	}

	@Test
	public void testRender() {
		output = new Html();
		
		assertThat(output.render(_seminar), is(_expectedHtml));	
	}

	@Test
	public void testHtmlRequest() throws Exception {
		WebClient webClient = new WebClient();
		HtmlPage page = webClient.getPage("http://localhost:8080/course/html");
		
		assertThat(page.asText(), is(_expectedHtml));	
	}

}

package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11329")
public class BenchmarkTest11329 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = "";
		java.util.Enumeration<String> names = request.getParameterNames();
		if (names.hasMoreElements()) {
			param = names.nextElement(); // just grab first element
		}

		String bar = new Test().doSomething(param);
		
		response.setHeader(bar, "SomeValue");
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar;
		
		// Simple ? condition that assigns param to bar on false condition
		int i = 106;
		
		bar = (7*42) - i > 200 ? "This should never happen" : param;
		

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest11337")
public class BenchmarkTest11337 extends HttpServlet {
	
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
		
		response.getWriter().write(bar);
	}  // end doPost

    private class Test {

        public String doSomething(String param) throws ServletException, IOException {

		String bar = "safe!";
		java.util.HashMap<String,Object> map78324 = new java.util.HashMap<String,Object>();
		map78324.put("keyA-78324", "a_Value"); // put some stuff in the collection
		map78324.put("keyB-78324", param.toString()); // put it in a collection
		map78324.put("keyC", "another_Value"); // put some stuff in the collection
		bar = (String)map78324.get("keyB-78324"); // get it back out
		bar = (String)map78324.get("keyA-78324"); // get safe value back out

            return bar;
        }
    } // end innerclass Test

} // end DataflowThruInnerClass
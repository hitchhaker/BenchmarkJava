package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest17384")
public class BenchmarkTest17384 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		java.util.Map<String,String[]> map = request.getParameterMap();
		String param = "";
		if (!map.isEmpty()) {
			param = map.get("foo")[0];
		}
		

		String bar = doSomething(param);
		
		java.security.Provider[] provider = java.security.Security.getProviders();
		java.security.MessageDigest md;

		try {
			if (provider.length > 1) {

				md = java.security.MessageDigest.getInstance("SHA1", provider[0]);
			} else {
				md = java.security.MessageDigest.getInstance("SHA1", "Sun");
			}
		} catch (java.security.NoSuchAlgorithmException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
		} catch (java.security.NoSuchProviderException e) {
			System.out.println("Problem executing hash - TestCase java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider)");
		}

		response.getWriter().println("Hash Test java.security.MessageDigest.getInstance(java.lang.String,java.security.Provider) executed");
	}  // end doPost
	
	private static String doSomething(String param) throws ServletException, IOException {

		String bar = org.apache.commons.lang.StringEscapeUtils.escapeHtml(param);
	
		return bar;	
	}
}
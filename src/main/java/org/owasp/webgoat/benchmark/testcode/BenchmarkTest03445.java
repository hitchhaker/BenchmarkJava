package org.owasp.webgoat.benchmark.testcode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BenchmarkTest03445")
public class BenchmarkTest03445 extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String param = request.getParameter("foo");
		
		
		StringBuilder sbxyz48375 = new StringBuilder(param);
		String bar = sbxyz48375.append("_SafeStuff").toString();
		
		
		String sql = "SELECT * from USERS where USERNAME='foo' and PASSWORD='"+ bar +"'";
				
		try {
			java.sql.Statement statement =  org.owasp.webgoat.benchmark.helpers.DatabaseHelper.getSqlStatement();
			statement.execute( sql, java.sql.Statement.RETURN_GENERATED_KEYS );
		} catch (java.sql.SQLException e) {
			throw new ServletException(e);
		}
	}
}
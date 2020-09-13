package com.law.jdbc;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = Servlet.class, property = {"sling.servlet.paths=/sandeep/jdbc", "sling.servlet.methods={GET,POST}"})
public class JDBCServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Reference CRUDOperations crud;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("JDBC Servlet Called - 6.4");
		String buses = crud.retrieveBuses();
		response.getWriter().write(buses);
	}
}

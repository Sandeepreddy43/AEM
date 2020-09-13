package com.law.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = { ServletResolverConstants.SLING_SERVLET_NAME + " = My Servlet",
ServletResolverConstants.SLING_SERVLET_PATHS + "=/sandeep/test",
ServletResolverConstants.SLING_SERVLET_METHODS + "=GET" })

public class TestServlet1_ServletResolverConstants extends SlingAllMethodsServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/content/Law-Proj/indexPage.html").forward(request, response);
//	response.getWriter().write("Testing by Sandeep - Custom Path");
	}
}

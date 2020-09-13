package com.vegfood.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.ServletResolverConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

/**
 * Servlet implementation class Sample2
 */

@Component(service = Servlet.class, property = { ServletResolverConstants.SLING_SERVLET_NAME + " = My Servlet",
ServletResolverConstants.SLING_SERVLET_PATHS + "=/sandeepReddie/sample2",
ServletResolverConstants.SLING_SERVLET_METHODS + "=GET" })
public class Sample_ServletResolverConstants extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see SlingSafeMethodsServlet#SlingSafeMethodsServlet()
     */
    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
    		throws ServletException, IOException {
    	request.getRequestDispatcher("/content/music-school/indexResponsive.html").forward(request, response);
//    	response.getWriter().write("Testing by Sandeep");
    }
    @Override
    protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.doGet(request, response);
    }
}

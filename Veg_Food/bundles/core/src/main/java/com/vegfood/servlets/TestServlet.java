package com.vegfood.servlets;

import java.io.IOException;
import java.util.Iterator;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.vegfood.services.Test;

@Component(service =Servlet.class, name = "Test Servlet", 
property = {"sling.servlet.paths=/bin/test", "sling.servlet.methods={GET,POST}"})
public class TestServlet extends SlingAllMethodsServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7454938573187377093L;
	
	@Reference
	private Test test;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String path =  request.getParameter("path");
		response.getWriter().write("Do Get Called");
		if(null != path) {
			doGetChildren(request,response, path);
		}else {
			String author = test.author("Static");
			response.getWriter().write("Page Path parameter missing "+author);
		}
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		String path =  request.getParameter("path");
		String name =  request.getParameter("name");
		if(null != name ) {
			response.getWriter().write("Hi  ... "+name);
		}
		response.getWriter().write("Do Post Called");
		if(null != path) {
			doGetChildren(request,response, path);
		}else {
			response.getWriter().write("Page Path parameter missing");
		}
	}
	private void doGetChildren(SlingHttpServletRequest request, SlingHttpServletResponse response, String path) throws IOException {
		ResourceResolver resourceResolver = request.getResourceResolver();
		if(null != resourceResolver) {
			PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
			Page page = pageManager.getPage(path);
			if(null != page) {
				Iterator<Page> listChildren = page.listChildren();
				while(listChildren.hasNext()) {
					response.getWriter().write(listChildren.next().getTitle());
				}
			}else {
				response.getWriter().write("Invalid Page Path");
			}
		}
	}

	
}

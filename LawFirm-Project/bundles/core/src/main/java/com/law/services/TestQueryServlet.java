package com.law.services;

import java.io.IOException;
import java.util.List;

import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.result.Hit;
import com.law.queryBuilder.QueryBuilderInterface;


@Component(service = Servlet.class, name = "Query Servlet", 
property = { "sling.servlet.paths=/bin/abcdef",
	"sling.servlet.methods={GET,POST}" })
public class TestQueryServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Reference
	QueryBuilderInterface builder;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		List<Hit> list = builder.getHitsService();
		for (Hit hit : list) {
			try {
				response.getWriter().println(hit.getPath().toString());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

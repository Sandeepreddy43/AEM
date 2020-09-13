package com.vegfood.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.vegfood.jdbc.CRUD_Operations;
import com.vegfood.jdbc.User;

@Component(service = Servlet.class, name = "JDBC Servlet", property = { "sling.servlet.paths=/sandeepReddie/jdbc", "sling.servlet.methods={GET,POST}" })
public class JDBCServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Reference
	private CRUD_Operations crud;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Servlet Called - JDBC");
		List<User> retriveUserInfo = crud.retriveUserInfo();
		if (retriveUserInfo != null) {
			for (User user : retriveUserInfo) {
				response.getWriter().write(user.toString());
			}
		} else {
			response.getWriter().write("Servlet Name Called - JDBC");
		}
	}

}

package com.law.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONException;
import org.json.JSONObject;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, name = "My Login Servlet" , property = { "sling.servlet.paths=/bin/loginServlet",
"sling.servlet.methods={GET,POST}" })
public class LoginServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().write("\nLogin Servlet .. .. .!!\n");
		String name = request.getParameter("name");
		String mail = request.getParameter("mailId");
		
		JSONObject obj = new JSONObject();
		try {
			obj.put("name", name);
			obj.put("mailId", mail);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.getWriter().println(obj);
	}

}

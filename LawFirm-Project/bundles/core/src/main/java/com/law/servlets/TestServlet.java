package com.law.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.json.JSONArray;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, name = "Demo Servlet", 
	property = { "sling.servlet.paths=/bin/testServlet",
		"sling.servlet.methods={GET,POST}" })
public class TestServlet extends SlingAllMethodsServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
//		MultiFieldDemo md = new MultiFieldDemo();
		List<Map<String, String>> list = new ArrayList<Map<String,String>>();
		for (int i = 0; i < 5; i++) {		
		Map<String, String> map = new HashMap<String, String>();
		map.put("A","123");
		map.put("B","123");
		map.put("C","123");
		map.put("D","123");
		map.put("E","123");
		list.add(map);
		}
		JSONArray jsArray = new JSONArray(list);
		@SuppressWarnings("unused")
		String json = jsArray.toString();
	response.getWriter().write(jsArray.toString());
	
	}
}

package com.vegfood.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(service = Servlet.class, name = "Page Servlet", 
property = {"sling.servlet.paths=/sandeepReddie/page"})
public class PageServlet extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1817052739089761479L;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("do Get called");
		PageManager pageManager = request.getResourceResolver().adaptTo(PageManager.class);
		Page page = null;
		try {
			System.out.println("inside try block");
			page = pageManager.create("/content/music-school", "ServletPage", "/apps/music-school-project/templates/index", "ServletPage");
			page = pageManager.copy(page, "/content/music-school/ServletPage", null, true, true); 
		} catch (WCMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} System.out.println("after catch block");
//		response.getWriter().write(page.getPath()+" "+page.getName()+" "+page.getTitle());
		request.getRequestDispatcher(page.getPath().concat(".html")).forward(request, response);
//	response.getWriter().write("Page Servlet Called");
	}
}

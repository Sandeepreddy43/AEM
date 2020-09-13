package com.vegfood.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(service = Servlet.class, name = "Page Servlet 123", property = { "sling.servlet.paths=/sandeepReddie/page123" })
public class PageServlet_Test extends SlingAllMethodsServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Page pagePath = null;
		ResourceResolver resourceResolver = request.getResourceResolver();
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		Resource parent = resourceResolver.resolve(pagePath + "/target");

		if (parent.getResourceType().equals(Resource.RESOURCE_TYPE_NON_EXISTING)) {
			try {
				Page refPage = pageManager.getPage("/apps/music-school-project/components/page/index");
				
				pagePath = pageManager.create("/content/music-school", "abc",
						"/apps/music-school-project/templates/index", "abc");
				pageManager.copy(pagePath, refPage + "/content/music-school/xyz", null, true, false);
				response.getWriter().write("inside 'try' block");
			} catch (WCMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.getWriter().write("after 'catch' block");
		}
	}
}
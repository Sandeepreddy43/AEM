package com.vegfood.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.vegfood.services.HeaderNavigation;

@Component(service = Servlet.class, name = "Sample Servlet", property = {
		 "sling.servlet.paths=/bin/sampleServlet",
//		"sling.servlet.resourceTypes=regnant/test", 
//		ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES+"=regnant/test"
//		ServletResolverConstants.SLING_SERVLET_RESOURCE_TYPES+"=/apps/music-school-project/components/content/featured-indexPage"
		"sling.servlet.methods={GET,POST}"
		})

public class SampleServlet extends SlingAllMethodsServlet {

	@Reference
	private HeaderNavigation headerNavigation;
	/**
	 * 
	 */
	private static final long serialVersionUID = -4442248848443558910L;

	@SuppressWarnings("unused")
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		List<Resource> resourceList = new ArrayList<Resource>();
		ValueMap vm = null;	
		System.out.println("doGet Called");
		ResourceResolver resolver = request.getResourceResolver();
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		String message = headerNavigation.getMessage();
		response.getWriter().write(message);
//		if (null != pageManager) {
//			System.out.println(pageManager);
//			Page page = pageManager.getPage("/content/we-retail");
//			System.out.println(page);
//			if (page != null) {
//				Iterator<Page> listChildren = page.listChildren();
//				while (listChildren.hasNext()) {
//					ValueMap properties = listChildren.next().getProperties();
//					vm = new ValueMapDecorator(new HashMap<String, Object>());
//					vm.put("value",properties.get("jcr:title", ""));
//					vm.put("text", getShortString(properties.get("jcr:title", "").toString(), 50));
//					resourceList.add(new ValueMapResource(request.getResourceResolver(), new ResourceMetadata(),
//							"nt:unstructured", vm));
//				}
//			}
//		}
//		DataSource ds = new SimpleDataSource(resourceList.iterator());
//		request.setAttribute(DataSource.class.getName(), ds);

	}

	public String getShortString(String post, int width) {
		if (post != null && post.length() > width) {
			return post.substring(0, width - 3) + "...";
		} else {
			return post;
		}
	}

	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().write("Sample Do Post Called");
		System.out.println("doPost called");
		ResourceResolver resolver = request.getResourceResolver();
		response.getWriter().write("Sample Do Post Called" + resolver);
		List<Page> childPages = headerNavigation.getChildPages(resolver, "/content/we-retail");
		childPages.forEach(page -> {
			try {
				System.out.println("inside try block");
				response.getWriter().write(page.getTitle());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}
}

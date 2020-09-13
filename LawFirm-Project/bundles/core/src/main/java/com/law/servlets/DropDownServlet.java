package com.law.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceMetadata;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.wrappers.ValueMapDecorator;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.ui.components.ds.DataSource;
import com.adobe.granite.ui.components.ds.SimpleDataSource;
import com.adobe.granite.ui.components.ds.ValueMapResource;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;


@Component(service = Servlet.class, name = "Dynamic Drop-Down", property = {"sling.servlet.resourceTypes=abc/dropdown"})
public class DropDownServlet extends SlingAllMethodsServlet {

	private static final long serialVersionUID = 7935026325897498826L;
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		List<Resource> resourceList = new ArrayList<Resource>();
		ValueMap vm = null;
		System.out.println("doGet Called - Drop Down Demo");
		ResourceResolver resolver = request.getResourceResolver();
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		if (null != pageManager) {
			System.out.println(pageManager);
			Page page = pageManager.getPage("/content/we-retail/language-masters");
			System.out.println(page);
			if (page != null) {
				Iterator<Page> listChildren = page.listChildren();
				while (listChildren.hasNext()) {
					 ValueMap properties = listChildren.next().getProperties();
					vm = new ValueMapDecorator(new HashMap<String, Object>());
					vm.put("value",properties.get("jcr:title", String.class));
					vm.put("text", getShortString(properties.get("jcr:title", String.class).toString(), 50));
					resourceList.add(new ValueMapResource(request.getResourceResolver(), new ResourceMetadata(),
							"nt:unstructured", vm));
				}
			}
		}
		DataSource ds = new SimpleDataSource(resourceList.iterator());
		request.setAttribute(DataSource.class.getName(), ds);

	}

	public String getShortString(String post, int width) {
		if (post != null && post.length() > width) {
			return post.substring(0, width - 3) + "...";
		} else {
			return post;
		}
	}
}

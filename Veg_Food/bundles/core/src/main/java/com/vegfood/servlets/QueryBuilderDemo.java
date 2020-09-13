package com.vegfood.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import com.day.cq.wcm.api.WCMException;

@Component(service = Servlet.class, property = { "sling.servlet.paths=/sandeepReddie/abcd", "sling.servlet.methods={GET,POST}" })
public class QueryBuilderDemo extends SlingAllMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Reference
	QueryBuilder queryBuilder;
	
	@Reference
	Session session;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resourceResolver = request.getResourceResolver();
		Map<String, String> queryMap = new HashMap<>();
		queryMap.put("type","cq:page");
		queryMap.put("path","/content");
		queryMap.put("property","jcr:createdBy");
		queryMap.put("property.value","test-user");
		queryMap.put("p.limit", "-1");
		Query createQuery = queryBuilder.createQuery(PredicateGroup.create(queryMap), resourceResolver.adaptTo(Session.class));
		SearchResult result = createQuery.getResult();
		createQuery.setStart(0);
		createQuery.setHitsPerPage(4);
		List<Hit> hits = result.getHits();
		response.getWriter().write("Hits Size: "+String.valueOf(hits.size()));
		
		System.out.println("Hits: "+result.getHits().size());
		int i = 1;
		for (Hit hit : result.getHits()) {
			try {
				String path2 = hit.getPath();
				String title = hit.getTitle();
				
				System.out.println("Path:: --> "+path2);
				
				response.getWriter().write(path2 +" "+title);
				ResourceResolver resolver = request.getResourceResolver();
				PageManager pageManager = resolver.adaptTo(PageManager.class);
				
				StringBuilder sb = new StringBuilder(path2);
				
				String path = sb.reverse().delete(0, 12).reverse().toString();
				
//				Resource resource = hit.getResource();
				
				response.getWriter().println("\nResource Path: "+path);
				Page page = pageManager.getPage(path2);
				if(page != null) {
					pageManager.delete(page, true);
				}
				resolver.commit();
				response.getWriter().print("Delete #"+i); i++;
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WCMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

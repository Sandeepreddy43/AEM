package com.law.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Component;

@Component(service = Servlet.class, property = { "sling.servlet.paths=/bin/node",
"sling.servlet.methods={GET,POST}" }, name = "Node Creation Demo Servlet")
public class NodeCreation extends SlingSafeMethodsServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		/*Node Creation can be done by using Session or ResourceResolver*/
		String path = "/apps/lawfirm-project/components/content/featured";
		Resource resource = request.getResourceResolver().getResource(path);
		Node node = resource.adaptTo(Node.class);
		
		PrintWriter writer = response.getWriter();
		
		writer.println("Servlet Called - "+getServletInfo());
		try {
			
			// Adding Child Node
			Node child = node.addNode("clientlib", "cq:ClientLibraryFolder");
			String[] categories = {"law-firm-project.components.content"};
			child.setProperty("prop1", "value1");
			child.setProperty("allowProxy", true);
			child.setProperty("categories", categories);
			
			
			writer.println("\n Child Node: \n"+child.toString());			
			
			Node js = child.addNode("js", "nt:folder");
			writer.println("\n JS Node: \n"+js.toString());
			
			Node css = child.addNode("css", "nt:folder");
			writer.println("\n CSS Node: \n"+css.toString());
			
			child.getSession().save();
			
			Node createnode = js.addNode("js.txt", "nt:file");
			System.out.println("JS File Created ====> "+createnode.toString());
			createnode.addMixin("mix:referenceable");
			Node createnode1 = node.addNode("jcr:content", "nt:resource");
			System.out.println("jcr:content !!!!! ---> "+createnode1.toString());
			Calendar lastmodified = Calendar.getInstance();
			lastmodified.setTimeInMillis(lastmodified.getTimeInMillis());
			createnode1.setProperty("jcr:lastModified", lastmodified);
			
			createnode1.getSession().save();
			
			// Adding Properties to Already Exixting Node
			/*
			 * Resource related = resource.getChild(path.concat("/jcr:content/related"));
			 * ModifiableValueMap map = related.adaptTo(ModifiableValueMap.class);
			 * map.put("prop", "my value"); resource.getResourceResolver().commit();
			 * 
			 * writer.println("\n Related Node: \n"+related.adaptTo(Node.class).toString());
			 */			
			
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package com.law.schedulers;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true)
@Designate(ocd = FolderInterface.class)
public class FolderSchedulerImpl implements Runnable {
	
	Logger loger = LoggerFactory.getLogger(this.getClass());

	private String displayMessage;	
	int i = 1;

	@Activate
	private void shceduler(FolderInterface test) {
		displayMessage = test.displayMessage();
	}

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	@Override
	public void run() {
		System.out.println("\n"+i + " : " + displayMessage);
		loger.info("Logger Runs: ---> "+i);
		if (i % 100 == 0) {
			System.out.println("\n------------Scheduler Runs " + i + " times ..!!------------\n");
		}
		i++;

		/*
		 * We are mapping this below SUBSERVICE to Apache Sling Service User Mapper
		 * Service Amendment in ConfigMgr(Felix Console)..!! To map this, we had
		 * already created a user in user admin console(localhost:4502/useradmin) named
		 * test-user-admin.. We are mapping the above user with the symbolic name of our
		 * project(We can find in our bundle(Felix console))
		 */

		Map<String, Object> map = new HashMap<String, Object>();
		map.put(ResourceResolverFactory.SUBSERVICE, "sandeep");
		try {
			ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(map);
			if (null != resolver) {
				String path = "/apps/lawfirm-project/components/content/adBox/clientlib";
				
				Session session = resolver.adaptTo(Session.class);
				Node node = session.getNode(path);
				System.out.println("Node : "+node.toString());
				Node createnode = node.addNode("js.txt", "nt:file");
				System.out.println("JS File Created ====> "+createnode.toString());
				createnode.addMixin("mix:referenceable");
				Node createnode1 = node.addNode("jcr:content", "nt:resource");
				System.out.println("jcr:content !!!!! ---> "+createnode1.toString());
				Calendar lastmodified = Calendar.getInstance();
				lastmodified.setTimeInMillis(lastmodified.getTimeInMillis());
				createnode1.setProperty("jcr:lastModified", lastmodified);
				
				resolver.commit();
				session.save();
			}
		} catch (LoginException | RepositoryException | PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
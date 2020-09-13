package com.vegfood.schedular;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;

import com.vegfood.services.impl.TestData;

@Component(immediate = true)
@Designate(ocd = TestData.class)
public class Schedular implements Runnable{

	private String message;
	private String path; int i = 1;

	@Reference
	private ResourceResolverFactory resolverFactory;
	@Activate
	private void ativate(TestData data) {
		// TODO Auto-generated method stub
		message = data.message();
		path = data.path();

	}
	
	@Override
	public void run() {
		System.out.println("\n"+i+" : Inside Run Method\n"+message); i++;
		Map<String, Object> map = new HashMap<>();
		map.put(ResourceResolverFactory.SUBSERVICE, "regnant");
		try {
//			System.out.println(" try block - scheduler");
//		System.out.println(path);
			ResourceResolver serviceResourceResolver = resolverFactory.getServiceResourceResolver(map);
			if(null != serviceResourceResolver && null != path) {
//				System.out.println(" creating Resource");
				Resource resource = serviceResourceResolver.getResource(path);
				if(null != resource){			
					serviceResourceResolver.delete(resource);
//					System.out.println("End of the Scheduler");
					serviceResourceResolver.commit();
				}
			}
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PersistenceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

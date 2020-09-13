
package com.law.schedulers;

import java.util.List;

import javax.jcr.RepositoryException;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.result.Hit;
import com.law.queryBuilder.QueryBuilderInterface;

//@Component(immediate = true)
//@Designate(ocd = SchedulerInterface.class)
public class QueryScheduler implements Runnable {

	private String templatePath;


	@Activate
	private void perform(SchedulerInterface in) {
		templatePath = in.templatePath();
	}
	
	@Reference
	QueryBuilderInterface q;
	
	@Override
	public void run() {
		System.out.println("Query Scheduler Called");
		List<Hit> hits = q.getHitsService();
		for (Hit hit : hits) {
			try {
				System.out.println(hit.getPath().toString());
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(templatePath);
	}

}

package com.law.queryBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

@Component(service = QueryBuilderInterface.class, name = "Query Service")
public class QueryBuilderDemo implements QueryBuilderInterface {

	@Reference
	ResourceResolverFactory factory;
	
	@Reference
	ResourceResolver resolver;

	@Reference
	Session sess;
	
	@Reference
	com.day.cq.search.QueryBuilder builder;
	
	@Override
	public List<Hit> getHitsService() {
		
		Map<String, Object> queryMap = new HashMap<>();
		queryMap.put("path","/content");
		queryMap.put("property","jcr:title");
		queryMap.put("property.value","Page123456");
		queryMap.put("p.limit", "-1");
		
//		ResourceResolver resolver = null;
		List<Hit> hits = null;
		//			resolver = factory.getServiceResourceResolver(queryMap);
		PredicateGroup prGroup = PredicateGroup.create(queryMap);
		Session session = resolver.adaptTo(Session.class);
		
					Query createQuery = builder.createQuery(prGroup, session);
					SearchResult result = createQuery.getResult();
					createQuery.setStart(0);
					createQuery.setHitsPerPage(4);
					hits = result.getHits();	
		return hits;
	}
	
}

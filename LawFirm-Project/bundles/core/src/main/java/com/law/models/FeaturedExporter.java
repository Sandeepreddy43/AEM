package com.law.models;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.export.json.ComponentExporter;
import com.adobe.cq.export.json.ExporterConstants;

import lombok.Getter;

@Model(adaptables = Resource.class, resourceType = FeaturedExporter.RESOURCE_TYPE , adapters = ComponentExporter.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Exporter(name = ExporterConstants.SLING_MODEL_EXPORTER_NAME, extensions = ExporterConstants.SLING_MODEL_EXTENSION)
public class FeaturedExporter implements ComponentExporter {

	static final String RESOURCE_TYPE  = "lawfirm-project/components/content/feature-multi";
	
	@Inject @Getter
	List<ExporterBean>  navItems;
	
	@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
	interface ExporterBean{
		
		@Inject
		String getTitle();
		
		@Inject
		String getText1();
		
		@Inject
		String getText2();
		
		@Inject
		String getLink();
		
		@Inject
		String getImglink();
		
		@Inject
		Date getDate();
	}

	@Override
	public String getExportedType() {
		// TODO Auto-generated method stub
		return RESOURCE_TYPE;
	}
	
	
	/* List - JSON Array - String*/
//	JSONArray jsArray = new JSONArray(listData);
//	String json = jsArray.toString();
	  
	
}
package com.vegfood.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;

@Model(adaptables = Resource.class)
public class ResourceTest {

	@Inject
	@Optional
	String title;
	
	@PostConstruct
	private void myMethod() {
		System.out.println("ResourceTest class");
		System.out.println("Injected filed: "+title.toUpperCase());
//		Class<Resource> res = Resource.class;
//		Annotation[] annotations = res.getAnnotations();
//		for (Annotation annotation : annotations) {
//			System.out.println(annotation.toString());
//		}
//		Field[] declaredFields = res.getDeclaredFields();
//		for (Field field : declaredFields) {
//			System.out.println(field.toString());
//		}
		System.out.println("Injected filed: "+title.toLowerCase());
	}
}

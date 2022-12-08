package com.myproject.core.models;

import java.util.Iterator;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class)
public class PagePathModel2 {
	@SlingObject
	@Via("resource")
	ResourceResolver resourceResolver;

	private String path = "/content/myproject/us/en/PHP";

	private String name;

	public String getName() {
		return resourceResolver.getResource(path).getName();
	}

	public Iterator<Resource> getAllChild() {
		return resourceResolver.getResource(path).listChildren();
	}
}

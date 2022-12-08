package com.myproject.core.models;

import java.util.Iterator;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

@Model(adaptables = Resource.class)
public class NodeDataModel {
	@SlingObject
	ResourceResolver resourceResolver;
	
	private String name;
	
	private String path;
	
	public String getName() {
		return resourceResolver.getResource("/content/myproject/mynode").getName();
	}
	
	public String getPath() {
		return resourceResolver.getResource("/content/myproject/mynode").getPath();
	}
	
	public Iterator<Resource> getAllChildren() {
		return resourceResolver.getResource("/content/myproject/mynode").listChildren();
	}

}

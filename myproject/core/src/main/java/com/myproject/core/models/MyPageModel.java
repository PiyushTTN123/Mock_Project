package com.myproject.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import com.day.cq.wcm.api.Page;

@Model(adaptables = Resource.class)
public class MyPageModel {
	@SlingObject
	ResourceResolver resourceResolver;

	@Self
	SlingHttpServletRequest request;

	private List<String> children = new ArrayList<String>();

	private String name;

	public String getName() {
		return resourceResolver.getResource(root).getName();
	}

	private String root = "/content/myproject/us/en/j1";

	@PostConstruct
	protected void initialize() {
		Page rootPage = resourceResolver.getResource(root).adaptTo(Page.class);
		Iterator<Page> listChildren = rootPage.listChildren(null, true);
		while (listChildren.hasNext()) {
			children.add(listChildren.next().getPath());
		}
	}

	public List<String> getChildren() {
		return children;
	}

	public String getRoot() {
		return root;
	}
}

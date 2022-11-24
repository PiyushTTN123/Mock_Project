package com.myproject.core.models;

import javax.inject.Inject;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.day.cq.commons.inherit.HierarchyNodeInheritanceValueMap;
import com.day.cq.commons.inherit.InheritanceValueMap;
import com.day.cq.wcm.api.Page;
//Model to access current page properties
@Model(adaptables= {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PageModel {
	@Inject
	private Page currentPage;//Object of current page.
	public int getNoOfBlogs() {	//To convert value string to integer
		InheritanceValueMap ivm = new HierarchyNodeInheritanceValueMap(currentPage.getContentResource());
		int blogs = ivm.getInherited("noOfBlogs", Integer.class);
		return blogs-1;
	}
}

//Getter to get noOfBlogs from page properties to print blogs.
//		ValueMap v=currentPage.getProperties();
//		return v.get("noOfBlogs",Integer.class);
package com.myproject.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
//Model for Footer Component
@Model(adaptables= Resource.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class Footer {
	//All variables
	@Inject
	private String linkToHome;
	@Inject
	private String linkToTop;
	@Inject
	private String linkToBlogs;
	
	//Setters and getters
	public String getLinkToHome() {
		return linkToHome;
	}
	public void setLinkToHome(String linkToHome) {
		this.linkToHome = linkToHome;
	}
	
	public String getLinkToTop() {
		return linkToTop;
	}
	public void setLinkToTop(String linkToTop) {
		this.linkToTop = linkToTop;
	}
	
	public String getLinkToBlogs() {
		return linkToBlogs;
	}
	public void setLinkToBlogs(String linkToBlogs) {
		this.linkToBlogs = linkToBlogs;
	}
}

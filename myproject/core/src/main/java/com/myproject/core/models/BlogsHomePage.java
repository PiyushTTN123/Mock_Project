package com.myproject.core.models;

import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogsHomePage {
	@Inject
	private String blogLink;
	public String getBlogLink() {
		return blogLink;
	}
	public void setBlogLink(String blogLink) {
		this.blogLink = blogLink;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getBlogTag() {
		return blogTag;
	}
	public void setBlogTag(String blogTag) {
		this.blogTag = blogTag;
	}
	public String getBlogTitle() {
		return blogTitle;
	}
	public void setBlogTitle(String blogTitle) {
		this.blogTitle = blogTitle;
	}
	public String getBlogDescription() {
		return blogDescription;
	}
	public void setBlogDescription(String blogDescription) {
		this.blogDescription = blogDescription;
	}
	@Inject
	private String image;
	@Inject
	private String blogTag;
	@Inject
	private String blogTitle; 
	@Inject
	private String blogDescription;
}

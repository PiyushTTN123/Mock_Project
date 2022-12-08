package com.myproject.core.models;

import javax.annotation.PostConstruct;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.InjectionStrategy;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

//Model for Header Component
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class Header {
	// All variables
	@ValueMapValue(injectionStrategy = InjectionStrategy.OPTIONAL)
	@Default(values = "BootCamp Blog")
	protected String logoText;
	@Inject
	private String HomeLink;
	@Inject
	private String PublishedBlogslink;
	@Inject
	private String image;

	// setters and getters
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getHomeLink() {
		return HomeLink;
	}

	public void setHomeLink(String homeLink) {
		HomeLink = homeLink;
	}

	public String getPublishedBlogslink() {
		return PublishedBlogslink;
	}

	public void setPublishedBlogslink(String publishedBlogslink) {
		PublishedBlogslink = publishedBlogslink;
	}

	public String getLogoText() {
		return logoText;
	}

	public void setLogoText(String logoText) {
		this.logoText = logoText;
	}

}

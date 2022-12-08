package com.myproject.core.models;

import java.util.List;
import javax.inject.Inject;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class BlogsListModel {

	@Inject
	private List<BlogsHomePage> blogList;

	public List<BlogsHomePage> getBlogList() {
		return blogList;
	}
}

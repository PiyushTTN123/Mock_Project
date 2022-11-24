package com.myproject.core.models;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.myproject.core.services.Blogs;

@Model(adaptables=Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class PublishedBlogsImpl {
	@Inject
	@Named(value="./blogsList")
	private List<PublishedBlogsModel> blogsList;
    public List<PublishedBlogsModel> getBlogsList() {
		return blogsList;
	}
	@OSGiService
    Blogs blogs;
    int BlogsNum;
	public int getBlogsNum() {
		return blogs.noOfBlogs()-1;
	}
}

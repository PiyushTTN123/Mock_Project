package com.myproject.core.services;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

//Implementation of service
@Component(service = Blogs.class, immediate = true)
@Designate(ocd = BlogsConfiguration.class)
public class BlogsImpl implements Blogs {
	int blogsNo;// variable to store number entered by author.

	public void activate(BlogsConfiguration config) {
		blogsNo = config.numbers_Of_Blogs();
	}

	@Override
	public int noOfBlogs() {
		return blogsNo;
	}
}

package com.myproject.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Model(adaptables = { Resource.class, SlingHttpServletRequest.class })
public class PagePathModel {

	@SlingObject
	@Via("resource")
	ResourceResolver resourceResolver;
	private String rootPath;

	@Inject
	private Page currentPage;

	public List<Page> getAllChild() {
		rootPath = currentPage.getAbsoluteParent(3).getPath();
		PageManager pageManager = resourceResolver.adaptTo(PageManager.class);
		List<Page> pageList = new ArrayList<Page>();
		Page rootPage = pageManager.getPage(rootPath);
		Iterator<Page> rootPageIterator = rootPage.listChildren();
		while (rootPageIterator.hasNext()) {
			Page childPage = rootPageIterator.next();
			pageList.add(childPage);
		}
		return pageList;
	}

	private String name;

	public String getName() {
		return resourceResolver.getResource(rootPath).getName();
	}

	private String path;

	public String getPath() {
		return resourceResolver.getResource(rootPath).getPath();
	}

//    @ResourcePath(path="/content/myproject/us/en/PHP")
//    @Via("resource")
//    Resource path;
//    
//    private String name;
//	public String getName() {
//        return path.getName();
//    }
//
//    public String getPath() {
//        return path.getPath();
	// }

}

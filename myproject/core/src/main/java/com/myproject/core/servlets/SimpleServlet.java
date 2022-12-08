/*
 *  Copyright 2015 Adobe Systems Incorporated
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.myproject.core.servlets;

import com.day.cq.commons.jcr.JcrConstants;
import com.myproject.core.services.BlogsImpl;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.propertytypes.ServiceDescription;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import java.io.IOException;

/**
 * Servlet that writes some sample content into the response. It is mounted for
 * all resources of a specific Sling resource type. The
 * {@link SlingSafeMethodsServlet} shall be used for HTTP methods that are
 * idempotent. For write operations use the {@link SlingAllMethodsServlet}.
 */
//@Component(service = { Servlet.class })
//@SlingServletResourceTypes(
//        resourceTypes="myapp/piyush/mypage",
//        methods=HttpConstants.METHOD_GET,
//        selectors="sample",
//        extensions="html")
//@ServiceDescription("Simple Demo Servlet")


//@Component(service= Servlet.class, property= {
//		"sling.servlet.recourceTypes=" + "/myapp/piyush/mypage",
//		"sling.servlet.methods=" + "HttpConstants.METHOD_POST",
//		"sling.servlet.selectors="+"sample",
//		"sling.servlet.extensions="+"html"})

//@Component(service = { Servlet.class })
//@SlingServletResourceTypes(
//    resourceTypes="/myapp/piyush/mypage", 
//    methods= "GET",
//    extensions="html",
//    selectors="sample")



@Component(service=Servlet.class,
property={
        "sling.servlet.methods=" + HttpConstants.METHOD_GET,
        "sling.servlet.resourceTypes="+ "/myapp/piyush/mypage",
        "sling.servlet.selectors="+ "data",
        "sling.servlet.extensions="+ "html"
})
public class SimpleServlet extends SlingSafeMethodsServlet {
	
    private static final long serialVersionUID = 1L;
    @Reference BlogsImpl blogs;
    
    @Reference
    ResourceResolver resourceResolver;

    @Override
    protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
        //ResourceResolver resourceResolver= ResolverUtil.newResolver(resourceResolverFactory);
		String title= resourceResolver.getResource("/content/myproject/us/Hn").getValueMap().get("jcr:title",String.class);
		response.setContentType("text/plain");
		response.getWriter().write(title);

        response.getWriter().write("<h1>this is my servlet</h1>");
    response.setContentType("text/plain");
//        Resource resource = request.getResource();
//        String title1 = resource.getValueMap().get("jcr:title",String.class);
//        title1 += " appended from servlet";
//        response.getWriter().write(title1);
//        response.setContentType("text/plain");
    }
}

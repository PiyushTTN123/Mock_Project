package com.myproject.core.servlets;

import java.io.IOException;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.PersistenceException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(service = Servlet.class, property = { 
		"sling.servlet.methods=" + HttpConstants.METHOD_POST,
		"sling.servlet.paths=" + "/bin/submitdata2" })
public class MyServlet extends SlingAllMethodsServlet {
	private static final long serialVersionUID = -159625176093879129L;
	private static final Logger log = LoggerFactory.getLogger(MyServlet.class);

	private String nodePath = "/content/myproject/mynode";

	@Override
	protected void doPost(SlingHttpServletRequest req, SlingHttpServletResponse resp) {
		try {
			ResourceResolver resourceResolver = req.getResourceResolver();

			Resource resource = resourceResolver.getResource(nodePath);

			Node node = resource.adaptTo(Node.class);

			Node newNode = node.addNode(getNodeName(req), "nt:unstructured");
			
			newNode.setProperty("lastName", getRequestParameter(req, "lastName"));
			newNode.setProperty("firstName", getRequestParameter(req, "firstName"));

			resourceResolver.commit();

		} catch (RepositoryException e) {

			log.error(e.getMessage(), e);

			e.printStackTrace();

		} catch (PersistenceException e) {

			log.error(e.getMessage(), e);

			e.printStackTrace();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static String getRequestParameter(SlingHttpServletRequest request, String s) {
		String parameterValue = request.getParameter(s);
		return parameterValue;
	}

	public static String getNodeName(SlingHttpServletRequest request) {
		String Name = request.getParameter("firstName");
		String UserNodeName = Name;
		return UserNodeName;
	}
}

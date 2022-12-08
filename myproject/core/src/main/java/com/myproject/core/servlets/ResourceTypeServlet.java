package com.myproject.core.servlets;

import java.io.IOException;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.apache.sling.servlets.annotations.SlingServletResourceTypes;
import org.osgi.service.component.annotations.Component;

@Component(service = { Servlet.class })
@SlingServletResourceTypes(resourceTypes = "myproject/mynode", methods = HttpConstants.METHOD_GET, selectors = "hello", extensions = "html")
public class ResourceTypeServlet extends SlingSafeMethodsServlet {
	private static final long serialVersionUID = 1L;
	static int i = 0;

	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		ResourceResolver resourceResolver = request.getResourceResolver();
		;
		Resource resource = resourceResolver.getResource("/content/myproject/PiyushMyNode");
		Node node = resource.adaptTo(Node.class);
		try {
			node.addNode("Node" + i++, "nt:unstructured");
			int depth = node.getDepth();
			response.getWriter().write("Node created successfully" + depth);
			resourceResolver.commit();
		} catch (RepositoryException e) {
			throw new RuntimeException(e);
		}
	}
}

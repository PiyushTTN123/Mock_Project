package com.myproject.core.models;

import javax.annotation.PostConstruct;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import org.apache.jackrabbit.api.security.user.User;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Exporter;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import com.adobe.cq.export.json.ExporterConstants;

@Model(adaptables = Resource.class)
public class GetUserNameModel {
	@ValueMapValue
    private String userName;
    @SlingObject
    ResourceResolver resourceResolver;
    public String getUserName() {
        return userName;
    }
    @PostConstruct
    public void init() throws RepositoryException {
        final Session session = resourceResolver.adaptTo(Session.class);
        final String userId = session.getUserID();
        final UserManager userManager = resourceResolver.adaptTo(UserManager.class);
        final User user = (User) userManager.getAuthorizable(userId);
        userName=user.getID().toString();
    }
}

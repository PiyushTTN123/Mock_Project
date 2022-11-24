package com.myproject.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

//Configuration class
@ObjectClassDefinition(name= "Blogs Configuration")
public @interface BlogsConfiguration {

    @AttributeDefinition(
    		name = "No Of Blogs",
    		description = "Enter no of Blogs",
            type = AttributeType.INTEGER,
            defaultValue = "2")
    int numbers_Of_Blogs();
}

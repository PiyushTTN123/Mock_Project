package com.myproject.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

//Model for carousel multifield list
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CarouselModel {
	@Inject
	@Named("./fieldList")
	private List<MultifieldModel> fieldList;// List of object of MultifieldModel

	public List<MultifieldModel> getFieldList() {// Getter for list
		return fieldList;
	}
}
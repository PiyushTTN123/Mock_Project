package com.myproject.core.services;

import org.apache.sling.settings.SlingSettingsService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component
public class CheckRunMode {
	@Reference
	SlingSettingsService slingSettingService;
	public String checkRunMode() {
		return slingSettingService.getRunModes().toString();
	}
}

package com.helios.main.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="config")
public class ApplicationConfig {
	private String imageHost;
	
	public String getImageHost() {
		return imageHost;
	}
	
	public void setImageHost(String imageHost) {
		this.imageHost = imageHost;
	}
}

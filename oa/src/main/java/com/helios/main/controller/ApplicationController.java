package com.helios.main.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.helios.main.config.ApplicationConfig;

public abstract class ApplicationController {
	
	@Autowired
	protected ApplicationConfig config;
}

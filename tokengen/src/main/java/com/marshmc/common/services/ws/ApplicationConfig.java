package com.marshmc.common.services.ws;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> resources = new HashSet<>();
		addRestResrouceClasses(resources);
		return resources;
	}

	private void addRestResrouceClasses(Set<Class<?>> resources) {
		resources.add(TokenGeneratorService.class);
		
	}
}

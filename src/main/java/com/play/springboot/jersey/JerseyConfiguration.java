package com.play.springboot.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfiguration extends ResourceConfig {
	public JerseyConfiguration() {
		register(UserResource.class);
	}
}
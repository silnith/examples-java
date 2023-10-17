package org.silnith.example.spring.boot.jersey;

import org.glassfish.jersey.server.ResourceConfig;
import org.silnith.example.spring.boot.resource.TessellateResource;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		super();
		this.packages("org.silnith.example", TessellateResource.class.getPackageName());
	}

}

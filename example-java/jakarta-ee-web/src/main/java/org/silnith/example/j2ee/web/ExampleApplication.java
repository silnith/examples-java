package org.silnith.example.j2ee.web;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import org.silnith.example.j2ee.web.resource.RootResource;
import org.silnith.example.j2ee.web.resource.TessellateResource;

@ApplicationPath("example")
public class ExampleApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		return new HashSet<>(Arrays.asList(TessellateResource.class, RootResource.class));
	}

}

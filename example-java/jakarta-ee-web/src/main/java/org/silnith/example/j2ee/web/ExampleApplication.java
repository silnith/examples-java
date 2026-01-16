package org.silnith.example.j2ee.web;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

import org.silnith.example.j2ee.web.model.Tessellator;
import org.silnith.example.j2ee.web.resource.RootResource;
import org.silnith.example.j2ee.web.resource.TessellateResource;

@ApplicationPath("example")
public class ExampleApplication extends Application {

//	@Override
//	public Set<Class<?>> getClasses() {
//		return new HashSet<>(Arrays.asList(TessellateResource.class, RootResource.class, Tessellator.class));
//	}
    
//    @Override
//    public Map<String, Object> getProperties() {
//        final Map<String, Object> configStuff = new HashMap<>();
//        configStuff.put("jsonb.strict-ijson", true);
//        return configStuff;
//    }
    
}

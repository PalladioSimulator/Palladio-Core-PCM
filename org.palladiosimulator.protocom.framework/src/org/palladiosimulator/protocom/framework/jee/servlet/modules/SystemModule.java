package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import java.lang.reflect.Constructor;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;

public class SystemModule extends Module {
	private String className;
	
	public SystemModule(String id, String name, String className) {
		super(id, name, true);
		
		this.className = className;
	}

	@Override
	public Response startModule(String location) {
		
		try {
			Class<?> systemClass = Class.forName(className);
			
			Class<?>[] types = {String.class, String.class};
			Object[] arguments = {location, getId()};
			
			Constructor<?> constructor = systemClass.getConstructor(types);
			constructor.newInstance(arguments);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new Response(Response.FAILED);
	}
}

package org.palladiosimulator.protocom.framework.java.ee.protocol;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * A RemoteStub object is used to delegate local method calls to a remote instance.
 * @author Christian Klaussner
 */
public class LocalStub implements InvocationHandler {
	private String location;
	private String path;
	
	/**
	 * Constructs a new RemoteStub object.
	 * @param location the location part of the remote URL
	 * @param path the path part of the remote URL
	 */
	public LocalStub(String location, String path) {
		this.location = location;
		this.path = path;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {		
		RemoteCall call = new RemoteCall();
		
		call.setName(method.getName());
		call.setFormalTypes(method.getParameterTypes());
		
		if (args != null) {
			call.setArguments(args);
			
			Class<?>[] actualTypes = new Class<?>[args.length];
			
			for (int i = 0; i < actualTypes.length; i++) {
				actualTypes[i] = args[i].getClass();
			}
			
			call.setActualTypes(actualTypes);
		} else {
			call.setArguments(new Object[0]);
			call.setActualTypes(new Class<?>[0]);
		}
		
		Request.post(location, path, call.toJson());
		
		return null;
	}
}

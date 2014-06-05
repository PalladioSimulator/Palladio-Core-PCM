package org.palladiosimulator.protocom.framework.jee.servlet.registry;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Request;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * A RemoteStub object is used to delegate local method calls to a remote instance.
 * @author Christian Klaussner
 */
public class RemoteStub implements InvocationHandler {
	private String location;
	private String path;
	
	/**
	 * Constructs a new RemoteStub object.
	 * @param location the location part of the remote URL
	 * @param path the path part of the remote URL
	 */
	public RemoteStub(String location, String path) {
		this.location = location;
		this.path = path;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {		
		RemoteCall call = new RemoteCall();
		
		call.setName(method.getName());
		call.setParameters(method.getParameterTypes());
		call.setArgs(args);
		
		Request.post(location, path, call.toJson());
		
		return null;
	}
}

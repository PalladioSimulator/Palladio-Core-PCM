package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Parameter;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Request;
import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.http.StringResponse;

import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * A ComponentModule object represents a permanent component module.
 * @author Christian Klaussner
 */
public class ComponentModule extends Module {
	private String path;
	
	/**
	 * Constructs a new ComponentModule object.
	 * @param id the ID of the module
	 * @param name the name of the module
	 * @param path the path part of the module's URL
	 */
	public ComponentModule(String id, String name, String path) {
		super(id, name, true);
		this.path = path;
	}
	
	@Override
	public void startModule(String location) {
		ArrayList<Parameter> params = new ArrayList<Parameter>(2);
		
		params.add(new Parameter("action", "start"));
		params.add(new Parameter("location", location));
		
		String responseString = Request.get(location, path, params);
		Response response = StringResponse.fromJson(responseString);
		
		if (response.getError() == Response.OK) {
			setStarted(true);
		}
		
		// return response;
	}
	
	@Override
	protected void writeJson(JsonGenerator json) throws IOException {
		json.writeStringField("path", path);
	}
}

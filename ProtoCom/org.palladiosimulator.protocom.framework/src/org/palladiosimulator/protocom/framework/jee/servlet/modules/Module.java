package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;

/**
 * The Module class is the common base class for modules.
 * A module represents an entity (e.g., component) that can be started by a user.
 * 
 * @author Christian Klaussner
 */
public abstract class Module {
	private String id;
	private String name;
	private boolean permanent, started;
	
	/**
	 * Constructs a new Module object.
	 * @param id the ID of the module
	 * @param name the name of the module
	 * @param permanent true if the module is permanent, otherwise false
	 */
	public Module(String id, String name, boolean permanent) {
		this.id = id;
		this.name = name;
		this.permanent = permanent;
	}
	
	/**
	 * Gets the ID of the module.
	 * @return the ID of the module
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Gets the name of the module.
	 * @return the name of the module
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Checks whether the module is permanent. 
	 * @return true if the module is permanent, otherwise false
	 */
	public boolean isPermanent() {
		return permanent;
	}
	
	/**
	 * Checks whether the module is started.
	 * @return true if the module is started, otherwise false
	 */
	public boolean isStarted() {
		return started;
	}
	
	/**
	 * Sets the started state of the module.
	 * @param started true if the module is started, otherwise false
	 */
	public void setStarted(boolean started) {
		this.started = started;
	}
	
	/**
	 * Starts the module.
	 * @param location the location of the module
	 * @throws ModuleStartException when the module could not be started
	 */
	public abstract void startModule(String location) throws ModuleStartException;
	
	/**
	 * Converts the module-specific data to JSON.
	 * @param json the JSON generator to write to
	 * @throws IOException when the JSON data could not be written to the generator
	 */
	protected void writeJson(JsonGenerator json) throws IOException {
	}
	
	/**
	 * Converts the module to JSON.
	 * @param json the JSON generator to write the object string to
	 */
	public void writeJsonObject(JsonGenerator json) {
		try {
			json.writeStartObject();
			
			json.writeStringField("id", id);
			json.writeStringField("name", name);
			json.writeBooleanField("permanent", permanent);
			json.writeBooleanField("started", started);
			
			writeJson(json);
			
			json.writeEndObject();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

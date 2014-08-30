package org.palladiosimulator.protocom.framework.java.ee.modules;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.LinkedList;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * A ModuleList object stores an arbitrary number of modules.
 * @author Christian Klaussner
 */
public class ModuleList {
	private static JsonFactory jsonFactory = new JsonFactory();
	
	private LinkedList<Module> modules;
	private HashMap<String, Module> moduleMap;
	
	/**
	 * Constructs a new ModuleList object.
	 */
	public ModuleList() {
		modules = new LinkedList<Module>();
		moduleMap = new HashMap<String, Module>();
	}
	
	/**
	 * Adds the specified module to the list.
	 * @param module the module to add
	 */
	public void add(Module module) {
		modules.add(module);
		moduleMap.put(module.getId(), module);
	}
	
	/**
	 * Gets the module with the specified ID from the list.
	 * @param id the ID of the module to retrieve
	 * @return the module with the specified ID
	 */
	public Module get(String id) {
		return moduleMap.get(id);
	}
	
	/**
	 * Converts the module list to JSON.
	 * @return a JSON array string representing the module list
	 */
	public String toJson() {
		StringWriter out = new StringWriter();
		
		try {
			JsonGenerator json = jsonFactory.createGenerator(out);
			json.writeStartArray();
			
			for (Module module : modules) {
				module.writeJsonObject(json);
			}
			
			json.writeEndArray();
			json.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return out.toString();
	}
}

package org.palladiosimulator.protocom.framework.jee.servlet.modules;

import org.palladiosimulator.protocom.framework.jee.servlet.http.Response;
import org.palladiosimulator.protocom.framework.jee.servlet.usage.IUsageScenario;

/**
 * A UsageScenarioModule object represents an executable usage scenario.
 * @author Christian Klaussner
 */
public class UsageScenarioModule extends Module {
	IUsageScenario scenario;
	
	/**
	 * Constructs a new UsageScenarioModule object.
	 * @param id the ID of the module
	 * @param name the name of the module
	 * @param scenario the usage scenario of the module
	 */
	public UsageScenarioModule(String id, String name, IUsageScenario scenario) {
		super(id, name, false);
		this.scenario = scenario;
	}
	
	@Override
	public void startModule(String location) {
		Response response = new Response();
		
		try {
			scenario.start();
			response.setError(Response.OK);
		} catch (ModuleStartException e) {
			response.setError(Response.FAILED);
		}
		
		// return response;
	}
	
	/**
	 * Gets the usage scenario.
	 * @return the usage scenario
	 */
	public IUsageScenario getUsageScenario() {
		return scenario;
	}
}

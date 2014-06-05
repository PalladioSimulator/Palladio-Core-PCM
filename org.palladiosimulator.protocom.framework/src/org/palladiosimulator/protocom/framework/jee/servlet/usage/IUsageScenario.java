package org.palladiosimulator.protocom.framework.jee.servlet.usage;

import org.palladiosimulator.protocom.framework.jee.servlet.modules.ModuleStartException;

/**
 * Classes implementing the IUsageScenario interface represent usage scenarios.
 * @author Christian Klaussner
 */
public interface IUsageScenario {
	
	/**
	 * Starts the usage scenario. 
	 */
	void start() throws ModuleStartException;
}

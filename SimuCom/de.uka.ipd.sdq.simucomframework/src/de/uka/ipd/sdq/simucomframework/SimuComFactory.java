package de.uka.ipd.sdq.simucomframework;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimEngineFactory;

/**
 * Factory for creating simulation objects. The created objects are already attached
 * to a desmo-j experiment
 * @author Steffen Becker
 *
 */
public class SimuComFactory {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SimuComFactory.class);

	/**
	 * Create a new simulation model as needed by desmo-j
	 * @param name The name of the simulation model
	 * @param showInReport Should desmoj report on our experiment
	 * @param showInTrance Should desmoj trace our experiment
	 * @return The created simulation model
	 */
	public static SimuComModel getSimuComModel(SimuComConfig config, SimuComStatus simuComStatus, boolean isRemote) {
		ISimEngineFactory factory = null;

		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor("de.uka.ipd.sdq.simulation.abstractsimengine.engine")){

			try {
				if (configurationElement.getAttribute("id").equals(config.getEngine()))
				factory = (ISimEngineFactory)configurationElement.createExecutableExtension("class");
			} catch (CoreException e) {
				if(logger.isEnabledFor(Level.WARN))
					logger.warn("Could not get factory for registered simulation engine.", e);
				factory = null;
			}
		}
		if (factory == null)
			throw new RuntimeException("No Simulation Engine available. Please install at least one engine.");
		else {
			SimuComModel model = new SimuComModel(
					config, simuComStatus, factory, isRemote);

			return model;
		}
	}

}

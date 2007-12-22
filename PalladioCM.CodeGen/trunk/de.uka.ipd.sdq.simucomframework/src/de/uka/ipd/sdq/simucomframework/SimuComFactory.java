package de.uka.ipd.sdq.simucomframework;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapterFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEngineFactory;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Factory for creating simulation objects. The created objects are already attached
 * to a desmo-j experiment
 * @author Steffen Becker
 *
 */
public class SimuComFactory {

	/**
	 * Create a new simulation model as needed by desmo-j
	 * @param name The name of the simulation model
	 * @param showInReport Should desmoj report on our experiment
	 * @param showInTrance Should desmoj trace our experiment
	 * @return The created simulation model 
	 */
	public static SimuComModel getSimuComModel(SimuComConfig config) {
		ISimEngineFactory factory = null;
		
		for(IConfigurationElement configurationElement : Platform.getExtensionRegistry().
				getConfigurationElementsFor("de.uka.ipd.sdq.simucomframework.engine")){
		            
			try {
				if (configurationElement.getAttribute("id").equals(config.getEngine()))
				factory = (ISimEngineFactory)configurationElement.createExecutableExtension("class");
			} catch (CoreException e) {
				e.printStackTrace();
				factory = null;
			}
		}
		if (factory == null)
			return null;
		else {
			SimuComModel model = new SimuComModel( 
					config, factory);
			
			return model;
		}
	}
	
}

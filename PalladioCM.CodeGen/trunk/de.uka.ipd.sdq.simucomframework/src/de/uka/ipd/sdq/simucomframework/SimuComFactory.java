package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Experiment;

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
	public static SimuComModel getSimuComModel(String name,
			boolean showInReport, boolean showInTrance) {
		
		SimuComModel model = new SimuComModel(null, 
				name, 
				showInReport,
				showInTrance);
		
		Experiment exp = new Experiment("SimuCom Experiment");
		// ATTENTION, since the name of the experiment is used in the names of
		// the
		// output files, you have to specify a string that's compatible with the
		// filename constraints of your computer's operating system.
		model.connectToExperiment(exp);
		
		return model;
	}
	
}

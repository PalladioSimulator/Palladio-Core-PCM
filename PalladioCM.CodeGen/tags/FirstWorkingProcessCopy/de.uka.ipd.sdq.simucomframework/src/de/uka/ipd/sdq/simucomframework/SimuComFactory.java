package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Experiment;

public class SimuComFactory {

	private static SimuComModel lastModel = null;
	
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
		lastModel = model;
		
		return model;
	}

	public static SimuComModel getLastSimuComModel() {
		return lastModel;
	}

}

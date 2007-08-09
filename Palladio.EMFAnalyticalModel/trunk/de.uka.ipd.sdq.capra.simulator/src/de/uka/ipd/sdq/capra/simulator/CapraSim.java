package de.uka.ipd.sdq.capra.simulator;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.simulator.builder.SimulationModelCreator;
import de.uka.ipd.sdq.capra.simulator.tools.CapraTools;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class CapraSim {

	private static final String path = "G:/jens/Diss/dev/runtime-EclipseApplication/CapraProject/";

	public static volatile boolean done = false;

	public static final Logger logger = Logger.getLogger("Capra");

	public static final boolean debug = false;

	public static void main(String[] args) {
		double simTime = 500;
		
		if (!debug){
			logger.setLevel(Level.ERROR);
			simTime = 100000;
		}
		
		CapraModel capraModel = (CapraModel) CapraTools.loadFromXMI(path
				+ "My.capra");
		long start = System.nanoTime();
		SimulationModel simModel = SimulationModelCreator
				.createFrom(capraModel);
		simModel.init();
		System.out.println("Loading took " + (System.nanoTime() - start)
				/ 1000000 + " ms");
		start = System.nanoTime();
		simModel.simulate(simTime);
		System.out.println("Simulation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");

		if (!debug) {
			start = System.nanoTime();
			ExperimentManager expManager = new ExperimentManager("Simulation DoubleQ" + simModel.getDescription());
			simModel.storeData(expManager);
			expManager.close();
			ExperimentManager.closeDBConnection();
			System.out.println("Saving took " + (System.nanoTime() - start)
					/ 1000000 + " ms");
		}
	}
}

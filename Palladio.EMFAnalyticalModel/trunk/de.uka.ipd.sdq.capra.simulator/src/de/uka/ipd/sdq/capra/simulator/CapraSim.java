package de.uka.ipd.sdq.capra.simulator;

import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.simulator.builder.SimulationModelCreator;
import de.uka.ipd.sdq.capra.simulator.tools.EMFTools;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class CapraSim {
	
	private static final String path = "G:/jens/Diss/dev/runtime-EclipseApplication/CapraProject/";
	
	public static volatile boolean done = false;
	

	public static void main(String[] args){
		CapraModel capraModel = (CapraModel)EMFTools.loadFromXMI(path + "My.capra");
		long start = System.nanoTime();
		SimulationModel simModel = SimulationModelCreator.createFrom(capraModel);
		simModel.init();
		System.out.println("Loading took " + (System.nanoTime() - start) / 1000000 + " ms");
		start = System.nanoTime();
		simModel.simulate(100000);
		System.out.println("Simulation took " + (System.nanoTime() - start) / 1000000 + " ms");
		
		start = System.nanoTime();
		ExperimentManager expManager = new ExperimentManager("Simulation");
		simModel.storeData(expManager);
		expManager.close();
		ExperimentManager.closeDBConnection();
		System.out.println("Saving took " + (System.nanoTime() - start) / 1000000 + " ms");
	}
}

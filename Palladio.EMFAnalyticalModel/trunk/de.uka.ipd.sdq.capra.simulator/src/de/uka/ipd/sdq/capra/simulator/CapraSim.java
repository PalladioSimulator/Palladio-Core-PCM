package de.uka.ipd.sdq.capra.simulator;

import scheduler.SystemConfiguration;
import de.uka.ipd.sdq.capra.CapraModel;
import de.uka.ipd.sdq.capra.simulator.builder.SimulationModelCreator;
import de.uka.ipd.sdq.capra.simulator.tools.CapraTools;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.sensorframework.util.ExperimentManager;

public class CapraSim {

	private static final String path = "D:/Diss/dev/runtime-EclipseApplication/SchedulerConfigurator/";

	public static volatile boolean done = false;


	public static final boolean debug = false;

	public static void main(String[] args) {
		double simTime = 1000;
		LoggingWrapper.activate();
		
		if (!debug){
			LoggingWrapper.deactivate();
			simTime = 10000;
		}
		
		CapraModel capraModel = (CapraModel) CapraTools.loadFromXMI(path + "Process.capra");
		SchedulerTools.loadFromXMI(path + "Library.scheduler");
		SystemConfiguration systemConfiguration = (SystemConfiguration) SchedulerTools.loadFromXMI(path + "SystemConfiguration.scheduler");
		
		long start = System.nanoTime();
		SimulationModel simModel = SimulationModelCreator.loadSimulation(capraModel, systemConfiguration);
		simModel.init();
		System.out.println("Initialisation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");
		start = System.nanoTime();
		simModel.simulate(simTime);
		System.out.println("Simulation took " + (System.nanoTime() - start)
				/ 1000000 + " ms");

		if (!debug) {
			start = System.nanoTime();
			IDAOFactory factory = new FileDAOFactory(2,"D:\\Diss\\dev\\runtime-EclipseApplication\\SchedulerConfigurator\\temp\\");
			ExperimentManager expManager = new ExperimentManager("Simulation " + simModel.getDescription(),factory);
			simModel.storeData(expManager);
			expManager.close();
			expManager.finalizeAndClose();
			System.out.println("Saving took " + (System.nanoTime() - start)
					/ 1000000 + " ms");
		}
	}
}

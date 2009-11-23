package de.uka.ipd.sdq.measurements.osscheduler.experimentcontroller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.measurements.MachineDescription;
import de.uka.ipd.sdq.measurements.experimentcontroller.ExperimentController;
import de.uka.ipd.sdq.measurements.osscheduler.systemadapter.OSSchedulerSystemAdapter;
import de.uka.ipd.sdq.measurements.tasks.TaskSet;

public class OSSchedulerExperimentController extends ExperimentController {
	
	private List<OSSchedulerSystemAdapter> osSchedulerSystemAdapters = new ArrayList<OSSchedulerSystemAdapter>();
	private final static Logger logger = Logger.getLogger(OSSchedulerExperimentController.class);

	@Override
	public void performExperiment(List<MachineDescription> machineDescriptions, TaskSet taskSet) {

		logger.info("Preparing experiment " + taskSet.getName() + " ...");
		if (!prepareExperiment(machineDescriptions, taskSet)) {
			return;
		}
		logger.info("Experiment prepared.");
		logger.info("Executing experiment " + taskSet.getName() + " ...");
		if (!executeExperiment()) {
			return;
		}
		logger.info("Experiment executed.");
		
	}
	
	private boolean prepareExperiment(List<MachineDescription> machineDescriptions, TaskSet taskSet) {
		if (!prepareConnections(machineDescriptions)) {
			return false;
		}
		
		// We use only the first machine (only one machine is necessary anyway for OS experiments)
		if (osSchedulerSystemAdapters.size()<0) {
			logger.error("No machines specified.");
			return false;
		}
				
		OSSchedulerSystemAdapter osSchedulerSystemAdapter = osSchedulerSystemAdapters.get(0);
		
		logger.info("Preparing experiment on machine " + osSchedulerSystemAdapter.getMachineIP() + ":" + osSchedulerSystemAdapter.getMachinePort() + " ...");
		if (!osSchedulerSystemAdapter.prepareExperiment(machineDescriptions, taskSet)) {
			logger.error("Preparing experiment on machine " + osSchedulerSystemAdapter.getMachineIP() + ":" + osSchedulerSystemAdapter.getMachinePort() + " failed.");
		}
		
		return true;
	}
	
	private boolean executeExperiment() {
		OSSchedulerSystemAdapter osSchedulerSystemAdapter = osSchedulerSystemAdapters.get(0);
		return osSchedulerSystemAdapter.executeExperiment();
	}
	
	private boolean prepareConnections(List<MachineDescription> machineDescriptions) {
		for (MachineDescription d : machineDescriptions) {
			logger.info("Checking connection to machine " + d.getName() + "...");
			OSSchedulerSystemAdapter adapter = getOSSchedulerSystemAdapter(d.getIp(), d.getPort());
			if (!adapter.checkConnection()) {
				logger.error("Connection test failed for machine " + d.getName() + "...");
				return false;
			}
			logger.info("Connection test for machine " + d.getName() + " succeeded.");
		}
		return true;
	}
	
	
	/**
	 * Get the OSSchedulerSystemAdapter from the list of adapters. If the adapter does not exist yet,
	 * it is created and stored in the list.
	 * @param ip
	 * @param port
	 * @return
	 */
	private OSSchedulerSystemAdapter getOSSchedulerSystemAdapter(String ip, int port) {
		for (OSSchedulerSystemAdapter osSchedulerSystemAdapter : osSchedulerSystemAdapters) {
			if (osSchedulerSystemAdapter.getMachineIP().equals(ip) && (osSchedulerSystemAdapter.getMachinePort() == port)) {
				return osSchedulerSystemAdapter;
			}
		}
		OSSchedulerSystemAdapter adapter = new OSSchedulerSystemAdapter(ip, port);
		osSchedulerSystemAdapters.add(adapter);
		return adapter;
	}

}

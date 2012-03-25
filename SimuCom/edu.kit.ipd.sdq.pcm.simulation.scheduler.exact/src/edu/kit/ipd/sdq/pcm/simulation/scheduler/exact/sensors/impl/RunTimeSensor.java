package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.sensors.impl;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;

public class RunTimeSensor implements IProcessStateSensor {

    private SchedulerModel model;
	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private double otherTime;
	private double runTime;
	private IActiveProcess process;

	public RunTimeSensor(SchedulerModel model, IActiveProcess process) {
	    this.model = model;
		this.lastUpdateTime = 0;
		this.process = process;
		this.last_state = process.getState();
		reset();
	}

	public void reset() {
		runTime = 0;
		otherTime = 0;
		this.lastUpdateTime = model.getSimulationControl().getCurrentSimulationTime();
	}
	
	public double getRunTime(){
		if (process.getState() == PROCESS_STATE.RUNNING){
			double currentTime = model.getSimulationControl().getCurrentSimulationTime();
			double passedTime = currentTime - lastUpdateTime;
			runTime += passedTime;
			lastUpdateTime = currentTime;
		}
		return runTime;
	}
	
	public double getNotRunTime(){
		if (process.getState() != PROCESS_STATE.RUNNING){
			double currentTime = model.getSimulationControl().getCurrentSimulationTime();
			double passedTime = currentTime - lastUpdateTime;
			otherTime += passedTime;
			lastUpdateTime = currentTime;
		}
		return otherTime;
	}

	public void update(PROCESS_STATE new_state) {
		double currentTime = model.getSimulationControl().getCurrentSimulationTime();
		double passedTime = currentTime - lastUpdateTime;

		// Process was running, but is finished now
		if (last_state == PROCESS_STATE.RUNNING
				&& new_state != PROCESS_STATE.RUNNING) {
			runTime += passedTime;
			lastUpdateTime = currentTime;
		}

		// Process was not running, but starts now
		if (last_state != PROCESS_STATE.RUNNING
				&& new_state == PROCESS_STATE.RUNNING) {
			otherTime += passedTime;
			lastUpdateTime = currentTime;
		}
		last_state = new_state;
	}
}

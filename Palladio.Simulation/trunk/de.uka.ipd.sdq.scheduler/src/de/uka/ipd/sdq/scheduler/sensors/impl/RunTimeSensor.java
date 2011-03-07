package de.uka.ipd.sdq.scheduler.sensors.impl;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;

public class RunTimeSensor implements IProcessStateSensor {

	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private Simulator simulator;
	private double otherTime;
	private double runTime;
	private IActiveProcess process;

	public RunTimeSensor(IActiveProcess process) {
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.lastUpdateTime = 0;
		this.process = process;
		this.last_state = process.getState();
		reset();
	}

	public void reset() {
		runTime = 0;
		otherTime = 0;
		this.lastUpdateTime = simulator.time();
	}
	
	public double getRunTime(){
		if (process.getState() == PROCESS_STATE.RUNNING){
			double currentTime = simulator.time();
			double passedTime = currentTime - lastUpdateTime;
			runTime += passedTime;
			lastUpdateTime = currentTime;
		}
		return runTime;
	}
	
	public double getNotRunTime(){
		if (process.getState() != PROCESS_STATE.RUNNING){
			double currentTime = simulator.time();
			double passedTime = currentTime - lastUpdateTime;
			otherTime += passedTime;
			lastUpdateTime = currentTime;
		}
		return otherTime;
	}

	public void update(PROCESS_STATE new_state) {
		double currentTime = simulator.time();
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

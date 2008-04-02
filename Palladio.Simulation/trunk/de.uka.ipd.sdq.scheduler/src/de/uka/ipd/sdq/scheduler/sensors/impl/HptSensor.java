package de.uka.ipd.sdq.scheduler.sensors.impl;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;

public class HptSensor implements IProcessStateSensor {

	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private Simulator simulator;
	private boolean isHpt = false;
	private double hpt = 0;
	private double threshold;
	private double hptStart;
	
	public HptSensor(IActiveProcess process, double threshold){
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.lastUpdateTime = 0;
		this.last_state = process.getState();
		this.threshold = threshold;
	}
	
	public void start(){
		isHpt = true;
		hpt = 0.0;
		hptStart = simulator.time();
		lastUpdateTime = hptStart;
	}
	
	public double getHpt() {
		return hpt;
	}

	public double getHptStart() {
		return hptStart;
	}

	public void stop() {
		double currentTime = simulator.time();
		double passedTime = currentTime - lastUpdateTime;
		
		if (last_state == PROCESS_STATE.RUNNING){
			if (isHpt ){
				hpt  += passedTime;
			}
		}
		lastUpdateTime = currentTime;
		isHpt = false;
	}

	public void update(PROCESS_STATE new_state) {
		if (isHpt){
			double currentTime = simulator.time();
			double passedTime = currentTime - lastUpdateTime;
			
			// Process was running, but is finished now
			if (last_state == PROCESS_STATE.RUNNING &&
				new_state != PROCESS_STATE.RUNNING) {
				if (isHpt ){
					hpt  += passedTime;
				}
				lastUpdateTime = currentTime;
			}

			// Process was not running, but starts now
			if (last_state != PROCESS_STATE.RUNNING &&
				new_state == PROCESS_STATE.RUNNING) {
				if (passedTime > threshold){
					isHpt = false;
				}
				lastUpdateTime = currentTime;
			}
			last_state = new_state;
		}
	}
}

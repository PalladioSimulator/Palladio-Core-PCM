package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.sensors.impl;

import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.processes.PROCESS_STATE;
import de.uka.ipd.sdq.scheduler.sensors.IProcessStateSensor;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.processes.IActiveProcess;

public class HptSensor implements IProcessStateSensor {

    private SchedulerModel model; 
	private PROCESS_STATE last_state;
	private double lastUpdateTime;
	private boolean isHpt = false;
	private double hpt = 0;
	private double threshold;
	private double hptStart;
	
	public HptSensor(SchedulerModel model, IActiveProcess process, double threshold){
	    this.model = model;
		this.lastUpdateTime = 0;
		this.last_state = process.getState();
		this.threshold = threshold;
	}
	
	public void start(){
		isHpt = true;
		hpt = 0.0;
		hptStart = model.getSimulationControl().getCurrentSimulationTime();
		lastUpdateTime = hptStart;
	}
	
	public double getHpt() {
		return hpt;
	}

	public double getHptStart() {
		return hptStart;
	}

	public void stop() {
		double currentTime = model.getSimulationControl().getCurrentSimulationTime();
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
			double currentTime = model.getSimulationControl().getCurrentSimulationTime();
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

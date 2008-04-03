package de.uka.ipd.sdq.capra.simulator.actions;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.simulator.expressions.IFinishingListener;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraExpression;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.processes.SimCapraProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;


public class SimTimeProbe implements SimAction {
	
	List<SimTimeSpanSensor> sensorsToStart = new ArrayList<SimTimeSpanSensor>();
	List<SimTimeSpanSensor> sensorsToStop = new ArrayList<SimTimeSpanSensor>();
	Simulator simulator;
	
	
	public SimTimeProbe(){
		this.simulator = SchedulingFactory.getUsedSimulator();
	}
	
	
	@Override
	public void execute(SimCapraProcess process) {
		double time = simulator.time();
		for (SimTimeSpanSensor sensor : sensorsToStart) {
			sensor.notifyStart(time,process);
			LoggingWrapper.log("Start Sensor "+sensor.getName()+" for Process " + process);
		}
		for (SimTimeSpanSensor sensor : sensorsToStop) {
			sensor.notifyStop(time,process);
			LoggingWrapper.log("Stop Sensor "+sensor.getName()+" for Process " + process);
		}
		process.activate();
	}
	
	public void addSensorToStart(SimTimeSpanSensor sensor){
		sensorsToStart.add(sensor);
	}
	
	public void addSensorToStop(SimTimeSpanSensor sensor){
		sensorsToStop.add(sensor);
	}	
	
	@Override
	public SimTimeProbe clone(){
		SimTimeProbe probe = new SimTimeProbe();
		probe.sensorsToStart = this.sensorsToStart;
		probe.sensorsToStop = this.sensorsToStop;
		return probe;
	}

	@Override
	public void reset() {
	}

	@Override
	public SimCapraExpression getNext(SimCapraProcess process) {
		return null;
	}

	@Override
	public boolean isAction() {
		return true;
	}

	@Override
	public void setVarUsages(String name, SimCapraExpression behaviour) {
	}

	@Override
	public boolean hasNext() {
		return false;
	}


	@Override
	public void addFinishingListener(IFinishingListener listener) {
	}

}

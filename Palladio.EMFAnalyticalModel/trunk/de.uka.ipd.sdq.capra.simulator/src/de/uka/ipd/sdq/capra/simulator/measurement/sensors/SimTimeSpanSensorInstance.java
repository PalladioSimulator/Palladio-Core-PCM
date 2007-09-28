package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import umontreal.iro.lecuyer.simevents.Sim;

/**
 * @author     jens.happe
 */
public class SimTimeSpanSensorInstance implements SimSensorInstance {
	
	private double startTime = -1;
	private SimTimeSpanSensor sensor;
	
	public SimTimeSpanSensorInstance(SimTimeSpanSensor sensor) {
		super();
		this.sensor = sensor;
	}

	public void notifyStart(double time){
		if (startTime < 0){
			startTime = time;
		} else {
			System.out.println("StartTime recorded multiple times for sensor " + sensor.getName() + ".");
		}
	}
	
	public void notifyStop(double time){
		if (startTime >= 0){
			sensor.addTimeSpan(time - startTime);
			startTime = -1;
		} else {
			System.out.println("StartTime not set for sensor " + sensor.getName() + ".");			
		}
	}

	@Override
	public void finishMeasurements() {
		if (startTime >= 0){
			sensor.addTimeSpan(Sim.time() - startTime);
		}
	}
}

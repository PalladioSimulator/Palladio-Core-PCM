package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimStateRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimProcessSensor;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.sensors.impl.RunTimeSensor;

public class SimProcessorShareSensor extends AbstractSensor implements SimProcessSensor {

	private String processName;
	private SimActiveResource resource;
	private IActiveProcess process;
	private RunTimeSensor process_sensor;
	private double start_time;

	public SimProcessorShareSensor(String sensorName, String processName,
			SimActiveResource resource) {
		super(sensorName);
		this.processName = processName;
		this.resource = resource;
		this.start_time = 0;
	}

	@Override
	public void finishMeasurements() {
	}

	@Override
	public void initialiseProcess() {
		this.process =  resource.findProcess(processName);
		this.process_sensor = new RunTimeSensor(process);
		this.process.addStateSensor(process_sensor);
	}

	@Override
	public void toNow() {
		double runtime = this.process_sensor.getRunTime();
		this.process_sensor.reset();
		for (SimRecorder recorder : recorderList) {
			((SimStateRecorder) recorder).addStateTime("Runtime",start_time,runtime);
		}
		start_time = simulator.time();
	}

	@Override
	public void start() {
		for (SimRecorder recorder : recorderList) {
			recorder.start();
		}		
	}
}

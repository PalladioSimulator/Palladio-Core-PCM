package de.uka.ipd.sdq.capra.simulator.measurement.sensors.impl;

import java.util.Hashtable;
import java.util.Map;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.sensors.impl.HptSensor;

/**
 * @author  jens.happe
 */
public class SimHptSensor extends AbstractSensor implements SimTimeSpanSensor {
	
	private Map<ISchedulableProcess, HptSensor> processStorage = new Hashtable<ISchedulableProcess, HptSensor>();
	private SimActiveResource resource;
	private double threshold;
	
	public SimHptSensor(String name, SimActiveResource resource, double threshold) {
		super(name);
		this.resource = resource;
		this.threshold = threshold;
	}
	
	@Override
	public void addTimeSpan(double timeSpan, double time){
		for (SimRecorder recorder : recorderList) {
			((SimTimeSpanRecorder)recorder).addTimeSpan(timeSpan, time);
		}
	}

	@Override
	public void finishMeasurements() {
		for (ISchedulableProcess p : processStorage.keySet()) {
			processStorage.get(p).stop();
		}
	}
	
	@Override
	public void notifyStart(double time, ISchedulableProcess p){
		HptSensor s = null;
		if ((s = processStorage.get(p)) == null){
			IActiveProcess ap = resource.lookUp(p);
			s = new HptSensor(ap,threshold);
			ap.addStateSensor(s);
			processStorage.put(p, s);
		}
		s.start();
	}
	
	@Override
	public void notifyStop(double time, ISchedulableProcess p){
		HptSensor s = processStorage.get(p);
		assert (s != null) : "No state sensor for: " + name +" Process: " + p + " Started Measurements: " + this.processStorage;
		s.stop();
		addTimeSpan(s.getHpt(), s.getHptStart());
	}

	@Override
	public void start() {
		
	}
}

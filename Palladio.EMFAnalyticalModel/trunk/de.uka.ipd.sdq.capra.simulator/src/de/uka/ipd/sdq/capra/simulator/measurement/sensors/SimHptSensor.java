package de.uka.ipd.sdq.capra.simulator.measurement.sensors;

import java.util.Hashtable;
import java.util.Map;

import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.sensors.impl.HptSensor;

/**
 * @author  jens.happe
 */
public class SimHptSensor extends SimTimeSpanSensor {
	
	private Map<ISchedulableProcess, HptSensor> processStorage = new Hashtable<ISchedulableProcess, HptSensor>();
	private SimActiveResource resource;
	
	public SimHptSensor(String name, SimActiveResource resource) {
		super(name);
		this.resource = resource;
	}
	
	@Override
	public void addTimeSpan(double timeSpan, double time){
		for (SimTimeSpanRecorder recorder : recorderList) {
			recorder.addTimeSpan(timeSpan, time);
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
			s = new HptSensor(ap);
			ap.addStateSensor(s);
			processStorage.put(p, s);
		}
		s.start();
	}
	
	@Override
	public void notifyStop(double time, ISchedulableProcess p){
		HptSensor s = processStorage.get(p);
		assert (s != null) : "No state sensor for: " + name +" Process: " + p + " Started Measurements: " + this.processStorage;	
		addTimeSpan(s.getHpt(), s.getHptStart());
	}
}

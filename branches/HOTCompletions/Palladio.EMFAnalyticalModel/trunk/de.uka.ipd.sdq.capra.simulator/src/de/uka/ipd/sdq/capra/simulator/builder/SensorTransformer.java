package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.FinalValueRecorder;
import de.uka.ipd.sdq.capra.measurement.FullStateRecorder;
import de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.HistogramRecorder;
import de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.IntervalStateRecorder;
import de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor;
import de.uka.ipd.sdq.capra.measurement.Recorder;
import de.uka.ipd.sdq.capra.measurement.ResourceUtilisationSensor;
import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.measurement.StateRecorder;
import de.uka.ipd.sdq.capra.measurement.StateSensor;
import de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.impl.SimIntervalRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimStateSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;

/**
 * @author     jens.happe
 */
public class SensorTransformer {
	SensorVisitor visitor;
	SensorFactory factory;
	ResourceManager resourceManager;
	
	
	public SensorTransformer(SensorFactory sensorFactory, ResourceManager resourceManager) {
		super();
		visitor = new SensorVisitor(this, resourceManager);
		factory = sensorFactory;
		this.resourceManager = resourceManager;
	}

	public SimRecorder transformRecorder(Recorder recorder) {
		return visitor.visitRecorder(recorder);
	}

	public SimSensor transformStateSensor(StateSensor stateSensor) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimSensor transformCountingSensor(CountingSensor countingSensor) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimRecorder transformSteadyStateRecorder(SteadyStateRecorder steadyStateRecorder) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimRecorder transformFullStateRecorder(FullStateRecorder object) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimRecorder transformFinalValueRecorder(FinalValueRecorder object) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimRecorder transformHistogramRecorder(HistogramRecorder object) {
		// TODO Auto-generated method stub
		return null;
	}

	public SimRecorder transformFullTimeSpanRecorder(FullTimeSpanRecorder fullTimeSpanRecorder) {
		String name = fullTimeSpanRecorder.getTimeSpanSensor().getName();
		return factory.createFullTimeSpanRecorder(name);
	}

	public SimSensor transformSensor(Sensor sensor) {
		return visitor.visitSensor(sensor);
	}

	private void addTimeSpanRecorders(AbstractTimeSpanSensor object,
			SimTimeSpanSensor sensor) {
		for (TimeSpanRecorder recorder : object.getTimeSpanRecorders()) {
			SimRecorder simRecorder = transformRecorder(recorder);
			sensor.addRecorder(simRecorder);
		}
	}

	public SimSensor transformGlobalTimeSpanSensor(GlobalTimeSpanSensor object) {
		String name = object.getName();
		SimTimeSpanSensor sensor = factory.createGlobalTimeSpanSensor(name);
		addTimeSpanRecorders(object, sensor);
		return sensor;
	}


	public SimSensor transformLocalTimeSpanSensor(LocalTimeSpanSensor object) {
		String name = object.getName();
		SimTimeSpanSensor sensor = factory.createLocalTimeSpanSensor(name);
		addTimeSpanRecorders(object, sensor);
		return sensor;
	}

	public SimSensor transformInterruptionTimeSpanSensor(
			InterruptionTimeSpanSensor object) {
		String name = object.getName();
		SimActiveResource resource =  (SimActiveResource)resourceManager.getActiveResource((ProcessingResource)object.getObservedResource());
		double threshold = object.getThreshold().getValue();
		
		SimTimeSpanSensor sensor = factory.createInterruptionTimeSpanSensor(name, resource, threshold);
		addTimeSpanRecorders(object, sensor);
		return sensor;
	}

	public SimRecorder transformIntervalStateRecorder(
			IntervalStateRecorder object) {
		double interval = object.getTimeInterval().getValue();
		String name = object.getStateSensor().getName();
		boolean percent = object.isPercent();
		return new SimIntervalRecorder(interval,name,percent);
	}

	public SimSensor transformResourceUtilisationSensor(
			ResourceUtilisationSensor object) {
		String name = object.getName();
		SimActiveResource resource =  (SimActiveResource)resourceManager.getActiveResource((ProcessingResource)object.getObservedResource());
		SimStateSensor sensor = factory.createResourceUtilisationSensor(name, resource);
		addStateRecorders(object, sensor);
		return sensor;
	}

	private void addStateRecorders(StateSensor object,
			SimStateSensor sensor) {
		for (StateRecorder recorder : object.getStateRecorder()) {
			SimRecorder simRecorder = transformRecorder(recorder);
			sensor.addRecorder(simRecorder);
			simRecorder.setSensor(sensor);
		}		
	}

	public SimSensor transformProcessorShareSensor(ProcessorShareSensor object) {
		String sensorName = object.getName();
		SimActiveResource resource =  (SimActiveResource)resourceManager.getActiveResource((ProcessingResource)object.getObservedResource());
		String processName = object.getObservedProcess().getName();
		SimStateSensor sensor = factory.createProcessorShareSensor(sensorName, processName, resource);
		addStateRecorders(object, sensor);
		return sensor;
	}

}

package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.measurement.AbstractTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.FinalValueRecorder;
import de.uka.ipd.sdq.capra.measurement.FullStateRecorder;
import de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.GlobalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.HistogramRecorder;
import de.uka.ipd.sdq.capra.measurement.InterruptionTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.LocalTimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.Recorder;
import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.measurement.StateSensor;
import de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
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

	public SimTimeSpanRecorder transformTimeSpanRecorder(
			TimeSpanRecorder recorder) {
		return (SimTimeSpanRecorder) transformRecorder(recorder);
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

	private void addRecorders(AbstractTimeSpanSensor object,
			SimTimeSpanSensor sensor) {
		for (TimeSpanRecorder recorder : object.getTimeSpanRecorders()) {
			SimTimeSpanRecorder simRecorder = transformTimeSpanRecorder(recorder);
			sensor.addTimeSpanRecorder(simRecorder);
		}
	}

	public SimSensor transformGlobalTimeSpanSensor(GlobalTimeSpanSensor object) {
		String name = object.getName();
		SimTimeSpanSensor sensor = factory.createGlobalTimeSpanSensor(name);
		addRecorders(object, sensor);
		return sensor;
	}


	public SimSensor transformLocalTimeSpanSensor(LocalTimeSpanSensor object) {
		String name = object.getName();
		SimTimeSpanSensor sensor = factory.createLocalTimeSpanSensor(name);
		addRecorders(object, sensor);
		return sensor;
	}

	public SimSensor transformInterruptionTimeSpanSensor(
			InterruptionTimeSpanSensor object) {
		String name = object.getName();
		SimActiveResource resource =  (SimActiveResource)resourceManager.getActiveResource((ProcessingResource)object.getObservedResource());
		double threshold = object.getThreshold().getValue();
		
		SimTimeSpanSensor sensor = factory.createInterruptionTimeSpanSensor(name, resource, threshold);
		addRecorders(object, sensor);
		return sensor;
	}

}

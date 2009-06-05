package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.measurement.CountingSensor;
import de.uka.ipd.sdq.capra.measurement.FinalValueRecorder;
import de.uka.ipd.sdq.capra.measurement.FullStateRecorder;
import de.uka.ipd.sdq.capra.measurement.FullTimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.HistogramRecorder;
import de.uka.ipd.sdq.capra.measurement.Recorder;
import de.uka.ipd.sdq.capra.measurement.Sensor;
import de.uka.ipd.sdq.capra.measurement.StateSensor;
import de.uka.ipd.sdq.capra.measurement.SteadyStateRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder;
import de.uka.ipd.sdq.capra.measurement.TimeSpanSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimTimeSpanRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimTimeSpanSensor;

public class SensorTransformer {
	SensorVisitor visitor;
	SensorFactory factory;
	
	
	public SensorTransformer(SensorFactory sensorFactory) {
		super();
		visitor = new SensorVisitor(this);
		factory = sensorFactory;
	}

	public SimSensor transformTimeSpanSensor(TimeSpanSensor timeSpanSensor) {
		String name = timeSpanSensor.getName();
		SimTimeSpanSensor sensor = factory.createTimeSpanSensor(name);
		
		for (TimeSpanRecorder recorder : timeSpanSensor.getTimeSpanRecorders()) {
			SimTimeSpanRecorder simRecorder = transformTimeSpanRecorder(recorder);
			sensor.addTimeSpanRecorder(simRecorder);
		}
		return sensor;
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

}

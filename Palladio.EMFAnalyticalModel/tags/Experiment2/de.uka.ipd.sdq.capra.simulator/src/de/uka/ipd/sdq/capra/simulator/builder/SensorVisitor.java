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
import de.uka.ipd.sdq.capra.measurement.TimeSpanSensor;
import de.uka.ipd.sdq.capra.measurement.util.MeasurementSwitch;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;



public class SensorVisitor {
	private SensorTransformer sensorTransformer;
	
	public SensorVisitor(SensorTransformer sensorTransformer) {
		this.sensorTransformer = sensorTransformer;
	}
	
	public SimSensor visitSensor(Sensor sensor) {
		SimSensor result = sSwitch.doSwitch(sensor); 
		if (result == null){
			System.out.println("Unknown sensor: "+sensor.eClass().getName());
		}
		return result;
	}
	
	public SimRecorder visitRecorder(Recorder recorder){
		SimRecorder result = rSwitch.doSwitch(recorder);
		if (result == null){
			System.out.println("Unknown recorder: "+recorder.eClass().getName());
		}
		return result;
	}
	
	private MeasurementSwitch<SimRecorder> rSwitch = new MeasurementSwitch<SimRecorder>(){
		@Override
		public SimRecorder caseFullTimeSpanRecorder(FullTimeSpanRecorder object) {
			return sensorTransformer.transformFullTimeSpanRecorder(object);
		}
		
		@Override
		public SimRecorder caseHistogramRecorder(HistogramRecorder object) {
			return sensorTransformer.transformHistogramRecorder(object);
		}
		
		@Override
		public SimRecorder caseFinalValueRecorder(FinalValueRecorder object) {
			return sensorTransformer.transformFinalValueRecorder(object);
		}
		
		@Override
		public SimRecorder caseFullStateRecorder(FullStateRecorder object) {
			return sensorTransformer.transformFullStateRecorder(object);
		}
		
		@Override
		public SimRecorder caseSteadyStateRecorder(SteadyStateRecorder object) {
			return sensorTransformer.transformSteadyStateRecorder(object);
		}
	};

	private MeasurementSwitch<SimSensor> sSwitch = new MeasurementSwitch<SimSensor>(){
		@Override
		public SimSensor caseTimeSpanSensor(TimeSpanSensor object) {
			return sensorTransformer.transformTimeSpanSensor(object);
		}
		
		@Override
		public SimSensor caseStateSensor(StateSensor object) {
			return sensorTransformer.transformStateSensor(object);
		}
		
		@Override
		public SimSensor caseCountingSensor(CountingSensor object) {
			return sensorTransformer.transformCountingSensor(object);
		}
	};
}

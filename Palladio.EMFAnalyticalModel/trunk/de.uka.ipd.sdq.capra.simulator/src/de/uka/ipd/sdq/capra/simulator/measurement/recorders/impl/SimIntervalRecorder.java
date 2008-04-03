package de.uka.ipd.sdq.capra.simulator.measurement.recorders.impl;

import java.util.Hashtable;
import java.util.Map;

import cern.colt.list.DoubleArrayList;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.capra.simulator.measurement.recorders.SimStateRecorder;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimSensor;
import de.uka.ipd.sdq.capra.simulator.measurement.sensors.SimStateSensor;
import de.uka.ipd.sdq.capra.simulator.tools.CapraExperimentManager;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public class SimIntervalRecorder implements SimStateRecorder {

	private double interval;
	private String name;
	private LogEvent logEvent;
	private Map<String, Double> stateTimeMap;
	private Map<String, DoubleArrayList> stateDurationSeriesMap;
	private Map<String, DoubleArrayList> stateStartSeriesMap;
	private double start_time;
	private Simulator simulator;
	private boolean percent;
	private SimStateSensor sensor = null;;

	public SimIntervalRecorder(double interval, String name, boolean percent) {
		this.interval = interval;
		this.name = name;
		this.logEvent = new LogEvent();
		this.stateTimeMap = new Hashtable<String, Double>();
		this.stateDurationSeriesMap = new Hashtable<String, DoubleArrayList>();
		this.stateStartSeriesMap = new Hashtable<String, DoubleArrayList>();
		this.percent = percent;
	}

	@Override
	public void storeData(CapraExperimentManager expManager) {
		for (String state : stateDurationSeriesMap.keySet()){
			DoubleArrayList durations = stateDurationSeriesMap.get(state);
			DoubleArrayList starts = stateStartSeriesMap.get(state);
			expManager.storeTimeSpans(name + " " + state, durations.elements(), starts.elements(), durations.size());
		}
	}
	
	@Override
	public void start(){
		this.simulator = SchedulingFactory.getUsedSimulator();
		this.start_time = simulator.time();
		this.stateDurationSeriesMap.clear();
		this.stateStartSeriesMap.clear();
		this.stateTimeMap.clear();
		this.logEvent.schedule(interval);
	}
	
	@Override
	public SimIntervalRecorder clone() {
		return new SimIntervalRecorder(interval, name, percent);
	}

	@Override
	public void addStateTime(String state, double start_time, double duration) {
		Double time;
		if ((time = stateTimeMap.get(state)) == null){
			time = 0.0;
		}
		time += duration;
		stateTimeMap.put(state, time);
	}
	
	protected void log() {
		sensor.toNow();
		for (String state : stateTimeMap.keySet()){
			DoubleArrayList durationList;
			if ((durationList = stateDurationSeriesMap.get(state)) == null){
				durationList = new DoubleArrayList();
				stateDurationSeriesMap.put(state, durationList);
			}
			DoubleArrayList startList;
			if ((startList = stateStartSeriesMap.get(state)) == null){
				startList = new DoubleArrayList();
				stateStartSeriesMap.put(state, startList);
			}
			if (percent){
				durationList.add(stateTimeMap.get(state) / interval * 100);
			} else {
				durationList.add(stateTimeMap.get(state));
			}
			startList.add(start_time);
		}
		start_time = simulator.time();
		stateTimeMap.clear();
		this.logEvent.schedule(interval);
	}

	
	private class LogEvent extends Event{
		
		public LogEvent() {
			super(SchedulingFactory.getUsedSimulator());
		}

		@Override
		public void actions() {
			log();
		}
	}


	@Override
	public void setSensor(SimSensor sensor) {
		this.sensor = (SimStateSensor) sensor;
	}

}

package de.uka.ipd.sdq.simucomframework.ssj;

import java.util.ArrayList;
import java.util.Observer;

import org.apache.log4j.Logger;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import umontreal.iro.lecuyer.simevents.eventlist.SplayTree;
import umontreal.iro.lecuyer.simprocs.ProcessSimulator;
import umontreal.iro.lecuyer.simprocs.ThreadProcessSimulator;

import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

public class SSJExperiment implements ISimulationControlDelegate {
	
	private ThreadProcessSimulator simulator;
	private ArrayList<Condition> stopConditions = new ArrayList<Condition>();
	private ArrayList<Observer> timeObservers = new ArrayList<Observer>();
	double lastNotificationTime = 0.0;
	private boolean isRunning;
	
	public SSJExperiment(final SimuComModel model) {
		model.setSimulationControl(this);
		simulator = new ThreadProcessSimulator();
		simulator.init(new SplayTree());
		SchedulingFactory.setUsedSimulator(simulator);
		ISchedulingFactory.eINSTANCE.resetFactory();
		
		createStartEvent(model).schedule(0);
	}

	public void addStopCondition(Condition maxMeasurementsStopCondition) {
		stopConditions.add(maxMeasurementsStopCondition);
	}

	public void checkStopConditions(){
		if (lastNotificationTime != this.getCurrentSimulationTime()) {
			lastNotificationTime = this.getCurrentSimulationTime();
			for(Observer o : timeObservers){
				o.update(null, lastNotificationTime);
			}
		}
		for(Condition c : stopConditions) {
			if (c.check()) {
				createStopEvent().schedule(0);
				return;
			}
		}
	}
	
	public void addTimeObserver(Observer observer) {
		timeObservers .add(observer);
	}

	public double getCurrentSimulationTime() {
		return simulator.time();
	}

	public void setMaxSimTime(long simTime) {
		createStopEvent().schedule(simTime);
	}

	protected static Logger logger = 
		Logger.getLogger(SSJExperiment.class.getName());
	
	public void start() {
		this.isRunning = true;
		
		double start = System.nanoTime();
		logger.warn("Starting simulation...");
		simulator.start();
		logger.warn("Simulation terminated. Took "+((System.nanoTime()-start)/Math.pow(10,9))+" real time seconds.");
		
		this.isRunning = false;
	}

	public void stop() {
		this.isRunning = false;
		
		logger.info("Simulation stop requested!");
		createStopEvent().schedule(0);
		logger.info("Scheduled Simulation Stop Event now");
	}

	public ProcessSimulator getSimulator(){
		return simulator;
	}

	public boolean isRunning() {
		return this.isRunning;
	}

	private Event createStopEvent() {
		return new Event(simulator) {

			@Override
			public void actions() {
				logger.debug("Executing Stop Event");
				simulator.stop();
				// Removed the following line because it deadlocked SSJ
				// simulator.killAll();
			}
			
		};
	}

	private Event createStartEvent(final SimuComModel model) {
		return new Event(simulator) {

			@Override
			public void actions() {
				logger.debug("Executing Initial Event");
				model.doInitialSchedules();
			}
			
		};
	}
}

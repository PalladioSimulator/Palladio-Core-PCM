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
import de.uka.ipd.sdq.simucomframework.usage.ClosedWorkloadUser;
import de.uka.ipd.sdq.simucomframework.usage.OpenWorkloadUser;

public class SSJExperiment implements ISimulationControlDelegate {
	
	private Simulator simulator;
	private ArrayList<Condition> stopConditions = new ArrayList<Condition>();
	private ArrayList<Observer> timeObservers = new ArrayList<Observer>();
	double lastNotificationTime = 0.0;
	private boolean isRunning;
	private SimuComModel model;
	
	public SSJExperiment(final SimuComModel model) {
		model.setSimulationControl(this);
		simulator = new Simulator();
		simulator.init(new SplayTree());
		SchedulingFactory.setUsedSimulator(simulator);
		ISchedulingFactory.eINSTANCE.resetFactory();
		
		this.model = model;
		createStartEvent(model).schedule(0);
	}

	public void addStopCondition(Condition condition) {
		stopConditions.add(condition);
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
		timeObservers.add(observer);
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

		doReliabilityResultLogging();
	
		this.isRunning = false;
	}

	public void stop() {
		if (this.isRunning) {
			this.isRunning = false;
			
			logger.info("Simulation stop requested!");
			// createStopEvent().schedule(0);
			this.model.getResourceRegistry().deactivateAllActiveResources();
			this.model.getResourceRegistry().deactivateAllPassiveResources();
			logger.info("Scheduled Simulation Stop Event now");
		}
	}

	public Simulator getSimulator(){
		return simulator;
	}

	public boolean isRunning() {
		return this.isRunning;
	}

	private Event createStopEvent() {
		return new Event(simulator) {

			@Override
			public void actions() {
				if (isRunning()){
					logger.debug("Executing Stop Event");
					stop();
				}
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

	private void doReliabilityResultLogging() {
		int openRunCount = OpenWorkloadUser.getRunCount();
		int openFailureCount = OpenWorkloadUser.getFailureCount();
		double openFailureRate = (openRunCount == 0) ? 0
				: ((double) openFailureCount / (double) openRunCount);
		int closedRunCount = ClosedWorkloadUser.getRunCount();
		int closedFailureCount = ClosedWorkloadUser.getFailureCount();
		double closedFailureRate = (closedRunCount == 0) ? 0
				: ((double) closedFailureCount / (double) closedRunCount);
		logger.warn("Simulation results: OpenWorkloadUser.runCount = "
				+ openRunCount);
		logger.warn("Simulation results: OpenWorkloadUser.failureCount = "
				+ openFailureCount);
		logger.warn("Simulation results: OpenWorkloadUser.failureRate = "
				+ openFailureRate);
		logger.warn("Simulation results: ClosedWorkloadUser.runCount = "
				+ closedRunCount);
		logger.warn("Simulation results: ClosedWorkloadUser.failureCount = "
				+ closedFailureCount);
		logger.warn("Simulation results: ClosedWorkloadUser.failureRate = "
				+ closedFailureRate);
		OpenWorkloadUser.resetCounters();
		ClosedWorkloadUser.resetCounters();
	}
}

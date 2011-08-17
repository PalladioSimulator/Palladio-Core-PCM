package de.uka.ipd.sdq.simucomframework.desmoj;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class DesmoJExperiment implements ISimulationControlDelegate {

	private DesmoJModel model;
	private boolean isRunning;
	private SimuComModel simuComModel;
	private ArrayList<Condition> stopConditions = new ArrayList<Condition>();

	public DesmoJExperiment(SimuComModel model) {
		this.model = new DesmoJModel(model);
		this.simuComModel = model;
	}

	public void addStopCondition(Condition condition) {
		stopConditions.add(condition);
	}

	double lastStopConditionEvaluationSimTime = 0;
	public void checkStopConditions(){
		if (lastStopConditionEvaluationSimTime < this.getCurrentSimulationTime()) {
			if (isRunning()){
				Entity e = new Entity(model, "StopEntity", false){};
				for(Condition c : stopConditions) {
					if (c.check()) {
						logger.debug("Scheduling stop event as a stop condition is true.");
						createStopCondition().schedule(e, new SimTime(0));
						return;
					}
				}
			}
			lastStopConditionEvaluationSimTime = this.getCurrentSimulationTime();
		}
	}

	private Event createStopCondition() {
		return new Event(model, "StopEvent", false) {

			@Override
			public void eventRoutine(Entity arg0) {
				logger.debug("createStopCondition()::eventRountine(..) reached.");
				stop();
			}

		};
	}
	public void addTimeObserver(Observer observer) {
		model.getExperiment().getSimClock().addObserver(observer);
	}

	public double getCurrentSimulationTime() {
		return model.currentTime().getTimeValue();
	}

	public void setMaxSimTime(long simTime) {
		if (simTime > 0) {
			//model.getExperiment().stop(new SimTime(simTime));
			Entity e = new Entity(model, "StopEntity", false){};
			createStopCondition().schedule(e, new SimTime(simTime));
		}
	}

	protected static Logger logger =
		Logger.getLogger(DesmoJExperiment.class.getName());

	public void start() {
		this.isRunning = true;

		this.addTimeObserver(new Observer(){

			/** {@inheritDoc}
			 */
			public void update(Observable o, Object arg) {
				checkStopConditions();
			}

		});

		double start = System.nanoTime();
		logger.info("Starting DESMO-J-based simulation");
		model.getExperiment().start();
		logger.info("DESMO-J-based Simulation terminated. Execution time: "+((System.nanoTime()-start)/Math.pow(10,9))+" seconds (real time).");

		this.isRunning = false;
	}

	public void stop() {
		if (isRunning) {
			this.isRunning = false;
			// model.getExperiment().stop();
			// model.getExperiment().finish();
			logger.info("Simulation stop requested!");
			// createStopEvent().schedule(0);
			this.simuComModel.getResourceRegistry().deactivateAllActiveResources();
			this.simuComModel.getResourceRegistry().deactivateAllPassiveResources();
			logger.info("Scheduled Simulation Stop Event now");
		}
	}

	public Model getDesmoJModel() {
		return model;
	}

	public boolean isRunning() {
		return this.isRunning;
	}

}

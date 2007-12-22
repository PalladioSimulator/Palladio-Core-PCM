package de.uka.ipd.sdq.simucomframework.desmoj;

import java.util.Observer;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Condition;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimulationControlDelegate;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class DesmoJExperiment implements ISimulationControlDelegate {

	private DesmoJModel model;

	public DesmoJExperiment(SimuComModel model) {
		this.model = new DesmoJModel(model);
	}
	
	public void addStopCondition(Condition condition) {
		model.getExperiment().stop(new DesmoJConditionWrapper(condition,model));
	}

	public void addTimeObserver(Observer observer) {
		model.getExperiment().getSimClock().addObserver(observer);
	}

	public double getCurrentSimulationTime() {
		return model.currentTime().getTimeValue();
	}

	public void setMaxSimTime(long simTime) {
		if (simTime > 0)
			model.getExperiment().stop(new SimTime(simTime));
	}

	protected static Logger logger = 
		Logger.getLogger(DesmoJExperiment.class.getName());

	public void start() {
		double start = System.nanoTime();
		logger.warn("Starting simulation...");
		model.getExperiment().start();
		logger.warn("Simulation terminated. Took "+((System.nanoTime()-start)/Math.pow(10,9))+" real time seconds.");
	}

	public void stop() {
		model.getExperiment().stop();
		model.getExperiment().finish();
	}

	public Model getDesmoJModel() {
		return model;
	}

}

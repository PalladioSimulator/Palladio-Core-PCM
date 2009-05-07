package de.uka.ipd.sdq.simucomframework.usage;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedActiveResource;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class ClosedWorkloadUser extends SimProcess implements IUser {

	private static Logger logger = 
		Logger.getLogger(ClosedWorkloadUser.class.getName());
	
	private IScenarioRunner scenarioRunner;
	private String thinkTime;

	public ClosedWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name, false);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
	}

	@Override
	public void lifeCycle() {
		logger.info("Starting user "+this.getName());
		try {
			while (true) {
				scenarioRunner(this);
			}
		} catch (SimFinishedException ex) {
		} catch (Exception e) {
			this.getModel().getExperiment().stop();
			((SimuComModel)getModel()).setStatus(SimuComStatus.ERROR,
					e);
		}
	}

	public void scenarioRunner(SimProcess thread) {
		double thinkTime = (Double)Context.evaluateStatic(this.thinkTime,Double.class,null);
		this.hold(new SimTime(thinkTime));
		this.scenarioRunner.scenarioRunner(thread);
	}

	public void startUserLife() {
		this.activate(SimTime.NOW);
	}

}

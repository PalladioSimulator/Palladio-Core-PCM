package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

/**
 * A closed workload user is a user which performs the typical closed workload clycle:
 * execute, think, execute, ...
 * @author Steffen Becker
 *
 */
public class ClosedWorkloadUser extends SimProcess implements IUser {

	private static Logger logger = 
		Logger.getLogger(ClosedWorkloadUser.class.getName());
	
	private IScenarioRunner scenarioRunner;
	private String thinkTime;

	/**
	 * Constructor of the closed workload user
	 * @param owner The model this user belongs to
	 * @param name The users name
	 * @param scenarioRunner2 The scenario runner determining the users behaviour
	 * @param thinkTimeSpec A stoex which deterimines the users think time
	 */
	public ClosedWorkloadUser(Model owner, String name, IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name, false);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimProcess thread) {
		double thinkTime = (Double)Context.evaluateStatic(this.thinkTime,Double.class,null);
		this.hold(new SimTime(thinkTime));
		this.scenarioRunner.scenarioRunner(thread);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
	 */
	public void startUserLife() {
		this.activate(SimTime.NOW);
	}

}

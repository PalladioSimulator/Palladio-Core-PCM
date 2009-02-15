package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

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
	public ClosedWorkloadUser(SimuComModel owner, String name, IScenarioRunner scenarioRunner2, String thinkTimeSpec) {
		super(owner, name);
		this.scenarioRunner = scenarioRunner2;
		this.thinkTime = thinkTimeSpec;
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.SimProcess#lifeCycle()
	 */
	@Override
	protected void internalLifeCycle() {
		while (getModel().getSimulationControl().isRunning()) {
			scenarioRunner(this);
		}
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IScenarioRunner#scenarioRunner(desmoj.core.simulator.SimProcess)
	 */
	public void scenarioRunner(SimProcess thread) {
		double thinkTime = (Double)Context.evaluateStatic(
				this.getModel().getStoExCache(),
				this.thinkTime,Double.class,null);
		this.hold(thinkTime);
		this.scenarioRunner.scenarioRunner(thread);
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUser#startUserLife()
	 */
	public void startUserLife() {
		this.scheduleAt(0);
	}

}

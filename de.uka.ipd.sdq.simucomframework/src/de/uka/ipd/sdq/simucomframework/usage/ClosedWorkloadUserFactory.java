package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Factory to create closed workload users
 * 
 * @author Steffen Becker
 * 
 */
public abstract class ClosedWorkloadUserFactory implements IUserFactory {

	private String thinkTime;
	private SimuComModel model;

	public ClosedWorkloadUserFactory(SimuComModel model, String thinkTimeSpec) {
		this.thinkTime = thinkTimeSpec;
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#createUser()
	 */
	public IUser createUser(final String usageScenarioId) {
		IScenarioRunner scenarioRunner = this.createScenarioRunner();
		return new ClosedWorkloadUser(model, "ClosedUser", scenarioRunner,
				thinkTime, usageScenarioId);
	}

	/**
	 * Template method filled by the generator. Returns the users behaviour.
	 * 
	 * @return The behaviour of the users created by this factory
	 */
	public abstract IScenarioRunner createScenarioRunner();

}

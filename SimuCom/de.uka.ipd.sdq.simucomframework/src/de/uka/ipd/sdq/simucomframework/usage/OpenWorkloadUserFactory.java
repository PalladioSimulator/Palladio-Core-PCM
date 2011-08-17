package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * A factory for creating open workload users
 * 
 * @author Steffen Becker
 * 
 */
public abstract class OpenWorkloadUserFactory implements IUserFactory {

	private SimuComModel model;

	public OpenWorkloadUserFactory(SimuComModel model) {
		this.model = model;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.simucomframework.usage.IUserFactory#createUser()
	 */
	public IUser createUser(final String usageScenarioId) {
		IScenarioRunner scenarioRunner = this.createScenarioRunner();
		return new OpenWorkloadUser(model, "OpenUser", scenarioRunner,
				usageScenarioId);
	}

	/**
	 * Template method filled in by the generator. Returns an object
	 * representing the user behaviour needed for the new users.
	 * 
	 * @return The behaviour of the users created by this factory
	 */
	public abstract IScenarioRunner createScenarioRunner();

}

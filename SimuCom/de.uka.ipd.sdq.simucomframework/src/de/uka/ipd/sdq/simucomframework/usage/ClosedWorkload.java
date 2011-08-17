package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;

/**
 * Class used for executing a closed workload. The class creates as many
 * users as specified and executes them simultaniously
 * @author Steffen Becker
 *
 */
public class ClosedWorkload implements IWorkloadDriver {

	private int population;
	private IUserFactory userFactory;
	private String usageScenarioId;

	/**
	 * Constructor of the closed workload driver
	 * @param userFactory Factory used to create the users 
	 * @param population Number of users in the system
	 */
	public ClosedWorkload(IUserFactory userFactory, int population, String usageScenarioId)
	{
		this.population = population;
		this.userFactory = userFactory;
		this.usageScenarioId = usageScenarioId;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver#run()
	 */
	public void run() {
		FailureStatistics.getInstance().reset();
		for (int i=0; i<population; i++) {
			IUser user = userFactory.createUser(usageScenarioId);
			user.startUserLife();
		}
	}
}

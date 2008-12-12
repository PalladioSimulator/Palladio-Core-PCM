package de.uka.ipd.sdq.simucomframework.usage;


/**
 * Class used for executing a closed workload. The class creates as many
 * users as specified and executes them simultaniously
 * @author Steffen Becker
 *
 */
public class ClosedWorkload implements IWorkloadDriver {

	private int population;
	private IUserFactory userFactory;

	private int runCount = 0;
	private int failureCount = 0;

	/**
	 * Constructor of the closed workload driver
	 * @param userFactory Factory used to create the users 
	 * @param population Number of users in the system
	 */
	public ClosedWorkload(IUserFactory userFactory, int population)
	{
		this.population = population;
		this.userFactory = userFactory;
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver#run()
	 */
	public void run() {
		for (int i=0; i<population; i++) {
			IUser user = userFactory.createUser();
			user.startUserLife();
		}
	}
}

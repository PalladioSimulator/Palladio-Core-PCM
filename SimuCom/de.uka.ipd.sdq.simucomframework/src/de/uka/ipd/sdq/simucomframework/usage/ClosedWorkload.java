package de.uka.ipd.sdq.simucomframework.usage;


public class ClosedWorkload implements IWorkloadDriver {

	private int population;
	private IUserFactory userFactory;

	public ClosedWorkload(IUserFactory userFactory, int population)
	{
		this.population = population;
		this.userFactory = userFactory;
	}

	public void run() {
		for (int i=0; i<population; i++) {
			IUser user = userFactory.createUser();
			user.startUserLife();
		}
	}
}

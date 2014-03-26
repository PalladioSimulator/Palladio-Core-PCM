package de.uka.ipd.sdq.simucomframework.usage;


/**
 * Class used for executing a closed workload. The class creates as many users as specified and
 * executes them simultaniously
 * 
 * @author Steffen Becker
 * 
 */
public class ClosedWorkload implements IWorkloadDriver {

    private final int population;
    private final IUserFactory userFactory;

    /**
     * Constructor of the closed workload driver
     * 
     * @param userFactory
     *            Factory used to create the users
     * @param population
     *            Number of users in the system
     */
    public ClosedWorkload(final IUserFactory userFactory, final int population) {
        super();
        this.userFactory = userFactory;
        this.population = population;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.simucomframework.usage.IWorkloadDriver#run()
     */
    @Override
    public void run() {
        for (int i = 0; i < population; i++) {
            final IUser user = userFactory.createUser();
            user.startUserLife();
        }
    }

    @Override
    public IUserFactory getUserFactory() {
        return this.userFactory;
    }
}

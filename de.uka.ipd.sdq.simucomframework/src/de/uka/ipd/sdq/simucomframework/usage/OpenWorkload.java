package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Implementation of the workload driver interface for open workloads
 * 
 * @author Steffen Becker
 * 
 */
public class OpenWorkload extends SimuComSimProcess implements IWorkloadDriver {

    private final String interArrivalTime;
    private final IUserFactory userFactory;

    private static Logger logger = Logger.getLogger(OpenWorkload.class
            .getName());

    /**
     * Counter for usage scenario runs.
     */

    /**
     * Constructor of the open workload driver
     * 
     * @param model
     *            The simulation model this driver belongs to
     * @param userFactory
     *            The factory which is used to bread the users
     * @param interArrivalTime
     *            The time to wait between leaving a new user to its fate
     */
    public OpenWorkload(final SimuComModel model, final IUserFactory userFactory,
            final String interArrivalTime) {
        super(model, "OpenWorkloadUserMaturationChamber");
        this.interArrivalTime = interArrivalTime;
        this.userFactory = userFactory;
    }

    @Override
    public void run() {
        this.scheduleAt(0);
    }

    @Override
    protected void internalLifeCycle() {
        FailureStatistics.getInstance().reset();

        // As long as the simulation is running, new OpenWorkloadUsers are
        // generated and started:
        while (getModel().getSimulationControl().isRunning()) {

            try {
                // Generate and execute the new user:
                generateUser();

                // Wait for inter-arrival time:
                waitForNextUser();

                // Count the new user:
                if (this.getModel().getConfiguration().getSimulateFailures()) {
                    FailureStatistics.getInstance().increaseRunCount();
                    FailureStatistics.getInstance().printRunCount(logger, getModel().getSimulationControl().getCurrentSimulationTime());
                }
            }
            catch (final OutOfMemoryError e) {
                // the system is overloaded. stop simulation
                if(logger.isEnabledFor(Level.INFO)) {
                    logger.info("Stopping simulation run due to memory constraints.");
                }
                getModel().getSimulationControl().stop();
            }
        }

        // Print failure statistics:
        // if (this.getModel().getConfig().getSimulateFailures()) {
        // 	FailureStatistics.getInstance().printFailureStatistics(logger);
        // }
    }

    private void waitForNextUser() {
        final double interArrivalTimeSample = Context.evaluateStatic(
                interArrivalTime, Double.class);
        if(logger.isDebugEnabled()) {
            logger.debug("Waiting for " + interArrivalTimeSample
                    + " before spawing the next user");
        }
        this.hold(interArrivalTimeSample);
    }

    private IUser generateUser() {
        if(logger.isDebugEnabled()) {
            logger.debug("Spawning New User...");
        }
        final IUser user = userFactory.createUser();
        user.startUserLife();
        return user;
    }

    @Override
    public IUserFactory getUserFactory() {
        return this.userFactory;
    }

}

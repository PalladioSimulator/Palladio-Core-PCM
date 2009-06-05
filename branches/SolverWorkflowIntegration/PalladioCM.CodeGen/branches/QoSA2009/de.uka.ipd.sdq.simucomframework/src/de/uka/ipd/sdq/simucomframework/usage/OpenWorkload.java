package de.uka.ipd.sdq.simucomframework.usage;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;


/**
 * Implementation of the workload driver interface for open workloads
 * @author Steffen Becker
 *
 */
public class OpenWorkload extends SimProcess implements IWorkloadDriver {

	private static final int USER_THRESHOLD = 1000;
	private String interArrivalTime;
	private IUserFactory userFactory;

	private static Logger logger = 
		Logger.getLogger(OpenWorkload.class.getName());
	
	/**
	 * Constructor of the open workload driver
	 * @param model The simulation model this driver belongs to
	 * @param userFactory The factory which is used to bread the users
	 * @param interArrivalTime The time to wait between leaving a new user to its fate
	 */
	public OpenWorkload(SimuComModel model, IUserFactory userFactory, String interArrivalTime) {
		super(model,"OpenWorkloadUserMaturationChamber");
		this.interArrivalTime = interArrivalTime;
		this.userFactory = userFactory;
	}

	public void run() {
		this.scheduleAt(0);
	}

	@Override
	protected void internalLifeCycle() {
		while(getModel().getSimulationControl().isRunning()) {
			generateUser();
			waitForNextUser();
			if (Thread.activeCount() > USER_THRESHOLD) {
				logger.error("Too many users spawned! Check your workload settings!");
				throw new RuntimeException("Too many users spawned");
			}
		}
	}

	private void waitForNextUser() {
		double interArrivalTimeSample = (Double)Context.evaluateStatic(interArrivalTime,Double.class);
		logger.info("Waiting for "+interArrivalTimeSample+" before spawing the next user");
		this.hold(interArrivalTimeSample);
	}

	private void generateUser() {
		logger.info("Spawning New User...");
		IUser newUser = userFactory.createUser();
		newUser.startUserLife();
	}	
}

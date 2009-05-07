package de.uka.ipd.sdq.simucomframework.usage;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.exception.SimFinishedException;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class OpenWorkload extends SimProcess implements IWorkloadDriver {

	private static final int USER_THRESHHOLD = 1000;
	private String interArrivalTime;
	private IUserFactory userFactory;

	private static Logger logger = 
		Logger.getLogger(OpenWorkload.class.getName());
	
	public OpenWorkload(SimuComModel model, IUserFactory userFactory, String interArrivalTime) {
		super(model,"OpenWorkloadUserMaturationChamber",true);
		this.interArrivalTime = interArrivalTime;
		this.userFactory = userFactory;
	}

	public void run() {
		this.activate(SimTime.NOW);
	}

	@Override
	public void lifeCycle() {
		try {
			logger.info("Open Workload User Generator starting...");
			while(true) {
				generateUser();
				waitForNextUser();
				if (Thread.activeCount() > USER_THRESHHOLD) {
					logger.error("Too many users spawned! Check your workload settings!");
					throw new RuntimeException("Too many users spawned");
				}
			}
		} catch (SimFinishedException ex) {
		} catch (Exception e) {
			this.getModel().getExperiment().stop();
			((SimuComModel)getModel()).setStatus(SimuComStatus.ERROR,
					e);
		}
	}

	private void waitForNextUser() {
		double interArrivalTimeSample = (Double)Context.evaluateStatic(interArrivalTime,Double.class);
		logger.info("Waiting for "+interArrivalTimeSample+" before spawing the next user");
		this.hold(new SimTime(interArrivalTimeSample));
	}

	private void generateUser() {
		logger.info("Spawning New User...");
		userFactory.createUser().startUserLife();
	}	
}

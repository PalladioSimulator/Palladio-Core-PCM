package de.uka.ipd.sdq.simucomframework.usage;

import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;


public class OpenWorkload extends SimProcess implements IWorkloadDriver {

	private String interArrivalTime;
	private IUserFactory userFactory;

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
		while(true) {
			generateUser();
			waitForNextUser();
		}
	}

	private void waitForNextUser() {
		double interArrivalTimeSample = (Double)Context.evaluate(interArrivalTime,Double.class,null);
		this.hold(new SimTime(interArrivalTimeSample));
	}

	private void generateUser() {
		userFactory.createUser().startUserLife();
	}	
}

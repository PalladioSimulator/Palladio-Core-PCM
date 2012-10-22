package simurex;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class Server extends SimProcess {

	QueueingModel myModel;
	
	public Server(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		myModel = (QueueingModel)owner;
	}

	@Override
	public void lifeCycle() {
		while(true) { // repeat for the complete simulation
			if(myModel.resourceQueue.isEmpty()){
				myModel.idleServerQueue.insert(this);
				passivate();
			} else {
				Customer next = (Customer)myModel.resourceQueue.first();
				myModel.resourceQueue.remove(next);
				//next.endWait();
				hold(new SimTime(myModel.getServiceTime()));
				next.activate(new SimTime(0.0));
			}
			
		}
	}

}

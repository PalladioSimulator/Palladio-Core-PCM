package simurex;

import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimProcess;
import desmoj.core.simulator.SimTime;

public class Customer extends SimProcess {
	
	QueueingModel myModel;
	
	
	public Customer(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		
		myModel = (QueueingModel)owner;
	}

	@Override
	public void lifeCycle() {
		while(true){

			hold(new SimTime(myModel.getThinkTime())); // think
			
			SimTime start = currentTime();			

			myModel.queueLength.addValue(myModel.resourceQueue.length());
			myModel.resourceQueue.insert(this);
			sendTraceNote("TruckQueuelength: " + myModel.resourceQueue.length());			
			
			if (!myModel.idleServerQueue.isEmpty()){
				Server server = (Server)myModel.idleServerQueue.first();
				myModel.idleServerQueue.remove(server);
				server.activateAfter(this);
				passivate();
			} else {
				passivate();
			}
			myModel.sojournTime.addValue(currentTime().getTimeValue() - start.getTimeValue());			
			sendTraceNote("Customer was serviced and leaves system.");
		}
	}

}

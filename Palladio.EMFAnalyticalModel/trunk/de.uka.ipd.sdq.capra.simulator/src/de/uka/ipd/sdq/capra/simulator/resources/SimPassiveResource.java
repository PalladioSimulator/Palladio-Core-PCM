package de.uka.ipd.sdq.capra.simulator.resources;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import umontreal.iro.lecuyer.simevents.Sim;

import de.uka.ipd.sdq.capra.simulator.CapraSim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.events.ContinueProcessEvent;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveProcess;

public class SimPassiveResource extends AbstractSimResource{
	
	private class WaitingFor {
		public SimCapraProcess process;
		public int num;
		
		public WaitingFor(SimCapraProcess process, int num) {
			super();
			this.process = process;
			this.num = num;
		}
	}
	
	private Queue<WaitingFor> waitingQueue = new ArrayDeque<WaitingFor>();
	
	private List<SimActiveResource> favouredResources = new ArrayList<SimActiveResource>();
	
	public SimPassiveResource(String name, int capacity) {
		super(name, capacity);
	}

	public void init(){
	}
	
	public void addFavouredResource(SimActiveResource resource){
		this.favouredResources.add(resource);
	}
	
	public void acquire(SimCapraProcess capraProcess, int num){
		CapraSim.logger.info(Sim.time() + "\t  " + capraProcess.getName() + " requests #" + num + " " + getName());
		if (num <= capacity) {
			capacity -= num;
			CapraSim.logger.info(Sim.time() + "\t  " + capraProcess.getName() + " receives #" + num + " " + getName());
			increasePriority(capraProcess);
			capraProcess.setReady(false);
			capraProcess.proceed();
		} else {
			waitingQueue.add(new WaitingFor( capraProcess, num) );
			capraProcess.setReady(true);
		}
	}
	
	public void release(SimCapraProcess capraProcess, int num){
		capacity += num;
		CapraSim.logger.info(Sim.time() + "\t  " + capraProcess.getName() + " returns #" + num + " " + getName());
		ContinueProcessEvent predecessor = null;
		// TODO: Where to decrease priorities?
		// decreasePriority(capraProcess);
		while( (waitingQueue.size()>0) && (waitingQueue.peek().num <= capacity)){
			WaitingFor waitingProcess = waitingQueue.poll();
			capacity -= waitingProcess.num;
			CapraSim.logger.info(Sim.time() + "\t  " + waitingProcess.process.getName() + " receives #" + num + " " + getName());
			increasePriority(waitingProcess.process);
			ContinueProcessEvent proceedEvent = new ContinueProcessEvent(waitingProcess.process);
			saveScheduleAfter(proceedEvent, predecessor);
			predecessor = proceedEvent;
		}
		ContinueProcessEvent proceedEvent = new ContinueProcessEvent(capraProcess);
		saveScheduleAfter(proceedEvent, predecessor);
	}

	private void decreasePriority(SimCapraProcess process) {
		for (SimActiveResource resource : favouredResources) {
			PreemptiveProcess preemptiveProcess = resource.getRegistry().getPreemptiveProcess(process);
			preemptiveProcess.decreasePriority();
		}
	}

	private void increasePriority(SimCapraProcess process) {
		for (SimActiveResource resource : favouredResources) {
			PreemptiveProcess preemptiveProcess = resource.getRegistry().getPreemptiveProcess(process);
			preemptiveProcess.increasePriority();
		}
	}

	private void saveScheduleAfter(ContinueProcessEvent proceedEvent, ContinueProcessEvent predecessor) {
		if (predecessor == null){
			proceedEvent.scheduleNext();
		} else {
			proceedEvent.scheduleAfter(predecessor);
		}
	}
}

package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.Hashtable;
import java.util.Map.Entry;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public class SimProcessorSharingResource extends AbstractActiveResource {
	
	private class ProcessingFinishedEvent extends Event {
		ISchedulableProcess process;
		
		public ProcessingFinishedEvent(ISchedulableProcess process) {
			super(SchedulingFactory.getUsedSimulator());
			this.process = process;
		}
		
		public ISchedulableProcess getProcess() {
			return process;
		}

		public void setProcess(ISchedulableProcess process) {
			this.process = process;
		}

		@Override
		public void actions() {
			ISchedulableProcess last = process;
			toNow();
			running_processes.remove(last);
			fireStateChange(running_processes.size(), 0);
			LoggingWrapper.log(last + " finished.");
			scheduleNextEvent();
			last.activate();
		}
		
	}
	
	private ProcessingFinishedEvent processingFinished = new ProcessingFinishedEvent(null);
	private Hashtable<ISchedulableProcess,Double> running_processes = new Hashtable<ISchedulableProcess, Double>();
	private double last_time; 
	private Simulator simulator;

	public SimProcessorSharingResource(String name, String id, int i) {
		super(i, name, id);
		this.simulator = SchedulingFactory.getUsedSimulator();
	}


	public void scheduleNextEvent() {
		ISchedulableProcess shortest = null;
		for (ISchedulableProcess process : running_processes.keySet()) {
			if (shortest == null || running_processes.get(shortest) > running_processes.get(process)){
				shortest = process;
			}
		}
		processingFinished.cancel();
		if (shortest!=null){
			processingFinished.setProcess(shortest);
			double time = running_processes.get(shortest) * getSpeed();
			
			// avoid trouble caused by rounding issues
			time = MathTools.equalsDouble(time, 0) ? 0.0 : time; 
			
			assert time >= 0 : "Remaining time ("+ time +")small than zero!";
			
			processingFinished.schedule(time);
		}
	}


	private void toNow() {
		double now = simulator.time();
		double passed_time = now - last_time;
		if (MathTools.less(0, passed_time)){
			passed_time /= getSpeed(); 
			for (Entry<ISchedulableProcess,Double> e : running_processes.entrySet()) {
				double rem =   e.getValue() - passed_time;
				e.setValue(rem);
			}
		}
		last_time = now;
	}


	private double getSpeed() {
		double speed = (double)running_processes.size() / (double)getCapacity();
		return speed < 1.0 ? 1.0 : speed;
	}


	public void start() {
	}


	@Override
	protected void dequeue(ISchedulableProcess process) {
	}


	@Override
	protected void doProcessing(ISchedulableProcess process, double demand) {
		if (simulator.isStopped()) {
			//Hauck
			//Do nothing, but allows calling process to complete
			return;
		}
		toNow();
		LoggingWrapper.log("PS: " + process + " demands " + demand);
		running_processes.put(process, demand);
		fireStateChange(running_processes.size(), 0);
		scheduleNextEvent();
		process.passivate();
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
	}


	public void stop() {
		// Hauck
		// Activate all waiting processes to yield process completion
		for (Entry<ISchedulableProcess, Double> processEntry : running_processes.entrySet()) {
			processEntry.getKey().activate();
		}
	}

	public void registerProcess(IRunningProcess runningProcess) {
	}
	
	@Override
	public int getQueueLengthFor(SimResourceInstance simResourceInstance) {
		return this.running_processes.size();
	}

}

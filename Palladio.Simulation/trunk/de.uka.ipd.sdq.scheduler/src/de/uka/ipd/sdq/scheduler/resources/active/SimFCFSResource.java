package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Hashtable;

import umontreal.iro.lecuyer.simevents.Event;
import umontreal.iro.lecuyer.simevents.Simulator;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;

public class SimFCFSResource extends AbstractActiveResource {

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
			ISchedulableProcess first = process;
			toNow();
			assert MathTools.equalsDouble(0, running_processes.get(first));
			running_processes.remove(first);
			processQ.remove(first);
			LoggingWrapper.log("Demand of Process "+ first + " finished.");
			scheduleNextEvent();
			first.activate();
		}

	}

	private ProcessingFinishedEvent processingFinished = new ProcessingFinishedEvent(
			null);
	private Deque<ISchedulableProcess> processQ = new ArrayDeque<ISchedulableProcess>();
	private Hashtable<ISchedulableProcess, Double> running_processes = new Hashtable<ISchedulableProcess, Double>();
	private double last_time;
	private Simulator simulator;

	public SimFCFSResource(String name, String id, int i) {
		super(i, name, id);
		this.simulator = SchedulingFactory.getUsedSimulator();
	}

	public void scheduleNextEvent() {
		ISchedulableProcess first = processQ.peek();
		processingFinished.cancel();
		if (first != null) {
			processingFinished.setProcess(first);
			double time = running_processes.get(first);
			processingFinished.schedule(time);
		}
	}

	private void toNow() {
		double now = simulator.time();
		double passed_time = now - last_time;
		if (MathTools.less(0, passed_time)) {
			ISchedulableProcess first = processQ.peek();
			if (first != null) {
				double demand = running_processes.get(first);
				demand -= passed_time;
				assert MathTools.lessOrEqual(0, demand);
				running_processes.put(first, demand);
			}
		}
		last_time = now;
		
	}

	public void start() {
	}

	@Override
	protected void dequeue(ISchedulableProcess process) {
	}

	@Override
	protected void doProcessing(ISchedulableProcess process, double demand) {
		toNow();
		LoggingWrapper.log("FCFS: " + process + " demands " + demand);
		running_processes.put(process, demand);
		processQ.add(process);
		scheduleNextEvent(); 
		process.passivate();
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
	}

	public void stop() {

	}

	public void registerProcess(IRunningProcess runningProcess) {
	}

}

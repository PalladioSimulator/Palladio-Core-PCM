package de.uka.ipd.sdq.scheduler.resources.active;

import java.util.Hashtable;
import java.util.Map.Entry;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.probfunction.math.util.MathTools;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.LoggingWrapper;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.entities.SchedulerEntity;
import de.uka.ipd.sdq.simulation.abstractsimengine.AbstractSimEventDelegator;

public class SimProcessorSharingResource extends AbstractActiveResource {
	
	private static Logger logger = Logger.getLogger(SimProcessorSharingResource.class);
	
	/**
	 * The minimum amount of time used for scheduling an event 
	 */
	static double JIFFY = 1e-9;
	
	private class ProcessingFinishedEvent extends AbstractSimEventDelegator<ISchedulableProcess> {
				
		public ProcessingFinishedEvent(SchedulerModel model) {
			super(model, ProcessingFinishedEvent.class.getName());
		}

		@Override
		public void eventRoutine(ISchedulableProcess process) {
			ISchedulableProcess last = process;
			toNow();
			running_processes.remove(last);
			// fire changes of the queue length only, if there is one single core. 
			// With more cores, one cannot say on which core a job has been processed.
			if (getCapacity() == 1) {
				fireStateChange(running_processes.size(), 0);
			}
			fireDemandCompleted(last);
			LoggingWrapper.log(last + " finished.");
			scheduleNextEvent();
			last.activate();
		}
		
	}
	
	private ProcessingFinishedEvent processingFinished;
	private Hashtable<ISchedulableProcess,Double> running_processes = new Hashtable<ISchedulableProcess, Double>();
	private double last_time; 

	public SimProcessorSharingResource(SchedulerModel model, String name, String id, int i) {
		super(model, i, name, id);
		this.processingFinished = new ProcessingFinishedEvent(model);
	}

	public void scheduleNextEvent() {
		ISchedulableProcess shortest = null;
		for (ISchedulableProcess process : running_processes.keySet()) {
			if (shortest == null || running_processes.get(shortest) > running_processes.get(process)){
				shortest = process;
			}
		}
		processingFinished.removeEvent();
		if (shortest!=null){
			double remainingTime = running_processes.get(shortest) * getSpeed();
			
			// avoid trouble caused by rounding issues
			remainingTime = remainingTime < JIFFY ? 0.0 : remainingTime; 
			
			assert remainingTime >= 0 : "Remaining time ("+ remainingTime +")small than zero!";
			
			processingFinished.schedule(shortest, remainingTime);
		}
	}


	private void toNow() {
		double now = getModel().getSimulationControl().getCurrentSimulationTime();
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
	protected void doProcessing(ISchedulableProcess process, int resourceServiceID, double demand) {
		toNow();
		LoggingWrapper.log("PS: " + process + " demands " + demand);
		if(demand < JIFFY)
		{
			demand = JIFFY;
			LoggingWrapper.log("PS: " + process + " demand was increased to match JIFFY " + demand);
		}
	
		running_processes.put(process, demand);
		// fire changes of the queue length only, if there is one single core. 
		// With more cores, one cannot say on which core a job has been processed.
		if (getCapacity() == 1) {
			fireStateChange(running_processes.size(), 0);
		}
		scheduleNextEvent();
		process.passivate();
	}
	
	
	@Override
	public double getRemainingDemand(ISchedulableProcess process) {
		if (!running_processes.contains(process)) {
			return 0.0;
		}
		toNow();
		return running_processes.get(process);
	}
	
	@Override
	public void updateDemand(ISchedulableProcess process, double demand) {
		boolean updated = false;
		for (Entry<ISchedulableProcess,Double> e : running_processes.entrySet()) {
			if (e.getKey().equals(process)) {
				if (Double.isNaN(demand)) {
					if(logger.isEnabledFor(Level.INFO))
						logger.info("Specified demand " + demand + "is not a number.");
				}
				e.setValue(demand);
				updated = true;
				break;
			}
		}
		if (updated == false) {
			throw new RuntimeException("COULD NOT UPDATE PROCESS!");
		}
		scheduleNextEvent();
	}

	@Override
	protected void enqueue(ISchedulableProcess process) {
	}

	public void registerProcess(ISchedulableProcess process) {
	}
	
	public int getQueueLengthFor(SchedulerEntity schedulerEntity) {
		return this.running_processes.size();
	}

	public void stop() {
	}

}

/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.resources;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.PreemptionConfiguration;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.PriorityConfiguration;
import scheduler.configuration.PriorityRange;
import scheduler.configuration.ProcessConfiguration;
import scheduler.configuration.ProcessSelection;
import scheduler.configuration.ResourceInstanceSelection;
import scheduler.configuration.RunQueueType;
import scheduler.configuration.SchedulerConfiguration;
import scheduler.configuration.SingleQueueConfiguration;
import scheduler.configuration.TimeSliceConfiguration;
import scheduler.configuration.TimeValue;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * @author Snowball
 *
 */
public class ExactCPUResource extends AbstractScheduledResource {

	private String processingRate = "0";
	private String units = null;
	IActiveResource myCPU = null;
	ActiveResourceConfiguration config = null;
	
	public ExactCPUResource(SimuComModel myModel, String typeID, String description, String processingRate, String units, SchedulingStrategy strategy)
	{
		super (myModel, typeID, description, strategy);
		
		this.processingRate = processingRate;
		this.units = units;
		config = ConfigurationFactory.eINSTANCE.createActiveResourceConfiguration();
		config.setId(description);
		config.setName(description);
		config.setReplicas(1);
		SchedulerConfiguration schedConf = ConfigurationFactory.eINSTANCE.createSchedulerConfiguration();
		config.setSchedulerConfiguration(schedConf);
		schedConf.setId(description+"Scheduler");
		schedConf.setName(description+"Scheduler");
		PreemptionConfiguration preemptconfig = ConfigurationFactory.eINSTANCE.createPreemptionConfiguration();
		TimeSliceConfiguration timesliceConfig = ConfigurationFactory.eINSTANCE.createPredefinedTimeSliceConfiguration();
		timesliceConfig.setGranularity(1);
		TimeValue timedValue = ConfigurationFactory.eINSTANCE.createTimeValue();
		timedValue.setValue(0.1);
		TimeValue timedValue2 = ConfigurationFactory.eINSTANCE.createTimeValue();
		timedValue2.setValue(0.1);
		timesliceConfig.setTimeslice(timedValue);
		preemptconfig.setTimesliceConfiguration(timesliceConfig);
		schedConf.setPreemptionConfiguration(preemptconfig);
		PriorityConfiguration prioConfig = ConfigurationFactory.eINSTANCE.createPriorityConfiguration();
		PriorityRange range = ConfigurationFactory.eINSTANCE.createPriorityRange();
		range.setHigh(15);
		range.setLow(1);
		range.setAverage(7);
		range.setDefault(7);
		range.setHighest(20);
		range.setLowest(0);
		prioConfig.setRange(range);
		schedConf.setPriorityConfiguration(prioConfig);
		SingleQueueConfiguration queueConfig = ConfigurationFactory.eINSTANCE.createSingleQueueConfiguration();
		queueConfig.setInitialInstanceSelection(ResourceInstanceSelection.ROUND_ROBIN);
		queueConfig.setProcessSelection(ProcessSelection.NEXT_RUNNABLE);
		queueConfig.setRunqueueType(RunQueueType.SINGLE);
		schedConf.setQueueingConfiguration(queueConfig);
		schedConf.setInterval(timedValue2);
		myCPU = SchedulingFactory.eINSTANCE.createActiveResource(config);
	}

	@Override
	protected double calculateDemand(double demand) {
		return demand/(Double)Context.evaluateStatic(processingRate,Double.class);
	}

	@Override
	public void activateResource() {
		myCPU.start();
	}

	@Override
	public void addJob(JobAndDemandStruct demand) {
	}

	@Override
	public void consumeResource(SimProcess thread, double demand) {
		ProcessConfiguration pc = ConfigurationFactory.eINSTANCE.createProcessConfiguration();
		pc.setId(thread.getId());
		pc.setName(thread.getId());
		pc.setReplicas(1);
		pc.setPriority(PriorityClass.DEFAULT);
		IRunningProcess rp = SchedulingFactory.eINSTANCE.createRunningProcess
			(thread, pc, config);
		myCPU.registerProcess(rp);
		myCPU.process(thread, demand);
	}

	@Override
	public void deactivateResource() {
		// Nothing to do here
	}

	@Override
	protected ISchedulingStrategy getStrategy(SchedulingStrategy strategy) {
		return super.getStrategy(strategy);
	}

	@Override
	public double getTimeWhenNextJobIsDone() {
		throw new UnsupportedOperationException();
	}

	@Override
	public int getTotalJobCount() {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean hasMoreJobs() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void processPassedTime() {
		throw new UnsupportedOperationException();
	}

	@Override
	public JobAndDemandStruct removeFinishedJob() {
		throw new UnsupportedOperationException();
	}

	@Override
	public void setIdle(boolean b) {
		throw new UnsupportedOperationException();
	}
}

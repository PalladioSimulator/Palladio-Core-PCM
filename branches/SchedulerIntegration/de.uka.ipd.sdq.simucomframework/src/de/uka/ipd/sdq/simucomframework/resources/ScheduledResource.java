/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.resources;

import scheduler.SchedulerLibrary;
import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.ConfigurationFactory;
import scheduler.configuration.PriorityClass;
import scheduler.configuration.ProcessConfiguration;
import scheduler.configuration.SchedulerConfiguration;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.impl.ProcessWithPriority;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * @author Snowball
 *
 */
public class ScheduledResource extends AbstractScheduledResource {

	private static final String PATHMAP_TO_SCHEDULER_LIBRARY = "pathmap://PCM_MODELS/Library.scheduler";
	//private static final String PATHMAP_TO_SCHEDULER_LIBRARY = "C:/data/scheduler/de.uka.ipd.sdq.pcm.codegen.m2m/defaultModels/Library.scheduler";
	private static long resourceId = 1;
	private String processingRate = "0";
	IActiveResource aResource = null;
	ActiveResourceConfiguration resourceConf = null;

	
	/* Loads scheduler configuration */
	private IActiveResource getResource(String schedulerLibFileName, String schedulerName, int numReplicas) {
		
		SchedulerLibrary lib = (SchedulerLibrary) SchedulerTools
				.loadFromXMI(schedulerLibFileName);
		SchedulerConfiguration selectedConf = null;
		for (SchedulerConfiguration conf : lib.getSchedulerConfiguration()) {
			if (conf.getName().equals(schedulerName)) {
				selectedConf = conf;
				break;
			}
		}
		if (selectedConf != null) {
			resourceConf = ConfigurationFactory.eINSTANCE
					.createActiveResourceConfiguration();
			resourceConf.setId(getNextResourceId());
			resourceConf.setName(schedulerName);
			resourceConf.setReplicas(numReplicas);
			resourceConf.setSchedulerConfiguration(selectedConf);
			return ISchedulingFactory.eINSTANCE
					.createActiveResource(resourceConf);
		}
		return null;
	}

	private IActiveResource getScheduledResource(SchedulingStrategy strategy, int numberOfCores)
	{
		IActiveResource scheduledResource = null;

		switch (strategy) {
		
		// active resources scheduled by standard scheduling techniques
		case FCFS:
			scheduledResource = ISchedulingFactory.eINSTANCE.
				createSimFCFSResource(SchedulingStrategy.FCFS.toString(), getNextResourceId());
			break;
		case PROCESSOR_SHARING:
			scheduledResource = ISchedulingFactory.eINSTANCE.
				createSimProcessorSharingResource(SchedulingStrategy.PROCESSOR_SHARING.toString(), getNextResourceId());
			break;
		case DELAY:
			scheduledResource = ISchedulingFactory.eINSTANCE.
				createSimDelayResource(SchedulingStrategy.DELAY.toString(), getNextResourceId());
			break;
		// active resources scheduled by improved scheduler
		case LINUX_2_6:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Linux 2.6.22", numberOfCores);
			break;
		case WINDOWS_SERVER_2003:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Windows 2003", numberOfCores);
			break;
		case WINDOWS_XP:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Windows XP", numberOfCores);
			break;
		}
		
		return scheduledResource;
	}
	
	private void registerProcessWindows(ISchedulableProcess process,
			IActiveResource resource, int prio) {
		if (resourceConf != null) {
			ProcessConfiguration processConf = ConfigurationFactory.eINSTANCE
					.createProcessConfiguration();
			processConf.setId(process.getId());
			processConf.setName(process.getId());
			processConf.setPriority(PriorityClass.AVERAGE);
			processConf.setReplicas(1);
			ProcessWithPriority p = (ProcessWithPriority) ISchedulingFactory.eINSTANCE
					.createRunningProcess(process, processConf, resourceConf);
			p.getStaticPriority().setValue(prio);
			p.getDynamicPriority().setValue(prio);

			resource.registerProcess(p);
		}
	}
	
	public ScheduledResource(SimuComModel myModel, 
			String typeID, 
			String description, 
			String processingRate, 
			String units, 
			SchedulingStrategy strategy,
			int numberOfCores)
	{
		super (myModel, typeID, description, strategy);
		this.processingRate = processingRate;
		
		logger.debug("Creating scheduled resource with strategy "+strategy.name()+" and "+numberOfCores+" replicas!");
		aResource = getScheduledResource(strategy, numberOfCores);	
	}
	

	@Override
	protected double calculateDemand(double demand) {
		return demand/(Double)Context.evaluateStatic(processingRate,Double.class);
	}

	@Override
	public void activateResource() {
		aResource.start();
	}

	@Override
	public void addJob(JobAndDemandStruct demand) {
	}

	@Override
	public void consumeResource(SimProcess thread, double demand) {
		registerProcessWindows(thread, aResource, 8);
		aResource.process(thread, demand);
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

	public static String getNextResourceId() {
		
		return Long.toString(resourceId++);
	}
}

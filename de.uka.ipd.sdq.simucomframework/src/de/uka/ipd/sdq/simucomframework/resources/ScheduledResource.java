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
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.tools.SchedulerTools;
import de.uka.ipd.sdq.simucomframework.Context;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.sensors.SimpleTimeSpanSensor;
import de.uka.ipd.sdq.simucomframework.sensors.UtilisationSensor;

/**
 * @author Snowball
 *
 */
public class ScheduledResource extends AbstractScheduledResource {

	private static final String PATHMAP_TO_SCHEDULER_LIBRARY = "pathmap://PCM_MODELS/Library.scheduler";
	private static long resourceId = 1;
	private String processingRate = "0";
	IActiveResource aResource = null;
	ActiveResourceConfiguration resourceConf = null;
	private SimpleTimeSpanSensor demandedTimeSensor;

	
	public ScheduledResource(SimuComModel myModel, 
			String typeID, 
			String description, 
			String processingRate, 
			Double mttf, Double mttr,  
			SchedulingStrategy strategy,
			int numberOfCores)
	{
		super (myModel, typeID, description, strategy);
		this.processingRate = processingRate;
		logger.debug("Creating scheduled resource with strategy "+strategy.name()+" and "+numberOfCores+" replicas!");
		aResource = getScheduledResource(strategy, numberOfCores);	
		
		this.demandedTimeSensor = new SimpleTimeSpanSensor(myModel, "Demanded time at " + description);
		
		// Reliability Stuff.
		this.mttf = mttf;
		this.mttr = mttr;
		this.canBeUnavailable = (myModel.getConfig().getSimulateFailures()
				&& (this.mttf > 0.0) && (this.mttr > 0.0));

		// used to let resource fail and be repaired again:
		if (this.canBeUnavailable) {
			this.failedEvent = new ResourceFailedEvent(myModel,
					"ResourceFailed");
			this.repairedEvent = new ResourceRepairedEvent(myModel,
					"ResourceRepaired");
			this.failedEvent.setResource(this);
			this.failedEvent.setRepairedEvent(repairedEvent);
			this.repairedEvent.setResource(this);
			this.repairedEvent.setFailedEvent(failedEvent);
		}
	}

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
			resourceConf.setName(schedulerName);
			resourceConf.setReplicas(numReplicas);
			resourceConf.setSchedulerConfiguration(selectedConf);
			IActiveResource resource = ISchedulingFactory.eINSTANCE
					.createActiveResource(resourceConf);
			addResourceSensors(resource);
			return resource;
		}
		return null;
	}
	
	private void addResourceSensors(IActiveResource resource) {
		UtilisationSensor utilisationSensor = new UtilisationSensor(this.getModel());
		((SimActiveResource) resource).addObserver(utilisationSensor);
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
				createSimProcessorSharingResource(SchedulingStrategy.PROCESSOR_SHARING.toString(), getNextResourceId(), numberOfCores);
			break;
		case DELAY:
			scheduledResource = ISchedulingFactory.eINSTANCE.
				createSimDelayResource(SchedulingStrategy.DELAY.toString(), getNextResourceId());
			break;
		// active resources scheduled by improved scheduler
		case LINUX_2_6_O1:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Linux 2.6.22", numberOfCores);
			break;
		case LINUX_2_6_CFS:
			scheduledResource = ISchedulingFactory.eINSTANCE.createSimProcessorSharingResource(SchedulingStrategy.LINUX_2_6_CFS.toString(), getNextResourceId(), numberOfCores);
			break;
		case WINDOWS_7:
			// Windows 7, Windows Vista and Windows Server 2003 share the same scheduler
		case WINDOWS_VISTA:
		case WINDOWS_SERVER_2003:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Windows 2003", numberOfCores);
			break;
		case WINDOWS_XP:
			scheduledResource = getResource(PATHMAP_TO_SCHEDULER_LIBRARY, "Windows XP", numberOfCores);
			break;
		case SPECIAL_WINDOWS:
			scheduledResource = ISchedulingFactory.eINSTANCE.createSimProcessorSharingResourceWindows(SchedulingStrategy.SPECIAL_WINDOWS.toString(), getNextResourceId(), numberOfCores);
			break;
		case SPECIAL_LINUXO1:
			scheduledResource = ISchedulingFactory.eINSTANCE.createSimProcessorSharingResourceLinuxO1(SchedulingStrategy.SPECIAL_LINUXO1.toString(), getNextResourceId(), numberOfCores);
			break;
		}
		
		return scheduledResource;
	}
	
	private void registerProcessWindows(ISchedulableProcess process,
			IActiveResource resource) {
		if (resourceConf != null) {
			ProcessConfiguration processConf = ConfigurationFactory.eINSTANCE
					.createProcessConfiguration();
			processConf.setName(process.getId());
			processConf.setPriority(PriorityClass.DEFAULT);
			processConf.setReplicas(1);
			ProcessWithPriority p = (ProcessWithPriority) ISchedulingFactory.eINSTANCE
					.createRunningProcess(process, processConf, resourceConf);
			
			resource.registerProcess(p);
		}
	}
	
	@Override
	protected double calculateDemand(double demand) {
		return demand/(Double)Context.evaluateStatic(
				processingRate,Double.class);
	}

	@Override
	public void activateResource() {
		aResource.start();
	}

	@Override
	public void consumeResource(SimProcess process, double abstractDemand) {
		registerProcessWindows(process, aResource);
		double concreteDemand = calculateDemand(abstractDemand);
		this.demandedTimeSensor.record(concreteDemand);
		aResource.process(process, concreteDemand);
	}

	@Override
	public void deactivateResource() {
		aResource.stop();
	}

	public static String getNextResourceId() {
		return Long.toString(resourceId++);
	}

	@Override
	public IActiveResource getScheduledResource() {
		return aResource;
	}
}

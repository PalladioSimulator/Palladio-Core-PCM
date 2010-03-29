package de.uka.ipd.sdq.scheduler;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.ProcessConfiguration;

public interface ISchedulingFactory {
	
	public static ISchedulingFactory eINSTANCE = new SchedulingFactory();
	
	public IActiveResource createSimFCFSResource(String resourceName, String resourceId);
	
	public IActiveResource createSimDelayResource(String resourceName, String resourceId);
	
	public IActiveResource createSimProcessorSharingResource(String resourceName, String resourceId);
	
	public IActiveResource createSimProcessorSharingResourceWindows(String resourceName, String resourceId, int numberOfCores);

	public abstract IActiveResource createActiveResource(
			ActiveResourceConfiguration configuration);

	public abstract IPassiveResource createPassiveResource(
			PassiveResourceConfiguration configuration);

	public abstract IRunningProcess createRunningProcess(
			ISchedulableProcess process, ProcessConfiguration process_configuration,
			ActiveResourceConfiguration resource_configuration);

	public abstract void resetFactory();
}
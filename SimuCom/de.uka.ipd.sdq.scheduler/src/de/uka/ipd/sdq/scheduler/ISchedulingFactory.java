package de.uka.ipd.sdq.scheduler;


public interface ISchedulingFactory {
	
	// Retrieves a scheduler implementation from a registered extension
	// for the scheduler extension point.
	public IActiveResource createResourceFromExtension(String extensionId, String resourceId, int numberOfCores);
	
	public IActiveResource createSimFCFSResource(String resourceName, String resourceId);
	
	public IActiveResource createSimDelayResource(String resourceName, String resourceId);
	
	//public IActiveResource createSimGinpexDiskResource(String resourceName, String resourceId, HDDParameterConfig hddParameterConfig);
	
	public IActiveResource createSimProcessorSharingResource(String resourceName, String resourceId, int numberOfCores);
	public IActiveResource createSimProcessorSharingResourceWindows(String resourceName, String resourceId, int numberOfCores);
	public IActiveResource createSimProcessorSharingResourceLinuxO1(String resourceName, String resourceId, int numberOfCores);

	//public abstract IActiveResource createActiveResource(ActiveResourceConfiguration configuration);

	//public abstract IPassiveResource createPassiveResource(PassiveResourceConfiguration configuration);

	//public abstract IRunningProcess createRunningProcess(ISchedulableProcess process, ProcessConfiguration process_configuration, ActiveResourceConfiguration resource_configuration);

	public abstract void resetFactory();
}
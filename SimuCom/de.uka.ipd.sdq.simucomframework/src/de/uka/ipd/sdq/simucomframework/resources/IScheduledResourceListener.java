package de.uka.ipd.sdq.simucomframework.resources;

public interface IScheduledResourceListener {

	public void jobArrived(JobAndDemandStruct job);
	
	public void jobDone(JobAndDemandStruct job);
	
}

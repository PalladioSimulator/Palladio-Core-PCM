package de.uka.ipd.sdq.probespec.framework.garbagecollection;


public interface IRegionBasedGarbageCollector<T> {
	
	public void enterRegion(T regionId);
	
	public void leaveRegion(T regionId);
	

}

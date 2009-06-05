package de.uka.ipd.sdq.simucomframework.exceptions;

public class ResourceContainerIsMissingRequiredResourceType extends RuntimeException {
	
	public ResourceContainerIsMissingRequiredResourceType(String typeID){
		super("ResourceContainer is missing resource required "+
				"by a Component running on it. ID of missing resource "+typeID);
	}

}

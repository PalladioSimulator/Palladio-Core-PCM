package de.uka.ipd.sdq.simucomframework.exceptions;

public class ResourceContainerIsMissingRequiredResourceType extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8979174328859054856L;

	public ResourceContainerIsMissingRequiredResourceType(String typeID){
		super("ResourceContainer is missing resource required "+
				"by a Component running on it. ID of missing resource "+typeID);
	}

}

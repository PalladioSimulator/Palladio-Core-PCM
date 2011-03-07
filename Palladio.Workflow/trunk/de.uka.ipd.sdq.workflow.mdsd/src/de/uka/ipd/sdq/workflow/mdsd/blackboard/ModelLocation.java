package de.uka.ipd.sdq.workflow.mdsd.blackboard;

import org.eclipse.emf.common.util.URI;

/**
 * Immutable class used to uniquely identify a model (aka a resouce) on a MDSD blackboard 
 * @author Steffen Becker
 */
public class ModelLocation {
	private final String partitionID;
	private final URI modelID;
	
	/** Constructor
	 * @param partitionID The ID of the blackboard partition containing the model
	 * @param modelID The URI of the model (the normalized URI is used to identify the model in a partition)
	 */
	public ModelLocation(String partitionID, URI modelID) {
		super();
		this.partitionID = partitionID;
		this.modelID = modelID;
	}
	/**
	 * @return the partitionID
	 */
	public String getPartitionID() {
		return partitionID;
	}
	/**
	 * @return the modelID
	 */
	public URI getModelID() {
		return modelID;
	}
}

package de.uka.ipd.sdq.workflow;

/**
 * Interface of a blackboard as defined in POSA I. See also class Blackboard for further information.
 * @author Steffen
 * @param <T> The type of the data stored in the blackboard
 */
public interface IBlackboard<T> {
	/**
	 * Retrieve a named partition from this blackboard. The partition has to exist on the 
	 * blackboard
	 * @param id ID of the partition to retrieve
	 * @return The requested partition
	 */
	public T getPartition(String id);
	
	/**
	 * Add a new partition to this blackboard. The partition is required to not exist before.
	 * @param id The ID of the partition to add
	 * @param newPartition The partition to add
	 */
	public void addPartition(String id, T newPartition);
	
	/**
	 * Query the blackboard for a named partition
	 * @param id The ID of the named partition
	 * @return true if the partition exists on the blackboard
	 */
	public boolean hasPartition(String id);
	
	/**
	 * Remove a named partition from the blackboard
	 * @param id ID of the partition to removeS
	 */
	public void removePartition(String id);
}

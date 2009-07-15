package de.uka.ipd.sdq.workflow;

/**
 * Interface of a job which needs access to a certain type of blackboard to retrieve or store data
 * @author Steffen
  * @param <BlackboardType> Type of the blackboard which is needed by this job
 */
public interface IBlackboardInteractingJob<BlackboardType extends Blackboard<?>> extends IJob {
	/**
	 * Sets the blackboard of this job to the given blackboard
	 * @param blackboard The blackboard to be used by this job
	 */
	public void setBlackboard(BlackboardType blackboard);
}

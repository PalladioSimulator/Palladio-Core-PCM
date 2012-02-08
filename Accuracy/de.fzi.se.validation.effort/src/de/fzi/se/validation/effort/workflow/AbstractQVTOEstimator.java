/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.validation.effort.IEstimator;
import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

/**Validation effort estimation algorithm for jobs using QVT Operational scripts.
 * @see AbstractEstimateQVTO
 *
 * @author groenda
 *
 */
public abstract class AbstractQVTOEstimator extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements IEstimator {
	/** Name of the criterion which is estimated by this class. */
	public static final String CRITERION_NAME = "NOT/AVAILABLE";

	/** Job for estimation algorithm. */
	private AbstractEstimateQVTO estimator = null;

	/**Initializes all jobs which need to run for the estimation.
	 */
	public AbstractQVTOEstimator() {
		super();
		estimator = createEstimateJob();
		this.add(new PrepareEstimatorPartitions());
		additionalPreparationJobs(this);
		this.add(estimator);
	}

	/**Template method allowing to add individual preparation jobs (if required).
	 * Use the provided instance to add the jobs.
	 * @param self Composite job class.
	 */
	protected abstract void additionalPreparationJobs(AbstractQVTOEstimator self);

	/**
	 * @return The estimation job itself.
	 */
	protected abstract AbstractEstimateQVTO createEstimateJob();

	@Override
	public final void buildAndSetCustomConfiguration(
			ILaunchConfiguration configuration) {
		estimator.buildAndSetCustomConfiguration(configuration);
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#getCriterionName()
	 */
	public abstract String getCriterionName();

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#getNumberTestcases()
	 */
	public final EffortEstimationResult getEstimation() {
		return estimator.getEstimation();
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.IEstimator#setConfiguration(de.fzi.se.validation.effort.workflow.EstimatorConfiguration)
	 */
	public final void setConfiguration(EstimatorConfiguration estimatorConfiguration) {
		estimator.setConfiguration(estimatorConfiguration);
	}

	/**
	 * @return The estimator job
	 */
	protected AbstractEstimateQVTO getEstimator() {
		return estimator;
	}
}

package de.fzi.se.validation.effort.modifiedconditiondecisiontests;

import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.AbstractQVTOEstimator;
import de.fzi.se.validation.effort.workflow.RunEstimationsJob;
/**Validation effort estimation algorithm CModifiedConditionDecisionTests.
 * IEstimator interface is needed so that this estimator can be called by
 * the estimation job ({@link RunEstimationsJob}.
 * @author Martin Krogmann *
 */
public class CModifiedConditionDecisionTestsEstimator extends AbstractQVTOEstimator {
	/** Name of the criterion which is estimated. */
	public static final String CRITERION_NAME = "Modified Condition Decision";

	/** {@inheritDoc} */
	@Override
	protected void additionalPreparationJobs(AbstractQVTOEstimator self) {
		// nothing to do here
	}

	/** {@inheritDoc} */
	@Override
	protected AbstractEstimateQVTO createEstimateJob() {
		return new EstimateCModifiedConditionDecisionTests();
	}

	/** {@inheritDoc} */
	@Override
	public String getCriterionName() {
		return CRITERION_NAME;
	}

}

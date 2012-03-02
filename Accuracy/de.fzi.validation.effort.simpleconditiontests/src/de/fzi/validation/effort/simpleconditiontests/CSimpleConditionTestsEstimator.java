package de.fzi.validation.effort.simpleconditiontests;

import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.AbstractQVTOEstimator;
import de.fzi.se.validation.effort.workflow.RunEstimationsJob;
/**Validation effort estimation algorithm CSimpleConditionTests.
 * IEstimator interface is needed so that this estimator can be called by 
 * the estimation job ({@link RunEstimationsJob}.
 * @author Martin Krogmann *
 */
public class CSimpleConditionTestsEstimator extends AbstractQVTOEstimator {
	/** Name of the criterion which is estimated. */
	public static final String CRITERION_NAME = "CSimpleConditionTests";

	/** {@inheritDoc} */
	@Override
	protected void additionalPreparationJobs(AbstractQVTOEstimator self) {
		// nothing to do here
	}

	/** {@inheritDoc} */
	@Override
	protected AbstractEstimateQVTO createEstimateJob() {
		return new EstimateCSimpleConditionTests();
	}

	/** {@inheritDoc} */
	@Override
	public String getCriterionName() {
		return CRITERION_NAME;
	}

}

/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsEffortEstimationResult;
import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.AbstractQVTOEstimator;


/**Validation effort estimation algorithm using QVT Operational scripts and {@link AbstractEstimateQVTO} jobs.
 *
 * @author groenda
 *
 */
public class JJnPathsLowerBoundEstimator extends AbstractQVTOEstimator {
	/** Name of the criterion which is estimated. */
	public static final String CRITERION_NAME = "JJn-Paths (Lower Bound)";

	public JJnPathsLowerBoundEstimator() {
		super();
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.jjnpaths.AbstractQVTOEstimator#createEstimateJob()
	 */
	protected AbstractEstimateQVTO createEstimateJob() {
		 return new EstimateJJnPathsLowerBound();
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.jjnpaths.AbstractQVTOEstimator#additionalPreparationJobs(de.fzi.se.validation.effort.jjnpaths.AbstractQVTOEstimator)
	 */
	@Override
	protected void additionalPreparationJobs(AbstractQVTOEstimator self) {
		self.add(new PrepareJJnPathsEstimatorPartitions());
	}

	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.jjnpaths.AbstractQVTOEstimator#getCriterionName()
	 */
	@Override
	public String getCriterionName() {
		if (getEstimation() != null) {
			return CRITERION_NAME.replace("JJn", "JJ" + Integer.toString(((JJnPathsEffortEstimationResult)getEstimation()).getN()));
		} else {
			return CRITERION_NAME;
		}
	}
}

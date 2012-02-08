/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPathsEffortEstimationResult;
import de.fzi.se.validation.effort.workflow.AbstractEstimateQVTO;
import de.fzi.se.validation.effort.workflow.AbstractQVTOEstimator;

/**Validation effort estimation algorithm for the lower bound of JJn-Paths.
 *
 * @author groenda
 *
 */
public class JJnPathsUpperBoundEstimator extends AbstractQVTOEstimator {
	/** Name of the criterion which is estimated by this class. */
	public static final String CRITERION_NAME = "JJn-Paths (Upper Bound)";

	@Override
	public String getCriterionName() {
		if (getEstimation() != null) {
			return CRITERION_NAME.replace("JJn", "JJ" + Integer.toString(((JJnPathsEffortEstimationResult)getEstimation()).getN()));
		} else {
			return CRITERION_NAME;
		}
	}

	@Override
	protected void additionalPreparationJobs(AbstractQVTOEstimator self) {
		self.add(new PrepareJJnPathsEstimatorPartitions());
	}

	@Override
	protected AbstractEstimateQVTO createEstimateJob() {
		return new EstimateJJnPathsUpperBound();
	}
}

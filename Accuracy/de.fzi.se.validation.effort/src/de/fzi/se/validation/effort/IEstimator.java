/**
 *
 */
package de.fzi.se.validation.effort;

import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.validation.effort.workflow.EstimatorConfiguration;
import de.uka.ipd.sdq.workflow.IJob;

/**Interface for validation effort estimation algorithms.
 * @author Henning Groenda
 *
 */
public interface IEstimator extends IJob {

	/** @returns Estimation on the number of test cases necessary to cover the specification with respect to the criterion. */
	public Long getNumberTestcases();

	/** @returns Name of the criterion for which the estimation is provided. */
	public String getCriterionName();

	/**Builds the configuration which belongs to an estimator.
	 * This configuration is then set as configuration of this job in order to make all parameters available during processing.
	 * @param configuration The launch configuration from which the specific configuration is build.
	 */
	public void buildAndSetCustomConfiguration(ILaunchConfiguration configuration);

	/** Sets the generic estimator configuration.
	 * @param estimatorConfiguration The generic configuration.
	 */
	public void setConfiguration(EstimatorConfiguration estimatorConfiguration);

}

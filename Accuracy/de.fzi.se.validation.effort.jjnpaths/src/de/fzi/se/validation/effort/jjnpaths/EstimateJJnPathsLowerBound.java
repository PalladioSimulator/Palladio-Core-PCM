/**
 *
 */
package de.fzi.se.validation.effort.jjnpaths;

import org.eclipse.core.runtime.IProgressMonitor;

import de.fzi.se.controlflowdescription.jjnpaths.JJnPath;
import de.fzi.se.controlflowdescription.jjnpaths.JJnPathTestSuite;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

/**Validation effort estimation algorithm for the lower bound of JJn-Paths.
 *
 * @author groenda
 *
 */
public class EstimateJJnPathsLowerBound extends AbstractEstimateJJnPaths {
	/** Name of this estimation job. */
	private static final String NAME = "Estimate JJnPaths Lower Bound Job";

	/** Operational QVT transformation script URI which transforms {@link JJnPath} to {@link JJnPathTestSuite}. */
	protected static final String JJNPATHS_2_LOWER_BOUND_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.qvtoscripts/transforms/JJnPaths2LowerBoundEstimation.qvto";

	@Override
	public String getName() {
		return NAME;
	}

	@Override
	protected void executeScript(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		super.executeScript(monitor);
		executeStep(monitor, new ModelLocation[] {cfdModelLocation, resultModelLocation}, JJNPATHS_2_LOWER_BOUND_SCRIPT);
	}
}

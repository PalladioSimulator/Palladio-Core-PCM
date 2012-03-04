package de.fzi.validation.effort.spttests;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.ModelLocation;

/**
 * Validation effort estimation algorithm CSPTTests.
 * @author Martin Krogmann
 *
 */
public class EstimateCSPTTests  extends AbstractEstimateSPT {

	/** Operational QVT transformation script URI which transforms {@link ResourceDemandingBehaviour} to {@link SPTEffortEstimationResult}. */
	protected static final String TRANSFORMATION_SCRIPT = "platform:/plugin/de.fzi.se.validation.effort.qvtoscripts/transforms/behaviour2CSPTTestsEffortEstimationResult.qvto";

	protected ILaunchConfiguration configuration = null;
	
	/* (non-Javadoc)
	 * @see de.fzi.se.validation.effort.jjnpaths.AbstractEstimateQVTO#executeScript(org.eclipse.core.runtime.IProgressMonitor)
	 */
	protected void executeScript(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		executeStep(monitor, new ModelLocation[] {targetBehaviour, resultModelLocation}, TRANSFORMATION_SCRIPT);
	}
}

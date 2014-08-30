package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;

/**
 * This class extends a SimuCom job description with reliability aspects.
 */
public class ReliabilityExtensionJob extends AbstractSimuComExtensionJob {

    @Override
    public final void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
        ReliabilityExtensionJobConfiguration configuration = (ReliabilityExtensionJobConfiguration) getJobConfiguration();
        if (configuration.isSimulateFailures()) {
            addCodeGenerationAdvice("simulation_template_methods_reliability");
        }
        System.out.println("YES!!!");
    }
}

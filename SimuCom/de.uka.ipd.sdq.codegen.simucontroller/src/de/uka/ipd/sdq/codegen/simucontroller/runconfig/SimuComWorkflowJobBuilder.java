/**
 *
 */
package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SensitivityAnalysisJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.PCMWorkflowJobBuilder;

/**
 * Builder for SimuComJobs.
 * 
 * @author groenda
 */
public class SimuComWorkflowJobBuilder extends PCMWorkflowJobBuilder {
    /** Logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(SimuComWorkflowJobBuilder.class);

    /** Debug listener for created SimuCom job. */
    private IDebugListener listener;

    public SimuComWorkflowJobBuilder(IDebugListener listener) {
        this.listener = listener;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.workflow.pcm.jobs.PCMWorkflowJobBuilder#buildJob(de.uka.ipd.sdq.workflow.pcm
     * .configurations.AbstractPCMWorkflowRunConfiguration)
     */
    @Override
    public IJob buildJob(AbstractPCMWorkflowRunConfiguration config) {
        try {
            return new SensitivityAnalysisJob((SimuComWorkflowConfiguration) config, listener);
        } catch (CoreException e) {
            if (LOGGER.isEnabledFor(Level.ERROR))
                LOGGER.error("Core exception occured when building SensitivityAnalysisJob.", e);
            return null;
        }
    }

}

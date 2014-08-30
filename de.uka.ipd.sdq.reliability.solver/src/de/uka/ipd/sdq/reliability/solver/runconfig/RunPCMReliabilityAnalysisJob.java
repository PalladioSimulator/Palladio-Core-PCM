package de.uka.ipd.sdq.reliability.solver.runconfig;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Controls the PCM Reliability Solver process when launched from the eclipse UI.
 * 
 * @author brosch,
 * 
 */
public class RunPCMReliabilityAnalysisJob implements IBlackboardInteractingJob<MDSDBlackboard> {

    /**
     * Enables log4j logging for this class.
     */
    private static final Logger LOGGER = Logger.getLogger(RunPCMReliabilityAnalysisJob.class.getName());

    /**
     * Blackboard for passing EMF model resources between jobs in the workflow.
     */
    private MDSDBlackboard blackboard;

    /**
     * The strategy for reliability modelling & transformation.
     */
    private Pcm2MarkovStrategy strategy;

    /**
     * The constructor.
     * 
     * Configures the PCM Solver process according to the launch configuration defined by the user.
     * 
     * @param configuration
     *            the solver configuration object
     */
    public RunPCMReliabilityAnalysisJob(final PCMSolverWorkflowRunConfiguration configuration) {

        // Configure the PCM Solver process:
        PDFConfiguration.setCurrentConfiguration(configuration.getDomainSize(), configuration.getDistance(),
                IProbabilityFunctionFactory.eINSTANCE.createDefaultUnit());
        if (configuration.isReliabilityAnalysis()) {
            strategy = new Pcm2MarkovStrategy(configuration);
        } else {
            throw new RuntimeException("Invoked reliability analysis with incompatible configuration data!");
        }
    }

    /**
     * Executes the Solver workflow.
     * 
     * @param monitor
     *            the progress monitor
     * @throws JobFailedException
     *             indicates that one of the jobs in the workflow was not successfully completed
     * @throws UserCanceledException
     *             indicates that the user has canceled the workflow before completion
     */
    @Override
    public void execute(final IProgressMonitor monitor) throws JobFailedException, UserCanceledException {

        // Determine the PCM model parts from the launch configuration:
        PCMInstance currentModel = new PCMInstance(
                (PCMResourceSetPartition) this.blackboard
                        .getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));

        // Check the model for being valid:
        if (!currentModel.isValid()) {
            LOGGER.error("PCM Instance invalid! Check filenames.");
            return;
        }

        // Only a very coarse progress monitoring is supported, which assigns
        // 50% progress to the execution of the involved transformation(s), and
        // 50% to the final solving:
        monitor.beginTask("Analysis", 100);
        strategy.transform(currentModel);
        monitor.worked(50);
        strategy.solve();
        monitor.worked(50);
    }

    @Override
    public String getName() {
        return "Run PCM Reliability Analysis";
    }

    public SolverStrategy getStrategy() {
        return strategy;
    }

    @Override
    public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {
        // Nothing to do here
    }

    @Override
    public void setBlackboard(MDSDBlackboard blackboard) {
        this.blackboard = blackboard;
    }
}

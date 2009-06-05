package de.uka.ipd.sdq.pcmsolver;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2regex.Pcm2RegExStrategy;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.PDFConfiguration;
import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * The central class that controls the PCM Solver process when launched from the
 * eclipse UI.
 * 
 * @author koziolek, brosch, becker
 * 
 */
public class RunPCMAnalysisJob implements IBlackboardInteractingJob<MDSDBlackboard> {

	/**
	 * Enables log4j logging for this class.
	 */
	private static Logger logger = Logger.getLogger(RunPCMAnalysisJob.class.getName());

	/**
	 * Configuration details constant.
	 */
	private static final int DOMAINSIZEDEFAULT = 32;

	/**
	 * Configuration details constant.
	 */
	private static final double DISTANCEDEFAULT = 1.0;

	/**
	 * Indicates the actual type of the PCM solving process. The user can choose
	 * between different types through the launch configuration.
	 */
	private SolverStrategy strategy;

	private MDSDBlackboard blackboard;

	private ILaunchConfiguration configuration;

	/**
	 * The constructor.
	 * 
	 * Configures the PCM Solver process according to the launch configuration
	 * defined by the user.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param monitor
	 *            the progress monitor
	 * @param reliability
	 *            enables reliability analysis
	 */
	public RunPCMAnalysisJob(final ILaunchConfiguration configuration, final boolean reliability) {

		this.configuration = configuration;
		
		// Determine configuration details:
		int domainSize = DOMAINSIZEDEFAULT;
		double distance = DISTANCEDEFAULT;
		String solver = MessageStrings.SRE_SOLVER;
		try {
			domainSize = Integer.parseInt(configuration.getAttribute(
					MessageStrings.MAX_DOMAIN, "" + DOMAINSIZEDEFAULT));
			distance = Double.parseDouble(configuration.getAttribute(
					MessageStrings.SAMPLING_DIST, "" + DISTANCEDEFAULT));
			solver = configuration.getAttribute(MessageStrings.SOLVER,
					MessageStrings.SRE_SOLVER);
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// Configure the PCM Solver process:
		PDFConfiguration.setCurrentConfiguration(domainSize, distance,
				IProbabilityFunctionFactory.eINSTANCE.createDefaultUnit());
		if (reliability) {
			strategy = new Pcm2MarkovStrategy(configuration);
		} else if (solver.equals(MessageStrings.SRE_SOLVER)) {
			strategy = new Pcm2RegExStrategy();
		} else if (solver.equals(MessageStrings.LQNS_SOLVER)) {
			strategy = new Pcm2LqnStrategy(configuration);
		} else if (solver.equals(MessageStrings.LQSIM_SOLVER)) {
			strategy = new Pcm2LqnStrategy(configuration);
		}
	}

	/**
	 * The constructor with default value for reliability (FALSE).
	 * 
	 * This constructor is maintained for being downwards compatible with the
	 * former PCM Solver version, which did not support reliability analysis.
	 * 
	 * @param configuration
	 *            the launch configuration
	 * @param monitor
	 *            the progress monitor
	 */
	public RunPCMAnalysisJob(final ILaunchConfiguration configuration,
			final IProgressMonitor monitor) {
		this(configuration, false);
	}

	/**
	 * Executes the PCM Solver process.
	 */
	public void execute(IProgressMonitor monitor) throws JobFailedException,
		UserCanceledException {

		// Determine the PCM model parts from the launch configuration:
		PCMInstance currentModel = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		
		// Check the model for being valid:
		if (!currentModel.isValid()) {
			logger.error("PCM Instance invalid! Check filenames.");
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

	public SolverStrategy getStrategy() {
		return strategy;
	}

	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	public String getName() {
		return "Run PCM Analysis";
	}

	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
		// Nothing to do here
	}
}

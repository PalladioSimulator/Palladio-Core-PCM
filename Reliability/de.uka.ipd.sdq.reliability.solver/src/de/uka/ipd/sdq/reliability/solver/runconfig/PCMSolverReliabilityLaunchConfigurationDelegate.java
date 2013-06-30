package de.uka.ipd.sdq.reliability.solver.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.fzi.se.accuracy.jobs.AccuracyInfluenceAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;

/**
 * Launches the PCM Solver for Reliability analysis.
 * 
 * The extension point org.eclipse.debug.core.launchConfigurationTypes in the plugin.xml refers to
 * this class. The class inherits from the eclipse-internal launch configuration delegate.
 * 
 * @author anne
 * 
 */
public class PCMSolverReliabilityLaunchConfigurationDelegate extends PCMSolverLaunchConfigurationDelegate {

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate
     * #createWorkflowJob (de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration,
     * org.eclipse.debug.core.ILaunch)
     */
    protected IJob createWorkflowJob(PCMSolverWorkflowRunConfiguration config, ILaunch launch) throws CoreException {

        // To enable accuracy analysis, the former top-level job
        // (PCMSolverReliabilityJob)
        // is replaced through a new AccuracyInfluenceAnalysisJob:
        ReliabilityWorkflowJobBuilder jobBuilder = new ReliabilityWorkflowJobBuilder(launch);
        return new AccuracyInfluenceAnalysisJob(config, jobBuilder);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate
     * #deriveConfiguration(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String)
     */
    protected PCMSolverWorkflowRunConfiguration deriveConfiguration(ILaunchConfiguration configuration, String mode)
            throws CoreException {

        // First derive a configuration with general attributes for the PCM
        // Solver workflow:
        PCMSolverWorkflowRunConfiguration solverConfiguration = super.deriveConfiguration(configuration, mode);

        // Then, derive attributes specific to reliability solving:
        PCMSolverReliabilityConfigurationBasedConfigBuilder builder = new PCMSolverReliabilityConfigurationBasedConfigBuilder(
                configuration, mode);
        builder.fillConfiguration(solverConfiguration);

        return solverConfiguration;
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate
     * #setupLogging(org.apache.log4j.Level)
     */
    protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
        ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
        loggerList.add(setupLogger("de.uka.ipd.sdq.reliability", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.markov", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN
                : SHORT_LOG_PATTERN));

        return loggerList;
    }
}

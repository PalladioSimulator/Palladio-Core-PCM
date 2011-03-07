package de.uka.ipd.sdq.simulation.controller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowLauncher;
import de.uka.ipd.sdq.simulation.controller.workflow.jobs.EventSimJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

/**
 * 
 * TODO describe class
 * 
 * This class is based on {@link SimuComWorkflowLauncher}. Some code has been reused.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimWorkflowLauncher extends AbstractPCMLaunchConfigurationDelegate<EventSimWorkflowConfiguration> {

    @Override
    protected IJob createWorkflowJob(EventSimWorkflowConfiguration config, ILaunch launch) throws CoreException {
        IDebugListener listener = null;
        if (config.isDebug()) {
            listener = new SimulationDebugListener(launch);
        }

        // TODO allow for sensitivity analysis. See class SimuComWorkflowLauncher

        return new EventSimJob(config, listener);
    }

    @Override
    protected EventSimWorkflowConfiguration deriveConfiguration(ILaunchConfiguration configuration, String mode)
            throws CoreException {
        EventSimWorkflowConfiguration config = new EventSimWorkflowConfiguration();

        AbstractWorkflowConfigurationBuilder builder;
        builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
        builder.fillConfiguration(config);

        builder = new EventSimLaunchConfigurationBasedConfigBuilder(configuration, mode);
        builder.fillConfiguration(config);

        return config;
    }

    /*
     * copied from class SimuComWorflowLauncher
     */
    @Override
    protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
        ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
        loggerList.add(setupLogger("de.uka.ipd.sdq.codegen", logLevel, 
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.simucomframework", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.workflow.mdsd.emf.qvtr", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.statistics", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.probespec.framework", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        loggerList.add(setupLogger("de.uka.ipd.sdq.simulation", logLevel,
                Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
        
        return loggerList;
    }

}

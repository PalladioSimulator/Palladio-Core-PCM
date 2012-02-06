package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.logging.console.LoggerAppenderStruct;

public interface ISimulationWorkflowLauncher {
    
    public AbstractPCMCompletionWorkflowRunConfiguration deriveConfiguration(ILaunchConfiguration configuration, String mode) throws CoreException;
    
    public ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException;
    
    public IJob createWorkflowJob(AbstractPCMCompletionWorkflowRunConfiguration config, ILaunch launch) throws CoreException;
    
}

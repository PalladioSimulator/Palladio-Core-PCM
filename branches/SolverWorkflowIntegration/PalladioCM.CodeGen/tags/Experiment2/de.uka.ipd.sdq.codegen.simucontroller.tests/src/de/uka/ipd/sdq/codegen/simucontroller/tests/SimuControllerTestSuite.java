package de.uka.ipd.sdq.codegen.simucontroller.tests;

import java.io.PrintWriter;
import java.io.StringWriter;

import junit.framework.Assert;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.junit.Test;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuControllerTestSuite {

	public static final String ID_SIMUCOM_LAUNCH = "de.uka.ipd.sdq.simucontroller.SimuLaunching";

	// A test of all SimuCom Launch Configs in the workspace. We are not
	// expecting any exceptions during the execution
	@Test
	public void RunSimuComLaunchConfigs() throws CoreException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type =
		      manager.getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);
		ILaunchConfiguration[] configurations =
		      manager.getLaunchConfigurations(type);
		for (ILaunchConfiguration config : configurations) {
			try {
				ILaunchConfigurationWorkingCopy copy = config.copy("Test Suite Launcher");
				copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, true);
				copy.launch(ILaunchManager.RUN_MODE,new NullProgressMonitor()); 		
			}catch(CoreException ex){
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				Assert.fail(config.getName()+"failed: "+ex.getMessage()+"\n"+sw.toString());
			}
		}
	}
}

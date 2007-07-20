package de.uka.ipd.sdq.codegen.simucontroller.tests;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

import junit.framework.Assert;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.junit.Test;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ModelsFileNameInputTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ResourceManagerTab;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class SimuControllerTestSuite {

	public static final String ID_SIMUCOM_LAUNCH = "de.uka.ipd.sdq.simucontroller.SimuLaunching";

	/**
	 * A test of all SimuCom Launch Configs in the workspace. We are not
	 * expecting any exceptions during the execution
	 */
	@Test
	public void RunSimuComLaunchConfigs() throws CoreException {
		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);
		ILaunchConfiguration[] configurations = manager
				.getLaunchConfigurations(type);

		for (ILaunchConfiguration config : configurations) {
			try {
				ILaunchConfigurationWorkingCopy copy = config
						.copy("Test Suite Launcher");
				copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, true);
				copy.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
			} catch (CoreException ex) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				ex.printStackTrace(pw);
				Assert.fail(config.getName() + "failed: " + ex.getMessage()
						+ "\n" + sw.toString());
			}
		}
	}
	
	
	/**
	 * A test of example SimuCom LaunchConfigs in the workspace. We are not
	 * expecting any exceptions during the execution
	 */
	@Test
	public void RunSimuComLaunch_QoSA2007_MediaStore() throws CoreException {

		String DIR_NAME = "QoSA2007_MediaStore";

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);

		IContainer container = ResourcesPlugin.getWorkspace().getRoot();

		ILaunchConfigurationWorkingCopy copy = type.newInstance(container,
				DIR_NAME);
		
		copy.setAttribute(ResourceManagerTab.ALLOCATION_FILE,
				getModelsFilePath(DIR_NAME,
						ModelsFileNameInputTab.ALLOCATION_EXTENSION[0]));
		
		copy.setAttribute(ResourceManagerTab.REPOSITORY_FILE,
				getModelsFilePath(DIR_NAME,
						ModelsFileNameInputTab.REPOSITORY_EXTENSION[0]));
		
		copy.setAttribute(ResourceManagerTab.RESOURCETYPEREPOSITORY_FILE,
				getModelsFilePath(DIR_NAME,
						ModelsFileNameInputTab.RESOURCETYPE_EXTENSION[0]));
		
		copy.setAttribute(ResourceManagerTab.USAGE_FILE, getModelsFilePath(
				DIR_NAME, ModelsFileNameInputTab.USAGEMODEL_EXTENSION[0]));
		
		copy.setAttribute(ResourceManagerTab.SYSTEM_FILE, getModelsFilePath(
				DIR_NAME, ModelsFileNameInputTab.SYSTEM_EXTENSION[0]));
		
		copy.setAttribute(SimuComConfig.DATASOURCE_ID, 1);
		copy.setAttribute(SimuComConfig.SIMULATION_TIME, "1500");
		copy.setAttribute(SimuComConfig.EXPERIMENT_RUN, "MyRun");
		copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, true);
		copy.setAttribute(SimuComConfig.VERBOSE_LOGGING, false);
		copy.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());

	}
	
	
	private String getModelsFilePath(String dirName, String extension) {
		String dirPath = "";

		URL dir = FileLocator.find(Platform.getBundle(Activator.PLUGIN_ID),
				new Path(dirName), null);

		if (dir != null) {
			try {
				dir = FileLocator.resolve(dir);
				dirPath = dir.getPath().replaceFirst("/", "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String[] files = new File(dirPath).list();

		for (int i = 0; i < files.length; i++)
			if (files[i].contains(extension.replace("*", "")))
				return dirPath + files[i];

		return null;
	}
}

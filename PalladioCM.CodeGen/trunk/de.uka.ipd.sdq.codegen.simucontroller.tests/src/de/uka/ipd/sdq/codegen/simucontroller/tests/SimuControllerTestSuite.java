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

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
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
				copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);
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
	
	
	/** A test of example SimuCom LaunchConfigs -> QoSA2007_MediaStore */ 
	@Test
	public void RunSimuComLaunch_QoSA2007_MediaStore() throws CoreException {
		runSimuComLaunch("QoSA2007_MediaStore");
	}
	
	/** A test of example SimuCom LaunchConfigs -> QoSA2006_WebAudioStore */ 
	@Test
	public void RunSimuComLaunch_QoSA2006_WebAudioStore() throws CoreException {
		runSimuComLaunch("QoSA2006_WebAudioStore");
	}
	
	/** A test of example SimuCom LaunchConfigs -> ModelExample_QoSA06 */ 
	@Test
	public void RunSimuComLaunch_ModelExample_QoSA06() throws CoreException {
		runSimuComLaunch("ModelExample_QoSA06");
	}
	
	/** A test of example SimuCom LaunchConfigs -> PCMForkExample */ 
	@Test
	public void RunSimuComLaunch_PCMForkExample() throws CoreException {
		runSimuComLaunch("PCMForkExample");
	}
	
	/** A test of example SimuCom LaunchConfigs -> PCMSetVariableExample */ 
	@Test
	public void RunSimuComLaunch_PCMSetVariableExample() throws CoreException {
		runSimuComLaunch("PCMSetVariableExample");
	}
	
	/**
	 * A test of example SimuCom LaunchConfigs in the workspace. We are not
	 * expecting any exceptions during the execution
	 * 
	 * @param dir/model name
	 */
	private void runSimuComLaunch(String modelName) throws CoreException {

		ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
		ILaunchConfigurationType type = manager
				.getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);

		IContainer container = ResourcesPlugin.getWorkspace().getRoot();

		try {
			ILaunchConfigurationWorkingCopy copy = type.newInstance(container,
					modelName);

			copy.setAttribute(ConstantsContainer.ALLOCATION_FILE,
					getModelsFilePath(modelName,
							ConstantsContainer.ALLOCATION_EXTENSION[0]));

			copy.setAttribute(ConstantsContainer.REPOSITORY_FILE,
					getModelsFilePath(modelName,
							ConstantsContainer.REPOSITORY_EXTENSION[0]));

			copy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE,
					getModelsFilePath(modelName,
							ConstantsContainer.RESOURCETYPE_EXTENSION[0]));

			copy.setAttribute(ConstantsContainer.USAGE_FILE, getModelsFilePath(
					modelName, ConstantsContainer.USAGEMODEL_EXTENSION[0]));

			copy.setAttribute(ConstantsContainer.SYSTEM_FILE,
					getModelsFilePath(modelName,
							ConstantsContainer.SYSTEM_EXTENSION[0]));

			copy.setAttribute(SimuComConfig.DATASOURCE_ID, 1);
			copy.setAttribute(SimuComConfig.SIMULATION_TIME, "1500");
			copy.setAttribute(SimuComConfig.EXPERIMENT_RUN, "MyRun");
			copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, true);
			copy.setAttribute(SimuComConfig.VERBOSE_LOGGING, false);
			copy.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
		} catch (CoreException ex) {
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			ex.printStackTrace(pw);
			Assert.fail("Created config failed: " + ex.getMessage() + "\n"
					+ sw.toString());
		}
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

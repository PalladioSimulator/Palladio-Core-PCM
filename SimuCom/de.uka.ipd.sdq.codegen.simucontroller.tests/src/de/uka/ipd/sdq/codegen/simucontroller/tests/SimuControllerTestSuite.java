package de.uka.ipd.sdq.codegen.simucontroller.tests;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.Enumeration;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.debug.core.DebugPlugin;
import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.junit.Assert;
import org.junit.Test;
import org.palladiosimulator.recorderframework.sensorframework.SensorFrameworkRecorderConfiguration;
import org.palladiosimulator.recorderframework.sensorframework.SensorFrameworkRecorderConfigurationFactory;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

/**
 * 
 * @author ???; Sebastian Lehrig
 */
public class SimuControllerTestSuite {

    public static final String ID_SIMUCOM_LAUNCH = "de.uka.ipd.sdq.simucontroller.SimuLaunching";

    // /**
    // * A test of all SimuCom Launch Configs in the workspace. We are not
    // * expecting any exceptions during the execution
    // */
    // @Test
    // public void RunSimuComLaunchConfigs() throws CoreException {
    // DebugPlugin debugPlugin = DebugPlugin.getDefault();
    // ILaunchManager manager = debugPlugin.getLaunchManager();
    // ILaunchConfigurationType type = manager
    // .getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);
    // ILaunchConfiguration[] configurations = manager
    // .getLaunchConfigurations(type);
    //
    // for (ILaunchConfiguration config : configurations) {
    // try {
    // ILaunchConfigurationWorkingCopy copy = config
    // .copy("Test Suite Launcher");
    // copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);
    // copy.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());
    // } catch (CoreException ex) {
    // StringWriter sw = new StringWriter();
    // PrintWriter pw = new PrintWriter(sw);
    // ex.printStackTrace(pw);
    // Assert.fail(config.getName() + "failed: " + ex.getMessage()
    // + "\n" + sw.toString());
    // }
    // }
    // }

    /** A test of example MediaStore */
    @Test
    public void RunSimuComLaunch_MediaStore() {
        runSimuComLaunch("MediaStore");
    }

    // /** A test of example SimuCom LaunchConfigs -> QoSA2007_MediaStore */
    // @Test
    // public void RunSimuComLaunch_QoSA2007_MediaStore() throws CoreException {
    // runSimuComLaunch("QoSA2007_MediaStore");
    // }
    //
    // /** A test of example SimuCom LaunchConfigs -> QoSA2006_WebAudioStore */
    // @Test
    // public void RunSimuComLaunch_QoSA2006_WebAudioStore() throws CoreException {
    // runSimuComLaunch("QoSA2006_WebAudioStore");
    // }
    //
    // /** A test of example SimuCom LaunchConfigs -> ModelExample_QoSA06 */
    // @Test
    // public void RunSimuComLaunch_ModelExample_QoSA06() throws CoreException {
    // runSimuComLaunch("ModelExample_QoSA06");
    // }
    //
    // /** A test of example SimuCom LaunchConfigs -> PCMForkExample */
    // @Test
    // public void RunSimuComLaunch_PCMForkExample() throws CoreException {
    // runSimuComLaunch("PCMForkExample");
    // }
    //
    // /** A test of example SimuCom LaunchConfigs -> PCMSetVariableExample */
    // @Test
    // public void RunSimuComLaunch_PCMSetVariableExample() throws CoreException {
    // runSimuComLaunch("PCMSetVariableExample");
    // }

    /**
     * A test of example SimuCom LaunchConfigs in the workspace. We are not expecting any exceptions
     * during the execution
     * 
     * @param modelFolderName
     *            Name of the model folder within this plug-in.
     */
    private void runSimuComLaunch(final String modelFolderName) {

        final ILaunchManager manager = DebugPlugin.getDefault().getLaunchManager();
        final ILaunchConfigurationType type = manager
                .getLaunchConfigurationType(SimuControllerTestSuite.ID_SIMUCOM_LAUNCH);

        final IContainer container = ResourcesPlugin.getWorkspace().getRoot();

        try {
            final ILaunchConfigurationWorkingCopy copy = type.newInstance(container, modelFolderName);

            copy.setAttribute(ConstantsContainer.ALLOCATION_FILE,
                    getModelsFilePath(modelFolderName, ConstantsContainer.ALLOCATION_EXTENSION[0]));

            copy.setAttribute(ConstantsContainer.REPOSITORY_FILE,
                    getModelsFilePath(modelFolderName, ConstantsContainer.REPOSITORY_EXTENSION[0]));

            copy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE,
                    getModelsFilePath(modelFolderName, ConstantsContainer.RESOURCETYPE_EXTENSION[0]));

            copy.setAttribute(ConstantsContainer.USAGE_FILE,
                    getModelsFilePath(modelFolderName, ConstantsContainer.USAGEMODEL_EXTENSION[0]));

            copy.setAttribute(ConstantsContainer.SYSTEM_FILE,
                    getModelsFilePath(modelFolderName, ConstantsContainer.SYSTEM_EXTENSION[0]));

            copy.setAttribute(ConstantsContainer.MWREPOSITORY_FILE,
                    ConstantsContainer.DEFAULT_MIDDLEWARE_REPOSITORY_FILE);

            copy.setAttribute(ConstantsContainer.EVENT_MIDDLEWARE_REPOSITORY_FILE,
                    ConstantsContainer.DEFAULT_EVENT_MIDDLEWARE_FILE);

            copy.setAttribute(ConstantsContainer.TEMPORARY_DATA_LOCATION,
                    ConstantsContainer.DEFAULT_TEMPORARY_DATA_LOCATION);

            copy.setAttribute(ConstantsContainer.ACCURACY_QUALITY_ANNOTATION_FILE,
                    ConstantsContainer.DEFAULT_ACCURACY_QUALITY_ANNOTATION_FILE);

            copy.setAttribute(ConstantsContainer.FEATURE_CONFIG, ConstantsContainer.DEFAULT_FEATURE_CONFIGURATION_FILE);

            copy.setAttribute(SimuComConfig.PERSISTENCE_RECORDER_NAME, SensorFrameworkRecorderConfiguration.PERSISTENCE_RECORDER_ID);
            copy.setAttribute(SensorFrameworkRecorderConfigurationFactory.DATASOURCE_ID, 0);
            copy.setAttribute(SimuComConfig.MAXIMUM_MEASUREMENT_COUNT, "100");
            copy.setAttribute(SimuComConfig.USE_FIXED_SEED, Boolean.FALSE);
            copy.setAttribute(SimuComConfig.SIMULATION_TIME, "1500");
            copy.setAttribute(SimuComConfig.EXPERIMENT_RUN, "MyRun");
            copy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);
            copy.setAttribute(SimuComConfig.VERBOSE_LOGGING, false);
            copy.setAttribute(SimuComConfig.SIMULATOR_ID, SimuComConfig.DEFAULT_SIMULATOR_ID);
            copy.launch(ILaunchManager.RUN_MODE, new NullProgressMonitor());

        } catch (final Exception ex) {
            final StringWriter sw = new StringWriter();
            final PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            Assert.fail("Created config failed: " + ex.getMessage() + "\n" + sw.toString());
        }
    }

    private String getModelsFilePath(final String dirName, final String extension) {

        final Enumeration<URL> files = Platform.getBundle(Activator.PLUGIN_ID).findEntries(dirName, extension, true);
        if (files == null) {
            Assert.fail("Could not find a " + extension + " in " + dirName);
        }

        URL fileURL = files.nextElement();

        if (fileURL != null) {
            try {
                fileURL = FileLocator.resolve(fileURL);
                return fileURL.getPath();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}

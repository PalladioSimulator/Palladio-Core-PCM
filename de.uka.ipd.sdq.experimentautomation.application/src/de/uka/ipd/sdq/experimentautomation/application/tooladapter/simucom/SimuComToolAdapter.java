package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public class SimuComToolAdapter implements IToolAdapter {

    @Override
    public void runExperiment(String experimentName, PCMModelFiles model, ToolConfiguration configuration,
            List<StopCondition> stopConditions, ISimulationListener listener) throws CoreException {
        // create simulation configuration
        SimuComConfig simuComConfig = SimuComConfigFactory.createConfig((SimuComConfiguration) configuration, stopConditions, model,
                experimentName);
        simuComConfig.addListener(listener);

        // create workflow configuration
        SimuComWorkflowConfiguration workflowConfig = SimuComWorkflowConfigurationFactory.createWorkflowConfiguration(
                (SimuComConfiguration) configuration, model, simuComConfig);

        // run simulation
        final SimuComJob run = new SimuComJob(workflowConfig, null);
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(run,
                blackboard);
        workflow.run();
        
        // clean up TODO
        SensorFramework sensorFramework = (SensorFramework) ((SimuComConfiguration) configuration).getPersistenceFramework();
        SensorFrameworkDatasource datasource = sensorFramework.getDatasource();
        SensorFrameworkFactory.closeDatasource(datasource);
    }

}

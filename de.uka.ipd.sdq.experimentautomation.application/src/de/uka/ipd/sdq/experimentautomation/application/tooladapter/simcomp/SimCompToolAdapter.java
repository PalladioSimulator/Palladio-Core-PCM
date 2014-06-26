package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simcomp;

import java.util.List;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimCompConfiguration;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import edu.kit.ipd.sdq.simcomp.controller.runconfig.SimulationComponentWorkflowConfiguration;
import edu.kit.ipd.sdq.simcomp.controller.workflow.jobs.SimulationComponentJob;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

public class SimCompToolAdapter implements IToolAdapter {

	@Override
	public void runExperiment(String experimentName, PCMModelFiles model,
			ToolConfiguration configuration,
			List<StopCondition> stopConditions, ISimulationListener listener)
			throws Exception {
        // create simulation configuration
		SimulationConfiguration simConfig = SimCompConfigFactory.createConfig((SimCompConfiguration) configuration, stopConditions, model,
                experimentName);
        simConfig.addListener(listener);

        // create workflow configuration
        SimulationComponentWorkflowConfiguration workflowConfig = SimCompWorkflowConfigurationFactory
                .createWorkflowConfiguration((SimCompConfiguration) configuration, model, simConfig);

        // run simulations
        final SimulationComponentJob run = new SimulationComponentJob(workflowConfig, null);
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(run,
                blackboard);
        workflow.run();
        
        // clean up TODO
        SensorFramework sensorFramework = (SensorFramework) ((SimCompConfiguration) configuration).getPersistenceFramework();
        SensorFrameworkDatasource datasource = sensorFramework.getDatasource();
        SensorFrameworkFactory.closeDatasource(datasource);

	}

}

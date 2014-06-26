package de.uka.ipd.sdq.experimentautomation.application.tooladapter.eventsim;

import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.IToolAdapter;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration;
import de.uka.ipd.sdq.simulation.ISimulationListener;
import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import edu.kit.ipd.sdq.eventsim.EventSimConfig;
import edu.kit.ipd.sdq.eventsim.controller.runconfig.EventSimWorkflowConfiguration;
import edu.kit.ipd.sdq.eventsim.controller.workflow.jobs.EventSimJob;

public class EventSimToolAdapter implements IToolAdapter {

    @Override
    public void runExperiment(String experimentName, PCMModelFiles model, ToolConfiguration configuration,
            List<StopCondition> stopConditions, ISimulationListener listener) throws CoreException {
        // create simulation configuration
        EventSimConfig simConfig = EventSimConfigFactory.createConfig((EventSimConfiguration) configuration, stopConditions, model,
                experimentName);
        simConfig.addListener(listener);

        // create workflow configuration
        EventSimWorkflowConfiguration workflowConfig = EventSimWorkflowConfigurationFactory
                .createWorkflowConfiguration((EventSimConfiguration) configuration, model, simConfig);

        // run simulation
        final EventSimJob run = new EventSimJob(workflowConfig, null);
        final MDSDBlackboard blackboard = new MDSDBlackboard();
        final BlackboardBasedWorkflow<MDSDBlackboard> workflow = new BlackboardBasedWorkflow<MDSDBlackboard>(run,
                blackboard);
        workflow.run();
        
        // clean up TODO
        SensorFramework sensorFramework = (SensorFramework) ((EventSimConfiguration) configuration).getPersistenceFramework();
        SensorFrameworkDatasource datasource = sensorFramework.getDatasource();
        SensorFrameworkFactory.closeDatasource(datasource);
    }

}

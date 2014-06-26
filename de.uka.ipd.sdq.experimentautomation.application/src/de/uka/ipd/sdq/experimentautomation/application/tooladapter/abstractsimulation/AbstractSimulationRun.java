package de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation;

import de.uka.ipd.sdq.experimentautomation.experiments.ToolConfiguration;
import de.uka.ipd.sdq.workflow.blackboard.Blackboard;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

public abstract class AbstractSimulationRun extends
		SequentialBlackboardInteractingJob<Blackboard<MDSDBlackboard>> {
//        OrderPreservingBlackboardCompositeJob<Blackboard<MDSDBlackboard>> {

    private ToolConfiguration config;

    /**
     * Default constructor.
     * 
     * @param config
     *            the tool configuration
     */
    public AbstractSimulationRun(ToolConfiguration config) {
        this.config = config;
    }

    public ToolConfiguration getConfig() {
        return config;
    }

}

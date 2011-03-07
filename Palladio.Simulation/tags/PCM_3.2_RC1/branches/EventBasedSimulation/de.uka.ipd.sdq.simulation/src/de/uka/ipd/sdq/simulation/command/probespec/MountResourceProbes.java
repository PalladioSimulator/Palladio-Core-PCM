package de.uka.ipd.sdq.simulation.command.probespec;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.EventSimModel;
import de.uka.ipd.sdq.simulation.PCMModel;
import de.uka.ipd.sdq.simulation.abstractSimEngine.ISimulationControl;
import de.uka.ipd.sdq.simulation.command.ICommandExecutor;
import de.uka.ipd.sdq.simulation.command.IPCMCommand;
import de.uka.ipd.sdq.simulation.resources.SimulatedActiveResource;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.resources.SimulatedResourceEnvironment;
import de.uka.ipd.sdq.simulation.resources.listener.IDemandListener;
import de.uka.ipd.sdq.simulation.resources.listener.IStateListener;

public class MountResourceProbes implements IPCMCommand<Void> {

    private EventSimModel model;
    private SimulatedResourceEnvironment environment;

    public MountResourceProbes(EventSimModel model, SimulatedResourceEnvironment environment) {
        this.model = model;
        this.environment = environment;
    }

    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (SimulatedResourceContainer c : environment.getResourceContainers()) {
            for (SimulatedActiveResource r : c.getResources()) {
                setupResourceStateCalculator(r);
                setupDemandCalculator(r);
            }
        }

        // TODO
        // // setup utilization calculators depending on their scheduling strategy and number of
        // cores
        // if (strategy.equals(SchedulingStrategy.PROCESSOR_SHARING)) {
        // if (r.getNumberOfInstances() == 1) {
        // CalculatorHelper.setupStateCalculator(r);
        // } else {
        // CalculatorHelper.setupOverallUtilizationCalculator(r);
        // }
        // } else if (strategy.equals(SchedulingStrategy.DELAY) ||
        // strategy.equals(SchedulingStrategy.FCFS)) {
        // assert (r.getNumberOfInstances() == 1) : "DELAY and FCFS resources are expected to "
        // + "have exactly one core";
        // CalculatorHelper.setupStateCalculator(r);
        // } else if (SchedulingStrategyHelper.isExactSchedulingStrategy(strategy)) {
        // CalculatorHelper.setupOverallUtilizationCalculator(r);
        // } else {
        // throw new RuntimeException("Could not setup utilization calculator at resource " +
        // description
        // + " as it is unknown how to handle the scheduling strategy " + strategy.name() + ".");
        // }

        return null;
    }

    private void setupDemandCalculator(final SimulatedActiveResource resource) {
        // build demand calculator
        final Integer demandedTimeProbeSetId = ProbeSpecContext.instance().obtainProbeSetId(
                "demandedTimeSchedRes_" + resource.getName() + "_" + resource.getId());
        // TODO was: resource.getDescription()
        ProbeSpecContext.instance().getCalculatorFactory().buildDemandCalculator(resource.getDescription(),
                demandedTimeProbeSetId);

        resource.addDemandListener(new IDemandListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void demand(double demand) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // take demanded time
                ProbeSample demandedTimeSample = takeDemandedTimeSample(resource, demand);

                // build ProbeSetSample and publish it on the blackboard
                RequestContext context = new RequestContext("");
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, demandedTimeSample, context, "",
                                demandedTimeProbeSetId));
            }
        });
    }

    private void setupResourceStateCalculator(SimulatedActiveResource resource) {
        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
            String instanceDescription = resource.getDescription();
            if (resource.getNumberOfInstances() > 1) {
                instanceDescription = "Core " + (instance + 1) + " " + instanceDescription;
            }

            // build state calculator
            final Integer stateProbeSetID = ProbeSpecContext.instance()
                    .obtainProbeSetId("state_" + instanceDescription);
            ProbeSpecContext.instance().getCalculatorFactory().buildStateCalculator(instanceDescription,
                    stateProbeSetID);

            resource.addStateListener(new IStateListener() {

                @SuppressWarnings("unchecked")
                @Override
                public void stateChanged(int state, int instanceId) {
                    // take current time
                    ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                    // take state
                    ProbeSample stateSample = takeStateProbe(state);

                    // build ProbeSetSample and publish it on the blackboard
                    // TODO maybe null instead of an empty string is better here
                    RequestContext context = new RequestContext("");
                    ProbeSpecContext.instance().getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "",
                                    stateProbeSetID));
                }
            }, instance);
        }
    }

    @Override
    public boolean cachable() {
        return false;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(int state) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_STATE, SimulatedActiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", state);
        return stateSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeCurrentTimeSample(ISimulationControl<EventSimModel> simControl) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId",
        // TODO add probeID as soon as a ProbeSpec model is used
                simControl);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeDemandedTimeSample(SimulatedActiveResource r, Double demand) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_DEMAND, SimulatedActiveResource.class);
        ProbeSample demandedTimeSample = probeStrategy.takeSample("TODO: probeId",
        // TODO add probeID as soon as a ProbeSpec model is used
                demand);
        return demandedTimeSample;
    }

}

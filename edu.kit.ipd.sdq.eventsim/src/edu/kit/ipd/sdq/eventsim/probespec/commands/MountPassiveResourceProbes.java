package edu.kit.ipd.sdq.eventsim.probespec.commands;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.PCMModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.entities.scheduler.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.listener.IPassiveResourceListener;
import edu.kit.ipd.sdq.eventsim.staticstructure.PassiveResourceRegistry;

public class MountPassiveResourceProbes implements IPCMCommand<Void> {

    private EventSimModel model;
    private PassiveResourceRegistry registry;

    public MountPassiveResourceProbes(EventSimModel model, PassiveResourceRegistry registry) {
        this.model = model;
        this.registry = registry;
    }

    @Override
    public Void execute(PCMModel model, ICommandExecutor<PCMModel> executor) {
        for (SimPassiveResource r : registry.getPassiveResources()) {
            mountResourceStateProbes(r);
            mountWaitingTimeProbes(r);
            mountHoldTimeProbes(r);
        }

        // this command is not supposed to return a value
        return null;
    }

    @Override
    public boolean cachable() {
        return false;
    }

    private void mountResourceStateProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @Override
            public void request(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @Override
            public void release(SimulatedProcess process, int num) {
                measureState();
            }

            @Override
            public void acquire(SimulatedProcess process, int num) {
                measureState();
            }

            @SuppressWarnings("unchecked")
            private void measureState() {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // take state
                ProbeSample stateSample = takeStateProbe(model.getProbeSpecContext(), resource);

                // build ProbeSetSample and publish it on the blackboard
                // TODO maybe null instead of empty string is better here
                RequestContext context = new RequestContext("");
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "",
                                BuildPassiveResourceCalculators.getStateProbeSetId(model.getProbeSpecContext(),
                                        resource)));
            }

        });

    }

    private void mountWaitingTimeProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void request(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartWaitingProbeSetId(model
                                        .getProbeSpecContext(), resource)));
            }

            @Override
            public void release(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @SuppressWarnings("unchecked")
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopWaitingProbeSetId(model
                                        .getProbeSpecContext(), resource)));
            }
        });

    }

    private void mountHoldTimeProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @Override
            public void request(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @SuppressWarnings("unchecked")
            @Override
            public void release(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopHoldTimeProbeSetId(model
                                        .getProbeSpecContext(), resource)));
            }

            @SuppressWarnings("unchecked")
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartHoldTimeProbeSetId(model
                                        .getProbeSpecContext(), resource)));
            }
        });

    }

    /**
     * Creates a probe sample containing the current simulation time. The specified simControl
     * provides the current simulation time.
     * 
     * @param simControl
     *            the simulation control providing the current simulation time
     * @return the created probe sample
     */
    @SuppressWarnings("unchecked")
    private static ProbeSample takeCurrentTimeSample(ProbeSpecContext probeSpecContext, ISimulationControl simControl) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", simControl);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(ProbeSpecContext probeSpecContext, final SimPassiveResource r) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_STATE, SimPassiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", r);
        return stateSample;
    }

}

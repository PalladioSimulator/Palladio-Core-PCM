package de.uka.ipd.sdq.simulation.probespec.commands;

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
import de.uka.ipd.sdq.simulation.entities.SimPassiveResource;
import de.uka.ipd.sdq.simulation.resources.listener.IPassiveResourceListener;
import de.uka.ipd.sdq.simulation.resources.scheduler.SimulatedProcess;
import de.uka.ipd.sdq.simulation.staticstructure.PassiveResourceRegistry;

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
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // take state
                ProbeSample stateSample = takeStateProbe(resource);

                // build ProbeSetSample and publish it on the blackboard
                // TODO maybe null instead of empty string is better here
                RequestContext context = new RequestContext("");
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "",
                                BuildPassiveResourceCalculators.getStateProbeSetId(resource)));
            }

        });

    }

    private void mountWaitingTimeProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void request(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartWaitingProbeSetId(resource)));
            }

            @Override
            public void release(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @SuppressWarnings("unchecked")
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopWaitingProbeSetId(resource)));
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
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopHoldTimeProbeSetId(resource)));
            }

            @SuppressWarnings("unchecked")
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartHoldTimeProbeSetId(resource)));
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
    private static ProbeSample takeCurrentTimeSample(ISimulationControl<EventSimModel> simControl) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", simControl);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(final SimPassiveResource r) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_STATE, SimPassiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", r);
        return stateSample;
    }

}

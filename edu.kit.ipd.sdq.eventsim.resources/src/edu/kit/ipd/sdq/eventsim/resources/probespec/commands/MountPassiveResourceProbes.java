package edu.kit.ipd.sdq.eventsim.resources.probespec.commands;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import edu.kit.ipd.sdq.eventsim.AbstractEventSimModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.resources.entities.SimulatedProcess;
import edu.kit.ipd.sdq.eventsim.resources.listener.IPassiveResourceListener;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;

public class MountPassiveResourceProbes implements IPCMCommand<Void> {

    private AbstractEventSimModel model;
    private SimPassiveResource resource;
	private ISimulationMiddleware middleware;

    public MountPassiveResourceProbes(AbstractEventSimModel model, SimPassiveResource resource) {
        this.model = model;
        this.resource = resource;
        this.middleware = model.getSimulationMiddleware();
    }

    @Override
    public Void execute(IPCMModel model, ICommandExecutor<IPCMModel> executor) {
//        for (SimPassiveResource r : registry.getPassiveResources()) {
            mountResourceStateProbes(resource);
            mountWaitingTimeProbes(resource);
            mountHoldTimeProbes(resource);
//        }

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

            @SuppressWarnings({ "unchecked", "rawtypes" })
            private void measureState() {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationMiddleware().getProbeSpecContext(), middleware.getSimulationControl());

                // take state
                ProbeSample stateSample = takeStateProbe(middleware.getProbeSpecContext(), resource);

                // build ProbeSetSample and publish it on the blackboard
                // TODO maybe null instead of empty string is better here
                RequestContext context = new RequestContext("");
                middleware.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "", BuildPassiveResourceCalculators.getStateProbeSetId(middleware.getProbeSpecContext(), resource)));
            }

        });

    }

    private void mountWaitingTimeProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public void request(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(middleware.getProbeSpecContext(), middleware.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                middleware.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartWaitingProbeSetId(middleware.getProbeSpecContext(), resource)));
            }

            @Override
            public void release(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(middleware.getProbeSpecContext(), middleware.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                middleware.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopWaitingProbeSetId(middleware.getProbeSpecContext(), resource)));
            }
        });

    }

    private void mountHoldTimeProbes(final SimPassiveResource resource) {
        resource.addListener(new IPassiveResourceListener() {

            @Override
            public void request(SimulatedProcess process, int num) {
                // nothing to do here
            }

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public void release(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(middleware.getProbeSpecContext(), middleware.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                middleware.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStopHoldTimeProbeSetId(middleware.getProbeSpecContext(), resource)));
            }

            @SuppressWarnings({ "unchecked", "rawtypes" })
            @Override
            public void acquire(SimulatedProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(middleware.getProbeSpecContext(), middleware.getSimulationControl());

                // build ProbeSetSample and publish it on the blackboard
                middleware.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, process.getRequest().getRequestContext(),
                                "", BuildPassiveResourceCalculators.getStartHoldTimeProbeSetId(middleware.getProbeSpecContext(), resource)));
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
    @SuppressWarnings({ "rawtypes" })
    private static ProbeSample takeCurrentTimeSample(ProbeSpecContext probeSpecContext, ISimulationControl simControl) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", simControl);
        return currentTimeSample;
    }

    @SuppressWarnings({ "rawtypes" })
    private static ProbeSample takeStateProbe(ProbeSpecContext probeSpecContext, final SimPassiveResource r) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_STATE, SimPassiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", r);
        return stateSample;
    }

}

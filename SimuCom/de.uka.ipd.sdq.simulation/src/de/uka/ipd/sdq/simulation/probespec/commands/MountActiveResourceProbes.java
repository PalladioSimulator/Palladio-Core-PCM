package de.uka.ipd.sdq.simulation.probespec.commands;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
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
import de.uka.ipd.sdq.simulation.entities.SimActiveResource;
import de.uka.ipd.sdq.simulation.resources.listener.IDemandListener;
import de.uka.ipd.sdq.simulation.resources.listener.IOverallUtilizationListener;
import de.uka.ipd.sdq.simulation.resources.listener.IStateListener;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceContainer;
import de.uka.ipd.sdq.simulation.staticstructure.SimulatedResourceEnvironment;

/**
 * This command registers one or more {@link IStateListener} and one {@link IDemandListener} at each
 * resource. If the resource has more than one instance, a {@link IStateListener} is registered for
 * each instance.
 * <p>
 * The {@link IDemandListener} takes a {@link ProbeType#RESOURCE_DEMAND} sample whenever a resource
 * demand is issued. The {@link IStateListener} takes a {@link ProbeType#RESOURCE_STATE} sample
 * whenever the resource state changes.
 * 
 * @author Philipp Merkle
 * 
 */
public class MountActiveResourceProbes implements IPCMCommand<Void> {

    private EventSimModel model;
    private SimulatedResourceEnvironment environment;

    /**
     * 
     * @param model
     * @param environment
     */
    public MountActiveResourceProbes(EventSimModel model, SimulatedResourceEnvironment environment) {
        this.model = model;
        this.environment = environment;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Void execute(PCMModel pcm, ICommandExecutor<PCMModel> executor) {
        for (SimulatedResourceContainer c : environment.getResourceContainers()) {
            for (SimActiveResource r : c.getResources()) {
                mountResourceStateProbes(r);
                mountOverallUtilisationProbes(r);
                mountDemandProbes(r);
            }
        }

        // TODO setup (overall) utilization calculators here

        // this command is not supposed to return a value
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean cachable() {
        return false;
    }

    /**
     * Registers an {@link IStateListener} at each instance of the specified resource. Whenever the
     * state changes, {@link ProbeSample}s are taken.
     * 
     * @param resource
     *            the resource that is to be observed
     */
    private void mountResourceStateProbes(final SimActiveResource resource) {
        for (int instance = 0; instance < resource.getNumberOfInstances(); instance++) {
            final int i = instance;
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
                                    BuildActiveResourceCalculators.getStateProbeSetId(resource, i)));
                }
            }, instance);
        }
    }

    private void mountOverallUtilisationProbes(final SimActiveResource resource) {
        resource.addOverallUtilizationListener(new IOverallUtilizationListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void utilizationChanged(double resourceDemand, double totalTime) {
                // build ProbeSetSamples and publish them on the blackboard
                // TODO maybe null instead of empty string is better here
                ISampleBlackboard blackboard = ProbeSpecContext.instance().getSampleBlackboard();
                RequestContext context = new RequestContext("");
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(0.0), takeStateProbe(1),
                        context, "", BuildActiveResourceCalculators.getOverallUtilisationProbeSetId(resource)));
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(resourceDemand),
                        takeStateProbe(0), context, "", BuildActiveResourceCalculators
                                .getOverallUtilisationProbeSetId(resource)));
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(totalTime), takeStateProbe(1),
                        context, "", BuildActiveResourceCalculators.getOverallUtilisationProbeSetId(resource)));
            }
        });
    }

    /**
     * Registers an {@link IDemandListener} at the specified resource. Whenever the state changes,
     * {@link ProbeSample}s are taken.
     * 
     * @param resource
     *            the resource that is to be observed
     */
    private void mountDemandProbes(final SimActiveResource resource) {
        resource.addDemandListener(new IDemandListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void demand(double demand) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl());

                // take demanded time
                ProbeSample demandedTimeSample = takeDemandedTimeSample(demand);

                // build ProbeSetSample and publish it on the blackboard
                RequestContext context = new RequestContext("");
                ProbeSpecContext.instance().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, demandedTimeSample, context, "",
                                BuildActiveResourceCalculators.getDemandedTimeProbeSetId(resource)));
            }
        });
    }

    /**
     * Creates a probe sample containing the specified state.
     * 
     * @param state
     *            the state
     * @return the created probe sample
     */
    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(int state) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_STATE, SimActiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", state);
        return stateSample;
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
    private static ProbeSample takeTimeSample(Double time) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", time);
        return currentTimeSample;
    }

    /**
     * Creates a probe sample containing the specified resource demand.
     * 
     * @param demand
     *            the resource demand
     * @return the created probe sample
     */
    @SuppressWarnings("unchecked")
    private static ProbeSample takeDemandedTimeSample(Double demand) {
        IProbeStrategy probeStrategy = ProbeSpecContext.instance().getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_DEMAND, SimActiveResource.class);
        ProbeSample demandedTimeSample = probeStrategy.takeSample("TODO: probeId", demand);
        return demandedTimeSample;
    }

}

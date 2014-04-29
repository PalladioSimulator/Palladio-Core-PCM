package edu.kit.ipd.sdq.eventsim.probespec.commands;

import java.util.Set;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;
import edu.kit.ipd.sdq.eventsim.EventSimModel;
import edu.kit.ipd.sdq.eventsim.command.ICommandExecutor;
import edu.kit.ipd.sdq.eventsim.command.IPCMCommand;
import edu.kit.ipd.sdq.eventsim.resources.listener.IDemandListener;
import edu.kit.ipd.sdq.eventsim.resources.listener.IOverallUtilizationListener;
import edu.kit.ipd.sdq.eventsim.resources.listener.IStateListener;
import edu.kit.ipd.sdq.eventsim.system.entities.SimActiveResource;
import edu.kit.ipd.sdq.eventsim.system.staticstructure.SimulatedResourceEnvironment;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.PCMModel;

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
        // collect all active resources
        Set<SimActiveResource> resources = model.execute(new CollectActiveResources(environment));

        // mount probes for each resource
        for (SimActiveResource r : resources) {
            mountResourceStateProbes(r);
            mountOverallUtilisationProbes(r);
            mountDemandProbes(r);
        }

        // TODO setup (overall) utilization calculators here?

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
                    ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                            .getSimulationControl());

                    // take state
                    ProbeSample stateSample = takeStateProbe(model.getProbeSpecContext(), state);

                    // build ProbeSetSample and publish it on the blackboard
                    // TODO maybe null instead of an empty string is better here
                    RequestContext context = new RequestContext("");
                    model.getProbeSpecContext().getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "",
                                    BuildActiveResourceCalculators.getStateProbeSetId(model.getProbeSpecContext(),
                                            resource, i)));
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
                ISampleBlackboard blackboard = model.getProbeSpecContext().getSampleBlackboard();
                RequestContext context = new RequestContext("");
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(
                        takeTimeSample(model.getProbeSpecContext(), 0.0),
                        takeStateProbe(model.getProbeSpecContext(), 1), context, "", BuildActiveResourceCalculators
                                .getOverallUtilisationProbeSetId(model.getProbeSpecContext(), resource)));
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(model.getProbeSpecContext(),
                        resourceDemand), takeStateProbe(model.getProbeSpecContext(), 0), context, "",
                        BuildActiveResourceCalculators.getOverallUtilisationProbeSetId(model.getProbeSpecContext(),
                                resource)));
                blackboard.addSample(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(model.getProbeSpecContext(),
                        totalTime), takeStateProbe(model.getProbeSpecContext(), 1), context, "",
                        BuildActiveResourceCalculators.getOverallUtilisationProbeSetId(model.getProbeSpecContext(),
                                resource)));
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
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getProbeSpecContext(), model
                        .getSimulationControl());

                // take demanded time
                ProbeSample demandedTimeSample = takeDemandedTimeSample(model.getProbeSpecContext(), demand);

                // build ProbeSetSample and publish it on the blackboard
                RequestContext context = new RequestContext("");
                model.getProbeSpecContext().getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, demandedTimeSample, context, "",
                                BuildActiveResourceCalculators.getDemandedTimeProbeSetId(model.getProbeSpecContext(),
                                        resource)));
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
    private static ProbeSample takeStateProbe(ProbeSpecContext probeSpecContext, int state) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
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
    private static ProbeSample takeCurrentTimeSample(ProbeSpecContext probeSpecContext, ISimulationControl simControl) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", simControl);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeTimeSample(ProbeSpecContext probeSpecContext, Double time) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
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
    private static ProbeSample takeDemandedTimeSample(ProbeSpecContext probeSpecContext, Double demand) {
        IProbeStrategy probeStrategy = probeSpecContext.getProbeStrategyRegistry().getProbeStrategy(
                ProbeType.RESOURCE_DEMAND, SimActiveResource.class);
        ProbeSample demandedTimeSample = probeStrategy.takeSample("TODO: probeId", demand);
        return demandedTimeSample;
    }

}

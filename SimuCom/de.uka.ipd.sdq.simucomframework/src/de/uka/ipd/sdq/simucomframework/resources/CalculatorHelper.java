package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.calculator.DemandCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.HoldTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.StateCalculator;
import de.uka.ipd.sdq.probespec.framework.calculator.WaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.probespec.framework.utils.ProbeSpecUtils;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.DiscardInvalidMeasurementsBlackboardDecorator;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Offers static methods to setup different types of calculators for resources like
 * {@link AbstractScheduledResource} and {@link IPassiveResource}.
 * 
 * @author Philipp Merkle
 * 
 */
public class CalculatorHelper {

    /**
     * Sets up a {@link WaitingTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the waiting time. When such an event arrives, an
     * appropriate {@link ProbeSample} will be taken and published at the {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // build waiting time calculator
        final Integer startWaitingProbeSetId = ctx.obtainProbeSetId("startWaitingPsvRes_" + resource.getId());
        final Integer stopWaitingProbeSetId = ctx.obtainProbeSetId("stopWaitingPsvRes_" + resource.getId());
        ctx.getCalculatorFactory().buildWaitingTimeCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), startWaitingProbeSetId,
                stopWaitingProbeSetId);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(ISchedulableProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl(), ctx);

                // build ProbeSetSample and publish it on the blackboard
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, ((SimuComSimProcess) process)
                                .getRequestContext(), "", startWaitingProbeSetId));
            }

            @Override
            public void acquire(ISchedulableProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl(), ctx);

                // build ProbeSetSample and publish it on the blackboard
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, ((SimuComSimProcess) process)
                                .getRequestContext(), "", stopWaitingProbeSetId));

            }

            @Override
            public void release(ISchedulableProcess process, int num) {
                // nothing to do here

            }

        });

    }

    /**
     * Sets up a {@link HoldTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the hold time. When such an event arrives, an
     * appropriate {@link ProbeSample} will be taken and published at the {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // build hold time calculator
        final Integer startHoldProbeSetId = ctx.obtainProbeSetId("startHoldPsvRes_" + resource.getId());
        final Integer stopHoldProbeSetId = ctx.obtainProbeSetId("stopHoldPsvRes_" + resource.getId());
        ctx.getCalculatorFactory().buildHoldTimeCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), startHoldProbeSetId,
                stopHoldProbeSetId);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(ISchedulableProcess process, int num) {
                // nothing to do here
            }

            @Override
            public void acquire(ISchedulableProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl(), ctx);

                // build ProbeSetSample and publish it on the blackboard
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, ((SimuComSimProcess) process)
                                .getRequestContext(), "", startHoldProbeSetId));
            }

            @Override
            public void release(ISchedulableProcess process, int num) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl(), ctx);

                // build ProbeSetSample and publish it on the blackboard
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, ((SimuComSimProcess) process)
                                .getRequestContext(), "", stopHoldProbeSetId));
            }
        });
    }

    /**
     * Sets up a {@link DemandCalculator} for the specified resource. Also a {@link IDemandListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the demanded time. When such an event arrives, an appropriate {@link ProbeSample}
     * will be taken and published at the {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupDemandCalculator(final AbstractScheduledResource r, SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // build demand calculator
        final Integer demandedTimeProbeSetId = ctx.obtainProbeSetId("demandedTimeSchedRes_" + r.getDescription());
        ctx.getCalculatorFactory().buildDemandCalculator(r.getDescription(), demandedTimeProbeSetId);

        r.addDemandListener(new IDemandListener() {

            public void demand(double demand) {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(r, ctx);

                // take demanded time
                ProbeSample demandedTimeSample = takeDemandedTimeSample(r, demand, ctx);

                // TODO Check whether the context is unique so that there is at
                // most one job per SimProcess
                // RequestContext context = ((SimProcess) job.getJobParent())
                // .getRequestContext()
                // .append("_" + job.getCreationTime());

                // build ProbeSetSample and publish it on the blackboard
                RequestContext context = new RequestContext("");
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample, demandedTimeSample, context, "",
                                demandedTimeProbeSetId));
            }
            
            public void demandCompleted(ISchedulableProcess simProcess) {
            	// Do nothing.
            }
        });
    }

    /**
     * Sets up a {@link StateCalculator} for the specified resource. Also a {@link IStateListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the state. When such an event arrives, an appropriate {@link ProbeSample} will be
     * taken and published at the {@link ISampleBlackboard}.
     * 
     * @param r
     *            the resource
     */
    public static void setupStateCalculator(final AbstractScheduledResource r, SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // setup a calculator for each instance
        for (int instance = 0; instance < r.getNumberOfInstances(); instance++) {
            String instanceDescription = r.getDescription();
            if (r.getNumberOfInstances() > 1) {
                instanceDescription = "Core " + (instance + 1) + " " + instanceDescription;
            }

            // build state calculator
            final Integer stateProbeSetID = ctx.obtainProbeSetId("state_" + instanceDescription);
            ctx.getCalculatorFactory().buildStateCalculator(instanceDescription, stateProbeSetID);

            r.addStateListener(new IStateListener() {
                @SuppressWarnings("unchecked")
                @Override
                public void stateChanged(int state, int instanceId) {
                    // take current time
                    ProbeSample currentTimeSample = takeCurrentTimeSample(r, ctx);

                    // take state
                    ProbeSample stateSample = takeStateProbe(state, ctx);

                    // build ProbeSetSample and publish it on the blackboard
                    // TODO maybe null instead of empty string is better here
                    RequestContext context = new RequestContext("");
                    ctx.getSampleBlackboard().addSample(
                            ProbeSpecUtils.buildProbeSetSample(currentTimeSample, stateSample, context, "",
                                    stateProbeSetID));
                }
            }, instance);
        }
    }

    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource r, SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // build state calculator
        final Integer stateProbeSetID = ctx.obtainProbeSetId("overallUtilization_" + r.getDescription());
        ctx.getCalculatorFactory().buildOverallUtilizationCalculator(r.getDescription(), stateProbeSetID);

        r.addOverallUtilizationListener(new IOverallUtilizationListener() {

            @Override
            public void utilizationChanged(double resourceDemand, double totalTime) {
                // FIXME This is a hack that allows to add samples to the blackboard even when
                // the simulation has stopped.
                if (!(ctx.getSampleBlackboard() instanceof DiscardInvalidMeasurementsBlackboardDecorator)) {
                    return;
                }
                DiscardInvalidMeasurementsBlackboardDecorator blackboard = (DiscardInvalidMeasurementsBlackboardDecorator) ctx
                        .getSampleBlackboard();

                // build ProbeSetSamples and publish them on the blackboard
                // TODO maybe null instead of empty string is better here
                RequestContext context = new RequestContext("");
                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(0.0, ctx),
                        takeStateProbe(1, ctx), context, "", stateProbeSetID));
                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(
                        resourceDemand, ctx), takeStateProbe(0, ctx), context, "", stateProbeSetID));
                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(
                        takeTimeSample(totalTime, ctx), takeStateProbe(1, ctx), context, "", stateProbeSetID));
            }
        });
    }

    public static void setupStateCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // build state calculator
        final Integer stateProbeSetID = ctx.obtainProbeSetId("state_" + resource.getName() + " " + resource.getId());
        ctx.getCalculatorFactory().buildStateCalculator(
                "Passive Resource " + resource.getName() + " " + resource.getId(), stateProbeSetID);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(ISchedulableProcess process, int num) {
                // nothing to do here
            }

            @Override
            public void release(ISchedulableProcess process, int num) {
                measureState();
            }

            @Override
            public void acquire(ISchedulableProcess process, int num) {
                measureState();
            }

            @SuppressWarnings("unchecked")
            private void measureState() {
                // take current time
                ProbeSample currentTimeSample = takeCurrentTimeSample(model.getSimulationControl(), ctx);

                // take state
                ProbeSample stateSample = takeStateProbe(resource, ctx);

                // build ProbeSetSample and publish it on the blackboard
                // TODO maybe null instead of empty string is better here
                RequestContext context = new RequestContext("");
                ctx.getSampleBlackboard().addSample(
                        ProbeSpecUtils
                                .buildProbeSetSample(currentTimeSample, stateSample, context, "", stateProbeSetID));
            }

        });
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeCurrentTimeSample(SimuComSimProcess thread, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId",
        // TODO add probeID as soon as a ProbeSpec model is used
                thread.getModel().getSimulationControl());
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeCurrentTimeSample(ISimulationControl simControl, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId",
        // TODO add probeID as soon as a ProbeSpec model is used
                simControl);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeCurrentTimeSample(final AbstractScheduledResource r, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", r.getModel().getSimulationControl());
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeTimeSample(Double time, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.CURRENT_TIME, null);
        ProbeSample currentTimeSample = probeStrategy.takeSample("TODO: probeId", time);
        return currentTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeDemandedTimeSample(AbstractScheduledResource r, Double demand, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.RESOURCE_DEMAND,
                AbstractScheduledResource.class);
        ProbeSample demandedTimeSample = probeStrategy.takeSample("TODO: probeId",
        // TODO add probeID as soon as a ProbeSpec model is used
                demand);
        return demandedTimeSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(int state, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.RESOURCE_STATE,
                AbstractScheduledResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", state);
        return stateSample;
    }

    @SuppressWarnings("unchecked")
    private static ProbeSample takeStateProbe(final IPassiveResource r, ProbeSpecContext ctx) {
        IProbeStrategy probeStrategy = ctx.getProbeStrategyRegistry().getProbeStrategy(ProbeType.RESOURCE_STATE,
                IPassiveResource.class);
        ProbeSample stateSample = probeStrategy.takeSample("TODO: probeId", r);
        return stateSample;
    }

}

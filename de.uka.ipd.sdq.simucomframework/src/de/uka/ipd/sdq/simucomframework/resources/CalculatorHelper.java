package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Arrays;

import de.uka.ipd.sdq.probespec.framework.ProbeSpecContext;
import de.uka.ipd.sdq.probespec.framework.measurements.BasicMeasurement;
import de.uka.ipd.sdq.probespec.framework.probes.Probe;
import de.uka.ipd.sdq.probespec.framework.probes.ProbeSet;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceDemandProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceStateProbe;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Offers static methods to setup different types of calculators for resources like
 * {@link AbstractScheduledResource} and {@link IPassiveResource}.
 * 
 * @author Philipp Merkle
 * 
 */
public final class CalculatorHelper {

    //    /**
    //     * Sets up a {@link WaitingTimeCalculator} for the specified resource. Also a
    //     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
    //     * events that are relevant for calculating the waiting time. When such an event arrives, an
    //     * appropriate {@link BasicMeasurement} will be taken and published at the {@link ISampleBlackboard}.
    //     *
    //     * @param resource the resource
    //     * @param model The Simucom Model
    //     */
    //    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
    //        final ProbeSpecContext ctx = model.getProbeSpecContext();
    //
    //        // build waiting time calculator
    //        final Integer startWaitingProbeSetId = ctx.obtainProbeSetId("startWaitingPsvRes_" + resource.getId());
    //        final Integer stopWaitingProbeSetId = ctx.obtainProbeSetId("stopWaitingPsvRes_" + resource.getId());
    //        ctx.getCalculatorFactory().buildWaitingTimeCalculator(
    //                "Passive Resource " + resource.getName() + " " + resource.getId(),
    //                startWaitingProbeSetId,
    //                stopWaitingProbeSetId);
    //
    //        resource.addObserver(new IPassiveResourceSensor() {
    //
    //            @Override
    //            public void request(final ISchedulableProcess process, final long num) {
    //                // take current time
    //                final BasicMeasurement<?, ? extends Quantity> currentTimeSample = takeCurrentTimeSample(
    //                        model.getSimulationControl(), ctx);
    //
    //                // build ProbeSetSample and publish it on the blackboard
    //                ctx.getSampleBlackboard().addSample(
    //                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample,
    //                                ((SimuComSimProcess) process).getRequestContext(), "", startWaitingProbeSetId));
    //            }
    //
    //            @Override
    //            public void acquire(final ISchedulableProcess process, final long num) {
    //                // take current time
    //                final BasicMeasurement<Double, Duration> currentTimeSample = takeCurrentTimeSample(
    //                        model.getSimulationControl(), ctx);
    //
    //                // build ProbeSetSample and publish it on the blackboard
    //                ctx.getSampleBlackboard().addSample(
    //                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample,
    //                                ((SimuComSimProcess) process).getRequestContext(), "", stopWaitingProbeSetId));
    //
    //            }
    //
    //            @Override
    //            public void release(final ISchedulableProcess process, final long num) {
    //                // nothing to do here
    //            }
    //
    //        });
    //
    //    }
    //
    //    /**
    //     * Sets up a {@link HoldTimeCalculator} for the specified resource. Also a
    //     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
    //     * events that are relevant for calculating the hold time. When such an event arrives, an
    //     * appropriate {@link BasicMeasurement} will be taken and published at the {@link ISampleBlackboard}.
    //     *
    //     * @param r
    //     *            the resource
    //     */
    //    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
    //        final ProbeSpecContext ctx = model.getProbeSpecContext();
    //
    //        // build hold time calculator
    //        final Integer startHoldProbeSetId = ctx.obtainProbeSetId("startHoldPsvRes_" + resource.getId());
    //        final Integer stopHoldProbeSetId = ctx.obtainProbeSetId("stopHoldPsvRes_" + resource.getId());
    //        ctx.getCalculatorFactory().buildHoldTimeCalculator(
    //                "Passive Resource " + resource.getName() + " " + resource.getId(), startHoldProbeSetId,
    //                stopHoldProbeSetId);
    //
    //        resource.addObserver(new IPassiveResourceSensor() {
    //
    //            @Override
    //            public void request(final ISchedulableProcess process, final long num) {
    //                // nothing to do here
    //            }
    //
    //            @Override
    //            public void acquire(final ISchedulableProcess process, final long num) {
    //                // take current time
    //                final BasicMeasurement<?, ? extends Quantity> currentTimeSample = takeCurrentTimeSample(
    //                        model.getSimulationControl(), ctx);
    //
    //                // build ProbeSetSample and publish it on the blackboard
    //                ctx.getSampleBlackboard().addSample(
    //                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample,
    //                                ((SimuComSimProcess) process).getRequestContext(), "", startHoldProbeSetId));
    //            }
    //
    //            @Override
    //            public void release(final ISchedulableProcess process, final long num) {
    //                // take current time
    //                final BasicMeasurement<?, ? extends Quantity> currentTimeSample = takeCurrentTimeSample(
    //                        model.getSimulationControl(), ctx);
    //
    //                // build ProbeSetSample and publish it on the blackboard
    //                ctx.getSampleBlackboard().addSample(
    //                        ProbeSpecUtils.buildProbeSetSample(currentTimeSample,
    //                                ((SimuComSimProcess) process).getRequestContext(), "", stopHoldProbeSetId));
    //            }
    //        });
    //    }

    /**
     * Sets up a {@link DemandCalculator} for the specified resource. Also a {@link IDemandListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the demanded time. When such an event arrives, an appropriate {@link BasicMeasurement}
     * will be taken and published at the {@link ISampleBlackboard}.
     *
     * @param r
     *            the resource
     */
    public static void setupDemandCalculator(final AbstractScheduledResource r, final SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        final Probe scheduledResourceProbe = getProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakeScheduledResourceDemandProbe(r));
        ctx.getCalculatorFactory().buildDemandCalculator(r.getDescription(), scheduledResourceProbe);

        r.addDemandListener(new IDemandListener() {

            @Override
            public void demand(final double demand) {
                scheduledResourceProbe.takeMeasurement(RequestContext.EMPTY_REQUEST_CONTEXT);
            }

            @Override
            public void demandCompleted(final ISchedulableProcess simProcess) {
                // Do nothing.
            }
        });
    }

    /**
     * Sets up a {@link StateCalculator} for the specified resource. Also a {@link IStateListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the state. When such an event arrives, an appropriate {@link BasicMeasurement} will be
     * taken and published at the {@link ISampleBlackboard}.
     * 
     * @param scheduledResource
     *            the resource
     */
    public static void setupStateCalculator(final AbstractScheduledResource scheduledResource, final SimuComModel model) {
        final ProbeSpecContext ctx = model.getProbeSpecContext();

        // setup a calculator for each instance
        for (int instance = 0; instance < scheduledResource.getNumberOfInstances(); instance++) {
            final String instanceDescription = "Core " + (instance + 1) + " " + scheduledResource.getDescription();
            final Probe scheduledResourceProbe = getProbeSetWithCurrentTime(model.getSimulationControl(),
                    new TakeScheduledResourceStateProbe(scheduledResource,instance));
            ctx.getCalculatorFactory().buildStateCalculator(instanceDescription, scheduledResourceProbe);

            scheduledResource.addStateListener(new IStateListener() {
                @Override
                public void stateChanged(final long state, final int instanceId) {
                    scheduledResourceProbe.takeMeasurement(RequestContext.EMPTY_REQUEST_CONTEXT);
                }
            }, instance);
        }
    }
    //
    //    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource r, final SimuComModel model) {
    //        final ProbeSpecContext ctx = model.getProbeSpecContext();
    //
    //        // build state calculator
    //        final Integer stateProbeSetID = ctx.obtainProbeSetId("overallUtilization_" + r.getDescription());
    //        ctx.getCalculatorFactory().buildOverallUtilizationCalculator(r.getDescription(), stateProbeSetID);
    //
    //        r.addOverallUtilizationListener(new IOverallUtilizationListener() {
    //
    //            @Override
    //            public void utilizationChanged(final double resourceDemand, final double totalTime) {
    //                // FIXME This is a hack that allows to add samples to the blackboard even when
    //                // the simulation has stopped.
    //                if (!(ctx.getSampleBlackboard() instanceof DiscardInvalidMeasurementsBlackboardDecorator)) {
    //                    return;
    //                }
    //                final DiscardInvalidMeasurementsBlackboardDecorator blackboard = (DiscardInvalidMeasurementsBlackboardDecorator) ctx
    //                        .getSampleBlackboard();
    //
    //                // build ProbeSetSamples and publish them on the blackboard
    //                // TODO maybe null instead of empty string is better here
    //                final RequestContext context = new RequestContext("");
    //                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(takeTimeSample(0.0, ctx),
    //                        takeStateProbe(1l, ctx), context, "", stateProbeSetID));
    //                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(
    //                        takeTimeSample(resourceDemand, ctx), takeStateProbe(0l, ctx), context, "", stateProbeSetID));
    //                blackboard.addSampleAfterSimulationEnd(ProbeSpecUtils.buildProbeSetSample(
    //                        takeTimeSample(totalTime, ctx), takeStateProbe(1l, ctx), context, "", stateProbeSetID));
    //            }
    //        });
    //    }
    //
    //    public static void setupStateCalculator(final IPassiveResource resource, final SimuComModel model) {
    //        final ProbeSpecContext ctx = model.getProbeSpecContext();
    //
    //        // build state calculator
    //        final Integer stateProbeSetID = ctx.obtainProbeSetId("state_" + resource.getName() + " " + resource.getId());
    //        ctx.getCalculatorFactory().buildStateCalculator(
    //                "Passive Resource " + resource.getName() + " " + resource.getId(), stateProbeSetID);
    //
    //        resource.addObserver(new IPassiveResourceSensor() {
    //
    //            @Override
    //            public void request(final ISchedulableProcess process, final long num) {
    //                // nothing to do here
    //            }
    //
    //            @Override
    //            public void release(final ISchedulableProcess process, final long num) {
    //                measureState();
    //            }
    //
    //            @Override
    //            public void acquire(final ISchedulableProcess process, final long num) {
    //                measureState();
    //            }
    //
    //            private void measureState() {
    //                // take current time
    //                final BasicMeasurement<?, ? extends Quantity> currentTimeSample = takeCurrentTimeSample(
    //                        model.getSimulationControl(), ctx);
    //
    //                // take state
    //                final BasicMeasurement<?, ? extends Quantity> stateSample = takeStateProbe(resource, ctx);
    //
    //                // build ProbeSetSample and publish it on the blackboard
    //                // TODO maybe null instead of empty string is better here
    //                final RequestContext context = new RequestContext("");
    //                ctx.getSampleBlackboard().addSample(
    //                        ProbeSpecUtils
    //                        .buildProbeSetSample(currentTimeSample, stateSample, context, "", stateProbeSetID));
    //            }
    //
    //        });
    //    }

    /**
     * @param scheduledResource
     * @param model
     * @param instance
     * @return
     */
    protected static ProbeSet getProbeSetWithCurrentTime(final ISimulationControl control, final Probe additionalProbe) {
        return new ProbeSet(Arrays.asList(
                new TakeCurrentSimulationTimeProbe(control),
                additionalProbe));
    }
}

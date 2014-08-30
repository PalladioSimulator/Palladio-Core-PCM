package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Arrays;
import java.util.List;

import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.ResourceURIMeasuringPoint;
import org.palladiosimulator.edp2.util.MeasuringPointUtility;
import org.palladiosimulator.measurementframework.BasicMeasurement;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.probeframework.ProbeFrameworkContext;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.EventProbe;
import org.palladiosimulator.probeframework.probes.EventProbeList;
import org.palladiosimulator.probeframework.probes.Probe;
import org.palladiosimulator.probeframework.probes.TriggeredProbe;
import org.palladiosimulator.probeframework.probes.TriggeredProbeList;

import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulableProcess;
import de.uka.ipd.sdq.scheduler.sensors.IPassiveResourceSensor;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.probes.TakeCurrentSimulationTimeProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakePassiveResourceStateProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceDemandProbe;
import de.uka.ipd.sdq.simucomframework.probes.TakeScheduledResourceStateProbe;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Offers static methods to setup different types of calculators for resources like
 * {@link AbstractScheduledResource} and {@link IPassiveResource}.
 *
 * TODO Some calculators are created in AbstractMain. Why is that? [Lehrig]
 *
 * @author Philipp Merkle, Sebastian Lehrig
 */
public final class CalculatorHelper {

    /** Default EMF factory for measuring points. */
    private static final MeasuringpointFactory MEASURINGPOINT_FACTORY = MeasuringpointFactory.eINSTANCE;

    /** Default EMF factory for pcm measuring points. */
    private static final PcmmeasuringpointFactory PCM_MEASURINGPOINT_FACTORY = PcmmeasuringpointFactory.eINSTANCE;

    /**
     * Sets up a {@link WaitingTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the waiting time. When such an event arrives, an
     * appropriate {@link BasicMeasurement} will be taken and published at the
     * {@link ISampleBlackboard}.
     *
     * @param resource
     *            the resource
     * @param model
     *            The Simucom Model
     */
    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildWaitingTimeCalculator(createMeasuringPoint(resource), startStopProbes);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe) startStopProbes.get(0)).takeMeasurement(new RequestContext(process.getId()));
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe) startStopProbes.get(1)).takeMeasurement(new RequestContext(process.getId()));
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

        });

    }

    /**
     * Sets up a {@link HoldingTimeCalculator} for the specified resource. Also a
     * {@link IPassiveResourceSensor} will be registered at the resource which gets notified of
     * events that are relevant for calculating the hold time. When such an event arrives, an
     * appropriate {@link BasicMeasurement} will be taken and published at the
     * {@link ISampleBlackboard}.
     *
     * @param r
     *            the resource
     */
    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildHoldingTimeCalculator(createMeasuringPoint(resource), startStopProbes);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe) startStopProbes.get(0)).takeMeasurement(new RequestContext(process.getId()));
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                ((TriggeredProbe) startStopProbes.get(1)).takeMeasurement(new RequestContext(process.getId()));
            }
        });
    }

    /**
     * @param model
     * @return
     */
    protected static List<Probe> buildStartStopProbes(final SimuComModel model) {
        return Arrays.asList((Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()),
                (Probe) new TakeCurrentSimulationTimeProbe(model.getSimulationControl()));
    }

    /**
     * Sets up a {@link DemandCalculator} for the specified resource. Also a {@link IDemandListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the demanded time. When such an event arrives, an appropriate
     * {@link BasicMeasurement} will be taken and published at the {@link ISampleBlackboard}.
     *
     * @param scheduledResource
     *            the resource
     */
    public static void setupDemandCalculator(final AbstractScheduledResource scheduledResource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final Probe scheduledResourceProbe = getEventProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakeScheduledResourceDemandProbe(scheduledResource));
        ctx.getCalculatorFactory().buildResourceDemandCalculator(createMeasuringPoint(scheduledResource),
                scheduledResourceProbe);
    }

    /**
     * Sets up a {@link StateCalculator} for the specified resource. Also a {@link IStateListener}
     * will be registered at the resource which gets notified of events that are relevant for
     * calculating the state. When such an event arrives, an appropriate {@link BasicMeasurement}
     * will be taken and published at the {@link ISampleBlackboard}.
     *
     * @param scheduledResource
     *            the resource
     */
    public static void setupActiveResourceStateCalculator(final AbstractScheduledResource scheduledResource,
            final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        // setup a calculator for each instance
        for (int instance = 0; instance < scheduledResource.getNumberOfInstances(); instance++) {
            final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(
                    model.getSimulationControl(), new TakeScheduledResourceStateProbe(scheduledResource, instance));
            ctx.getCalculatorFactory().buildStateOfActiveResourceCalculator(
                    createMeasuringPoint(scheduledResource, instance), scheduledResourceProbe);

            scheduledResource.addStateListener(new IStateListener() {
                @Override
                public void stateChanged(final long state, final int instanceId) {
                    scheduledResourceProbe.takeMeasurement();
                }
            }, instance);
        }
    }

    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource r, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        r.addOverallUtilizationListener(new IOverallUtilizationListener() {

            @Override
            public void utilizationChanged(final double resourceDemand, final double totalTime) {

                // FIXME following line was commented-out. Make code working again.
                // ctx.getCalculatorFactory().buildOverallUtilizationCalculator(r.getDescription(),
                // null);
                // FIXME: Define a new probe which results in the overall observed utilisation and
                // hands it to the calculator
                // // FIXME This is a hack that allows to add samples to the blackboard even when
                // // the simulation has stopped.
                // if (!(ctx.getSampleBlackboard() instanceof
                // DiscardInvalidMeasurementsBlackboardDecorator)) {
                // return;
                // }
                // final DiscardInvalidMeasurementsBlackboardDecorator blackboard =
                // (DiscardInvalidMeasurementsBlackboardDecorator) ctx
                // .getSampleBlackboard();
                //
                // // build ProbeSetSamples and publish them on the blackboard
                // // TODO maybe null instead of empty string is better here
                // final RequestContext context = new RequestContext("");
                // blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(takeTimeSample(0.0,
                // ctx),
                // takeStateProbe(1l, ctx), context, "", stateProbeSetID));
                // blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(
                // takeTimeSample(resourceDemand, ctx), takeStateProbe(0l, ctx), context, "",
                // stateProbeSetID));
                // blackboard.addSampleAfterSimulationEnd(ProbeFrameworkUtils.buildProbeSetSample(
                // takeTimeSample(totalTime, ctx), takeStateProbe(1l, ctx), context, "",
                // stateProbeSetID));
            }
        });
    }

    public static void setupPassiveResourceStateCalculator(final IPassiveResource resource, final SimuComModel model) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final MeasuringPoint mp = createMeasuringPoint(resource);
        final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakePassiveResourceStateProbe(resource));
        ctx.getCalculatorFactory().buildStateOfPassiveResourceCalculator(mp, scheduledResourceProbe);

        resource.addObserver(new IPassiveResourceSensor() {

            @Override
            public void request(final ISchedulableProcess process, final long num) {
                // nothing to do here
            }

            @Override
            public void release(final ISchedulableProcess process, final long num) {
                scheduledResourceProbe.takeMeasurement();
            }

            @Override
            public void acquire(final ISchedulableProcess process, final long num) {
                scheduledResourceProbe.takeMeasurement();
            }
        });
    }

    protected static TriggeredProbeList getTriggeredProbeSetWithCurrentTime(final ISimulationControl control,
            final TriggeredProbe additionalProbe) {
        return new TriggeredProbeList(Arrays.asList(new TakeCurrentSimulationTimeProbe(control), additionalProbe));
    }

    protected static EventProbeList getEventProbeSetWithCurrentTime(final ISimulationControl control,
            final EventProbe<?> additionalProbe) {
        return new EventProbeList(additionalProbe, Arrays.asList((TriggeredProbe) new TakeCurrentSimulationTimeProbe(
                control)));
    }

    /**
     * FIXME Assemblies are non-unique if assembled in two composite structures. Checking for the
     * path from system to assembled component Would be required to uniquely identify such
     * assemblies. [Lehrig]
     *
     * @param resource
     * @return
     */
    private static MeasuringPoint createMeasuringPoint(final IPassiveResource resource) {
        final AssemblyPassiveResourceMeasuringPoint mp = PCM_MEASURINGPOINT_FACTORY
                .createAssemblyPassiveResourceMeasuringPoint();
        mp.setAssembly(resource.getAssemblyContext());
        mp.setPassiveResource(resource.getResource());

        final ResourceURIMeasuringPoint measuringPoint = MEASURINGPOINT_FACTORY.createResourceURIMeasuringPoint();
        measuringPoint.setResourceURI(EMFLoadHelper.getResourceURI(resource.getResource()));
        measuringPoint.setMeasuringPoint(MeasuringPointUtility.measuringPointToString(mp));
        return measuringPoint;
    }

    private static MeasuringPoint createMeasuringPoint(final AbstractScheduledResource scheduledResource) {
        return createMeasuringPoint(scheduledResource, 0);
    }

    private static MeasuringPoint createMeasuringPoint(final AbstractScheduledResource scheduledResource,
            final int replicaID) {
        final ResourceURIMeasuringPoint measuringPoint = MEASURINGPOINT_FACTORY.createResourceURIMeasuringPoint();

        if (scheduledResource instanceof ScheduledResource) {
            final ScheduledResource resource = (ScheduledResource) scheduledResource;

            final ActiveResourceMeasuringPoint mp = PCM_MEASURINGPOINT_FACTORY.createActiveResourceMeasuringPoint();
            mp.setActiveResource(resource.getActiveResource());
            mp.setReplicaID(replicaID);

            measuringPoint.setResourceURI(EMFLoadHelper.getResourceURI(resource.getActiveResource()));
            measuringPoint.setMeasuringPoint(MeasuringPointUtility.measuringPointToString(mp));
        } else if (scheduledResource instanceof SimulatedLinkingResource) {
            final SimulatedLinkingResource resource = (SimulatedLinkingResource) scheduledResource;

            final LinkingResourceMeasuringPoint mp = PCM_MEASURINGPOINT_FACTORY.createLinkingResourceMeasuringPoint();
            mp.setLinkingResource(resource.getLinkingResource());

            measuringPoint.setResourceURI(EMFLoadHelper.getResourceURI(resource.getLinkingResource()));
            measuringPoint.setMeasuringPoint(MeasuringPointUtility.measuringPointToString(mp));
        } else {
            throw new IllegalArgumentException("Unknown variant of AbstractScheduledResource");
        }

        return measuringPoint;
    }
}

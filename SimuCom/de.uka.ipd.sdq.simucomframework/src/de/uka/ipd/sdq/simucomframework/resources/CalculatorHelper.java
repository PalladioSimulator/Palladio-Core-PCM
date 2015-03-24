package de.uka.ipd.sdq.simucomframework.resources;

import java.util.Arrays;
import java.util.List;

import org.palladiosimulator.commons.emfutils.EMFLoadHelper;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPoint;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringPointRepository;
import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointFactory;
import org.palladiosimulator.edp2.models.measuringpoint.ResourceURIMeasuringPoint;
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

    /** Default reporsitory where measuring points are attached to. */
    private static final MeasuringPointRepository MEASURING_POINT_REPOSITORY = MEASURINGPOINT_FACTORY
            .createMeasuringPointRepository();

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
     *            the Simucom Model
     */
    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model,
            final MeasuringPoint measuringPoint) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildWaitingTimeCalculator(measuringPoint, startStopProbes);

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
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param resource
     *            the resource
     * @param model
     *            the Simucom Model
     */
    public static void setupWaitingTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        setupWaitingTimeCalculator(resource, model, createMeasuringPoint(resource));
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
    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model,
            final MeasuringPoint measuringPoint) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final List<Probe> startStopProbes = buildStartStopProbes(model);
        ctx.getCalculatorFactory().buildHoldingTimeCalculator(measuringPoint, startStopProbes);

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
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param resource
     *            the resource
     * @param model
     *            the Simucom Model
     */
    public static void setupHoldTimeCalculator(final IPassiveResource resource, final SimuComModel model) {
        setupHoldTimeCalculator(resource, model, createMeasuringPoint(resource));
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
    public static void setupDemandCalculator(final AbstractScheduledResource scheduledResource,
            final SimuComModel model, final MeasuringPoint measuringPoint) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();
        final Probe scheduledResourceProbe = getEventProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakeScheduledResourceDemandProbe(scheduledResource));
        ctx.getCalculatorFactory().buildResourceDemandCalculator(measuringPoint, scheduledResourceProbe);
    }

    /**
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param scheduledResource
     *            the resource
     * @param model
     *            the Simucom Model
     */
    public static void setupDemandCalculator(final AbstractScheduledResource scheduledResource, final SimuComModel model) {
        setupDemandCalculator(scheduledResource, model, createMeasuringPoint(scheduledResource));
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
            final SimuComModel model, final MeasuringPoint measuringPoint, final int replicaID) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakeScheduledResourceStateProbe(scheduledResource, replicaID));
        ctx.getCalculatorFactory().buildStateOfActiveResourceCalculator(measuringPoint, scheduledResourceProbe);

        scheduledResource.addStateListener(new IStateListener() {
            @Override
            public void stateChanged(final long state, final int instanceId) {
                scheduledResourceProbe.takeMeasurement();
            }
        }, replicaID);
    }

    /**
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param resource
     *            the scheduledResource
     * @param model
     *            the Simucom Model
     */
    public static void setupActiveResourceStateCalculator(final AbstractScheduledResource scheduledResource,
            final SimuComModel model) {
        // setup a calculator for each instance
        for (int instance = 0; instance < scheduledResource.getNumberOfInstances(); instance++) {
            MeasuringPoint measurementPoint = createMeasuringPoint(scheduledResource, instance);
            setupActiveResourceStateCalculator(scheduledResource, model, measurementPoint, instance);
        }
    }

    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource resource,
            final SimuComModel model, final MeasuringPoint measuringPoint) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        resource.addOverallUtilizationListener(new IOverallUtilizationListener() {

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

    /**
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param scheduledResource
     *            the resource
     * @param model
     *            the Simucom Model
     */
    public static void setupOverallUtilizationCalculator(final AbstractScheduledResource resource,
            final SimuComModel model) {
        setupOverallUtilizationCalculator(resource, model, createMeasuringPoint(resource));
    }

    public static void setupPassiveResourceStateCalculator(final IPassiveResource resource, final SimuComModel model,
            final MeasuringPoint measuringPoint) {
        final ProbeFrameworkContext ctx = model.getProbeFrameworkContext();

        final TriggeredProbe scheduledResourceProbe = getTriggeredProbeSetWithCurrentTime(model.getSimulationControl(),
                new TakePassiveResourceStateProbe(resource));
        ctx.getCalculatorFactory().buildStateOfPassiveResourceCalculator(measuringPoint, scheduledResourceProbe);

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

    /**
     * Convenient method in case measuring point has to be created anew.
     * 
     * @param scheduledResource
     *            the resource
     * @param model
     *            the Simucom Model
     */
    public static void setupPassiveResourceStateCalculator(final IPassiveResource resource, final SimuComModel model) {
        setupPassiveResourceStateCalculator(resource, model, createMeasuringPoint(resource));
    }

    public static TriggeredProbeList getTriggeredProbeSetWithCurrentTime(final ISimulationControl control,
            final TriggeredProbe additionalProbe) {
        return new TriggeredProbeList(Arrays.asList(new TakeCurrentSimulationTimeProbe(control), additionalProbe));
    }

    public static EventProbeList getEventProbeSetWithCurrentTime(final ISimulationControl control,
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
        measuringPoint.setMeasuringPoint(mp.getStringRepresentation());
        putIntoRepository(measuringPoint);
        return measuringPoint;
    }

    private static MeasuringPoint createMeasuringPoint(final AbstractScheduledResource scheduledResource) {
        return createMeasuringPoint(scheduledResource, 0);
    }

    private static MeasuringPoint createMeasuringPoint(final AbstractScheduledResource scheduledResource,
            final int replicaID) {
        final MeasuringPoint measuringPoint;

        if (scheduledResource instanceof ScheduledResource) {
            measuringPoint = createActiveResourceMeasuringPoint((ScheduledResource) scheduledResource, replicaID);
        } else if (scheduledResource instanceof SimulatedLinkingResource) {
            measuringPoint = createLinkingResourceMeasuringPoint((SimulatedLinkingResource) scheduledResource);
        } else {
            throw new IllegalArgumentException("Unknown variant of AbstractScheduledResource");
        }

        putIntoRepository(measuringPoint);
        return measuringPoint;
    }

    private static ActiveResourceMeasuringPoint createActiveResourceMeasuringPoint(
            final ScheduledResource scheduledResource, final int replicaID) {
        final ActiveResourceMeasuringPoint measuringPoint = PCM_MEASURINGPOINT_FACTORY
                .createActiveResourceMeasuringPoint();
        measuringPoint.setActiveResource(scheduledResource.getActiveResource());
        measuringPoint.setReplicaID(replicaID);
        return measuringPoint;
    }

    private static LinkingResourceMeasuringPoint createLinkingResourceMeasuringPoint(
            final SimulatedLinkingResource simulatedLinkingResource) {
        final LinkingResourceMeasuringPoint measuringPoint = PCM_MEASURINGPOINT_FACTORY
                .createLinkingResourceMeasuringPoint();
        measuringPoint.setLinkingResource(simulatedLinkingResource.getLinkingResource());
        return measuringPoint;
    }

    private static void putIntoRepository(final MeasuringPoint measuringPoint) {
        MEASURING_POINT_REPOSITORY.getMeasuringPoints().add(measuringPoint);
        measuringPoint.setMeasuringPointRepository(MEASURING_POINT_REPOSITORY);
    }
}

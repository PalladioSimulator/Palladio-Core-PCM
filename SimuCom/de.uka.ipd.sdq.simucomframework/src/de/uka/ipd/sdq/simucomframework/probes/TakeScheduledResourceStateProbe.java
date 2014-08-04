package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.BasicObjectStateProbe;

import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;

/**
 * Measures a CPU state metric (dimensionless) by requesting the queue length from the scheduled CPU
 * resource (observed state object). Because scheduled resources can have many instances (e.g., a
 * CPU can have many cores), a pointer to the concrete instance is used additionally.
 * 
 * @author Sebastian Lehrig, Steffen Becker
 */
public class TakeScheduledResourceStateProbe extends
        BasicObjectStateProbe<AbstractScheduledResource, Long, Dimensionless> {

    /** Pointer to the concrete instance of the scheduled resource, e.g., CPU 0 */
    private final int instance;

    /**
     * Default constructor.
     * 
     * @param scheduledResource
     *            The observer object is a scheduled resource, thus, allowing to request its queue
     *            length.
     * @param instance
     *            Pointer to the concrete instance of the scheduled resource, e.g., CPU 0.
     */
    public TakeScheduledResourceStateProbe(final AbstractScheduledResource scheduledResource, final int instance) {
        super(scheduledResource, MetricDescriptionConstants.STATE_OF_ACTIVE_RESOURCE_METRIC);
        this.instance = instance;
    }

    /**
     * Measures the queue length from the scheduled resources (observed state object).
     */
    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(getStateObject().getQueueLength(instance), Dimensionless.UNIT);
    }

}

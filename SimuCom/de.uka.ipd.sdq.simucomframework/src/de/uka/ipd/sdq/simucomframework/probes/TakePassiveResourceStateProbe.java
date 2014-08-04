package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.BasicObjectStateProbe;

import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * Measures a passive resource state metric (dimensionless) by calculating the difference between
 * the capacity of the passive resource (observed state object) and its available resources.
 * 
 * @author Sebastian Lehrig, Steffen Becker
 */
public class TakePassiveResourceStateProbe extends BasicObjectStateProbe<IPassiveResource, Long, Dimensionless> {

    /**
     * Default constructor.
     * 
     * @param passiveResource
     *            The observer object is a passive resource, thus, allowing to request its capacity
     *            and its available resources.
     */
    public TakePassiveResourceStateProbe(final IPassiveResource passiveResource) {
        super(passiveResource, MetricDescriptionConstants.STATE_OF_PASSIVE_RESOURCE_METRIC);
    }

    /**
     * Measures the difference of capacity and available resources as requested from the passive
     * resource (observed state object).
     */
    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(getStateObject().getCapacity() - getStateObject().getAvailable(), Dimensionless.UNIT);
    }
}

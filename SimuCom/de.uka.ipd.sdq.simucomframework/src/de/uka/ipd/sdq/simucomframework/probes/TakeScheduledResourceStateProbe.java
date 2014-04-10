package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import org.palladiosimulator.probespec.framework.constants.MetricDescriptionConstants;
import org.palladiosimulator.probespec.framework.probes.BasicObjectStateProbe;
import org.palladiosimulator.probespec.framework.requestcontext.RequestContext;

import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;

/**
 * ProbeStrategy which is able to measure the state of a
 * {@link AbstractScheduledResource}. The state is the total job count of the
 * resource.
 *
 * @author Philipp Merkle
 *
 */
public class TakeScheduledResourceStateProbe extends BasicObjectStateProbe<AbstractScheduledResource, Long, Dimensionless> {

    private final int instance;

    public TakeScheduledResourceStateProbe(final AbstractScheduledResource scheduledResource, final int instance) {
        super(scheduledResource,MetricDescriptionConstants.CPU_STATE_METRIC);
        this.instance = instance;
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(getStateObject().getQueueLength(instance), Dimensionless.UNIT);
    }

}

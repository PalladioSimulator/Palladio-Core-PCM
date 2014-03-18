package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;

/**
 * ProbeStrategy which is able to measure the state of a
 * {@link AbstractScheduledResource}. The state is the total job count of the
 * resource.
 *
 * @author Philipp Merkle
 *
 */
public class TakeScheduledResourceStateProbe extends BasicProbe<Long, Dimensionless> {

    public TakeScheduledResourceStateProbe() {
        super(MetricDescriptionConstants.CPU_STATE_METRIC);
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        final long state = 0;
        return Measure.valueOf(state, Dimensionless.UNIT);
    }
}

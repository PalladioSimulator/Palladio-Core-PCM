package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.simucomframework.resources.ScheduledResource;

/**
 * ProbeStrategy which is able to measure the demanded time of a {@link ScheduledResource}. The unit
 * is assumed to be {@link SI#SECOND}.
 * 
 * @author Steffen Becker, Philipp Merkle
 * 
 */
public class TakeScheduledResourceDemandProbe extends BasicProbe<Double, Duration> {

    public TakeScheduledResourceDemandProbe() {
        super(MetricDescriptionConstants.RESOURCE_DEMAND_METRIC);
    }

    @Override
    protected Measure<Double, Duration> getBasicMeasure(final RequestContext measurementContext) {
        final double demand = 0;
        return Measure.valueOf(demand, SI.SECOND);
    }
}

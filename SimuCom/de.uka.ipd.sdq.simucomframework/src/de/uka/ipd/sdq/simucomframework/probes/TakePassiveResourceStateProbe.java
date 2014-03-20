package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.scheduler.IPassiveResource;

/**
 * ProbeStrategy which is able to measure the state of a
 * {@link IPassiveResource}. The state is calculated as follows:
 * <code>state = capacity - available</code>.
 *
 * @author Philipp Merkle
 *
 */
public class TakePassiveResourceStateProbe extends BasicProbe<Long, Dimensionless> {

    private final IPassiveResource myResource;

    public TakePassiveResourceStateProbe(final IPassiveResource passiveResource) {
        super(MetricDescriptionConstants.PASSIVE_RESOURCE_STATE_METRIC);
        this.myResource = passiveResource;
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        final long state = myResource.getCapacity() - myResource.getAvailable();
        return Measure.valueOf(state, Dimensionless.UNIT);
    }
}

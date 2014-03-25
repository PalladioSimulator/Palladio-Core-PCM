package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicObjectStateProbe;
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
public class TakePassiveResourceStateProbe extends BasicObjectStateProbe<IPassiveResource, Long, Dimensionless> {

    public TakePassiveResourceStateProbe(final IPassiveResource passiveResource) {
        super(passiveResource,MetricDescriptionConstants.PASSIVE_RESOURCE_STATE_METRIC);
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(getStateObject().getCapacity() - getStateObject().getAvailable(), Dimensionless.UNIT);
    }
}

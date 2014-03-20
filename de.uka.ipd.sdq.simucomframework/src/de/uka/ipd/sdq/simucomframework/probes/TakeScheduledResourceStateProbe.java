package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.IStateListener;

/**
 * ProbeStrategy which is able to measure the state of a
 * {@link AbstractScheduledResource}. The state is the total job count of the
 * resource.
 *
 * @author Philipp Merkle
 *
 */
public class TakeScheduledResourceStateProbe extends BasicProbe<Long, Dimensionless> implements IStateListener {

    private final int instance;
    private long lastState;

    public TakeScheduledResourceStateProbe(final AbstractScheduledResource scheduledResource, final int instance) {
        super(MetricDescriptionConstants.CPU_STATE_METRIC);
        this.instance = instance;
        scheduledResource.addStateListener(this, instance);
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        final long state = lastState;
        return Measure.valueOf(state, Dimensionless.UNIT);
    }

    @Override
    public void stateChanged(final long queueLength, final int instanceId) {
        if (this.instance == instanceId) {
            this.lastState = queueLength;
        }
    }
}

package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;

/**
 * ProbeStrategy which is able to measure the type of an execution result.
 *
 * The execution result type is identified through its numeric ID.
 *
 * @author brosch
 *
 */
public class TakeExecutionResultProbe extends BasicProbe<Long, Dimensionless>{

    public TakeExecutionResultProbe() {
        super(MetricDescriptionConstants.EXECUTION_RESULT_METRIC);
    }

    @Override
    protected Measure<Long, Dimensionless> getBasicMeasure(final RequestContext measurementContext) {
        // TODO: Deliver correct state!
        final long stateId = 0;
        return Measure.valueOf(stateId, Dimensionless.UNIT);
    }
}

package de.uka.ipd.sdq.reliability.core.probe;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.unit.Unit;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicEventProbe;
import de.uka.ipd.sdq.reliability.core.FailureStatistics;
import de.uka.ipd.sdq.reliability.core.IFailureStatisticsListener;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;

/**
 * ProbeStrategy which is able to measure the type of an execution result.
 *
 * The execution result type is identified through its numeric ID.
 *
 * @author brosch
 *
 */
public class TakeExecutionResultProbe extends BasicEventProbe<FailureStatistics, Long, Dimensionless> implements IFailureStatisticsListener {

    public TakeExecutionResultProbe(final FailureStatistics failureStatistics) {
        super(failureStatistics,MetricDescriptionConstants.EXECUTION_RESULT_METRIC);
    }

    @Override
    protected void registerListener() {
        this.eventSource.addObserver(this);
    }

    @Override
    public void executionResultRecorder(final MarkovFailureType failureType) {
        this.notify(Measure.valueOf((long)this.eventSource.getExecutionResultId(failureType),Unit.ONE));
    }

}

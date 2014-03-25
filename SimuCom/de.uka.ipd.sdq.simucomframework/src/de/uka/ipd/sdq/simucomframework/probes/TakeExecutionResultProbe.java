package de.uka.ipd.sdq.simucomframework.probes;

import javax.measure.quantity.Dimensionless;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicEventProbe;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;

/**
 * ProbeStrategy which is able to measure the type of an execution result.
 *
 * The execution result type is identified through its numeric ID.
 *
 * @author brosch
 *
 */
public class TakeExecutionResultProbe extends BasicEventProbe<SimuComSimProcess, Long, Dimensionless> {

    public TakeExecutionResultProbe() {
        super(null,MetricDescriptionConstants.EXECUTION_RESULT_METRIC);
    }

    @Override
    protected void registerListener() {
    }

}

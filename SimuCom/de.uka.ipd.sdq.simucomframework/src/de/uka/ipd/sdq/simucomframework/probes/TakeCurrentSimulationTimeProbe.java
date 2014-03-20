package de.uka.ipd.sdq.simucomframework.probes;

import static javax.measure.unit.SI.SECOND;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.constants.MetricDescriptionConstants;
import de.uka.ipd.sdq.probespec.framework.probes.BasicProbe;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * ProbeStrategy which is able to measure the current simulated time. The
 * simulated time's unit is assumed to be {@link SI#SECOND}.
 *
 * @author Philipp Merkle
 *
 */
public class TakeCurrentSimulationTimeProbe extends BasicProbe<Double, Duration> {

    private final ISimulationControl simulationControl;

    public TakeCurrentSimulationTimeProbe(final ISimulationControl simulationControl) {
        super(MetricDescriptionConstants.POINT_IN_TIME_METRIC);
        if (simulationControl == null) {
            throw new IllegalArgumentException("Simulation control must not be null");
        }
        this.simulationControl = simulationControl;
    }

    @Override
    protected Measure<Double, Duration> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(this.simulationControl.getCurrentSimulationTime(), SECOND);
    }
}

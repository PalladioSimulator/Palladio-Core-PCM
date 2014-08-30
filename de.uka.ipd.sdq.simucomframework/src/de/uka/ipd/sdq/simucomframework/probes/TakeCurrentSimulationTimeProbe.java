package de.uka.ipd.sdq.simucomframework.probes;

import static javax.measure.unit.SI.SECOND;

import javax.measure.Measure;
import javax.measure.quantity.Duration;

import org.palladiosimulator.metricspec.constants.MetricDescriptionConstants;
import org.palladiosimulator.probeframework.measurement.RequestContext;
import org.palladiosimulator.probeframework.probes.BasicObjectStateProbe;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * Measures a point in time metric (in seconds) by requesting the current simulation time from the
 * simulation controller (observed state object).
 *
 * @author Sebastian Lehrig, Steffen Becker
 */
public class TakeCurrentSimulationTimeProbe extends BasicObjectStateProbe<ISimulationControl, Double, Duration> {

    /**
     * Default constructor.
     * 
     * @param simulationControl
     *            The observer object is a simulation control, thus, allowing to request the current
     *            simulation time.
     */
    public TakeCurrentSimulationTimeProbe(final ISimulationControl simulationControl) {
        super(simulationControl, MetricDescriptionConstants.POINT_IN_TIME_METRIC);
    }

    /**
     * Measures the current simulation time from the simulation control (observed state object).
     */
    @Override
    protected Measure<Double, Duration> getBasicMeasure(final RequestContext measurementContext) {
        return Measure.valueOf(getStateObject().getCurrentSimulationTime(), SECOND);
    }
}

package edu.kit.ipd.sdq.simcomp.middleware.probespec.probes;

import static javax.measure.unit.SI.SECOND;

import javax.measure.Measure;
import javax.measure.quantity.Duration;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeType;
import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationControl;

/**
 * ProbeStrategy which is able to measure the current simulated time. The simulated time's unit is
 * assumed to be {@link SI#SECOND}.
 * 
 * @author Philipp Merkle
 * 
 */
public class TakeSimulatedTimeStrategy implements IProbeStrategy {

    /**
     * {@inheritDoc}
     * 
     * @param o
     *            expects a {@link ISimulationControl}
     */
    @Override
    public ProbeSample<Double, Duration> takeSample(String probeId, Object... o) {
        double simTime = 0;
        if (o.length >= 1 && (o[0] instanceof ISimulationControl || o[0] instanceof Double)) {
            if (o[0] instanceof ISimulationControl) {
                ISimulationControl simControl = (ISimulationControl) o[0];
                simTime = simControl.getCurrentSimulationTime();
            } else {
                simTime = (Double) o[0];
            }
        } else {
            throw new IllegalArgumentException("Expected an argument implementing "
                    + ISimulationControl.class.getSimpleName() + " or an argument of type "
                    + Double.class.getSimpleName() + ".");
        }

        // Here it is assumed that the simulation time's unit is SI.SECOND
        Measure<Double, Duration> time = Measure.valueOf(simTime, SECOND);
        ProbeSample<Double, Duration> sample = new ProbeSample<Double, Duration>(time, probeId, ProbeType.CURRENT_TIME);

        return sample;
    }

}

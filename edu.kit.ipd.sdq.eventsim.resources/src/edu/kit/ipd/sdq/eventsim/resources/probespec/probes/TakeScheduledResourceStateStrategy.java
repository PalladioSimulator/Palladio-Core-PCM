//package edu.kit.ipd.sdq.eventsim.resources.probespec.probes;
//
//import javax.measure.Measure;
//import javax.measure.quantity.Dimensionless;
//
//import de.uka.ipd.sdq.probespec.framework.ProbeSample;
//import de.uka.ipd.sdq.probespec.framework.ProbeType;
//import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
//import edu.kit.ipd.sdq.eventsim.resources.entities.SimActiveResource;
//
///**
// * ProbeStrategy which is able to measure the state of a {@link SimActiveResource}. The state is the
// * total job count of the resource.
// * 
// * @author Philipp Merkle
// * 
// */
//public class TakeScheduledResourceStateStrategy implements IProbeStrategy {
//
//    /**
//     * {@inheritDoc}
//     * 
//     * @param o
//     *            expects an {@link Integer} representing the resource state
//     */
//    @Override
//    public ProbeSample<Integer, Dimensionless> takeSample(String probeId, Object... o) {
//        Integer state = null;
//        if (o.length >= 1 && o[0] instanceof Integer) {
//            state = (Integer) o[0];
//        } else {
//            throw new IllegalArgumentException("Expected an argument of type " + Integer.class.getSimpleName() + ".");
//        }
//
//        Measure<Integer, Dimensionless> stateMeasure = Measure.valueOf(state, Dimensionless.UNIT);
//        ProbeSample<Integer, Dimensionless> sample = new ProbeSample<Integer, Dimensionless>(stateMeasure, probeId,
//                ProbeType.RESOURCE_STATE);
//
//        return sample;
//    }
//
//}

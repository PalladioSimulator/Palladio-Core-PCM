//package edu.kit.ipd.sdq.eventsim.resources.probespec.probes;
//
//import javax.measure.Measure;
//import javax.measure.quantity.Dimensionless;
//
//import de.uka.ipd.sdq.probespec.framework.ProbeSample;
//import de.uka.ipd.sdq.probespec.framework.ProbeType;
//import de.uka.ipd.sdq.probespec.framework.probes.IProbeStrategy;
//import edu.kit.ipd.sdq.eventsim.resources.entities.SimPassiveResource;
//
///**
// * ProbeStrategy which is able to measure the state of a {@link SimPassiveResource}. The state is
// * calculated as follows: <code>state = capacity - available</code>.
// * 
// * @author Philipp Merkle
// * 
// */
//public class TakePassiveResourceStateStrategy implements IProbeStrategy {
//
//    /**
//     * @param o
//     *            expects a {@link SimPassiveResource}
//     */
//    @Override
//    public ProbeSample<Integer, Dimensionless> takeSample(String probeId, Object... o) {
//        SimPassiveResource r = null;
//        if (o.length >= 1 && o[0] instanceof SimPassiveResource) {
//            r = (SimPassiveResource) o[0];
//        } else {
//            throw new IllegalArgumentException("Expected an argument of type "
//                    + SimPassiveResource.class.getSimpleName() + ".");
//        }
//
//        int state = r.getCapacity() - r.getAvailable();
//        Measure<Integer, Dimensionless> stateMeasure = Measure.valueOf(state, Dimensionless.UNIT);
//        ProbeSample<Integer, Dimensionless> sample = new ProbeSample<Integer, Dimensionless>(stateMeasure, probeId,
//                ProbeType.RESOURCE_STATE);
//
//        return sample;
//    }
//
//}

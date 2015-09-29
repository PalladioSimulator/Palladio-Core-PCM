//package edu.kit.ipd.sdq.simcomp.middleware.probespec;
//
//import org.palladiosimulator.probeframework.measurement.RequestContext;
//
///**
// * A {@link RegionBasedGarbageCollector}, specialized to be used within
// * simulation components. It enables a {@link RequestContext} to be used as
// * region identifier. More precisely, the specified {@link RequestContext} gets
// * translated to the appropriate region identifier.
// * 
// * @author Philipp Merkle
// * @author Christoph Föhrdes
// * 
// */
//public class SimCompGarbageCollector extends RegionBasedGarbageCollector<RequestContext> {
//
//	private ISampleBlackboard blackboard;
//
//	/**
//	 * Constructs a garbage collector for the measurements on the specified
//	 * blackboard.
//	 * 
//	 * @param blackboard
//	 *            the blackboard whose measurements are to be collected
//	 */
//	public SimCompGarbageCollector(ISampleBlackboard blackboard) {
//		this.blackboard = blackboard;
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public void collectRegionSamples(RequestContext regionId) {
//		blackboard.deleteSamplesInRequestContext(regionId);
//	}
//
//	/**
//	 * {@inheritDoc}
//	 */
//	@Override
//	public RequestContext obtainRegionId(ProbeSetAndRequestContext sampleId) {
//		return sampleId.getCtxID().rootContext();
//	}
//
//}

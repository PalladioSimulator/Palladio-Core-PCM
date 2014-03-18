package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.probespec.framework.ISampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.RegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.requestcontext.ProbeAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.requestcontext.RequestContext;

/**
 * A {@link RegionBasedGarbageCollector}, specialised to be used within SimuCom.
 * It enables a {@link RequestContext} to be used as region identifier. More
 * precisely, the specified {@link RequestContext} gets translated to the
 * appropriate region identifier.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimuComGarbageCollector extends
		RegionBasedGarbageCollector<RequestContext> {

	private ISampleBlackboard blackboard;

	public SimuComGarbageCollector(ISampleBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public void collectRegionSamples(RequestContext regionId) {
		blackboard.deleteSamplesInRequestContext(regionId);
	}

	@Override
	public RequestContext obtainRegionId(ProbeAndRequestContext sampleId) {
		return sampleId.getCtxID().rootContext();
	}

}

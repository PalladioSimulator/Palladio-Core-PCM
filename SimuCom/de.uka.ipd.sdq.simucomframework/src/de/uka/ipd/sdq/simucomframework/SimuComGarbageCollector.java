package de.uka.ipd.sdq.simucomframework;

import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.garbagecollection.RegionBasedGarbageCollector;

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

	private SampleBlackboard blackboard;

	public SimuComGarbageCollector(SampleBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public void collectRegionSamples(RequestContext regionId) {
		blackboard.deleteSamplesInRequestContext(regionId);
	}

	@Override
	public RequestContext obtainRegionId(ProbeSetAndRequestContext sampleId) {
		return sampleId.getCtxID().rootContext();
	}

}

package de.uka.ipd.sdq.probespec.framework.test.mockup;

import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.RegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;

public class RegionBasedGarbageCollectorMockup extends
		RegionBasedGarbageCollector<String> {

	private SampleBlackboard blackboard;
	
	public RegionBasedGarbageCollectorMockup(SampleBlackboard blackboard) {
		this.blackboard = blackboard;
	}

	@Override
	public void collectRegionSamples(String regionId) {
		blackboard.deleteSamplesInRequestContext(new RequestContext(regionId));
	}
	
	@Override
	public String obtainRegionId(ProbeSetAndRequestContext c) {
		return c.getCtxID().getRequestContextId();
	}
	
}

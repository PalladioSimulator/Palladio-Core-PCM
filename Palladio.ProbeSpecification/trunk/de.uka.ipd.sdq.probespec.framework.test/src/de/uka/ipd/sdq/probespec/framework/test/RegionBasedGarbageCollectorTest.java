package de.uka.ipd.sdq.probespec.framework.test;

import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.RegionBasedGarbageCollector;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.test.mockup.BlackboardListenerMockup;
import de.uka.ipd.sdq.probespec.framework.test.mockup.RegionBasedGarbageCollectorMockup;
import de.uka.ipd.sdq.probespec.framework.test.utils.TestUtils;
import junit.framework.TestCase;

public class RegionBasedGarbageCollectorTest extends TestCase {
	
	private SampleBlackboard blackboard;
	
	private RegionBasedGarbageCollector<String> garbageCollector;
	
	@Override
	protected void setUp() throws Exception {
		blackboard = new SampleBlackboard();
		blackboard.addBlackboardListener(new BlackboardListenerMockup(BlackboardVote.RETAIN));
		garbageCollector = new RegionBasedGarbageCollectorMockup(blackboard);
	}

	public void testGarbageCollectionAfterRegionClosed() {
		String contextOne = "context1";
		String contextTwo = "context2";
		
		// enter first region and add two samples
		garbageCollector.enterRegion(contextOne);
		blackboard.addSample(new ProbeSetSample(TestUtils
				.createDummyProbeSample(1), new RequestContext(contextOne), null,
				1));
		blackboard.addSample(new ProbeSetSample(TestUtils
				.createDummyProbeSample(2), new RequestContext(contextOne), null,
				2));
		assertEquals(2, blackboard.size());
		
		// enter second region and add a sample
		garbageCollector.enterRegion(contextTwo);
		blackboard.addSample(new ProbeSetSample(TestUtils
				.createDummyProbeSample(3), new RequestContext(contextTwo), null,
				3));
		assertEquals(3, blackboard.size());
		
		// leave second region...
		garbageCollector.leaveRegion(contextTwo);
		// ...and check whether contained samples are deleted 
		assertEquals(2, blackboard.size());
		
		// leave first region...
		garbageCollector.leaveRegion(contextOne);
		// ...and check whether contained samples are deleted
		assertEquals(0, blackboard.size());
	}
	
}

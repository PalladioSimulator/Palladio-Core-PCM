package de.uka.ipd.sdq.probespec.framework.test;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.RequestContextID;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSampleID;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;

/**
 * 
 * @author Faber
 * 
 */
public class SampleBlackboardTest extends TestCase {
	SampleBlackboard blackboard;

	public SampleBlackboardTest() {
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testGarbageCollection() {
		ProbeSetSample pss1 = new ProbeSetSample(null, new RequestContextID("1"), "1",
				"1");
		ProbeSetSample pss2 = new ProbeSetSample(null, new RequestContextID("2"), "1",
				"1");
		pss1.addToTimeToLive(1);
		pss2.addToTimeToLive(2);

		blackboard = new SampleBlackboard();
		blackboard.addProbeSetSample(pss1);
		blackboard.addProbeSetSample(pss2);
		assertEquals(2, blackboard.getHashMapSize());
		blackboard.getProbeSetSample(pss1.getProbeSetSampleID());
		assertEquals(1, blackboard.getHashMapSize());

		blackboard.getProbeSetSample(pss2.getProbeSetSampleID());
		assertEquals(1, blackboard.getHashMapSize());

		blackboard.getProbeSetSample(pss2.getProbeSetSampleID());
		assertEquals(0, blackboard.getHashMapSize());

	}

	public void testSamePSSID() {
		blackboard = new SampleBlackboard();
		ProbeSetSample pss1 = new ProbeSetSample(null, new RequestContextID("1"), "1",
				"1");
		ProbeSetSample pss2 = new ProbeSetSample(null, new RequestContextID("1"), "1",
				"2");
		ProbeSetSample pss3 = new ProbeSetSample(null, new RequestContextID("2"), "1",
				"1");
		ProbeSetSample pss4 = new ProbeSetSample(null, new RequestContextID("2"), "1",
				"2");
		pss1.addToTimeToLive(1);
		pss2.addToTimeToLive(1);
		pss3.addToTimeToLive(1);
		pss4.addToTimeToLive(1);
		blackboard.addProbeSetSample(pss1);
		blackboard.addProbeSetSample(pss2);
		blackboard.addProbeSetSample(pss3);
		blackboard.addProbeSetSample(pss4);
		
		assertSame(pss1, blackboard.getProbeSetSample(pss1
				.getProbeSetSampleID()));
		assertSame(pss2, blackboard.getProbeSetSample(pss2
				.getProbeSetSampleID()));
		assertSame(pss3, blackboard.getProbeSetSample(pss3
				.getProbeSetSampleID()));
		assertSame(pss4, blackboard.getProbeSetSample(pss4
				.getProbeSetSampleID()));
	}

	public void testDifferentPSSID() {
		blackboard = new SampleBlackboard();
		ProbeSetSample pss1 = new ProbeSetSample(null, new RequestContextID("1"), "1",
				"1");
		ProbeSetSample pss2 = new ProbeSetSample(null, new RequestContextID("2"), "1",
				"1");
		pss1.addToTimeToLive(5);
		pss2.addToTimeToLive(5);
		blackboard.addProbeSetSample(pss1);
		blackboard.addProbeSetSample(pss2);
		ProbeSetSampleID pssID1 = new ProbeSetSampleID("1", new RequestContextID("1"));
		ProbeSetSampleID pssID2 = new ProbeSetSampleID("1", new RequestContextID("2"));
		assertSame(pss1, blackboard.getProbeSetSample(pssID1));
		assertNotSame(pss2, blackboard.getProbeSetSample(pssID1));
		
		assertSame(pss2, blackboard.getProbeSetSample(pssID2));
		assertNotSame(pss1, blackboard.getProbeSetSample(pssID2));
	}

}

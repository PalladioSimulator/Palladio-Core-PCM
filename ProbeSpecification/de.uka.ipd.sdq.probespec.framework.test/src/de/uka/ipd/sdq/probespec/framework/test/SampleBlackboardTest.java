package de.uka.ipd.sdq.probespec.framework.test;

import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Dimensionless;
import javax.measure.quantity.Quantity;

import junit.framework.TestCase;
import de.uka.ipd.sdq.probespec.framework.BlackboardVote;
import de.uka.ipd.sdq.probespec.framework.ProbeSample;
import de.uka.ipd.sdq.probespec.framework.ProbeSetAndRequestContext;
import de.uka.ipd.sdq.probespec.framework.ProbeSetSample;
import de.uka.ipd.sdq.probespec.framework.RequestContext;
import de.uka.ipd.sdq.probespec.framework.SampleBlackboard;
import de.uka.ipd.sdq.probespec.framework.test.mockup.BlackboardListenerMockup;
import de.uka.ipd.sdq.probespec.framework.test.utils.TestUtils;

/**
 * Tests the {@link SampleBlackboard}.
 * 
 * @author Faber
 * @author Philipp Merkle
 * 
 */
public class SampleBlackboardTest extends TestCase {

	private SampleBlackboard blackboard;

	@Override
	protected void setUp() throws Exception {
		blackboard = new SampleBlackboard();
	}

	public void testGetProbeSetSample() {
		// blackboard should retain added samples
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.RETAIN));

		/*
		 * Build a context hierarchy as follows:
		 * 
		 * Context1 Context1-1 Context1-2 Context1-2-1
		 */
		RequestContext context1 = new RequestContext("Context1");
		RequestContext context1_1 = new RequestContext("Context1-1", context1);
		RequestContext context1_2 = new RequestContext("Context1-2", context1);
		RequestContext context1_2_1 = new RequestContext("Context1-2-1",
				context1_2);

		// create sample in context1 and publish
		ProbeSetSample sample1 = new ProbeSetSample(TestUtils
				.createDummyProbeSample(1), context1, null, 1);
		blackboard.addSample(sample1);

		assertEquals(sample1, blackboard
				.getSample(new ProbeSetAndRequestContext(1,
						context1)));
		assertEquals(sample1, blackboard
				.getSample(new ProbeSetAndRequestContext(1,
						context1_1)));
		assertEquals(sample1, blackboard
				.getSample(new ProbeSetAndRequestContext(1,
						context1_2)));
		assertEquals(sample1, blackboard
				.getSample(new ProbeSetAndRequestContext(1,
						context1_2_1)));

		// create sample in context 1-2 and publish
		ProbeSetSample sample1_2 = new ProbeSetSample(TestUtils
				.createDummyProbeSample(2), context1_2, null, 2);
		blackboard.addSample(sample1_2);

		assertNull(blackboard.getSample(new ProbeSetAndRequestContext(
				2, context1)));
		assertNull(blackboard.getSample(new ProbeSetAndRequestContext(
				2, context1_1)));
		assertEquals(sample1_2, blackboard
				.getSample(new ProbeSetAndRequestContext(2,
						context1_2)));
		assertEquals(sample1_2, blackboard
				.getSample(new ProbeSetAndRequestContext(2,
						context1_2_1)));
	}

	/**
	 * Let some listeners vote for discard and one listener vote for retain. The
	 * added sample should be retained.
	 */
	public void testRetainVote() {
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.DISCARD));
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.RETAIN));
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.DISCARD));

		ProbeSetSample sample = new ProbeSetSample(TestUtils
				.createDummyProbeSample(1),
				RequestContext.EMPTY_REQUEST_CONTEXT, null, 1);
		blackboard.addSample(sample);

		assertEquals(sample, blackboard
				.getSample(new ProbeSetAndRequestContext(1,
						RequestContext.EMPTY_REQUEST_CONTEXT)));
	}

	/**
	 * Let some listeners vote for discard, none listener vote for retain. The
	 * added sample should be discarded.
	 */
	public void testDiscardVote() {
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.DISCARD));
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.DISCARD));

		ProbeSetSample sample = new ProbeSetSample(TestUtils
				.createDummyProbeSample(1),
				RequestContext.EMPTY_REQUEST_CONTEXT, null, 1);
		blackboard.addSample(sample);

		assertNull(blackboard.getSample(new ProbeSetAndRequestContext(
				1, RequestContext.EMPTY_REQUEST_CONTEXT)));
	}

	public void testSamePSSID() {
		// blackboard should retain added samples
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.RETAIN));

		ProbeSetSample pss1 = new ProbeSetSample(null, new RequestContext("1"),
				"1", 1);
		ProbeSetSample pss2 = new ProbeSetSample(null, new RequestContext("1"),
				"1", 2);
		ProbeSetSample pss3 = new ProbeSetSample(null, new RequestContext("2"),
				"1", 1);
		ProbeSetSample pss4 = new ProbeSetSample(null, new RequestContext("2"),
				"1", 2);
		blackboard.addSample(pss1);
		blackboard.addSample(pss2);
		blackboard.addSample(pss3);
		blackboard.addSample(pss4);

		assertSame(pss1, blackboard.getSample(pss1
				.getProbeSetAndRequestContext()));
		assertSame(pss2, blackboard.getSample(pss2
				.getProbeSetAndRequestContext()));
		assertSame(pss3, blackboard.getSample(pss3
				.getProbeSetAndRequestContext()));
		assertSame(pss4, blackboard.getSample(pss4
				.getProbeSetAndRequestContext()));
	}

	public void testDifferentPSSID() {
		// blackboard should retain added samples
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.RETAIN));

		ProbeSetSample pss1 = new ProbeSetSample(null, new RequestContext("1"),
				"1", 1);
		ProbeSetSample pss2 = new ProbeSetSample(null, new RequestContext("2"),
				"1", 1);
		blackboard.addSample(pss1);
		blackboard.addSample(pss2);
		ProbeSetAndRequestContext pssID1 = new ProbeSetAndRequestContext(1,
				new RequestContext("1"));
		ProbeSetAndRequestContext pssID2 = new ProbeSetAndRequestContext(1,
				new RequestContext("2"));
		assertSame(pss1, blackboard.getSample(pssID1));
		assertNotSame(pss2, blackboard.getSample(pssID1));

		assertSame(pss2, blackboard.getSample(pssID2));
		assertNotSame(pss1, blackboard.getSample(pssID2));
	}
	
	public void testSize() {
		// blackboard should retain added samples
		blackboard.addBlackboardListener(new BlackboardListenerMockup(
				BlackboardVote.RETAIN));
		
		// test empty blackboard
		assertEquals(0, blackboard.size());
		
		// add one element and test the size
		ProbeSetSample pss1 = new ProbeSetSample(TestUtils
				.createDummyProbeSample(0), new RequestContext("context1"), null,
				1);
		blackboard.addSample(pss1);
		assertEquals(1, blackboard.size());
		
		// add a second element and test the size
		ProbeSetSample pss2 = new ProbeSetSample(TestUtils
				.createDummyProbeSample(1), new RequestContext("context1"), null,
				2);
		blackboard.addSample(pss2);
		assertEquals(2, blackboard.size());
		
		// add a third element, now in a new context
		ProbeSetSample pss3 = new ProbeSetSample(TestUtils
				.createDummyProbeSample(2), new RequestContext("context2"), null,
				3);
		blackboard.addSample(pss3);
		assertEquals(3, blackboard.size());
	}

}

/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate;

/**
 * @author Tom Beyer
 *
 */
public class HeuristicCandidateTest {
	
	private TacticsResultCandidate candidate;
	private static final double EPSILON = 0.00000001;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		candidate = new TacticsResultCandidate(null, null, null, "test");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate#getCandidateWeight()}.
	 */
	@Test
	public final void testGetCandidateWeight() {
		assertEquals(0.0, candidate.getCandidateWeight(), EPSILON);
		Random random = new Random();
		for (int i = 0; i < 100; i++) {
			double r = random.nextDouble();
			candidate.setCandidateWeight(r);
			assertEquals(r, candidate.getCandidateWeight(), EPSILON);
		}
		candidate.setCandidateWeight(1.0);
		assertEquals(1.0, candidate.getCandidateWeight(), EPSILON);
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate#setCandidateWeight(double)}.
	 */
	@Test
	public final void testSetCandidateWeight() {
		testGetCandidateWeight();
		try {
			candidate.setCandidateWeight(2);
		} catch (IllegalArgumentException e) {
			return;
		} 
		fail();
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate#getHeuristic()}.
	 */
	@Test
	public final void testGetHeuristic() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate#setHeuristic(de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.IHeuristic)}.
	 */
	@Test
	public final void testSetHeuristic() {
//		fail("Not yet implemented"); // TODO
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.TacticsResultCandidate#getFinalWeight()}.
	 */
	@Test
	public final void testGetFinalWeight() {
//		fail("Not yet implemented"); // TODO
	}

}

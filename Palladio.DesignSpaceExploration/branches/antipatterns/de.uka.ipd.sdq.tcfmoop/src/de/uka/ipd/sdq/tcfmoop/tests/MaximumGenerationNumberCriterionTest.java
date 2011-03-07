/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.tcfmoop.config.MaxGenerationNumberConfig;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MaxGenerationNumber;

/**
 * @author Atanas Dimitrov
 *
 */
public class MaximumGenerationNumberCriterionTest {
	MaxGenerationNumberConfig mgnconf;
	MaxGenerationNumber mgncrit;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		mgnconf = new MaxGenerationNumberConfig();
		mgnconf.setMaximumNumberOfIterations(5);
		if(!mgnconf.validateConfiguration()){
			throw new Exception();
		}
		mgncrit = new MaxGenerationNumber();
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testGetEvaluationResult() {
		mgncrit.initialize(mgnconf, null, null);
		mgncrit.evaluate(4, 0);
		assertFalse(mgncrit.getEvaluationResult());
		
		mgncrit.evaluate(5, 0);
		assertTrue(mgncrit.getEvaluationResult());
		
		mgncrit.evaluate(6, 0);
		assertTrue(mgncrit.getEvaluationResult());
	}

}

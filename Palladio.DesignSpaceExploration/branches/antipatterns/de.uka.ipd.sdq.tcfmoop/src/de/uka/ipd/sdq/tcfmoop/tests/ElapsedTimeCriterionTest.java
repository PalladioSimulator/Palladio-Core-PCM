/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig;
import de.uka.ipd.sdq.tcfmoop.config.ElapsedTimeConfig.TimeType;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ElapsedTimeCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class ElapsedTimeCriterionTest {
	ElapsedTimeConfig etconfUser;
	ElapsedTimeCriterion etcritUser;
	ElapsedTimeConfig etconfCPUFalse;
	ElapsedTimeCriterion etcritCPUFalse;
	ElapsedTimeConfig etconfCPUTrue;
	ElapsedTimeCriterion etcritCPUTrue;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		//User Time
		etconfUser = new ElapsedTimeConfig();
		etconfUser.setExecutionInterval(1000*60*60);
		etconfUser.setTimeType(TimeType.USER_TIME);
		if(!etconfUser.validateConfiguration()){
			throw new Exception();
		}
		etcritUser = new ElapsedTimeCriterion();
		
		//CPU False
		etconfCPUFalse = new ElapsedTimeConfig();
		etconfCPUFalse.setExecutionInterval(1000*60*60);
		etconfCPUFalse.setTimeType(TimeType.CPU_TIME);
		if(!etconfCPUFalse.validateConfiguration()){
			throw new Exception();
		}
		etcritCPUFalse = new ElapsedTimeCriterion();
		
		//CPU True
		etconfCPUTrue = new ElapsedTimeConfig();
		etconfCPUTrue.setExecutionInterval(10);
		etconfCPUTrue.setTimeType(TimeType.CPU_TIME);
		if(!etconfCPUTrue.validateConfiguration()){
			throw new Exception();
		}
		etcritCPUTrue = new ElapsedTimeCriterion();
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testGetEvaluationResult() {
		etcritUser.initialize(etconfUser, null, null);
		etcritUser.evaluate(251, System.currentTimeMillis());
		assertFalse(etcritUser.getEvaluationResult());
		etcritUser.evaluate(251, System.currentTimeMillis() + (1000*60*60*2));
		assertTrue(etcritUser.getEvaluationResult());
		
		etcritCPUFalse.initialize(etconfCPUFalse, null, null);
		etcritCPUFalse.evaluate(251, 0);
		assertFalse(etcritCPUFalse.getEvaluationResult());
		
		etcritCPUTrue.initialize(etconfCPUTrue, null, null);
		etcritCPUTrue.evaluate(251, 0);
		assertTrue(etcritCPUTrue.getEvaluationResult());
	}

}

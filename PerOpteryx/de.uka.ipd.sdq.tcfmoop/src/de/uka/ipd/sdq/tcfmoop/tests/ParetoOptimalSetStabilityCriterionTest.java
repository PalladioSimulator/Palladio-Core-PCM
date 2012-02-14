/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.opt4j.common.archive.DefaultArchive;
import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.domination.ParetoDomination;

import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig;
import de.uka.ipd.sdq.tcfmoop.config.ParetoOptimalSetStabilityConfig.EvaluationMode;
import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.ParetoOptimalSetStabilityCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class ParetoOptimalSetStabilityCriterionTest {
	ParetoOptimalSetStabilityConfig possconf;
	ParetoOptimalSetStabilityCriterion posscrit;
	
	Archive archive = new DefaultArchive();

	Objectives o1 = new Objectives(new ParetoDomination());
	Objectives o2 = new Objectives(new ParetoDomination());
	Objectives o3 = new Objectives(new ParetoDomination());
	Objectives o4 = new Objectives(new ParetoDomination());
	Objectives o5 = new Objectives(new ParetoDomination());
	
	MyIndividual i1 = new MyIndividual();
	MyIndividual i2 = new MyIndividual();
	MyIndividual i3 = new MyIndividual();
	MyIndividual i4 = new MyIndividual();
	MyIndividual i5 = new MyIndividual();
	
	Objective X = new Objective("X", Sign.MIN);
	Objective Y = new Objective("Y", Sign.MIN);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		possconf = new ParetoOptimalSetStabilityConfig();
		
		o1.add(X, 2);
		o1.add(Y, 6);
		
		o2.add(X, 4);
		o2.add(Y, 3);
				
		o3.add(X, 6);
		o3.add(Y, 1);
		
		o4.add(X, 8);
		o4.add(Y, 0.5);
		
		o5.add(X, 9);
		o5.add(Y, 1.5);
		
		i1.setObjectives(o1);
		i2.setObjectives(o2);
		i3.setObjectives(o3);
		i4.setObjectives(o4);
		i5.setObjectives(o5);
		
		archive.add(i1);
		archive.add(i2);
		archive.add(i3);
		archive.add(i4);		
		
		possconf.setMinimumIterationsToSurvive(3);
		possconf.setMinimumSurvivors(3);
		possconf.setMinimumSurvivorsInPercentage(0.75);
		possconf.setEvaluationMode(EvaluationMode.EXACT_NUMBER);
		if(!possconf.validateConfiguration()){
			throw new Exception();
		}
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testExactNumbersMode() {
		
		//Test exact number
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertTrue(posscrit.getEvaluationResult());
		
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		archive.remove(i2);
		archive.add(i5);
		posscrit.evaluate(0, 0);
		assertTrue(posscrit.getEvaluationResult());
		
		archive.remove(i5);
		archive.add(i2);
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		archive.remove(i2);
		archive.remove(i3);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testPercentageMode() {
		
		//Test percentage
		try {
			possconf.setEvaluationMode(EvaluationMode.PERCENTAGE);
		} catch (InvalidConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertTrue(posscrit.getEvaluationResult());
		
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		archive.remove(i2);
		archive.add(i5);
		posscrit.evaluate(0, 0);
		assertTrue(posscrit.getEvaluationResult());
		
		archive.remove(i5);
		archive.add(i2);
		posscrit = new ParetoOptimalSetStabilityCriterion(possconf, null, archive);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		archive.remove(i2);
		archive.remove(i3);
		archive.add(i5);
		posscrit.evaluate(0, 0);
		assertFalse(posscrit.getEvaluationResult());
		
	}
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}

}

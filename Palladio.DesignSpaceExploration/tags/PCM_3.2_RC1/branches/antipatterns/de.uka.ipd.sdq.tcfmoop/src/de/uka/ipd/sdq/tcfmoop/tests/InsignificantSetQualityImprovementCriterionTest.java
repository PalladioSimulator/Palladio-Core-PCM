package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.opt4j.common.archive.DefaultArchive;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig.ValueDifference;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantSetQualityImprovementCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class InsignificantSetQualityImprovementCriterionTest {
	InsignificantSetQualityImprovementConfig isqiconf;
	InsignificantSetQualityImprovementCriterion isqiccrit;
	
	Archive archive = new DefaultArchive();

	Objectives o1 = new Objectives();
	Objectives o2 = new Objectives();
	Objectives o3 = new Objectives();
	Objectives o4 = new Objectives();
	Objectives o5 = new Objectives(); //signifficant
	Objectives o6 = new Objectives(); //insignifficant
	Objectives o7 = new Objectives(); //insignifficant with new minimum
	
	MyIndividual i1 = new MyIndividual();
	MyIndividual i2 = new MyIndividual();
	MyIndividual i3 = new MyIndividual();
	MyIndividual i4 = new MyIndividual();
	MyIndividual i5 = new MyIndividual(); //signifficant
	MyIndividual i6 = new MyIndividual(); //insignifficant
	MyIndividual i7 = new MyIndividual(); //insignifficant with new minimum
	
	Objective X = new Objective("X", Sign.MIN);
	Objective Y = new Objective("Y", Sign.MIN);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		isqiconf = new InsignificantSetQualityImprovementConfig();
		
		o1.add(X, 2);
		o1.add(Y, 6);
		
		o2.add(X, 4);
		o2.add(Y, 3);
				
		o3.add(X, 6);
		o3.add(Y, 1);
		
		o4.add(X, 8);
		o4.add(Y, 0.5);
		
		i1.setObjectives(o1);
		i2.setObjectives(o2);
		i3.setObjectives(o3);
		i4.setObjectives(o4);
		
		archive.add(i1);
		archive.add(i2);
		archive.add(i3);
		archive.add(i4);
		
		o5.add(X, 30);
		o5.add(Y, 0.5);
		i5.setObjectives(o5);
		
		o6.add(X, 5);
		o6.add(Y, 0.5);
		i6.setObjectives(o6);
		
		o7.add(X, 1);
		o7.add(Y, 0.5);
		i7.setObjectives(o7);
		
		isqiconf.setComparisionGenerations(3);
		List<ValueDifference> vDiffs = new LinkedList<ValueDifference>();
		vDiffs.add(isqiconf.new ValueDifference(X, 0.25, 0.1));
		vDiffs.add(isqiconf.new ValueDifference(Y, 0.25, 0.1));
		isqiconf.setValueDifferences(vDiffs);
		if(!isqiconf.validateConfiguration()){
			throw new Exception();
		}
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testGetEvaluationResult() {
		Population population = new Population();
		population.add(i1);
		
		//Insignificant Change
		isqiccrit = new InsignificantSetQualityImprovementCriterion();
		isqiccrit.initialize(isqiconf, population, archive);
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		archive.add(i6);
		isqiccrit.evaluate(0, 0);
		assertTrue(isqiccrit.getEvaluationResult());
		archive.remove(i6);
		
		//Insignificant Change with significant minimum
		isqiccrit = new InsignificantSetQualityImprovementCriterion();
		isqiccrit.initialize(isqiconf, population, archive);
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		archive.add(i7);
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		archive.remove(i7);
		
		//Significant Change
		isqiccrit = new InsignificantSetQualityImprovementCriterion();
		isqiccrit.initialize(isqiconf, population, archive);
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		archive.add(i5);
		isqiccrit.evaluate(0, 0);
		assertFalse(isqiccrit.getEvaluationResult());
		
	}
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}

}

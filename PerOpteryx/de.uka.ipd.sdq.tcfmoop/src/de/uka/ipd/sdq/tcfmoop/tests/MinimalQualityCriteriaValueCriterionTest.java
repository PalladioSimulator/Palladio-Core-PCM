package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.opt4j.common.archive.DefaultArchive;
import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.DoubleValue;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.domination.ParetoDomination;

import de.uka.ipd.sdq.tcfmoop.config.MinimalQualityCriteriaValueConfig;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.MinimalQualityCriteriaValueCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class MinimalQualityCriteriaValueCriterionTest {
	MinimalQualityCriteriaValueConfig mqcvconf;
	MinimalQualityCriteriaValueCriterion mqcvcrit;
	
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
	MyIndividual i5 = new MyIndividual(); //signifficant
	
	Objective X = new Objective("X", Sign.MIN);
	Objective Y = new Objective("Y", Sign.MIN);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		mqcvconf = new MinimalQualityCriteriaValueConfig();
		
		o1.add(X, 2);
		o1.add(Y, 6);
		
		o2.add(X, 4);
		o2.add(Y, 3);
				
		o3.add(X, 3);
		o3.add(Y, 1.5);
		
		o4.add(X, 4);
		o4.add(Y, 0.5);
		
		i1.setObjectives(o1);
		i2.setObjectives(o2);
		i3.setObjectives(o3);
		i4.setObjectives(o4);
		
		archive.add(i1);
		archive.add(i2);
		archive.add(i3);
		archive.add(i4);
		
		o5.add(X, 2);
		o5.add(Y, 0.6);
		i5.setObjectives(o5);
		
		mqcvconf.setNumberOfCandidatesToConform(3);
		
		Map<Objective, Value<?>> configuredObjects = new HashMap<Objective, Value<?>>();
		
		configuredObjects.put(X, new DoubleValue(5d));
		configuredObjects.put(Y, new DoubleValue(2.5));
		
		mqcvconf.setObjectiveMinimalValues(configuredObjects);
		
		if(!mqcvconf.validateConfiguration()){
			throw new Exception();
		}
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testNotEnoughConformingCandidates() {
		Population population = new Population();
		population.add(i1);
		
		//Not Enough candidates
		mqcvcrit = new MinimalQualityCriteriaValueCriterion(mqcvconf, population, archive);
		mqcvcrit.evaluate(0, 0);
		assertFalse(mqcvcrit.getEvaluationResult());
		
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testEnoughConformingCandidates() {
		Population population = new Population();
		population.add(i1);
		
		mqcvcrit = new MinimalQualityCriteriaValueCriterion(mqcvconf, population, archive);
		
		archive.remove(i2);
		archive.add(i5);
		
		//Enough conforming candidates
		mqcvcrit.evaluate(0, 0);
		assertTrue(mqcvcrit.getEvaluationResult());
		
	}
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}
	
}

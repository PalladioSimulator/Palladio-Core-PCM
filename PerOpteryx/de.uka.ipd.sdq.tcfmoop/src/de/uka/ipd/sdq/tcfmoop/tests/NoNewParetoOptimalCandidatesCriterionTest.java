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

import de.uka.ipd.sdq.tcfmoop.config.NoNewParetoOptimalCandidatesFoundConfig;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.NoNewParetoOptimalCandidatesFoundCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class NoNewParetoOptimalCandidatesCriterionTest {
	NoNewParetoOptimalCandidatesFoundConfig nnpocconf;
	NoNewParetoOptimalCandidatesFoundCriterion nnpoccrit;
	
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
		
		nnpocconf = new NoNewParetoOptimalCandidatesFoundConfig();
		
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
		
		nnpocconf.setIterationsWithoutNewCandidates(3);
		if(!nnpocconf.validateConfiguration()){
			throw new Exception();
		}
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testNoNewCandidates() {
		
		nnpoccrit = new NoNewParetoOptimalCandidatesFoundCriterion(nnpocconf, null, archive);
		
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertTrue(nnpoccrit.getEvaluationResult());
		
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testOneNewCandidate() {
		
		nnpoccrit = new NoNewParetoOptimalCandidatesFoundCriterion(nnpocconf, null, archive);
		
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		archive.add(i5);
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertTrue(nnpoccrit.getEvaluationResult());
		
	}
	
	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testEmptyArchive() {
		
		nnpoccrit = new NoNewParetoOptimalCandidatesFoundCriterion(nnpocconf, null, archive);
		archive.clear();
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertFalse(nnpoccrit.getEvaluationResult());
		nnpoccrit.evaluate(0, 0);
		assertTrue(nnpoccrit.getEvaluationResult());
		
	}
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}

}

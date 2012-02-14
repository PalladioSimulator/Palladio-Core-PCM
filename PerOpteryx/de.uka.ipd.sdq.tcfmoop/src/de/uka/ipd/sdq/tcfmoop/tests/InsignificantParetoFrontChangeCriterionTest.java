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

import de.uka.ipd.sdq.tcfmoop.config.InsignificantParetoFrontChangeConfig;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.InsignificantParetoFrontChangeCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class InsignificantParetoFrontChangeCriterionTest {
	InsignificantParetoFrontChangeConfig ipfcconf;
	InsignificantParetoFrontChangeCriterion ipfccrit;
	
	Archive archive = new DefaultArchive(); //empty

	Objectives o1 = new Objectives(new ParetoDomination());
	Objectives o2 = new Objectives(new ParetoDomination());
	Objectives o3 = new Objectives(new ParetoDomination());
	Objectives o4 = new Objectives(new ParetoDomination());
	Objectives o5 = new Objectives(new ParetoDomination());
	Objectives o6 = new Objectives(new ParetoDomination());
	
	MyIndividual i1 = new MyIndividual();
	MyIndividual i2 = new MyIndividual();
	MyIndividual i3 = new MyIndividual();
	MyIndividual i4 = new MyIndividual();
	MyIndividual i5 = new MyIndividual();
	MyIndividual i6 = new MyIndividual();
	
	Objective X = new Objective("X", Sign.MIN);
	Objective Y = new Objective("Y", Sign.MIN);
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		ipfcconf = new InsignificantParetoFrontChangeConfig();
		
		o1.add(X, 2);
		o1.add(Y, 6);
		
		o2.add(X, 4);
		o2.add(Y, 3);
				
		o3.add(X, 6);
		o3.add(Y, 1);
		
		o4.add(X, 8);
		o4.add(Y, 0.5);
		
		//frontInsig
		o5.add(X, 3);
		o5.add(Y, 2);
		
		//frontSig
		o6.add(X, 1);
		o6.add(Y, 5);
		
		i1.setObjectives(o1);
		i2.setObjectives(o2);
		i3.setObjectives(o3);
		i4.setObjectives(o4);
		i5.setObjectives(o5);
		i6.setObjectives(o6);
		
		
		ipfcconf.setMinimumAllowedDifference(0.35);
		ipfcconf.setPastIterationNumber(2);
		if(!ipfcconf.validateConfiguration()){
			throw new Exception();
		}
		
	}

	/**
	 * Test method for {@link de.uka.ipd.sdq.tcfmoop.terminationcriteria.AbstractTerminationCriterion#getEvaluationResult()}.
	 */
	@Test
	public void testWithAnEmptyArchive() {
		
		//Test with an empty archive
		ipfccrit = new InsignificantParetoFrontChangeCriterion(ipfcconf, null, archive);
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		ipfccrit.evaluate(0, 0);
		assertTrue(ipfccrit.getEvaluationResult());
		
	}
	
	@Test
	public void testInsignificantChange() {
		//Test insignificant front
		//Init archive
		
		this.archive.add(i1);
		this.archive.add(i2);
		this.archive.add(i3);
		this.archive.add(i4);
		
		ipfccrit = new InsignificantParetoFrontChangeCriterion(ipfcconf, null, archive);
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		
		//Make an insignificant change in the archive
		
		archive.remove(i2);
		archive.add(i5);
		
		ipfccrit.evaluate(0, 0);
		assertTrue(ipfccrit.getEvaluationResult());
		
		//Roll back the archive
		
		archive.clear();
		this.archive.add(i1);
		this.archive.add(i2);
		this.archive.add(i3);
		this.archive.add(i4);
		
	}
	
	@Test
	public void testSignificantChange() {
		
		//Test significant front
		ipfccrit = new InsignificantParetoFrontChangeCriterion(ipfcconf, null, archive);
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		
		//Make a significant change to the archive
		archive.remove(i1);
		archive.remove(i2);
		archive.add(i5);
		archive.add(i6);
		
		ipfccrit.evaluate(0, 0);
		assertFalse(ipfccrit.getEvaluationResult());
		
	}
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}

}

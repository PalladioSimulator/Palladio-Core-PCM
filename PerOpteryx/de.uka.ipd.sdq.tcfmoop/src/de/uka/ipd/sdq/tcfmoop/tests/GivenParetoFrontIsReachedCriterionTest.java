/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

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

import de.uka.ipd.sdq.tcfmoop.config.GivenParetoFrontIsReachedConfig;
import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;
import de.uka.ipd.sdq.tcfmoop.terminationcriteria.GivenParetoFrontIsReachedCriterion;

/**
 * @author Atanas Dimitrov
 *
 */
public class GivenParetoFrontIsReachedCriterionTest {
	GivenParetoFrontIsReachedConfig gpfirconf;
	GivenParetoFrontIsReachedCriterion gpfircrit;
	Archive front25 = new DefaultArchive();
	Archive front75 = new DefaultArchive();
	Archive front100 = new DefaultArchive();
	List<Objectives> paretoFront = new LinkedList<Objectives>();
	Objectives o1 = new Objectives(new ParetoDomination());
	Objectives o2 = new Objectives(new ParetoDomination());
	Objectives o3 = new Objectives(new ParetoDomination());
	Objectives o4 = new Objectives(new ParetoDomination());
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		Objective X = new Objective("X", Sign.MIN);
		Objective Y = new Objective("Y", Sign.MAX);
		
		gpfirconf = new GivenParetoFrontIsReachedConfig();
		
		o1.add(X, 5);
		o1.add(Y, 5);
		
		o2.add(X, 4);
		o2.add(Y, 4);
				
		o3.add(X, 3);
		o3.add(Y, 3);
		
		o4.add(X, 2);
		o4.add(Y, 2);
		
		paretoFront.add(o1);
		paretoFront.add(o2);
		paretoFront.add(o3);
		paretoFront.add(o4);
		
		gpfirconf.setParetoFront(paretoFront);
		gpfirconf.setPercentagesToCover(0.75);
		if(!gpfirconf.validateConfiguration()){
			throw new Exception();
		}
		
		MyIndividual i1 = new MyIndividual();
		i1.setObjectives(o1);
		MyIndividual i2 = new MyIndividual();
		i2.setObjectives(o2);
		MyIndividual i3 = new MyIndividual();
		i3.setObjectives(o3);
		MyIndividual i4 = new MyIndividual();
		i4.setObjectives(o4);
		
		front25.add(i1);
		
		front75.add(i1);
		front75.add(i2);
		front75.add(i3);
		
		front100.add(i1);
		front100.add(i2);
		front100.add(i3);
		front100.add(i4);
		
	}

	@Test
	public void test25PercentCoverage() {
		
		int initialParetoFrontSize = this.paretoFront.size();
		
		gpfircrit = new GivenParetoFrontIsReachedCriterion(gpfirconf, null, front25);
		gpfircrit.evaluate(0, 0);
		assertFalse(gpfircrit.getEvaluationResult());
		
		assertTrue(this.paretoFront.size() == initialParetoFrontSize);
		
	}
	
	@Test
	public void test55PercentCoverage() {
		
		int initialParetoFrontSize = this.paretoFront.size();
		
		try {
			gpfirconf.setParetoFront(paretoFront);
		} catch (InvalidConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gpfircrit = new GivenParetoFrontIsReachedCriterion(gpfirconf, null, front75);
		gpfircrit.evaluate(0, 0);
		assertTrue(gpfircrit.getEvaluationResult());
		
		assertTrue(this.paretoFront.size() == initialParetoFrontSize);
		
	}
	
	@Test
	public void test100PercentCoverage() {
		
		int initialParetoFrontSize = this.paretoFront.size();
				
		try {
			gpfirconf.setParetoFront(paretoFront);
		} catch (InvalidConfigException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		gpfircrit = new GivenParetoFrontIsReachedCriterion(gpfirconf, null, front100);
		gpfircrit.evaluate(0, 0);
		assertTrue(gpfircrit.getEvaluationResult());
		
		assertTrue(this.paretoFront.size() == initialParetoFrontSize);
		
	}
	
	
	
	public class MyIndividual extends Individual{
		public MyIndividual(){
			this.setIndividualStatusListeners(new HashSet<IndividualStateListener>());
		}
	}

}

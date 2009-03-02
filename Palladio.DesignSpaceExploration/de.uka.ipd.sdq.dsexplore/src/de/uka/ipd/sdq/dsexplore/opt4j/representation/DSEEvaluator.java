package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.Collection;

import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.problem.Evaluator;

/**
 * The Evaluator is responsible for determining the objective functions values 
 * for an individual based on the phenotype (i.e. the PCM instance). Thus, 
 * it calls the simulation or LQN solver for performance and also a cost 
 * evaluator. 
 * 
 * It is a singleton  
 * 
 * @author Anne
 * 
 */
public class DSEEvaluator implements Evaluator<PCMPhenotype>{

	@Override
	public Objectives evaluate(PCMPhenotype arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Objective> getObjectives() {
		// TODO Auto-generated method stub
		return null;
	}

}

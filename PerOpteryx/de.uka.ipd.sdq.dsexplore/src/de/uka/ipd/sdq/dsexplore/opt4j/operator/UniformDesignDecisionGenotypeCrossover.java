package de.uka.ipd.sdq.dsexplore.opt4j.operator;

import org.opt4j.common.random.Rand;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;

/**
 * Uniform crossover implementation. For each gene of the first offspring, 
 * it is randomly decided whether the value of parent 1 or parent 2 is taken.
 * The second offspring then is the opposite.  
 * 
 * @author martens
 *
 */
public class UniformDesignDecisionGenotypeCrossover implements Crossover<DesignDecisionGenotype>  {

	private Rand random;

	@Inject
	public UniformDesignDecisionGenotypeCrossover(Rand random) {
		this.random = random;
	}

	@Override
	public Pair<DesignDecisionGenotype> crossover(DesignDecisionGenotype parent1, DesignDecisionGenotype parent2) {
		
		DesignDecisionGenotype o1 = parent1.newInstance();
		DesignDecisionGenotype o2 = parent2.newInstance();

		if (o1.size() != o2.size()){
			throw new RuntimeException("Two genomes do not have the same length: "+parent1 + " and "+parent2);
		}
		
		for (int i = 0; i < o2.size(); i ++) {
			if (this.random.nextBoolean()){
				o1.add(parent1.get(i));
				o2.add(parent2.get(i));
			} else {
				o1.add(parent2.get(i));
				o2.add(parent1.get(i));
			}
		}

		Pair<DesignDecisionGenotype> offspring = new Pair<DesignDecisionGenotype>(o1, o2);
		return offspring;
	}

}

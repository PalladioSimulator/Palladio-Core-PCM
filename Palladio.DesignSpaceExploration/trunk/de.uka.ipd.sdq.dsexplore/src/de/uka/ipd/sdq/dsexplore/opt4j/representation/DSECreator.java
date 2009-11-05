package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.Random;

import org.opt4j.core.problem.Creator;
import org.opt4j.genotype.DoubleGenotype;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * The {@link DSECreator} is responsible for randomly creating genotypes 
 * in the solution space. It can query the {@link DSEProblem} for the 
 * available design space.
 *  
 * @author Anne
 *
 */
public class DSECreator implements Creator<DoubleGenotype> {

	private DSEProblem problem;
	private Random random;
	
	private boolean initialGenotypeEvaluated = false;
	private int numberOfNotEvaluatedPredefinedOnes;

	@Inject
	public DSECreator(){
		//XXX like this you can only set the problem once. Maybe dont save the reference. 
		this.problem = Opt4JStarter.problem;
		this.random = new Random();
		this.numberOfNotEvaluatedPredefinedOnes = this.problem.getInitialGenotypeList().size();
	}
	

	@Override
	public DoubleGenotype create() {
		
		if (!initialGenotypeEvaluated){
			DoubleGenotype genome = this.problem.getInitialGenotypeList().get(this.problem.getInitialGenotypeList().size()-this.numberOfNotEvaluatedPredefinedOnes);
			numberOfNotEvaluatedPredefinedOnes --;
			if (numberOfNotEvaluatedPredefinedOnes <= 0){
			initialGenotypeEvaluated = true;
		}
			return genome;
		
		}
		
		DoubleGenotype genotype = new DoubleGenotype(problem.getBounds());
		//I do not use an iterator here to avoid the creator to know too much of the problem. Just the bounds are enough. 
		for (int index = 0; index < problem.getBounds().numberOfDimensions(); index++) {
			if (problem.getBounds().isInteger(index)){
				createIntegerValue(genotype, index);
			} else {
				createDoubleValue(genotype, index);
			}
		}
		return genotype;
	}


	private void createIntegerValue(DoubleGenotype genotype, int index) {
		int range = (int)genotype.getUpperBound(index) - (int)genotype.getLowerBound(index);
		//random.nextInt creates a random value between 0 <= x < param. I want one 0 <= x <= range. Thus, I add  1  
		int value = (int)genotype.getLowerBound(index) + this.random.nextInt(range+1);
		genotype.add(new Double(value));
		
	}


	private void createDoubleValue(DoubleGenotype genotype, int index) {
		double factor = genotype.getUpperBound(index) - genotype.getLowerBound(index);
		genotype.add(genotype.getLowerBound(index) + this.random.nextDouble()*factor);
	}

}

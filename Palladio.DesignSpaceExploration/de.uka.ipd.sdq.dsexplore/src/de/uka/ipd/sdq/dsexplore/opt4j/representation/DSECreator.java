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

	@Inject
	public DSECreator(){
		//XXX like this you can only set the problem once. Maybe dont save the reference. 
		this.problem = Opt4JStarter.problem;
		this.random = new Random();
	}
	

	@Override
	public DoubleGenotype create() {
		DoubleGenotype genotype = new DoubleGenotype(problem.getBounds());
		//I do not use an iterator here to avoid the creator to know too much of the problem. Just the bounds are enough. 
		for (int index = 0; index < problem.getBounds().numberOfDimensions(); index++) {
			double factor = genotype.getUpperBound(index) - genotype.getLowerBound(index);
			genotype.add(genotype.getLowerBound(index) + this.random.nextDouble()*factor);
		}
		return genotype;
	}

}

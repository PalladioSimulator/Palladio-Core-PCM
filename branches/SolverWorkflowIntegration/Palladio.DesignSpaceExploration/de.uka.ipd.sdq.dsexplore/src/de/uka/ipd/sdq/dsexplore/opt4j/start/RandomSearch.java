package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.List;

import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSECreator;

public class RandomSearch extends PredefinedInstanceEvaluator{
	
	private DSECreator creator = new DSECreator();
	private int numberOfCandidates = 0;

	public RandomSearch(int noOfIterations, int candidatesPerIteration){
		
		this.numberOfCandidates = noOfIterations * candidatesPerIteration;
		
		

	}

	private List<DoubleGenotype> createRandomCandidates(long numberOfCandidates) {
		
		List<DoubleGenotype> result = new ArrayList<DoubleGenotype>();
		for (long i = 0; i < numberOfCandidates; i++) {
			result.add(this.creator.create());
		}
		
		return result;
	}

	@Override
	protected List<DoubleGenotype> getGenotypes() {
		return createRandomCandidates(this.numberOfCandidates);
	}

}

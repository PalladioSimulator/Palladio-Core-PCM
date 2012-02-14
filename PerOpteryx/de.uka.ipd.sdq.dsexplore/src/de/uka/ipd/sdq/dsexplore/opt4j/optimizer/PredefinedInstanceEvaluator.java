package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Iteration;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

public class PredefinedInstanceEvaluator extends AbstractOptimizer {
	
	IndividualFactory individualFactory;

	@Inject
	public PredefinedInstanceEvaluator(Population population, Archive archive,
			IndividualFactory individualFactory, IndividualCompleter completer,
			Control control, Iteration iteration){
		
		super(population, archive, completer, control, iteration);
		this.individualFactory = individualFactory;
				
	}
	
	@Override
	public void optimize() throws StopException, TerminationException {
		
		try {
			int numberOfCandidatesToEvaluate = Opt4JStarter.getDSECreator().getNumberOfNotEvaluatedPredefinedOnes();
			
			for (int i = 0; i < numberOfCandidatesToEvaluate; i ++){
				Individual indiv = individualFactory.create();
				population.add(indiv);
			}
			
			nextIteration();
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	
	}

}
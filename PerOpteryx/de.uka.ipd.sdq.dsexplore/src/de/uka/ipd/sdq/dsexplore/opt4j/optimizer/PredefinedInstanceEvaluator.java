package de.uka.ipd.sdq.dsexplore.opt4j.optimizer;

import org.eclipse.core.runtime.CoreException;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

public class PredefinedInstanceEvaluator extends AbstractOptimizer {

	@Inject
	public PredefinedInstanceEvaluator(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control){
		
		super(population, archive, individualBuilder, completer, control);
				
	}
	
	@Override
	public void optimize() throws StopException, TerminationException {
		
		try {
			int numberOfCandidatesToEvaluate = Opt4JStarter.getDSECreator().getNumberOfNotEvaluatedPredefinedOnes();
			
			for (int i = 0; i < numberOfCandidatesToEvaluate; i ++){
				Individual indiv = individualBuilder.build();
				population.add(indiv);
			}
			
			nextIteration();
			
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	
	}

}
package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;

/**
 * Adds the possibility to terminate a run in the eclipse Progress view. 
 * If cancel operation is clicked there, IProgressMonitor.isCanceled evaluates to true and 
 * the optimisation is asked to terminate after completing the current iteration.
 * @author Anne
 *
 */
public class DSEListener implements OptimizerIterationListener {

	private IProgressMonitor monitor;

	public DSEListener(IProgressMonitor monitor, int maxIterations) {
		this.monitor = monitor;
		monitor.beginTask("DSE run", maxIterations);
	}

	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		if (this.monitor.isCanceled()){
			Opt4JStarter.terminate();
			this.monitor.setTaskName("DSE Run cancelling");
			this.monitor.done();
		} else {
			monitor.worked(1);
			
			storeIntermediateResults(iteration);
			
		}
		

	}

	private void storeIntermediateResults(int iteration) {
		
		Collection<Individual> archive = Opt4JStarter.getParetoOptimalIndividuals();
		
		Collection<Individual> individuals = Opt4JStarter.getAllIndividuals();
		
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		ResultsWriter.writeIndividualsToFile(individuals, "allCandidates", iteration, exceptionList);
		
		ResultsWriter.writeIndividualsToFile(archive, "optimalCandidates", iteration, exceptionList);

		
		
	}



}

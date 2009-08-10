package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;


import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTracker;


/**
 * Adds the possibility to terminate a run in the eclipse Progress view. 
 * If cancel operation is clicked there, IProgressMonitor.isCanceled evaluates to true and 
 * the optimisation is asked to terminate after completing the current iteration.
 * @author Anne
 *
 */
public class DSEListener implements OptimizerIterationListener {

	private IProgressMonitor monitor;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

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
			
			printStatistics(iteration);
			storeIntermediateResults(iteration);
			
		}
		

	}

	private void printStatistics(int iteration) {
		logger.info("Iteration "+iteration+" completed: \n "
				+Opt4JStarter.getAllIndividuals().size()+" in archive "+Opt4JStarter.getAllIndividuals().getClass().getName()+", \n"
				+Opt4JStarter.getAllIndividuals().getParetoOptimalIndividuals().size()+" in pareto optimal archive "+Opt4JStarter.getAllIndividuals().getParetoOptimalIndividuals().getClass().getName()+", \n"
				+Opt4JStarter.getArchiveIndividuals().size() + " in archive "+Opt4JStarter.getArchiveIndividuals().getClass().getName()+", \n"
				+Opt4JStarter.getPopulationIndividuals().size() + " in archive "+Opt4JStarter.getPopulationIndividuals().getClass().getName());
		
	}

	private void storeIntermediateResults(int iteration) {
		
		Collection<Individual> archive = Opt4JStarter.getArchiveIndividuals();
		
		PopulationTracker individuals = Opt4JStarter.getAllIndividuals();
		
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		ResultsWriter.writeIndividualsToFile(individuals, "allCandidates", iteration, exceptionList);
		
		ResultsWriter.writeIndividualsToFile(archive, "optimalCandidatesNSGA2", iteration, exceptionList);

		ResultsWriter.writeIndividualsToFile(individuals.getParetoOptimalIndividuals(), "ownOptimalCandidates", iteration, exceptionList);

			
	}



}

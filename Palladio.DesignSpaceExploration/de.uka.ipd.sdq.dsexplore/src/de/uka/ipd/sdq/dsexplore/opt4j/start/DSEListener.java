package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;

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

	public DSEListener(IProgressMonitor monitor) {
		this.monitor = monitor;
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
		
		String output = addResultsToString(individuals, exceptionList);
		writeToFile("allCandidates", output, iteration);
		
		output = addResultsToString(individuals.getParetoOptimalIndividuals(), exceptionList);
		writeToFile("ownOptimalCandidates", output, iteration);
		
		output = addResultsToString(archive, exceptionList);
		writeToFile("optimalCandidatesNSGA2", output, iteration);
		
		
	}

	private String addResultsToString(Collection<Individual> individuals,
			List<Exception> exceptionList) {
		String output = ""; 
		output = Opt4JStarter.prettyPrintHeadlineCSV(individuals, output);
		int counter = 0;

		// content
		for (Individual ind2 : individuals) {
			try {
			output = Opt4JStarter.prettyPrintResultLineCSV(output, ind2);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		return output;
	}

	private void writeToFile(String filename, String output, int iteration) {
		filename = filename + iteration + ".csv";
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename)));
			
			w.write(output);
			
			w.flush();
			
			w.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

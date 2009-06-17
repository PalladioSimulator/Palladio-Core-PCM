package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.Individual;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;

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
		
		String output = addResultsToString(individuals, exceptionList);
		writeToFile("allCandidates", output, iteration);
		
		output = addResultsToString(archive, exceptionList);
		writeToFile("optimalCandidates", output, iteration);
		
		
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

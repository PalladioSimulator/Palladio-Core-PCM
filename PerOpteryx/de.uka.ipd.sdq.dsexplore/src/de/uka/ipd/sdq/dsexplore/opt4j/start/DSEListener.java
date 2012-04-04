package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;

import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTracker;


/**
 * Adds the possibility to terminate a run in the eclipse Progress view. 
 * If cancel operation is clicked there, IProgressMonitor.isCanceled evaluates to true and 
 * the optimisation is asked to terminate after completing the current iteration.
 * @author Anne
 *
 */
public class DSEListener implements OptimizerIterationListener {
	
	int iteration = 0;

	private IProgressMonitor monitor;

	private String resultFolder;

	private boolean asEMF;

	private boolean asCSV;
	
	public DSEListener(IProgressMonitor monitor, DSEWorkflowConfiguration dseConfig) {
		this.resultFolder = dseConfig.getResultFolder();
		this.asEMF = dseConfig.isResultsAsEMF();
		this.asCSV = dseConfig.isResultsAsCSV();
		this.monitor = monitor;
		monitor.beginTask("DSE run", dseConfig.getMaxIterations());
	}

	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		if (this.monitor.isCanceled()){
			Opt4JStarter.terminate();
			this.monitor.setTaskName("DSE Run cancelling");
			this.monitor.done();
		} else {
			monitor.worked(1);
			
			//printStatistics(iteration);
			
			// -1 to start with iteration 0, as Opt4J now newly starts with iteration 1 it seems.  
			storeIntermediateResults(iteration-1);
			
		}
		this.iteration = iteration;

	}

	private void storeIntermediateResults(int iteration) {
		
		PopulationTracker individuals = Opt4JStarter.getAllIndividuals();
		
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		ResultsWriter.writeDSEIndividualsToFile(individuals.getIndividuals(), this.resultFolder+"allCandidates", iteration, this.asEMF, this.asCSV, exceptionList);
		
		ResultsWriter.writeDSEIndividualsToFile(Opt4JStarter.getPopulationIndividuals(), this.resultFolder+"population", iteration, this.asEMF, this.asCSV, exceptionList);

		//ResultsWriter.writeIndividualsToFile(individuals.getParetoOptimalIndividuals(), this.resultFolder+"ownOptimalCandidates", iteration, exceptionList);
		ResultsWriter.writeIndividualsToFile(Opt4JStarter.getArchiveIndividuals(), this.resultFolder+"archiveCandidates", iteration, exceptionList, this.asEMF, this.asCSV);	
	}


	public int getIteration(){
		return this.iteration;
	}

}

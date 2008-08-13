package de.uka.ipd.sdq.dsexplore.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;

public class FullSearchAlgorithm extends HillClimbingAlgorithm {
	
	List<PCMInstance> analysedCandidates;
	List<IAnalysisResult> analysisResults;
	
	
	
	public FullSearchAlgorithm() {
		super();
		this.analysedCandidates = new ArrayList<PCMInstance>();
		this.analysisResults = new ArrayList<IAnalysisResult>();
	}

	@Override
	public List<IAnalysisResult> iterate(List<IAnalysisResult> population)
			throws CoreException, AnalysisFailedException {
		
		/* if this is the first iteration, also include the initial population to the results*/
		if (analysisResults.size() == 0){
			analysisResults.addAll(population);
		}
		
		//do not start if already done. 
		if (terminated)
			return analysisResults;

		generation++;
		
		List<IAnalysisResult> newGeneration = new ArrayList<IAnalysisResult>();
		
		//if no new neighbours for the whole population is found, we are done 
		terminated = true;
		
		//for each individual
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator.hasNext();) {
			IAnalysisResult currentResult = iterator.next();
			
			//1) determine neighbors
			List<PCMInstance> neighbours = this.evolve(currentResult.getPCMInstance());
			
			//2) remove all we already have in the list
			//FIXME the check for identity does not work yet, mis-gen3-AltCom-0.system is the same than mis-gen1-AltCom-2.system
			//Or are the systems saved before we check for already having had it?
			//neighbours.removeAll(analysedCandidates);
			
			//if no new neighbors are found, set terminated to true.
			if (neighbours.size()!=0)
				terminated = false;
			
			// and add the new ones, because we now have them
			analysedCandidates.addAll(neighbours);
			
			//3) evaluate new neighbors
			List<IAnalysisResult> results = this.evaluate(neighbours);
			analysisResults.addAll(results);
			
			//4) add all new neighbors to the new generation
			newGeneration.addAll(results);

		}
		if (terminated){
			Collections.sort(analysisResults);
			
			printAnalysisResults(analysisResults);
			
			return analysisResults;
		} else {
			return newGeneration;
		}
	}

	private void printAnalysisResults(List<IAnalysisResult> anaResult) {
		logger.debug("The results of a full search:");
		int counter = 1; 
		for (Iterator<IAnalysisResult> iterator = anaResult.iterator(); iterator
				.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			try {
				logger.debug("The "+counter+". option: "+analysisResult.getPCMInstance().getName()+" with resp. time "+analysisResult.getMeanValue());
				counter++;
			} catch (AnalysisFailedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}

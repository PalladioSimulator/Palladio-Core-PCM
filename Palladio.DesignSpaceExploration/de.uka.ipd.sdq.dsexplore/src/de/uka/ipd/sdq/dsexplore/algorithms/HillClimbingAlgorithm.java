package de.uka.ipd.sdq.dsexplore.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.CoreException;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.dsexplore.newcandidates.NewCandidateProxy;

public class HillClimbingAlgorithm implements IAlgorithm {

	private IAnalysis analysisTool;
	private boolean terminated = false;
	INewCandidates newCands;
	
	int generation = 0;

	/**
	 * For a given List of {@link PCMInstance}s, finds the neighbours in terms of alternative components. 
	 * @param population
	 * @return A list of neighbours of all passed {@link PCMInstance}s. 
	 * @throws CoreException
	 */
	public List<PCMInstance> evolve(List<PCMInstance> population) throws CoreException {
	    List<PCMInstance> result = new ArrayList<PCMInstance>();
	    //Generate alternatives
		for (Iterator<PCMInstance> iterator = population.iterator(); iterator.hasNext();) {
			PCMInstance instance = iterator.next();
			newCands.setGeneration(generation);
			result.addAll(newCands.generateNewCandidates(instance));
		}
	    return result;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm#initialise(java.util.List, de.uka.ipd.sdq.dsexplore.analysis.IAnalysis)
	 */
	@Override
	public void initialise(List<PCMInstance> population, IAnalysis analysisTool) {
		this.analysisTool = analysisTool;
		this.newCands = new NewCandidateProxy();
		
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm#iterate(java.util.List)
	 */
	@Override
	public List<IAnalysisResult> iterate(List<IAnalysisResult> population) throws CoreException, AnalysisFailedException {
		boolean improved = false;
		generation++;
		
		List<IAnalysisResult> newGeneration = new ArrayList<IAnalysisResult>();
		
		//for each individual
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator.hasNext();) {
			IAnalysisResult currentResult = iterator.next();
			
			//1) determine neighbors
			List<PCMInstance> neighbours = this.evolve(currentResult.getPCMInstance());
			
			//2) evaluate neighbors
			List<IAnalysisResult> results = this.evaluate(neighbours);
			
			//3) choose best neighbor, if better than current.
			IAnalysisResult best = this.selectBest(results);
			
			//Then create a new generation out of these.
			if (best != null && best.getMeanValue() < currentResult.getMeanValue()){
				improved = true;
				newGeneration.add(best);
			} else{
				newGeneration.add(currentResult);
			}
			
		}
		//if no new neighbors are found, set terminated to true.
		if (!improved)
			terminated = true;
		return newGeneration;
	}

	/**
	 * Retrieves the {@link IAnalysisResult} with the lowest mean response time of the analysed usage scenario. Might return null. 
	 * @param results A list of IAnalysisResults to find the best one from. 
	 * @return the {@link IAnalysisResult} with the lowest mean response time or null if the passed List is empty.
	 * @throws AnalysisFailedException
	 */
	private IAnalysisResult selectBest(List<IAnalysisResult> results) throws AnalysisFailedException {
		Iterator<IAnalysisResult> iterator = results.iterator();
		if (!iterator.hasNext()){
			return null;
		}
		IAnalysisResult best = iterator.next();
		for (; iterator.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			if (best.getMeanValue() > analysisResult.getMeanValue()){
				best = analysisResult;
			}
			
		}
		return best;
	}

	/**
	 * Calls the analysis tool for each passed {@link PCMInstance} and returns the results. 
	 * @param neighbours
	 * @return The results for each passed {@link PCMInstance}.
	 * @throws AnalysisFailedException
	 * @throws CoreException
	 */
	private List<IAnalysisResult> evaluate(List<PCMInstance> neighbours) throws AnalysisFailedException, CoreException {
		List<IAnalysisResult> result = new ArrayList<IAnalysisResult>();
	    //analyse the alternatives
	    for (PCMInstance instance : neighbours) {
			result.add(analysisTool.analyse(instance));
		}
	    return result;
	}

	/**
	 * Just prepares a {@link List} from the one given PCM Instance and passes it on to {@link #evolve(List)}.
	 * @param instance The instance to evolve
	 * @return A list of {@link PCMInstance} as returned by {@link #evolve(List)}
	 * @throws CoreException
	 */
	private List<PCMInstance> evolve(PCMInstance instance) throws CoreException {
		List<PCMInstance> list = new ArrayList<PCMInstance>();
		list.add(instance);
		return this.evolve(list);
	}

	/**
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm#terminated()
	 */
	@Override
	public boolean terminated() {
		return this.terminated ;
	}

}

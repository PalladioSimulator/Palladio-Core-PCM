package de.uka.ipd.sdq.dsexplore.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.designdecisions.INewCandidates;
import de.uka.ipd.sdq.dsexplore.designdecisions.NewCandidateFactory;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class HillClimbingAlgorithm implements IAlgorithm {

	private IAnalysis analysisTool;
	protected boolean terminated = false;
	List<INewCandidates> newCands;
	
	List<IAnalysisResult> allResults = new ArrayList<IAnalysisResult>();
	
	int generation = 0;
	private double meanResponseTimeRequirement;
	
	/** Logger for log4j. */
	protected static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	public HillClimbingAlgorithm(double requirement){
		this.meanResponseTimeRequirement = requirement;
	}

	/**
	 * For a given List of {@link PCMInstance}s, finds the neighbours in terms of alternative components. 
	 * @param population
	 * @return A list of neighbours of all passed {@link PCMInstance}s. 
	 * @throws CoreException
	 */
	public List<PCMInstance> evolve(List<IAnalysisResult> population) throws CoreException {
	    List<PCMInstance> result = new ArrayList<PCMInstance>();
	    //Generate alternatives
		for (Iterator<IAnalysisResult> iterator = population.iterator(); iterator.hasNext();) {
			IAnalysisResult instance = iterator.next();
			for (Iterator<INewCandidates> iterator2 = newCands.iterator(); iterator2
					.hasNext();) {
				INewCandidates newCandGenerator = iterator2.next();
				//result.addAll(newCandGenerator.generateNewCandidates(instance));
			}
			
		}
	    return result;
	}

	/**
	 * 
	 * {@inheritDoc}
	 * @throws CoreException 
	 * @see de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm#initialise(java.util.List, de.uka.ipd.sdq.dsexplore.analysis.IAnalysis)
	 */
	@Override
	public void initialise(List<PCMInstance> population, IAnalysis analysisTool, ILaunchConfiguration conf) throws CoreException {
		this.analysisTool = analysisTool;
		this.newCands = NewCandidateFactory.getInstance().getAllNewCandidateExtensions();
		for (INewCandidates cand : this.newCands) {
			cand.setConfiguration(conf);
		}
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
			List<PCMInstance> neighbours = this.evolve(currentResult);
			
			//2) evaluate neighbors
			List<IAnalysisResult> results = this.evaluate(neighbours);
			
			//Keep all for later
			this.allResults.addAll(results);
			
			//3) choose best neighbor, if better than current.
			IAnalysisResult best = this.selectBest(results);
			
			//Check whether requirements are fulfilled
			if (best != null && best.getMeanValue() <= this.meanResponseTimeRequirement){
				logger.info("Found a candidate that fulfills the response time requirements.");
				newGeneration.add(best);
				terminated = true;
				break;
			}
			
			//Then create a new generation out of these.
			if (best != null && best.getMeanValue() < currentResult.getMeanValue()){
				improved = true;
				logger.debug("Selected steepest ascent "+best.getPCMInstance().getName()+", continuing with that one.");
				newGeneration.add(best);
			} /*else{
				newGeneration.add(currentResult);
			}*/
			
		}
		//if no new neighbors are found, set terminated to true.
		if (!improved) {
			terminated = true;
			logger.info("No better candidate found, terminating the search.");
		}
		return newGeneration;
	}

	/**
	 * Retrieves the {@link IAnalysisResult} with the lowest mean response time of the analysed usage scenario. Might return null. 
	 * @param results A list of IAnalysisResults to find the best one from. 
	 * @return the {@link IAnalysisResult} with the lowest mean response time or null if the passed List is empty.
	 * @throws AnalysisFailedException
	 */
	protected IAnalysisResult selectBest(List<IAnalysisResult> results) throws AnalysisFailedException {
		Iterator<IAnalysisResult> iterator = results.iterator();
		if (!iterator.hasNext()){
			return null;
		}
		IAnalysisResult best = iterator.next();
		for (; iterator.hasNext();) {
			IAnalysisResult analysisResult = iterator.next();
			if (best.compareTo(analysisResult)>0){
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
	protected List<IAnalysisResult> evaluate(List<PCMInstance> neighbours) throws AnalysisFailedException, CoreException {
		List<IAnalysisResult> result = new ArrayList<IAnalysisResult>();
	    //analyse the alternatives
	    for (PCMInstance instance : neighbours) {
			try {
			result.add(analysisTool.analyse(instance));
			} catch (UserCanceledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JobFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		}
	    return result;
	}

	/**
	 * Just prepares a {@link List} from the one given PCM Instance and passes it on to {@link #evolve(List)}.
	 * @param instance The instance to evolve
	 * @return A list of {@link PCMInstance} as returned by {@link #evolve(List)}
	 * @throws CoreException
	 */
	protected List<PCMInstance> evolve(IAnalysisResult instance) throws CoreException {
		List<IAnalysisResult> list = new ArrayList<IAnalysisResult>();
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

	public List<IAnalysisResult> getAllResults() {
		return allResults;
	}

}

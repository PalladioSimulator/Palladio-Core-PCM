package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.domination.DominationStrategy;

import com.google.inject.Inject;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IPerformanceAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.IStatisticAnalysisResult;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

public class DSEObjectives extends Objectives {

	private Map<Objective, ConfidenceInterval> confidence = new HashMap<Objective, ConfidenceInterval>();
	private Map<Objective, ResultDecoratorRepository> resultDecorators = new HashMap<Objective, ResultDecoratorRepository>();
	private Map<Objective, ComputedAggregatedUsage> computedAggregatedResult = new HashMap<Objective, ComputedAggregatedUsage>();
		
	//private Map<Objective, IAnalysisResult> detailedResults = new TreeMap<Objective, IAnalysisResult>();
	
	public void addResult(Objective o, IAnalysisResult result){
		//this.detailedResults.put(o, result);
		ConfidenceInterval ci = this.getConfidenceIntervalFromResult(result);
		if (ci != null){
			this.confidence.put(o, ci);
		}
		if (result instanceof IPerformanceAnalysisResult){
			this.resultDecorators.put(o, ((IPerformanceAnalysisResult) result).getResults());
			this.computedAggregatedResult .put(o, ((IPerformanceAnalysisResult) result).getComputedAggregatedUsage());
		}
	}
	
	@Deprecated
	public DSEObjectives(){super();} // Get objects from provider 
	
	@Inject
	public DSEObjectives(DominationStrategy strategy) {
		super(strategy);
	}
	
	
	
//	public boolean hasDetailedResultsForObjective(Objective o){
//		return this.detailedResults.containsKey(o);
//	}
//	
//	public IAnalysisResult getDetailedResultsFor(Objective o){
//		return this.detailedResults.get(o);
//	}

	@Override
	public Objective get(Value<?> value) {
		// TODO Auto-generated method stub
		return super.get(value);
	}



	public void addConfidence(Objective o, ConfidenceInterval c){
		this.confidence.put(o, c);
	}
	
	/**
	 * 
	 * @return The Map of ConfidenceIntervals, which is not null, but may be empty. 
	 */
	public Map<Objective, ConfidenceInterval> getConfidenceIntervals(){
		return this.confidence;
	}
	
	/**
	 * Can be null
	 * @param o
	 * @return The confidence interval for the given Objective or null if it does not exist. 
	 */
	public ConfidenceInterval getConfidenceIntervalForObjective(Objective o){
		return this.confidence.get(o);
	}

	/**
	 * Can be null
	 * @param o
	 * @return The confidence interval for the given Objective or null if it does not exist. 
	 */
	private ConfidenceInterval getConfidenceIntervalFromResult(
			IAnalysisResult result) {
		if (result instanceof IStatisticAnalysisResult){
			IStatisticAnalysisResult statisticResult = (IStatisticAnalysisResult) result;
			ConfidenceInterval c = statisticResult.getConfidenceInterval();
			return c;
		} else {
			return null;
		}
	}
	
	public void addResultDecoratorFor(Objective o, ResultDecoratorRepository resultDecorator){
		this.resultDecorators.put(o, resultDecorator);
	}
	

	/**
	 * May return null if no result decorator is available. 
	 * @param o
	 * @return
	 */
	public ResultDecoratorRepository getResultDecoratorFor(
			Objective o) {
		return this.resultDecorators.get(o);
	}
	
	/**
	 * Returns whether a non-null result decorator for this Objective o is available 
	 * @param o
	 * @return
	 */
	public boolean hasResultDecoratorFor(
			Objective o) {
		return this.resultDecorators.containsKey(o) && this.resultDecorators.get(o) != null;
	}
	
	public void addComputedAggregatedUsage(Objective o, ComputedAggregatedUsage computedAggregatedUsage){
		this.computedAggregatedResult.put(o, computedAggregatedUsage);
	}
	

	/**
	 * May return null if no result decorator is available. 
	 * @param o
	 * @return
	 */
	public ComputedAggregatedUsage getComputedAggregatedUsageFor(Objective o) {
		return this.computedAggregatedResult.get(o);
	}
	
	/**
	 * Returns whether a non-null result decorator for this Objective o is available 
	 * @param o
	 * @return
	 */
	public boolean hasComputedAggregatedUsageFor(
			Objective o) {
		return this.computedAggregatedResult.containsKey(o) && this.computedAggregatedResult.get(o) != null;
	}
	

}

package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Criterion;
import org.opt4j.core.Objective;
import org.opt4j.core.Constraint;
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

	private Map<Criterion, ConfidenceInterval> confidence = new HashMap<Criterion, ConfidenceInterval>();
	private Map<Criterion, ResultDecoratorRepository> resultDecorators = new HashMap<Criterion, ResultDecoratorRepository>();
	private Map<Criterion, ComputedAggregatedUsage> computedAggregatedResult = new HashMap<Criterion, ComputedAggregatedUsage>();
		
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
	
	public Value<?> getValueForCriterion(Criterion c){
		if (c instanceof Objective){
			return this.get((Objective)c);
		} else if (c instanceof Constraint){
			return this.getConstraints().get((Constraint)c);
		} else {
			throw new RuntimeException("A criterion that is neither Objective nor Constraints has been encountered, contact developers. Class: "+c.getClass());
		}
	}



	public void addConfidence(Criterion o, ConfidenceInterval c){
		this.confidence.put(o, c);
	}
	
	/**
	 * 
	 * @return The Map of ConfidenceIntervals, which is not null, but may be empty. 
	 */
	public Map<Criterion, ConfidenceInterval> getConfidenceIntervals(){
		return this.confidence;
	}
	
	/**
	 * Can be null
	 * @param o
	 * @return The confidence interval for the given Objective or null if it does not exist. 
	 */
	public ConfidenceInterval getConfidenceIntervalForObjective(Criterion o){
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
	
	public void addResultDecoratorFor(Criterion performance, ResultDecoratorRepository resultDecorator){
		this.resultDecorators.put(performance, resultDecorator);
	}
	

	/**
	 * May return null if no result decorator is available. 
	 * @param o
	 * @return
	 */
	public ResultDecoratorRepository getResultDecoratorFor(
			Criterion o) {
		return this.resultDecorators.get(o);
	}
	
	/**
	 * Returns whether a non-null result decorator for this Objective o is available 
	 * @param o
	 * @return
	 */
	public boolean hasResultDecoratorFor(
			Criterion o) {
		return this.resultDecorators.containsKey(o) && this.resultDecorators.get(o) != null;
	}
	
	public void addComputedAggregatedUsage(Criterion o, ComputedAggregatedUsage computedAggregatedUsage){
		this.computedAggregatedResult.put(o, computedAggregatedUsage);
	}
	

	/**
	 * May return null if no result decorator is available. 
	 * @param o
	 * @return
	 */
	public ComputedAggregatedUsage getComputedAggregatedUsageFor(Criterion o) {
		return this.computedAggregatedResult.get(o);
	}
	
	/**
	 * Returns whether a non-null result decorator for this Objective o is available 
	 * @param o
	 * @return
	 */
	public boolean hasComputedAggregatedUsageFor(
			Criterion o) {
		return this.computedAggregatedResult.containsKey(o) && this.computedAggregatedResult.get(o) != null;
	}

	public void addValueForCriterion(Criterion criterion, double d) {
		if (criterion instanceof Objective){
			this.add((Objective)criterion,d);
		} else if (criterion instanceof Constraint){
			this.getConstraints().add((Constraint)criterion, d);
		} else {
			throw new RuntimeException("A criterion that is neither Objective nor Constraints has been encountered, contact developers. Class: "+criterion.getClass());
		}
		
	}
	

}

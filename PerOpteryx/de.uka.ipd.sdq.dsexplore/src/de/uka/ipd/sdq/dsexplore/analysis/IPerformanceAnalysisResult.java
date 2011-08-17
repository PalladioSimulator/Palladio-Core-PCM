package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;

public interface IPerformanceAnalysisResult extends IAnalysisResult {

	public ResultDecoratorRepository getResults();
	
	public ComputedAggregatedUsage getComputedAggregatedUsage();
	
}

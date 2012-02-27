package de.uka.ipd.sdq.dsexplore.analysis;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.visitors.AggregatedContextUsageModelVisitor;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;

public abstract class AbstractPerformanceAnalysisResult implements
		IPerformanceAnalysisResult {

	private ComputedAggregatedUsage computedAggregatedUsage = null;

	public AbstractPerformanceAnalysisResult(PCMInstance model) {
		
		if (Opt4JStarter.getDSEWorkflowConfig().isUseHeuristics()) {

			solveDependencies(model);

			this.computedAggregatedUsage = model.getComputedAggregatedUsage();
		}
		
	}

	/**
	 * Careful: Must only be called per {@link PCMInstance} once, because otherwise it will 
	 * reuse {@link ComputedUsageContext} from old candidates.  
	 * @param model
	 */
	public static void solveDependencies(PCMInstance model) {
		// XXX: Dependency solver replaces IntPMFs and DoublePMFs by
		// DoublePDFs.
		
		model.resetComputedContexts();
		
		UsageModelVisitor visitor = new AggregatedContextUsageModelVisitor(
				model);
		visitor.doSwitch(model.getUsageModel());
		
	}

	/**
	 * @return the computedAggregatedUsage
	 */
	public ComputedAggregatedUsage getComputedAggregatedUsage() {
		return computedAggregatedUsage;
	}


	

}

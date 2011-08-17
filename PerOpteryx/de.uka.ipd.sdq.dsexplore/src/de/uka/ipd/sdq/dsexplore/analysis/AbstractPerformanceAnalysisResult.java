package de.uka.ipd.sdq.dsexplore.analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
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

	public static void solveDependencies(PCMInstance model) {
		// XXX: Dependency solver replaces IntPMFs and DoublePMFs by
		// DoublePDFs.
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

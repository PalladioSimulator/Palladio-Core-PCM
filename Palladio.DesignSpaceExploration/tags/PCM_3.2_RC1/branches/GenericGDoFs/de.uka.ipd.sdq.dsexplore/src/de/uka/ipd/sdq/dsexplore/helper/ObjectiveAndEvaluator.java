package de.uka.ipd.sdq.dsexplore.helper;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

public class ObjectiveAndEvaluator extends CriterionAndEvaluator {
	
	public ObjectiveAndEvaluator(Objective objective, IAnalysis evaluator) {
		super(objective, evaluator);
	}
	
	public Objective getObjective() {
		return (Objective)super.getCriterion();
	}

	@Override
	public IAnalysis getEvaluator() {
		return super.getEvaluator();
	}

}

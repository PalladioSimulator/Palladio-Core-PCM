package de.uka.ipd.sdq.dsexplore.helper;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

public class ObjectiveAndEvaluator {
	private Objective objective;
	private IAnalysis evaluator;
	
	public ObjectiveAndEvaluator(Objective objective, IAnalysis evaluator) {
		super();
		this.objective = objective;
		this.evaluator = evaluator;
	}
	
	public Objective getObjective() {
		return objective;
	}

	public IAnalysis getEvaluator() {
		return evaluator;
	}

	
}

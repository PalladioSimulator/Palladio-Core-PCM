/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.helper;

import org.opt4j.core.Criterion;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

/**
 * @author noorshams
 *
 */
public abstract class CriterionAndEvaluator {
	private Criterion criterion;
	private IAnalysis evaluator;
	
	public CriterionAndEvaluator(Criterion criterion, IAnalysis evaluator) {
		this.criterion = criterion;
		this.evaluator = evaluator;
	}
	
	public Criterion getCriterion() {
		return criterion;
	}

	public IAnalysis getEvaluator() {
		return evaluator;
	}
}

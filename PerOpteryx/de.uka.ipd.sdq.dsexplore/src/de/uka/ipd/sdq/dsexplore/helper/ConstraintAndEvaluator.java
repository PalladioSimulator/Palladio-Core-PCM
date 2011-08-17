/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.helper;

import org.opt4j.core.Constraint;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;

/**
 * @author noorshams
 *
 */
public class ConstraintAndEvaluator extends CriterionAndEvaluator {
	
	public ConstraintAndEvaluator(Constraint constraint, IAnalysis evaluator) {
		super(constraint, evaluator);
	}

	public Constraint getConstraint() {
		return (Constraint)super.getCriterion();
	}

	@Override
	public IAnalysis getEvaluator() {
		return super.getEvaluator();
	}
}

/**
 * 
 */
package org.opt4j.core.domination;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.opt4j.core.Constraint;
import org.opt4j.core.Constraints;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.SatisfactionConstraint;
import org.opt4j.core.Value;
import org.opt4j.core.Objective.Sign;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * 
 * This class implements {@code DominationStrategy}. The dominance relation is
 * based on the goal attainment approach described in Carlos M. Fonseca 
 * and Peter J. Fleming: Genetic Algorithms for Multiobjective Optimization: 
 * Formulation, Discussion and Generalization. In: Genetic Algorithms: 
 * Proceedings of the Fifth International Conference, pp 416-423. 
 * Morgan Kaufmann, 1993.
 * <br>
 * The approach is extended in C.M. Fonseca and P.J. Fleming: Multiobjective 
 * optimization and multiple constraint handling with evolutionary algorithms. 
 * I. A unified formulation. Systems, Man and Cybernetics, Part A: Systems and 
 * Humans, IEEE Transactions on, 28(1):26-37, 1998.
 * Here, it is shown that the relation is transitive.
 * <br><br>
 * 
 * The strategy is based on {@link ParetoDomination} and uses its <em>array based</em>
 * method {@link ParetoDomination#dominates(double[], double[])}.
 * <br><br>
 * 
 * 
 * It is essential to provide a <em>goal vector (reference point)</em> by a 
 * number of {@code SatisfactionConstraints} on {@code Objective}s! If no 
 * satisfaction for an {@code Objective o} exists, the constraint is consequently 
 * {@code o < negative infinity} or {@code o > positive infinity}". Semantically, a 
 * satisfaction constraint {@code x < a} will mean, that the attribute {@code x} satisfies 
 * the goal, if its value {@code v(x)} is less than {@code a}. 
 * 
 * @see DominationStrategy
 * @see SatisfactionConstraint
 * @see ParetoDomination
 * @author noorshams
 *
 */
@Singleton
public class GoalAttainmentDomination implements DominationStrategy {
	
	protected ParetoDomination paretoDomination;
	
	@Inject
	public GoalAttainmentDomination(ParetoDomination paretoDomination) {
		this.paretoDomination = paretoDomination;
	}
	
	/**
	 * {@inheritDoc} The dominance relation is <em>Goal-Attainment-Domination</em>.<br><br>
	 * 
	 * The basic idea is to give a higher priority to objectives in which the 
	 * goal is not fulfilled. Thus, when deciding whether a solution x is 
	 * preferable to a solution y or not, first, only the objectives in which 
	 * solution x does not satisfy the goal are considered, and x is preferred 
	 * to y if it dominates y on these objectives. If x is equal to y in all 
	 * these objectives, or if x satisfies the goal in all objectives, x is 
	 * preferred over y either if y does not fulfill some of the objectives 
	 * fulfilled by x, or if x dominates y on the objectives fulfilled by x.
	 * 
	 * If no {@link SatisfactionConstraint}s are present, this method just passes 
	 * the parameters on to its internal strategy for Pareto Domination. 
	 */
	/* (non-Javadoc)
	 * @see org.opt4j.core.domination.DominationStrategy#dominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)
	 */
	@Override
	public boolean dominates(Objectives o1, Objectives o2) {
		
		List<Constraint> eligibleConstraints = getAllElibleConstraints(o1);
		
		//If no eligible constraints are there, just pass the parameters on. 
		if (eligibleConstraints.size() == 0){
			return this.paretoDomination.dominates(o1, o2);
		}
		
		Constraints constraints1 = o1.getConstraints();
		Constraints constraints2 = o2.getConstraints();
		List<Double> notFullfilledConstraints1 = new ArrayList<Double>();
		List<Double> notFullfilledConstraints2 = new ArrayList<Double>();
		double[] allConstraintValues1 = new double[eligibleConstraints.size()];
		double[] allConstraintValues2 = new double[eligibleConstraints.size()];
		boolean valuesOfViolatedConstraintsAreEqual = true;
		boolean constraint2hasViolationsConstraint1doesNotHave = false;
		
		boolean violation;
		int i = 0;
		for (Constraint c : eligibleConstraints) {
			if(getObjective(c).getSign() == Sign.MIN) {
				allConstraintValues1[i] = constraints1.get(c).getDouble();
				allConstraintValues2[i] = constraints2.get(c).getDouble();
			} else {
				//Sign == MAX
				allConstraintValues1[i] = -constraints1.get(c).getDouble();
				allConstraintValues2[i] = -constraints2.get(c).getDouble();
			}
			i++; 
			violation = false;
			switch (c.getDirection()) {
				case less:
					if (!(constraints1.get(c).getDouble() < c.getLimit())) {
						violation = true;
					} else if (!(constraints2.get(c).getDouble() < c.getLimit())) {
						constraint2hasViolationsConstraint1doesNotHave = true;
					}
					break;
				case greater:
					if (!(constraints1.get(c).getDouble() > c.getLimit())) {
						violation = true;
					} else if (!(constraints2.get(c).getDouble() > c.getLimit())) {
						constraint2hasViolationsConstraint1doesNotHave = true;
					}
					break;
				case lessOrEqual:
					if (!(constraints1.get(c).getDouble() <= c.getLimit())) {
						violation = true;
					} else if (!(constraints2.get(c).getDouble() <= c.getLimit())) {
						constraint2hasViolationsConstraint1doesNotHave = true;
					}
					break;
				case greaterOrEqual:
					if (!(constraints1.get(c).getDouble() >= c.getLimit())) {
						violation = true;
					} else if (!(constraints2.get(c).getDouble() >= c.getLimit())) {
						constraint2hasViolationsConstraint1doesNotHave = true;
					}
					break;
				case equal:
					if (!(constraints1.get(c).getDouble() == c.getLimit())) {
						violation = true;
					} else if (!(constraints2.get(c).getDouble() == c.getLimit())) {
						constraint2hasViolationsConstraint1doesNotHave = true;
					}
					break;
				default:
					throw new RuntimeException("No matching case in switch statement!");
			}		
			
			if (violation) {
				double d1 = constraints1.get(c).getDouble();
				double d2 = constraints2.get(c).getDouble();
				if(getObjective(c).getSign()== Sign.MAX) {
					d1 = -d1;
					d2 = -d2;
				}
					notFullfilledConstraints1.add(d1);
					notFullfilledConstraints2.add(d2);
				
				if (d1 != d2) {
					valuesOfViolatedConstraintsAreEqual = false;
				}
			}
		}
		
		if(notFullfilledConstraints1.size() > 0 && !valuesOfViolatedConstraintsAreEqual) {
			return this.paretoDomination.dominates(listToArray(notFullfilledConstraints1), listToArray(notFullfilledConstraints2));
		} else if (constraint2hasViolationsConstraint1doesNotHave) {
			return true;
		} else {
			return this.paretoDomination.dominates(allConstraintValues1, allConstraintValues2);			
		}
	}
		
	protected double[] listToArray(List<Double> list){
		double[] array = new double[list.size()];
		int i = 0;
		for(double d : list){
			array[i] = d;
			i++;
		}
		return array;
	}
	
	protected List<Constraint> getAllElibleConstraints(Objectives o) {
		Constraints constraints = o.getConstraints();
		List<Constraint> returnList = new ArrayList<Constraint>();
		for (Iterator<Map.Entry<Constraint, Value<?>>> iterator = constraints.iterator(); iterator.hasNext();) {
			Constraint c = iterator.next().getKey();
			if(isEligibleConstraint(c)) {
				returnList.add(c);
			}
		}
		return returnList;
	}
	
	protected boolean isEligibleConstraint(Constraint constraint) {
		//only consider satisfaction constraints
		if (constraint instanceof SatisfactionConstraint) {
			return true;
		} else {
			return false;
		}
	}
	
	protected Objective getObjective(Constraint constraint) {
		if (constraint instanceof SatisfactionConstraint) {
			return ((SatisfactionConstraint) constraint).getObjective();
		} else {
			throw new RuntimeException("Wrong constraint type! Can't get objective!");
		}
	}

	/**
	 * {@inheritDoc} The dominance relation is <em>Goal-Attainment-Domination</em>.
	 * 
	 */
	/* (non-Javadoc)
	 * @see org.opt4j.core.domination.DominationStrategy#weaklyDominates(org.opt4j.core.Objectives, org.opt4j.core.Objectives)
	 */
	@Override
	public boolean weaklyDominates(Objectives o1, Objectives o2) {
		// are equal or o1 dominates o2
		
		double[] a1 = o1.array();
		double[] a2 = o2.array();
		boolean equals = true;
		
		for (int i = 0; i < a1.length; i++) {
			if(a1[i] != a2[i]){
				equals = false;
				break;
			}
		}
		
		return (equals || this.dominates(o1, o2));
	}

}

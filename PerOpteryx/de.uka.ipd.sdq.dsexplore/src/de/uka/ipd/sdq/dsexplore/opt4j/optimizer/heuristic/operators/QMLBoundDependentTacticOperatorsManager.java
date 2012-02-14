/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import org.opt4j.core.Constraint;
import org.opt4j.core.InfeasibilityConstraint;
import org.opt4j.core.SatisfactionConstraint;
import org.opt4j.core.Value;
import org.opt4j.core.Genotype;
import org.opt4j.operator.copy.Copy;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;

/**
 * Applies activated heuristics based on the constraint violation of an 
 * individual in the following order:
 * 1) Try to get individual feasible if it is infeasible. 
 * 2) Try to reach all defined goals if not reached yet. 
 * 3) Apply any heuristic applicable if no previous case applies.   
 * 
 * @author noorshams
 *
 */
public class QMLBoundDependentTacticOperatorsManager extends TacticOperatorsManager {

	@Inject
	public QMLBoundDependentTacticOperatorsManager(Copy<Genotype> copy,
			DSEIndividualFactory individualFactory) {
		super(copy, individualFactory);
	}
	
	/**
	 * Applies heuristics based on all constraint violations of an individual: 
	 * Try to make individual feasible. If feasible, try to reach all goals. If all goals
	 * reached, apply any heuristic. 
	 */
	@Override
	public List<TacticsResultCandidate> getAllCandidates(
			DSEIndividual individual) {
		//results cache for the current candidate. 
		UtilisationResultCacheAndHelper resultsCache = new UtilisationResultCacheAndHelper(); 
		
		
		List<TacticsResultCandidate> result = new ArrayList<TacticsResultCandidate>();
		Collection<TacticsResultCandidate> candidatesFromCurrentHeuristic;
		Set<ITactic> applicableHeuristics = new HashSet<ITactic>();
		
		//get all constraint violations and fulfillments
		ConstraintViolationInformation cvi = analyzeConstraints(individual);
		
		if(cvi.getViolatedInfeasibilityConstraints().size() > 0) {
			//individual is infeasible try to make it feasible
			
			for(InfeasibilityConstraint c : cvi.getViolatedInfeasibilityConstraints()) {
				EvaluationAspectWithContext pivotAspectContext = 
					PCMDeclarationsReader.retranslateCriterionToEvaluationAspect(c);				
				
				//pick applicable heuristic that improves aspect					
				for(ITactic h: heuristics) {
					if(h.improves(pivotAspectContext.getDimension(), pivotAspectContext.getEvaluationAspect())){
						applicableHeuristics.add(h);
					}
				}
			}
		} else {
			//individual is feasible try to reach all goals (-> fulfill all SatisfactionConstraints)
			
			if(cvi.getViolatedSatisfactionConstraints().size() > 0) {
				//not all goals reached
				
				for (SatisfactionConstraint c : cvi.getViolatedSatisfactionConstraints()) {
					EvaluationAspectWithContext pivotAspectContext = 
						PCMDeclarationsReader.retranslateCriterionToEvaluationAspect(c);				
					
					//pick applicable heuristic that improves aspect					
					for(ITactic h: heuristics) {
						if(h.improves(pivotAspectContext.getDimension(), pivotAspectContext.getEvaluationAspect())){
							applicableHeuristics.add(h);
						}
					}
				}
			} else {
				//all goals reached, apply any possible heuristic 
				applicableHeuristics.addAll(heuristics);
			}
		}
		
		if (applicableHeuristics.size() == 0){
			//no tactic is applicable in this case, so again add all
			applicableHeuristics.addAll(heuristics);
		}
				
		//apply heuristic
		for(ITactic heuristic : applicableHeuristics){
			candidatesFromCurrentHeuristic = heuristic.getHeuristicCandidates(individual, resultsCache);
			if (candidatesFromCurrentHeuristic.size() > 0) {
				this.writer.writeTacticCandidateInfo(heuristic, candidatesFromCurrentHeuristic);
			}
			result.addAll(candidatesFromCurrentHeuristic);
		}
		//XXX Try again to add all other tactics if the appropriate ones did not help? Or rather do not apply tactics in this case?
		
		return result;
	}
	
	protected boolean isViolated(Entry<Constraint, Value<?>> constraintAndValue) {
		boolean violated = false;
		Constraint c = constraintAndValue.getKey();
		Value<?> v = constraintAndValue.getValue();
		
		switch (c.getDirection()) {
			case less:
				if(!(v.getDouble() < c.getLimit())){
					violated = true;
				}
				break;
			case lessOrEqual:
				if(!(v.getDouble() <= c.getLimit())){
					violated = true;
				}			
				break;
			case equal:
				if(!(v.getDouble() == c.getLimit())){
					violated = true;
				}
				break;
			case greater:
				if(!(v.getDouble() > c.getLimit())){
					violated = true;
				}
				break;
			case greaterOrEqual:
				if(!(v.getDouble() >= c.getLimit())){
					violated = true;
				}
				break;
			default:
				throw new RuntimeException("Unexpected case in switch statement!");				
		}
		return violated;
	}
	
	protected boolean isFulfilled(Entry<Constraint, Value<?>> constraintAndValue) {
		boolean fulfilled = false;
		Constraint c = constraintAndValue.getKey();
		Value<?> v = constraintAndValue.getValue();
		
		switch (c.getDirection()) {
			case less:
				if(v.getDouble() < c.getLimit()){
					fulfilled = true;
				}
				break;
			case lessOrEqual:
				if(v.getDouble() <= c.getLimit()){
					fulfilled = true;
				}			
				break;
			case equal:
				if(v.getDouble() == c.getLimit()){
					fulfilled = true;
				}
				break;
			case greater:
				if(v.getDouble() > c.getLimit()){
					fulfilled = true;
				}
				break;
			case greaterOrEqual:
				if(v.getDouble() >= c.getLimit()){
					fulfilled = true;
				}
				break;
			default:
				throw new RuntimeException("Unexpected case in switch statement!");				
		}
		return fulfilled;
	}
	
	protected ConstraintViolationInformation analyzeConstraints(DSEIndividual individual){
		ConstraintViolationInformation cvi = new ConstraintViolationInformation();
		for(Entry<Constraint, Value<?>> constraintAndValue : individual.getObjectives().getConstraints()) {
			if (isViolated(constraintAndValue)) {
				if (constraintAndValue.getKey() instanceof InfeasibilityConstraint) {
					cvi.addViolatedInfeasibilityConstraint((InfeasibilityConstraint)constraintAndValue.getKey());
				} else {
					//SatisfactionConstraint
					cvi.addViolatedSatisfactionConstraint((SatisfactionConstraint)constraintAndValue.getKey());
				}
			} else if (isFulfilled(constraintAndValue)) { // To ignore constraints where the value is NaN, check constraints explicitly
				if (constraintAndValue.getKey() instanceof InfeasibilityConstraint) {
					cvi.addFulfilledInfeasibilityConstraint((InfeasibilityConstraint)constraintAndValue.getKey());
				} else {
					//SatisfactionConstraint
					cvi.addFulfilledSatisfactionConstraint((SatisfactionConstraint)constraintAndValue.getKey());
				}
			}
				
		}
			
		return cvi;
	}
	
	protected class ConstraintViolationInformation {
		protected List<InfeasibilityConstraint> violatedInfeasibilityConstraints = new ArrayList<InfeasibilityConstraint>();
		protected List<InfeasibilityConstraint> fulfilledInfeasibilityConstraints = new ArrayList<InfeasibilityConstraint>();
		protected List<SatisfactionConstraint> violatedSatisfactionConstraints = new ArrayList<SatisfactionConstraint>();
		protected List<SatisfactionConstraint> fulfilledSatisfactionConstraints = new ArrayList<SatisfactionConstraint>();
		
		public List<InfeasibilityConstraint> getViolatedInfeasibilityConstraints() {
			return violatedInfeasibilityConstraints;
		}

		public void addViolatedInfeasibilityConstraint(
				InfeasibilityConstraint violoatedInfeasibilityConstraint) {
			this.violatedInfeasibilityConstraints.add(violoatedInfeasibilityConstraint);
		}

		public List<InfeasibilityConstraint> getFulfilledInfeasibilityConstraints() {
			return fulfilledInfeasibilityConstraints;
		}

		public void addFulfilledInfeasibilityConstraint(
				InfeasibilityConstraint fulfilledInfeasibilityConstraint) {
			this.fulfilledInfeasibilityConstraints.add(fulfilledInfeasibilityConstraint);
		}

		public List<SatisfactionConstraint> getViolatedSatisfactionConstraints() {
			return violatedSatisfactionConstraints;
		}

		public void addViolatedSatisfactionConstraint(
				SatisfactionConstraint violoatedSatisfactionConstraint) {
			this.violatedSatisfactionConstraints.add(violoatedSatisfactionConstraint);
		}
		
		public List<SatisfactionConstraint> getFulfilledSatisfactionConstraints() {
			return fulfilledSatisfactionConstraints;
		}

		public void addFulfilledSatisfactionConstraint(
				SatisfactionConstraint fulfilledSatisfactionConstraint) {
			this.fulfilledSatisfactionConstraints.add(fulfilledSatisfactionConstraint);
		}		
	}
	
	//Don't override, same picking method as superclass
//	@Override
//	public DSEIndividual getCandidate(DSEIndividual individual)

	
}

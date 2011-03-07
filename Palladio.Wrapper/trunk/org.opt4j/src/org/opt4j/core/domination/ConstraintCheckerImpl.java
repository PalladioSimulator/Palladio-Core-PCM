/**
 * 
 */
package org.opt4j.core.domination;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.opt4j.core.Constraint;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.InfeasibilityConstraint;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.Range;
import org.opt4j.core.Value;

import com.google.inject.Inject;
import com.google.inject.Singleton;





/**
 * {@code ConstraintCheckerImpl} calculates constraint violations of 
 * <em>infeasibility</em> constraints.
 *  
 * @see ConstraintChecker
 * @author noorshams
 *
 */
@Singleton
public class ConstraintCheckerImpl implements ConstraintChecker, IndividualCollectionListener, IndividualStateListener {

	// stores range of each constraint
	// make it thread safe to avoid accidental problems 
	protected Map<Constraint, Range> constraintRanges = new ConcurrentHashMap<Constraint, Range>(); 
	
	
	//as this class listens on Population, it must be registered there
	@Inject
	public ConstraintCheckerImpl(Population population) {
		// When individuals are added, they are NOT yet evaluated! 
		// Wait for a state change
		population.addListener(this);
	}
	
	protected boolean isEligibleConstraint(Constraint constraint) {
		//only consider infeasibility constraints
		if (constraint instanceof InfeasibilityConstraint) {
			return true;
		} else {
			return false;
		}
	}
	
	protected boolean isIneligibleConstraint(Constraint constraint) {
		return !isEligibleConstraint(constraint);
	}
	
	/**
	 * {@inheritDoc}
	 */
	/* (non-Javadoc)
	 * @see constrainChecker.ConstraintChecker#getConstraintViolation(org.opt4j.core.Objectives)
	 */
	@Override
	public double getConstraintViolation(Objectives o) {
		Iterator<Entry<Constraint, Value<?>>> constraint_iterator; 
		constraint_iterator = o.getConstraints().iterator();
		
		Constraint constraint;
		Value<?> value;
		Entry<Constraint, Value<?>> entry;
		double violation = 0;
		double violSingleConstraint;
		boolean isViolated;
		Range range;
		// Check every constraint and add up all violation
		while (constraint_iterator.hasNext()) {
			
			isViolated = false;
			violSingleConstraint = 0;
			entry = (Entry<Constraint, Value<?>>) constraint_iterator.next();
			constraint = entry.getKey();
			value = entry.getValue();
			
			if(isIneligibleConstraint(constraint)) {
				continue;
			}
			
			// check depends on direction of the constraint
			switch (constraint.getDirection()) {
				case less:
					if (!(value.getDouble() < constraint.getLimit())){
						isViolated = true;						
					}
					break;					
				case greater:
					if (!(value.getDouble() > constraint.getLimit())){
						isViolated = true;
					}
					break;
				case lessOrEqual:
					if (!(value.getDouble() <= constraint.getLimit())){
						isViolated = true;						
					}
					break;					
				case greaterOrEqual:
					if (!(value.getDouble() >= constraint.getLimit())){
						isViolated = true;
					}
					break;
				case equal:
					if (!(value.getDouble() == constraint.getLimit())){
						isViolated = true;						
					}
					break;
				default:
					throw new RuntimeException("No matching case in switch statement: " + constraint.getDirection());
			}
			if(isViolated){
				violSingleConstraint = Math.abs(value.getDouble() - constraint.getLimit());
			
				// Scaling according to range (if possible)
				range = constraintRanges.get(constraint);
				if(range.getMin() != range.getMax()) {
					violSingleConstraint /= (range.getMax() - range.getMin());
				}
			}
			
			violation += violSingleConstraint;
		}
		return violation;
	}

	/**
	 * {@inheritDoc}
	 */
	/* (non-Javadoc)
	 * @see constrainChecker.ConstraintChecker#isFeasible(org.opt4j.core.Objectives)
	 */
	@Override
	public boolean isFeasible(Objectives o) {
		Iterator<Entry<Constraint, Value<?>>> constraint_iterator; 
		constraint_iterator = o.getConstraints().iterator();
		
		Constraint constraint;
		Value<?> value;
		Entry<Constraint, Value<?>> entry;
		// Check every constraint, if it holds
		while (constraint_iterator.hasNext()) {
			entry = (Entry<Constraint, Value<?>>) constraint_iterator.next();
			constraint = entry.getKey();
			value = entry.getValue();
			
			if(isIneligibleConstraint(constraint)) {
				continue;
			}
						
			// check depends on direction of the constraint
			switch (constraint.getDirection()) {
				case less:
					if (!(value.getDouble() < constraint.getLimit())){
						return false;
					}
					break;					
				case greater:
					if (!(value.getDouble() > constraint.getLimit())){
						return false;
					}
					break;
				case lessOrEqual:
					if (!(value.getDouble() <= constraint.getLimit())){
						return false;
					}
					break;					
				case greaterOrEqual:
					if (!(value.getDouble() >= constraint.getLimit())){
						return false;
					}
					break;
				case equal:
					if (!(value.getDouble() == constraint.getLimit())){
						return false;
					}
					break;
				default:
					throw new RuntimeException("No matching case in switch statement: " + constraint.getDirection());
			}
		}
		return true;
	}

	@Override
	public void individualAdded(IndividualCollection collection,
			Individual individual) {
		// Added Individuals are not yet evaluated
		// However, to be sure inidividualStateChanged() can be called
	}

	@Override
	public void individualRemoved(IndividualCollection collection,
			Individual individual) {
				
		for (Iterator<Map.Entry<Constraint, Value<?>>> iterator = individual.getObjectives().getConstraints().iterator(); iterator.hasNext();) {
			Map.Entry<Constraint, Value<?>> entry = iterator.next();
			
			if(isIneligibleConstraint(entry.getKey())) {
				continue;
			}
			
			Range range = this.constraintRanges.get(entry.getKey());
			if (range != null) {
				if (entry.getValue().getDouble() == range.getMin() || entry.getValue().getDouble() == range.getMax()) {
					// Check, if current range still is valid
					double currentMin = range.getMin();
					double currentMax = range.getMax();
					boolean currentMinStillExists = false;
					boolean currentMaxStillExists = false;					
										
					// Recalculate range
					double min = Double.MAX_VALUE;
					double max = Double.MIN_VALUE;
					for (Iterator<Individual> iterator2 = collection.iterator(); iterator2
							.hasNext();) {
						Individual individual2 = (Individual) iterator2.next();
						Value<?> v = individual2.getObjectives().getConstraints().get(entry.getKey());
						if (v.getDouble() > max) {
							max = v.getDouble();
						}
						if (v.getDouble() < min) {
							min = v.getDouble();
						}
						
												
						if (v.getDouble() == currentMin) {
							currentMinStillExists = true;
						}						
						if (v.getDouble() == currentMax) {
							currentMaxStillExists = true;
						}						
						if (currentMaxStillExists && currentMinStillExists) {
							break;
						}
					}

					// If current range still is valid, there is no need for change
					if (!currentMaxStillExists || !currentMinStillExists) {
						this.constraintRanges.remove(entry.getKey());
						constraintRanges.put(entry.getKey(), new Range(min, max));
					}
										
				}
			}
		}
	}

	@Override
	public void inidividualStateChanged(Individual individual) {
		// We need evaluated individuals 
		if (!individual.isEvaluated()) {
			return;
		}
		// Evaluated individuals belong to the population
		
		
		//Check the range of each constraint
		for (Iterator<Map.Entry<Constraint, Value<?>>> iterator = individual.getObjectives().getConstraints().iterator(); 
		iterator.hasNext();) {
			Map.Entry<Constraint, Value<?>> entry = iterator.next();
			
			if(isIneligibleConstraint(entry.getKey())) {
				continue;
			}
			
			Range range = this.constraintRanges.get(entry.getKey());
			if (range == null ){ // Range is not initialized
				Range r = new Range(entry.getValue().getDouble(), entry.getValue().getDouble());
				this.constraintRanges.put(entry.getKey(), r);
			} else { // Check min/max
				if (entry.getValue().getDouble() < range.getMin()) {
					range.setMin(entry.getValue().getDouble());
				} else if (entry.getValue().getDouble() > range.getMax()) {
					range.setMax(entry.getValue().getDouble());
				}
			}
		}
		
	}

}

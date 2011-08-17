package de.uka.ipd.sdq.dsexplore.opt4j.operator;



import java.util.List;

import org.apache.log4j.Logger;
import org.opt4j.common.random.Rand;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.IntegerGenotype;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.operator.mutate.MutateDouble;
import org.opt4j.operator.mutate.MutateInteger;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.exception.ChoiceOutOfBoundsException;
import de.uka.ipd.sdq.dsexplore.exception.InvalidChoiceForDegreeException;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationChoice;
import de.uka.ipd.sdq.pcm.designdecision.EnumerationDegree;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyChoice;
import de.uka.ipd.sdq.pcm.designdecision.SchedulingPolicyDegree;
import de.uka.ipd.sdq.pcm.resourceenvironment.SchedulingPolicy;

/**
 * Mutator for {@link DesignDecisionGenotype}s. Calls the bound {@link MutateInteger} or {@link MutateDouble}, depending on 
 * the type of {@link DegreeOfFreedom} of each gene. 
 * 
 * @author martens
 *
 */
public class MutateDesignDecisionGenotype implements Mutate<DesignDecisionGenotype> {
	
	MutateInteger mutateInteger;
	MutateDouble mutateDouble;
	private Rand random;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.operator.MutateDesignDecisionGenotype");
	
	@Inject
	public MutateDesignDecisionGenotype(Rand random, MutateInteger mutateInteger, MutateDouble mutateDouble){
		 this.mutateDouble = mutateDouble;
		 this.mutateInteger = mutateInteger;
		 this.random = random;
	}

	/**
	 * Mutates the passed {@link DesignDecisionGenotype} by calling a matching {@link Mutate}
	 * for each gene.
	 */
	@Override
	public void mutate(DesignDecisionGenotype genotype) {
		for (Choice choice : genotype) {
			if (choice instanceof DiscreteRangeChoice){
				mutateDiscrete((DiscreteRangeChoice)choice);
			} else if (choice instanceof EnumerationChoice){
				mutateEnum((EnumerationChoice)choice);
			} else if (choice instanceof ContinousRangeChoice){
				mutateContinous((ContinousRangeChoice)choice);
			} else if (choice instanceof SchedulingPolicyChoice){
				mutateSchedulingPolicyChoice((SchedulingPolicyChoice)choice);
			} else {
				throw new UnsupportedOperationException("Choice type "+choice+" not supported.");
			}
		}
	}
	
	private void mutateSchedulingPolicyChoice(SchedulingPolicyChoice choice) {
		DegreeOfFreedom degree = choice.getDegreeOfFreedom();
		if (degree instanceof SchedulingPolicyDegree){
			SchedulingPolicyDegree schedDegree = (SchedulingPolicyDegree)degree;
			List<SchedulingPolicy> domain = schedDegree.getDomainOfAllowedSchedulingPolicies();
			
			int oldIndex = domain.indexOf(choice.getChosenValue());
			if (oldIndex == -1){
				throw new ChoiceOutOfBoundsException(choice, "Error when mutating individual, old choice was invalid");
			}
			int newIndex = randomlySelectNewIndex(domain, oldIndex);
			
			choice.setChosenValue(domain.get(newIndex));
			
		} else {
			throw new InvalidChoiceForDegreeException(choice);
		}
		
	}

	@SuppressWarnings("unchecked")
	private int randomlySelectNewIndex(List domain,
			int oldIndex) {
		//use mutateInteger as that one already realises a uniform distribution among the possible values with a certain rate. 
		int newIndex = mutateInteger(oldIndex, 0, domain.size()-1);
		
		//choose new value from the (size - 1) (all except old) values. 
		//randomly choose an integer from [0,size-2]
		//int newIndex = this.random.nextInt(enumDegree.getDomainOfEntities().size() -1);
		//if new index is larger or equal than the old value's index, shift it by one, 
		//to achieve a uniform distribution and not choose the old value again. 
		//if (oldIndex <= newIndex){
		//	newIndex ++;
		//}

		if (newIndex < 0 || newIndex >= domain.size()){
			throw new RuntimeException("Error when mutating integer index value: Value is out of bounds!");
		}
		return newIndex;
	}

	/**
	 * Calls {@link MutateDouble} for the given {@link Choice}.
	 * @param choice
	 */
	private void mutateContinous(ContinousRangeChoice choice) {
		DegreeOfFreedom degree = choice.getDegreeOfFreedom();
		if (degree instanceof ContinuousRangeDegree){
			ContinuousRangeDegree contDegree = (ContinuousRangeDegree)degree;
			DoubleGenotype doubleList = new DoubleGenotype(contDegree.getFrom(),contDegree.getTo());
			doubleList.add(choice.getChosenValue());
			this.mutateDouble.mutate(doubleList);
			double newValue = doubleList.get(0);
			choice.setChosenValue(newValue);
		} else throw new InvalidChoiceForDegreeException(choice);
	}

	/**
	 * Mutates an enumeration design decision (i.e. without order) by randomly choosing a 
	 * new (!= old) value from the design decision options.
	 * 
	 * @param choice
	 */
	private void mutateEnum(EnumerationChoice choice) {
		DegreeOfFreedom degree = choice.getDegreeOfFreedom();
		if (degree instanceof EnumerationDegree){
			EnumerationDegree enumDegree = (EnumerationDegree) degree;
			int oldIndex = enumDegree.getDomainOfEntities().indexOf(choice.getEntity());
			if (oldIndex == -1){
				throw new ChoiceOutOfBoundsException(choice, "Error when mutating individual, old choice was invalid");
			}
			//use mutateInteger as that one already realises a uniform distribution among the possible values with a certain rate. 
			int newIndex = randomlySelectNewIndex(enumDegree.getDomainOfEntities(), oldIndex);
			
			choice.setEntity(enumDegree.getDomainOfEntities().get(newIndex));
		}
	}

	/**
	 * Calls {@link MutateInteger} for the given {@link Choice}. 
	 * @param choice
	 */
	private void mutateDiscrete(DiscreteRangeChoice choice) {
		DegreeOfFreedom degree = choice.getDegreeOfFreedom();
		if (degree instanceof DiscreteRangeDegree) {
			DiscreteRangeDegree discDegree = (DiscreteRangeDegree) degree;
			int newValue = mutateInteger(choice.getChosenValue(), discDegree.getFrom(), discDegree.getTo());
			choice.setChosenValue(newValue);
		} else throw new InvalidChoiceForDegreeException(choice);
		
	}

	private int mutateInteger(int oldValue, int lowerBound, int upperBound) {
		IntegerGenotype integerGenotype = new IntegerGenotype(lowerBound, upperBound);
		integerGenotype.add(oldValue);
		this.mutateInteger.mutate(integerGenotype);
		int newValue = integerGenotype.get(0);
		return newValue;
	}

}

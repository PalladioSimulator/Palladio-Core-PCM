package de.uka.ipd.sdq.dsexplore.opt4j.operator;



import java.util.List;

import org.opt4j.common.random.Rand;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.IntegerGenotype;
import org.opt4j.operator.mutate.Mutate;
import org.opt4j.operator.mutate.MutateDouble;
import org.opt4j.operator.mutate.MutateInteger;
import org.opt4j.operator.mutate.MutationRate;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.exception.ChoiceOutOfBoundsException;
import de.uka.ipd.sdq.dsexplore.exception.InvalidChoiceForDegreeException;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.ClassDegree;
import de.uka.ipd.sdq.pcm.designdecision.ContinousRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.OrderedIntegerDegree;


/**
 * Mutator for {@link DesignDecisionGenotype}s. Calls the bound {@link MutateInteger} or {@link MutateDouble}, depending on 
 * the type of {@link DegreeOfFreedomInstance} of each gene. 
 * 
 * @author martens
 *
 */
public class MutateDesignDecisionGenotype implements Mutate<DesignDecisionGenotype> {
	
	private MutateInteger mutateInteger;
	private MutateDouble mutateDouble;
	private MutationRate mutationRate;
	private Rand random;
	

	@Inject
	public MutateDesignDecisionGenotype(Rand random, MutateInteger mutateInteger, MutateDouble mutateDouble, MutationRate rate){
		 this.mutateDouble = mutateDouble;
		 this.mutateInteger = mutateInteger;
		 this.mutationRate = rate;
		 this.random = random;
		 
	}

	/**
	 * Mutates the passed {@link DesignDecisionGenotype} by calling a matching {@link Mutate}
	 * for each gene.
	 */
	@Override
	public void mutate(DesignDecisionGenotype genotype, double mutationRate) {
		for (Choice choice : genotype) {
			if (random.nextDouble() < mutationRate) {
				if (choice instanceof DiscreteRangeChoice){
					mutateDiscrete((DiscreteRangeChoice)choice);
				} else if (choice instanceof ClassChoice){
					mutateEnum((ClassChoice)choice);
				} else if (choice instanceof ContinousRangeChoice){
					mutateContinous((ContinousRangeChoice)choice);
				} else {
					throw new UnsupportedOperationException("Choice type "+choice+" not supported.");
				}
			}
		}
	}
	
	private int randomlySelectNewIndex(List<?> domain,
			int oldIndex) {
		//use mutateInteger as that one already realises a uniform distribution among the possible values with a certain rate. 
		int newIndex = mutateInteger(oldIndex, 0, domain.size()-1);
		
		//choose new value from the (size - 1) (all except old) values. 
		//randomly choose an integer from [0,size-2]
		//int newIndex = this.random.nextInt(enumDegree.getClassDesignOptions().size() -1);
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
		DegreeOfFreedomInstance degree = choice.getDegreeOfFreedomInstance();
		if (degree instanceof ContinuousRangeDegree){
			ContinuousRangeDegree contDegree = (ContinuousRangeDegree)degree;
			DoubleGenotype doubleList = new DoubleGenotype(contDegree.getFrom(),contDegree.getTo());
			doubleList.add(choice.getChosenValue());
			this.mutateDouble.mutate(doubleList, this.mutationRate.get());
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
	private void mutateEnum(ClassChoice choice) {
		DegreeOfFreedomInstance degree = choice.getDegreeOfFreedomInstance();
		if (degree instanceof ClassDegree){
			ClassDegree enumDegree = (ClassDegree) degree;
			int oldIndex = enumDegree.getClassDesignOptions().indexOf(choice.getChosenValue());
			if (oldIndex == -1){
				throw new ChoiceOutOfBoundsException(choice, "Error when mutating individual, old choice was invalid");
			}
			//use mutateInteger as that one already realises a uniform distribution among the possible values with a certain rate. 
			int newIndex = randomlySelectNewIndex(enumDegree.getClassDesignOptions(), oldIndex);
			
			choice.setChosenValue(enumDegree.getClassDesignOptions().get(newIndex));
		}
	}

	/**
	 * Calls {@link MutateInteger} for the given {@link Choice}. 
	 * @param choice
	 */
	private void mutateDiscrete(DiscreteRangeChoice choice) {
		DegreeOfFreedomInstance degree = choice.getDegreeOfFreedomInstance();
		if (degree instanceof DiscreteRangeDegree) {
			DiscreteRangeDegree discDegree = (DiscreteRangeDegree) degree;
			int newValue = mutateInteger(choice.getChosenValue(), discDegree.getFrom(), discDegree.getTo());
			choice.setChosenValue(newValue);
		} else if (degree instanceof OrderedIntegerDegree){
			OrderedIntegerDegree orderedIntegerDegree = (OrderedIntegerDegree) degree;
			int currentIndex = orderedIntegerDegree.getListOfIntegers().indexOf(new Integer(choice.getChosenValue()));
			int randomIndex = mutateInteger(currentIndex, 0,orderedIntegerDegree.getListOfIntegers().size()-1);
			choice.setChosenValue(orderedIntegerDegree.getListOfIntegers().get(randomIndex));
		} else throw new InvalidChoiceForDegreeException(choice);
		
	}

	private int mutateInteger(int oldValue, int lowerBound, int upperBound) {
		IntegerGenotype integerGenotype = new IntegerGenotype(lowerBound, upperBound);
		integerGenotype.add(oldValue);
		this.mutateInteger.mutate(integerGenotype, this.mutationRate.get());
		int newValue = integerGenotype.get(0);
		return newValue;
	}

}

package de.uka.ipd.sdq.dsexplore.exception;

import de.uka.ipd.sdq.dsexplore.helper.DegreeOfFreedomHelper;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedomInstance;
import de.uka.ipd.sdq.pcm.designdecision.DiscreteRangeChoice;

/**
 * Thrown in the value of a {@link Choice} is not contained in the corresponding {@link DegreeOfFreedomInstance}.
 * Example: {@link DiscreteRangeChoice} A has the chosen value 5, but the linked {@link DegreeOfFreedomInstance} D 
 * has from = 7 and to = 10.
 *   
 * @author martens
 *
 */
public class ChoiceOutOfBoundsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5518058966677144866L;
	
	public ChoiceOutOfBoundsException(ClassChoice choice){
		super("Chosen entity "+choice.getChosenValue()+" of choice "+choice.getClass().getSimpleName()+" does not exist in domain of degree "+DegreeOfFreedomHelper.getDegreeDescription(choice.getDegreeOfFreedomInstance())+" of type "+choice.getDegreeOfFreedomInstance().getClass().getSimpleName());
	}
	
	public ChoiceOutOfBoundsException(ClassChoice choice, String location){
		super(location+": Chosen entity "+choice.getChosenValue()+" of choice "+choice.getClass().getSimpleName()+" does not exist in domain of degree "+DegreeOfFreedomHelper.getDegreeDescription(choice.getDegreeOfFreedomInstance())+" of type "+choice.getDegreeOfFreedomInstance().getClass().getSimpleName());
	}

	public ChoiceOutOfBoundsException(DiscreteRangeChoice discreteChoice) {
		super("Chosen value "+discreteChoice.getChosenValue()+" of choice "+discreteChoice.getClass().getSimpleName()+" does not exist in domain of degree "+DegreeOfFreedomHelper.getDegreeDescription(discreteChoice.getDegreeOfFreedomInstance())+" of type "+discreteChoice.getDegreeOfFreedomInstance().getClass().getSimpleName());
	}
	
	public ChoiceOutOfBoundsException(DiscreteRangeChoice discreteChoice, String message) {
		super("Chosen value "+discreteChoice.getChosenValue()+" of choice "+discreteChoice.getClass().getSimpleName()+" does not exist in domain of degree "+DegreeOfFreedomHelper.getDegreeDescription(discreteChoice.getDegreeOfFreedomInstance())+" of type "+discreteChoice.getDegreeOfFreedomInstance().getClass().getSimpleName()+". Details: "+message);
	}


}

package de.uka.ipd.sdq.dsexplore.exception;

import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcm.designdecision.ContinuousRangeDegree;
import de.uka.ipd.sdq.pcm.designdecision.DegreeOfFreedom;
import de.uka.ipd.sdq.pcm.designdecision.ClassChoice;

/**
 * This exception is thrown if a {@link Choice} and the linked {@link DegreeOfFreedom} 
 * do not match by their type. 
 * 
 * Example: an
 * {@link ClassChoice} links a {@link ContinuousRangeDegree}).
 * 
 * @author martens
 *
 */
public class InvalidChoiceForDegreeException extends RuntimeException {

	public InvalidChoiceForDegreeException(Choice choice) {
		super("Degree "+choice.getDegreeOfFreedom().getClass().getName()+" and choice "+choice.getClass().getName()+" do not match!");

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 6487974641238880884L;

}

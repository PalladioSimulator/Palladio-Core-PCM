package de.uka.ipd.sdq.stoex.analyser.exceptions;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpectedTypeMismatchIssue implements IIssue {

	private TypeEnum expectedType;
	private TypeEnum foundType;

	public ExpectedTypeMismatchIssue(TypeEnum expectedType, TypeEnum type) {
		this.expectedType = expectedType;
		this.foundType = type;
	}

	public String getMessage() {
		return "Expected Type and Actual Type mismatch.\nInfered Type: "+foundType.name()+" Expected Type: "+expectedType.name();
	}

}

package de.uka.ipd.sdq.stoex.analyser.exceptions;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpectedTypeMismatchIssue implements IIssue {

	private String expectedType;
	private TypeEnum foundType;

	public ExpectedTypeMismatchIssue(TypeEnum expectedType, TypeEnum type) {
		this.expectedType = expectedType.name();
		this.foundType = type;
	}

	public ExpectedTypeMismatchIssue(String expectedType, TypeEnum type) {
		this.expectedType = expectedType;
		this.foundType = type;
	}

	public String getMessage() {
		return 
			"Expected Type and Actual Type mismatch.\nInfered Type: " +
			( foundType == null ? "unknown" : foundType.name() ) +
			", Expected Type: "+expectedType;
	}

}

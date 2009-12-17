package de.uka.ipd.sdq.errorhandling;

import org.eclipse.emf.ecore.EObject;

public class SeverityAndIssue implements Comparable<SeverityAndIssue> {

	private final SeverityEnum error;
	private String message;
	private EObject element;
	
	public SeverityAndIssue(SeverityEnum error, String message, EObject element) {
		this.error = error;
		this.message = message;
		this.element = element;
	}

	public String getMessage(){
		return message;
	}
	
	public EObject getElement() {
		return element;
	}

	public String getResourceName() {
		return element.eResource().getURI().toFileString();
	}
	
	public SeverityEnum getError() {
		return error;
	}

	public int compareTo(SeverityAndIssue o) {
		if (this.error == o.getError())
			return 0;
		if (this.error == SeverityEnum.ERROR && o.getError() == SeverityEnum.WARNING)
			return -1;
		else
			return 1;
	}

}

package de.uka.ipd.sdq.errorhandling;

import org.eclipse.emf.ecore.EObject;

public class SeverityAndIssue implements Comparable<SeverityAndIssue> {

	private int error;
	private String message;
	private EObject element;
	
	public SeverityAndIssue(int error, String message, EObject element) {
		this.error = error;
		this.message = message;
		this.element = element;
	}
	
	public static final int ERROR = 0;
	public static final int WARNING = 1;

	public String getMessage(){
		return message;
	}
	
	public EObject getElement() {
		return element;
	}

	public String getResourceName() {
		return element.eResource().getURI().toFileString();
	}
	
	public int getError() {
		return error;
	}

	public int compareTo(SeverityAndIssue o) {
		if (this.error == o.getError())
			return 0;
		if (this.error == ERROR && o.getError() == WARNING)
			return -1;
		else
			return 1;
	}

}

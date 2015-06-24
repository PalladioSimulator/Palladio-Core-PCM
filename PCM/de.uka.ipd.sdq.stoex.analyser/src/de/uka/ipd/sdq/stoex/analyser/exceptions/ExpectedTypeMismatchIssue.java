package de.uka.ipd.sdq.stoex.analyser.exceptions;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ExpectedTypeMismatchIssue implements IIssue {

	private String expectedType;
	private TypeEnum foundType;
	private EObject object;
    private EStructuralFeature feature;

	public ExpectedTypeMismatchIssue(TypeEnum expectedType, TypeEnum type) {
		this.expectedType = expectedType.name();
		this.foundType = type;
	}

	public ExpectedTypeMismatchIssue(String expectedType, TypeEnum type) {
		this.expectedType = expectedType;
		this.foundType = type;
	}
	
	public ExpectedTypeMismatchIssue(String expectedType, TypeEnum type, EObject object, EStructuralFeature feature) {
        this(expectedType, type);
        this.object = object;
        this.feature = feature;
    }
	
	public ExpectedTypeMismatchIssue(TypeEnum expectedType, TypeEnum type, EObject object, EStructuralFeature feature) {
        this(expectedType, type);
        this.object = object;
        this.feature = feature;
    }

	public String getMessage() {
		return 
			"Expected Type and Actual Type mismatch.\nInfered Type: " +
			( foundType == null ? "unknown" : foundType.name() ) +
			", Expected Type: "+expectedType;
	}
	
	public TypeEnum getFoundType(){
	    return foundType;
	}
	
	public String getExpectedType(){
	    return expectedType;
	}
	
	public EObject getObject(){
	    return object;
	}
	
	public EStructuralFeature getFeature(){
	    return feature;
	}

}

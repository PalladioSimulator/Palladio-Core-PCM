/**
 * 
 */
package de.uka.ipd.sdq.cip.configuration;

public enum TransformationType {
	NONE,
	REGISTERED,
	FEATURE,
	ANNOTATED,
	PLAIN;
	
	public String toString(){
		if(this == REGISTERED)
			return "Registered";
		else if(this == FEATURE)
			return "Feature";
		else if(this == ANNOTATED)
			return "Annoteted";
		else if(this == PLAIN)
			return "Plain";
		
		return "None";
	}
	
	public static TransformationType fromString(String value){
		if(value.equalsIgnoreCase  ("Registered"))
			return REGISTERED;
		else if(value.equalsIgnoreCase  ("Feature"))
			return FEATURE;
		else if(value.equalsIgnoreCase  ("Annoteted"))
			return ANNOTATED;
		else if(value.equalsIgnoreCase  ("Plain"))
			return PLAIN;
		
		return NONE;
	}
}
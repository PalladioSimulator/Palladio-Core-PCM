/**
 * 
 */
package de.uka.ipd.sdq.cip.completions;

import java.util.Scanner;

/**
 * 
 * 
 * @author Thomas Schuischel
 */
public class CompletionEntry{

	//private CompletionSet set;
	private CompletionType type;
	private Boolean active;
	private String featureFile;
	/**
	 * @param type
	 */
	public CompletionEntry(CompletionType type) {
		this.type = type;
		active = false;
		featureFile = null;
	}
	
	public void fromConfigString(String str){
		if(str == null)
			return;
		Scanner scanner = new Scanner( str ).useDelimiter( "\\s*;;\\s*" ); 
		if(!scanner.hasNextBoolean())
			return;
		active = scanner.nextBoolean();
		if(!scanner.hasNext())
			return;
		featureFile = scanner.next();
		
		
	}
	
	public String toConfigString() {
		String str = active.toString()+";;";
		if(featureFile != null)
			str += featureFile;
		return str;
	}
	
	public String getFeatureFile() {
		return featureFile;
		
	}
	
	public void setFeatureFile(String featureFile) {
		this.featureFile = featureFile;
	}
	
	public Boolean isActive() {
		return active;
	}
	
	public void setActive(Boolean active) {
		this.active = active;
	}

	public CompletionType getType() {
		return type;
	}
	
}

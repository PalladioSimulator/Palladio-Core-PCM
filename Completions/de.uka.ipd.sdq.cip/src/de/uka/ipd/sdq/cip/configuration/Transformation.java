package de.uka.ipd.sdq.cip.configuration;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.cip.ConstantsContainer;
import de.uka.ipd.sdq.cip.completions.RegisteredCompletion;
import de.uka.ipd.sdq.cip.completions.RegisteredCompletions;

/**
 * Transformation contains the configuration
 * for a single Completion. 
 * 
 * @author Thomas Schuischel
 * 
 */
public class Transformation {
	
	public enum TransformationQVTType {
		NONE,
		QVTR,
		QVTO;
		
		public String toString(){
			if(this == QVTR)
				return "QVTR";
			else if(this == QVTO)
				return "QVTO";
			
			return "QVTR";
		}
		
		public static TransformationQVTType fromString(String value){
			if(value == null)
				return QVTR;
			
			if(value.equalsIgnoreCase  ("QVTR"))
				return QVTR;
			else if(value.equalsIgnoreCase  ("QVTO"))
				return QVTO;
			
			return QVTR;
		}
	}
	
	Map<String, String> keyValueMap = null; 
	
	public Transformation() {
		keyValueMap =  new HashMap<String, String>();
	}

	public String toDataString() {
		
		String data = "";
		
		// write key-value combinations back to string
		for ( String key : keyValueMap.keySet() )
		{
			data += key + "="+keyValueMap.get(key) + ";";
		}
		
		// remove last semikolon
		data = data.replaceFirst(";$","");
		
		return data;
	}
	
	public void readFromDataString(String data) {
		String[] dataStrings = data.split(";", -1);
		
		// read key-value combinations from string
		for(int i= 0; i< dataStrings.length; i++)
		{
			String[] keyValueData = dataStrings[i].split("=");
			keyValueMap.put(keyValueData[0], keyValueData[1]);
		}
	}
	
	public static Transformation fromDataString(String data) {
		Transformation transformation = new Transformation();
		transformation.readFromDataString(data);
		return transformation;
	}
	
	public Boolean isEnabled() {
		return Boolean.parseBoolean(keyValueMap.get("enabled"));
	}
	
	public void setEnabled(Boolean enabled) {
		keyValueMap.put("enabled", enabled.toString());
	}
	
	public TransformationType getType() {
		return TransformationType.fromString(keyValueMap.get("type"));
	}
	
	public void setType(TransformationType type) {
		keyValueMap.put("type", type.toString());
	}
	
	public TransformationQVTType getQVTType() {
		if(getType() == TransformationType.REGISTERED){
			RegisteredCompletion completion = getCompletion();
			
			if(completion == null)
				return TransformationQVTType.NONE;
			
			if(completion.containsCategory(ConstantsContainer.QVTO_Category))
				return TransformationQVTType.QVTO;
		}
		
		return TransformationQVTType.fromString(keyValueMap.get("qvtrType"));
	}
	
	public void setQVTType(TransformationQVTType qvtType) {
		keyValueMap.put("qvtrType", qvtType.toString());
	}
	
	public RegisteredCompletion getCompletion() {
		String ID = keyValueMap.get("id");
		
		if(ID == null)
			return null;
		
		return RegisteredCompletions.findCompletion(ID);
	}
	
	public void setCompletion(String ID) {
		keyValueMap.put("id",ID);
	}

	public void setFeatureFileURI(String featureFileURI) {
		keyValueMap.put("featureFileURI", featureFileURI);
	}
	
	public String getFeatureFileURI() {
		return keyValueMap.get("featureFileURI");
	}

	public void setConfigFileURI(String configFileURI) {
		keyValueMap.put("configFileURI", configFileURI);	
	}
	
	public String getConfigFileURI() {
		return keyValueMap.get("configFileURI");	
	}

	public void setMetamodelFileURI(String metamodelFileURI) {
		keyValueMap.put("metamodelFileURI", metamodelFileURI);		
	}
	
	public String getMetamodelFileURI() {
		if(getType() == TransformationType.REGISTERED){
			RegisteredCompletion completion = getCompletion();
			return completion.getMetamodel();
		}
		
		return keyValueMap.get("metamodelFileURI");	
	}

	public void setQVTFileURI(String qvtFileURI) {
		keyValueMap.put("qvtFileURI", qvtFileURI);	
	}
	
	public String getQVTFileURI() {
		if(getType() == TransformationType.REGISTERED){
			RegisteredCompletion completion = getCompletion();
			return completion.getQvtscript();
		}
		
		return keyValueMap.get("qvtFileURI");	
	}

	/**
	 * Set an optional additional model to be used in the transformation.
	 * 
	 * @param optionalModelFileURI The URI to the model.
	 */
	public void setOptionalModelFileURI(String optionalModelFileURI) {
		keyValueMap.put("optionalModelFileURI", optionalModelFileURI);	
	}
	
	/**
	 * Get an optional additional model to be used in the transformation.
	 * 
	 * @return The URI to the model.
	 */
	public String getOptionalModelFileURI() {
		return keyValueMap.get("optionalModelFileURI");	
	}
}

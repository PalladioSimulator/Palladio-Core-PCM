package de.fzi.stanja.core.model;

public class Output extends AbstractOutput{

	public Output(String analyzerId, String policyId, String queryId,
			String packageName, String className, String elementName,
			String filepathName, String startLine, String startChar) {
		super(analyzerId, policyId, queryId, packageName, className, elementName,
				filepathName, startLine, startChar);
		// TODO Auto-generated constructor stub
	}
	
	
	public String toString(){
		return this.packageName+"."+this.className+"."+this.elementName+">>>"+this.filepathName+"/"+this.startLine+"/"+this.startChar;

	}
	

}

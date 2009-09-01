package de.fzi.stanja.core.model;

/*
 * TODO 
 * 
 * */


/**
 * this class implements the output of stanja. 
 * the output has an link to the analyzer, policy and query that create him and 
 * the from the query SELECT rows (which are static at the moment). 
 * 
 * @author Christina Pildner
 *
 */
public abstract class AbstractOutput {
	protected String analyzerId;
	protected String policyId;
	protected String queryId;
	
	/* these elements are extracted from the database and 
	 * shown in the view or 
	 * used to find the place in code   */
	protected String packageName;
	protected String className;
	protected String elementName;
	protected String filepathName;
	protected String startLine;
	protected String startChar;
	
	private AbstractOutput(){};
	
	public AbstractOutput(	String analyzerId, String policyId, String queryId,
							String packageName, String className, String elementName, 
							String filepathName, String startLine, String startChar){
		this.analyzerId = analyzerId;
		this.policyId = policyId;
		this.queryId = queryId;
		this.packageName = packageName;
		this.className = className;
		this.elementName = elementName; 
		this.filepathName = filepathName; 
		this.startLine = startLine;
		this.startChar = startChar;
		
		
	}
	
	/**
	 * add the Output element to the Outpur provider
	 */
	public void addToOuputProvider(){
		boolean selber = (boolean) OutputProvider.getInstance().getOutputs().add(this);
		
		//TODO delete on cleaning  
		String info = "";
		if (selber){ info = "ok";}
		else { info = "ko";} 
		System.out.println(info + this.toString());
		
	}
		
	
}

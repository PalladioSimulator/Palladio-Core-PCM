package de.uka.ipd.sdq.ByCounter.execution;

import java.util.List;

/**
 * A small class to describe results of a counting step.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CountingArtefactInformation 
implements Comparable<CountingArtefactInformation>{
	
	/**
	 * Static instance of the corresponding <code>CountingResultCollector</code>
	 */
	private static CountingResultCollector myCollector;
	
	/**
	 * A simple getter 
	 * @return the underlying static instance of <code>CountingResultCollector</code>
	 */
	public static CountingResultCollector getMyCollector() {
		return myCollector;
	}
	
	/**
	 * Input parameters used for counting
	 */
	private List<RuntimeMethodParameters> inputPrms;
	
	/**
	 * TODO {@link CountingArtefactInformation} always corresponds to an instrumented class/method, or not?
	 */
	private boolean isInstrumented;
	
    /**
     * Flag to describe whether log was written directly to disk ("true") 
     * or saved by {@link CountingResultCollector} ("false") 
     */
    private boolean logWrittenToDisk;
    
    /**
     * TODO instrumented method? invoked (executed) method?
     */
    private String methodName;
    
    /**
     * TODO what if several methods executed? 
     * or, then, one artefact information per executed method? 
     */
    private List<RuntimeMethodParameters> outputPrms;
    
    /**
     * The timestamp (from System.currentTimeMillis()) when the method 
     * invocation started.
     */
    private Long time_InvocationReceived;
    
    /**
     * The timestamp (from System.currentTimeMillis()) when the results 
     * were received by {@link CountingResultCollector}
     */
    private Long time_resultsReceivedByCollector;
    
    /**
     * The default constructor (inside, it gets an instance of the {@link CountingResultCollector})
     */
    public CountingArtefactInformation(){
		myCollector = CountingResultCollector.getInstance();
	}
    
    /** Parametrised constructor
     * @param methodName reporting method (thus, it is an instrumented one)
     * @param invocationReceivedTime the timestamp when the 
     * instrumented method detected that it is being invoked 
     * @param inputPrms input parameters of the instrumented method
     * @param resultsReceivedByCollectorTime the timestamp 
     * when {@link CountingResultCollector}
     * received the information
     * @param outputPrms ouput parameters of the method
     */
    public CountingArtefactInformation(
			String methodName,
			Long invocationReceivedTime,
			List<RuntimeMethodParameters> inputPrms,
			Long resultsReceivedByCollectorTime,
			List<RuntimeMethodParameters> outputPrms){
		this(); //there, Collector instance is obtained
//		this.exitingTime = null;//field removed
		this.inputPrms = inputPrms;
		//TODO isInstrumented is missing
		//TODO logWrittenToDisk is missing
		this.methodName = methodName;
		this.outputPrms = outputPrms;
		this.time_InvocationReceived = invocationReceivedTime;
		this.time_resultsReceivedByCollector = resultsReceivedByCollectorTime;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(CountingArtefactInformation cai) {
		if(this.getTime_InvocationReceived()<cai.getTime_InvocationReceived()){
			return -1;
		}else if(this.getTime_InvocationReceived()>cai.getTime_InvocationReceived()){
			return +1;
		}else{//same invocation time
			if(this.getTime_resultsReceivedByCollector()<cai.getTime_resultsReceivedByCollector()){
				return -1;
			}else if(this.getTime_resultsReceivedByCollector()>cai.getTime_resultsReceivedByCollector()){
				return +1;
			}else{
				return this.getMethodName().compareTo(cai.getMethodName());
			}
		}
	}

//	public Long getExitingTime() {
//		return exitingTime;
//	}

	/** Delegating getter for counting results that correspond to this artefact
	 * @return counting results that correspond to this artefact
	 */
	public CountingResult getCountingResult(){
		return myCollector.getCountsByArtefact(this);
	}

	/**Simple getter
	 * @return inputPrms
	 */
	public List<RuntimeMethodParameters> getInputPrms() {
		return inputPrms;
	}

	/**Simple getter
	 * @return time_InvocationReceived
	 */
	public Long getInvocationReceivedTime() {
		return time_InvocationReceived;
	}

	/**Simple getter
	 * @return methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**Simple getter
	 * @return outputPrms
	 */
	public List<RuntimeMethodParameters> getOutputPrms() {
		return outputPrms;
	}

	/**Simple getter
	 * @return time_resultsReceivedByCollector
	 */
	public Long getResultsReceivedByCollectorTime() {
		return time_resultsReceivedByCollector;
	}
	
	/**Simple getter
	 * @return time_InvocationReceived
	 */
	public Long getTime_InvocationReceived() {
		return time_InvocationReceived;
	}

	/**Simple getter
	 * @return time_resultsReceivedByCollector
	 */
	public Long getTime_resultsReceivedByCollector() {
		return time_resultsReceivedByCollector;
	}

	/**Simple getter
	 * @return isInstrumented
	 */
	public boolean isInstrumented() {
		return isInstrumented;
	}

	/**Simple getter
	 * @return logWrittenToDisk
	 */
	public boolean isLogWrittenToDisk() {
		return logWrittenToDisk;
	}

	/** Simple setter
	 * @param inputPrms to be set
	 */
	public void setInputPrms(List<RuntimeMethodParameters> inputPrms) {
		this.inputPrms = inputPrms;
	}

	/** Simple setter
	 * @param isInstrumented to be set
	 */
	public void setInstrumented(boolean isInstrumented) {
		this.isInstrumented = isInstrumented;
	}

	/** Simple setter
	 * @param logWrittenToDisk to be set
	 */
	public void setLogWrittenToDisk(boolean logWrittenToDisk) {
		this.logWrittenToDisk = logWrittenToDisk;
	}

	/** Simple setter
	 * @param methodName to be set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/** Simple setter
	 * @param outputPrms to be set
	 */
	public void setOutputPrms(List<RuntimeMethodParameters> outputPrms) {
		this.outputPrms = outputPrms;
	}

	/** Simple setter
	 * @param time_InvocationReceived to be set
	 */
	public void setTime_InvocationReceived(Long time_InvocationReceived) {
		this.time_InvocationReceived = time_InvocationReceived;
	}

	/** Simple setter
	 * @param time_resultsReceivedByCollector to be set
	 */
	public void setTime_resultsReceivedByCollector(
			Long time_resultsReceivedByCollector) {
		this.time_resultsReceivedByCollector = time_resultsReceivedByCollector;
	}

	/** Returns a String representation of this class
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		StringBuffer sb = new StringBuffer();
		@SuppressWarnings("unused")
		String inputPrmsSize = "none";
		if(inputPrms!=null){
			inputPrmsSize = ""+inputPrms.size();
		}
		@SuppressWarnings("unused")
		String outputPrmsSize = "none";
		if(outputPrms!=null){
			outputPrmsSize = ""+outputPrms.size();
		}
		sb.append("\n"+
				  "      "+this.getClass().getSimpleName()+" (hash code: "+this.hashCode()+")\n");
		sb.append("      > methodName: "+methodName+"\n");
		sb.append("      > invocationReceivedTime: "+time_InvocationReceived+"\n");
		sb.append("      > resultsReceivedByCollectorTime: "+time_resultsReceivedByCollector+"\n");
//		sb.append("      > input prms ("+inputPrmsSize+"): "+inputPrms+"\n");
//		sb.append("      > output prms ("+outputPrmsSize+"): "+outputPrms+"\n");
//		sb.append("      > isInstrumented: "+isInstrumented+"\n"); //TODO pre-init wrongful
//		sb.append("      > logWrittenToDisk: "+logWrittenToDisk+"\n"); //TODO pre-init wrongful
	    return sb.toString();
	}

}

package de.uka.ipd.sdq.ByCounter.execution;

/**
 * A small class to describe caller information.
 * TODO why isn't it used anywhere?
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
class CallerInformation {
    /**
     * TODO
     */
    Long callerStart;
    
    /**
     * TODO
     */
    Long callerStop;
    
    /**
     * TODO
     */
    String fullMethodName;
    
    public String toString(){
    	return "CallerInformation [Method "+fullMethodName+", " +
    			"start: "+callerStart+", stop: "+callerStop+"]";
    }
}

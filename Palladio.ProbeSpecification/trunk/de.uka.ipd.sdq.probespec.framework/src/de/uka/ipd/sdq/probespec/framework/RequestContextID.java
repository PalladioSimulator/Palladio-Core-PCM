package de.uka.ipd.sdq.probespec.framework;

/**
 * This class represents the context ID of a request. This ID is unique with a
 * ProbeSetID for a ProbeSetSample.
 * 
 * TODO The implementation can later be extended to realize a stack for request
 * IDs to handle forks.
 * <p>
 * Later it will also be useful to implement a method which allows something
 * like a maximum pattern match for the stack. This would be necessary to find
 * the start ProbeSetSample (taken before the fork) for a given end
 * ProbeSetSample (appears in a forked thread).
 * 
 * @author Faber
 * 
 */
public class RequestContextID {

	private String requestID;

	/**
	 * This Constructor creates a ContextID.
	 * 
	 * @param requestID
	 *            The RequestID which is set initially.
	 */
	public RequestContextID(String requestID) {
		this.requestID = requestID;
	}

	/**
	 * Returns the reqeuestID.
	 * 
	 * @return Returns the requestID for this ContextID
	 */
	public String getRequestID() {
		return requestID;
	}

	/**
	 * Checks if two ContextIDs are equal by String-comparing the request ID.
	 * 
	 * @param obj
	 *            Is another instance of the ContextID which should be compared.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof RequestContextID) {
			RequestContextID otherCtxID = (RequestContextID) obj;
			return requestID.equals(otherCtxID.getRequestID());
		}
		return false;
	}

	/**
	 * Returns the hash code for this ContextID. 
	 * 
	 * @return hash code for this ContextID.
	 */
	@Override
	public int hashCode() {
		return requestID.hashCode();
	}

	/**
	 * Returns the String code for this ContextID. 
	 * 
     * @return String which characterizes this instance.
	 */
	@Override
	public String toString() {
		return requestID;
	}

}

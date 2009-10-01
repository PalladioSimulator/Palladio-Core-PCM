package de.uka.ipd.sdq.probespec.framework;

/**
 * 
 * @author Faber
 * 
 */
public class ProbeSetSampleID {

	private String probeSetID;
	private RequestContextID ctxID;

	public ProbeSetSampleID(String probeSetID, RequestContextID ctxID) {
		super();
		this.probeSetID = probeSetID;
		this.ctxID = ctxID;
	}

	/**
	 * Returns the id of the probe set according to the underlying model.
	 * 
	 * @return The ID of probe set model entity
	 */
	public String getProbeSetID() {
		return probeSetID;
	}

	/**
	 * Returns the identifier for the context in which the contained probe
	 * samples have been taken.
	 * 
	 * @return the context identifier
	 * @see RequestContextID
	 */
	public RequestContextID getCtxID() {
		return ctxID;
	}

	/**
	 * Checks if the this ProbeSetSampleID is equal to the ProbeSetSampleID
	 * passed as argument
	 * 
	 * @param obj
	 *            The instance with which this instance should be compared with
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj instanceof ProbeSetSampleID) {
			ProbeSetSampleID other = (ProbeSetSampleID) obj;
			return (ctxID.equals(other.getCtxID()) && probeSetID.equals(other
					.getProbeSetID()));
		}
		return false;
	}

	/**
	 * Generates a hash code for this ProbeSetSampleID. It is used to hash the
	 * ProbeSetSample in the HashMap of the SampleBlackboard.
	 * 
	 * @return hash code for this instance.
	 */
	@Override
	public int hashCode() {
		String temp = probeSetID + "-" + ctxID.toString();
		return temp.hashCode();
	}

	/**
	 * Generates a String of this ProbeSetSampleID.
	 * 
	 * @return String which characterizes this instance.
	 */
	@Override
	public String toString() {
		return probeSetID + "-" + ctxID.toString();
	}

}

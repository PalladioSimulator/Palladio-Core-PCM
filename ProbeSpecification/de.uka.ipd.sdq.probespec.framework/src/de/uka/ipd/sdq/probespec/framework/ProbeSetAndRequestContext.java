package de.uka.ipd.sdq.probespec.framework;

/**
 * Represents a (ProbeSet, {@link RequestContext})-pair. The ProbeSet is
 * identified by its ID.
 * <p>
 * It is used to uniquely identify {@link ProbeSetSample}.
 * 
 * @author Faber
 * @author Philipp Merkle
 * 
 */
public class ProbeSetAndRequestContext {

	// the ID representing the ProbeSet
	private Integer probeSetId;

	private RequestContext requestContext;

	/**
	 * Default constructor. Constructs a pair consisting of a ProbeSet and a
	 * {@link RequestContext}.
	 * 
	 * @param probeSetId
	 *            the ID representing the ProbeSet
	 * @param requestContext
	 *            the RequestContext
	 */
	public ProbeSetAndRequestContext(Integer probeSetId,
			RequestContext requestContext) {
		this.probeSetId = probeSetId;
		this.requestContext = requestContext;
	}

	/**
	 * Returns the ID of the ProbeSet component.
	 * 
	 * @return The ID representing the ProbeSet
	 */
	public Integer getProbeSetID() {
		return probeSetId;
	}

	/**
	 * Returns the {@link RequestContext} component.
	 * 
	 * @return the context
	 */
	public RequestContext getCtxID() {
		return requestContext;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((requestContext == null) ? 0 : requestContext.hashCode());
		result = prime * result
				+ ((probeSetId == null) ? 0 : probeSetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof ProbeSetAndRequestContext)) {
			return false;
		}
		ProbeSetAndRequestContext other = (ProbeSetAndRequestContext) obj;
		if (requestContext == null) {
			if (other.requestContext != null) {
				return false;
			}
		} else if (!requestContext.equals(other.requestContext)) {
			return false;
		}
		if (probeSetId == null) {
			if (other.probeSetId != null) {
				return false;
			}
		} else if (!probeSetId.equals(other.probeSetId)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return probeSetId + "-" + requestContext.toString();
	}

}

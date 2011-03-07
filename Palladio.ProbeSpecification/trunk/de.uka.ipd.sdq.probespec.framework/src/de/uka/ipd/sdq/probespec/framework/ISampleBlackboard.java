package de.uka.ipd.sdq.probespec.framework;

public interface ISampleBlackboard {

	/**
	 * Publishes a sample on the blackboard. Interested observers gets notified
	 * of the published sample.
	 * 
	 * @param pss
	 *            the sample
	 */
	public void addSample(ProbeSetSample pss);

	/**
	 * Deletes the sample specified by the {@link ProbeSetAndRequestContext}.
	 * 
	 * @param pss
	 *            the sample
	 */
	public void deleteSample(ProbeSetAndRequestContext pss);

	/**
	 * Deletes all samples contained in the specified requestContext.
	 * 
	 * @param requestContext
	 *            the request context whose samples will be deleted.
	 */
	public void deleteSamplesInRequestContext(RequestContext requestContext);

	/**
	 * Returns the ProbeSetSample for the specified pair of ProbeSetId and
	 * {@link RequestContext}, if there is any. The ProbeSetId and
	 * RequestContext are encapsulated by a {@link ProbeSetAndRequestContext}.
	 */
	public ProbeSetSample getSample(ProbeSetAndRequestContext probeSetSampleID);

	/**
	 * Returns the number of {@link ProbeSetSample}s contained in this
	 * blackboard
	 */
	public int size();

	/**
	 * Registers a listener for blackboard events.
	 * 
	 * @param l
	 *            the listener
	 */
	public void addBlackboardListener(IBlackboardListener l, Integer... topics);

}

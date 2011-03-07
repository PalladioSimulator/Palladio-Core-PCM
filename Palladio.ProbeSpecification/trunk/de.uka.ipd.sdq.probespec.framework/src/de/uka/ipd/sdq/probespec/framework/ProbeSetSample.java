package de.uka.ipd.sdq.probespec.framework;

import java.util.Collection;
import java.util.Vector;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.probespec.framework.matching.IMatchRule;

/**
 * Represents a sample which is taken for a ProbeSet in a {@link RequestContext}
 * .
 * <p>
 * The probe set sample is the result of a probe set measurement. It contains
 * one or more probe samples; one for each probe assigned to the underlying
 * probe set. In other words: The contained probe samples constitute the
 * combined sample for the annotated model element which is named probe set
 * sample.
 * <p>
 * A probe set (notice: not the resulting sample) encapsulates one or more
 * probes whose results are taken for the identical model element which is
 * annotated by the probe set.
 * 
 * @author pmerkle
 * @author Faber
 */
public class ProbeSetSample {

	private Collection<ProbeSample<?, ? extends Quantity>> probeSamples;

	private ProbeSetAndRequestContext probeSetAndRequestContext;

	/** The id of the annotated model element */
	private String modelElementID;

	/**
	 * Class constructor specifying the encapsulated probe samples, the context
	 * id, the model element id and the probe set id.
	 * 
	 * @param probeSamples
	 *            the probe samples to be encapsulated within this probe set
	 *            sample
	 * @param ctxID
	 *            the identifier for the context in which the contained probe
	 *            samples have been taken
	 * @param modelElementID
	 *            the id of the model element which is annotated by the
	 *            underlying probe set
	 * @param probeSetID
	 *            the id of the probe set according to the underlying model
	 * @see RequestContext
	 */
	public ProbeSetSample(
			Vector<ProbeSample<?, ? extends Quantity>> probeSamples,
			RequestContext ctxID, String modelElementID, Integer probeSetID) {
		super();

		this.probeSamples = probeSamples;
		this.probeSetAndRequestContext = new ProbeSetAndRequestContext(
				probeSetID, ctxID);

		// TODO modelElementId really needed?
		this.modelElementID = modelElementID;
	}

	/**
	 * Returns the encapsulated probe samples satisfying the specified rule set.
	 * 
	 * @param matchingRules
	 *            the rule set
	 * @return
	 * @see ProbeSample
	 */
	public Vector<ProbeSample<?, ? extends Quantity>> getProbeSamples(
			IMatchRule[] matchingRules) {
		Vector<ProbeSample<?, ? extends Quantity>> res = new Vector<ProbeSample<?, ? extends Quantity>>();

		for (ProbeSample<?, ? extends Quantity> sample : probeSamples) {
			boolean match = true;
			for (IMatchRule rule : matchingRules) {
				match = match && rule.match(sample);
			}
			if (match)
				res.add(sample);
		}

		return res;
	}

	/**
	 * Returns the id of the model element which is annotated by the underlying
	 * probe set.
	 * 
	 * @return the model element id
	 */
	public String getModelElementID() {
		return modelElementID;
	}

	/**
	 * This method returns the (ProbeSet, RequestContext)-pair for this sample.
	 * It indicates
	 * <ul>
	 * <li>from which ProbeSet the sample originates</li>
	 * <li>the {@link RequestContext} in which the sample has been taken</li>
	 * </ul>
	 * 
	 * @return the originating ProbeSet and {@link RequestContext}
	 */
	public ProbeSetAndRequestContext getProbeSetAndRequestContext() {
		return probeSetAndRequestContext;
	}

}

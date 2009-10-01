package de.uka.ipd.sdq.probespec.framework;

import java.util.Collection;
import java.util.Vector;

import javax.measure.quantity.Quantity;

/**
 * Represents a sample which is taken for a probe set.
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

	private ProbeSetSampleID probeSetSampleID;

	private int timeToLive = 1;

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
	 * @see RequestContextID
	 */
	public ProbeSetSample(
			Vector<ProbeSample<?, ? extends Quantity>> probeSamples,
			RequestContextID ctxID, String modelElementID, String probeSetID) {
		super();

		this.probeSamples = probeSamples;
		this.probeSetSampleID = new ProbeSetSampleID(probeSetID, ctxID);
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
	 * This method returns the ProbeSetSampleID for this ProbeSetSample. The
	 * ProbeSetSampleID contains the ContextID and the ID of the ProbeSet. For
	 * more detailed information see the documentation for ProbeSetSampleID.
	 * 
	 * @return ProbeSetSampleID for this ProbeSetSample
	 */
	public ProbeSetSampleID getProbeSetSampleID() {
		return probeSetSampleID;
	}

	/**
	 * This method returns the TimeToLive value. The value represents how often
	 * this ProbeSetSample is read from the SampleBlackboard. The first read is
	 * directly when this ProbeSetSample is added to the SampleBlackboard
	 * because of the Observer pattern. This method is used by the
	 * SampleBlackboard to determine when the ProbeSetSample can be deleted from
	 * the HashMap.
	 * 
	 * @return Number of reads until deletion
	 * @see SampleBlackboard
	 */
	public int getTimeToLive() {
		return timeToLive;
	}

	/**
	 * This method should be used to increase the TimeToLive. Let n be the
	 * number of binary Calculators where this ProbeSetSample is the start
	 * ProbeSetSample. Then this method should be used with n as the parameter.
	 * (For unary Calculator and end Probes nothing needs to be done here
	 * because in this case the Calculator receives this ProbeSetSample with the
	 * update method of the Observer pattern).
	 * <p>
	 * TODO For the Fork/Join topic the TTL value must also be modified
	 * appropriately.
	 * 
	 * @param Number
	 *            of Calculators for which this ProbeSetSample is used as the
	 *            start ProbeSetSample.
	 * @see SampleBlackboard
	 */
	public void addToTimeToLive(int toAdd) {
		this.timeToLive += toAdd;
	}

	/**
	 * This method is called by the SampleBlackboard when it is added to the
	 * SampleBlackboard and then each time a Calculator wants to get
	 * ProbeSetSample from the SampleBlackboard.
	 * 
	 * @see SampleBlackboard
	 */
	public void decrementTimeToLive() {
		this.timeToLive--;
	}

}

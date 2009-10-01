package de.uka.ipd.sdq.probespec.framework;

import java.util.HashMap;
import java.util.Observable;

/**
 * This class realizes the blackboard pattern to store all ProbeSetSamples and
 * allows the Calculators to access this data. This makes it to a central class
 * in the ProbeSpec framework. An observer pattern is used to notify the
 * Calculator about the arrival of a new ProbeSetSample.
 * <p>
 * Internally the storage is structured as HashMaps which maps the
 * ProbeSetSampleID to the ProbeSetSample (ProbeSetSampleID -> ProbeSetSample).
 * <p>
 * This SampleBlackboard also realizes a simple implementation of a garbage
 * collection to delete ProbeSetSamples which are not needed any more. For now
 * this is done by a counter for each ProbeSetSample which can be seen as a
 * "time to life" field (To set the field correctly see the ProbeSetSample
 * documentation). Every time a ProbeSetSample is read, the counter is
 * decremented and finally the ProbeSetSample is deleted, if the counter is
 * equal or less than zero. Note that the first time the TTL field is
 * decremented is, when the ProbeSetSample is added to the blackboard. This is
 * because the Calculators then receive the ProbeSetSample for the first time
 * (Observer pattern).
 * 
 * @author Faber
 * 
 */
public class SampleBlackboard extends Observable {
	// ProbeSetSampleID -> ProbeSetSample)
	private HashMap<ProbeSetSampleID, ProbeSetSample> pssMaps = new HashMap<ProbeSetSampleID, ProbeSetSample>();

	/**
	 * This method allows to add a ProbeSetSample to the SampleBlackboard. It is
	 * only added to the HashMap, if the TTL field is still greater than zero.
	 * See class description for detailed information about the storage
	 * structure and its garbage collection.
	 * 
	 * @param pss
	 *            ProbeSetSample which is added to the SampleBlackboard and then
	 *            distributed to all Calculators (observer pattern).
	 */
	public void addProbeSetSample(ProbeSetSample pss) {
		// only add this ProbeSetSample if the TTL field is greater than 0
		if (!reduceLifetime(pss))
			pssMaps.put(pss.getProbeSetSampleID(), pss);

		// Notify listeners
		setChanged();
		notifyObservers(pss);
	}

	/**
	 * This method extracts a ProbeSetSample from the internal structure and
	 * returns this to the caller. After the extraction the tryCleanUp method is
	 * called to eventually remove the ProbeSetSample from the HashMap.
	 * 
	 * @param probeSetSampleID
	 *            ID which identifies the ProbeSetSample
	 * @return Extracted ProbeSetSample
	 */
	public ProbeSetSample getProbeSetSample(ProbeSetSampleID probeSetSampleID) {
		// TODO For stacks of IDs (after a fork) first extract the ID of the
		// StartProbeSet (by reducing the Stack)
		ProbeSetSample pss = pssMaps.get(probeSetSampleID);
		tryCleanUp(pss);
		return pss;
	}

	/**
	 * This method calls the notAlive and then removes the ProbeSetSample from
	 * the HashMap, if notAlive returns true.
	 * 
	 * @param pss
	 *            The ProbeSetSample which eventually will be removed.
	 */
	private void tryCleanUp(ProbeSetSample pss) {
		if (reduceLifetime(pss)) {
			pssMaps.remove(pss.getProbeSetSampleID());
		}
	}

	/**
	 * This method decrements the TTL field for the ProbeSetSample and then
	 * returns true, if it is equal or less than zero.
	 * 
	 * @param pss
	 *            ProbeSetSample whose TTL counter is decremented
	 * @return true if the ProbeSetSample is not alive; else false
	 * 
	 */
	private boolean reduceLifetime(ProbeSetSample pss) {
		if (pss != null) {
			pss.decrementTimeToLive();
			return (pss.getTimeToLive() <= 0);
		}
		return false;
	}

	/**
	 * Returns the size of the HashMap which stores all ProbeSetSamples. This is
	 * mainly used by TestCases for the garbage collection. Later it could also
	 * be used to supervise the state/utilization of the blackboard.
	 * 
	 * @return Integer which represents the number of ProbeSetSamples which are
	 *         stored in the HashMap
	 */
	public int getHashMapSize() {
		return pssMaps.size();
	}

}

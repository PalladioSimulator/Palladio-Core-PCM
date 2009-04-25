package de.uka.ipd.sdq.dsexplore.helper;

import de.uka.ipd.sdq.identifier.Identifier;

public class EMFHelper {
	
	/**
	 * Checks for two PCM model elements whether they are the same, i.e. whether
	 * they have the same ID. The model elements have to be derived from
	 * Identifier. Note that two systems might use the same assembly contexts
	 * and components, but still are two different systems. If one of the 
	 * Identifiers in null, false is returned. 
	 * 
	 * @param i1
	 *            One Identifier
	 * @param i2
	 *            Another Identifier
	 * @return true if i1.getId().equals(i2.getId()), false otherwise
	 */
	public static boolean checkIdentity(Identifier i1, Identifier i2) {
		if (i1 == null || i2 == null)
			return false;
		if (i1.getId().equals(i2.getId())) {
			// logger.debug("Two model elements match with Id: "+i1.getId());
			return true;
		} else {
			return false;
		}
	}
}

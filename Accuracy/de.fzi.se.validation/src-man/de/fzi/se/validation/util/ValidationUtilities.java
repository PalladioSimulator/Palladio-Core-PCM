/**
 * 
 */
package de.fzi.se.validation.util;

import java.util.zip.CRC32;
import java.util.zip.Checksum;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**Contains general utilities used for the validation of performance specifications.
 * 
 * @author groenda
 */
public class ValidationUtilities {
	/**Calculates a checksum for a RD-SEFF.
	 * Used to check structure and performance-relevant behavior equality.
	 * @param rdseff RD-SEFF to check.
	 * @return checksum for the RD-SEFF.
	 */
	public static long checksum(ResourceDemandingSEFF rdseff) {
		// TODO check method with test cases
		Checksum checksum = new CRC32();
		checksum.reset();

		// Interface (ID) must stay the same
		updateChecksum(checksum, EcoreUtil.getID(rdseff.getDescribedService__SEFF()));
		// structure and parameters of actions must stay the same
		ActionChecksumSwitch checksumSwitch = new ActionChecksumSwitch(checksum);
		for (AbstractAction action : rdseff.getSteps_Behaviour()) {
			// start with StartAction
			if (action.getPredecessor_AbstractAction() == null) {
				updateChecksum(checksum, checksumSwitch.doSwitch(action).toString());
			}
		}
		// TODO implement correctly
		return checksum.getValue();
	}
	
	/**Updates checksum with the given string.
	 * @param checksum Checksum generator and storage.
	 * @param string String used to update the checksum.
	 */
	public static void updateChecksum(Checksum checksum, String string) {
		byte[] byteArray = string.getBytes();
		checksum.update(byteArray, 0, byteArray.length);
	}

}

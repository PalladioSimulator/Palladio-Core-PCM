/**
 *
 */
package de.fzi.se.accuracy.issues;

import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**Issue arised in an {@link ResourceDemandingSEFF} which is experienced on source code level and contains the relevant UUIDs.
 * @author groenda
 *
 */
public class RDSEFFSourceCodeIssue extends SeverityAndIssue {

	/** UUID of the {@link ResourceDemandingSEFF}. */
	private String rdseffId;

	public RDSEFFSourceCodeIssue(SeverityEnum error, String message,
			Object element, String objectResourceName, String rdseffId) {
		super(error, message, element, objectResourceName);
		this.rdseffId = rdseffId;
	}

	@Override
	public String getDetails() {
		String details = super.getDetails();
		if (rdseffId != null) {
			details += "UUID of RD-SEFF: " + rdseffId + "\n\n";
		}
		return details;
	}

}

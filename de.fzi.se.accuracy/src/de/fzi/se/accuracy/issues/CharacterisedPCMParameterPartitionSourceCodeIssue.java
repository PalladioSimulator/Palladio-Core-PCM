/**
 *
 */
package de.fzi.se.accuracy.issues;

import de.fzi.se.quality.qualityannotation.CharacterisedPCMParameterPartition;
import de.uka.ipd.sdq.errorhandling.SeverityAndIssue;
import de.uka.ipd.sdq.errorhandling.SeverityEnum;

/**Issue caused by an {@link CharacterisedPCMParameterPartition} which is experienced on source code level and contains the relevant UUIDs.
 * @author groenda
 *
 */
public class CharacterisedPCMParameterPartitionSourceCodeIssue extends SeverityAndIssue {

	/** UUID of the partition*/
	private String partitionId;

	public CharacterisedPCMParameterPartitionSourceCodeIssue(
			SeverityEnum error, String message, Object element,
			String objectResourceName, String partitionId) {
		super(error, message, element, objectResourceName);
		this.partitionId = partitionId;
	}

	@Override
	public String getDetails() {
		String details = super.getDetails();
		if (partitionId != null) {
			details += "UUID of partition: " + partitionId+ "\n\n";
		}
		return details;
	}

}

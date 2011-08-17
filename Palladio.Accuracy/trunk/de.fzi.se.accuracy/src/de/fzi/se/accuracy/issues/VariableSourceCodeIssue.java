/**
 *
 */
package de.fzi.se.accuracy.issues;

import de.uka.ipd.sdq.errorhandling.SeverityEnum;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;

/**Issue for {@link AbstractAction}s within an {@link ResourceDemandingSEFF}.
 * @author groenda
 *
 */
public class VariableSourceCodeIssue extends RDSEFFSourceCodeIssue {

	/** UUID of the {@link ResourceDemandingSEFF}. */
	private String variableReference;
	/** UUID of the {@link AbstractAction}. */
	private String actionId;

	public VariableSourceCodeIssue(SeverityEnum error, String message,
			Object actualValue, String objectResourceName, String rdseffId, String actionId, String variableReference) {
		super(error, message, actualValue, objectResourceName, rdseffId);
		this.actionId = actionId;
		this.variableReference = variableReference;
	}

	@Override
	public String getDetails() {
		String details = super.getDetails();
		if (actionId != null) {
			details += "UUID of action: " + actionId + "\n\n";
		}
		if (variableReference != null) {
			details += "Variable reference: " + variableReference + "\n\n";
		}
		return details;
	}

}

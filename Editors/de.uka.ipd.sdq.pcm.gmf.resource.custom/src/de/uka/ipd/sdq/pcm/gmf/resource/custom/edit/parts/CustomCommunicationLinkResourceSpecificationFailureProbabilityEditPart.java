package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.CommunicationLinkResourceSpecificationFailureProbabilityEditPart;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;

/**
 * A custom edit part for the failure probability of a communication link.
 * 
 * This class was introduced because the default edit part failed to display the value correctly
 * for values below or equal to 5*10^-4.
 * @author Dominik Werle
 *
 */
public class CustomCommunicationLinkResourceSpecificationFailureProbabilityEditPart
		extends
		CommunicationLinkResourceSpecificationFailureProbabilityEditPart {

	public CustomCommunicationLinkResourceSpecificationFailureProbabilityEditPart(
			View view) {
		super(view);
	}
	
	/**
	 * Returns the failure probability in the format returned by {@link Double#toString}. 
	 */
	@Override
	protected String getLabelText() {
		String text = null;
		CommunicationLinkResourceSpecification spec = (CommunicationLinkResourceSpecification) resolveSemanticElement();

		if (spec.getLatency_CommunicationLinkResourceSpecification() != null) {
			text = Double.toString(spec.getFailureProbability());
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	public String getEditText() {
		return getLabelText();
	}

}

/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InternalFailureOccurrenceDescriptionEditPart;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;


public class CustomInternalFailureOccurrenceDescriptionEditPart extends
InternalFailureOccurrenceDescriptionEditPart {


	private EContentAdapter changeListener = null;
	private EObject adaptedElement = null;


	public CustomInternalFailureOccurrenceDescriptionEditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = null;
		if (resolveSemanticElement() instanceof InternalFailureOccurrenceDescription) {
			InternalFailureOccurrenceDescription description = (InternalFailureOccurrenceDescription) resolveSemanticElement();
			if (description
					.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription() != null) {
				text = description
						.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
						.getEntityName();
			} else {
				text = "[UNSPECIFIED]";
			}
			text += " (" + description.getFailureProbability() + ")";
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		InternalFailureOccurrenceDescription element = (InternalFailureOccurrenceDescription) resolveSemanticElement();
		changeListener = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				refreshLabel();
			}

		};
		adaptedElement = element;
		element.eAdapters().add(changeListener);
	}

	@Override
	protected void removeSemanticListeners() {
		adaptedElement.eAdapters().remove(changeListener);
	}

}

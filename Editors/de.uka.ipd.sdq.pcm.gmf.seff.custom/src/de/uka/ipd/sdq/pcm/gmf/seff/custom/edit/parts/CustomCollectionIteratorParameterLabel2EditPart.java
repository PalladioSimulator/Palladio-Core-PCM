/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.CollectionIteratorParameterLabel2EditPart;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;

public class CustomCollectionIteratorParameterLabel2EditPart extends
CollectionIteratorParameterLabel2EditPart {

	public CustomCollectionIteratorParameterLabel2EditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = "Param: ";
		CollectionIteratorAction action = (CollectionIteratorAction) resolveSemanticElement();
		if (action.getParameter_CollectionIteratorAction() != null
				&& action.getParameter_CollectionIteratorAction()
						.getParameterName() != null)
			text += action.getParameter_CollectionIteratorAction()
					.getParameterName();
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		CollectionIteratorAction action = (CollectionIteratorAction) resolveSemanticElement();
		addListenerFilter("SemanticModel", this, action); //$NON-NLS-1$
	}

	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel"); //$NON-NLS-1$
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer) event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(
				feature)) {
			refreshUnderline();
		} else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough()
				.equals(feature)) {
			refreshStrikeThrough();
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(
				feature)
				|| NotationPackage.eINSTANCE.getFontStyle_FontName().equals(
						feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Bold()
						.equals(feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Italic().equals(
						feature)) {
			refreshFont();
		} else {
			refreshLabel();
		}
		super.handleNotificationEvent(event);
	}
}

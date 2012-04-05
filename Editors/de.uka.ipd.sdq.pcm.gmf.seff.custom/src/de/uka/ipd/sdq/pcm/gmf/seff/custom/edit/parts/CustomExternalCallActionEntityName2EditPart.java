/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ExternalCallActionEntityName2EditPart;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;


public class CustomExternalCallActionEntityName2EditPart extends ExternalCallActionEntityName2EditPart {


	public CustomExternalCallActionEntityName2EditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = null;
		if (resolveSemanticElement() instanceof ExternalCallAction) {
			ExternalCallAction eca = (ExternalCallAction) resolveSemanticElement();
			if (eca.getCalledService_ExternalService() != null
					&& eca.getRole_ExternalService() != null) {
				text = eca.getRole_ExternalService().getEntityName()
						+ "."
						+ eca.getCalledService_ExternalService()
								.getEntityName();
			}
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
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

/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallTargetLabelEditPart;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;


public class CustomInfrastructureCallTargetLabelEditPart extends InfrastructureCallTargetLabelEditPart {


	public CustomInfrastructureCallTargetLabelEditPart(View view) {
		super(view);
	}
	
	/**
	 * Displays required role and signature.
	 */
	@Override
	protected String getLabelText() {
		String text = null;
		EObject parserElement = getParserElement();
		if (parserElement instanceof InfrastructureCall) {
			InfrastructureCall eca = (InfrastructureCall) resolveSemanticElement();
			text = "";
			if (eca.getRequiredRole__InfrastructureCall() != null) {
				text += eca.getRequiredRole__InfrastructureCall()
						.getEntityName();
			} else {
				text += "?";
			}
			text += ".";
			if (eca.getSignature__InfrastructureCall() != null) {
				text += eca.getSignature__InfrastructureCall().getEntityName();
			} else {
				text += "?";
			}
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	/**
	 * Handles refresh of customized text.
	 */
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

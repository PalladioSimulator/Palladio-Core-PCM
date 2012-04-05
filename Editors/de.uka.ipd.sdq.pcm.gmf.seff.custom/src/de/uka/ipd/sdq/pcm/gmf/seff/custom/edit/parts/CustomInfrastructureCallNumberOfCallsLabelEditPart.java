/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.InfrastructureCallNumberOfCallsLabelEditPart;
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall;


public class CustomInfrastructureCallNumberOfCallsLabelEditPart extends
InfrastructureCallNumberOfCallsLabelEditPart {


	public CustomInfrastructureCallNumberOfCallsLabelEditPart(View view) {
		super(view);
	}

	/**
	 * Customized to display specification of number of calls.
	 */
	@Override
	protected String getLabelText() {
		String text = null;
		InfrastructureCall call = (InfrastructureCall) resolveSemanticElement();
		if (call != null) {
			text = "";
			if (call.getNumberOfCalls__InfrastructureCall() != null) {
				text += call.getNumberOfCalls__InfrastructureCall()
						.getSpecification();

			} else {
				text += "?";
			}
			text += " x";
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	/**
	 * Listens for changes on number of calls.
	 */
	@Override
	protected void addSemanticListeners() {
		InfrastructureCall call = (InfrastructureCall) resolveSemanticElement();
		addListenerFilter("SemanticModel", this, call
				.getNumberOfCalls__InfrastructureCall());
	}

	/**
	 * Remove customized filter.
	 */
	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel");
	}

	/**
	 * Do not use default but customized listener.
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

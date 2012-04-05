/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation5EditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.Expression;

public class CustomVariableCharacterisation5EditPart extends VariableCharacterisation5EditPart {

	public CustomVariableCharacterisation5EditPart(View view) {
		super(view);
	}

	@Override
	protected String getLabelText() {
		String text = null;
		VariableCharacterisation vc = (VariableCharacterisation) this
				.resolveSemanticElement();
		if (vc != null) {
			text = vc.getType().getLiteral() + " = ";
			if (vc.getSpecification_VariableCharacterisation() != null) {
				Expression expression = vc
						.getSpecification_VariableCharacterisation()
						.getExpression();
				if (expression != null)
					text += new PCMStoExPrettyPrintVisitor()
							.prettyPrint(expression);
			} else
				text = null;
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		VariableCharacterisation characterisation = (VariableCharacterisation) resolveSemanticElement();
		addListenerFilter("SemanticModel", this, characterisation
				.getSpecification_VariableCharacterisation());
		addListenerFilter("SemanticModel2", this, characterisation);
	}

	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel");
		removeListenerFilter("SemanticModel2");
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

/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.VariableCharacterisationEditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.stoex.Expression;


public class CustomVariableCharacterisationEditPart extends VariableCharacterisationEditPart {

	public CustomVariableCharacterisationEditPart(View view) {
		super(view);
	}

	private EContentAdapter changeListener = null;
	private EObject adaptedElement = null;

	@Override
	protected String getLabelText() {
		String text = null;
		EObject semanticElement = this.resolveSemanticElement();
		//Handle errors when element deleted
		if(semanticElement == null || !(semanticElement instanceof VariableCharacterisation))
				return "";
		
		VariableCharacterisation vc = (VariableCharacterisation) semanticElement;
		text = vc.getType().getLiteral() + " = ";
		Expression expression = vc.getSpecification_VariableCharacterisation()
				.getExpression();
		if (expression != null)
            text += new PCMStoExPrettyPrintVisitor().prettyPrint(expression);
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		EObject element = resolveSemanticElement();
		changeListener = new EContentAdapter() {

			@Override
			public void notifyChanged(final Notification notification) {
				super.notifyChanged(notification);
				CustomVariableCharacterisationEditPart.this
						.notifyChanged(notification);
			}

		};
		adaptedElement = element;
		element.eAdapters().add(changeListener);
		addListenerFilter("SemanticModel", this, element); //$NON-NLS-1$
	}

	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel"); //$NON-NLS-1$
		adaptedElement.eAdapters().remove(changeListener);
	}

	@Override
	protected void handleNotificationEvent(final Notification event) {
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

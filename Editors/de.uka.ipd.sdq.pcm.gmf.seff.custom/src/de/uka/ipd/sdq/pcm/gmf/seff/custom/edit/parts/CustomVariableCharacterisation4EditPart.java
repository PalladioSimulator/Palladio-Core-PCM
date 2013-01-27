/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.stoex.Expression;

/**
 * The customized variable characterisation4 edit part class.
 */
public class CustomVariableCharacterisation4EditPart extends VariableCharacterisation4EditPart {

    /**
     * Instantiates a new customized variable characterisation4 edit part.
     * 
     * @param view
     *            the view
     */
    public CustomVariableCharacterisation4EditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#getLabelText()
     */
    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final VariableCharacterisation vc = (VariableCharacterisation) this.resolveSemanticElement();
        if (vc != null) {
            text = vc.getType().getLiteral() + " = ";
            if (vc.getSpecification_VariableCharacterisation() != null) {
                final Expression expression = vc.getSpecification_VariableCharacterisation().getExpression();
                if (expression != null) {
                    text += new PCMStoExPrettyPrintVisitor().prettyPrint(expression);
                }
            } else {
                text = null;
            }
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#addSemanticListeners
     * ()
     */
    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        final VariableCharacterisation characterisation = (VariableCharacterisation) this.resolveSemanticElement();
        this.addListenerFilter("SemanticModel", this, characterisation.getSpecification_VariableCharacterisation());
        this.addListenerFilter("SemanticModel2", this, characterisation);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#removeSemanticListeners
     * ()
     */
    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        this.removeListenerFilter("SemanticModel");
        this.removeListenerFilter("SemanticModel2");
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#handleNotificationEvent
     * (org.eclipse.emf.common.notify.Notification)
     */
    /**
     * Handle notification event.
     * 
     * @param event
     *            the event
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.VariableCharacterisation4EditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotificationEvent(final Notification event) {
        final Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            final Integer c = (Integer) event.getNewValue();
            this.setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            this.refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            this.refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            this.refreshFont();
        } else {
            this.refreshLabel();
        }
        super.handleNotificationEvent(event);
    }
}

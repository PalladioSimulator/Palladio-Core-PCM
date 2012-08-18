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

/**
 * The customized infrastructure call target label edit part class.
 */
public class CustomInfrastructureCallTargetLabelEditPart extends InfrastructureCallTargetLabelEditPart {

    /**
     * Instantiates a new customized infrastructure call target label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomInfrastructureCallTargetLabelEditPart(final View view) {
        super(view);
    }

    /**
     * Displays required role and signature.
     * 
     * @return the label text
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final EObject parserElement = this.getParserElement();
        if (parserElement instanceof InfrastructureCall) {
            final InfrastructureCall eca = (InfrastructureCall) this.resolveSemanticElement();
            text = "";
            if (eca.getRequiredRole__InfrastructureCall() != null) {
                text += eca.getRequiredRole__InfrastructureCall().getEntityName();
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
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

    /**
     * Handles refresh of customized text.
     * 
     * @param event
     *            the notification event
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

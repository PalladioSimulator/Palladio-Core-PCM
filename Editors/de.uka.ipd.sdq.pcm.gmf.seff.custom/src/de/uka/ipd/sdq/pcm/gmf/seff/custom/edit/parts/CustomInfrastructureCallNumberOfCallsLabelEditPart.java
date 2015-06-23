/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.WrappingLabel2EditPart;
import org.palladiosimulator.pcm.seff.seff_performance.InfrastructureCall;

/**
 * The customized infrastructure call number of calls label edit part class.
 */
public class CustomInfrastructureCallNumberOfCallsLabelEditPart extends WrappingLabel2EditPart /*InfrastructureCallNumberOfCallsLabelEditPart*/ {

    /**
     * Instantiates a new customized infrastructure call number of calls label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomInfrastructureCallNumberOfCallsLabelEditPart(final View view) {
        super(view);
    }

    /**
     * Customized to display specification of number of calls.
     * 
     * @return the label text
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final InfrastructureCall call = (InfrastructureCall) this.resolveSemanticElement();
        if (call != null) {
            text = "";
            if (call.getNumberOfCalls__InfrastructureCall() != null) {
                text += call.getNumberOfCalls__InfrastructureCall().getSpecification();

            } else {
                text += "?";
            }
            text += " x";
        }
        if (text == null || text.length() == 0) {
            text = this.getLabelTextHelper(this.getFigure());
        }
        return text;
    }

    /**
     * Listens for changes on number of calls.
     */
    @Override
    protected void addSemanticListeners() {
        final InfrastructureCall call = (InfrastructureCall) this.resolveSemanticElement();
        this.addListenerFilter("SemanticModel", this, call.getNumberOfCalls__InfrastructureCall());
    }

    /**
     * Remove customized filter.
     */
    @Override
    protected void removeSemanticListeners() {
        this.removeListenerFilter("SemanticModel");
    }

    /**
     * Do not use default but customized listener.
     * 
     * @param event
     *            the event
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

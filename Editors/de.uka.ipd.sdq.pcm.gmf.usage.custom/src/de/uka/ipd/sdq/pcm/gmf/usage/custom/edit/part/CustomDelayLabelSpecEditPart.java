/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;

/**
 * The Class CustomDelayLabelSpecEditPart.
 */
public class CustomDelayLabelSpecEditPart extends DelayLabelSpecEditPart {

    /**
     * Instantiates a new custom delay label spec edit part.
     * 
     * @param view
     *            the view
     */
    public CustomDelayLabelSpecEditPart(View view) {
        super(view);
    }

    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;

        Delay d = (Delay) resolveSemanticElement();
        if (d.getTimeSpecification_Delay() != null) {
            text = "Delay Time: " + d.getTimeSpecification_Delay().getSpecification();
        }

        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(getFigure());
        }
        return text;

    }

    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        Delay d = (Delay) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, d.getTimeSpecification_Delay()); //$NON-NLS-1$
    }

    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
    }

    /**
     * Handle notification event.
     * 
     * @param event
     *            the event
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.DelayLabelSpecEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotificationEvent(final Notification event) {
        Object feature = event.getFeature();
        if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
            Integer c = (Integer) event.getNewValue();
            setFontColor(DiagramColorRegistry.getInstance().getColor(c));
        } else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(feature)) {
            refreshUnderline();
        } else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough().equals(feature)) {
            refreshStrikeThrough();
        } else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_FontName().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Bold().equals(feature)
                || NotationPackage.eINSTANCE.getFontStyle_Italic().equals(feature)) {
            refreshFont();
        } else {
            refreshLabel();
        }
        super.handleNotificationEvent(event);
    }

}

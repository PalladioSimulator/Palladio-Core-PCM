/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart;
import de.uka.ipd.sdq.pcm.usagemodel.ClosedWorkload;

/**
 * The Class CustomClosedWorkloadThinkTimeLabelEditPart.
 */
public class CustomClosedWorkloadThinkTimeLabelEditPart extends ClosedWorkloadThinkTimeLabelEditPart {

    /**
     * Instantiates a new custom closed workload think time label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomClosedWorkloadThinkTimeLabelEditPart(View view) {
        super(view);
    }

    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        ClosedWorkload cw = (ClosedWorkload) resolveSemanticElement();
        if (cw.getThinkTime_ClosedWorkload() != null) {
            text = "Think Time: " + cw.getThinkTime_ClosedWorkload().getSpecification();
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(getFigure());
        }
        return text;
    }

    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        ClosedWorkload cw = (ClosedWorkload) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, cw.getThinkTime_ClosedWorkload()); //$NON-NLS-1$
    }

    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart#removeSemanticListeners()
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
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ClosedWorkloadThinkTimeLabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
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

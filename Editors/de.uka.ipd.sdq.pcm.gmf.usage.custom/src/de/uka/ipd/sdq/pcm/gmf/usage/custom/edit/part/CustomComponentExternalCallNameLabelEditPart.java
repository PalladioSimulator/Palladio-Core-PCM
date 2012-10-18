/*
 * Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.custom.edit.part;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;

/**
 * The Class CustomComponentExternalCallNameLabelEditPart.
 */
public class CustomComponentExternalCallNameLabelEditPart extends ComponentExternalCallNameLabelEditPart {

    /**
     * Instantiates a new custom component external call name label edit part.
     *
     * @param view the view
     */
    public CustomComponentExternalCallNameLabelEditPart(View view) {
        super(view);
    }

    /**
     * Gets the label text.
     *
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        EntryLevelSystemCall call = (EntryLevelSystemCall) resolveSemanticElement();
        if (call != null && call.getProvidedRole_EntryLevelSystemCall() != null
                && call.getProvidedRole_EntryLevelSystemCall().getProvidedInterface__OperationProvidedRole() != null
                && call.getOperationSignature__EntryLevelSystemCall() != null) {
            text = call.getProvidedRole_EntryLevelSystemCall().getProvidedInterface__OperationProvidedRole()
                    .getEntityName()
                    + "." + call.getOperationSignature__EntryLevelSystemCall().getEntityName();
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(getFigure());
        }
        return text;
    }

    /**
     * Handle notification event.
     *
     * @param event the event
     * @see de.uka.ipd.sdq.pcm.gmf.usage.edit.parts.ComponentExternalCallNameLabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
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

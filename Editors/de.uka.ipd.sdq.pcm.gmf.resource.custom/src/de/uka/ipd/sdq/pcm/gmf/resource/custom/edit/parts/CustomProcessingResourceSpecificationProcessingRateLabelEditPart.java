/*
 * Copyright 2009, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.resource.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.palladiosimulator.pcm.dialogs.resource.OpenProcessingRateDialog;

import de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.ProcessingResourceSpecificationProcessingRateLabelEditPart;
import org.palladiosimulator.pcm.resourceenvironment.ProcessingResourceSpecification;

// TODO: Auto-generated Javadoc
/**
 * An edit part.
 */
public class CustomProcessingResourceSpecificationProcessingRateLabelEditPart extends
        ProcessingResourceSpecificationProcessingRateLabelEditPart {

    /**
     * Instantiates a new custom processing resource specification processing rate label edit part.
     * 
     * @param view
     *            a View
     */
    public CustomProcessingResourceSpecificationProcessingRateLabelEditPart(View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationProcessingRateLabelEditPart#createDefaultEditPolicies()
     */
    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicy() {

            protected List createSelectionHandles() {
                List handles = new ArrayList();
                NonResizableHandleKit.addMoveHandle((GraphicalEditPart) getHost(), handles);
                return handles;
            }

            public Command getCommand(Request request) {
                return null;
            }

            public boolean understandsRequest(Request request) {
                return false;
            }
        });
        installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenProcessingRateDialog());
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationProcessingRateLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        ProcessingResourceSpecification spec = (ProcessingResourceSpecification) resolveSemanticElement();
        if (spec.getProcessingRate_ProcessingResourceSpecification() != null) {
            text = spec.getProcessingRate_ProcessingResourceSpecification().getSpecification();
        }
        if (text == null || text.length() == 0) {
            text = getLabelTextHelper(getFigure());
        }
        return "Processing Rate: " + text; // custom code
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationProcessingRateLabelEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        ProcessingResourceSpecification spec = (ProcessingResourceSpecification) resolveSemanticElement();
        addListenerFilter("SemanticModel", this, spec.getProcessingRate_ProcessingResourceSpecification()); //$NON-NLS-1$

    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationProcessingRateLabelEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        removeListenerFilter("SemanticModel"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.resource.edit.parts.
     * ProcessingResourceSpecificationProcessingRateLabelEditPart
     * #handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
     */
    @Override
    protected void handleNotificationEvent(Notification event) {
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

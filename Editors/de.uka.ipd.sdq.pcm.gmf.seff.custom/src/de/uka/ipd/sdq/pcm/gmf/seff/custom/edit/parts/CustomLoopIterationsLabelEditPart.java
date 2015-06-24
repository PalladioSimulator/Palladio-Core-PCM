/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart;

import org.palladiosimulator.editors.dialogs.seff.OpenLoopIterationsDialog;
import org.palladiosimulator.pcm.seff.LoopAction;

/**
 * The customized loop iterations label edit part class.
 */
public class CustomLoopIterationsLabelEditPart extends LoopIterationsLabelEditPart {

    /**
     * Instantiates a new customized loop iterations label edit part.
     * 
     * @param view
     *            the view
     */
    public CustomLoopIterationsLabelEditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#createDefaultEditPolicies
     * ()
     */
    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#createDefaultEditPolicies()
     */
    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        this.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicy() {

            @SuppressWarnings("rawtypes")
            @Override
            protected List createSelectionHandles() {
                final List handles = new ArrayList();
                NonResizableHandleKit.addMoveHandle((GraphicalEditPart) this.getHost(), handles);
                return handles;
            }

            @Override
            public Command getCommand(final Request request) {
                return null;
            }

            @Override
            public boolean understandsRequest(final Request request) {
                return false;
            }
        });
        this.installEditPolicy(EditPolicyRoles.OPEN_ROLE, new OpenLoopIterationsDialog());
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#getLabelText()
     */
    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        final LoopAction loop = (LoopAction) this.resolveSemanticElement();
        if (loop.getIterationCount_LoopAction() != null) {
            text = loop.getIterationCount_LoopAction().getSpecification();
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
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#addSemanticListeners()
     */
    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        final LoopAction loop = (LoopAction) this.resolveSemanticElement();
        this.addListenerFilter("SemanticModel", this, loop.getIterationCount_LoopAction()); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#removeSemanticListeners()
     */
    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        this.removeListenerFilter("SemanticModel"); //$NON-NLS-1$
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#handleNotificationEvent
     * (org.eclipse.emf.common.notify.Notification)
     */
    /**
     * Handle notification event.
     * 
     * @param event
     *            the event
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.LoopIterationsLabelEditPart#handleNotificationEvent(org.eclipse.emf.common.notify.Notification)
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

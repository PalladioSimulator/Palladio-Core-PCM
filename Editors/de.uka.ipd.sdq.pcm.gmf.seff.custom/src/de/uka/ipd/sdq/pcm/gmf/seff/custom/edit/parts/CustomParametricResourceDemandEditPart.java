/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelTextNonResizableEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ParametricResourceDemandItemSemanticEditPolicy;

import org.palladiosimulator.editors.dialogs.OpenStoExDialog;
import org.palladiosimulator.pcm.seff.seff_performance.ParametricResourceDemand;
import org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * The customized parametric resource demand edit part class.
 */
public class CustomParametricResourceDemandEditPart extends ParametricResourceDemandEditPart {

    private static final int MAX_STOEX_DISPLAY_SIZE = 50;

    /** The change listener. */
    private EContentAdapter changeListener = null;

    /** The adapted element. */
    private EObject adaptedElement = null;

    /**
     * Instantiates a new customized parametric resource demand edit part.
     * 
     * @param view
     *            the view
     */
    public CustomParametricResourceDemandEditPart(final View view) {
        super(view);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#createDefaultEditPolicies
     * ()
     */
    /**
     * Creates the default edit policies.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#createDefaultEditPolicies()
     */
    @Override
    protected void createDefaultEditPolicies() {
        super.createDefaultEditPolicies();
        this.installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE, new ParametricResourceDemandItemSemanticEditPolicy());
        this.installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PalladioComponentModelTextNonResizableEditPolicy());
        this.installEditPolicy(EditPolicy.COMPONENT_ROLE, new ListItemComponentEditPolicy());
        this.installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE, new LabelDirectEditPolicy());
        this.installEditPolicy(
                EditPolicyRoles.OPEN_ROLE,
                new OpenStoExDialog(SeffPerformancePackage.eINSTANCE
                        .getParametricResourceDemand_Specification_ParametericResourceDemand()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#getLabelText()
     */
    /**
     * Gets the label text.
     * 
     * @return the label text
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#getLabelText()
     */
    @Override
    protected String getLabelText() {
        String text = null;
        if (this.resolveSemanticElement() instanceof ParametricResourceDemand) {
            final ParametricResourceDemand demand = (ParametricResourceDemand) this.resolveSemanticElement();
            if (demand.getRequiredResource_ParametricResourceDemand() != null) {
                text = new PCMStoExPrettyPrintVisitor().prettyPrint(demand.getSpecification_ParametericResourceDemand()
                        .getExpression());
                if (text == null) {
                    text = "";
                } else {
                    if (text.length() > MAX_STOEX_DISPLAY_SIZE) {
                        text = text.substring(0, MAX_STOEX_DISPLAY_SIZE) + "...";
                    }
                    text += " ";
                }
                text += "<" + demand.getRequiredResource_ParametricResourceDemand().getEntityName() + ">";
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
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#addSemanticListeners
     * ()
     */
    /**
     * Adds the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#addSemanticListeners()
     */
    @Override
    protected void addSemanticListeners() {
        final ParametricResourceDemand element = (ParametricResourceDemand) this.resolveSemanticElement();
        this.changeListener = new EContentAdapter() {

            @Override
            public void notifyChanged(final Notification notification) {
                super.notifyChanged(notification);
                CustomParametricResourceDemandEditPart.this.refreshLabel();
            }

        };
        this.adaptedElement = element;
        element.eAdapters().add(this.changeListener);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#removeSemanticListeners
     * ()
     */
    /**
     * Removes the semantic listeners.
     * 
     * @see de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart#removeSemanticListeners()
     */
    @Override
    protected void removeSemanticListeners() {
        this.adaptedElement.eAdapters().remove(this.changeListener);
    }

}

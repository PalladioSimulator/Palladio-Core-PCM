/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.Messages;

/**
 * The Class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart.
 *
 * @generated
 */
public class ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart
		extends ShapeCompartmentEditPart {

	/** The Constant VISUAL_ID. @generated */
	public static final int VISUAL_ID = 7002;

	/**
	 * Instantiates a new composed providing requiring entity composite structure inner compartment edit part.
	 *
	 * @param view the view
	 * @generated
	 */
	public ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart(
			View view) {
		super(view);
	}

	/**
	 * Gets the compartment name.
	 *
	 * @return the compartment name
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentEditPart_title;
	}

	/**
	 * Creates the figure.
	 *
	 * @return the i figure
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * Creates the default edit policies.
	 *
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(
				EditPolicyRoles.CANONICAL_ROLE,
				new ComposedProvidingRequiringEntityCompositeStructureInnerCompartmentCanonicalEditPolicy());
	}

	/**
	 * Sets the ratio.
	 *
	 * @param ratio the new ratio
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}

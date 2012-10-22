/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ListCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.Messages;

/**
 * @generated
 */
public class ResourceContainerAllocationCompartmentEditPart extends
		ShapeCompartmentEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 7003;

	/**
	 * @generated
	 */
	public ResourceContainerAllocationCompartmentEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	public String getCompartmentName() {
		return Messages.ResourceContainerAllocationCompartmentEditPart_title;
	}

	/**
	 * @generated
	 */
	public IFigure createFigure() {
		ResizableCompartmentFigure result = (ResizableCompartmentFigure) super
				.createFigure();
		result.setTitleVisibility(false);
		return result;
	}

	/**
	 * @generated not
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(
				EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceContainerAllocationCompartmentItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy() {

					/*
					 * (non-Javadoc)
					 * 
					 * @see
					 * org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy#getDropCommand
					 * (org.eclipse.gef.requests.ChangeBoundsRequest) Override this to implement Drag Drop
					 * of Allocation Contexts
					 */
					@Override
					protected Command getDropCommand(ChangeBoundsRequest request) {
						CompositeCommand cc = new CompositeCommand(
								"Drag Element");
						for (Object editPart : request.getEditParts()) {
							if (editPart instanceof IGraphicalEditPart) {
								EObject element = resolveElement((IGraphicalEditPart) editPart);
								Node allocationContextView = (Node) ((IGraphicalEditPart) editPart)
										.getModel();
								if (element != null
										&& element instanceof AllocationContext) {
									Rectangle newBounds = getNewBounds(
											allocationContextView, element,
											(IGraphicalEditPart) editPart,
											request);
									addAddViewCommand(cc,
											allocationContextView, element);
									addChangeSemanticModelCommand(cc, element);
									addChangeBoundsCommand(cc,
											allocationContextView, element,
											newBounds);
								}
							}
						}
						return new ICommandProxy(cc);
					}

					private void addChangeBoundsCommand(CompositeCommand cc,
							Node source, EObject element, Rectangle newBounds) {
						SetBoundsCommand setBounds = new SetBoundsCommand(
								ResourceContainerAllocationCompartmentEditPart.this
										.getEditingDomain(), "Set Position",
								new EObjectAdapter(source), newBounds);
						cc.add(setBounds);
					}

					private Rectangle getNewBounds(Node source,
							EObject element, IGraphicalEditPart editPart,
							ChangeBoundsRequest request) {
						Bounds b = (Bounds) source.getLayoutConstraint();
						Rectangle newBounds = new Rectangle(b.getX(), b.getY(),
								b.getWidth(), b.getHeight());
						editPart.getFigure().translateToAbsolute(newBounds);
						newBounds = request.getTransformedRectangle(newBounds);
						ResourceContainerAllocationCompartmentEditPart.this
								.getContentPane()
								.translateToRelative(newBounds);
						Point targetPoint = new Point(request.getLocation());
						getFigure().translateToRelative(targetPoint);

						return newBounds;
					}

					private void addChangeSemanticModelCommand(
							CompositeCommand cc, EObject element) {
						SetRequest setRequest = new SetRequest(
								element,
								AllocationPackage.eINSTANCE
										.getAllocationContext_ResourceContainer_AllocationContext(),
								ResourceContainerAllocationCompartmentEditPart.this
										.resolveSemanticElement());
						SetValueCommand cmd = new SetValueCommand(setRequest);
						cc.add(cmd);
					}

					private void addAddViewCommand(CompositeCommand cc,
							Node source, EObject element) {
						View targetView = (View) ResourceContainerAllocationCompartmentEditPart.this
								.getModel();
						AddCommand addCommand = new AddCommand(
								ResourceContainerAllocationCompartmentEditPart.this
										.getEditingDomain(),
								new EObjectAdapter(targetView),
								new EObjectAdapter(source));
						cc.add(addCommand);
					}

					private EObject resolveElement(IGraphicalEditPart editPart) {
						EObject element = ViewUtil
								.resolveSemanticElement((View) ((IGraphicalEditPart) editPart)
										.getModel());
						return element;
					}

				});
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ResourceContainerAllocationCompartmentCanonicalEditPolicy());
	}

	/**
	 * @generated
	 */
	protected void setRatio(Double ratio) {
		if (getFigure().getParent().getLayoutManager() instanceof ConstrainedToolbarLayout) {
			super.setRatio(ratio);
		}
	}

}

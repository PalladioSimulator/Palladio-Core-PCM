package de.uka.ipd.sdq.pcm.gmf.allocation.custom.edit.parts;

import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.diagram.core.commands.AddCommand;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts.ResourceContainerAllocationCompartmentEditPart;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.ResourceContainerAllocationCompartmentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry;

/**
 * A custom resource container allocation compartment EditPart.
 */
public class CustomResourceContainerAllocationCompartmentEditPart extends
        ResourceContainerAllocationCompartmentEditPart {

    /**
     * The constructor.
     * 
     * @param view
     *            a View
     */
    public CustomResourceContainerAllocationCompartmentEditPart(View view) {
        super(view);
        // TODO Auto-generated constructor stub
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
//				new CreationEditPolicy()  // in older GMF
				new CreationEditPolicyWithCustomReparent(
						PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE)
		);
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
//				new DragDropEditPolicy()
				// install custom edit policy:
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
						CustomResourceContainerAllocationCompartmentEditPart.this
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
				CustomResourceContainerAllocationCompartmentEditPart.this
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
						CustomResourceContainerAllocationCompartmentEditPart.this
								.resolveSemanticElement());
				SetValueCommand cmd = new SetValueCommand(setRequest);
				cc.add(cmd);
			}

			private void addAddViewCommand(CompositeCommand cc,
					Node source, EObject element) {
				View targetView = (View) CustomResourceContainerAllocationCompartmentEditPart.this
						.getModel();
				AddCommand addCommand = new AddCommand(
						CustomResourceContainerAllocationCompartmentEditPart.this
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
		}
		);
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new ResourceContainerAllocationCompartmentCanonicalEditPolicy());
	}
}

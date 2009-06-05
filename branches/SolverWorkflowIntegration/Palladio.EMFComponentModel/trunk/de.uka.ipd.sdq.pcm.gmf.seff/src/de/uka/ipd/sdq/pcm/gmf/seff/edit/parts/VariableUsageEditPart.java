/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.core.edithelpers.CreateElementRequestAdapter;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.VariableUsageItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

/**
 * @generated
 */
public class VariableUsageEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3032;

	/**
	 * @generated
	 */
	protected IFigure contentPane;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public VariableUsageEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					public Command getCommand(Request request) {
						if (understandsRequest(request)) {
							if (request instanceof CreateViewAndElementRequest) {
								CreateElementRequestAdapter adapter = ((CreateViewAndElementRequest) request)
										.getViewAndElementDescriptor()
										.getCreateElementRequestAdapter();
								IElementType type = (IElementType) adapter
										.getAdapter(IElementType.class);
								if (type == PalladioComponentModelElementTypes.VariableCharacterisation_3033) {
									EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
											.getType(VariableUsageVariableCharacterisationEditPart.VISUAL_ID));
									return compartmentEditPart == null ? null
											: compartmentEditPart
													.getCommand(request);
								}
							}
							return super.getCommand(request);
						}
						return null;
					}
				});
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new VariableUsageItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				EditPolicy result = child
						.getEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
				if (result == null) {
					result = new NonResizableEditPolicy();
				}
				return result;
			}

			protected Command getMoveChildrenCommand(Request request) {
				return null;
			}

			protected Command getCreateCommand(CreateRequest request) {
				return null;
			}
		};
		return lep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		ParametricParameterUsageFigure figure = new ParametricParameterUsageFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ParametricParameterUsageFigure getPrimaryShape() {
		return (ParametricParameterUsageFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrappingLabelEditPart) {
			((WrappingLabelEditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureVariableUsageReferenceLabelFigure());
			return true;
		}
		if (childEditPart instanceof VariableUsageVariableCharacterisationEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureParametricParameterUsageRectangleCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((VariableUsageVariableCharacterisationEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof VariableUsageVariableCharacterisationEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureParametricParameterUsageRectangleCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((VariableUsageVariableCharacterisationEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {

		if (editPart instanceof VariableUsageVariableCharacterisationEditPart) {
			return getPrimaryShape()
					.getFigureParametricParameterUsageRectangleCompartment();
		}
		return super.getContentPaneFor(editPart);
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(40), getMapMode().DPtoLP(40));
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane.
	 * Respects layout one may have set for generated figure.
	 * @param nodeShape instance of generated figure class
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(getMapMode().DPtoLP(5));
			nodeShape.setLayoutManager(layout);
		}
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(WrappingLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ParametricParameterUsageFigure extends RectangleFigure {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureVariableUsageReferenceLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureParametricParameterUsageRectangleCompartment;

		/**
		 * @generated
		 */
		public ParametricParameterUsageFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setBackgroundColor(ColorConstants.cyan);
			createContents();
		}

		/**
		 * @generated not
		 */
		private void createContents() {

			fFigureVariableUsageReferenceLabelFigure = new WrappingLabel();
			fFigureVariableUsageReferenceLabelFigure
					.setText(new PCMStoExPrettyPrintVisitor()
							.prettyPrint(((VariableUsage) resolveSemanticElement())
									.getNamedReference_VariableUsage()));
			fFigureVariableUsageReferenceLabelFigure
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureVariableUsageReferenceLabelFigure = new GridData();
			constraintFFigureVariableUsageReferenceLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalIndent = 0;
			constraintFFigureVariableUsageReferenceLabelFigure.horizontalSpan = 1;
			constraintFFigureVariableUsageReferenceLabelFigure.verticalSpan = 1;
			constraintFFigureVariableUsageReferenceLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureVariableUsageReferenceLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureVariableUsageReferenceLabelFigure,
					constraintFFigureVariableUsageReferenceLabelFigure);

			fFigureParametricParameterUsageRectangleCompartment = new RectangleFigure();
			fFigureParametricParameterUsageRectangleCompartment.setFill(false);
			fFigureParametricParameterUsageRectangleCompartment
					.setOutline(false);

			GridData constraintFFigureParametricParameterUsageRectangleCompartment = new GridData();
			constraintFFigureParametricParameterUsageRectangleCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalIndent = 0;
			constraintFFigureParametricParameterUsageRectangleCompartment.horizontalSpan = 1;
			constraintFFigureParametricParameterUsageRectangleCompartment.verticalSpan = 1;
			constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureParametricParameterUsageRectangleCompartment.grabExcessVerticalSpace = true;
			this
					.add(fFigureParametricParameterUsageRectangleCompartment,
							constraintFFigureParametricParameterUsageRectangleCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureVariableUsageReferenceLabelFigure() {
			return fFigureVariableUsageReferenceLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureParametricParameterUsageRectangleCompartment() {
			return fFigureParametricParameterUsageRectangleCompartment;
		}

		/**
		 * @generated
		 */
		private boolean myUseLocalCoordinates = false;

		/**
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}

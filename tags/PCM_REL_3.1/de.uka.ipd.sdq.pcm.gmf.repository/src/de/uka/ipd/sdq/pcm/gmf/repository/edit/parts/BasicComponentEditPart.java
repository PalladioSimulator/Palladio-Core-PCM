/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.PositionConstants;
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

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.BasicComponentItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.OpenSeffDiagramEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.repository.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.repository.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class BasicComponentEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2102;

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
	public BasicComponentEditPart(View view) {
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
								if (type == PalladioComponentModelElementTypes.ResourceDemandingSEFF_3102) {
									EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
											.getType(BasicComponentSEFFCompartmentEditPart.VISUAL_ID));
									return compartmentEditPart == null ? null
											: compartmentEditPart
													.getCommand(request);
								}
								if (type == PalladioComponentModelElementTypes.PassiveResource_3103) {
									EditPart compartmentEditPart = getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
											.getType(BasicComponentPassiveResourceCompartmentEditPart.VISUAL_ID));
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
				new BasicComponentItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenSeffDiagramEditPolicy());
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
		BasicComponentFigure figure = new BasicComponentFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BasicComponentFigure getPrimaryShape() {
		return (BasicComponentFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BasicComponentEntityNameEditPart) {
			((BasicComponentEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBasicComponent_Name_LabelFigure());
			return true;
		}
		if (childEditPart instanceof BasicComponentSEFFCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((BasicComponentSEFFCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof BasicComponentPassiveResourceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((BasicComponentPassiveResourceCompartmentEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof BasicComponentComponentParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((BasicComponentComponentParameterCompartmentEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof BasicComponentSEFFCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((BasicComponentSEFFCompartmentEditPart) childEditPart)
					.getFigure());
			return true;
		}
		if (childEditPart instanceof BasicComponentPassiveResourceCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((BasicComponentPassiveResourceCompartmentEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof BasicComponentComponentParameterCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBasicComponentCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((BasicComponentComponentParameterCompartmentEditPart) childEditPart)
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

		if (editPart instanceof BasicComponentSEFFCompartmentEditPart) {
			return getPrimaryShape().getFigureBasicComponentCompartment();
		}
		if (editPart instanceof BasicComponentPassiveResourceCompartmentEditPart) {
			return getPrimaryShape().getFigureBasicComponentCompartment();
		}
		if (editPart instanceof BasicComponentComponentParameterCompartmentEditPart) {
			return getPrimaryShape().getFigureBasicComponentCompartment();
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
				.getType(BasicComponentEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class BasicComponentFigure extends RectangleFigure {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBasicComponent_Name_LabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureBasicComponentCompartment;

		/**
		 * @generated
		 */
		public BasicComponentFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureBasicComponent_Name_LabelFigure = new WrappingLabel();
			fFigureBasicComponent_Name_LabelFigure.setText("<...>");
			fFigureBasicComponent_Name_LabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureBasicComponent_Name_LabelFigure = new GridData();
			constraintFFigureBasicComponent_Name_LabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureBasicComponent_Name_LabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureBasicComponent_Name_LabelFigure.horizontalIndent = 0;
			constraintFFigureBasicComponent_Name_LabelFigure.horizontalSpan = 1;
			constraintFFigureBasicComponent_Name_LabelFigure.verticalSpan = 1;
			constraintFFigureBasicComponent_Name_LabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureBasicComponent_Name_LabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureBasicComponent_Name_LabelFigure,
					constraintFFigureBasicComponent_Name_LabelFigure);

			fFigureBasicComponentCompartment = new RectangleFigure();
			fFigureBasicComponentCompartment.setFill(false);
			fFigureBasicComponentCompartment.setOutline(false);

			GridData constraintFFigureBasicComponentCompartment = new GridData();
			constraintFFigureBasicComponentCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureBasicComponentCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureBasicComponentCompartment.horizontalIndent = 0;
			constraintFFigureBasicComponentCompartment.horizontalSpan = 1;
			constraintFFigureBasicComponentCompartment.verticalSpan = 1;
			constraintFFigureBasicComponentCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureBasicComponentCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureBasicComponentCompartment,
					constraintFFigureBasicComponentCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBasicComponent_Name_LabelFigure() {
			return fFigureBasicComponent_Name_LabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureBasicComponentCompartment() {
			return fFigureBasicComponentCompartment;
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

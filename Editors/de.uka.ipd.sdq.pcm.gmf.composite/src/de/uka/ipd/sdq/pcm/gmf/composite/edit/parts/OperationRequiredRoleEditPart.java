/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.editpolicies.ResizableEditPolicy;
import org.eclipse.gef.handles.MoveHandle;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.BorderedBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.composite.AbstractBorderFigure.POSITION_TYPE;
import de.uka.ipd.sdq.pcm.gmf.composite.SocketFigure;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.OperationRequiredRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.composite.providers.PalladioComponentModelElementTypes;

/**
 * Operation Required Role Edit Part for inner assembly context required roles.
 * 
 * For system operation required roles
 * 
 * @see OperationRequiredRole2EditPart
 * 
 * @generated
 */
public class OperationRequiredRoleEditPart extends BorderedBorderItemEditPart {

	/** size of the figure in LP. @generated not */
	private static final int FIGURE_LOGICAL_SIZE = 30;

	/** The Constant VISUAL_ID. @generated */
	public static final int VISUAL_ID = 3008;

	/** The content pane. @generated */
	protected IFigure contentPane;

	/** The primary shape. @generated */
	protected IFigure primaryShape;

	/**
	 * Instantiates a new operation required role edit part.
	 *
	 * @param view the view
	 * @generated
	 */
	public OperationRequiredRoleEditPart(View view) {
		super(view);
	}

	/**
	 * Creates the default edit policies.
	 *
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new OperationRequiredRoleItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
		// XXX need an SCR to runtime to have another abstract superclass that would let children add reasonable editpolicies
		// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CONNECTION_HANDLES_ROLE);
	}

	/**
	 * Creates the layout edit policy.
	 *
	 * @return the layout edit policy
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected EditPolicy createChildEditPolicy(EditPart child) {
				View childView = (View) child.getModel();
				switch (PalladioComponentModelVisualIDRegistry
						.getVisualID(childView)) {
				case OperationRequiredRoleEntityNameEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy() {

						protected List createSelectionHandles() {
							MoveHandle mh = new MoveHandle(
									(GraphicalEditPart) getHost());
							mh.setBorder(null);
							return Collections.singletonList(mh);
						}
					};
				}
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
	 * Creates the node shape.
	 *
	 * @return the i figure
	 * @generated
	 */
	protected IFigure createNodeShape() {
		OperationRequiredRoleFigure figure = new OperationRequiredRoleFigure();
		return primaryShape = figure;
	}

	/**
	 * Gets the primary shape.
	 *
	 * @return the primary shape
	 * @generated
	 */
	public OperationRequiredRoleFigure getPrimaryShape() {
		return (OperationRequiredRoleFigure) primaryShape;
	}

	/**
	 * Adds the border item.
	 *
	 * @param borderItemContainer the border item container
	 * @param borderItemEditPart the border item edit part
	 * @generated
	 */
	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (borderItemEditPart instanceof OperationRequiredRoleEntityNameEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.SOUTH);
			locator.setBorderItemOffset(new Dimension(-20, -20));
			borderItemContainer.add(borderItemEditPart.getFigure(), locator);
		} else {
			super.addBorderItem(borderItemContainer, borderItemEditPart);
		}
	}

	/**
	 * Creates the node plate.
	 *
	 * @return the node figure
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(20, 20);

		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
		return result;
	}

	/**
	 * Gets the primary drag edit policy.
	 *
	 * @return the primary drag edit policy
	 * @generated
	 */
	public EditPolicy getPrimaryDragEditPolicy() {
		EditPolicy result = super.getPrimaryDragEditPolicy();
		if (result instanceof ResizableEditPolicy) {
			ResizableEditPolicy ep = (ResizableEditPolicy) result;
			ep.setResizeDirections(PositionConstants.NONE);
		}
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 * 
	 * Manually modified to generate a specific socket figure instead of the standard shape
	 * configured in the map model.
	 *
	 * @return the node figure
	 * @generated not
	 */
	protected NodeFigure createMainFigure() {
		SocketFigure figure = new SocketFigure(getMapMode().DPtoLP(
				FIGURE_LOGICAL_SIZE), POSITION_TYPE.POS_INTERNAL);
		figure.getBounds().setSize(figure.getPreferredSize());

		return figure;
	}

	/**
	 * Default implementation treats passed figure as content pane. Respects layout one may have set
	 * for generated figure.
	 *
	 * @param nodeShape instance of generated figure class
	 * @return the i figure
	 * @generated
	 */
	protected IFigure setupContentPane(IFigure nodeShape) {
		return nodeShape; // use nodeShape itself as contentPane
	}

	/**
	 * Gets the content pane.
	 *
	 * @return the content pane
	 * @generated
	 */
	public IFigure getContentPane() {
		if (contentPane != null) {
			return contentPane;
		}
		return super.getContentPane();
	}

	/**
	 * Sets the foreground color.
	 *
	 * @param color the new foreground color
	 * @generated
	 */
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * Sets the background color.
	 *
	 * @param color the new background color
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * Sets the line width.
	 *
	 * @param width the new line width
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * Sets the line type.
	 *
	 * @param style the new line type
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * Gets the primary child edit part.
	 *
	 * @return the primary child edit part
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(OperationRequiredRoleEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * Gets the mA rel types on source.
	 *
	 * @return the mA rel types on source
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types.add(PalladioComponentModelElementTypes.AssemblyConnector_4004);
		types
				.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
		return types;
	}

	/**
	 * Gets the mA rel types on source and target.
	 *
	 * @param targetEditPart the target edit part
	 * @return the mA rel types on source and target
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof OperationProvidedRoleEditPart) {
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4004);
		}
		if (targetEditPart instanceof OperationProvidedRole2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.AssemblyConnector_4004);
		}
		if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.composite.edit.parts.OperationRequiredRoleEditPart) {
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
		}
		if (targetEditPart instanceof OperationRequiredRole2EditPart) {
			types
					.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
		}
		return types;
	}

	/**
	 * Gets the mA types for target.
	 *
	 * @param relationshipType the relationship type
	 * @return the mA types for target
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4004) {
			types
					.add(PalladioComponentModelElementTypes.OperationProvidedRole_3007);
		}
		if (relationshipType == PalladioComponentModelElementTypes.AssemblyConnector_4004) {
			types
					.add(PalladioComponentModelElementTypes.OperationProvidedRole_3011);
		}
		if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4005) {
			types
					.add(PalladioComponentModelElementTypes.OperationRequiredRole_3008);
		}
		if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4005) {
			types
					.add(PalladioComponentModelElementTypes.OperationRequiredRole_3012);
		}
		return types;
	}

	/**
	 * Gets the mA rel types on target.
	 *
	 * @return the mA rel types on target
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.RequiredDelegationConnector_4005);
		return types;
	}

	/**
	 * Gets the mA types for source.
	 *
	 * @param relationshipType the relationship type
	 * @return the mA types for source
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4005) {
			types
					.add(PalladioComponentModelElementTypes.OperationRequiredRole_3008);
		}
		if (relationshipType == PalladioComponentModelElementTypes.RequiredDelegationConnector_4005) {
			types
					.add(PalladioComponentModelElementTypes.OperationRequiredRole_3012);
		}
		return types;
	}

	/**
	 * The Class OperationRequiredRoleFigure.
	 *
	 * @generated
	 */
	public class OperationRequiredRoleFigure extends Ellipse {

		/**
		 * Instantiates a new operation required role figure.
		 *
		 * @generated
		 */
		public OperationRequiredRoleFigure() {
			this.setLineWidth(1);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(20),
					getMapMode().DPtoLP(20)));
			this.setLocation(new Point(getMapMode().DPtoLP(50), getMapMode()
					.DPtoLP(50)));
		}

		/** The my use local coordinates. @generated */
		private boolean myUseLocalCoordinates = false;

		/**
		 * Use local coordinates.
		 *
		 * @return true, if successful
		 * @generated
		 */
		protected boolean useLocalCoordinates() {
			return myUseLocalCoordinates;
		}

		/**
		 * Sets the use local coordinates.
		 *
		 * @param useLocalCoordinates the new use local coordinates
		 * @generated
		 */
		protected void setUseLocalCoordinates(boolean useLocalCoordinates) {
			myUseLocalCoordinates = useLocalCoordinates;
		}

	}

}

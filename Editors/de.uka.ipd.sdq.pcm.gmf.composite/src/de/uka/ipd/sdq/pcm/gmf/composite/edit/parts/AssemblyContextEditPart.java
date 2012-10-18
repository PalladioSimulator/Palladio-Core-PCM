/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.BorderItemSelectionEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyContextCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyContextItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.composite.part.PalladioComponentModelVisualIDRegistry;

/**
 * The Class AssemblyContextEditPart.
 *
 * @generated
 */
public class AssemblyContextEditPart extends AbstractBorderedShapeEditPart {

	/** The Constant VISUAL_ID. @generated */
	public static final int VISUAL_ID = 3006;

	/** The content pane. @generated */
	protected IFigure contentPane;

	/** The primary shape. @generated */
	protected IFigure primaryShape;

	/**
	 * Instantiates a new assembly context edit part.
	 *
	 * @param view the view
	 * @generated
	 */
	public AssemblyContextEditPart(View view) {
		super(view);
	}

	/**
	 * Creates the default edit policies.
	 *
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssemblyContextItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new AssemblyContextCanonicalEditPolicy());
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
				case OperationProvidedRoleEditPart.VISUAL_ID:
				case OperationRequiredRoleEditPart.VISUAL_ID:
				case SourceRoleEditPart.VISUAL_ID:
				case SinkRoleEditPart.VISUAL_ID:
				case InfrastructureProvidedRoleEditPart.VISUAL_ID:
				case InfrastructureRequiredRoleEditPart.VISUAL_ID:
					return new BorderItemSelectionEditPolicy();
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
		AssemblyContextFigure figure = new AssemblyContextFigure();
		return primaryShape = figure;
	}

	/**
	 * Gets the primary shape.
	 *
	 * @return the primary shape
	 * @generated
	 */
	public AssemblyContextFigure getPrimaryShape() {
		return (AssemblyContextFigure) primaryShape;
	}

	/**
	 * Adds the fixed child.
	 *
	 * @param childEditPart the child edit part
	 * @return true, if successful
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssemblyContextEntityNameEditPart) {
			((AssemblyContextEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureAssemblyContextLabelFigure());
			return true;
		}
		if (childEditPart instanceof OperationProvidedRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer()
					.add(
							((OperationProvidedRoleEditPart) childEditPart)
									.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof OperationRequiredRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer()
					.add(
							((OperationRequiredRoleEditPart) childEditPart)
									.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof SourceRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((SourceRoleEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof SinkRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((SinkRoleEditPart) childEditPart).getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof InfrastructureProvidedRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.WEST);
			getBorderedFigure().getBorderItemContainer().add(
					((InfrastructureProvidedRoleEditPart) childEditPart)
							.getFigure(), locator);
			return true;
		}
		if (childEditPart instanceof InfrastructureRequiredRoleEditPart) {
			BorderItemLocator locator = new BorderItemLocator(getMainFigure(),
					PositionConstants.EAST);
			getBorderedFigure().getBorderItemContainer().add(
					((InfrastructureRequiredRoleEditPart) childEditPart)
							.getFigure(), locator);
			return true;
		}
		return false;
	}

	/**
	 * Removes the fixed child.
	 *
	 * @param childEditPart the child edit part
	 * @return true, if successful
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof AssemblyContextEntityNameEditPart) {
			return true;
		}
		if (childEditPart instanceof OperationProvidedRoleEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(
							((OperationProvidedRoleEditPart) childEditPart)
									.getFigure());
			return true;
		}
		if (childEditPart instanceof OperationRequiredRoleEditPart) {
			getBorderedFigure().getBorderItemContainer()
					.remove(
							((OperationRequiredRoleEditPart) childEditPart)
									.getFigure());
			return true;
		}
		if (childEditPart instanceof SourceRoleEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((SourceRoleEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof SinkRoleEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((SinkRoleEditPart) childEditPart).getFigure());
			return true;
		}
		if (childEditPart instanceof InfrastructureProvidedRoleEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((InfrastructureProvidedRoleEditPart) childEditPart)
							.getFigure());
			return true;
		}
		if (childEditPart instanceof InfrastructureRequiredRoleEditPart) {
			getBorderedFigure().getBorderItemContainer().remove(
					((InfrastructureRequiredRoleEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * Adds the child visual.
	 *
	 * @param childEditPart the child edit part
	 * @param index the index
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (addFixedChild(childEditPart)) {
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * Removes the child visual.
	 *
	 * @param childEditPart the child edit part
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (removeFixedChild(childEditPart)) {
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * Gets the content pane for.
	 *
	 * @param editPart the edit part
	 * @return the content pane for
	 * @generated
	 */
	protected IFigure getContentPaneFor(IGraphicalEditPart editPart) {
		if (editPart instanceof IBorderItemEditPart) {
			return getBorderedFigure().getBorderItemContainer();
		}
		return getContentPane();
	}

	/**
	 * Creates the node plate.
	 *
	 * @return the node figure
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(80, 80);
		return result;
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 *
	 * @return the node figure
	 * @generated
	 */
	protected NodeFigure createMainFigure() {
		NodeFigure figure = createNodePlate();
		figure.setLayoutManager(new StackLayout());
		IFigure shape = createNodeShape();
		figure.add(shape);
		contentPane = setupContentPane(shape);
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
		if (nodeShape.getLayoutManager() == null) {
			ConstrainedToolbarLayout layout = new ConstrainedToolbarLayout();
			layout.setSpacing(5);
			nodeShape.setLayoutManager(layout);
		}
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
				.getType(AssemblyContextEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * The Class AssemblyContextFigure.
	 *
	 * @generated
	 */
	public class AssemblyContextFigure extends RectangleFigure {
		
		/** The figure assembly context label figure. @generated */
		private WrappingLabel fFigureAssemblyContextLabelFigure;

		/**
		 * Instantiates a new assembly context figure.
		 *
		 * @generated
		 */
		public AssemblyContextFigure() {
			this.setLineWidth(1);
			this.setLineStyle(Graphics.LINE_DASH);
			this.setPreferredSize(new Dimension(getMapMode().DPtoLP(80),
					getMapMode().DPtoLP(80)));
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			this.setLocation(new Point(getMapMode().DPtoLP(10), getMapMode()
					.DPtoLP(10)));
			createContents();
		}

		/**
		 * Creates the contents.
		 *
		 * @generated
		 */
		private void createContents() {

			fFigureAssemblyContextLabelFigure = new WrappingLabel();
			fFigureAssemblyContextLabelFigure.setText("<...>");

			this.add(fFigureAssemblyContextLabelFigure);

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

		/**
		 * Gets the figure assembly context label figure.
		 *
		 * @return the figure assembly context label figure
		 * @generated
		 */
		public WrappingLabel getFigureAssemblyContextLabelFigure() {
			return fFigureAssemblyContextLabelFigure;
		}

	}

}

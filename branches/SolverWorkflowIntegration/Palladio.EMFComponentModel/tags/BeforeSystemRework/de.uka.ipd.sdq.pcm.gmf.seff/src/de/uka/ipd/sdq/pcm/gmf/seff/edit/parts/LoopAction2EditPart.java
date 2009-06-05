/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.LoopAction2CanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.LoopAction2GraphicalNodeEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.LoopAction2ItemSemanticEditPolicy;

import de.uka.ipd.sdq.pcm.gmf.seff.part.PcmVisualIDRegistry;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class LoopAction2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2004;

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
	public LoopAction2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new LoopAction2ItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE,
				new LoopAction2GraphicalNodeEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new LoopAction2CanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
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
		LoopFigure figure = new LoopFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public LoopFigure getPrimaryShape() {
		return (LoopFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof LoopActionEntityNameEditPart) {
			((LoopActionEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape().getFigureLoopNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof LoopActionIterationsEditPart) {
			((LoopActionIterationsEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureLoopIterationsLabelFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		return false;
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		return new DefaultSizeNodeFigure(getMapMode().DPtoLP(40), getMapMode()
				.DPtoLP(40));
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
		return getChildBySemanticHint(PcmVisualIDRegistry
				.getType(LoopActionEntityNameEditPart.VISUAL_ID));
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
	public class LoopFigure extends org.eclipse.draw2d.RoundedRectangle {

		/**
		 * @generated
		 */
		public LoopFigure() {

			this.setCornerDimensions(new org.eclipse.draw2d.geometry.Dimension(
					getMapMode().DPtoLP(8), getMapMode().DPtoLP(8)));

			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {
			org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_0 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();
			fig_0.setText("<<Loop>>");

			setFigureLoopStereotype(fig_0);

			Object layData0 = null;

			this.add(fig_0, layData0);
			org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_1 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();
			fig_1.setText("myLoop");

			setFigureLoopNameLabelFigure(fig_1);

			Object layData1 = null;

			this.add(fig_1, layData1);
			org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig_2 = new org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel();

			setFigureLoopIterationsLabelFigure(fig_2);

			Object layData2 = null;

			this.add(fig_2, layData2);
		}

		/**
		 * @generated
		 */
		private org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fLoopStereotype;

		/**
		 * @generated
		 */
		public org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel getFigureLoopStereotype() {
			return fLoopStereotype;
		}

		/**
		 * @generated
		 */
		private void setFigureLoopStereotype(
				org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig) {
			fLoopStereotype = fig;
		}

		/**
		 * @generated
		 */
		private org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fLoopNameLabelFigure;

		/**
		 * @generated
		 */
		public org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel getFigureLoopNameLabelFigure() {
			return fLoopNameLabelFigure;
		}

		/**
		 * @generated
		 */
		private void setFigureLoopNameLabelFigure(
				org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig) {
			fLoopNameLabelFigure = fig;
		}

		/**
		 * @generated
		 */
		private org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fLoopIterationsLabelFigure;

		/**
		 * @generated
		 */
		public org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel getFigureLoopIterationsLabelFigure() {
			return fLoopIterationsLabelFigure;
		}

		/**
		 * @generated
		 */
		private void setFigureLoopIterationsLabelFigure(
				org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel fig) {
			fLoopIterationsLabelFigure = fig;
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

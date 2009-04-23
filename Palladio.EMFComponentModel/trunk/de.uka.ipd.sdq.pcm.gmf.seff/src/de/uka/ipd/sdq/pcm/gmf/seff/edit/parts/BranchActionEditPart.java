/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.BranchActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class BranchActionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3009;

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
	public BranchActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new BranchActionItemSemanticEditPolicy());
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
		BranchFigure figure = new BranchFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public BranchFigure getPrimaryShape() {
		return (BranchFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof BranchActionEntityNameEditPart) {
			((BranchActionEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureBranchNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBranchTransitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((BranchActionBranchTransitionCompartmentEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureBranchTransitionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((BranchActionBranchTransitionCompartmentEditPart) childEditPart)
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

		if (editPart instanceof BranchActionBranchTransitionCompartmentEditPart) {
			return getPrimaryShape().getFigureBranchTransitionCompartment();
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
				.getType(BranchActionEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class BranchFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureBranchNameLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureBranchTransitionCompartment;

		/**
		 * @generated
		 */
		public BranchFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setCornerDimensions(new Dimension(getMapMode().DPtoLP(8),
					getMapMode().DPtoLP(8)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel branchStereotype0 = new WrappingLabel();
			branchStereotype0.setText("<<BranchAction>>");
			branchStereotype0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintBranchStereotype0 = new GridData();
			constraintBranchStereotype0.verticalAlignment = GridData.CENTER;
			constraintBranchStereotype0.horizontalAlignment = GridData.CENTER;
			constraintBranchStereotype0.horizontalIndent = 0;
			constraintBranchStereotype0.horizontalSpan = 1;
			constraintBranchStereotype0.verticalSpan = 1;
			constraintBranchStereotype0.grabExcessHorizontalSpace = false;
			constraintBranchStereotype0.grabExcessVerticalSpace = false;
			this.add(branchStereotype0, constraintBranchStereotype0);

			fFigureBranchNameLabelFigure = new WrappingLabel();
			fFigureBranchNameLabelFigure.setText("myBranch");
			fFigureBranchNameLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureBranchNameLabelFigure = new GridData();
			constraintFFigureBranchNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureBranchNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureBranchNameLabelFigure.horizontalIndent = 0;
			constraintFFigureBranchNameLabelFigure.horizontalSpan = 1;
			constraintFFigureBranchNameLabelFigure.verticalSpan = 1;
			constraintFFigureBranchNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureBranchNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureBranchNameLabelFigure,
					constraintFFigureBranchNameLabelFigure);

			fFigureBranchTransitionCompartment = new RectangleFigure();
			fFigureBranchTransitionCompartment.setFill(false);
			fFigureBranchTransitionCompartment.setOutline(false);

			GridData constraintFFigureBranchTransitionCompartment = new GridData();
			constraintFFigureBranchTransitionCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureBranchTransitionCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureBranchTransitionCompartment.horizontalIndent = 0;
			constraintFFigureBranchTransitionCompartment.horizontalSpan = 1;
			constraintFFigureBranchTransitionCompartment.verticalSpan = 1;
			constraintFFigureBranchTransitionCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureBranchTransitionCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureBranchTransitionCompartment,
					constraintFFigureBranchTransitionCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureBranchNameLabelFigure() {
			return fFigureBranchNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureBranchTransitionCompartment() {
			return fFigureBranchTransitionCompartment;
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

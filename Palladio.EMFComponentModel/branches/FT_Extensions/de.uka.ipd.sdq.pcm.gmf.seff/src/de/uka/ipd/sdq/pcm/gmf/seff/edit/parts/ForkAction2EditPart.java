/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

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
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ForkAction2ItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class ForkAction2EditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3023;

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
	public ForkAction2EditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ForkAction2ItemSemanticEditPolicy());
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
		ForkFigure figure = new ForkFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public ForkFigure getPrimaryShape() {
		return (ForkFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof ForkActionEntityName2EditPart) {
			((ForkActionEntityName2EditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureForkFigureNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof ForkActionForkedBehavioursEditPart) {
			IFigure pane = getPrimaryShape().getFigureForkCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((ForkActionForkedBehavioursEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof ForkActionForkedBehavioursEditPart) {
			IFigure pane = getPrimaryShape().getFigureForkCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.remove(((ForkActionForkedBehavioursEditPart) childEditPart)
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

		if (editPart instanceof ForkActionForkedBehavioursEditPart) {
			return getPrimaryShape().getFigureForkCompartment();
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
				.getType(ForkActionEntityName2EditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class ForkFigure extends RectangleFigure {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureForkFigureNameLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureForkCompartment;

		/**
		 * @generated
		 */
		public ForkFigure() {

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

			WrappingLabel stereotypeLabelFigure0 = new WrappingLabel();
			stereotypeLabelFigure0.setText("<<Fork>>");
			stereotypeLabelFigure0.setBorder(new MarginBorder(getMapMode()
					.DPtoLP(2), getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
					getMapMode().DPtoLP(0)));

			GridData constraintStereotypeLabelFigure0 = new GridData();
			constraintStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
			constraintStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
			constraintStereotypeLabelFigure0.horizontalIndent = 0;
			constraintStereotypeLabelFigure0.horizontalSpan = 1;
			constraintStereotypeLabelFigure0.verticalSpan = 1;
			constraintStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
			constraintStereotypeLabelFigure0.grabExcessVerticalSpace = false;
			this.add(stereotypeLabelFigure0, constraintStereotypeLabelFigure0);

			fFigureForkFigureNameLabelFigure = new WrappingLabel();
			fFigureForkFigureNameLabelFigure.setText("");
			fFigureForkFigureNameLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureForkFigureNameLabelFigure = new GridData();
			constraintFFigureForkFigureNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureForkFigureNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureForkFigureNameLabelFigure.horizontalIndent = 0;
			constraintFFigureForkFigureNameLabelFigure.horizontalSpan = 1;
			constraintFFigureForkFigureNameLabelFigure.verticalSpan = 1;
			constraintFFigureForkFigureNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureForkFigureNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureForkFigureNameLabelFigure,
					constraintFFigureForkFigureNameLabelFigure);

			fFigureForkCompartment = new RectangleFigure();
			fFigureForkCompartment.setFill(false);
			fFigureForkCompartment.setOutline(false);

			GridData constraintFFigureForkCompartment = new GridData();
			constraintFFigureForkCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureForkCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureForkCompartment.horizontalIndent = 0;
			constraintFFigureForkCompartment.horizontalSpan = 1;
			constraintFFigureForkCompartment.verticalSpan = 1;
			constraintFFigureForkCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureForkCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureForkCompartment, constraintFFigureForkCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureForkFigureNameLabelFigure() {
			return fFigureForkFigureNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureForkCompartment() {
			return fFigureForkCompartment;
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

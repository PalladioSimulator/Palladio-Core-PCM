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

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.SetVariableActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class SetVariableActionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3024;

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
	public SetVariableActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SetVariableActionItemSemanticEditPolicy());
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
		SetVariableActionFigure figure = new SetVariableActionFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public SetVariableActionFigure getPrimaryShape() {
		return (SetVariableActionFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof SetVariableActionEntityNameEditPart) {
			((SetVariableActionEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureSetVariableNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof SetVariableActionVariableSetterEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureSetVariableActionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane.add(((SetVariableActionVariableSetterEditPart) childEditPart)
					.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {

		if (childEditPart instanceof SetVariableActionVariableSetterEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureSetVariableActionCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((SetVariableActionVariableSetterEditPart) childEditPart)
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

		if (editPart instanceof SetVariableActionVariableSetterEditPart) {
			return getPrimaryShape().getFigureSetVariableActionCompartment();
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
				.getType(SetVariableActionEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class SetVariableActionFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureSetVariableNameLabelFigure;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureSetVariableActionCompartment;

		/**
		 * @generated
		 */
		public SetVariableActionFigure() {

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

			WrappingLabel setVariableActionStereotypeLabelFigure0 = new WrappingLabel();
			setVariableActionStereotypeLabelFigure0
					.setText("<<SetVariableAction>>");
			setVariableActionStereotypeLabelFigure0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintSetVariableActionStereotypeLabelFigure0 = new GridData();
			constraintSetVariableActionStereotypeLabelFigure0.verticalAlignment = GridData.CENTER;
			constraintSetVariableActionStereotypeLabelFigure0.horizontalAlignment = GridData.CENTER;
			constraintSetVariableActionStereotypeLabelFigure0.horizontalIndent = 0;
			constraintSetVariableActionStereotypeLabelFigure0.horizontalSpan = 1;
			constraintSetVariableActionStereotypeLabelFigure0.verticalSpan = 1;
			constraintSetVariableActionStereotypeLabelFigure0.grabExcessHorizontalSpace = false;
			constraintSetVariableActionStereotypeLabelFigure0.grabExcessVerticalSpace = false;
			this.add(setVariableActionStereotypeLabelFigure0,
					constraintSetVariableActionStereotypeLabelFigure0);

			fFigureSetVariableNameLabelFigure = new WrappingLabel();
			fFigureSetVariableNameLabelFigure.setText("");
			fFigureSetVariableNameLabelFigure.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintFFigureSetVariableNameLabelFigure = new GridData();
			constraintFFigureSetVariableNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureSetVariableNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureSetVariableNameLabelFigure.horizontalIndent = 0;
			constraintFFigureSetVariableNameLabelFigure.horizontalSpan = 1;
			constraintFFigureSetVariableNameLabelFigure.verticalSpan = 1;
			constraintFFigureSetVariableNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureSetVariableNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureSetVariableNameLabelFigure,
					constraintFFigureSetVariableNameLabelFigure);

			fFigureSetVariableActionCompartment = new RectangleFigure();
			fFigureSetVariableActionCompartment.setFill(false);
			fFigureSetVariableActionCompartment.setOutline(false);

			GridData constraintFFigureSetVariableActionCompartment = new GridData();
			constraintFFigureSetVariableActionCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureSetVariableActionCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureSetVariableActionCompartment.horizontalIndent = 0;
			constraintFFigureSetVariableActionCompartment.horizontalSpan = 1;
			constraintFFigureSetVariableActionCompartment.verticalSpan = 1;
			constraintFFigureSetVariableActionCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureSetVariableActionCompartment.grabExcessVerticalSpace = true;
			this.add(fFigureSetVariableActionCompartment,
					constraintFFigureSetVariableActionCompartment);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureSetVariableNameLabelFigure() {
			return fFigureSetVariableNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureSetVariableActionCompartment() {
			return fFigureSetVariableActionCompartment;
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

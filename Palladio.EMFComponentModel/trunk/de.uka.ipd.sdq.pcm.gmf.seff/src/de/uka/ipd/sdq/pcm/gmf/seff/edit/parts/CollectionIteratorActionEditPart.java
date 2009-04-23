/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
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
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.SWT;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.CollectionIteratorActionCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.CollectionIteratorActionItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;

/**
 * @generated
 */
public class CollectionIteratorActionEditPart extends ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3013;

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
	public CollectionIteratorActionEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy());
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new CollectionIteratorActionItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new CollectionIteratorActionCanonicalEditPolicy());
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
		CollectionIteratorFigure figure = new CollectionIteratorFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public CollectionIteratorFigure getPrimaryShape() {
		return (CollectionIteratorFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof CollectionIteratorActionEntityNameEditPart) {
			((CollectionIteratorActionEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureCollectionIteratorNameLabelFigure());
			return true;
		}
		if (childEditPart instanceof CollectionIteratorParameterLabelEditPart) {
			((CollectionIteratorParameterLabelEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureCollectionIteratorParameterLabelFigure());
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
				.getType(CollectionIteratorActionEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public class CollectionIteratorFigure extends RoundedRectangle {
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCollectionIteratorNameLabelFigure;
		/**
		 * @generated
		 */
		private WrappingLabel fFigureCollectionIteratorParameterLabelFigure;

		/**
		 * @generated
		 */
		public CollectionIteratorFigure() {

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

			WrappingLabel collectionIteratorStereotype0 = new WrappingLabel();
			collectionIteratorStereotype0
					.setText("<<CollectionIteratorAction>>");
			collectionIteratorStereotype0.setBorder(new MarginBorder(
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(2), getMapMode().DPtoLP(0)));

			GridData constraintCollectionIteratorStereotype0 = new GridData();
			constraintCollectionIteratorStereotype0.verticalAlignment = GridData.CENTER;
			constraintCollectionIteratorStereotype0.horizontalAlignment = GridData.CENTER;
			constraintCollectionIteratorStereotype0.horizontalIndent = 0;
			constraintCollectionIteratorStereotype0.horizontalSpan = 1;
			constraintCollectionIteratorStereotype0.verticalSpan = 1;
			constraintCollectionIteratorStereotype0.grabExcessHorizontalSpace = false;
			constraintCollectionIteratorStereotype0.grabExcessVerticalSpace = false;
			this.add(collectionIteratorStereotype0,
					constraintCollectionIteratorStereotype0);

			fFigureCollectionIteratorNameLabelFigure = new WrappingLabel();
			fFigureCollectionIteratorNameLabelFigure.setText("myLoop");
			fFigureCollectionIteratorNameLabelFigure
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureCollectionIteratorNameLabelFigure = new GridData();
			constraintFFigureCollectionIteratorNameLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureCollectionIteratorNameLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureCollectionIteratorNameLabelFigure.horizontalIndent = 0;
			constraintFFigureCollectionIteratorNameLabelFigure.horizontalSpan = 1;
			constraintFFigureCollectionIteratorNameLabelFigure.verticalSpan = 1;
			constraintFFigureCollectionIteratorNameLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureCollectionIteratorNameLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureCollectionIteratorNameLabelFigure,
					constraintFFigureCollectionIteratorNameLabelFigure);

			fFigureCollectionIteratorParameterLabelFigure = new WrappingLabel();
			fFigureCollectionIteratorParameterLabelFigure.setText("");
			fFigureCollectionIteratorParameterLabelFigure
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureCollectionIteratorParameterLabelFigure = new GridData();
			constraintFFigureCollectionIteratorParameterLabelFigure.verticalAlignment = GridData.CENTER;
			constraintFFigureCollectionIteratorParameterLabelFigure.horizontalAlignment = GridData.CENTER;
			constraintFFigureCollectionIteratorParameterLabelFigure.horizontalIndent = 0;
			constraintFFigureCollectionIteratorParameterLabelFigure.horizontalSpan = 1;
			constraintFFigureCollectionIteratorParameterLabelFigure.verticalSpan = 1;
			constraintFFigureCollectionIteratorParameterLabelFigure.grabExcessHorizontalSpace = false;
			constraintFFigureCollectionIteratorParameterLabelFigure.grabExcessVerticalSpace = false;
			this.add(fFigureCollectionIteratorParameterLabelFigure,
					constraintFFigureCollectionIteratorParameterLabelFigure);

		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCollectionIteratorNameLabelFigure() {
			return fFigureCollectionIteratorNameLabelFigure;
		}

		/**
		 * @generated
		 */
		public WrappingLabel getFigureCollectionIteratorParameterLabelFigure() {
			return fFigureCollectionIteratorParameterLabelFigure;
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

		@Override
		public void add(IFigure figure, Object constraint, int index) {
			Object newConstraint = constraint;
			if (newConstraint == null) {
				GridData layout = new GridData();
				layout.grabExcessHorizontalSpace = true;
				layout.grabExcessVerticalSpace = true;
				layout.horizontalAlignment = SWT.FILL;
				layout.verticalAlignment = SWT.FILL;
				layout.horizontalSpan = 1;
				layout.verticalSpan = 1;

				newConstraint = layout;
			}
			super.add(figure, newConstraint, index);
		}
	}

}

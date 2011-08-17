/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.parts;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.GridLayout;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.MarginBorder;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.draw2d.Shape;
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
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.RecoveryBlockAlternativeBehaviourItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.part.PalladioComponentModelVisualIDRegistry;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

/**
 * @generated
 */
public class RecoveryBlockAlternativeBehaviourEditPart extends
		ShapeNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 3052;

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
	public RecoveryBlockAlternativeBehaviourEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RecoveryBlockAlternativeBehaviourItemSemanticEditPolicy());
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
		RecoveryBlockAlternativeBehaviourFigure figure = new RecoveryBlockAlternativeBehaviourFigure();
		return primaryShape = figure;
	}

	/**
	 * @generated
	 */
	public RecoveryBlockAlternativeBehaviourFigure getPrimaryShape() {
		return (RecoveryBlockAlternativeBehaviourFigure) primaryShape;
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RecoveryBlockAlternativeBehaviourEntityNameEditPart) {
			((RecoveryBlockAlternativeBehaviourEntityNameEditPart) childEditPart)
					.setLabel(getPrimaryShape()
							.getFigureRecoveryBlockAlternativeBehaviourNameLabel());
			return true;
		}
		if (childEditPart instanceof RecoveryBlockAlternativeBehaviourAlternativeBehaviourCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRecoveryBlockAlternativeBehaviourCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.add(((RecoveryBlockAlternativeBehaviourAlternativeBehaviourCompartmentEditPart) childEditPart)
							.getFigure());
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected boolean removeFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof RecoveryBlockAlternativeBehaviourEntityNameEditPart) {
			return true;
		}
		if (childEditPart instanceof RecoveryBlockAlternativeBehaviourAlternativeBehaviourCompartmentEditPart) {
			IFigure pane = getPrimaryShape()
					.getFigureRecoveryBlockAlternativeBehaviourCompartment();
			setupContentPane(pane); // FIXME each comparment should handle his content pane in his own way 
			pane
					.remove(((RecoveryBlockAlternativeBehaviourAlternativeBehaviourCompartmentEditPart) childEditPart)
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
		if (editPart instanceof RecoveryBlockAlternativeBehaviourAlternativeBehaviourCompartmentEditPart) {
			return getPrimaryShape()
					.getFigureRecoveryBlockAlternativeBehaviourCompartment();
		}
		return getContentPane();
	}

	/**
	 * @generated
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(40, 40);
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
			layout.setSpacing(5);
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
	protected void setForegroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setForegroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setBackgroundColor(Color color) {
		if (primaryShape != null) {
			primaryShape.setBackgroundColor(color);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineWidth(int width) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineWidth(width);
		}
	}

	/**
	 * @generated
	 */
	protected void setLineType(int style) {
		if (primaryShape instanceof Shape) {
			((Shape) primaryShape).setLineStyle(style);
		}
	}

	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PalladioComponentModelVisualIDRegistry
				.getType(RecoveryBlockAlternativeBehaviourEntityNameEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSource() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviourNextAlternative_RecoveryBlockAlternativeBehaviour_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnSourceAndTarget(
			IGraphicalEditPart targetEditPart) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (targetEditPart instanceof de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.RecoveryBlockAlternativeBehaviourEditPart) {
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviourNextAlternative_RecoveryBlockAlternativeBehaviour_4002);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForTarget(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviourNextAlternative_RecoveryBlockAlternativeBehaviour_4002) {
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviour_3052);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMARelTypesOnTarget() {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		types
				.add(PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviourNextAlternative_RecoveryBlockAlternativeBehaviour_4002);
		return types;
	}

	/**
	 * @generated
	 */
	public List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/getMATypesForSource(
			IElementType relationshipType) {
		List/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/types = new ArrayList/*<org.eclipse.gmf.runtime.emf.type.core.IElementType>*/();
		if (relationshipType == PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviourNextAlternative_RecoveryBlockAlternativeBehaviour_4002) {
			types
					.add(PalladioComponentModelElementTypes.RecoveryBlockAlternativeBehaviour_3052);
		}
		return types;
	}

	/**
	 * @generated
	 */
	public class RecoveryBlockAlternativeBehaviourFigure extends
			RectangleFigure {

		/**
		 * @generated
		 */
		private WrappingLabel fFigureRecoveryBlockAlternativeBehaviourNameLabel;

		/**
		 * @generated
		 */
		private RectangleFigure fFigureRecoveryBlockAlternativeBehaviourCompartment;

		/**
		 * @generated
		 */
		public RecoveryBlockAlternativeBehaviourFigure() {

			GridLayout layoutThis = new GridLayout();
			layoutThis.numColumns = 1;
			layoutThis.makeColumnsEqualWidth = true;
			layoutThis.horizontalSpacing = 0;
			layoutThis.verticalSpacing = 0;
			layoutThis.marginWidth = 0;
			layoutThis.marginHeight = 0;
			this.setLayoutManager(layoutThis);

			this.setLineWidth(1);
			this.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
					getMapMode().DPtoLP(0)));
			createContents();
		}

		/**
		 * @generated
		 */
		private void createContents() {

			WrappingLabel recoveryBlockAlternativeBehaviourStereotype0 = new WrappingLabel();
			recoveryBlockAlternativeBehaviourStereotype0
					.setText("<<RecoveryBlockAlternativeBehaviour>>");
			recoveryBlockAlternativeBehaviourStereotype0
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintRecoveryBlockAlternativeBehaviourStereotype0 = new GridData();
			constraintRecoveryBlockAlternativeBehaviourStereotype0.verticalAlignment = GridData.CENTER;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.horizontalAlignment = GridData.CENTER;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.horizontalIndent = 0;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.horizontalSpan = 1;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.verticalSpan = 1;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.grabExcessHorizontalSpace = false;
			constraintRecoveryBlockAlternativeBehaviourStereotype0.grabExcessVerticalSpace = false;
			this.add(recoveryBlockAlternativeBehaviourStereotype0,
					constraintRecoveryBlockAlternativeBehaviourStereotype0);

			fFigureRecoveryBlockAlternativeBehaviourNameLabel = new WrappingLabel();
			fFigureRecoveryBlockAlternativeBehaviourNameLabel.setText("");
			fFigureRecoveryBlockAlternativeBehaviourNameLabel
					.setBorder(new MarginBorder(getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0), getMapMode().DPtoLP(2),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel = new GridData();
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.verticalAlignment = GridData.CENTER;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.horizontalAlignment = GridData.CENTER;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.horizontalIndent = 0;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.horizontalSpan = 1;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.verticalSpan = 1;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.grabExcessHorizontalSpace = false;
			constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel.grabExcessVerticalSpace = false;
			this
					.add(fFigureRecoveryBlockAlternativeBehaviourNameLabel,
							constraintFFigureRecoveryBlockAlternativeBehaviourNameLabel);

			fFigureRecoveryBlockAlternativeBehaviourCompartment = new RectangleFigure();
			fFigureRecoveryBlockAlternativeBehaviourCompartment.setFill(false);
			fFigureRecoveryBlockAlternativeBehaviourCompartment
					.setOutline(false);
			fFigureRecoveryBlockAlternativeBehaviourCompartment.setLineWidth(1);
			fFigureRecoveryBlockAlternativeBehaviourCompartment
					.setMinimumSize(new Dimension(getMapMode().DPtoLP(0),
							getMapMode().DPtoLP(0)));

			GridData constraintFFigureRecoveryBlockAlternativeBehaviourCompartment = new GridData();
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.verticalAlignment = GridData.FILL;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.horizontalAlignment = GridData.FILL;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.horizontalIndent = 0;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.horizontalSpan = 1;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.verticalSpan = 1;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.grabExcessHorizontalSpace = true;
			constraintFFigureRecoveryBlockAlternativeBehaviourCompartment.grabExcessVerticalSpace = true;
			this
					.add(fFigureRecoveryBlockAlternativeBehaviourCompartment,
							constraintFFigureRecoveryBlockAlternativeBehaviourCompartment);

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

		/**
		 * @generated
		 */
		public WrappingLabel getFigureRecoveryBlockAlternativeBehaviourNameLabel() {
			return fFigureRecoveryBlockAlternativeBehaviourNameLabel;
		}

		/**
		 * @generated
		 */
		public RectangleFigure getFigureRecoveryBlockAlternativeBehaviourCompartment() {
			return fFigureRecoveryBlockAlternativeBehaviourCompartment;
		}

	}

}

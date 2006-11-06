/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.parts;

import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.PcmExtNodeLabelHostLayoutEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.ReqRoleCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.ReqRoleGraphicalNodeEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.ReqRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;

import java.util.Iterator;

import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.RoleCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.RoleItemSemanticEditPolicy;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;

import org.eclipse.gef.commands.Command;

import org.eclipse.gef.editparts.LayerManager;

import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;

import org.eclipse.gef.requests.CreateRequest;

import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;

import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;

import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated NOT
 */
public class ReqRoleEditPart extends AbstractBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2002;

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
	public ReqRoleEditPart(View view) {
		super(view);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ReqRoleItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				getPrimaryDragEditPolicy());

		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new RoleCanonicalEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, createLayoutEditPolicy());
	}

	/**
	 * @generated
	 */
	protected LayoutEditPolicy createLayoutEditPolicy() {
		LayoutEditPolicy lep = new LayoutEditPolicy() {

			protected void decorateChild(EditPart child) {
				if (isExternalLabel(child)) {
					return;
				}
				super.decorateChild(child);
			}

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
		PcmExtNodeLabelHostLayoutEditPolicy xlep = new PcmExtNodeLabelHostLayoutEditPolicy() {

			protected boolean isExternalLabel(EditPart editPart) {
				return ReqRoleEditPart.this.isExternalLabel(editPart);
			}
		};
		xlep.setRealLayoutEditPolicy(lep);
		return xlep;
	}

	/**
	 * @generated
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new Ellipse();
	}

	/**
	 * @generated
	 */
	public Ellipse getPrimaryShape() {
		return (Ellipse) primaryShape;
	}

	/**
	 * @generated NOT
	 */
	protected NodeFigure createNodePlate() {
		DefaultSizeNodeFigure result = new DefaultSizeNodeFigure(getMapMode()
				.DPtoLP(20), getMapMode().DPtoLP(20));
		//FIXME: workaround for #154536
		result.getBounds().setSize(result.getPreferredSize());
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
		return getChildBySemanticHint(PcmVisualIDRegistry
				.getType(ReqRoleLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof ReqRoleLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated
	 */
	protected IFigure getExternalLabelsContainer() {
		LayerManager root = (LayerManager) getRoot();
		return root.getLayer(PcmEditPartFactory.EXTERNAL_NODE_LABELS_LAYER);
	}

	/**
	 * @generated
	 */
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart)
					.getFigure();
			getExternalLabelsContainer().add(labelFigure);
			return;
		}
		super.addChildVisual(childEditPart, -1);
	}

	/**
	 * @generated
	 */
	protected void removeChildVisual(EditPart childEditPart) {
		if (isExternalLabel(childEditPart)) {
			IFigure labelFigure = ((GraphicalEditPart) childEditPart)
					.getFigure();
			getExternalLabelsContainer().remove(labelFigure);
			return;
		}
		super.removeChildVisual(childEditPart);
	}

	/**
	 * @generated
	 */
	public void removeNotify() {
		for (Iterator it = getChildren().iterator(); it.hasNext();) {
			EditPart childEditPart = (EditPart) it.next();
			if (isExternalLabel(childEditPart)) {
				IFigure labelFigure = ((GraphicalEditPart) childEditPart)
						.getFigure();
				getExternalLabelsContainer().remove(labelFigure);
			}
		}
		super.removeNotify();
	}

}

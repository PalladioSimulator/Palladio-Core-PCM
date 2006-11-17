/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.parts;

import java.util.Iterator;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RectangleFigure;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editparts.LayerManager;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.system.AbstractRotatingBorderItemEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.BallOrSocketFigure;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.PcmExtNodeLabelHostLayoutEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.SystemProvidedRoleCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.SystemProvidedRoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;

/**
 * @generated NOT
 */
public class SystemProvidedRoleEditPart extends AbstractRotatingBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 1004;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public SystemProvidedRoleEditPart(View view) {
		super(view,60,30);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new SystemProvidedRoleItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new SystemProvidedRoleCanonicalEditPolicy());
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
				return SystemProvidedRoleEditPart.this
						.isExternalLabel(editPart);
			}
		};
		xlep.setRealLayoutEditPolicy(lep);
		return xlep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		Figure fig = new BallOrSocketFigure(BallOrSocketFigure.BALL_TYPE);
		return primaryShape = fig;
	}

	/**
	 * @generated NOT
	 */
	public RectangleFigure getPrimaryShape() {
		return (RectangleFigure) primaryShape;
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
				.getType(SystemProvidedRoleLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof SystemProvidedRoleLabelEditPart) {
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

/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.parts;

import java.util.Iterator;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.LayoutEditPolicy;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.system.AbstractRotatingBorderItemEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.BallOrSocketFigure;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.PcmExtNodeLabelHostLayoutEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.RoleCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.edit.policies.RoleItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.system.part.PcmVisualIDRegistry;

/**
 * @generated NOT
 */
public class RoleEditPart extends AbstractRotatingBorderItemEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 2001;

	/**
	 * @generated
	 */
	protected IFigure primaryShape;

	/**
	 * @generated
	 */
	public RoleEditPart(View view) {
		super(view,30,16);
	}

	/**
	 * @generated NOT
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RoleItemSemanticEditPolicy());
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
				return RoleEditPart.this.isExternalLabel(editPart);
			}
		};
		xlep.setRealLayoutEditPolicy(lep);
		return xlep;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure createNodeShape() {
		return primaryShape = new BallOrSocketFigure(BallOrSocketFigure.BALL_TYPE);
	}

	/**
	 * @generated NOT
	 */
	public BallOrSocketFigure getPrimaryShape() {
		return (BallOrSocketFigure) primaryShape;
	}


	/**
	 * @generated
	 */
	public EditPart getPrimaryChildEditPart() {
		return getChildBySemanticHint(PcmVisualIDRegistry
				.getType(RoleLabelEditPart.VISUAL_ID));
	}

	/**
	 * @generated
	 */
	protected boolean isExternalLabel(EditPart childEditPart) {
		if (childEditPart instanceof RoleLabelEditPart) {
			return true;
		}
		return false;
	}

	/**
	 * @generated NOT
	 */
	protected IFigure getExternalLabelsContainer() {
//		LayerManager root = (LayerManager) getRoot();
//		return root.getLayer(PcmEditPartFactory.EXTERNAL_NODE_LABELS_LAYER);
		IFigure fig = ((GraphicalEditPart)getParent().getParent()).getFigure();
		return ((ShapeCompartmentFigure)fig).getContentPane();
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

	protected Point getAnchorPoint(Point reference) {
		Rectangle r = Rectangle.SINGLETON;
		r.setBounds(getPrimaryShape().getBallBounds());
		r.translate(-1, -1);
		r.resize(1, 1);
		getContentPane().translateToAbsolute(r);
		
		Point ref = r.getCenter().negate().translate(reference);
		
		if (ref.x == 0)
			return new Point(reference.x, (ref.y > 0) ? r.bottom() : r.y);
		if (ref.y == 0)
			return new Point((ref.x > 0) ? r.right() : r.x, reference.y);
		
		float dx = (ref.x > 0) ? 0.5f : -0.5f;
		float dy = (ref.y > 0) ? 0.5f : -0.5f;
		  
		// ref.x, ref.y, r.width, r.height != 0 => safe to proceed
		  
		float k = (float)(ref.y * r.width) / (ref.x * r.height);
		k = k * k;
		  
		return r.getCenter().translate((int)(r.width * dx / Math.sqrt(1 + k)),
		                                (int)(r.height * dy / Math.sqrt(1 + 1 / k)));
	}		
}

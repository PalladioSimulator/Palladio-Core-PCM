/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.ResourceRequiredRoleItemSemanticEditPolicy;

/**
 * @generated
 */
public class ResourceRequiredRoleEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4105;

	/**
	 * @generated
	 */
	public ResourceRequiredRoleEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ResourceRequiredRoleItemSemanticEditPolicy());
	}

	/**
	 * @generated
	 */
	protected boolean addFixedChild(EditPart childEditPart) {
		if (childEditPart instanceof WrapLabel2EditPart) {
			((WrapLabel2EditPart) childEditPart).setLabel(getPrimaryShape()
					.getFigureResourceRequiresStereotypeLabelFigure());
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
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model
	 * so you may safely remove <i>generated</i> tag and modify it.
	 * 
	 * @generated
	 */

	protected Connection createConnectionFigure() {
		return new ResourceRequiredRoleFigure();
	}

	/**
	 * @generated
	 */
	public ResourceRequiredRoleFigure getPrimaryShape() {
		return (ResourceRequiredRoleFigure) getFigure();
	}

	/**
	 * @generated
	 */
	public class ResourceRequiredRoleFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrapLabel fFigureResourceRequiresStereotypeLabelFigure;

		/**
		 * @generated
		 */
		public ResourceRequiredRoleFigure() {

			createContents();
			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * @generated
		 */
		private void createContents() {

			fFigureResourceRequiresStereotypeLabelFigure = new WrapLabel();
			fFigureResourceRequiresStereotypeLabelFigure
					.setText("<<RequiredResource>>");

			this.add(fFigureResourceRequiresStereotypeLabelFigure);

		}

		/**
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

		/**
		 * @generated
		 */
		public WrapLabel getFigureResourceRequiresStereotypeLabelFigure() {
			return fFigureResourceRequiresStereotypeLabelFigure;
		}

	}

}

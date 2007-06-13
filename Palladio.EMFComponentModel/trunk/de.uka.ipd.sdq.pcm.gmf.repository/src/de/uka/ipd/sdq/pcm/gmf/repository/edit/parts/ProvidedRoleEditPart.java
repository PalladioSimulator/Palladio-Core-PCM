/*
 * Copyright 2007, IPD, SDQ, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.repository.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.repository.edit.policies.ProvidedRoleItemSemanticEditPolicy;

/**
 * @generated
 */
public class ProvidedRoleEditPart extends ConnectionNodeEditPart {

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 4101;

	/**
	 * @generated
	 */
	public ProvidedRoleEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ProvidedRoleItemSemanticEditPolicy());
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

		return new ProvidedRoleFigure();
	}

	/**
	 * @generated
	 */
	public class ProvidedRoleFigure extends PolylineConnectionEx {

		/**
		 * @generated
		 */
		private WrapLabel fFigureEntityEntityName5Figure;
		/**
		 * @generated
		 */
		private WrapLabel fFigureProvidesStereotypeLabelFigure;

		/**
		 * @generated
		 */
		public ProvidedRoleFigure() {

			setTargetDecoration(createTargetDecoration());
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
		public WrapLabel getFigureEntityEntityName5Figure() {
			return fFigureEntityEntityName5Figure;
		}

		/**
		 * @generated
		 */
		public WrapLabel getFigureProvidesStereotypeLabelFigure() {
			return fFigureProvidesStereotypeLabelFigure;
		}

	}

}

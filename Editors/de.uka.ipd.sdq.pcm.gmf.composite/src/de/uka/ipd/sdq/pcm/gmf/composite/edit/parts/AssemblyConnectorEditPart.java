/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyConnectorItemSemanticEditPolicy;

/**
 * The Class AssemblyConnectorEditPart.
 *
 * @generated
 */
public class AssemblyConnectorEditPart extends ConnectionNodeEditPart implements
		ITreeBranchEditPart {

	/** The Constant VISUAL_ID. @generated */
	public static final int VISUAL_ID = 4004;

	/**
	 * Instantiates a new assembly connector edit part.
	 *
	 * @param view the view
	 * @generated
	 */
	public AssemblyConnectorEditPart(View view) {
		super(view);
	}

	/**
	 * Creates the default edit policies.
	 *
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AssemblyConnectorItemSemanticEditPolicy());
	}

	/**
	 * Creates figure for this edit part.
	 * 
	 * Body of this method does not depend on settings in generation model so you may safely remove
	 * <i>generated</i> tag and modify it.
	 *
	 * @return the connection
	 * @generated
	 */
	protected Connection createConnectionFigure() {
		return new AssemblyConnectorFigure();
	}

	/**
	 * Gets the primary shape.
	 *
	 * @return the primary shape
	 * @generated
	 */
	public AssemblyConnectorFigure getPrimaryShape() {
		return (AssemblyConnectorFigure) getFigure();
	}

	/**
	 * The Class AssemblyConnectorFigure.
	 *
	 * @generated
	 */
	public class AssemblyConnectorFigure extends PolylineConnectionEx {

		/**
		 * Instantiates a new assembly connector figure.
		 *
		 * @generated
		 */
		public AssemblyConnectorFigure() {
			this.setLineWidth(1);

			setTargetDecoration(createTargetDecoration());
		}

		/**
		 * Creates the target decoration.
		 *
		 * @return the rotatable decoration
		 * @generated
		 */
		private RotatableDecoration createTargetDecoration() {
			PolylineDecoration df = new PolylineDecoration();
			df.setLineWidth(1);
			PointList pl = new PointList();
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(-1));
			pl.addPoint(getMapMode().DPtoLP(0), getMapMode().DPtoLP(0));
			pl.addPoint(getMapMode().DPtoLP(-1), getMapMode().DPtoLP(1));
			df.setTemplate(pl);
			df.setScale(getMapMode().DPtoLP(7), getMapMode().DPtoLP(3));
			return df;
		}

	}

}

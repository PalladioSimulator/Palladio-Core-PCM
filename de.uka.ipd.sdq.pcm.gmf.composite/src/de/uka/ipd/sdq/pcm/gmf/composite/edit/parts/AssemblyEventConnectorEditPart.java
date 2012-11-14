/*
 * Copyright 2007, SDQ, IPD, Uni Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.composite.edit.parts;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.PolylineDecoration;
import org.eclipse.draw2d.RotatableDecoration;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITreeBranchEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.PolylineConnectionEx;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.gmf.composite.edit.policies.AssemblyEventConnectorItemSemanticEditPolicy;

/**
 * The Class AssemblyEventConnectorEditPart.
 *
 * @generated
 */
public class AssemblyEventConnectorEditPart extends ConnectionNodeEditPart
		implements ITreeBranchEditPart {


	/** The Constant VISUAL_ID. @generated */
	public static final int VISUAL_ID = 4007;

	/**
	 * Instantiates a new assembly event connector edit part.
	 *
	 * @param view the view
	 * @generated
	 */
	public AssemblyEventConnectorEditPart(View view) {
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
				new AssemblyEventConnectorItemSemanticEditPolicy());
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
		return new AssemblyEventConnectorFigure();
	}

	/**
	 * Gets the primary shape.
	 *
	 * @return the primary shape
	 * @generated
	 */
	public AssemblyEventConnectorFigure getPrimaryShape() {
		return (AssemblyEventConnectorFigure) getFigure();
	}

	/**
	 * The Class AssemblyEventConnectorFigure.
	 *
	 * @generated
	 */
	public class AssemblyEventConnectorFigure extends PolylineConnectionEx {

		/**
		 * Instantiates a new assembly event connector figure.
		 *
		 * @generated
		 */
		public AssemblyEventConnectorFigure() {
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
	/**
	 * This method changes the color of the connector if a FilterCondition!=true is specified
	 * 
	 * @generated not
	 */
@Override
public IFigure getFigure() {
	IFigure figure= super.getFigure();
	Color c=null;
	 if (resolveSemanticElement() instanceof AssemblyEventConnector) 
	 {
		 AssemblyEventConnector con=(AssemblyEventConnector) resolveSemanticElement();
		 if ((con.getFilterCondition__AssemblyEventConnector()!=null) &&
				 !(con.getFilterCondition__AssemblyEventConnector().getSpecification().equalsIgnoreCase("TRUE"))){
			 c=new Color(null, 170, 60, 0);
			
		 }
		 else c=new Color(null,192,192,192);
		 figure.setForegroundColor(c);
	}
	
	return figure;
}


/**
 * SemanticListener to update the color if the filter condition is changed
 * @generated not
 */
@Override
protected void addSemanticListeners() {
    super.addSemanticListeners();
    
}

/**
 * SemanticListener to update the color if the filter condition is changed
 * @generated not
 */
@Override
protected void removeSemanticListeners() {
    removeListenerFilter("SemanticModel"); //$NON-NLS-1$
}

}

package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationCanonicalEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationItemSemanticEditPolicy;

import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;

/**
 * @generated
 */
public class AllocationEditPart extends DiagramEditPart {

	/**
	 * @generated
	 */
	public static String MODEL_ID = "allocation"; //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final int VISUAL_ID = 79;

	/**
	 * @generated
	 */
	public AllocationEditPart(View view) {
		super(view);
	}

	/**
	 * @generated
	 */
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new AllocationItemSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new AllocationCanonicalEditPolicy());
	}
}

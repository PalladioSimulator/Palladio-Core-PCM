/*
 * Copyright 2007, SDQ, IPD, U KA
 */
package de.uka.ipd.sdq.pcm.gmf.allocation.edit.parts;

/**
 * @generated
 */
public class AllocationEditPart extends org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart  {

		/**
 * @generated
 */
	public final static String MODEL_ID = "allocation";  //$NON-NLS-1$
	
		/**
 * @generated
 */
	public static final int VISUAL_ID = 1000;
	
		/**
 * @generated
 */
	public AllocationEditPart(org.eclipse.gmf.runtime.notation.View view) {
		super(view);
	}
	
		/**
 * @generated
 */
	protected void createDefaultEditPolicies() {
			super.createDefaultEditPolicies();
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.SEMANTIC_ROLE, new de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationItemSemanticEditPolicy());
			installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CANONICAL_ROLE, new de.uka.ipd.sdq.pcm.gmf.allocation.edit.policies.AllocationCanonicalEditPolicy());
		installEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.CREATION_ROLE, new org.eclipse.gmf.tooling.runtime.edit.policies.reparent.CreationEditPolicyWithCustomReparent(de.uka.ipd.sdq.pcm.gmf.allocation.part.PalladioComponentModelVisualIDRegistry.TYPED_INSTANCE));
					// removeEditPolicy(org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles.POPUPBAR_ROLE);
	}
	
		
		/**
 * @generated
 */
	/*package-local*/ static class NodeLabelDragPolicy extends org.eclipse.gef.editpolicies.NonResizableEditPolicy {

		/**
 * @generated
 */
		@SuppressWarnings("rawtypes")
		protected java.util.List createSelectionHandles() {
			org.eclipse.gef.handles.MoveHandle h = new org.eclipse.gef.handles.MoveHandle((org.eclipse.gef.GraphicalEditPart) getHost());
			h.setBorder(null);
			return java.util.Collections.singletonList(h);
		}

		/**
 * @generated
 */
		public org.eclipse.gef.commands.Command getCommand(org.eclipse.gef.Request request) {
			return null;
		}

		/**
 * @generated
 */
		public boolean understandsRequest(org.eclipse.gef.Request request) {
			return false;
		}
	}



	}

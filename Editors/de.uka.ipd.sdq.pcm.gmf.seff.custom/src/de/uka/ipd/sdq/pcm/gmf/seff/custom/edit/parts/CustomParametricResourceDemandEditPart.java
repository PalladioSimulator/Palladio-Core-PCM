/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ListItemComponentEditPolicy;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.dialogs.OpenStoExDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.ParametricResourceDemandEditPart;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.PalladioComponentModelTextNonResizableEditPolicy;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.policies.ParametricResourceDemandItemSemanticEditPolicy;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;

public class CustomParametricResourceDemandEditPart extends ParametricResourceDemandEditPart {

	private EContentAdapter changeListener = null;
	private EObject adaptedElement = null;

	public CustomParametricResourceDemandEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new ParametricResourceDemandItemSemanticEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new PalladioComponentModelTextNonResizableEditPolicy());
		installEditPolicy(EditPolicy.COMPONENT_ROLE,
				new ListItemComponentEditPolicy());
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		installEditPolicy(
				EditPolicyRoles.OPEN_ROLE,
				new OpenStoExDialog(
						SeffPerformancePackage.eINSTANCE
								.getParametricResourceDemand_Specification_ParametericResourceDemand()));
	}

	@Override
	protected String getLabelText() {
		String text = null;
		if (resolveSemanticElement() instanceof ParametricResourceDemand) {
			ParametricResourceDemand demand = (ParametricResourceDemand) resolveSemanticElement();
			if (demand.getRequiredResource_ParametricResourceDemand() != null) {
				text = new PCMStoExPrettyPrintVisitor().prettyPrint(demand
						.getSpecification_ParametericResourceDemand()
						.getExpression());
				if (text == null)
					text = "";
				else
					text += " ";
				text += "<"
						+ demand.getRequiredResource_ParametricResourceDemand()
								.getEntityName() + ">";
			}
		}
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		ParametricResourceDemand element = (ParametricResourceDemand) resolveSemanticElement();
		changeListener = new EContentAdapter() {

			@Override
			public void notifyChanged(Notification notification) {
				super.notifyChanged(notification);
				refreshLabel();
			}

		};
		adaptedElement = element;
		element.eAdapters().add(changeListener);
	}

	@Override
	protected void removeSemanticListeners() {
		adaptedElement.eAdapters().remove(changeListener);
	}

}

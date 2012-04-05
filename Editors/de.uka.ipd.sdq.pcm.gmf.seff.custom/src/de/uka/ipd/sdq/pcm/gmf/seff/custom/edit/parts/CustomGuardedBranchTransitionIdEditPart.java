/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.custom.edit.parts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.NonResizableEditPolicy;
import org.eclipse.gef.handles.NonResizableHandleKit;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.LabelDirectEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramColorRegistry;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.dialogs.seff.OpenBranchConditionDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.parts.GuardedBranchTransitionIdEditPart;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;


public class CustomGuardedBranchTransitionIdEditPart extends GuardedBranchTransitionIdEditPart {


	public CustomGuardedBranchTransitionIdEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.DIRECT_EDIT_ROLE,
				new LabelDirectEditPolicy());
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new NonResizableEditPolicy() {

					protected List<Object> createSelectionHandles() {
						List<Object> handles = new ArrayList<Object>();
						NonResizableHandleKit.addMoveHandle(
								(GraphicalEditPart) getHost(), handles);
						return handles;
					}

					public Command getCommand(Request request) {
						return null;
					}

					public boolean understandsRequest(Request request) {
						return false;
					}
				});
		installEditPolicy(EditPolicyRoles.OPEN_ROLE,
				new OpenBranchConditionDialog());
	}

	@Override
	protected String getLabelText() {
		String text = "Cond: ";
		GuardedBranchTransition transition = (GuardedBranchTransition) resolveSemanticElement();
		if (transition != null
				&& transition.getBranchCondition_GuardedBranchTransition() != null
				&& transition.getBranchCondition_GuardedBranchTransition()
						.getSpecification() != null)
			text += transition.getBranchCondition_GuardedBranchTransition()
					.getSpecification();
		if (text == null || text.length() == 0) {
			text = getLabelTextHelper(getFigure());
		}
		return text;
	}

	@Override
	protected void addSemanticListeners() {
		GuardedBranchTransition transition = (GuardedBranchTransition) resolveSemanticElement();
		addListenerFilter(
				"SemanticModel", this, transition.getBranchCondition_GuardedBranchTransition()); //$NON-NLS-1$
	}

	@Override
	protected void removeSemanticListeners() {
		removeListenerFilter("SemanticModel"); //$NON-NLS-1$
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		Object feature = event.getFeature();
		if (NotationPackage.eINSTANCE.getFontStyle_FontColor().equals(feature)) {
			Integer c = (Integer) event.getNewValue();
			setFontColor(DiagramColorRegistry.getInstance().getColor(c));
		} else if (NotationPackage.eINSTANCE.getFontStyle_Underline().equals(
				feature)) {
			refreshUnderline();
		} else if (NotationPackage.eINSTANCE.getFontStyle_StrikeThrough()
				.equals(feature)) {
			refreshStrikeThrough();
		} else if (NotationPackage.eINSTANCE.getFontStyle_FontHeight().equals(
				feature)
				|| NotationPackage.eINSTANCE.getFontStyle_FontName().equals(
						feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Bold()
						.equals(feature)
				|| NotationPackage.eINSTANCE.getFontStyle_Italic().equals(
						feature)) {
			refreshFont();
		} else {
			refreshLabel();
		}
		super.handleNotificationEvent(event);
	}
}

/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.gmf.runtime.notation.View;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class ParametricResourceDemandItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getDestroyElementCommand(DestroyElementRequest req) {
		return getMSLWrapper(new DestroyElementCommand(req) {

			protected EObject getElementToDestroy() {
				View view = (View) getHost().getModel();
				EAnnotation annotation = view.getEAnnotation("Shortcut"); //$NON-NLS-1$
				if (annotation != null) {
					return view;
				}
				return super.getElementToDestroy();
			}

		});
	}

	/**
	 * @generated
	 */
	protected Command getCreateRelationshipCommand(CreateRelationshipRequest req) {
		if (PcmElementTypes.AbstractResourceDemandingActionResourceDemand_Action_3003 == req
				.getElementType()) {
			return req.getTarget() == null ? null
					: getCreateCompleteIncomingAbstractResourceDemandingAction_ResourceDemand_Action3003Command(req);
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingAbstractResourceDemandingAction_ResourceDemand_Action3003Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof AbstractResourceDemandingAction)) {
			return UnexecutableCommand.INSTANCE;
		}
		AbstractResourceDemandingAction element = (AbstractResourceDemandingAction) req
				.getSource();
		if (element.getResourceDemand_Action().contains(req.getTarget())) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(
				req.getSource(),
				SeffPackage.eINSTANCE
						.getAbstractResourceDemandingAction_ResourceDemand_Action(),
				req.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}
}

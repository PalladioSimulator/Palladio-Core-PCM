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

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.gef.commands.UnexecutableCommand;

import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;

/**
 * @generated
 */
public class LoopActionItemSemanticEditPolicy extends
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
		if (PcmElementTypes.AbstractActionSuccessor_AbstractAction_3001 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingAbstractAction_Successor_AbstractAction3001Command(req)
					: getCreateCompleteIncomingAbstractAction_Successor_AbstractAction3001Command(req);
		}
		if (PcmElementTypes.AbstractResourceDemandingActionResourceDemand_Action_3003 == req
				.getElementType()) {
			return req.getTarget() == null ? getCreateStartOutgoingAbstractResourceDemandingAction_ResourceDemand_Action3003Command(req)
					: null;
		}
		return super.getCreateRelationshipCommand(req);
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingAbstractAction_Successor_AbstractAction3001Command(
			CreateRelationshipRequest req) {
		AbstractAction element = (AbstractAction) getSemanticElement();
		if (element.getSuccessor_AbstractAction() != null) {
			return UnexecutableCommand.INSTANCE;
		}

		return new Command() {
		};
	}

	/**
	 * @generated
	 */
	protected Command getCreateCompleteIncomingAbstractAction_Successor_AbstractAction3001Command(
			CreateRelationshipRequest req) {
		if (!(req.getSource() instanceof AbstractAction)) {
			return UnexecutableCommand.INSTANCE;
		}
		AbstractAction element = (AbstractAction) req.getSource();
		if (element.getSuccessor_AbstractAction() != null) {
			return UnexecutableCommand.INSTANCE;
		}
		SetRequest setReq = new SetRequest(req.getSource(),
				SeffPackage.eINSTANCE
						.getAbstractAction_Successor_AbstractAction(), req
						.getTarget());
		return getMSLWrapper(new SetValueCommand(setReq));
	}

	/**
	 * @generated
	 */
	protected Command getCreateStartOutgoingAbstractResourceDemandingAction_ResourceDemand_Action3003Command(
			CreateRelationshipRequest req) {

		return new Command() {
		};
	}
}

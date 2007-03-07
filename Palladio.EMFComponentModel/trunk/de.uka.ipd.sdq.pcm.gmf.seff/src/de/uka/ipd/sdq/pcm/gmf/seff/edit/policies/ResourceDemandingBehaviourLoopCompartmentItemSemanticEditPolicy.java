/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.BranchActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ExternalCallAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.LoopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StartAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StopAction2CreateCommand;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ResourceDemandingBehaviourLoopCompartmentItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.StartAction_3004 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new StartAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.StopAction_3005 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new StopAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.LoopAction_3006 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new LoopAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.InternalAction_3007 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new InternalActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.BranchAction_3009 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new BranchActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ExternalCallAction_3012 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new ExternalCallAction2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}

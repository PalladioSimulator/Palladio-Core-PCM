/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AcquireAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.BranchActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.CollectionIteratorActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ExternalCallAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.LoopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ReleaseActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.SetVariableActionCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StartAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

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
			return getGEFWrapper(new StartAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.StopAction_3005 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new StopAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.LoopAction_3006 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new LoopAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.InternalAction_3007 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new InternalActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.BranchAction_3009 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new BranchActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ExternalCallAction_3012 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new ExternalCallAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.CollectionIteratorAction_3013 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new CollectionIteratorActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.AcquireAction_3026 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new AcquireAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ReleaseAction_3020 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new ReleaseActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ForkAction_3023 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new ForkActionCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.SetVariableAction_3024 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new SetVariableActionCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}

/*
 * Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.AcquireAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.BranchAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.CollectionIteratorAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ExternalCallAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ForkAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.InternalAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.LoopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.ReleaseAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.SetVariableAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StartAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.edit.commands.StopAction2CreateCommand;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class ResourceDemandingBehaviourBehaviourCompartment2ItemSemanticEditPolicy
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
			return getGEFWrapper(new InternalAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.BranchAction_3009 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new BranchAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ExternalCallAction_3012 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new ExternalCallAction2CreateCommand(req));
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
			return getGEFWrapper(new ReleaseAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.ForkAction_3023 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new ForkAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.CollectionIteratorAction_3013 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new CollectionIteratorAction2CreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.SetVariableAction_3024 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getGEFWrapper(new SetVariableAction2CreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}

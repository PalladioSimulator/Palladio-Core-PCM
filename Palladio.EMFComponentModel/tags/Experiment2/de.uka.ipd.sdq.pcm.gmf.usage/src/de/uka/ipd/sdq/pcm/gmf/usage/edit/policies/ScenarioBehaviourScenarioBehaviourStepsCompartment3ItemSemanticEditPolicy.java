/*
 *Copyright 2007, SDQ, IPD, University of Karlsruhe
 */
package de.uka.ipd.sdq.pcm.gmf.usage.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.BranchCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.EntryLevelSystemCallCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.LoopCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.StartCreateCommand;
import de.uka.ipd.sdq.pcm.gmf.usage.edit.commands.StopCreateCommand;

import de.uka.ipd.sdq.pcm.gmf.usage.providers.PalladioComponentModelElementTypes;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

/**
 * @generated
 */
public class ScenarioBehaviourScenarioBehaviourStepsCompartment3ItemSemanticEditPolicy
		extends PalladioComponentModelBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PalladioComponentModelElementTypes.Start_3001 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UsagemodelPackage.eINSTANCE
						.getScenarioBehaviour_Actions_ScenarioBehaviour());
			}
			return getGEFWrapper(new StartCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.Stop_3002 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UsagemodelPackage.eINSTANCE
						.getScenarioBehaviour_Actions_ScenarioBehaviour());
			}
			return getGEFWrapper(new StopCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.EntryLevelSystemCall_3003 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UsagemodelPackage.eINSTANCE
						.getScenarioBehaviour_Actions_ScenarioBehaviour());
			}
			return getGEFWrapper(new EntryLevelSystemCallCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.Loop_3005 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UsagemodelPackage.eINSTANCE
						.getScenarioBehaviour_Actions_ScenarioBehaviour());
			}
			return getGEFWrapper(new LoopCreateCommand(req));
		}
		if (PalladioComponentModelElementTypes.Branch_3008 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(UsagemodelPackage.eINSTANCE
						.getScenarioBehaviour_Actions_ScenarioBehaviour());
			}
			return getGEFWrapper(new BranchCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}
}

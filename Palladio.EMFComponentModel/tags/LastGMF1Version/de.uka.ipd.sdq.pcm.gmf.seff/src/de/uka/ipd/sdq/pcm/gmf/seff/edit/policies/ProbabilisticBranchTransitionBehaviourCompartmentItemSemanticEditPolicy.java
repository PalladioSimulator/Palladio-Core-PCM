/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @generated
 */
public class ProbabilisticBranchTransitionBehaviourCompartmentItemSemanticEditPolicy
		extends PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.ResourceDemandingBehaviour_2011 == req
				.getElementType()) {
			ProbabilisticBranchTransition container = (ProbabilisticBranchTransition) (req
					.getContainer() instanceof View ? ((View) req
					.getContainer()).getElement() : req.getContainer());
			if (container.getBranchBehaviour_BranchTransition() != null) {
				return super.getCreateCommand(req);
			}
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getAbstractBranchTransition_BranchBehaviour_BranchTransition());
			}
			return getMSLWrapper(new CreateResourceDemandingBehaviour_2011Command(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateResourceDemandingBehaviour_2011Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateResourceDemandingBehaviour_2011Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getProbabilisticBranchTransition();
		};

		/**
		 * @generated
		 */
		protected EObject getElementToEdit() {
			EObject container = ((CreateElementRequest) getRequest())
					.getContainer();
			if (container instanceof View) {
				container = ((View) container).getElement();
			}
			return container;
		}
	}

}

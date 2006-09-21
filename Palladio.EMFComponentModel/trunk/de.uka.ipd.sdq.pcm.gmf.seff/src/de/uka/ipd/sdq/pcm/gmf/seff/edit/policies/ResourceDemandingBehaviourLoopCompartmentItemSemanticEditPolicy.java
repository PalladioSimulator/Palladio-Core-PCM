/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gef.commands.Command;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceDemandingBehaviourLoopCompartmentItemSemanticEditPolicy
		extends PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.StartAction_2002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateStartAction_2002Command(req));
		}
		if (PcmElementTypes.StopAction_2003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateStopAction_2003Command(req));
		}
		if (PcmElementTypes.LoopAction_2004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateLoopAction_2004Command(req));
		}
		if (PcmElementTypes.InternalAction_2005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateInternalAction_2005Command(req));
		}
		if (PcmElementTypes.BranchAction_2006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateBranchAction_2006Command(req));
		}
		if (PcmElementTypes.ExternalCallAction_2009 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateExternalCallAction_2009Command(req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateStartAction_2002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateStartAction_2002Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

	/**
	 * @generated
	 */
	private static class CreateStopAction_2003Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateStopAction_2003Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

	/**
	 * @generated
	 */
	private static class CreateLoopAction_2004Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateLoopAction_2004Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

	/**
	 * @generated
	 */
	private static class CreateInternalAction_2005Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateInternalAction_2005Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

	/**
	 * @generated
	 */
	private static class CreateBranchAction_2006Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateBranchAction_2006Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

	/**
	 * @generated
	 */
	private static class CreateExternalCallAction_2009Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateExternalCallAction_2009Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingBehaviour();
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

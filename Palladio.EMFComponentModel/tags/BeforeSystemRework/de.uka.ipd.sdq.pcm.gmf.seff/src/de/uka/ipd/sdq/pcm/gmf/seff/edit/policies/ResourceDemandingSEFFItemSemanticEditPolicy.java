/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class ResourceDemandingSEFFItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.StartAction_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateStartAction_1001Command(req));
		}
		if (PcmElementTypes.StopAction_1002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateStopAction_1002Command(req));
		}
		if (PcmElementTypes.ExternalCallAction_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateExternalCallAction_1003Command(req));
		}
		if (PcmElementTypes.LoopAction_1004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateLoopAction_1004Command(req));
		}
		if (PcmElementTypes.BranchAction_1005 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateBranchAction_1005Command(req));
		}
		if (PcmElementTypes.InternalAction_1006 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SeffPackage.eINSTANCE
						.getResourceDemandingBehaviour_Steps_Behaviour());
			}
			return getMSLWrapper(new CreateInternalAction_1006Command(req));
		}
		if (PcmElementTypes.PrimitiveParametricParameterUsage_1007 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getResourceDemandingBehaviour_ParametricParameterUsage_Behaviour());
			}
			return getMSLWrapper(new CreatePrimitiveParametricParameterUsage_1007Command(
					req));
		}
		if (PcmElementTypes.CollectionParametricParameterUsage_1008 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getResourceDemandingBehaviour_ParametricParameterUsage_Behaviour());
			}
			return getMSLWrapper(new CreateCollectionParametricParameterUsage_1008Command(
					req));
		}
		if (PcmElementTypes.ParametricResourceDemand_1009 == req
				.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(SeffPackage.eINSTANCE
								.getResourceDemandingBehaviour_ParametricResourceDemands_Behaviour());
			}
			return getMSLWrapper(new CreateParametricResourceDemand_1009Command(
					req));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateStartAction_1001Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateStartAction_1001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateStopAction_1002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateStopAction_1002Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateExternalCallAction_1003Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateExternalCallAction_1003Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateLoopAction_1004Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateLoopAction_1004Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateBranchAction_1005Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateBranchAction_1005Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateInternalAction_1006Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateInternalAction_1006Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreatePrimitiveParametricParameterUsage_1007Command
			extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreatePrimitiveParametricParameterUsage_1007Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateCollectionParametricParameterUsage_1008Command
			extends CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateCollectionParametricParameterUsage_1008Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	private static class CreateParametricResourceDemand_1009Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateParametricResourceDemand_1009Command(
				CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SeffPackage.eINSTANCE.getResourceDemandingSEFF();
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
	protected Command getDuplicateCommand(DuplicateElementsRequest req) {
		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost())
				.getEditingDomain();
		return getMSLWrapper(new DuplicateAnythingCommand(editingDomain, req));
	}

	/**
	 * @generated
	 */
	private static class DuplicateAnythingCommand extends
			DuplicateEObjectsCommand {

		/**
		 * @generated
		 */
		public DuplicateAnythingCommand(
				TransactionalEditingDomain editingDomain,
				DuplicateElementsRequest req) {
			super(editingDomain, req.getLabel(), req
					.getElementsToBeDuplicated(), req
					.getAllDuplicatedElementsMap());
		}
	}
}

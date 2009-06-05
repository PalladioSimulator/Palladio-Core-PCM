/*
 *Copyright 2006 SDQ Research Group, University of Karlsruhe (TH)
 */
package de.uka.ipd.sdq.pcm.gmf.seff.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

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
	 * @generated NOT
	 */
	private class CreateExternalCallAction_1003Command extends
			CreateElementCommand {

		private Signature signature;

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

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doDefaultElementCreation()
		 */
		@Override
		protected EObject doDefaultElementCreation() {
			EObject result = super.doDefaultElementCreation();
			((ExternalCallAction) result)
					.setCalledService_ExternalService(signature);
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			Shell shell = ResourceDemandingSEFFItemSemanticEditPolicy.this
					.getHost().getRoot().getViewer().getControl().getShell();

			ArrayList filterList = new ArrayList();
			filterList.add(RequiredRole.class);
			filterList.add(Interface.class);
			filterList.add(Signature.class);
			ArrayList additionalReferences = new ArrayList();
			additionalReferences.add(RepositoryPackage.eINSTANCE
					.getRequiredRole_RequiredInterface__RequiredRole());
			PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
					shell,
					filterList,
					additionalReferences,
					findBasicComponentModel((GraphicalEditPart) ResourceDemandingSEFFItemSemanticEditPolicy.this
							.getHost()));
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof Signature))
				return CommandResult.newCancelledCommandResult();
			this.signature = (Signature) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}

		private BasicComponent findBasicComponentModel(GraphicalEditPart part) {
			EObject model = null;
			do {
				model = ((View) part.getModel()).getElement();
				if (part.getParent() instanceof GraphicalEditPart)
					part = (GraphicalEditPart) part.getParent();
			} while (!(model instanceof ResourceDemandingSEFF));
			return (BasicComponent) model.eContainer();
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

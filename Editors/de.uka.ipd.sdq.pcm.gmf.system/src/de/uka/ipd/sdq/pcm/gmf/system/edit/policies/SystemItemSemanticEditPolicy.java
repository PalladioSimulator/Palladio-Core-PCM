/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPartViewer;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.commands.DuplicateEObjectsCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.DuplicateElementsRequest;

import de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;

import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;

import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;

import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import org.eclipse.gmf.runtime.notation.View;

/**
 * @generated
 */
public class SystemItemSemanticEditPolicy extends PcmBaseItemSemanticEditPolicy {

	/**
	 * @generated NOT
	 */
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.AssemblyContext_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(CompositionPackage.eINSTANCE
								.getComposedStructure_ChildComponentContexts_ComposedStructure());
			}
			return getMSLWrapper(new CreateAssemblyContext_1001Command(req,
					(SystemEditPart) getHost()));
		}
		if (PcmElementTypes.SystemProvidedRole_1002 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SystemPackage.eINSTANCE
						.getSystem_SystemProvidedRole_System());
			}
			return getMSLWrapper(new CreateSystemProvidedRole_1002Command(req,
					(SystemEditPart) getHost()));
		}
		if (PcmElementTypes.SystemRequiredRole_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(SystemPackage.eINSTANCE
						.getSystem_SystemRequiredRole_System());
			}
			return getMSLWrapper(new CreateSystemRequiredRole_1003Command(req,
					(SystemEditPart) getHost()));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated
	 */
	private static class CreateAssemblyContext_1001Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateAssemblyContext_1001Command(CreateElementRequest req) {
			super(req);
		}

		/**
		 * @generated NOT
		 */
		public CreateAssemblyContext_1001Command(CreateElementRequest req,
				SystemEditPart v) {
			super(req);
			this.v = v;
		}

		private SystemEditPart v = null;

		private ProvidesComponentType componentToLink;

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SystemPackage.eINSTANCE.getSystem();
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
			((AssemblyContext) result)
					.setEncapsulatedComponent_ChildComponentContext(componentToLink);
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
			adapterFactory
					.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			ArrayList filterList = new ArrayList();
			filterList.add(Repository.class);
			filterList.add(ProvidesComponentType.class);
			SelectEObjectDialog dialog = new SelectEObjectDialog(v.getRoot()
					.getViewer().getControl().getShell(), adapterFactory,
					filterList, v.getEditingDomain().getResourceSet());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof ProvidesComponentType))
				return CommandResult.newCancelledCommandResult();
			this.componentToLink = (ProvidesComponentType) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	private static class CreateSystemProvidedRole_1002Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateSystemProvidedRole_1002Command(CreateElementRequest req) {
			super(req);
		}

		private SystemEditPart v;

		private Interface interfaceToLink;

		/**
		 * @generated NOT
		 */
		public CreateSystemProvidedRole_1002Command(CreateElementRequest req,
				SystemEditPart v) {
			super(req);
			this.v = v;
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SystemPackage.eINSTANCE.getSystem();
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
			((SystemProvidedRole) result)
					.setProvidedInterface__ProvidedRole(interfaceToLink);
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
			adapterFactory
					.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			ArrayList filterList = new ArrayList();
			filterList.add(Repository.class);
			filterList.add(Interface.class);
			SelectEObjectDialog dialog = new SelectEObjectDialog(v.getRoot()
					.getViewer().getControl().getShell(), adapterFactory,
					filterList, v.getEditingDomain().getResourceSet());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof Interface))
				return CommandResult.newCancelledCommandResult();
			this.interfaceToLink = (Interface) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
		}
	}

	/**
	 * @generated
	 */
	private static class CreateSystemRequiredRole_1003Command extends
			CreateElementCommand {

		/**
		 * @generated
		 */
		public CreateSystemRequiredRole_1003Command(CreateElementRequest req) {
			super(req);
		}

		private SystemEditPart v;

		private Interface interfaceToLink;

		/**
		 * @generated NOT
		 */
		public CreateSystemRequiredRole_1003Command(CreateElementRequest req,
				SystemEditPart v) {
			super(req);
			this.v = v;
		}

		/**
		 * @generated
		 */
		protected EClass getEClassToEdit() {
			return SystemPackage.eINSTANCE.getSystem();
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
			((SystemRequiredRole) result)
					.setRequiredInterface__RequiredRole(interfaceToLink);
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
			adapterFactory
					.addAdapterFactory(new ResourceItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
			adapterFactory
					.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
			ArrayList filterList = new ArrayList();
			filterList.add(Repository.class);
			filterList.add(Interface.class);
			SelectEObjectDialog dialog = new SelectEObjectDialog(v.getRoot()
					.getViewer().getControl().getShell(), adapterFactory,
					filterList, v.getEditingDomain().getResourceSet());
			dialog.open();
			if (dialog.getResult() == null)
				return CommandResult.newCancelledCommandResult();
			if (!(dialog.getResult() instanceof Interface))
				return CommandResult.newCancelledCommandResult();
			this.interfaceToLink = (Interface) dialog.getResult();
			return super.doExecuteWithResult(monitor, info);
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

/*
 *by SDQ, IPD, U Karlrsuhe (TH), 2006
 */
package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.DestroyElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateRelationshipRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.DestroyElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemNodeEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RequiredRole;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @generated
 */
public class SystemNodeItemSemanticEditPolicy extends
		PcmBaseItemSemanticEditPolicy {

	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.SystemProvidedRole_1004 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EntityPackage.eINSTANCE.
						getInterfaceProvidingEntity_ProvidedRoles_InterfaceProvidingEntity());
			}
			return getMSLWrapper(new CreateSystemProvidedRole_1002Command(req,
					(SystemNodeEditPart) getHost()));
		}
		if (PcmElementTypes.SystemRequiredRole_1003 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req.setContainmentFeature(EntityPackage.eINSTANCE
						.getInterfaceRequiringEntity_RequiredRoles_InterfaceRequiringEntity());
			}
			return getMSLWrapper(new CreateSystemRequiredRole_1003Command(req,
					(SystemNodeEditPart) getHost()));
		}		
		return super.getCreateCommand(req);
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

		private SystemNodeEditPart v;

		private Interface interfaceToLink;

		/**
		 * @generated NOT
		 */
		public CreateSystemProvidedRole_1002Command(CreateElementRequest req,
				SystemNodeEditPart v) {
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
			((ProvidedRole) result)
					.setProvidedInterface__ProvidedRole(interfaceToLink);
			return result;
		}

		/* (non-Javadoc)
		 * @see org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand#doExecuteWithResult(org.eclipse.core.runtime.IProgressMonitor, org.eclipse.core.runtime.IAdaptable)
		 */
		@Override
		protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
				IAdaptable info) throws ExecutionException {
			ArrayList filterList = new ArrayList();
			filterList.add(Repository.class);
			filterList.add(Interface.class);
			PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(v.getRoot()
					.getViewer().getControl().getShell(),
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

		private SystemNodeEditPart v;

		private Interface interfaceToLink;

		/**
		 * @generated NOT
		 */
		public CreateSystemRequiredRole_1003Command(CreateElementRequest req,
				SystemNodeEditPart v) {
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
			((RequiredRole) result)
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
					.getViewer().getControl().getShell(), new PalladioItemProviderAdapterFactory(adapterFactory),
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
		return super.getCreateRelationshipCommand(req);
	}
}

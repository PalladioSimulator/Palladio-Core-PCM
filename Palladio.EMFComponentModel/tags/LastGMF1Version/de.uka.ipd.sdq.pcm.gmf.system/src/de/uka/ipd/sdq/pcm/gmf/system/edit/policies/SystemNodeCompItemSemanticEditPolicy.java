package de.uka.ipd.sdq.pcm.gmf.system.edit.policies;

import java.util.ArrayList;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.type.core.commands.CreateElementCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;
import org.eclipse.gmf.runtime.notation.View;

import de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.gmf.system.edit.parts.SystemNodeCompEditPart;
import de.uka.ipd.sdq.pcm.gmf.system.providers.PcmElementTypes;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;


public class SystemNodeCompItemSemanticEditPolicy extends PcmBaseItemSemanticEditPolicy {
	protected Command getCreateCommand(CreateElementRequest req) {
		if (PcmElementTypes.AssemblyContext_1001 == req.getElementType()) {
			if (req.getContainmentFeature() == null) {
				req
						.setContainmentFeature(CompositionPackage.eINSTANCE
								.getComposedStructure_ChildComponentContexts_ComposedStructure());
			}
			return getMSLWrapper(new CreateAssemblyContext_1001Command(req,
					(SystemNodeCompEditPart) getHost()));
		}
		return super.getCreateCommand(req);
	}

	/**
	 * @generated NOT
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
				SystemNodeCompEditPart v) {
			super(req);
			this.v = v;
		}

		private SystemNodeCompEditPart v = null;

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
					.getViewer().getControl().getShell(), new PalladioItemProviderAdapterFactory(adapterFactory),
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

}

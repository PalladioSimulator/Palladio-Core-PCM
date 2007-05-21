/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.system.System;

/**
 * @author admin
 *
 */
public class EntryLevelSystemCallEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		
		Signature signature = null;
		ProvidedRole providedRole = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(System.class);
		filterList.add(ProvidedRole.class);
		filterList.add(Interface.class);
		filterList.add(Signature.class);

		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		additionalReferences.add(RepositoryPackage.eINSTANCE
				.getProvidedRole_ProvidedInterface__ProvidedRole());

		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, request.getEditingDomain()
						.getResourceSet());
		dialog.setProvidedService(Signature.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof Signature))
			return new CanceledCommand();
		signature = (Signature) dialog.getResult();

		providedRole = getProvidedRoleToSignature(signature,request.getEditingDomain());
		
		return new EntryLevelSystemCallConfigureCommand(request,signature,providedRole);
	}
	
	/**
	 * @return - ProvidedRole to selected Signature
	 */
	private ProvidedRole getProvidedRoleToSignature(Signature signature,
			TransactionalEditingDomain editingDomain) {
		Collection<System> systems = new ArrayList<System>();
		Interface signInterface = signature.getInterface_Signature();

		/**
		 * search the system resource in EditingDomain
		 */
		EList<Resource> resources = editingDomain.getResourceSet()
				.getResources();
		for (Resource resource : resources)
			if (!resource.getContents().isEmpty()
					&& resource.getContents().get(0) instanceof System)
				systems.add((System) resource.getContents().get(0));

		if (systems.isEmpty())
			return null;

		/**
		 * search the ProvidedRole in System
		 */
		for (System system : systems) {
			EList<ProvidedRole> providedRoles = system
					.getProvidedRoles_InterfaceProvidingEntity();

			for (ProvidedRole providedRole : providedRoles)
				if (providedRole.getProvidedInterface__ProvidedRole().equals(
						signInterface))
					return providedRole;
		}
		
		return null;
	}
}

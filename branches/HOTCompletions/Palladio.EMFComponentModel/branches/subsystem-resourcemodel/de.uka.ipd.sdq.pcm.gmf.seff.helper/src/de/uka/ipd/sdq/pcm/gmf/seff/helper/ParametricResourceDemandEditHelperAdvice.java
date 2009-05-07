/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.entity.ResourceInterfaceRequiringEntity;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceInterface;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceService;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;


/** @author roman, hauck
 * 
 */
public class ParametricResourceDemandEditHelperAdvice 
extends	AbstractCreateRandomVariableEditHelperAdvice 
implements IEditHelperAdvice {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject eObject = searchResourceInterfaceRequiringEntity(request.getElementToConfigure());
		ResourceRequiredRole resourceRequiredRole = null;
		
		// define the filter list
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ResourceRequiredRole.class);
		filterList.add(ResourceInterface.class);
		filterList.add(ResourceService.class);
		
		// define the additional references
		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		additionalReferences.add(ResourcetypePackage.eINSTANCE
				.getResourceRequiredRole_RequiredResourceInterface_ResourceRequiredRole());
		
		// create the dialog
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, eObject);
		dialog.setProvidedService(ResourceService.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof ResourceService))
			return new CanceledCommand();
		
		// set the resourceService for ParametricResourceDemand 
		ResourceService resourceService = (ResourceService) dialog.getResult();
		
		// set the resourceRequiredRole for ParametricResourceDemand 
		if (dialog.getViewerRootElement() instanceof ResourceRequiredRole) {
			resourceRequiredRole = (ResourceRequiredRole) dialog.getRootOfResult();
		}

		// create and execute the ParametricResourceDemandConfigureCommand command
		return new ParametricResourceDemandConfigureCommand(request, resourceService,
				resourceRequiredRole);
	}
	
	private EObject searchResourceInterfaceRequiringEntity(EObject elementToConfigure) {
		EObject o = elementToConfigure;
		while (!(o instanceof ResourceInterfaceRequiringEntity))
			o = o.eContainer();
		return o;
	}
}

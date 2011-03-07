/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.OperationInterface;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * @author Roman Andrej
 * 
 */
public class ExternalCallActionEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject eObject = searchBasicComponent(request.getElementToConfigure());
		OperationRequiredRole requiredRole = null;
		
		// define the filter list
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(OperationRequiredRole.class);
		filterList.add(OperationInterface.class);
		filterList.add(OperationSignature.class);
		
		// define the additional references
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		additionalReferences.add(RepositoryPackage.eINSTANCE
				.getOperationRequiredRole_RequiredInterface__OperationRequiredRole());
		
		// create the dialog
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, eObject);
		dialog.setProvidedService(OperationSignature.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof OperationSignature))
			return new CanceledCommand();
		
		// set the signature for ExternalCallAction 
		OperationSignature signature = (OperationSignature) dialog.getResult();
		
		// set the required role for ExternalCallAction 
		if (dialog.getViewerRootElement() instanceof OperationRequiredRole) {
			requiredRole = (OperationRequiredRole) dialog.getRootOfResult();
		}

		// create and execute the ExternalCallActionConfigureCommand command
		return new ExternalCallActionConfigureCommand(request, signature,
				requiredRole);
	}

	private EObject searchBasicComponent(EObject elementToConfigure) {
		EObject o = elementToConfigure;
		while (!(o instanceof BasicComponent))
			o = o.eContainer();
		return o;
	}
}

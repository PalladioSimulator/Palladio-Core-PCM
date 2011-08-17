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
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface;
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole;
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**Advice for the EditHelper of InfrastructureCall. Displays the dialogs for selection of infrastructure required role and signature.
 * @author groenda
 */
public class InfrastructureCallEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject eObject = searchBasicComponent(request.getElementToConfigure());
		InfrastructureRequiredRole requiredRole = null;
		
		// define the filter list
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(InfrastructureRequiredRole.class);
		filterList.add(InfrastructureInterface.class);
		filterList.add(InfrastructureSignature.class);
		
		// define the additional references
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		additionalReferences
				.add(RepositoryPackage.eINSTANCE
						.getInfrastructureRequiredRole_RequiredInterface__InfrastructureRequiredRole());
		
		// create the call target dialog
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, eObject);
		dialog.setProvidedService(InfrastructureSignature.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof InfrastructureSignature))
			return new CanceledCommand();
		// set the signature for InfrastructureCall 
		InfrastructureSignature signature = (InfrastructureSignature) dialog.getResult();
		// set the required role for InfrastructureCall 
		if (dialog.getViewerRootElement() instanceof InfrastructureRequiredRole) {
			requiredRole = (InfrastructureRequiredRole) dialog.getRootOfResult();
		}
		
		//create the number of calls dialog
		StochasticExpressionEditDialog dialogNoC = new StochasticExpressionEditDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				TypeEnum.INT, request.getElementToConfigure());
		dialogNoC.open();
		if (dialogNoC.getReturnCode() == Dialog.CANCEL)
			return new CanceledCommand();
		String numberOfCalls = dialogNoC.getResultText();

		// create and execute the ExternalCallActionConfigureCommand command
		return new InfrastructureCallConfigureCommand(request, signature,
				requiredRole, numberOfCalls);
	}

	private EObject searchBasicComponent(EObject elementToConfigure) {
		EObject o = elementToConfigure;
		while (!(o instanceof BasicComponent))
			o = o.eContainer();
		return o;
	}
}

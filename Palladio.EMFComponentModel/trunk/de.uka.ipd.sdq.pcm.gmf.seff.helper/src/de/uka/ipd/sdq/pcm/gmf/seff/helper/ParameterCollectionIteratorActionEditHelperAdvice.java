/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @author admin
 *
 */
public class ParameterCollectionIteratorActionEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		
		ResourceDemandingSEFF seff = getSEFF(request.getElementToConfigure());
		
		EObject parameter = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		
		filterList.add(ResourceDemandingSEFF.class);
		filterList.add(Signature.class);
		filterList.add(Parameter.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				seff.getDescribedService__SEFF().getInterface_Signature());
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof Parameter))
			return new CanceledCommand();
		parameter = (Parameter) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						SeffPackage.eINSTANCE.getCollectionIteratorAction_Parameter_CollectionIteratorAction(),
						parameter));
		return cmd;
	}
	
	private ResourceDemandingSEFF getSEFF(EObject a) {
		EObject container = a;
		while (!(container instanceof ResourceDemandingSEFF))
			container = container.eContainer();
		if (!(container instanceof ResourceDemandingSEFF)) 
			return null;
		ResourceDemandingSEFF seff = (ResourceDemandingSEFF) container;
		return seff;
	}

}

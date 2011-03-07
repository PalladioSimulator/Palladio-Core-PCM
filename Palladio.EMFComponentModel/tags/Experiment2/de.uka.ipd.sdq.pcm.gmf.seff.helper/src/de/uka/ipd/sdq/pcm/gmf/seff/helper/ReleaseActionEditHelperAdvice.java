/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.resourcetype.PassiveResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * @author admin
 *
 */
public class ReleaseActionEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject resource = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ResourceRepository.class);
		filterList.add(PassiveResourceType.class);

		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				request.getEditingDomain().getResourceSet());
		dialog.setProvidedService(PassiveResourceType.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof PassiveResourceType))
			return new CanceledCommand();
		resource = (PassiveResourceType) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						SeffPackage.eINSTANCE.getReleaseAction_ResourceType_Release(),
						resource));
		return cmd;
	}
}

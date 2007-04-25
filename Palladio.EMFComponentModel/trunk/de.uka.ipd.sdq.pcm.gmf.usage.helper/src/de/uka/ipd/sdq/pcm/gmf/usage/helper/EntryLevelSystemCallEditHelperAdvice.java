/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.usage.helper;

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
import de.uka.ipd.sdq.pcm.repository.Interface;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
		EObject eOobject = request.getElementToConfigure().eContainer().eContainer();
		EObject signature = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ProvidedRole.class);
		filterList.add(Interface.class);
		filterList.add(Signature.class);
		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		additionalReferences.add(RepositoryPackage.eINSTANCE.getProvidedRole_ProvidingEntity_ProvidedRole());
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				eOobject);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof Signature))
			return new CanceledCommand();
		signature = (Signature) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						UsagemodelPackage.eINSTANCE.getEntryLevelSystemCall_Signature_EntryLevelSystemCall(),
						signature));
		return cmd;
	}

}

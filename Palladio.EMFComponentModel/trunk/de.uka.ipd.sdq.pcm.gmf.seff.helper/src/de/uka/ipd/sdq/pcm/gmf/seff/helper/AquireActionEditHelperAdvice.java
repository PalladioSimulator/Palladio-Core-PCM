/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;

/**
 * @author admin
 *
 */
public class AquireActionEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {
	
	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		// TODO: Adjust to new PCM structures
//		EObject resource = null;
//		ArrayList<Object> filterList = new ArrayList<Object>();
//		filterList.add(ResourceRepository.class);
//		filterList.add(PassiveResourceType.class);
//
//		ArrayList<Object> additionalReferences = new ArrayList<Object>();
//		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
//				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
//				filterList, 
//				additionalReferences,
//				request.getEditingDomain().getResourceSet());
//		dialog.setProvidedService(PassiveResourceType.class);
//		dialog.open();
//		if (dialog.getResult() == null)
//			return new CanceledCommand();
//		if (!(dialog.getResult() instanceof PassiveResourceType))
//			return new CanceledCommand();
//		resource = (PassiveResourceType) dialog.getResult();
//		
//		ICommand cmd = new SetValueCommand(
//				new SetRequest(
//						request.getElementToConfigure(), 
//						SeffPackage.eINSTANCE.getAcquireAction_Passiveresource_AcquireAction(),
//						resource));
//		return cmd;
		return null;
	}

}

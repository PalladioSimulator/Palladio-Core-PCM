package de.uka.ipd.sdq.pcm.gmf.allocation.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.CompositeCommand;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;

public class AllocationContextEditHelperAdvice
	extends AbstractEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		AssemblyContext resource = null;

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(de.uka.ipd.sdq.pcm.system.System.class);
		filterList.add(AssemblyContext.class);

		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				request.getElementToConfigure().eResource().getResourceSet());
		dialog.setProvidedService(AssemblyContext.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof AssemblyContext))
			return new CanceledCommand();
		resource = (AssemblyContext) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						AllocationPackage.eINSTANCE.getAllocationContext_AssemblyContext_AllocationContext(),
						resource));
		
		String allocationName = "Allocation_"+resource.getEntityName();
		if (resource.getEncapsulatedComponent__AssemblyContext() != null)
			allocationName += " <"+resource.getEncapsulatedComponent__AssemblyContext().getEntityName()+">";

		ICommand cmd2 = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						EntityPackage.eINSTANCE.getNamedElement_EntityName(),
						allocationName));
		
		CompositeCommand cc = new CompositeCommand("Configure Allocation Context");
		cc.add(cmd);
		cc.add(cmd2);
		
		return cc;
	}
}

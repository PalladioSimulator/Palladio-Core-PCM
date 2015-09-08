package org.palladiosimulator.editors.usage.externaljavaactions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.sirius.tools.api.ui.IExternalJavaAction;
import org.eclipse.ui.PlatformUI;
import org.palladiosimulator.editors.dialogs.selection.PalladioSelectEObjectDialog;
import org.palladiosimulator.pcm.repository.OperationInterface;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.ScenarioBehaviour;
import org.palladiosimulator.pcm.usagemodel.UsageModel;
import org.palladiosimulator.pcm.usagemodel.UsagemodelFactory;

public class EntryLevelSystemCallCreationDialog implements IExternalJavaAction {

	@Override
	public boolean canExecute(Collection<? extends EObject> arg0) {
		return true;
	}
	
	private EObject getUsageModel(EObject object) {
		if (object instanceof UsageModel) {
			return object;
		} else {
			return getUsageModel(object.eContainer());
		}
	}

	@Override
	public void execute(Collection<? extends EObject> arg0, Map<String, Object> arg1) {
		Object element = (Object) arg0.iterator().next();
		ScenarioBehaviour beh = (ScenarioBehaviour) element;
		
		EntryLevelSystemCall newElement = UsagemodelFactory.eINSTANCE.createEntryLevelSystemCall();
        beh.getActions_ScenarioBehaviour().add(newElement);

        
		
		OperationSignature signature = null;
		OperationProvidedRole providedRole = null;
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(System.class);
		filterList.add(OperationProvidedRole.class);

		/* first dialog for selection of the operation provided role */
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		additionalReferences
				.add(RepositoryPackage.eINSTANCE.getOperationProvidedRole_ProvidedInterface__OperationProvidedRole());
		additionalReferences.add(RepositoryPackage.eINSTANCE.getInterface_ParentInterfaces__Interface());

		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), filterList, additionalReferences,
				newElement);
		dialog.setProvidedService(OperationProvidedRole.class);
		dialog.open();
		if (dialog.getResult() == null) {
			return;
		}
		if (!(dialog.getResult() instanceof OperationProvidedRole)) {
			return;
		}

		providedRole = (OperationProvidedRole) dialog.getResult();

		/* second dialog for selection of the signature of the interface */
		filterList.clear();
		filterList.add(OperationProvidedRole.class);
		filterList.add(OperationInterface.class);
		filterList.add(OperationSignature.class);

		dialog = new PalladioSelectEObjectDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, providedRole);
		dialog.setProvidedService(OperationSignature.class);
		dialog.open();
		if (dialog.getResult() == null) {
			return;
		}
		if (!(dialog.getResult() instanceof OperationSignature)) {
			return;
		}
		signature = (OperationSignature) dialog.getResult();
	}
}

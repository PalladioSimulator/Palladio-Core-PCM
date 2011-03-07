package de.uka.ipd.sdq.pcm.gmf.resource.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.core.CoreFactory;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.dialogs.stoex.StochasticExpressionEditDialog;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceRepository;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

public class ProcessingResourceSpecificationEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {

	private static final String DISPLAY_TITLE = "Set Processing Rate";
	private static boolean ongoing = true;

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		PCMRandomVariable rv = CoreFactory.eINSTANCE.createPCMRandomVariable();
		rv.setSpecification("");
		if (ongoing){
			StochasticExpressionEditDialog dialog = new StochasticExpressionEditDialog(
					PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
					TypeEnum.DOUBLE, rv);
			dialog.setDisplayTitle(DISPLAY_TITLE);
			dialog.open();

			if (dialog.getReturnCode() == Dialog.CANCEL)
				return new CanceledCommand();

			rv.setSpecification(dialog.getResultText());
		}
		
		ongoing = true;

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_ProcessingRate_ProcessingResourceSpecification(),
				rv));

		return cmd;
	}
	
	@Override
	protected ICommand getBeforeConfigureCommand(ConfigureRequest request) {
		EObject resourceType = null;
		ArrayList<Object> filterList = new ArrayList<Object>(); // positive filter
		// Set types to show and their super types
		filterList.add(ProcessingResourceType.class);
		filterList.add(ResourceRepository.class);
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		// set EReference that should be set (in this case: active resource type)
		additionalReferences.add(ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification());
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				request.getElementToConfigure().eResource().getResourceSet());
		dialog.setProvidedService(ProcessingResourceType.class);
		dialog.open();
		if (dialog.getResult() == null) {
			ongoing = false; //prevents the StoexDialog for the ProcessingRate from being opened
			return new CanceledCommand();
		}

		if (!(dialog.getResult() instanceof ProcessingResourceType)){
			ongoing = false; //prevents the StoexDialog for the ProcessingRate from being opened
			return new CanceledCommand();
		}
		resourceType = (ProcessingResourceType) dialog.getResult();
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						ResourceenvironmentPackage.eINSTANCE.getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification(),
						resourceType));
		return cmd;
	}
}

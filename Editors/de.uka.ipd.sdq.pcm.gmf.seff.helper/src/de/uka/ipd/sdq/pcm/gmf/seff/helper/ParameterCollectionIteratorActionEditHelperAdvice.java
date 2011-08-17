package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.edithelper.IEditHelperAdvice;
import org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.ui.PlatformUI;

import de.uka.ipd.sdq.pcm.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/** @author roman */
public class ParameterCollectionIteratorActionEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject parameter = null;
		OperationSignature signature = null;
		ResourceDemandingSEFF seff = null;

		seff = getSEFF(request.getElementToConfigure());
		signature = (OperationSignature) seff.getDescribedService__SEFF();

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(ResourceDemandingSEFF.class);
		filterList.add(OperationSignature.class);
		filterList.add(Parameter.class);
		filterList.add(DataType.class);
		ArrayList<EReference> additionalReferences = new ArrayList<EReference>();
		additionalReferences.add(RepositoryPackage.eINSTANCE
				.getParameter_DataType__Parameter());
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, signature
						.getInterface__OperationSignature());
		dialog
				.setViewerContentProvider(new CollectionIteratorContentProvider());
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		/**
		 * set a LabelProvider for dialog TreeViewer
		 */
		dialog
				.setViewerLabelProvider(new AdapterFactoryLabelProvider(
						new CollectionIteratorItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))));
		dialog.setProvidedService(Parameter.class);
		dialog.open();
		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof Parameter))
			return new CanceledCommand();
		parameter = (Parameter) dialog.getResult();

		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(),
						SeffPackage.eINSTANCE
								.getCollectionIteratorAction_Parameter_CollectionIteratorAction(),
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

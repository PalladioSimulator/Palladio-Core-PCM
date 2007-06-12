/**
 * 
 */
package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
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

import de.uka.ipd.sdq.dialogs.selection.PalladioSelectEObjectDialog;
import de.uka.ipd.sdq.dialogs.stoex.InnerDeclarationContainer;
import de.uka.ipd.sdq.dialogs.stoex.DataTypeContainer;
import de.uka.ipd.sdq.dialogs.stoex.VariableUsageContentProvider;
import de.uka.ipd.sdq.dialogs.stoex.VariableUsageInputParameterContentProvider;
import de.uka.ipd.sdq.dialogs.stoex.VariableUsageItemProviderAdapterFactory;
import de.uka.ipd.sdq.dialogs.stoex.VariableUsageOutputParameterContentProvider;
import de.uka.ipd.sdq.pcm.gmf.seff.providers.PalladioComponentModelElementTypes;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * @author admin
 * 
 */
public class VariableUsageEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		if (request.getElementToConfigure().eContainer() instanceof ExternalCallAction) {
			if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3001){
				// 3001 = VariableUsage for input variables
				return caseExternalCallActionInputParameter(request);
			} else if (request.getTypeToConfigure() == PalladioComponentModelElementTypes.VariableUsage_3022){
				// 3022 = VariableUsage for output variables
				return caseExternalCallActionOutputParameter(request);
			} else {
				return null;
			}
		} else if (request.getElementToConfigure().eContainer() instanceof SetVariableAction) {
			return caseSetVariableAction(request);
		} else
			return new CanceledCommand();
	}

	private ICommand caseExternalCallActionOutputParameter(
			ConfigureRequest request) {

		SetOutputVariableNameDialog dialog = new SetOutputVariableNameDialog(PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell());
		dialog.open();
		
		String enteredName = dialog.getResult();
		if (enteredName == null){
			return new CanceledCommand();
		}
		
		AbstractNamedReference namedReference = 
			getOutputVariableReference(enteredName);

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), ParameterPackage.eINSTANCE
				.getVariableUsage_NamedReference_VariableUsage(),
				namedReference));
		return cmd;
	}

	private AbstractNamedReference getOutputVariableReference(String enteredName) {
		String[] enteredNameSplitted = enteredName.split("\\.");
		AbstractNamedReference namedReference = referenceFactory(
				enteredNameSplitted[enteredNameSplitted.length - 1], true);

		for (int i=enteredNameSplitted.length-2; i>=0; i--){
			NamespaceReference nr = (NamespaceReference)referenceFactory(enteredNameSplitted[i], false);
			nr.setInnerReference_NamespaceReference(namedReference);
			namedReference = nr;
		}
		return namedReference;
	}

	private ICommand caseSetVariableAction(ConfigureRequest request) {
		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(Repository.class);
		filterList.add(Signature.class);

		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, this.getMyService(request.getElementToConfigure()));
		/**
		 * set a ContentProvider for dialog TreeViewer
		 */
		dialog.setViewerContentProvider(new VariableUsageOutputParameterContentProvider());
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
						new VariableUsageItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))));
		dialog.open();

		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof DataTypeContainer)
				&& !(dialog.getResult() instanceof InnerDeclarationContainer)
				&& !(dialog.getResult() instanceof Parameter))
			return new CanceledCommand();

		EObject resource = (EObject) dialog.getResult();

		AbstractNamedReference namedReference = setNamedReference(resource,
				null, true);

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), ParameterPackage.eINSTANCE
				.getVariableUsage_NamedReference_VariableUsage(),
				namedReference));
		return cmd;
	}

	private Signature getMyService(EObject elementToConfigure) {
		EObject current = elementToConfigure;
		while (current != null && !(current instanceof ResourceDemandingSEFF))
			current = current.eContainer();
		return ((ResourceDemandingSEFF)current).getDescribedService__SEFF();
	}

	private ICommand caseExternalCallActionInputParameter(
			ConfigureRequest request) {
		EObject resource = null;
		ExternalCallAction call = getCall(request.getElementToConfigure());

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(Repository.class);
		filterList.add(Signature.class);

		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, additionalReferences, call
						.getCalledService_ExternalService());
		/**
		 * set a ContentProvider for dialog TreeViewer
		 */
		dialog.setViewerContentProvider(new VariableUsageInputParameterContentProvider());
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
						new VariableUsageItemProviderAdapterFactory(
								new PalladioItemProviderAdapterFactory(
										adapterFactory))));
		dialog.open();

		if (dialog.getResult() == null)
			return new CanceledCommand();
		if (!(dialog.getResult() instanceof DataTypeContainer)
				&& !(dialog.getResult() instanceof InnerDeclarationContainer)
				&& !(dialog.getResult() instanceof Parameter))
			return new CanceledCommand();

		resource = (EObject) dialog.getResult();

		AbstractNamedReference namedReference = setNamedReference(resource,
				null, true);

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), ParameterPackage.eINSTANCE
				.getVariableUsage_NamedReference_VariableUsage(),
				namedReference));
		return cmd;
	}

	/**
	 * @return - String: specification of VariableCharacterisation
	 */
	private AbstractNamedReference setNamedReference(EObject object,
			AbstractNamedReference namedReference, boolean last) {
		/**
		 * Parameter
		 */
		if (object instanceof Parameter) {
			Parameter parameter = (Parameter) object;
			AbstractNamedReference parameterReference = referenceFactory(
					parameter.getParameterName(), last);
			if (!last) {
				((NamespaceReference) parameterReference)
						.setInnerReference_NamespaceReference(namedReference);
			}
			return parameterReference;
		}

		/**
		 * TreeType container for CollectionDataType
		 * 
		 * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeType
		 */
		if (object instanceof DataTypeContainer) {
			DataTypeContainer treeType = (DataTypeContainer) object;
			if (treeType.getParent() != null) {
				AbstractNamedReference treetypeReference = referenceFactory(
						"INNER", last);
				if (!last) {
					((NamespaceReference) treetypeReference)
							.setInnerReference_NamespaceReference(namedReference);
				}
				return setNamedReference((EObject) treeType.getParent(),
						treetypeReference, false);
			}
		}

		/**
		 * TreeDeclaration container for InnerDeclaration
		 * 
		 * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeDeclaration
		 */
		if (object instanceof InnerDeclarationContainer) {
			InnerDeclarationContainer treeDeclaration = (InnerDeclarationContainer) object;
			InnerDeclaration declaration = (InnerDeclaration) treeDeclaration
					.getObject();

			AbstractNamedReference declarationReference = referenceFactory(
					declaration.getEntityName(), last);
			if (!last) {
				((NamespaceReference) declarationReference)
						.setInnerReference_NamespaceReference(namedReference);
			}
			return setNamedReference((EObject) treeDeclaration.getParent(),
					declarationReference, false);
		}

		return namedReference;
	}

	/**
	 * Create the AbstractNamedReference and set a string parameter
	 */
	private AbstractNamedReference referenceFactory(String string,
			boolean shouldGenerateVariableReference) {
		AbstractNamedReference parameterReference = null;
		if (shouldGenerateVariableReference) {
			parameterReference = StoexFactory.eINSTANCE
					.createVariableReference();
		} else {
			parameterReference = StoexFactory.eINSTANCE
					.createNamespaceReference();
		}
		parameterReference.setReferenceName(string);
		return parameterReference;
	}

	private ExternalCallAction getCall(EObject a) {
		EObject container = a;
		while (!(container instanceof ExternalCallAction))
			container = container.eContainer();
		if (!(container instanceof ExternalCallAction))
			return null;
		return (ExternalCallAction) container;
	}
}

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
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.InnerDeclaration;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.StoexFactory;

/**
 * @author admin
 *
 */
public class VariableUsageEditHelperAdvice extends AbstractEditHelperAdvice
		implements IEditHelperAdvice {

	/* (non-Javadoc)
	 * @see org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice#getAfterConfigureCommand(org.eclipse.gmf.runtime.emf.type.core.requests.ConfigureRequest)
	 */
	@Override
	protected ICommand getAfterConfigureCommand(ConfigureRequest request) {
		EObject resource = null;
		ResourceDemandingSEFF seff = getSEFF(request.getElementToConfigure());

		ArrayList<Object> filterList = new ArrayList<Object>();
		filterList.add(Repository.class);
		filterList.add(Signature.class);

		ArrayList<Object> additionalReferences = new ArrayList<Object>();
		PalladioSelectEObjectDialog dialog = new PalladioSelectEObjectDialog(
				PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(),
				filterList, 
				additionalReferences,
				seff);
		/**
		 * set a ContentProvider for dialog TreeViewer
		 */
		dialog.setViewerContentProvider(new VariableUsageContentProvider());
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
		if (!(dialog.getResult() instanceof TreeType)
				&& !(dialog.getResult() instanceof TreeDeclaration))
			return new CanceledCommand();
	
		resource = (EObject) dialog.getResult();
		
		NamespaceReference namedReference = setNamedReference(resource, null);

		ICommand cmd = new SetValueCommand(new SetRequest(request
				.getElementToConfigure(), ParameterPackage.eINSTANCE
				.getVariableUsage_VariableCharacterisation_VariableUsage(),
				namedReference));
		return cmd;
	}

	/**
	 * @return - String: specification of VariableCharacterisation
	 */
	private NamespaceReference setNamedReference(EObject object,
			NamespaceReference namedReference) {
		/**
		 * Parameter
		 */
		if (object instanceof Parameter) {
			Parameter parameter = (Parameter) object;
			NamespaceReference parameterReference = (NamespaceReference) referenceFactory(parameter
					.getParameterName());
			parameterReference.setInnerReference_NamespaceReference(namedReference);
			return parameterReference;
		}

		/**
		 * TreeType container for CollectionDataType
		 * 
		 * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeType
		 */
		if (object instanceof TreeType) {
			TreeType treeType = (TreeType) object;
			if (treeType.getParent() != null) {
				NamespaceReference treetypeReference = referenceFactory("INNER");
				treetypeReference
						.setInnerReference_NamespaceReference(namedReference);
				return setNamedReference((EObject) treeType.getParent(),
						treetypeReference);
			}
		}

		/**
		 * TreeDeclaration container for InnerDeclaration
		 * 
		 * @see de.uka.ipd.sdq.pcm.gmf.seff.helper.VariableUsageContentProvider.TreeDeclaration
		 */
		if (object instanceof TreeDeclaration) {
			TreeDeclaration treeDeclaration = (TreeDeclaration) object;
			InnerDeclaration declaration = (InnerDeclaration) treeDeclaration
					.getObject();

			NamespaceReference declarationReference = referenceFactory(declaration
					.getEntityName());
			declarationReference
					.setInnerReference_NamespaceReference(namedReference);
			return setNamedReference((EObject) treeDeclaration.getParent(),
					declarationReference);
		}

		return namedReference;
	}

	/**
	 * Create the AbstractNamedReference and set a string parameter
	 */
	private NamespaceReference referenceFactory(String string) {
		NamespaceReference parameterReference = StoexFactory.eINSTANCE
				.createNamespaceReference();
		parameterReference.setReferenceName(string);
		return parameterReference;
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

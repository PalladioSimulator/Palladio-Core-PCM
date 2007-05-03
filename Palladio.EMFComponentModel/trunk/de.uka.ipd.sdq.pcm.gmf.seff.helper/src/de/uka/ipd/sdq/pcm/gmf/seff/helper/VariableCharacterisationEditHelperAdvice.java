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

/**
 * @author admin
 *
 */
public class VariableCharacterisationEditHelperAdvice extends
		AbstractEditHelperAdvice implements IEditHelperAdvice {

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
		if (dialog.getResult() instanceof TreeType)
			return new CanceledCommand();
		if (dialog.getResult() instanceof TreeDeclaration)
			return new CanceledCommand();
	
		resource = (EObject) dialog.getResult();
		
		
		String name = setParameterName(resource,"");
		System.err.println("Name: " + name + "BYTESIZE");
		
//		VariableCharacterisation characterisation = ParameterFactory.eINSTANCE.createVariableCharacterisation();
//		characterisation.setSpecification("file.INNER");
//		characterisation.setType(VariableCharacterisationType.BYTESIZE);
//		
//		
		
		
		ICommand cmd = new SetValueCommand(
				new SetRequest(
						request.getElementToConfigure(), 
						ParameterPackage.eINSTANCE.getVariableUsage_VariableCharacterisation_VariableUsage(),
						"file.INNER"));
		return cmd;
	}

	private String setParameterName(EObject object, String name) {
		if (object instanceof Parameter) {
			Parameter parameter = (Parameter) object;
			return  parameter.getParameterName() + "." + name;
		}
		
		if (object instanceof TreeType) {
			TreeType treeType = (TreeType) object;
			if (treeType.getParent() != null)
				return setParameterName((EObject) treeType.getParent(),
						"INNER." + name);
		}
		
		if (object instanceof TreeDeclaration) {
			TreeDeclaration treeDeclaration = (TreeDeclaration) object;
			InnerDeclaration declaration = (InnerDeclaration) treeDeclaration.getObject();
			return declaration.getEntityName() + "." + name ;
		}
		
		return name;
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

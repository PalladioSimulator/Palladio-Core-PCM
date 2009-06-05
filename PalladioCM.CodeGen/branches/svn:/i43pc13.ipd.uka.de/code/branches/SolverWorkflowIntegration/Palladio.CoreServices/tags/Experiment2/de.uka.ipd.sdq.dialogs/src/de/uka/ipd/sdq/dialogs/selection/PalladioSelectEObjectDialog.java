package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author Snowball
 *
 */
public class PalladioSelectEObjectDialog extends SelectEObjectDialog {
	
	private Object input;

	/**
	 * @param parent
	 * @param adapterFactory
	 * @param filterList
	 * @param input
	 */
	public PalladioSelectEObjectDialog(Shell parent,
			Collection<Object> filterList,
			Collection<Object> additionalChildReferences, Object input) {
		super(parent);
		this.input = input;
		create();
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());

		setViewerContentProvider(new AdapterFactoryContentProvider(
				new FilteredItemsAdapterFactory(adapterFactory, filterList,
						additionalChildReferences)));
		setViewerLabelProvider(new AdapterFactoryLabelProvider(
				new PalladioItemProviderAdapterFactory(adapterFactory)));
		setViewerInput(input);
		setInputDialogResourceName(filterList);
	}

	public PalladioSelectEObjectDialog(Shell parent,
			Collection<Object> filterList, Object input) {
		this(parent,filterList,new ArrayList<Object>(),input);
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#setResourceName(java.util.Collection)
	 */
	@Override
	protected void setInputDialogResourceName(Collection<Object> filterList) {
		String system = "System";
		String repository = "Repository";
		String resourceRepository = "ResourceRepository";

		ArrayList<Object> list = new ArrayList<Object>();
		list.addAll(filterList);

		if (!list.isEmpty()) {
			for (Object object : list) {
				Class<?> clazz = (Class<?>) object;
				String name = clazz.getSimpleName();
				if (name.equals(system) || name.equals(repository)
						|| name.equals(resourceRepository))
					setResourceName(correctionResourceRepositoryName(name));
			}
		}
	}
	
	/** Correction the ResourceRepository to ResourceType */
	private String correctionResourceRepositoryName(String name){
		if (name.equals("ResourceRepository"))
			return "ResourceType";
		return name;
	}
	

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.dialogs.selection.SelectEObjectDialog#addResourceToEditingDomain(org.eclipse.swt.widgets.Shell, java.lang.String)
	 */
	@Override
	protected void addModelToResourceSet(Shell shell, String uri) {
		ResourceSet resourceSet = getResourceSet(input);
		
		if (resourceSet != null) {
			URI model = URI.createURI(uri);
			try {
				resourceSet.getResource(model, true);
			} catch (Throwable t) {
				MessageDialog.openInformation(shell, "Resource Loader Error", t
						.getMessage());
			}
		}
	}
	
	/**
	 * Get a resource set from dialog input object
	 * 
	 * @param object -
	 *            dialog input object
	 */
	protected ResourceSet getResourceSet(Object object) {
		/** ResourceSet */
		if (object instanceof ResourceSet)
			return (ResourceSet) object;
		/** EObject */
		if (object instanceof EObject) {
			TransactionalEditingDomain editingDomain = TransactionUtil
					.getEditingDomain((EObject) object);
			if (editingDomain != null)
				return editingDomain.getResourceSet();
		}
		return null;
	}
}

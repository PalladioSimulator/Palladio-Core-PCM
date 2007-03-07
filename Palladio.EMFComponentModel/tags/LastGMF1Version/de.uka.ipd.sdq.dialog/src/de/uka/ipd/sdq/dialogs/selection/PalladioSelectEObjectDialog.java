/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.ReflectiveItemProviderAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.swt.widgets.Shell;

import de.uka.ipd.sdq.pcm.repository.provider.RepositoryItemProviderAdapterFactory;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**
 * @author Snowball
 *
 */
public class PalladioSelectEObjectDialog extends SelectEObjectDialog {

	/**
	 * @param parent
	 * @param adapterFactory
	 * @param filterList
	 * @param input
	 */
	public PalladioSelectEObjectDialog(Shell parent,
			Collection filterList, Collection additionalChildReferences, Object input) {
		super(parent, null, filterList, additionalChildReferences, input);
		ComposedAdapterFactory adapterFactory = new ComposedAdapterFactory();
		adapterFactory
				.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new RepositoryItemProviderAdapterFactory());
		adapterFactory
				.addAdapterFactory(new ReflectiveItemProviderAdapterFactory());
		this.adapterFactory = new PalladioItemProviderAdapterFactory(adapterFactory);
	}

	public PalladioSelectEObjectDialog(Shell parent,
			Collection filterList, Object input) {
		this(parent,filterList,new ArrayList(),input);
	}
}

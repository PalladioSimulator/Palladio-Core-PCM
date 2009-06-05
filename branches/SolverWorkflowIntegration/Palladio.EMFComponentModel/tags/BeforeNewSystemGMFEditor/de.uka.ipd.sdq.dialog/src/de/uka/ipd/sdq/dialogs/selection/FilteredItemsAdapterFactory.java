/**
 * 
 */
package de.uka.ipd.sdq.dialogs.selection;

import java.util.Collection;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * @author Snowball
 *
 */
public class FilteredItemsAdapterFactory extends DecoratorAdapterFactory {

	private Collection filterList;

	public FilteredItemsAdapterFactory(AdapterFactory decoratedAdapterFactory, Collection filterList) {
		super(decoratedAdapterFactory);
		this.filterList = filterList;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.DecoratorAdapterFactory#createItemProviderDecorator(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target,
			Object Type) {
		IItemProviderDecorator decoredProvider = new FilteringItemProvider(this,filterList);
		decoredProvider.setDecoratedItemProvider((IChangeNotifier)getDecoratedAdapterFactory().adapt(target, Type));
		return decoredProvider;
	}

	
}

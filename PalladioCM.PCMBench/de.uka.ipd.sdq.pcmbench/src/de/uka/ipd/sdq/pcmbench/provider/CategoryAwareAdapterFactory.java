/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * @author Snowball
 * 
 */
public class CategoryAwareAdapterFactory 
extends DecoratorAdapterFactory 
implements AdapterFactory,
		IChangeNotifier {

	private ICategoryDescriptions categories;

	public CategoryAwareAdapterFactory(AdapterFactory decoratedAdapterFactory, ICategoryDescriptions categories) {
		super(decoratedAdapterFactory);
		this.categories = categories;
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target, Object Type) {
		return new CategoryAwareItemProviderDecorator(this, categories);
	}

}

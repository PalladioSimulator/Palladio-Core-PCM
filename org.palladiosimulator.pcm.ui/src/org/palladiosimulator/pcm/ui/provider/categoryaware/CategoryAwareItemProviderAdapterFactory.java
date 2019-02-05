package org.palladiosimulator.pcm.ui.provider.categoryaware;


import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * @author Snowball
 * An adapter factory which creates ItemProviders which are able to display their
 * model objects using categories. The categories are passed to the factory in order to
 * configure it.
 */
public class CategoryAwareItemProviderAdapterFactory 
extends DecoratorAdapterFactory 
implements AdapterFactory,
		IChangeNotifier {

	private ICategoryDescriptions categories;

	public CategoryAwareItemProviderAdapterFactory(AdapterFactory decoratedAdapterFactory, ICategoryDescriptions categories) {
		super(decoratedAdapterFactory);
		this.categories = categories;
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target, Object Type) {
		return new CategoryAwareItemProvider(this, categories);
	}

}

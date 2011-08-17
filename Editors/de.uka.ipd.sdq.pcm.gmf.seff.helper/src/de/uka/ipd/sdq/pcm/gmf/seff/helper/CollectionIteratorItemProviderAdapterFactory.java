package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/** @author roman */
public class CollectionIteratorItemProviderAdapterFactory extends
	DecoratorAdapterFactory {

	public CollectionIteratorItemProviderAdapterFactory(
			AdapterFactory decoratedAdapterFactory) {
		super(decoratedAdapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.DecoratorAdapterFactory#createItemProviderDecorator(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target,
			Object type) {
		IItemProviderDecorator decorator = new CollectionIteratorLabelProvider(this);
		if (type == IItemLabelProvider.class) {
			decorator
					.setDecoratedItemProvider((IChangeNotifier) decoratedAdapterFactory
							.adapt(target, IItemLabelProvider.class));
		} else {
			decorator
					.setDecoratedItemProvider((IChangeNotifier) decoratedAdapterFactory
							.adapt(target, type));
		}
		return decorator;
	}
}

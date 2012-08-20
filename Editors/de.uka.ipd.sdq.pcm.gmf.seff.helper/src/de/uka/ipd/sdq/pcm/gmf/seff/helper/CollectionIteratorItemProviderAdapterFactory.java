package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * A factory for creating CollectionIteratorItemProviderAdapter objects.
 * 
 * @author roman
 */
public class CollectionIteratorItemProviderAdapterFactory extends DecoratorAdapterFactory {

    /**
     * Instantiates a new collection iterator item provider adapter factory.
     * 
     * @param decoratedAdapterFactory
     *            the decorated adapter factory
     */
    public CollectionIteratorItemProviderAdapterFactory(final AdapterFactory decoratedAdapterFactory) {
        super(decoratedAdapterFactory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.eclipse.emf.edit.provider.DecoratorAdapterFactory#createItemProviderDecorator(java.lang
     * .Object, java.lang.Object)
     */
    @Override
    protected IItemProviderDecorator createItemProviderDecorator(final Object target, final Object type) {
        final IItemProviderDecorator decorator = new CollectionIteratorLabelProvider(this);
        if (type == IItemLabelProvider.class) {
            decorator.setDecoratedItemProvider((IChangeNotifier) this.decoratedAdapterFactory.adapt(target,
                    IItemLabelProvider.class));
        } else {
            decorator.setDecoratedItemProvider((IChangeNotifier) this.decoratedAdapterFactory.adapt(target, type));
        }
        return decorator;
    }
}

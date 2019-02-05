/**
 *
 */
package org.palladiosimulator.pcm.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;
import org.eclipse.emf.edit.provider.INotifyChangedListener;


/**
 * @author Snowball
 * This factory generates the default ItemProvider adapter which can be used
 * to display elements in Palladio related GUI elements, e.g., trees or list boxes
 *
 */
public class PalladioItemProviderAdapterFactory
extends DecoratorAdapterFactory
implements INotifyChangedListener, ComposeableAdapterFactory
{

    /**
     * @param decoratedAdapterFactory The factory which gets decorated
     */
    public PalladioItemProviderAdapterFactory(
            final AdapterFactory decoratedAdapterFactory) {
        super(decoratedAdapterFactory);
    }

    /* (non-Javadoc)
     * @see org.eclipse.emf.edit.provider.DecoratorAdapterFactory#createItemProviderDecorator(java.lang.Object, java.lang.Object)
     */
    @Override
    protected IItemProviderDecorator createItemProviderDecorator(final Object target,
            final Object type) {
        final PalladioItemProvider result = new PalladioItemProvider(this);
        if (((Class<?>)type).isInstance(result)) {
            result.addListener(this);
            return result;
        }
        return null;
    }

    @Override
    public void notifyChanged(final Notification notification) {
        fireNotifyChanged(notification);
    }

    /* (non-Javadoc)
     * @see org.eclipse.emf.edit.provider.DecoratorAdapterFactory#getRootAdapterFactory()
     */
    @Override
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return this;
    }

}

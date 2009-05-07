/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.DecoratorAdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

/**
 * @author Snowball
 * This factory generates the default ItemProvider adapter which can be used 
 * to display elements in Palladio related GUI elements, e.g., trees or list boxes 
 *
 */
public class PalladioItemProviderAdapterFactory extends DecoratorAdapterFactory {

	/**
	 * @param decoratedAdapterFactory The factory which gets decorated
	 */
	public PalladioItemProviderAdapterFactory(
			AdapterFactory decoratedAdapterFactory) {
		super(decoratedAdapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.DecoratorAdapterFactory#createItemProviderDecorator(java.lang.Object, java.lang.Object)
	 */
	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target,
			Object Type) {
		IItemProviderDecorator result = new PalladioItemProvider(this.decoratedAdapterFactory);
		if (((Class)Type).isInstance(result)) return result;
		return null;
	}

}

/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemProviderDecorator;

import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProvider;
import de.uka.ipd.sdq.pcmbench.ui.provider.PalladioItemProviderAdapterFactory;

/**Decorator for viewing Palladio items in the Quality model.
 * @author groenda
 *
 */
public class QualityPalladioItemProviderAdapterFactory extends
		PalladioItemProviderAdapterFactory {

	public QualityPalladioItemProviderAdapterFactory(
			AdapterFactory decoratedAdapterFactory) {
		super(decoratedAdapterFactory);
	}

	@Override
	protected IItemProviderDecorator createItemProviderDecorator(Object target,
			Object Type) {
		PalladioItemProvider result = new QualityPalladioItemProvider(this);
		if (((Class)Type).isInstance(result)) {
			result.addListener(this);
			return result;
		}
		return null;
	}
}

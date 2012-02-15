package de.uka.ipd.sdq.pcm.cost.editor.customisation;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.ui.views.properties.IPropertySource;

import de.uka.ipd.sdq.pcm.cost.ScalarFunction;
import de.uka.ipd.sdq.pcmbench.propertytabs.PalladioAdapterFactoryContentProvider;

public class CostPalladioAdapterFactoryContentProvider extends
		PalladioAdapterFactoryContentProvider {
	
	public CostPalladioAdapterFactoryContentProvider(
			AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	protected IPropertySource createPropertySource(Object object, IItemPropertySource itemPropertySource) {
	    if (object instanceof ScalarFunction)
	    {
	    	return getRandomVariablePropertySheet(object, itemPropertySource);
	    }
	    else
	    	return super.createPropertySource(object, itemPropertySource);
	}


}

/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * @author Snowball
 * Palladio Item Provider which renders Labels for elements of the Palladio Component Model
 *
 */
public class PalladioItemProvider extends ItemProviderDecorator implements
		IItemLabelProvider {

	/**
	 * Default constructor
	 * @param adapterFactory Decorated adapter factory
	 */
	public PalladioItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 * A label getter which is aware of the PCM
	 */
	@Override
	public String getText(Object object) {
		String result = "";
		if (object instanceof Entity) {
			result = ((Entity)object).getEntityName();
		} else {
			result = super.getText(object); 
		}
		if (object instanceof Identifier)
		{
			result += " [ID: " + ((Identifier)object).getId() + "]";
		}
		return result; 
	}
}

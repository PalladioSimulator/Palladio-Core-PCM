/**
 * 
 */
package de.uka.ipd.sdq.pcmbench.ui.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * @author Snowball
 * Palladio Item Provider which renders Labels for elements of the Palladio Component Model
 *
 */
public class PalladioItemProvider extends ItemProviderDecorator implements
	IEditingDomainItemProvider,	
	IStructuredItemContentProvider,	
	ITreeItemContentProvider,	
	IItemLabelProvider,	
	IItemPropertySource  {

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
			if (object instanceof EObject && new RepositoryPrinter().doSwitch((EObject)object)!=null)
				result = (String) new RepositoryPrinter().doSwitch((EObject)object);
			else
				result = super.getText(object); 
		}
		if (object instanceof EObject)
		{
			result += " <"+((EObject)object).eClass().getName()+"> ";
		}
		if (object instanceof Identifier)
		{
			result += " [ID: " + ((Identifier)object).getId() + "]";
		}
		return result; 
	}
}

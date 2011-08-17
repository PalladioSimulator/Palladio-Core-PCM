package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;

/** @author roman */
public class CollectionIteratorLabelProvider extends ItemProviderDecorator
		implements IItemLabelProvider {

	public CollectionIteratorLabelProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object object) {
		if (object instanceof Parameter) {
			Parameter parameter = (Parameter) object;
			DataType dataType = parameter.getDataType__Parameter();
			if (dataType == null)
				return parameter.getParameterName() + ": null";
			return parameter.getParameterName() + ": " + super.getText(dataType);
		}
		return super.getText(object);
	}
}

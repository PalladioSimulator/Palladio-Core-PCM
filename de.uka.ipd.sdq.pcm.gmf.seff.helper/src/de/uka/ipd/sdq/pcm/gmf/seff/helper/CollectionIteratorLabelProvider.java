package de.uka.ipd.sdq.pcm.gmf.seff.helper;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * The Class CollectionIteratorLabelProvider.
 * 
 * @author roman
 */
public class CollectionIteratorLabelProvider extends ItemProviderDecorator implements IItemLabelProvider {

    /**
     * Instantiates a new collection iterator label provider.
     * 
     * @param adapterFactory
     *            the adapter factory
     */
    public CollectionIteratorLabelProvider(final AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
     */
    /**
     * Gets the text.
     * 
     * @param object
     *            the object
     * @return the text
     * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getText(java.lang.Object)
     */
    @Override
    public String getText(final Object object) {
        if (object instanceof Parameter) {
            final Parameter parameter = (Parameter) object;
            final DataType dataType = parameter.getDataType__Parameter();
            if (dataType == null) {
                return parameter.getParameterName() + ": null";
            }
            return parameter.getParameterName() + ": " + super.getText(dataType);
        }
        return super.getText(object);
    }
}

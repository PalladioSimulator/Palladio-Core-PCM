package de.uka.ipd.sdq.pcm.dialogs.exception;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.ITableItemLabelProvider;
import org.eclipse.emf.edit.provider.ItemProviderDecorator;

import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Signature;

/** @author roman */
public class ExceptionsItemProvider extends ItemProviderDecorator implements ITableItemLabelProvider,
        IItemLabelProvider {

    /**
     * Inherited default constructor
     * 
     * @param factory
     *            The factory which created this object
     */
    public ExceptionsItemProvider(AdapterFactory adapterFactory) {
        super(adapterFactory);
    }

    /**
     * @see org.eclipse.emf.edit.provider.ItemProviderDecorator#getColumnImage(java.lang.Object,
     *      int) Get the icon by delegation if the first column is displayed
     */
    @Override
    public Object getColumnImage(Object object, int columnIndex) {
        if (columnIndex == ExceptionsDialog.ICON_COLUMN_INDEX)
            return this.getImage(object);
        return null;
    }

    /**
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     *      Format the columns with the given index constant as string text for displaying
     */
    @Override
    public String getColumnText(Object element, int columnIndex) {
        String result = "";
        ExceptionType exceptionType = (ExceptionType) element;

        switch (columnIndex) {
        case ExceptionsDialog.ICON_COLUMN_INDEX:
            break;
        case ExceptionsDialog.CONTEXT_COLUMN_INDEX:
            result = ((Signature) exceptionType.eContainer()).getEntityName();
            break;
        case ExceptionsDialog.NAME_COLUMN_INDEX:
            result = getExceptionName(exceptionType);
            break;
        default:
            break;
        }
        return result == null ? "" : result;
    }

    private String getExceptionName(ExceptionType type) {
        String exceptionName = type.getExceptionName();
        if (exceptionName != null)
            return exceptionName;
        return "null";
    }
}

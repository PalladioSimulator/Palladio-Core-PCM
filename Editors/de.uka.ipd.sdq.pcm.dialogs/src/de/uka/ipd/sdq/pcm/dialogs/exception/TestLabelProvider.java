/**
 * 
 */
package de.uka.ipd.sdq.pcm.dialogs.exception;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import de.uka.ipd.sdq.pcm.repository.ExceptionType;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * @author admin
 * 
 */
public class TestLabelProvider implements ITableLabelProvider {

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
     */
    public Image getColumnImage(Object element, int columnIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
     */
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

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.
     * ILabelProviderListener)
     */
    public void addListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
     */
    public void dispose() {
        // TODO Auto-generated method stub

    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object,
     * java.lang.String)
     */
    public boolean isLabelProperty(Object element, String property) {
        // TODO Auto-generated method stub
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.
     * ILabelProviderListener)
     */
    public void removeListener(ILabelProviderListener listener) {
        // TODO Auto-generated method stub

    }

}

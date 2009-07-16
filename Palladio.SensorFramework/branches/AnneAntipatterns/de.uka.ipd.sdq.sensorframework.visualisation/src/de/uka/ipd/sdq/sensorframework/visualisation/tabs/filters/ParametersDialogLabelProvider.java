/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * @author Roman Andrej
 */
public class ParametersDialogLabelProvider implements ITableLabelProvider {
	
	public ParametersDialogLabelProvider(String context) {
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnImage(java.lang.Object, int)
	 */
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ITableLabelProvider#getColumnText(java.lang.Object, int)
	 */
	public String getColumnText(Object element, int columnIndex) {
		String result = "";
//		
//		FilteredAttributes entry = (FilteredAttributes) element;
//
//		switch (columnIndex) {
//		case CreateEditorContents.ICON_COLUMN_INDEX:
//			break;
//		case CreateEditorContents.CONTEXT_COLUMN_INDEX:
//			result = context;
//			break;
//		case CreateEditorContents.TYPE_COLUMN_INDEX:
//			result = entry.getConfValue().getClass().getSimpleName();
//			break;
//		case CreateEditorContents.NAME_COLUMN_INDEX:
//			result = entry.getDescription();
//			break;
//		default:
//			break;
//		}
		return result;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#addListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#dispose()
	 */
	public void dispose() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#isLabelProperty(java.lang.Object, java.lang.String)
	 */
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IBaseLabelProvider#removeListener(org.eclipse.jface.viewers.ILabelProviderListener)
	 */
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

}

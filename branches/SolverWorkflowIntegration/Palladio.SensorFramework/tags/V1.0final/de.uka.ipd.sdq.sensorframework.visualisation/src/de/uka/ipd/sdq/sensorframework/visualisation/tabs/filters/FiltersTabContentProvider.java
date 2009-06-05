/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs.filters;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

/**
 * @author Roman Andrej
 */
public class FiltersTabContentProvider implements
		IStructuredContentProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof ConfigEditorInput) {
			ConfigEditorInput configuration = (ConfigEditorInput) inputElement;
			return configuration.getFiltersManager()
					.getFactories().toArray();
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		// The implementation is not necessary.
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object, java.lang.Object)
	 */
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// The implementation is not necessary.
	}

}

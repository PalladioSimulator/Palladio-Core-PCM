/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.tabs;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IEditorPart;

import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;

/**
 * @author admin
 *
 */
public class TabbedLabelProvider extends LabelProvider {

	/* (non-Javadoc)
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		IEditorPart editor = VisualisationPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		return editor.getTitle();
	}
}

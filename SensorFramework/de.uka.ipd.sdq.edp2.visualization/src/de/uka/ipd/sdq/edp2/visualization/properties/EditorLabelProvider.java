/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.properties;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.ui.IEditorPart;
import de.uka.ipd.sdq.edp2.visualization.Activator;


/**
 * @author Roland Richter
 *
 */
public class EditorLabelProvider extends LabelProvider {
	/**logger*/
	private static Logger logger = Logger.getLogger(EditorLabelProvider.class.getCanonicalName());
	
	
	/**
	 * @see org.eclipse.jface.viewers.ILabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		IEditorPart editor = null;
		try {editor = Activator.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor(); }
		catch (NullPointerException npe) {
			logger.log(Level.SEVERE, "Properties were created before editor.");
		}
		if (editor != null) {
		logger.log(Level.INFO, "editor.getTitle:"+editor.getTitle());
		return editor.getTitle();
		} else {
			return "titleNotFound";
		}
	}
	

}

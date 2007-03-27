/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.tabs;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.part.IDropActionDelegate;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

/**
 * @author admin
 *
 */
public class DropAdapter implements IDropActionDelegate {

	/* (non-Javadoc)
	 * @see org.eclipse.ui.part.IDropActionDelegate#run(java.lang.Object, java.lang.Object)
	 */
	@Override
	public boolean run(Object source, Object target) {
		/// IStructuredSelection sel = (IStructuredSelection)viewer.getSelection();
	      //parent of the pasted object is the current selection,
	      //or the viewer input if nothing is selected
	     // Gadget parent = (Gadget)sel.getFirstElement();
		
		if (target instanceof ExperimentRun) {
			ExperimentRun new_name = (ExperimentRun) target;
			
		}
		// TODO Auto-generated method stub
		return false;
	}

}

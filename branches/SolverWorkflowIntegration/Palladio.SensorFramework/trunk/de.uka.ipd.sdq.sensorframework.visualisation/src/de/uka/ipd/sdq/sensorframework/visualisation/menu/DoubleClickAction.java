package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

/** @author roman */
public class DoubleClickAction extends Action {

	private ConfigEditorInput editorInput;
	private String editorID;
	
	public DoubleClickAction(ConfigEditorInput editorInput, String editorID) {
		this.editorInput = editorInput;
		this.editorID = editorID;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.action.Action#run()
	 */
	@Override
	public void run() {
		IWorkbenchPage page = VisualisationPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		try {
			page.openEditor(editorInput, editorID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

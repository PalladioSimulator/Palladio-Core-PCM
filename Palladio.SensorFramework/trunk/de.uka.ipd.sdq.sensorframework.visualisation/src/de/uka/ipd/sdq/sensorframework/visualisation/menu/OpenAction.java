package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.sensorframework.visualisation.SimuPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

public class OpenAction extends Action {

	private String editorID;

	public OpenAction(String label, String editorID){
		super(label);
		this.editorID = editorID;
	}
	
	@Override
	public void run() {
		IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		try {
			page.openEditor(new ConfigEditorInput(),
					editorID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

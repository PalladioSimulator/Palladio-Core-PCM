package de.uka.ipd.sdq.sensorframework.visualisation.menu;

import org.eclipse.jface.action.Action;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.sensorframework.visualisation.VisualisationPlugin;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

public class OpenAction extends Action {

	private String editorID;
	private String adapterFactoryID;

	public OpenAction(String label, String adapterFactoryID, String editorID){
		super(label);
		this.editorID = editorID;
		this.adapterFactoryID = adapterFactoryID;
	}
	
	@Override
	public void run() {
		IWorkbenchPage page = VisualisationPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		try {
			page.openEditor(new ConfigEditorInput(adapterFactoryID),
					editorID);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

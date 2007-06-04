package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.EditorInputTransfer;

import com.sun.xml.internal.bind.v2.model.core.Adapter;

import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.adapter.AdapterRegistry;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.visualisation.dialogs.ActionListSelectionDialog;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEntry;

/**
 * @author admin
 */
public class TreeDragSourceListener implements DragSourceListener {

	TreeViewer viewer;
	
	public TreeDragSourceListener(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();
		ConfigEditorInput editorInput = new ConfigEditorInput();

		if (EditorInputTransfer.getInstance().isSupportedType(event.dataType)) {
			TreeObject treeObject = (TreeObject) object;
			Object innerObject = treeObject.getObject();
			/** Sensor */
			if (innerObject instanceof Sensor) {
				Sensor sensor = (Sensor) innerObject;

				ConfigEntry configEntry = new ConfigEntry(treeObject.getRun(),
						treeObject.getExperiment(), sensor);
				editorInput.addConfigEntry(configEntry);
			}
			/** Experiment Run*/
			if (innerObject instanceof ExperimentRun) {
				ExperimentRun run = (ExperimentRun) innerObject;
				ConfigEntry configEntry = new ConfigEntry(run, treeObject
						.getExperiment(), null);
				editorInput.addConfigEntry(configEntry);
			}
			
			IConfigurationElement action = getSelectedAction(event.display
					.getActiveShell());
			EditorInputTransfer.EditorInputData[] transferArray = new EditorInputTransfer.EditorInputData[] { EditorInputTransfer
					.createEditorInputData(action.getAttribute("editorID"),
							editorInput) };
			event.data = transferArray;

		} else if (LocalSelectionTransfer.getTransfer().isSupportedType(
				event.dataType)) {
			LocalSelectionTransfer.getTransfer().setSelection(selection);
		}
	}

	/**
	 * @return - choose Action from ActionListSelectionDialog
	 */
	private IConfigurationElement getSelectedAction(Shell shell) {
		ActionListSelectionDialog dialog = new ActionListSelectionDialog(shell);
		dialog.setElements(getElements());
		dialog.open();
		Object[] results = dialog.getResult();
		return (IConfigurationElement) results[0];
	}
	
	/**
	 * @return - actions, which are present in Menu/Visualization
	 */
	private Object[] getElements() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"de.uka.ipd.sdq.sensorframework.visualisation");
		return configurationElements;
	}
	
	/**
	 * @return - adapters, which are present 
	 */
	private Object[] getAdapters() {
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						"de.uka.ipd.sdq.sensorframework.adapter");
		
		Object[] adapters = new Object[configurationElements.length];
		for(int i = 0; i<configurationElements.length; i++){
			IConfigurationElement element = configurationElements[i];
			try {
				adapters[i] = element.createExecutableExtension("class");
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return adapters;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();

		event.doit = false;

		if (object instanceof TreeObject) {
			event.doit = true;
			// if the sensor is not a child from ExperimentRun
			TreeObject treeObject = (TreeObject) object;
			ExperimentRun run = treeObject.getRun();
			if (treeObject.getObject() instanceof Sensor && run == null)
				event.doit = false;
		}
	}

	public void dragFinished(DragSourceEvent event) {
	}
}

/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

/**
 * @author admin
 *
 */
public class TreeDragSourceListener implements DragSourceListener {

	TreeViewer viewer;
	/**
	 * @param viewer
	 */
	public TreeDragSourceListener(TreeViewer viewer) {
		this.viewer = viewer;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		Object object = selection.getFirstElement();
		
		/*		if (EditorInputTransfer.getInstance().isSupportedType(event.dataType)) {
			EditorInputTransfer.EditorInputData data = EditorInputTransfer
					.createEditorInputData(editorId, new ConfigEditorInput());
			event.data = new EditorInputTransfer.EditorInputData[] { data };
		}*/
		
		// create chart and initialisation with Experiment run
		if (object instanceof ExperimentRun) {
			
			ExperimentRun run = (ExperimentRun) object;
			IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();

			if (page.getActiveEditor() == null) {
				try {
					page.openEditor(new ConfigEditorInput(run),
							ReportView.EDITOR_ID);
				} catch (PartInitException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragStart(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	public void dragStart(DragSourceEvent event) {
		IEditorPart editor = SimuPlugin.getDefault().getWorkbench()
				.getActiveWorkbenchWindow().getActivePage().getActiveEditor();
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();
		
		event.doit = false;
		
		if (object instanceof ExperimentRun)
			event.doit = true;
		if (editor != null && object instanceof Sensor)
			event.doit = true;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub
		
	}

}

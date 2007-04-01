/**
 * 
 */
package de.uka.ipd.sdq.codegen.simudatavisualization.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.part.NullEditorInput;
import org.eclipse.ui.part.EditorInputTransfer;

import de.uka.ipd.sdq.codegen.simudatavisualization.SimuPlugin;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;

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
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragFinished(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	@Override
	public void dragFinished(DragSourceEvent event) {
		
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DragSourceListener#dragSetData(org.eclipse.swt.dnd.DragSourceEvent)
	 */
	@Override
	public void dragSetData(DragSourceEvent event) {
		String editorId = ReportView.EDITOR_ID;
		IEditorInput editorInput;
		
		IStructuredSelection selection = (IStructuredSelection)viewer.getSelection();
		Object object = selection.getFirstElement();
		
		// TODO
//		if (EditorInputTransfer.getInstance().isSupportedType(event.dataType)) {
//			EditorInputTransfer.EditorInputData data = EditorInputTransfer
//					.createEditorInputData(editorId, editorInput);
//			event.data = new EditorInputTransfer.EditorInputData[] { data };
//		}
		
		// create chart and initialisation with Experiment run
		if (object instanceof ExperimentRun) {
			ExperimentRun run = (ExperimentRun) object;

			IWorkbenchPage page = SimuPlugin.getDefault().getWorkbench()
					.getActiveWorkbenchWindow().getActivePage();
			if (page.getActiveEditor() == null) {
				try {
					editorInput = new ConfigEditorInput(run);
					ReportView editor = (ReportView) page.openEditor(editorInput, editorId);
					//editor.setInitEntry(run);
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
	@Override
	public void dragStart(DragSourceEvent event) {
		event.doit = !viewer.getSelection().isEmpty();

	}

}

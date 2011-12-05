package de.uka.ipd.sdq.edp2.models.ExperimentData.presentation;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.part.EditorInputTransfer;

public class DataSourceDragSourceListener implements DragSourceListener {

	private TreeViewer viewer;

	public DataSourceDragSourceListener(TreeViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		Object object = selection.getFirstElement();

		if (EditorInputTransfer.getInstance().isSupportedType(event.dataType)) {
			event.data = object;

		}
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		event.doit = true;

	}

}

package de.uka.ipd.sdq.edp2.models.ExperimentData.presentation;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.DragSourceListener;
import org.eclipse.ui.part.EditorInputTransfer;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.datasource.EDP2Source;

/**
 * Listener for drag-support of the {@link ExperimentDataEditor}.
 * @author Dominik Ernst
 *
 */
public class DataSourceDragSourceListener implements DragSourceListener {

	private final static Logger logger = Logger.getLogger(DataSourceDragSourceListener.class.getName());
	
	private StructuredViewer viewer;

	public DataSourceDragSourceListener(StructuredViewer viewer) {
		this.viewer = viewer;
	}

	@Override
	public void dragFinished(DragSourceEvent event) {
	}

	@Override
	public void dragSetData(DragSourceEvent event) {
		if (LocalSelectionTransfer.getTransfer().isSupportedType(event.dataType)) {
		IStructuredSelection selection = (IStructuredSelection) viewer
				.getSelection();
		event.data = selection.getFirstElement();
		LocalSelectionTransfer.getTransfer().setSelection(selection);
		logger.log(Level.INFO, "selection is supported by transfer");
		}
	}

	@Override
	public void dragStart(DragSourceEvent event) {
		event.detail = DND.DROP_LINK;
	}

}

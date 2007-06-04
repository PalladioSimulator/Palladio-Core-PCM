package de.uka.ipd.sdq.sensorframework.visualisation.views;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.views.navigator.LocalSelectionTransfer;

import de.uka.ipd.sdq.sensorfactory.entities.Sensor;
import de.uka.ipd.sdq.sensorframework.visualisation.editor.ConfigEditorInput;

/**
 * @author admin
 *
 */
public class ViewDropTargetListener extends DropTargetAdapter {

	private ConfigEditorInput configEditorInput;

	public ViewDropTargetListener(IEditorInput editorInput) {
		this.configEditorInput = (ConfigEditorInput)editorInput;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		if (event.detail == DND.DROP_DEFAULT) 
		{
			 if ((event.operations & DND.DROP_COPY) != 0)
			 	event.detail = DND.DROP_COPY;
			 else 
			 	event.detail = DND.DROP_NONE; 
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragLeave(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragLeave(DropTargetEvent event) {
		// TODO Auto-generated method stub
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOperationChanged(DropTargetEvent event) {
		if (event.detail == DND.DROP_DEFAULT) 
		{
			 if ((event.operations & DND.DROP_COPY) != 0)
			 	event.detail = DND.DROP_COPY;
			 else 
			 	event.detail = DND.DROP_NONE; 
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#drop(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void drop(DropTargetEvent event) {
		IStructuredSelection selection = (IStructuredSelection)
			LocalSelectionTransfer.getTransfer().getSelection();
		Object object = selection.getFirstElement();
		if (object instanceof TreeObject && ((TreeObject)object).getObject() instanceof Sensor) {
			TreeObject treeObject = (TreeObject) object;
			Sensor sensor = (Sensor) treeObject.getObject();
			configEditorInput.editConfigEntry(treeObject.getRun(), treeObject
					.getExperiment(), sensor);
		}
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetListener#dropAccept(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dropAccept(DropTargetEvent event) {
		// TODO Auto-generated method stub
	}

}

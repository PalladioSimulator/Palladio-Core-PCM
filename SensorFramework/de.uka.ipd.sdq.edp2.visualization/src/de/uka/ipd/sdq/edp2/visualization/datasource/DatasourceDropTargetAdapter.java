/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.datasource;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DropTargetAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInput;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;

/**
 * @author Dominik Ernst
 *
 */
public class DatasourceDropTargetAdapter extends DropTargetAdapter {

	private final static Logger logger = Logger.getLogger(DatasourceDropTargetAdapter.class.getName());
	private IVisualizationInputHandle inputHandle;
	
	public DatasourceDropTargetAdapter(IVisualizationInputHandle inputHandle){
		this.inputHandle = inputHandle;
	}
	
	public void drop(DropTargetEvent event){
		IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
		.getTransfer().getSelection();
		if (selection.getFirstElement() instanceof RawMeasurements){
			EDP2Source newSource = new EDP2Source((RawMeasurements) selection.getFirstElement());
			IVisualizationInput firstInput = (IVisualizationInput) inputHandle.getInputs().get(0);
			inputHandle.addInput(firstInput.createTransformationsChainCopy(newSource));
			logger.log(Level.INFO, "added new input:"+newSource.getRawMeasurementsUUID());
		}
		logger.log(Level.INFO, "dropped element: "+selection.getFirstElement().toString());
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragOperationChanged(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragOperationChanged(DropTargetEvent event) {
		event.detail = DND.DROP_LINK;
	}

	/* (non-Javadoc)
	 * @see org.eclipse.swt.dnd.DropTargetAdapter#dragEnter(org.eclipse.swt.dnd.DropTargetEvent)
	 */
	@Override
	public void dragEnter(DropTargetEvent event) {
		event.detail = DND.DROP_LINK;
	}
	
	
	
}

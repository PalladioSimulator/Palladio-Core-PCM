/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.datasource;

import org.eclipse.jface.util.LocalSelectionTransfer;
import org.eclipse.jface.viewers.IStructuredSelection;
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

	private IVisualizationInputHandle inputHandle;
	
	public DatasourceDropTargetAdapter(IVisualizationInputHandle inputHandle){
		this.inputHandle = inputHandle;
	}
	
	public void drop(DropTargetEvent event){
		IStructuredSelection selection = (IStructuredSelection) LocalSelectionTransfer
		.getTransfer().getSelection();
		Object object = selection.getFirstElement();
		if (object instanceof RawMeasurements) {
			RawMeasurements rm = (RawMeasurements) object;
			EDP2Source datasource = new EDP2Source(rm);
			IVisualizationInput firstInput = inputHandle.getInputs().get(0);
			inputHandle.addInput(firstInput.createTransformationsChainCopy(datasource));
		}
	}
	
	
}

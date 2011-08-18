package de.uka.ipd.sdq.edp2.visualization.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;

/**
 * Simple instance of a default {@link ElementListSelectionDialog}. Shows a list of available Editors for
 * selected {@link RawMeasurements}.
 * @author ernst
 *
 */
public class SelectVisualizationDialog extends ElementListSelectionDialog {
	
	/**
	 * Default constructor, which simply calls the parents class' constructor. 
	 * @param parent the shell window in which the dialog is created
	 * @param renderer a label provider for the list items
	 */
	public SelectVisualizationDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
	}

}

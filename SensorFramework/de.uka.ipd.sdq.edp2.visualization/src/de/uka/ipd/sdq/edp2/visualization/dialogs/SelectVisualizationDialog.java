package de.uka.ipd.sdq.edp2.visualization.dialogs;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;

public class SelectVisualizationDialog extends ElementListSelectionDialog {
	
	public SelectVisualizationDialog(Shell parent, ILabelProvider renderer) {
		super(parent, renderer);
	}

}

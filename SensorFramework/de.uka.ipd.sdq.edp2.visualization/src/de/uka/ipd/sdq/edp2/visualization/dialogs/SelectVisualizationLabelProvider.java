package de.uka.ipd.sdq.edp2.visualization.dialogs;

import org.eclipse.jface.viewers.LabelProvider;

import de.uka.ipd.sdq.edp2.visualization.IVisualization;

/**
 * {@link LabelProvider} for items in a {@link SelectVisualizationDialog}.
 * @author ernst
 *
 */
public class SelectVisualizationLabelProvider extends LabelProvider {

	/**
	 * Default, empty constructor.
	 */
	public SelectVisualizationLabelProvider() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@Override
	public String getText(Object element) {
		IVisualization editor = null;
		if (element instanceof IVisualization) {
			editor = (IVisualization) element;
		}
		return editor == null ? "No Editor found!" : editor.getClass().getName();
	}
	
	

}

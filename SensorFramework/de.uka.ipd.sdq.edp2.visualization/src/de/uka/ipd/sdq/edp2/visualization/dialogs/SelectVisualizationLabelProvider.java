package de.uka.ipd.sdq.edp2.visualization.dialogs;

import org.eclipse.jface.viewers.LabelProvider;

import de.uka.ipd.sdq.edp2.visualization.IDataSink;
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
		IDataSink editorInput = null;
		if (element instanceof IDataSink) {
			editorInput = (IDataSink) element;
		}
		return editorInput == null ? "No Editor found!" : editorInput.getFactoryId();
	}
	
	

}

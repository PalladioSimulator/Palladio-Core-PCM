package de.uka.ipd.sdq.edp2.visualization.dialogs;

import org.eclipse.jface.viewers.LabelProvider;

import de.uka.ipd.sdq.edp2.visualization.IVisualization;


public class SelectVisualizationLabelProvider extends LabelProvider {

	public SelectVisualizationLabelProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getText(Object element) {
		IVisualization editor = null;
		if (element instanceof IVisualization) {
			editor = (IVisualization) element;
		}
		return editor == null ? "No Editor found!" : editor.getClass().getName();
		//return super.getText(element);
	}
	
	

}

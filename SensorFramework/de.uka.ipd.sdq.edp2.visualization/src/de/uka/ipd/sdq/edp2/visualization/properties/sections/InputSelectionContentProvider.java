/**
 * 
 */
package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.util.ArrayList;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.uka.ipd.sdq.edp2.visualization.AbstractTransformation;
import de.uka.ipd.sdq.edp2.visualization.IDataSink;
import de.uka.ipd.sdq.edp2.visualization.IVisualizationInputHandle;

/**
 * @author Dominik Ernst
 * 
 */
public class InputSelectionContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getChildren(Object parentElement) {
		ArrayList<Object> transformations = new ArrayList<Object>();
		IDataSink sinkParent = (IDataSink) parentElement;
		while (sinkParent.getSource() instanceof AbstractTransformation) {
			sinkParent = (AbstractTransformation) sinkParent.getSource();
			transformations.add(sinkParent);
		}
		return transformations.toArray();
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof AbstractTransformation)
			return false;
		return true;
	}

	@Override
	public Object[] getElements(Object inputElement) {
		return ((IVisualizationInputHandle)inputElement).getInputs().toArray();
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

}

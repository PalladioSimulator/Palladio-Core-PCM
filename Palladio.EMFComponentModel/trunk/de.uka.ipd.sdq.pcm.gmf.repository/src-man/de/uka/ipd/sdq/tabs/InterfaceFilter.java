package de.uka.ipd.sdq.tabs;

import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.viewers.IFilter;
import org.eclipse.jface.viewers.IStructuredSelection;

import de.uka.ipd.sdq.pcm.repository.Interface;

public class InterfaceFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		Object input = toTest;
		if (input instanceof GraphicalEditPart)
		{
			GraphicalEditPart ep = (GraphicalEditPart)input;
			input = ep.getModel();
		}
		if (input instanceof View){
			input = ((View)input).getElement();
		}
		return input instanceof Interface;
	}

}

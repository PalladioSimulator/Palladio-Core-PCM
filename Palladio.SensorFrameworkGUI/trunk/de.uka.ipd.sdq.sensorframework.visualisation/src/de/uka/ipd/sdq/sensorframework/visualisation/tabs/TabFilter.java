package de.uka.ipd.sdq.sensorframework.visualisation.tabs;

import org.eclipse.jface.viewers.IFilter;

public class TabFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		return true;
	}

}

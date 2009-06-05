package de.uka.ipd.sdq.sensorframework.visualisation;

import java.util.Collection;

public interface IVisualisation {
	public void setInput(Collection c);
	public void addInput(Collection c);
	public void deleteInput(Collection c);
}

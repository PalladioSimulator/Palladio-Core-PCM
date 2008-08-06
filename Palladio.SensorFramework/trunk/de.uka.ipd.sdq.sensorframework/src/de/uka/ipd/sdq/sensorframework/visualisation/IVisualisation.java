package de.uka.ipd.sdq.sensorframework.visualisation;

import java.util.Collection;

/**
 * Interface for a sensorframework visualisation / editor.
 * @author Steffen Becker
 *
 * @param <T> The class of the data which can be displayed in this viewer
 */
public interface IVisualisation<T> {
	/**
	 * Display the given set of data 
	 * @param c The data to display. It is of type T which is understood by the viewer
	 */
	public void setInput(Collection<T> c);
	public void addInput(Collection<T> c);
	public void deleteInput(Collection<T> c);
}

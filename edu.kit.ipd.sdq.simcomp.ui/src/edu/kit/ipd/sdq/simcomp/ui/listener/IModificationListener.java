package edu.kit.ipd.sdq.simcomp.ui.listener;

/**
 * A listener intended to be registered and simulation component configurators
 * or rule editors to be notified if a user changes something in the
 * configuration.
 * 
 * @author Christoph Föhrdes
 * 
 */
public interface IModificationListener {

	/**
	 * Called when the configuration was modified.
	 */
	public void modified();

}

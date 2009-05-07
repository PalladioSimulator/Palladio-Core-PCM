package org.somox.controller;

import org.somox.configuration.ConfigurableComponent;
import org.somox.core.SoMoXCore;

/**
 * A Controller interface according to the observer (pulish/subscribe) pattern.
 * All plug-ins trying to control the SoMoX core have to implement such a controller to
 * a SoMoX core listener can register to.
 *
 * @author Benjamin Klatt
 *
 */
public interface SoMoXCoreController extends ConfigurableComponent {

	/** Register a listener for core events to the controller */
	public void register(SoMoXCoreControllerListener listener);

	/** Unregister a listener for core events from the controller */
	public void unregister(SoMoXCoreControllerListener listener);

	/** Set the connection to the SoMoX Core */
	public void setSoMoXCore(SoMoXCore somoxCore);
}

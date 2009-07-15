/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */
package org.opt4j.gui;

import org.opt4j.start.Opt4JModule;

import com.google.inject.Binder;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code VisualizationModule}.
 * 
 * @author lukasiewycz
 * 
 */
public abstract class VisualizationModule extends Opt4JModule {

	/**
	 * Add a {@code ToolBarService}.
	 * 
	 * @param toolBarService
	 *            the {@code ToolBarService} to be added
	 */
	protected void addToolBarService(Class<? extends ToolBarService> toolBarService) {
		Multibinder<ToolBarService> multibinder = Multibinder.newSetBinder(binder(), ToolBarService.class);
		multibinder.addBinding().to(toolBarService);
	}

	/**
	 * Add a {@code ToolBarService}.
	 * 
	 * @param binder
	 *            the binder
	 * @param toolBarService
	 *            the {@code ToolBarService} to be added
	 */
	public static void addToolBarService(Binder binder, Class<? extends ToolBarService> toolBarService) {
		Multibinder<ToolBarService> multibinder = Multibinder.newSetBinder(binder, ToolBarService.class);
		multibinder.addBinding().to(toolBarService);
	}

	/**
	 * Add a {@code IndividualMouseListener}.
	 * 
	 * @param individualMouseListener
	 *            the {@code IndividualMouseListener} to be added
	 */
	protected void addIndividualMouseListener(Class<? extends IndividualMouseListener> individualMouseListener) {
		Multibinder<IndividualMouseListener> multibinder = Multibinder.newSetBinder(binder(), IndividualMouseListener.class);
		multibinder.addBinding().to(individualMouseListener);
	}

	/**
	 * Add a {@code IndividualMouseListener}.
	 * 
	 * @param binder
	 *            the binder
	 * @param individualMouseListener
	 *            the {@code IndividualMouseListener} to be added
	 */
	public static void addIndividualMouseListener(Binder binder, Class<? extends IndividualMouseListener> individualMouseListener) {
		Multibinder<IndividualMouseListener> multibinder = Multibinder.newSetBinder(binder, IndividualMouseListener.class);
		multibinder.addBinding().to(individualMouseListener);
	}

}

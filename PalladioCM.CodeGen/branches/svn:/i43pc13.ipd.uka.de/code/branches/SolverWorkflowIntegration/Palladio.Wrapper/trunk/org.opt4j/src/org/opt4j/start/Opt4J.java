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
package org.opt4j.start;

import org.opt4j.config.Task;
import org.opt4j.config.visualization.About;
import org.opt4j.config.visualization.Configurator;
import org.opt4j.config.visualization.TasksPanel;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * The {@code Opt4J} configuration GUI.
 * 
 * @author lukasiewycz
 * 
 */
public class Opt4J extends Configurator {

	/**
	 * Starts the Opt4J configuration GUI.
	 * 
	 * @param args
	 *            accepts a configuration file
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		if (args.length > 0 && args[0].equalsIgnoreCase("-s")) {
			String[] a = new String[args.length - 1];
			System.arraycopy(args, 1, a, 0, a.length);
			Opt4JStarter.main(a);
		} else {
			Configurator configurator = new Opt4J();
			//calls Opt4J.start because of polymorphism (careful with Eclipse's F3)
			configurator.start(args);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.config.gui.Configurator#start(java.lang.String[])
	 */
	@Override
	public void start(String[] args) {
		String filename = null;
		if (args.length > 0) {
			filename = args[0];
		}
		main(Opt4JTask.class, filename);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.config.gui.Configurator#getModule(java.lang.Class)
	 */
	@Override
	public Module getModule(final Class<? extends Task> taskClass) {
		Module module = new Module() {
			public void configure(Binder b) {
				b.bind(Task.class).to(taskClass);
				b.bind(About.class).to(Opt4JAbout.class);
				b.bind(TasksPanel.class).to(Opt4JTasksPanel.class);
			}
		};
		return module;
	}

}

/** Opt4J is free software: you can redistribute it and/or modify it under
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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import org.opt4j.config.Icons;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerStateListener;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code Viewer}.
 * 
 * @author lukasiewycz
 * 
 */
public class Viewer extends JFrame implements OptimizerStateListener {

	/**
	 * The {@code CloseEvent} that is triggered if this viewer is closed.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	public enum CloseEvent {
		/**
		 * Optimization continues.
		 */
		NONE,
		/**
		 * Optimization is stopped.
		 */
		STOP,
		/**
		 * Optimization is terminated.
		 */
		TERMINATE;

	}

	protected final Optimizer optimizer;

	protected final Control control;

	protected final CloseEvent closeEvent;

	protected final boolean closeOnStop;

	protected final String title;

	protected final Set<ToolBarService> toolBarServices = new HashSet<ToolBarService>();

	protected final Viewport viewport;

	protected final ToolBar toolBar;

	protected final StatusBar statusBar;

	/**
	 * Constructs a {@code Viewer}.
	 * 
	 * @param viewport
	 *            the viewport
	 * @param toolBarServices
	 *            the toolbar services
	 * @param optimizer
	 *            the optimier
	 * @param control
	 *            the control
	 * @param title
	 *            the title of the frame
	 * @param closeEvent
	 *            event on closing the GUI window
	 * @param closeOnStop
	 *            close window at the end of the optimization run
	 */
	@Inject
	public Viewer(
			Viewport viewport,
			ToolBar toolBar,
			StatusBar statusBar,
			Set<ToolBarService> toolBarServices,
			Optimizer optimizer,
			Control control,
			@Constant(value = "title", namespace = Viewer.class) String title,
			@Constant(value = "closeEvent", namespace = Viewer.class) CloseEvent closeEvent,
			@Constant(value = "closeOnStop", namespace = Viewer.class) boolean closeOnStop) {

		this.viewport = viewport;
		this.toolBar = toolBar;
		this.statusBar = statusBar;
		this.title = title;
		this.optimizer = optimizer;
		this.control = control;
		this.closeEvent = closeEvent;
		this.closeOnStop = closeOnStop;

		this.toolBarServices.addAll(toolBarServices);

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected final void init() {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {

				ImageIcon logo = Icons.getIcon(Icons.OPT4J);
				setIconImage(logo.getImage());
				setTitle(title);
				setLayout(new BorderLayout());
				setPreferredSize(new Dimension(800, 600));

				toolBar.init();
				viewport.init();
				statusBar.init();

				add(toolBar.get(), BorderLayout.NORTH);
				add(viewport.get(), BorderLayout.CENTER);
				add(statusBar.get(), BorderLayout.SOUTH);

				WindowListener windowListener = new WindowAdapter() {
					@Override
					public void windowClosing(WindowEvent e) {
						switch (closeEvent) {
						case NONE:
							break;
						case TERMINATE:
							control.doTerminate();
							break;
						default:
							control.doStop();
						}
						dispose();
					}
				};

				addWindowListener(windowListener);
				setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

				pack();
				setVisible(true);
			}
		});
	}

	/**
	 * Registers the listeners.
	 */
	@Inject
	protected void registerListeners() {
		optimizer.addOptimizerStateListener(this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerStateListener#optimizationStarted(org
	 * .opt4j.core.optimizer.Optimizer)
	 */
	public void optimizationStarted(Optimizer optimizer) {
		init();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerStateListener#optimizationStopped(org
	 * .opt4j.core.optimizer.Optimizer)
	 */
	public void optimizationStopped(Optimizer optimizer) {
		if (closeOnStop) {
			dispose();
		}
	}

	private static final long serialVersionUID = 1L;
}
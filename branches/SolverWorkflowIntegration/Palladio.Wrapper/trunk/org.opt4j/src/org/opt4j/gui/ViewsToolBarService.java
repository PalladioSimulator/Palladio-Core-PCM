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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import org.opt4j.config.Icons;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * The {@code ViewsToolBarService} can open a {@code ArchiveWidget}, {@code
 * PopulationWidget}, or {@code PlotWidget}. This service has a {@link Order}
 * with {@code -50}.
 * 
 * @see ArchiveWidget
 * @see PopulationWidget
 * @see PlotWidget
 * @author lukasiewycz
 * 
 */
@Order(-50)
public class ViewsToolBarService implements ToolBarService {

	protected final Viewport viewport;
	protected final Provider<ArchiveWidget> archiveWidgetProvider;
	protected final Provider<PopulationWidget> populationWidgetProvider;
	protected final Provider<PlotWidget> plotWidgetProvider;
	protected ArchiveWidget archiveWidget = null;
	protected PopulationWidget populationWidget = null;

	/**
	 * Constructs a {@code ViewsToolBarService}.
	 * 
	 * @param viewport
	 * @param archiveWidgetProvider
	 * @param populationWidgetProvider
	 * @param plotWidgetProvider
	 */
	@Inject
	public ViewsToolBarService(Viewport viewport,
			Provider<ArchiveWidget> archiveWidgetProvider,
			Provider<PopulationWidget> populationWidgetProvider,
			Provider<PlotWidget> plotWidgetProvider) {
		super();
		this.viewport = viewport;
		this.archiveWidgetProvider = archiveWidgetProvider;
		this.populationWidgetProvider = populationWidgetProvider;
		this.plotWidgetProvider = plotWidgetProvider;
	}

	@Override
	public JToolBar getToolBar() {
		JToolBar toolbar = new JToolBar("Views");

		JButton buttonArchive = new JButton(Icons.getIcon(Icons.ARCHIVE));
		buttonArchive.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Widget widget = getArchiveWidget();
				viewport.addWidget(widget);
			}
		});
		buttonArchive.setToolTipText("Archive");
		buttonArchive.setFocusable(false);

		JButton buttonPopulation = new JButton(Icons.getIcon(Icons.POPULATION));
		buttonPopulation.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Widget widget = getPopulationWidget();
				viewport.addWidget(widget);
			}
		});
		buttonPopulation.setToolTipText("Population");
		buttonPopulation.setFocusable(false);

		JButton buttonPlot = new JButton(Icons.getIcon(Icons.PARETO));
		buttonPlot.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Widget widget = getPlotWidget();
				viewport.addWidget(widget);
			}
		});
		buttonPlot.setToolTipText("Pareto Plot");
		buttonPlot.setFocusable(false);

		toolbar.add(buttonArchive);
		toolbar.add(buttonPopulation);
		toolbar.add(buttonPlot);

		return toolbar;
	}

	protected ArchiveWidget getArchiveWidget() {
		if (archiveWidget == null) {
			archiveWidget = archiveWidgetProvider.get();
		}
		return archiveWidget;
	}

	protected PopulationWidget getPopulationWidget() {
		if (populationWidget == null) {
			populationWidget = populationWidgetProvider.get();
		}
		return populationWidget;
	}

	protected PlotWidget getPlotWidget() {
		return plotWidgetProvider.get();
	}

}

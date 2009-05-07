package de.uka.ipd.sdq.sensorframework.visualisation.actions;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.device.IDisplayServer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
//import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.script.IExternalContext;
import org.eclipse.birt.chart.util.PluginSettings;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

public class ExportAsPNGAction extends Action implements IAction {

	private Chart chart;

	public ExportAsPNGAction(Chart chart) {
		super();
		this.setText("Save as PNG...");
		this.chart = chart;
	}
	
	@Override
	public void run(){
		IDeviceRenderer idr = null;
		final PluginSettings ps = PluginSettings.instance();

		try {
			idr = ps.getDevice("dv.PNG");

			idr.setProperty(IDeviceRenderer.FILE_IDENTIFIER,
					"C:\\temp\\test.png");

			// DEFINE THE BOUNDS AND CONVERT INTO POINTS
			Bounds bo = BoundsImpl.create(0, 0, 800, 600); // IN PIXELS
			bo.scale(72d / idr.getDisplayServer().getDpiResolution()); // CONVERTED
																		// TO
																		// POINTS

			// BUILD THE RENDERED CHART STRUCTURE
			Generator gr = Generator.instance();
			GeneratedChartState gcs = null;

			gcs = gr.build(idr.getDisplayServer(), chart, bo, null, null);
			gr.render(idr, gcs);

		} catch (ChartException pex) {
			//DefaultLoggerImpl.instance().log(pex);
			throw new RuntimeException(pex.getLocalizedMessage());
		}
	}

}

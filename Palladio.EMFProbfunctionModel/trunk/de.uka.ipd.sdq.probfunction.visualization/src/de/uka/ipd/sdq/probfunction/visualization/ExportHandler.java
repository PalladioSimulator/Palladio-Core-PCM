/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.internal.log.DefaultLoggerImpl;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.script.IExternalContext;
import org.eclipse.birt.chart.util.PluginSettings;

/**
 * @author Ihssane
 * 
 */
public class ExportHandler {

	public enum ImageFormat {
		PNG, SVG
	};

	private static final int DEFAULT_W = 500;
	private static final int DEFAULT_H = 350;

	private Chart chart;
	private ImageFormat format;
	private int width = DEFAULT_W;
	private int height = DEFAULT_H;

	/**
	 * @param chart
	 */
	public ExportHandler(Chart chart, ImageFormat format) {
		super();
		this.format = format;
		this.chart = chart;
	}

	public void exportChartToPNGImage(String fileName) {
		// OBTAIN A PNG IMAGE DEVICE RENDERER
		PluginSettings ps = PluginSettings.instance();
		IDeviceRenderer idr = null;
		try {
			switch (format) {
				case PNG :
					idr = ps.getDevice("dv.PNG");
					break;
				case SVG :
					idr = ps.getDevice("dv.SVG");
					break;
				default :
					idr = ps.getDevice("dv.SVG");
					break;
			}
		} catch (ChartException pex) {
			DefaultLoggerImpl.instance().log(pex);
		}
		// DEFINE THE BOUNDS IN POINTS
		Bounds bo = BoundsImpl.create(0, 0, width, height);
		Generator gr = Generator.instance();
		GeneratedChartState state = null;
		try {
			state = gr.build(idr.getDisplayServer(), chart, bo,
					(IExternalContext) null, null);

		} catch (ChartException gex) {
			DefaultLoggerImpl.instance().log(gex);
			System.exit(0);
		}

		// new BufferedImage((int) bo.getWidth(), (int) bo.getHeight(),
		// BufferedImage.TYPE_INT_ARGB);
		idr.setProperty(IDeviceRenderer.FILE_IDENTIFIER, fileName);
		try {
			gr.render(idr, state);
		} catch (ChartException rex) {
			DefaultLoggerImpl.instance().log(rex);
		}
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

}

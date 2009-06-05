/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.exception.ChartException;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.script.IExternalContext;

/**
 * @author Ihssane
 * 
 */
@SuppressWarnings("serial")
public class ChartSwingViewer extends JPanel {
	private boolean bNeedsGeneration = true;
	private Chart cm = null;
	private IDeviceRenderer idr = null;

	public ChartSwingViewer(IDeviceRenderer idr, Chart cm) {
		this.idr = idr;
		this.cm = cm;
	}

	public void paint(Graphics g) {
		super.paint(g);
		// SETUP AS NEEDED
		Graphics2D g2d = (Graphics2D) g;
		idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, g2d);
		Dimension d = getSize();

		Bounds bo = BoundsImpl.create(0, 0, d.width, d.height);
		bo.scale(72d / idr.getDisplayServer().getDpiResolution());
		// BOUNDS MUST BE SPECIFIED IN POINTS
		// BUILD ONLY WHEN NECESSARY

		Generator gr = Generator.instance();
		GeneratedChartState state = null;
		if (bNeedsGeneration) {
			bNeedsGeneration = false;
			try {
				state = gr.build(idr.getDisplayServer(), cm, bo,
						(IExternalContext) null, null);
			} catch (ChartException gex) {
				gex.printStackTrace();
			}
		}
		try { // RENDERING DONE WHEN JPANEL IS PAINTED
			gr.render(idr, state);
		} catch (ChartException rex) {
			rex.printStackTrace();
		}

	}
}

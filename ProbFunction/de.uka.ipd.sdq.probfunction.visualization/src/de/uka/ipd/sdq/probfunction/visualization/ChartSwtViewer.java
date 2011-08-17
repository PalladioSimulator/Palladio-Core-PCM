/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.script.IExternalContext;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Ihssane
 * 
 */
public class ChartSwtViewer implements PaintListener {

	private IDeviceRenderer idr = null;
	private Chart cm = null;

	/**
	 * @param idr
	 * @param cm
	 */
	public ChartSwtViewer(IDeviceRenderer idr, Chart cm) {
		this.idr = idr;
		this.cm = cm;

	}

	public void paintControl(PaintEvent pe) {
		idr.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, pe.gc);
		Composite co = (Composite) pe.getSource();
		Rectangle re = co.getClientArea();
		Bounds bo = BoundsImpl.create(re.x, re.y, re.width, re.height);
		bo.scale(72d / idr.getDisplayServer().getDpiResolution());

		Generator gr = Generator.instance();
		GeneratedChartState state;
		try {
			state = gr.build(idr.getDisplayServer(), cm, bo,
					(IExternalContext) null, null);
			gr.render(idr, state);
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
		}
	}

}

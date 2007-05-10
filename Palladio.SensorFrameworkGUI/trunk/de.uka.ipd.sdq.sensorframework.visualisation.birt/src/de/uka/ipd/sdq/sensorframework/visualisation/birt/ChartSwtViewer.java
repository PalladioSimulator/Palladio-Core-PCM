/**
 * 
 */
package de.uka.ipd.sdq.sensorframework.visualisation.birt;

import org.eclipse.birt.chart.device.IDeviceRenderer;
import org.eclipse.birt.chart.device.IDisplayServer;
import org.eclipse.birt.chart.factory.GeneratedChartState;
import org.eclipse.birt.chart.factory.Generator;
import org.eclipse.birt.chart.model.Chart;
import org.eclipse.birt.chart.model.ChartWithAxes;
import org.eclipse.birt.chart.model.attribute.Bounds;
import org.eclipse.birt.chart.model.attribute.impl.BoundsImpl;
import org.eclipse.birt.chart.script.IExternalContext;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;

import de.uka.ipd.sdq.sensorframework.visualisation.actions.ConfigureBirtViewerAction;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.ExportAsPNGAction;
import de.uka.ipd.sdq.sensorframework.visualisation.actions.ExportAsSVGAction;

/**
 * @author Ihssane
 * 
 */
public class ChartSwtViewer extends Canvas {

	private IDeviceRenderer renderer = null;
	private Chart chart = null;

	/**
	 * @param idr
	 * @param cm
	 */
	public ChartSwtViewer(Composite parent, int flags, IDeviceRenderer idr, Chart cm) {
		super(parent, flags);
		this.renderer = idr;
		this.chart = cm;
		
		
		this.addPaintListener(new PaintListener(){
	
			public void paintControl(PaintEvent event) {
				renderer.setProperty(IDeviceRenderer.GRAPHICS_CONTEXT, event.gc);
				IDisplayServer displayServer = renderer.getDisplayServer();
		
				Composite composite = (Composite) event.getSource();
				Rectangle rectangle = composite.getClientArea();
				Bounds bounds = BoundsImpl.create(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
				bounds.scale(72d / displayServer.getDpiResolution());
		
				Generator generator = Generator.instance();
				GeneratedChartState state;
				try {
					
					state = generator.build(displayServer, chart, bounds,
							(IExternalContext) null, null);
					generator.render(renderer, state);
				} catch (Exception ex) {
					ex.printStackTrace();
					System.exit(1);
				}
			}
		});
	}
}

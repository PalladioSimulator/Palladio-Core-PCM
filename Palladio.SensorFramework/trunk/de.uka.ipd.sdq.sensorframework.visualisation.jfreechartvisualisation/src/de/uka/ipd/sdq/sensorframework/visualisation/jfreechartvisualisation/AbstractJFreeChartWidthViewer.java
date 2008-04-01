package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.util.Collection;

import org.eclipse.swt.widgets.Composite;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;

public abstract class AbstractJFreeChartWidthViewer extends
		AbstractJFreeChartChart<Histogram> {

	protected Collection<Histogram> lastData;

	protected DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();

	
	public AbstractJFreeChartWidthViewer(Composite parent, int style) {
		super(parent, style);
	}

	public void setData(Collection<Histogram> data) {
		densityDataset.removeAllSeries();
				
		for (Histogram h : data) {
			densityDataset.addSeries(computeDensities(h));
		}
		initChart();
		
		this.setChart(chart);
		this.forceRedraw();
		
		lastData = data;
	}

	protected abstract XYSeries computeDensities(Histogram hist);
}
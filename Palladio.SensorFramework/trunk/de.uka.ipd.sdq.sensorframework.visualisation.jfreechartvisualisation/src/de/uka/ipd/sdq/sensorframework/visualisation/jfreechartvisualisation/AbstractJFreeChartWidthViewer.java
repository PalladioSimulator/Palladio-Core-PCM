package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;

import org.eclipse.swt.widgets.Composite;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramEntity;
import de.uka.ipd.sdq.sensorframework.adapter.IAdapter;
import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanMeasurement;

public abstract class AbstractJFreeChartWidthViewer extends
		AbstractJFreeChartChart {

	protected double histogramWidth = 1.0;
	protected Collection<?> lastData;
	public static final String HISTOGRAM_WIDTH = "HISTOGRAM_WIDTH";
	protected DefaultTableXYDataset densityDataset=new DefaultTableXYDataset();

	
	public AbstractJFreeChartWidthViewer(Composite parent, int style) {
		super(parent, style);
	}

	public double getHistogramWidth() {
		return histogramWidth;
	}

	public void setData(Collection<?> data) {
		setData(data,getMaxHistWidth(data));
	}

	private void setData(Collection<?> data, double width) {
		densityDataset.removeAllSeries();
		
		histogramWidth = width;
		
		for (Object o : data) {
			XYSeries density = null;
			if (o instanceof IAdapter) {
				IAdapter histAdapter = (IAdapter) o;
				Properties p = new Properties();
				p.put(HISTOGRAM_WIDTH, histogramWidth);
				histAdapter.setProperties(p);
				Histogram hist = (Histogram) histAdapter.getAdaptedObject();
				density = computeDensities(hist);
			}				
			densityDataset.addSeries(density);
		}
		initChart();
		
		
		this.forceRedraw();

		
		lastData = data;
	}

	protected abstract XYSeries computeDensities(Histogram hist);

	private double getMaxHistWidth(Collection<?> data) {
		double result = Double.MIN_VALUE;
		for (Object object : data) {
			if (object instanceof IAdapter) {
				IAdapter myAdapter = (IAdapter) object;
				double width = (Double)myAdapter.getProperties().get(HISTOGRAM_WIDTH);
				result = width > result ? width : result;
			}
		}
		return result;
	}

	public void setHistogramWidth(double width) {
		this.histogramWidth = width;
		setData(lastData,width);
	}

}
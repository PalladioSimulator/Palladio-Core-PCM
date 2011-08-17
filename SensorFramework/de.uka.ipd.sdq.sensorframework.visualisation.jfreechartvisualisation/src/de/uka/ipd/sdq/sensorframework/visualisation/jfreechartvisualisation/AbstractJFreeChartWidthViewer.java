package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.swt.widgets.Composite;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;

/**
 * It's unclear why this class is called width viewer...
 * @author TODO
 *
 */
public abstract class AbstractJFreeChartWidthViewer extends
		AbstractJFreeChartChart<Histogram> {

	/**
	 * It is not final, so that it can be overwritten in subclasses
	 */
	protected String DEFAULT_X_AXIS_LABEL = "Time";
	
	/** The logger used by this class. */
	private Logger logger;//TODO is a logger needed in this class if the abstract superclass already has one?

	/**
	 * Getting all series, not just the first one as in getSeries()
	 * @return
	 */
	public synchronized List<XYSeries> getAllSeries() {
		logger.info("Only the first series of densityDataset is returned");
		List<XYSeries> ret = new ArrayList<XYSeries>();
		for(int i=0; i<densityDataset.getSeriesCount(); i++){
			ret.add(densityDataset.getSeries(i));
		}
		return ret; 
	}

	protected void setCustomXAxisLabel(Histogram histogram){
		if(xAxisCustomSet 
//				&& histogram.getXAxisAnnotation()!=null 
//				&& histogram.getXAxisAnnotation().length()!=0
				){
			logger.info("xAxisLabel already custom-set to "+xAxisLabel+", " +
					"passed histogram not checked for x-axis label");
		}else if(
				histogram.getXAxisAnnotation()!=null 
				&& histogram.getXAxisAnnotation().length()!=0
				){
			this.xAxisLabel = histogram.getXAxisAnnotation();
			this.xAxisCustomSet = true;
		}else{
			logger.info("No custom x-axis label set, but the passed histogram's " +
					"x-axis label is null or empty");
		}
	}

	/**
	 * Introduced to make x-axis label settable, incl. reading it from added histograms
	 */
	protected String xAxisLabel;
	
	/**
	 * Used to control xAxisLabel: when adding more than one histogram, or when adding a 
	 * histogram to a CDF with custom-set xAxisLabel, the new histogram's xAxisLabel 
	 * (if custom-set, i.e. non-null and non-empty) should not override an existing, 
	 * custom-set xAxisLabel
	 */
	protected boolean xAxisCustomSet = false;

	protected Collection<Histogram> lastData;

	protected DefaultTableXYDataset densityDataset = new DefaultTableXYDataset();

	/**
	 * The dataset of densities remains empty / freshly initialised
	 * @param parent
	 * @param style
	 */
	public AbstractJFreeChartWidthViewer(Composite parent, int style) {
		super(parent, style);
		logger = Logger.getLogger(this.getClass().getName());
	}

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.AbstractJFreeChartChart#setData(java.util.Collection)
	 */
	public void setData(Collection<Histogram> data) {//see addData methods in 
		densityDataset.removeAllSeries();
		XYSeries density;
		for (Histogram h : data) {
			System.err.println("TEST jfree vis: histogram:\n"+h);//TODO remove me
			density = computeDensities(h);
			densityDataset.addSeries(density);
			System.err.println("TEST jfree vis: density:\n"+density);//TODO REMOVE ME
		}
		initChart();

		this.setChart(chart);
		this.forceRedraw();

		lastData = data;
	}

	/**
	 * Converts the SensorFramework representation into JFreeChart's data type.
	 * 
	 * @param hist
	 *            histogram to be converted
	 * @return a series of (x,y) pairs
	 */
	protected abstract XYSeries computeDensities(Histogram hist);
}
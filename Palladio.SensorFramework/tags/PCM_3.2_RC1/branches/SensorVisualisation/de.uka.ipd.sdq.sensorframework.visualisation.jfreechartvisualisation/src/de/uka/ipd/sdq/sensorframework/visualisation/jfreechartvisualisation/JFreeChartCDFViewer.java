package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import java.awt.BasicStroke;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;

/**
 * @author TODO
 * 
 */
public class JFreeChartCDFViewer extends AbstractJFreeChartWidthViewer
		implements IHistogramAccepter, ISeriesExporter {
	
	/** The logger used by this class. */
	private Logger logger;
	
	/**
	 * The non-default constructor TODO check whether creating a private default
	 * constructor is useful (to prevent wrong usage)
	 * 
	 * @param parent
	 * @param style
	 */
	public JFreeChartCDFViewer(Composite parent, int style) {
		this(parent, style, null);
	}

	/**
	 * The non-default constructor TODO check whether creating a private default
	 * constructor is useful (to prevent wrong usage)
	 * 
	 * @param parent
	 * @param style
	 */
	public JFreeChartCDFViewer(Composite parent, int style, String xAxisLabel) {
		super(parent, style);
		this.logger = Logger.getLogger(this.getClass().getName());
		if(xAxisLabel!=null && xAxisLabel.length()>0){
			this.xAxisLabel = xAxisLabel;
			this.xAxisCustomSet = true; 
		}else{
			this.xAxisLabel = DEFAULT_X_AXIS_LABEL;
			this.xAxisCustomSet = false;
			logger.error("Passed xAxisLabel was null or empty, " +
					"using the default one: "+DEFAULT_X_AXIS_LABEL);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.
	 * IHistogramAccepter
	 * #addHistogram(de.uka.ipd.sdq.codegen.simudatavisualisation
	 * .datatypes.Histogram)
	 */
	public void addHistogram(Histogram histogram) {//TODO pull up?
		setCustomXAxisLabel(histogram);
		//it is implicitly assumed that all histograms' x axes refer to the same entity, e.g. time
		this.densityDataset.addSeries(this.computeDensities(histogram));
		initChart();
		this.redraw();//TODO why not forceRedraw?
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.
	 * AbstractJFreeChartWidthViewer
	 * #computeDensities(de.uka.ipd.sdq.codegen.simudatavisualisation
	 * .datatypes.Histogram)
	 */
	protected XYSeries computeDensities(Histogram hist) {
//		XYSeries density = new XYSeries(histogram.getTitle(),true/*autosort*/,false/*allow duplicate x entries*/);
//		double sum = 0;
//		for (HistogramBucketInformation e : histogram.getBucketInformation()) {
//			sum += e.getProbability();
//			density.add(e.getValue(), sum);// since this is a cumulative
//									// function, sum is used
//		}

		double sum = 0;
		XYSeries density;
		density = new XYSeries(
				hist.getTitle(), 
				true, //autosort 
				false //allow duplicate x values
				);
		for (HistogramBucketInformation bucketInformation : hist
				.getBucketInformation()) {
			if (sum == 0){ // is only executed the first time in the loop as long as histogram contains only probabilities >0
				density.add(
						bucketInformation.getValue(), 
						sum);
			}
			sum += bucketInformation.getProbability();
			if (sum != 0){
				density.add(
						bucketInformation.getValue() + hist.getBucketWidth(), //TODO add checks for negative values...
						sum);
			}
			// if (sum == 1)
			// density.add(bucketInformation.getValue() + hist.getBucketWidth(),
			// sum);
		}
		return density;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.
	 * ISeriesExporter#getSeries()
	 */
	public XYSeries getSeries() {
		logger.info("Only the first series of densityDataset is returned");
		return densityDataset.getSeries(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation.
	 * AbstractJFreeChartChart#initChart()
	 */
	@SuppressWarnings("deprecation")
	protected void initChart() {
		chart = ChartFactory.createXYLineChart(
				"Cumulative Distribution Function", 
				xAxisLabel, 
				"Probability",
				densityDataset, 
				PlotOrientation.VERTICAL, 
				true, 
				true, 
				true);
		XYPlot plot = (XYPlot) chart.getPlot();

		plot.getRangeAxis().setAutoRange(true);
		plot.getRenderer().setStroke(new BasicStroke(3));
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
		menu_manager.add(new LoadCSVHistogram(this));
		menu_manager.add(new ExportCSV(this));
	}

}

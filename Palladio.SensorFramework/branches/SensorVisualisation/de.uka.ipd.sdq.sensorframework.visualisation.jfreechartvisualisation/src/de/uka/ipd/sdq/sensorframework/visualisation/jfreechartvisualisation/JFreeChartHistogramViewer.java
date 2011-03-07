package de.uka.ipd.sdq.sensorframework.visualisation.jfreechartvisualisation;

import org.apache.log4j.Logger;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.Histogram;
import de.uka.ipd.sdq.codegen.simudatavisualisation.datatypes.HistogramBucketInformation;

public class JFreeChartHistogramViewer extends AbstractJFreeChartWidthViewer
		implements IHistogramAccepter, IHistSeriesExporter {

	/** The logger used by this class. */
	private Logger logger;

	public JFreeChartHistogramViewer(Composite parent, int style) {
		this(parent, style, null);
	}
		
	public JFreeChartHistogramViewer(Composite parent, int style, String xAxisLabel) {
		super(parent, style);
		DEFAULT_X_AXIS_LABEL = "Values";
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

	public void addHistogram(Histogram histogram) {
		setCustomXAxisLabel(histogram);
//		XYSeries density = new XYSeries(histogram.getTitle(), true, false);
//		for (HistogramBucketInformation e : histogram.getBucketInformation())
//			density.add(e.getValue(), e.getProbability());
		densityDataset.addSeries(this.computeDensities(histogram));
		densityDataset.setAutoWidth(true);//TODO why?
		initChart();
		this.redraw();//TODO why not forceRedraw?
	}

	protected XYSeries computeDensities(Histogram hist) {
		XYSeries density;
		density = new XYSeries(hist.getTitle(), true, false);
		double xValue;
		for (HistogramBucketInformation bucketInformation : 
				hist.getBucketInformation()) {
			xValue = bucketInformation.getValue() + hist.getBucketWidth()/ 2;
			density.add(xValue, 
					bucketInformation.getProbability());
		}
		return density;
	}

	public double getHistogramWidth() {
		return densityDataset.getIntervalWidth();
	}

	public XYSeries getSeries() {
		logger.info("Only the first series of densityDataset is returned");
		return densityDataset.getSeries(0);
	}

	protected void initChart() {
		chart = ChartFactory.createHistogram(
				"Histogram", 
				xAxisLabel,
				"Probability", 
				densityDataset, 
				PlotOrientation.VERTICAL, 
				true,
				true, 
				true);

		XYPlot plot = (XYPlot) chart.getPlot();
		plot.getRangeAxis().setAutoRange(true);
		plot.setForegroundAlpha(0.8f); // for transparency
		if (densityDataset != null)
			densityDataset.setAutoWidth(true);
	}

	@Override
	protected void initializeContextMenu(MenuManager menu_manager) {
		super.initializeContextMenu(menu_manager);
		menu_manager.add(new LoadCSVHistogram(this));
		menu_manager.add(new ExportCSV(this));
		menu_manager.add(new ExportDoublePDF(this));
	}

}

package de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.reportitems;

import org.eclipse.core.runtime.IStatus;

import de.uka.ipd.sdq.sensorframework.visualisation.rvisualisation.RVisualisationPlugin;

public class TimeSeriesReportItem extends AbstractPlotReportItem {
	
	/** Default label for the x axis. */
	public static final String DEFAULT_X_AXIS_LABEL = "";
	
	/** Label of the x axis. */
	private String xAxisLabel = DEFAULT_X_AXIS_LABEL;

	public TimeSeriesReportItem(String title, final String xAxisLabel) {
		super(title);
		this.xAxisLabel = xAxisLabel;
	}

	public TimeSeriesReportItem(final String title, final int height, 
			final int width, final int fontSize, final String xAxisLabel) {
		super(title, height, width, fontSize);
		this.xAxisLabel = xAxisLabel;
	}
	
	/**
	 * Plots the first data set against the second. Expects to find 
	 * the measured values in the first set and the 
	 * measurements number or event time in the second. 
	 */
	@Override
	protected String generatePlotCommand() {
		String rCommand = "";
		
		String[] dataSeries = getDataSeries();
		
		if (dataSeries.length > 1){
			
			String xDataId = dataSeries[1];
			String yDataId = dataSeries[0];
			
			String xDataName = getDataCommand(xDataId);
			String yDataName = getDataCommand(yDataId);
			
			rCommand = "plot("+xDataName +", "+yDataName+ ", main=\"" + getDescription() + "\", " 
				+ "title=\"Histogram\", "
				+ "xlab=\"" + xAxisLabel + "\", " + "ylab=\"Value\")\n";
			
		} else {
			RVisualisationPlugin.log(IStatus.ERROR,"Internal Error: Less than two measurements in data for time series.");
		}

		return rCommand;
	}

}

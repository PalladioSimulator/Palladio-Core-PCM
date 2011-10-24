package de.uka.ipd.sdq.edp2.visualization.properties.sections;

import java.io.Serializable;

import org.jfree.chart.JFreeChart;

/**
 * The properties wrapper with common settings for all JFreeCharts.
 * @author Dominik Ernst
 *
 */
public class CommonChartProperties implements Serializable {

	private static final long serialVersionUID = 6964212270982799287L;

	private JFreeChart chart;
	
	private String title;
	private String labelXAxis;
	private String labelYAxis;
	private boolean showTitle;
	private boolean showLabelXAxis;
	private boolean showLabelYAxis;
	
	/**
	 * Empty constructor.
	 */
	public CommonChartProperties(){
	}
	
	/**
	 * Constructor which assigns a chart to the properties.
	 * @param chart the associated chart
	 */
	public CommonChartProperties(JFreeChart chart){
		setChart(chart);
		
		this.labelXAxis = chart.getXYPlot().getDomainAxis().getLabel();
		this.labelYAxis = chart.getXYPlot().getRangeAxis().getLabel();
		this.showTitle = chart.getTitle() != null;
		if (showTitle) {
			this.title = chart.getTitle().getText();
		}
		this.showLabelXAxis = chart.getXYPlot().getDomainAxis().getLabel() != null;
		this.showLabelYAxis = chart.getXYPlot().getRangeAxis().getLabel() != null;
	}

	/**
	 * @return the chart
	 */
	public JFreeChart getChart() {
		return chart;
	}

	/**
	 * @param chart the chart to set
	 */
	public void setChart(JFreeChart chart) {
		this.chart = chart;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		chart.setTitle(title);
		this.title = title;
		setShowTitle(true);
	}

	/**
	 * @return the labelXAxis
	 */
	public String getLabelXAxis() {
		return labelXAxis;
	}

	/**
	 * @param labelXAxis the labelXAxis to set
	 */
	public void setLabelXAxis(String labelXAxis) {
		chart.getXYPlot().getDomainAxis().setLabel(labelXAxis);
		this.labelXAxis = labelXAxis;
		setShowLabelXAxis(true);
	}

	/**
	 * @return the labelYAxis
	 */
	public String getLabelYAxis() {
		return labelYAxis;
	}

	/**
	 * @param labelYAxis the labelYAxis to set
	 */
	public void setLabelYAxis(String labelYAxis) {
		chart.getXYPlot().getRangeAxis().setLabel(labelYAxis);
		this.labelYAxis = labelYAxis;
		setShowLabelYAxis(true);
	}

	/**
	 * @return the showTitle
	 */
	public boolean isShowTitle() {
		return showTitle;
	}

	/**
	 * @param showTitle the showTitle to set
	 */
	public void setShowTitle(boolean showTitle) {
		chart.setTitle(showTitle ? title : null);
		this.showTitle = showTitle;
	}

	/**
	 * @return the showLabelXAxis
	 */
	public boolean isShowLabelXAxis() {
		return showLabelXAxis;
	}

	/**
	 * @param showLabelXAxis the showLabelXAxis to set
	 */
	public void setShowLabelXAxis(boolean showLabelXAxis) {
		chart.getXYPlot().getDomainAxis().setLabel(showLabelXAxis ? getLabelXAxis() : null);
		this.showLabelXAxis = showLabelXAxis;
	}

	/**
	 * @return the showLabelYAxis
	 */
	public boolean isShowLabelYAxis() {
		return showLabelYAxis;
	}

	/**
	 * @param showLabelYAxis the showLabelYAxis to set
	 */
	public void setShowLabelYAxis(boolean showLabelYAxis) {
		chart.getXYPlot().getRangeAxis().setLabel(showLabelYAxis ? getLabelYAxis() : null);
		this.showLabelYAxis = showLabelYAxis;
	}
	
}

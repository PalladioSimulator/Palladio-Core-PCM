package de.uka.ipd.sdq.edp2.visualization.properties;

import java.io.Serializable;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.LegendTitle;

import de.uka.ipd.sdq.edp2.visualization.properties.sections.CommonJFreeChartPropertiesComposite;

/**
 * The properties wrapper with common settings for all JFreeCharts.
 * @author Dominik Ernst
 *
 */
public class CommonJFreeChartProperties implements Serializable {

	private static final long serialVersionUID = 6964212270982799287L;

	/**
	 * Default style for composites displaying the wrapped properties.
	 */
	private static final int STYLE = SWT.EMBEDDED;

	protected JFreeChart chart;
	
	private String title;
	private String labelXAxis;
	private String labelYAxis;
	private boolean showTitle;
	private boolean showLabelXAxis;
	private boolean showLabelYAxis;
	private boolean showLegend;
	private ArrayList<LegendTitle> removedLegends;
	
	/**
	 * Empty constructor.
	 */
	public CommonJFreeChartProperties(){
	}
	
	/**
	 * Constructor which assigns a chart to the properties.
	 * @param chart the associated chart
	 */
	public CommonJFreeChartProperties(JFreeChart chart){
		setChart(chart);
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
		this.labelXAxis = chart.getXYPlot().getDomainAxis().getLabel();
		this.labelYAxis = chart.getXYPlot().getRangeAxis().getLabel();
		this.showTitle = chart.getTitle() != null;
		if (showTitle) {
			this.title = chart.getTitle().getText();
		}
		this.showLabelXAxis = chart.getXYPlot().getDomainAxis().getLabel() != null;
		this.showLabelYAxis = chart.getXYPlot().getRangeAxis().getLabel() != null;
		removedLegends = new ArrayList<LegendTitle>();
		this.showLegend = chart.getLegend() != null;
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

	/**
	 * @param showLegend the showLegend to set
	 */
	public void setShowLegend(boolean showLegend) {
		if (!showLegend) {
			removedLegends.add(chart.getLegend());
			chart.removeLegend();
		} else {
			chart.addLegend(removedLegends.get(0));
		}
		this.showLegend = showLegend;
	}

	/**
	 * @return the showLegend
	 */
	public boolean isShowLegend() {
		return showLegend;
	}
	
	/**
	 * 
	 * @return a new {@link Composite} to display the {@link CommonJFreeChartProperties} using the default style.
	 */
	public CommonJFreeChartPropertiesComposite retrieveComposite(Composite parent){
		return new CommonJFreeChartPropertiesComposite(parent, STYLE, this);
	}
	
}

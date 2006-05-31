package de.uka.ipd.sdq.simucom.ui;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.simucom.usage.SimulatedUsageScenario;

public class UsageScenarioResponseTimeMonitor implements Observer {

	protected XYSeries series;
	protected JFrame graphFrame;
	protected JFreeChart myChart;
	protected ChartPanel chartPanel;

	public UsageScenarioResponseTimeMonitor(SimulatedUsageScenario monitoredScenario)
	{
		graphFrame = new JFrame("Result: "+monitoredScenario.getName());
		DefaultTableXYDataset dataset=new DefaultTableXYDataset();
		series = new XYSeries(monitoredScenario.getName(),true,false);
		dataset.addSeries(series);
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("Response Time Histogram of "+monitoredScenario.getName(),"Time [ms]","Number", dataset,PlotOrientation.VERTICAL,true,true,true);
		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setRange(0,400d);
		graphFrame.setSize(600,400);
		graphFrame.setLocation(
		        (Toolkit.getDefaultToolkit().getScreenSize().width-
		         graphFrame.getSize().width) / 2,
		        (Toolkit.getDefaultToolkit().getScreenSize().height-
		         graphFrame.getSize().height) / 2);		
		graphFrame.getContentPane().setLayout(new BorderLayout());
		chartPanel = new ChartPanel(myChart);
		graphFrame.getContentPane().add(chartPanel,BorderLayout.CENTER);
		graphFrame.setVisible(true);
	}
	
	public void update(Observable observedSensor, Object newValue) {
		int index = series.indexOf((Double)newValue);
		if (index >= 0)
		{
			Number oldValue = series.getY(index);
			series.update(index,(Number)(oldValue.intValue()+1));
		}
		else
			series.add((Number) newValue,(double)1);
		chartPanel.repaint();	
		//chartPanel.scale(new Rectangle2D(1.0,1.0));
	}	
}

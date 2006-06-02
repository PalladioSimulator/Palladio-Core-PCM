package RegEx.util;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import RegEx.Complex;
import RegEx.DistributionFunction;

import org.eclipse.emf.common.util.EList;
import org.jfree.chart.ChartUtilities;



public class Visualization {

	protected int thinkTime;
	protected boolean thinkFirst;
	protected JFrame graphFrame;
	protected JFreeChart myChart;
	protected ChartPanel chartPanel;
	protected DefaultTableXYDataset dataset;
	protected double distance;
	
	
	public Visualization(double distance){
		dataset = new DefaultTableXYDataset();		
		graphFrame = new JFrame("Result: Measured Execution Time");
		this.distance = distance; 
	}
	
	public void addDistributionFunction(DistributionFunction distFunc, String name){

		XYSeries series = new XYSeries(name,true,false);
		
		EList points = distFunc.getPoints();
		int amountOfPoints = points.size();
		Complex[] pointArray = (Complex[]) points.toArray(); 
		distFunc = distFunc.adjustDistance(distance);
		for (int i=0; i<amountOfPoints; i++){
			Complex currentPoint = pointArray[i];
			series.add(i, currentPoint.getRe());

		}
		dataset.addSeries(series);
	}
	
	public void visualize(){
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("Measured Execution Time Histogram",
				"Time [ms]",
				"Number", 
				dataset,
				PlotOrientation.VERTICAL,true,true,true);
		XYPlot plot = (XYPlot)myChart.getPlot();
		plot.getRangeAxis().setRange(0,1.1d);
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
		
//		File testFile = new File("test.png");
//		try {
//			ChartUtilities.saveChartAsPNG(testFile, myChart, 600, 400);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}		
	}
	
	public void visualizeOverlay(){
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("",
				"Time [ms]", 	// x Axis label
				"Probability", 		// y Axis label
				dataset,
				PlotOrientation.VERTICAL,
				true,	// legend
				true,	// tooltips
				true);	// url
		
		
		XYPlot plot = (XYPlot)myChart.getPlot();
		
		plot.getRenderer().setSeriesPaint(0, Color.LIGHT_GRAY); // Foreground Series
		plot.getRenderer().setSeriesPaint(1, Color.DARK_GRAY.brighter()); // Background Series

		plot.setForegroundAlpha( 0.8f ); // for transparency		

		plot.getRangeAxis().setRange(0,0.4d);

		plot.setBackgroundPaint(Color.white);

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
		
		File testFile = new File("examplePMF2.png");
		try {
			ChartUtilities.saveChartAsPNG(testFile, myChart, 600, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
	}
}


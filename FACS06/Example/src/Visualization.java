import java.awt.BorderLayout;
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
	protected XYSeries measuredSeries;
	protected XYSeries predictedSeries;
	protected JFrame graphFrame;
	protected JFreeChart myChart;
	protected ChartPanel chartPanel;
	
	public void visualize(DistributionFunction distFunc){

		graphFrame = new JFrame("Result: Measured Execution Time");
		DefaultTableXYDataset dataset=new DefaultTableXYDataset();
		measuredSeries = new XYSeries("Measurement",true,false);
		predictedSeries = new XYSeries("Prediction",true,false);
		
		EList points = distFunc.getPoints();
		int amountOfPoints = points.size();
		Complex[] pointArray = (Complex[]) points.toArray(); 
		double distance = distFunc.getDistance();
		for (int i=0; i<amountOfPoints; i++){
			Complex currentPoint = pointArray[i];
			measuredSeries.add(i, currentPoint.getRe());
			predictedSeries.add(i, currentPoint.getRe()/2);

		}
		dataset.addSeries(predictedSeries);
		dataset.addSeries(measuredSeries);

		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("Measured Execution Time Histogram",
				"Time [ms]",
				"Number", 
				dataset,
				PlotOrientation.VERTICAL,true,true,true);
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
		
		File testFile = new File("test.png");
		try {
			ChartUtilities.saveChartAsPNG(testFile, myChart, 600, 400);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

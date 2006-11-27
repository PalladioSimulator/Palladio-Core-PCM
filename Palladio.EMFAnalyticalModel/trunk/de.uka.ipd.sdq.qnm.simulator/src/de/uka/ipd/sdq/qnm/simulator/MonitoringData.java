package de.uka.ipd.sdq.qnm.simulator;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.swing.JFrame;

import org.eclipse.emf.common.util.EList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.probfunction.math.IProbabilityDensityFunction;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.IUnit;
import flanagan.complex.Complex;


public class MonitoringData {

	public ArrayList<Double> measuredValues = new ArrayList<Double>();
	private ISamplePDF probFunc; 
	
	public void addValue(double value) {
		measuredValues.add(value);
	}

	public MonitoringData(){
	}

	public IProbabilityDensityFunction getDistFunc(double distance) {

		Hashtable resultMap = new Hashtable();
		// key = measurement, value = probability

		double singleProb = (double) 1 / measuredValues.size();
		double largestMeas = 0;

		for (int i = 0; i < measuredValues.size(); i++) {
			double value = (Double) measuredValues.get(i);
			long pos = Math.round((double) value / distance);

			if (pos > largestMeas)
				largestMeas = pos;

			if (resultMap.containsKey(pos)) {
				double prob = (Double) resultMap.get(pos);
				resultMap.put(pos, prob + singleProb);
			} else {
				resultMap.put(pos, singleProb);
			}
		}

		List<Complex> pointList = new ArrayList<Complex>();
		for (int j = 0; j <= largestMeas; j++) {
			Complex point = new Complex();
			point.setReal(0.0);
			point.setImag(0.0);
			if (resultMap.containsKey((long) j)) {
				double prob = (Double) resultMap.get((long) j);
				point.setReal(prob);
			}
			pointList.add(point);
		}
		
		IUnit unit = IProbabilityFunctionFactory.eINSTANCE.createUnit("ms");

		return IProbabilityFunctionFactory.eINSTANCE.createSamplePDFFromComplex(distance, pointList,false,unit);
	}
	
	public void visualize(double distance){
		
		probFunc=(ISamplePDF) getDistFunc(distance);
		List<Complex> points = probFunc.getValues();
		
		// derive points to draw
		XYSeries series = new XYSeries("ServiceTime",true,false);
		for (int i=0; i<points.size(); i++){
			Complex currentPoint = points.get(i);
			series.add(i*distance, currentPoint.getReal());
		}

		// configure graph
		DefaultTableXYDataset dataset = new DefaultTableXYDataset();
		dataset.addSeries(series);
		dataset.setIntervalWidth(1);
		JFreeChart myChart = ChartFactory.createHistogram("Measured Simulation Service Time Per Task Histogram",
				"Time[ms]",
				"Probability", 
				dataset,
				PlotOrientation.VERTICAL,true,true,true);
		XYPlot plot = (XYPlot)myChart.getPlot();
		//plot.getRangeAxis().setRange(0,1.1d);
		plot.getRangeAxis().setAutoRange(true);
		
		// draw graph
		JFrame graphFrame = new JFrame("Result: Measured Execution Time");
		graphFrame.setSize(600,400);
		graphFrame.setLocation(
		        (Toolkit.getDefaultToolkit().getScreenSize().width-
		         graphFrame.getSize().width) / 2,
		        (Toolkit.getDefaultToolkit().getScreenSize().height-
		         graphFrame.getSize().height) / 2);		
		graphFrame.getContentPane().setLayout(new BorderLayout());
		ChartPanel chartPanel = new ChartPanel(myChart);
		graphFrame.getContentPane().add(chartPanel,BorderLayout.CENTER);
		graphFrame.setVisible(true);
	}

}

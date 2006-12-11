package de.uka.ipd.sdq.spa.concurrencysolver.visualization;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYSeries;

import de.uka.ipd.sdq.probfunction.math.IProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ISamplePDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

public class JFVisualisation {

	protected JFrame graphFrame;

	protected JFreeChart myChart;

	protected ChartPanel chartPanel;

	protected DefaultTableXYDataset dataset;

	protected double distance;

	public JFVisualisation(double distance) {
		dataset = new DefaultTableXYDataset();
		graphFrame = new JFrame("Execution Time");
		this.distance = distance;
	}

	public void addSamplePDF(ManagedPDF pdf, String name)
			throws ProbabilityFunctionException {
		ISamplePDF samplePDF = pdf.getSamplePdfTimeDomain();

		XYSeries series = new XYSeries(name, true, false);

		List<Double> points = samplePDF.getValuesAsDouble();
		samplePDF = samplePDF.getFunctionWithNewDistance(distance);
		int i = 0;
		for (Double point : points) {
			series.add(i, point);
			i++;
		}
		dataset.addSeries(series);
	}

	public void visualize() {
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram(
				"Measured Execution Time Histogram", "Time [10 ms]",
				"Probability", dataset, PlotOrientation.VERTICAL, true, true,
				true);
		XYPlot plot = (XYPlot) myChart.getPlot();
		plot.getRangeAxis().setRange(0, 1.1d);
		graphFrame.setSize(800, 600);
		graphFrame
				.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width - graphFrame
								.getSize().width) / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height - graphFrame
								.getSize().height) / 2);
		graphFrame.getContentPane().setLayout(new BorderLayout());
		chartPanel = new ChartPanel(myChart);
		graphFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
		graphFrame.setVisible(true);

	}

	public void visualizeOverlay() {
		dataset.setIntervalWidth(1);
		myChart = ChartFactory.createHistogram("", "Time [ms]", // x Axis label
				"Probability", // y Axis label
				dataset, PlotOrientation.VERTICAL, true, // legend
				true, // tooltips
				true); // url

		XYPlot plot = (XYPlot) myChart.getPlot();

		plot.getRenderer().setSeriesPaint(0, Color.LIGHT_GRAY); // Foreground
																// Series
		plot.getRenderer().setSeriesPaint(1, Color.DARK_GRAY.brighter()); // Background
																			// Series

		plot.setForegroundAlpha(0.8f); // for transparency

		plot.getRangeAxis().setRange(0, 0.25d);

		plot.setBackgroundPaint(Color.white);

		graphFrame.setSize(677, 495);
		graphFrame
				.setLocation(
						(Toolkit.getDefaultToolkit().getScreenSize().width - graphFrame
								.getSize().width) / 2,
						(Toolkit.getDefaultToolkit().getScreenSize().height - graphFrame
								.getSize().height) / 2);
		graphFrame.getContentPane().setLayout(new BorderLayout());
		chartPanel = new ChartPanel(myChart);
		graphFrame.getContentPane().add(chartPanel, BorderLayout.CENTER);
		graphFrame.setVisible(true);

		File testFile = new File("examplePMF2.png");
		try {
			ChartUtilities.saveChartAsPNG(testFile, myChart, 600, 400);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addPMF(ManagedPMF managedPMF, String name) {
		IProbabilityMassFunction pmf = managedPMF.getPmfTimeDomain();

		XYSeries series = new XYSeries(name, true, false);

		List<ISample> points = pmf.getSamples();

		for (ISample sample : points) {
			double value = (Integer) sample.getValue();
			series.add(value, sample.getProbability());
		}
		dataset.addSeries(series);
	}
}

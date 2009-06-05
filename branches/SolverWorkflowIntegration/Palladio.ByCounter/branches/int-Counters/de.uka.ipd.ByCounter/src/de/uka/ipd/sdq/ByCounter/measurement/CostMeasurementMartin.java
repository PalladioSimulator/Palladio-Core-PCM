package de.uka.ipd.sdq.ByCounter.measurement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

//import section1.JGFArithBench;

import com.lowagie.text.pdf.DefaultFontMapper;

import de.uka.ipd.sdq.ByCounter.evaluation.Linpack.Linpack;
import de.uka.ipd.sdq.ByCounter.utils.ChartResultWriter;
import de.uka.ipd.sdq.ByCounter.utils.MethodDescriptor;

/**
 * Class for measuring the cost of the bytecode instrumentation as well as the 
 * cost for the invocation of (instrumented) methods.
 * 
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.9
 */
public class CostMeasurementMartin {
	
	private static String CHART_DIR = "charts";	// directory to output charts into
	public static final int FILETYPE_JPG = 2;
	/** Filetypes for chart files. */
	public static final int FILETYPE_PDF = 0;
	public static final int FILETYPE_PNG = 1;
	public static final int INSTRUMENTATION_INSTRUMENT_AND_CALL = 2;
	public static final int INSTRUMENTATION_INSTRUMENT_ONLY = 0;		// for verbosity
	
	public static final int INSTRUMENTATION_NO_HIGH_REGISTERS = 0;	// for verbosity
	/** Flags for instrumentation modes. Combine bitwise.*/
	public static final int INSTRUMENTATION_NONE = -1;
	public static final int INSTRUMENTATION_USE_HIGH_REGISTERS = 1;
	
	private static Logger log;
	
//	private static String TEST_CLASSNAME = MKProvocator.class.getCanonicalName();
//	private static String TEST_CLASSNAME = MKSudoku.class.getCanonicalName();
//	private static String TEST_CLASSNAME = MKNewCompressor.class.getCanonicalName();
//	private static String TEST_CLASSNAME = Test.class.getCanonicalName();

	private static int NUMBEROFMEASUREMENTS_DEFAULT = 20;	// default to 300 measurements when no args are given

	//	private static String TEST_METHODNAME = "provoke";
//	private static String TEST_METHODNAME = "MKmeasureSudoku";
//	private static String TEST_METHODNAME = "compress";
//	private static String TEST_METHODNAME = "compressFake";

	private static final double PERCENTAGE_OF_CAPPING = 0.9D;

	private static String TEST_CLASSNAME = Linpack.class.getCanonicalName();
//	private static String TEST_CLASSNAME = JGFArithBench.class.getCanonicalName();
	private static String TEST_METHODSIGNATURE = "public void run_benchmark()";
//	private static String TEST_METHODNAME = "JGFrun";
	
	/**
	 * Main call for a measurement of the costs for instrumentation.
	 * @param args First argument is the number if measurements to do.
	 */
	public static void main(String args[]) {
		int numberOfMeasurements = NUMBEROFMEASUREMENTS_DEFAULT;
		
		// try to read command line arguments
		if (args.length > 0) {
		    try {
		    	numberOfMeasurements = Integer.parseInt(args[0]);
		    } catch (NumberFormatException e) {
		        System.err.println("Argument must be an integer (number of measurements).");
		        System.exit(1);
		    }
		} else {
			System.out.println("Warning: Expected one argument to be supplied for the number ");
			System.out.println("of measurements to take. Using default of 300.");
		}
		
		// start the measurement
		CostMeasurementMartin measurement = new CostMeasurementMartin(numberOfMeasurements);
		measurement.measure();
	}

	private static void writeToCSV(String measurementDescriptor, long min,
			long median, double mean, double sd, long max) {
		File f = new File("measurements/" + measurementDescriptor + "_nrOfMeas" + NUMBEROFMEASUREMENTS_DEFAULT + ".txt");

		StringBuilder builder = new StringBuilder();
		builder.append(System.getProperty("java.vendor"));
		builder.append("\n");
		builder.append(System.getProperty("java.version"));
		builder.append("\n");
		builder.append(System.getProperty("os.arch"));
		builder.append("\n");
		builder.append(System.getProperty("os.name"));
		builder.append("\n");
		builder.append(System.getProperty("os.version"));
		builder.append("\n");
		builder.append(System.getProperty("user.name"));
		builder.append("\n");
		builder.append(measurementDescriptor);
		builder.append("\n");
		builder.append(NUMBEROFMEASUREMENTS_DEFAULT); 	//z.B. 1, oder 1000
		builder.append("\n");
		builder.append(PERCENTAGE_OF_CAPPING);
		builder.append("\n"); //z.B. 0, 5, 10, 25 etc.
		// separierte Aneinanderreihung der 4 Messwerte
		builder.append(median);
		builder.append("\n");
		builder.append(min);
		builder.append("\n");
		builder.append(mean);
		builder.append("\n");
		builder.append(max);
		builder.append("\n");

		try {
			FileOutputStream s = new FileOutputStream(f);
			s.write(builder.toString().getBytes());
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	protected long diff = 0L;
	protected long finish = 0L;
	private long nanoTimeCost;
	
	protected int numberOfMeasurements;
	

	protected long start = 0L;

	/**
	 * Construct CostMeasurement.
	 * @param numberOfMeasurements The number of measurements to perform.
	 */
	public CostMeasurementMartin(int numberOfMeasurements) {
		// setup log4j
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
		this.numberOfMeasurements = numberOfMeasurements;
		
		// get a (not so accurate) value for nanoTimeCost
		long n1, n2;
		n1 = System.nanoTime();
		do {
			n2 = System.nanoTime();
		} while(n1 == n2);
		this.nanoTimeCost = n2-n1;
	}

	/**
	 * Gather and and log statistics about the given measurement.
	 * Writes a chart as a file into CHART_DIR.
	 * @param measurementName Descriptive title for the resulting chart.
	 * @param measurements List of measuring numbers.
	 * @param printAllResults When true, all results are written to the log.
	 */
	public void evaluateMeasurement(
			String measurementName, 
			List<Long> measurements, 
			boolean printAllResults) {
		log.info("");
		log.info("Statistics for \"" + measurementName + "\":");
		if(printAllResults) {
			for(long l : measurements) {
				log.info(l);
			}
		}
		
		// Add values to statistic classes
		DescriptiveStatistics stats = DescriptiveStatistics.newInstance();
		XYSeries series = new XYSeries(measurementName);
		for(int i = 0; i < measurements.size(); i++) {
			series.add(i, measurements.get(i));
			stats.addValue(measurements.get(i));
		}
		XYDataset xyDataset = new XYSeriesCollection(series);
		// Draw a chart
		writeToChartFile(measurementName, xyDataset, 800, 600, FILETYPE_PDF);
		
		Collections.sort(measurements);		// needed to get smallest
		
		
		long min = measurements.get(0);
		long median = measurements.get(measurements.size()/2);
		double mean = stats.getMean();
		double sd = stats.getStandardDeviation();
		long max = measurements.get(measurements.size()-1);
		// log the statistic values
		log.info("Smallest:   " + min);
		log.info("Median:     " + median);
		log.info("  Mean:     " + mean);
		log.info("  SD<:       " + sd);
//		log.info("  Variance: " + stats.getVariance());
		
		writeToCSV(measurementName, min, median, mean, sd, max);
	}
	
	/**
	 * Performs a set of measurements and evaluations on the instrumentation.
	 *
	 */
	@SuppressWarnings("deprecation")
	public void measure() {
		ArrayList<Long> callCostNoInstrumResults = new ArrayList<Long>();
		ArrayList<Long> instrumentationDynResults = new ArrayList<Long>();
		ArrayList<Long> instrumentationHighResults = new ArrayList<Long>();
		ArrayList<Long> callCostDynInstrumResults = new ArrayList<Long>();
		ArrayList<Long> callCostHighInstrumResults = new ArrayList<Long>();

		// measure the time it takes to run (non-/)instrumented methods:
		MeasurableCostsForMethodRun measurableRun = 
			new MeasurableCostsForMethodRun(TEST_CLASSNAME, 
					new MethodDescriptor(TEST_METHODSIGNATURE), INSTRUMENTATION_NONE);
		
		callCostNoInstrumResults = this.measure(measurableRun, numberOfMeasurements);
		
		// measure the time the instrumentation itself takes:
		MeasurableInstrumentationCostsForMethod measurableInstrum = 
			new MeasurableInstrumentationCostsForMethod(
					TEST_CLASSNAME, new MethodDescriptor(TEST_METHODSIGNATURE), false);
		instrumentationDynResults = this.measure(measurableInstrum, numberOfMeasurements);
		
		measurableInstrum.setUseHighRegisters(true);
		instrumentationHighResults = this.measure(measurableInstrum, numberOfMeasurements);
		
		// instrumenting and calling at once:
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_NO_HIGH_REGISTERS);
		callCostDynInstrumResults = this.measure(measurableRun, numberOfMeasurements);
		measurableRun.setInstrumentationMode(INSTRUMENTATION_INSTRUMENT_AND_CALL|INSTRUMENTATION_USE_HIGH_REGISTERS);
		callCostHighInstrumResults = this.measure(measurableRun, numberOfMeasurements);

		// create logs and graphs from the unchanged measurements:
		this.evaluateMeasurement("Method call (not instrumented)", 
				callCostNoInstrumResults, false);
		this.evaluateMeasurement("Instrumentation (dyn. registers)", 
				instrumentationDynResults, false);
		this.evaluateMeasurement("Instrumentation (high registers)", 
				instrumentationHighResults, false);
		this.evaluateMeasurement("Method call (instr. dyn. registers)", 
				callCostDynInstrumResults, false);
		this.evaluateMeasurement("Method call (instr. high registers)", 
				callCostHighInstrumResults, false);
		
		// sort the measurements in order to truncate outliers:
		Collections.sort(callCostNoInstrumResults);
		Collections.sort(callCostDynInstrumResults);
		Collections.sort(callCostHighInstrumResults);
		Collections.sort(instrumentationDynResults);
//		Collections.sort(instrumentationHighResults);
		
		//assumption: all of same length
		int length = new Double(Math.ceil(PERCENTAGE_OF_CAPPING*callCostNoInstrumResults.size())).intValue();
		List<Long> callCostNoInstrumResultsTruncated   = callCostNoInstrumResults.subList  (0, length);
		List<Long> callCostDynInstrumResultsTruncated  = callCostDynInstrumResults.subList (0, length);
		List<Long> callCostHighInstrumResultsTruncated = callCostHighInstrumResults.subList(0, length);
		List<Long> instrumentationDynResultsTruncated  = instrumentationDynResults.subList (0, length);
		List<Long> instrumentationHighResultsTruncated = instrumentationHighResults.subList(0, length);
		
		// create the logs and graphs for the adjusted measurements
		this.evaluateMeasurement("TRUNCATED Method call (not instrumented)", 
				callCostNoInstrumResultsTruncated, false);
		this.evaluateMeasurement("TRUNCATED Instrumentation (dyn. registers)", 
				instrumentationDynResultsTruncated, false);
		this.evaluateMeasurement("TRUNCATED Instrumentation (high registers)", 
				instrumentationHighResultsTruncated, false);
		this.evaluateMeasurement("TRUNCATED Method call (instr. dyn. registers)", 
				callCostDynInstrumResultsTruncated, false);
		this.evaluateMeasurement("TRUNCATED Method call (instr. high registers)", 
				callCostHighInstrumResultsTruncated, false);
	}
	
	
	/**
	 * Do a measurement on the given <code>Measurable</code>. This
	 * does not substract the costs for calling <code>nanoTime()</code>!
	 * @param measurable Measurable object that defines what to measure. 
	 * @param numberOfMeasurements The number of repetitive calls for a measurement.
	 * @return An ArrayList of longs that represent the time (in nanoseconds) 
	 * that a call of the Measurable's callForMeasurement method has taken.
	 */
	public ArrayList<Long>  measure(IMeasurable measurable, int numberOfMeasurements) {
		ArrayList<Long> measurements = new ArrayList<Long>(numberOfMeasurements);
		
		boolean prepareSuccess = measurable.prepareMeasuring();
		int numberOfRepetitions = 1;

		if(prepareSuccess == false) {
			log.error("ERROR: Could not initialize the measuring with " + measurable.toString() + ". Skipping.");
		} else {
			// do the measurements
			for (int i = 0; i < numberOfMeasurements; i++) {

				// automatism to increase repetitions between nanoTime()s if diff=nanoTime cost or only slightly above.
				do {
					start = System.nanoTime();
	
					for(int j = 0; j < numberOfRepetitions; j++) {
						// call the method to measure
						measurable.callForMeasuring();
					}
					
					// take the time
					finish = System.nanoTime();
					diff = finish - start;
					diff = Math.round(((double)diff)/numberOfRepetitions);
				} while (diff < 2*nanoTimeCost);
	
				measurements.add(diff);
			}
		}
		
		return measurements;
	}
	
	/**
	 * Write a simple XY-Chart to the charts directory.
	 * @param title Title of the chart.
	 * @param xyDataset The chart to draw.
	 * @param width Width of the chart.
	 * @param height Height of the chart.
	 * @param filetype Type of the output file. See FILETYPE_* constants.
	 */
	private void writeToChartFile(String title, XYDataset xyDataset, 
			int width, int height, int filetype) {

		JFreeChart chart = ChartFactory.createXYAreaChart
		                     (title,					// Title
		                      "Measurement",			// X-Axis label
		                      "Time",					// Y-Axis label
		                      xyDataset,				// Dataset
		                      PlotOrientation.VERTICAL,
		                      true,					// Show legend
		                      false,					// no tooltips
		                      false					// no urls
		                     );

		try {
			// make sure the directory CHART_DIR exists:
			File chartsdir = new File(CHART_DIR);
			if(!chartsdir.exists() || !chartsdir.isDirectory()) {
				if(chartsdir.mkdir() == false) {
					throw new IOException("Error! Could not create charts directory");
				} else {
					log.info("Creating directory '" + CHART_DIR + "'.");
				}
			}
			
			String filenameExtensionless = CHART_DIR + File.separator + title;
			
			// save to the chosen filetype:
			switch(filetype) {
			case FILETYPE_PNG:
				ChartUtilities.saveChartAsPNG(new File(filenameExtensionless + ".png"), chart, width, height);
				break;
				
			case FILETYPE_JPG:
				ChartUtilities.saveChartAsJPEG(new File(filenameExtensionless + ".jpg"), chart, width, height);
				break;

			case FILETYPE_PDF:
				ChartResultWriter.saveChartAsPDF(new File(filenameExtensionless + ".pdf"), chart, width, height, new DefaultFontMapper());
				break;
				
			default:
				log.error("ERROR: Unknown filetype " + filetype + ". Please use a FILETYPE_* constant.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

package de.uka.ipd.sdq.ByCounter.evaluation;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.math.stat.descriptive.DescriptiveStatistics;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import de.uka.ipd.sdq.ByCounter.execution.CountingResult;
import de.uka.ipd.sdq.ByCounter.test.Test;
import de.uka.ipd.sdq.ByCounter.utils.ASMOpcodesMapper;

/**
 * TODO refactor/rewrite this class systematically
 * 
 * @author Michael Kuperberg
 * @author Martin Krogmann
 * @since 0.1
 * @version 0.1
 * @deprecated
 */
public class Evaluation {
	
	@SuppressWarnings("unused")
	private static String CHART_DIR = "charts"; // directory to output charts
	public static final int FILETYPE_JPG = 2;
	/** Filetypes for chart files. */
	public static final int FILETYPE_PDF = 0;
	public static final int FILETYPE_PNG = 1;
	public static final int INSTRUMENTATION_INSTRUMENT_AND_CALL = 2;
	public static final int INSTRUMENTATION_INSTRUMENT_ONLY = 0; // for
	public static final int INSTRUMENTATION_NO_HIGH_REGISTERS = 0; // for
	/** Flags for instrumentation modes. Combine bitwise. */
	public static final int INSTRUMENTATION_NONE = -1;
	public static final int INSTRUMENTATION_USE_HIGH_REGISTERS = 1;
	private static Logger log;
	@SuppressWarnings("unused")
	private static int NUMBEROFMEASUREMENTS_DEFAULT = 300; // default to 300 measurements when no args are given
	@SuppressWarnings("unused")
	private static String TEST_CLASSNAME = Test.class.getCanonicalName();
	@SuppressWarnings("unused")
	private static String TEST_METHODNAME = "printTest";
	private int paramForLogging; // TODO expand: for result evaluation
	protected int numberOfMeasurements;
	@SuppressWarnings("unused")
	private long nanoTimeCost;

	public Evaluation(int numberOfMeasurements) {
		// setup log4j
		PropertyConfigurator.configure("log4j.properties");
		log = Logger.getLogger(this.getClass().getCanonicalName());
		this.numberOfMeasurements = numberOfMeasurements;

		// get a (not so accurate) value for nanoTimeCost //TODO: talkback
		long n1, n2;
		n1 = System.nanoTime();
		do {
			n2 = System.nanoTime();
		} while (n1 == n2);
		this.nanoTimeCost = n2 - n1;
	}

	/**@deprecated
	 * @param opcodeCounts
	 */
	@SuppressWarnings("unused")
	private void analyseData(HashMap<Integer, Integer> opcodeCounts) {
		FileOutputStream fosCSV = null;
		FileOutputStream fosSSV = null;
		String csvValueSeparator = ",";
		// String ssvValueSeparator = ";";

		StringBuffer csvNames = new StringBuffer();
		StringBuffer ssvNames = new StringBuffer();
		StringBuffer csvValues = new StringBuffer();
		StringBuffer ssvValues = new StringBuffer();
		csvNames.append("param" + csvValueSeparator);
		csvValues.append(paramForLogging + csvValueSeparator);
		// ssvNames.append("param"+ssvValueSeparator);
		// ssvValues.append(paramForLogging+ssvValueSeparator);

		try {
			fosCSV = new FileOutputStream("./" + System.currentTimeMillis()
					+ ".csv.MLSet");
			Integer count = null;
			ASMOpcodesMapper dispo = ASMOpcodesMapper.getInstance();
			String opcodeString = null;
			int realColumns = 0;
			for (int i = 0; i < 500; i++) {
				opcodeString = dispo.getOpcodeString(i);
				if (opcodeString != null && !opcodeString.equals("")) {
					realColumns++;
					csvNames.append(opcodeString + csvValueSeparator);
					count = opcodeCounts.get(i);
					if (count == null || count.intValue() == 0) {
						csvValues.append("0" + csvValueSeparator);
					} else {
						csvValues.append("" + count + csvValueSeparator);
					}
				}
			}
			fosCSV.write((csvNames.toString() + "\n").getBytes());
			fosCSV.write((csvValues.toString() + "\n").getBytes());

			fosSSV = new FileOutputStream("./" + System.currentTimeMillis()
					+ ".ssv.MLSet");
			String ssvNameLine = csvNames.toString().replace(',', ';') + "\n";
			String ssvValueLine = csvValues.toString().replace(',', ';') + "\n";
			fosSSV.write(ssvNameLine.getBytes());
			fosSSV.write(ssvValueLine.getBytes());
			// MK log.debug("Really found instructions: "+realColumns);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fosCSV!=null) fosCSV.close();
				if(fosSSV!=null) fosSSV.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Gather and and log statistics about the given measurement. Writes a chart
	 * as a file into CHART_DIR.
	 * 
	 * @param measurementName
	 *            Descriptive title for the resulting chart.
	 * @param measurements
	 *            List of measuring numbers.
	 * @param printAllResults
	 *            When true, all results are written to the log.
	 *            @deprecated
	 */
	public void evaluateMeasurement(String measurementName,
			List<Long> measurements, boolean printAllResults) {
		log.info("");
		log.info("Statistics for \"" + measurementName + "\":");
		if (printAllResults) {
			for (long l : measurements) {
				log.info(l);
			}
		}

		// Add values to statistic classes
		DescriptiveStatistics stats = DescriptiveStatistics.newInstance();
		XYSeries series = new XYSeries(measurementName);
		for (int i = 0; i < measurements.size(); i++) {
			series.add(i, measurements.get(i));
			stats.addValue(measurements.get(i));
		}
		@SuppressWarnings("unused")
		XYDataset xyDataset = new XYSeriesCollection(series);
		// Draw a chart
		// writeToChartFile(measurementName, xyDataset, 800, 600, FILETYPE_PDF);

		Collections.sort(measurements); // needed to get smallest

		// log the statistic values
		log.info("Smallest:   " + measurements.get(0));
		log.info("Median:     " + measurements.get(measurements.size() / 2));
		log.info("  Mean:     " + ((int) stats.getMean()) + " (more precise: "
				+ stats.getMean());
		log.info("  SD:       " + ((int) stats.getStandardDeviation())
				+ " (more precise: " + stats.getStandardDeviation());
		// log.info(" Variance: " + stats.getVariance());
	}

	/**@deprecated
	 * @param r
	 * @param inputVarValue
	 */
	public void makeMLSetFromResult(CountingResult r, int inputVarValue) {
		@SuppressWarnings("unused")
		long time = r.getTime();
		@SuppressWarnings("unused")
		String qualifyingMethodName = r.getQualifyingMethodName();
		HashMap<Integer, Integer> opcodeCounts = r.getOpcodeCounts();
		@SuppressWarnings("unused")
		HashMap<String, Integer> methodCallCounts = r.getMethodCallCounts();

		// make sure DisplayOpcodes does not interfer the output
		ASMOpcodesMapper.getInstance();

		FileOutputStream fosCSV = null;
		FileOutputStream fosSSV = null;
		String csvValueSeparator = ",";

		StringBuffer csvNames = new StringBuffer();
		@SuppressWarnings("unused")
		StringBuffer ssvNames = new StringBuffer();
		StringBuffer csvValues = new StringBuffer();
		@SuppressWarnings("unused")
		StringBuffer ssvValues = new StringBuffer();
		csvNames.append("param" + csvValueSeparator);
		csvValues.append(paramForLogging + csvValueSeparator);
		List<String> existingBytecodes = new ArrayList<String>();
		List<Integer> outputVarsValues = new ArrayList<Integer>();

		try {
			fosCSV = new FileOutputStream("./" + System.currentTimeMillis()
					+ ".csv.MLSet");
			Integer count = null;
			ASMOpcodesMapper dispo = ASMOpcodesMapper.getInstance();
			String opcodeString = null;
			int realColumns = 0;
			for (int i = 0; i < 500; i++) {
				opcodeString = dispo.getOpcodeString(i);
				if (opcodeString != null && !opcodeString.equals("")) {
					realColumns++;
					existingBytecodes.add(opcodeString);
					csvNames.append(opcodeString + csvValueSeparator);
					count = opcodeCounts.get(i);
					if (count == null || count.intValue() == 0) {
						csvValues.append("0" + csvValueSeparator);
						outputVarsValues.add(0);
					} else {
						csvValues.append("" + count + csvValueSeparator);
						outputVarsValues.add(count);

					}
				}
			}
			fosCSV.write((csvNames.toString() + "\n").getBytes());
			fosCSV.write((csvValues.toString() + "\n").getBytes());

			fosSSV = new FileOutputStream("./" + System.currentTimeMillis()
					+ ".ssv.MLSet");
			String ssvNameLine = csvNames.toString().replace(',', ';') + "\n";
			String ssvValueLine = csvValues.toString().replace(',', ';') + "\n";
			fosSSV.write(ssvNameLine.getBytes());
			fosSSV.write(ssvValueLine.getBytes());
			// MK log.debug("Really found instructions: "+realColumns);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fosCSV.close();
				fosSSV.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// // log the number of occurrences for all method calls
		// log.info("\nThe following methods were called:");
		// String tabs;
		// for(String methodSig : methodCallCounts.keySet()) {
		// tabs = getTabs(methodSig + ":", 9);
		// log.info(methodSig + ": " + tabs + methodCallCounts.get(methodSig));
		// }
		// OneInputVarLearningSet set = new OneInputVarLearningSet("param",
		// existingBytecodes,
		// inputVarValue,
		// outputVarsValues);
		// return set;
		return;
	}

	//	
	// /** TODO move this to utils package
	// * Write a simple XY-Chart to the charts directory.
	// * @param title Title of the chart.
	// * @param xyDataset The chart to draw.
	// * @param width Width of the chart.
	// * @param height Height of the chart.
	// * @param filetype Type of the output file. See FILETYPE_* constants.
	// */
	// private void writeToChartFile(String title, XYDataset xyDataset,
	// int width, int height, int filetype) {
	//
	// JFreeChart chart = ChartFactory.createXYAreaChart
	// (title, // Title
	// "Measurement", // X-Axis label
	// "Time", // Y-Axis label
	// xyDataset, // Dataset
	// PlotOrientation.VERTICAL,
	// true, // Show legend
	// false, // no tooltips
	// false // no urls
	// );
	//
	// try {
	// // make sure the directory CHART_DIR exists:
	// File chartsdir = new File(CHART_DIR);
	// if(!chartsdir.exists() || !chartsdir.isDirectory()) {
	// if(chartsdir.mkdir() == false) {
	// throw new IOException("Error! Could not create charts directory");
	// } else {
	// log.info("Creating directory '" + CHART_DIR + "'.");
	// }
	// }
	//			
	// String filenameExtensionless = CHART_DIR + File.separator + title;
	//			
	// // save to the chosen filetype:
	// switch(filetype) {
	// case FILETYPE_PNG:
	// ChartUtilities.saveChartAsPNG(new File(filenameExtensionless + ".png"),
	// chart, width, height);
	// break;
	//				
	// case FILETYPE_JPG:
	// ChartUtilities.saveChartAsJPEG(new File(filenameExtensionless + ".jpg"),
	// chart, width, height);
	// break;
	//
	// case FILETYPE_PDF:
	// ChartResultWriter.saveChartAsPDF(
	// new File(filenameExtensionless + ".pdf"),
	// chart,
	// width,
	// height,
	// new DefaultFontMapper());
	// break;
	//				
	// default:
	// log.error("ERROR: Unknown filetype " + filetype + ". Please use a
	// FILETYPE_* constant.");
	// }
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// }
	//
}

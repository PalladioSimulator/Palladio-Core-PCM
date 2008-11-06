package de.uka.ipd.sdq.pcmsolver.tests;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;

/**
 * This is an adaption of MarkovTest05ORC. Here we are interested in finding an
 * optimal solution for providing some target reliability. This includes
 * performing a binary search over the possible base failure probabilities.
 * 
 * @author brosch
 * 
 */
public class MarkovTest06ORC {

	/**
	 * The Properties instance holds the references to the base PCM instance
	 * files.
	 */
	private Properties baseProps = new Properties();

	/**
	 * The Properties instance holds the references to the temporary PCM
	 * instance files.
	 */
	private Properties temporaryProps = new Properties();

	/**
	 * The PATH variable stores the local path to the base PCM instance.
	 */
	private static final String PATH = "C:\\MyData\\Eclipse\\"
			+ "workspace_3_3_europa_PCMSource\\OpenReferenceCase\\";

	/**
	 * The PATHADDITION variable stores the additional path to the temporary PCM
	 * instance.
	 */
	private static final String PATHADDITION = "Temporary";

	/**
	 * The MODELNAME variable stores the name of the PCM instance files.
	 */
	private static final String MODELNAME = "orc";

	/**
	 * The SCRIPTPATH variable stores the name of the resulting R script file.
	 */
	private static final String SCRIPTPATH = PATH + "Script\\script.r";

	/**
	 * The PLOTPATH variable stores the name of the resulting R plot file.
	 */
	private static final String PLOTPATH = PATH + "Script\\plot.eps";

	/**
	 * The RPATH variable stores the name of the R executable file.
	 */
	private static final String RPATH = "C:\\MyPrograms\\R\\R-2.7.2\\bin\\R.exe";

	/**
	 * The lower bound of tested item counts.
	 */
	private static final int ITEMCOUNTLOWERBOUND = 10;

	/**
	 * The upper bound of tested item counts.
	 */
	private static final int ITEMCOUNTUPPERBOUND = 100;

	/**
	 * The increment between two tested item counts.
	 */
	private static final int ITEMCOUNTSTEP = 10;

	/**
	 * The target reliability value.
	 */
	private static final double TARGET = 0.99999;

	/**
	 * The intended accuracy of the results.
	 */
	private static final double ACCURACY = 0.000000001;

	/**
	 * Sets up the test configuration.
	 * 
	 * @throws IOException
	 *             might be thrown during file copy
	 */
	@Before
	public void setUp() throws IOException {

		// Set the file names of the base PCM instance:
		baseProps.setProperty("Filename_Allocation", PATH + MODELNAME
				+ ".allocation");
		baseProps.setProperty("Filename_Repository", PATH + MODELNAME
				+ ".repository");
		baseProps.setProperty("Filename_ResourceEnvironment", PATH + MODELNAME
				+ ".resourceenvironment");
		baseProps.setProperty("Filename_ResourceType", PATH + MODELNAME
				+ ".resourcetype");
		baseProps.setProperty("Filename_System", PATH + MODELNAME + ".system");
		baseProps.setProperty("Filename_UsageModel", PATH + MODELNAME
				+ ".usagemodel");
		baseProps.setProperty("Storage_Path", PATH + PATHADDITION);

		// Set the file names of the temporary PCM instance:
		temporaryProps.setProperty("Filename_Allocation", PATH + PATHADDITION
				+ "\\" + MODELNAME + ".allocation");
		temporaryProps.setProperty("Filename_Repository", PATH + PATHADDITION
				+ "\\" + MODELNAME + ".repository");
		temporaryProps.setProperty("Filename_ResourceEnvironment", PATH
				+ PATHADDITION + "\\" + MODELNAME + ".resourceenvironment");
		temporaryProps.setProperty("Filename_ResourceType", PATH + PATHADDITION
				+ "\\" + MODELNAME + ".resourcetype");
		temporaryProps.setProperty("Filename_System", PATH + PATHADDITION
				+ "\\" + MODELNAME + ".system");
		temporaryProps.setProperty("Filename_UsageModel", PATH + PATHADDITION
				+ "\\" + MODELNAME + ".usagemodel");
		temporaryProps.setProperty("Storage_Path", PATH + PATHADDITION);

		// Create the temporary PCM instance:
		copyFile(baseProps.getProperty("Filename_Allocation"), temporaryProps
				.getProperty("Filename_Allocation"));
		copyFile(baseProps.getProperty("Filename_Repository"), temporaryProps
				.getProperty("Filename_Repository"));
		copyFile(baseProps.getProperty("Filename_ResourceEnvironment"),
				temporaryProps.getProperty("Filename_ResourceEnvironment"));
		copyFile(baseProps.getProperty("Filename_ResourceType"), temporaryProps
				.getProperty("Filename_ResourceType"));
		copyFile(baseProps.getProperty("Filename_System"), temporaryProps
				.getProperty("Filename_System"));
		copyFile(baseProps.getProperty("Filename_UsageModel"), temporaryProps
				.getProperty("Filename_UsageModel"));
	}

	/**
	 * Performs the sensitivity analysis.
	 * 
	 * @throws IOException
	 *             might be thrown during script file generation
	 * @throws InterruptedException
	 *             might be thrown during R execution
	 */
	@Test
	public void extendedMarkovTransform() throws IOException,
			InterruptedException {

		// Declare some arrays to store the results:
		ArrayList<Integer> inputValues = new ArrayList<Integer>();
		ArrayList<Double> resultValues = new ArrayList<Double>();

		// Run a test series with stepwise changes of the PCM instance:
		for (Integer i = ITEMCOUNTLOWERBOUND; i <= ITEMCOUNTUPPERBOUND; i += ITEMCOUNTSTEP) {

			// Store the input value:
			inputValues.add(i);

			// Initialize the search parameters:
			double lowerIntervalBound = 0.0;
			double upperIntervalBound = 1.0;
			double intervalSize = upperIntervalBound - lowerIntervalBound;

			// Perform a binary search:
			while (intervalSize > ACCURACY) {

				// Split the interval in two halves:
				double newBound = lowerIntervalBound + intervalSize / 2;

				// Perform the analysis:
				double result = performAnalysis(i, newBound);
				if (result < TARGET) {
					upperIntervalBound = newBound;
					intervalSize = upperIntervalBound - lowerIntervalBound;
				} else if (result > TARGET) {
					lowerIntervalBound = newBound;
					intervalSize = upperIntervalBound - lowerIntervalBound;
				} else {
					break;
				}
			}

			// Store the result value (the middle of the search interval):
			resultValues.add(lowerIntervalBound + intervalSize / 2);
		}

		// Generate an R script to plot the results into a diagram:
		generateScript(inputValues, resultValues);

		// Run the R script:
		runR();
	}

	/**
	 * Performs a Markov analysis with the given parameters for item count of
	 * bookSale and failure probability of InternalAction AccessData.
	 * 
	 * @param itemCount
	 *            item count of bookSale call
	 * @param failureProbability
	 *            failure probability of Internal Action AccessData
	 * @return resulting failure probability of bookSale call
	 */
	private double performAnalysis(final Integer itemCount,
			final Double failureProbability) {

		// We need a MarkovTestHelper to perform an EMF model query:
		MarkovTestHelper helper = new MarkovTestHelper();

		// Load the temporary PCM instance from the given files:
		PCMInstance temporaryModel = new PCMInstance(temporaryProps);

		// Adjust the temporary PCM instance by changing the failure
		// probability of the InternalAction "AccessData":
		InternalAction action = (InternalAction) helper.getModelElement(
				temporaryModel.getRepository(), "_BqnUYKapEd2aT7ee5CpgQg");
		action.setFailureProbability(failureProbability.toString());

		// Further adjust the PCM instance by changing the number of
		// items input into the bookSale() call:
		EntryLevelSystemCall call = (EntryLevelSystemCall) helper
				.getModelElement(temporaryModel.getUsageModel()
						.getUsageScenario_UsageModel().get(0),
						"_x0OCkHk5Ed2DBfjHDxUcwg");
		call.getInputParameterUsages_EntryLevelSystemCall().get(0)
				.getVariableCharacterisation_VariableUsage().get(0)
				.getSpecification_VariableCharacterisation().setSpecification(
						itemCount.toString());

		// It is necessary to store the changes back to the model files
		// because EMF model element proxies won't be resolved to
		// elements already loaded into memory, but to elements newly
		// created out of the model files. The saving has to be done
		// before any proxy resolving takes place:
		temporaryModel.saveToFiles(MODELNAME);

		// Initialize a new Pcm2Markov Strategy:
		Pcm2MarkovStrategy strat = new Pcm2MarkovStrategy();

		// Transform the PCM instance to a Markov Chain instance:
		strat.transform(temporaryModel);

		// Solve the Markov Chain instance:
		strat.solve();

		// Return the result:
		return strat.getSolvedValue();
	}

	/**
	 * Helper routine to copy a file from a source path to a target path.
	 * 
	 * @param sourcePath
	 *            the source path - must be an absolute path including file name
	 * @param targetPath
	 *            the target path - must be an absolute path including file name
	 * @throws IOException
	 *             might be thrown during file access
	 */
	private void copyFile(final String sourcePath, final String targetPath)
			throws IOException {

		// Create file objects:
		File inputFile = new File(sourcePath);
		File outputFile = new File(targetPath);

		// Create new directory and file, if not already existent:
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();

		// Copy contents of original file into new file:
		FileReader in = new FileReader(inputFile);
		FileWriter out = new FileWriter(outputFile);
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}

		// It's done:
		in.close();
		out.close();
	}

	/**
	 * Helper routine that generates an R script which includes commands to plot
	 * a diagram.
	 * 
	 * @param xValues
	 *            the x axis values of the diagram
	 * @param yValues
	 *            the y axis values of the diagram
	 * @throws IOException
	 *             might be thrown during file access
	 */
	private void generateScript(final ArrayList<Integer> xValues,
			final ArrayList<Double> yValues) throws IOException {

		// Create file object:
		File outputFile = new File(SCRIPTPATH);

		// Create new directory and file, if not already existent:
		outputFile.getParentFile().mkdir();
		outputFile.createNewFile();

		// Generate Script contents:
		BufferedWriter out = new BufferedWriter(new FileWriter(outputFile));

		// Read xValues into variable x:
		out.write("x <- c(");
		for (int i = 0; i < xValues.size(); i++) {
			out.write(xValues.get(i).toString());
			out.write((i == xValues.size() - 1) ? ")" : ", ");
		}
		out.newLine();

		// Read yValues into variable y:
		out.write("y <- c(");
		for (Integer i = 0; i < yValues.size(); i++) {
			out.write(yValues.get(i).toString());
			out.write((i == yValues.size() - 1) ? ")" : ", ");
		}
		out.newLine();

		// Generate an EPS file for the plot:
		out.write("postscript(\"" + PLOTPATH.replace("\\", "\\\\")
				+ "\", height = 10, width = 8, pointsize = 10)");
		out.newLine();

		// Start the new diagram plot:
		out.write("plot.new()");
		out.newLine();

		// Set the dimensions of the plot so that all x and y values are shown:
		double yMin = 0.0;
		double yMax = 0.000001;
		out.write("plot.window(xlim = c(" + ITEMCOUNTLOWERBOUND + ","
				+ ITEMCOUNTUPPERBOUND + "), ylim = c(" + yMin + "," + yMax
				+ "))");
		out.newLine();

		// Plot the y values:
		out.write("points(x,y); lines(x,y)");
		out.newLine();

		// Plot helper lines:
		for (double d = yMin; d <= yMax; d += (yMax - yMin) / 5) {
			out.write("abline(h = " + d + ", lty = 3)");
			out.newLine();
		}
		for (int d = ITEMCOUNTLOWERBOUND; d <= ITEMCOUNTUPPERBOUND; d += ITEMCOUNTSTEP) {
			out.write("abline(v = " + d + ", lty = 3)");
			out.newLine();
		}

		// Plot the axes and a box around all:
		out.write("axis(1); axis(2); box()");
		out.newLine();

		// Finish the plot:
		out.write("dev.off()");
		out.newLine();

		// It's done:
		out.close();
	}

	/**
	 * Starts R with the script generated before in order to produce the result
	 * plot.
	 * 
	 * @throws IOException
	 *             might be thrown during file access
	 * @throws InterruptedException
	 *             might be thrown during process execution
	 * 
	 */
	private void runR() throws IOException, InterruptedException {

		// Collect the arguments necessary for process start:
		ProcessBuilder processBuilder = new ProcessBuilder(RPATH, "CMD",
				"BATCH", SCRIPTPATH);

		// Start the process:
		Process process = processBuilder.start();

		// Wait for the process to exit:
		process.waitFor();
	}
}

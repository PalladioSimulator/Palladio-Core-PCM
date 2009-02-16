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
 * Performs a sensitivity analysis on the Markov transformation. During multiple
 * test runs, some properties of a base PCM instance are stepwise changed and
 * saved into a temporary PCM instance. For the temporary PCM instance, a
 * reliability analysis is performed. By that, the impact of the changes on the
 * resulting reliability can be determined. The results are saved into a file
 * which can be used to plot an R diagram. As this test case includes EMF model
 * queries, it has to be run as a JUnit Plug-in Test (not only a JUnit Test).
 * 
 * @author brosch
 * 
 */
public class MarkovTest05ORC {

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
	private static final String PLOTPATH = PATH + "Script\\plot.pdf";

	/**
	 * The RPATH variable stores the name of the R executable file.
	 */
	private static final String RPATH = "C:\\MyPrograms\\R\\R-2.7.2\\bin\\R.exe";

	/**
	 * The lower bound of tested failure probabilities.
	 */
	private static final double FAILPROBLOWERBOUND = 0.0;

	/**
	 * The upper bound of tested failure probabilities.
	 */
	private static final double FAILPROBUPPERBOUND = 0.000002;

	/**
	 * The increment between two tested failure probabilities.
	 */
	private static final double FAILPROBSTEP = 0.000001;

	/**
	 * The lower bound of tested item counts.
	 */
	private static final int ITEMCOUNTLOWERBOUND = 0;

	/**
	 * The upper bound of tested item counts.
	 */
	private static final int ITEMCOUNTUPPERBOUND = 20;

	/**
	 * The increment between two tested item counts.
	 */
	private static final int ITEMCOUNTSTEP = 5;

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
		ArrayList<Double> failprobValues = new ArrayList<Double>();
		ArrayList<ArrayList<Double>> resultValuesSeries = new ArrayList<ArrayList<Double>>();

		// Run a test series with stepwise changes of the PCM instance:
		for (double d = FAILPROBLOWERBOUND; d <= FAILPROBUPPERBOUND; d += FAILPROBSTEP) {

			// Create a new Array of result values:
			resultValuesSeries.add(new ArrayList<Double>());

			// Store the current failure probability:
			failprobValues.add(d);

			for (int i = ITEMCOUNTLOWERBOUND; i <= ITEMCOUNTUPPERBOUND; i += ITEMCOUNTSTEP) {

				// During the first iteration of the outer loop, Store the input
				// values:
				if (d == FAILPROBLOWERBOUND) {
					inputValues.add(i);
				}

				// Store the result:
				resultValuesSeries.get(resultValuesSeries.size() - 1).add(
						performAnalysis(i, d));
			}
		}

		// Generate an R script to plot the results into a diagram:
		generateScript(inputValues, failprobValues, resultValuesSeries);

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
	private double performAnalysis(final int itemCount,
			final double failureProbability) {

		// We need a MarkovTestHelper to perform an EMF model query:
		MarkovTestHelper helper = new MarkovTestHelper();

		// Load the temporary PCM instance from the given files:
		PCMInstance temporaryModel = new PCMInstance(temporaryProps);

		// Adjust the temporary PCM instance by changing the failure
		// probabilities of the InternalActions "AccessData" and "QueryData":
		InternalAction action = (InternalAction) helper.getModelElement(
				temporaryModel.getRepository(), "_BqnUYKapEd2aT7ee5CpgQg");
		action.setFailureProbability(((Double) failureProbability).toString());
		action = (InternalAction) helper.getModelElement(temporaryModel
				.getRepository(), "_QyQB4KapEd2aT7ee5CpgQg");
		action.setFailureProbability(((Double) failureProbability).toString());

		// Further adjust the PCM instance by changing the number of
		// items input into the bookSale() call:
		EntryLevelSystemCall call = (EntryLevelSystemCall) helper
				.getModelElement(temporaryModel.getUsageModel()
						.getUsageScenario_UsageModel().get(0),
						"_x0OCkHk5Ed2DBfjHDxUcwg");
		call.getInputParameterUsages_EntryLevelSystemCall().get(0)
				.getVariableCharacterisation_VariableUsage().get(0)
				.getSpecification_VariableCharacterisation().setSpecification(
						((Integer) itemCount).toString());

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
	 * @param legendValues
	 *            the legend values of the diagram
	 * @param yValuesSeries
	 *            the y axis values series of the diagram
	 * @throws IOException
	 *             might be thrown during file access
	 */
	private void generateScript(final ArrayList<Integer> xValues,
			final ArrayList<Double> legendValues,
			final ArrayList<ArrayList<Double>> yValuesSeries)
			throws IOException {

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
		for (int i = 0; i < yValuesSeries.size(); i++) {
			out.write("y" + i + " <- c(");
			for (Integer j = 0; j < yValuesSeries.get(i).size(); j++) {
				out.write(yValuesSeries.get(i).get(j).toString());
				out.write((j == yValuesSeries.get(i).size() - 1) ? ")" : ", ");
			}
			out.newLine();
		}

		// Generate an EPS file for the plot.
		// - height, width: size of the plot
		// - pointsize: font size of all text in plot
		// - mar: size of the margin around the 4 sides of the plot
		// - bg: sets the background color to white --> assures that
		// legend is not painted with transparent background
		out.write("pdf(\"" + PLOTPATH.replace("\\", "\\\\")
				+ "\", height = 3, width = 6, pointsize = 10);");
		out.write("par(mar=c(5, 10, 1, 10), bg = \"white\")");
		out.newLine();

		// Start the new diagram plot:
		out.write("plot.new()");
		out.newLine();

		// Set the ranges of the x and y axis in the plot:
		out.write("plot.window(xlim = c(" + xValues.get(0) + ","
				+ xValues.get(xValues.size() - 1) + "), ylim = c(0.99995,1))");
		out.newLine();

		// Plot all functions of the y values series:
		int[] pointtypes = new int[] { 4, 0, 1 };
		for (int i = 0; i < yValuesSeries.size(); i++) {
			out.write("lines(x,y" + i + ");");
			out.write("points(x,y" + i + ", pch = " + pointtypes[i] + ")");
			out.newLine();
		}

		// Plot a target line of 99.999% reliability:
		out.write("abline(h = 0.99999, lty = 2);");

		// Plot helper lines:
		out.write("abline(h = 0.99995, lty = 3);");
		out.write("abline(h = 0.99996, lty = 3);");
		out.write("abline(h = 0.99997, lty = 3);");
		out.write("abline(h = 0.99998, lty = 3);");
		out.write("abline(h = 1, lty = 3);");
		out.write("abline(v = 0, lty = 3);");
		out.write("abline(v = 5, lty = 3);");
		out.write("abline(v = 10, lty = 3);");
		out.write("abline(v = 15, lty = 3);");
		out.write("abline(v = 20, lty = 3)");
		out.newLine();

		// Plot the axes and a box around all.
		// - side: which axis (bottom / left / top / right)
		// - las: label orientation (1 - horizontal)
		out.write("axis(side = 1, las = 1); axis(side = 2, las = 1); box()");
		out.newLine();

		// Add text to the axes:
		out.write("mtext(\"number of items\", side = 1, line = 3);");
		out.write("mtext(\"reliability\", side = 2, line = 6)");
		out.newLine();

		// Add a legend:
		String strLegend = "legend(x = 0, y = 0.99997, legend = c(";
		for (int i = 0; i < legendValues.size(); i++) {
			strLegend += "\"fp = " + legendValues.get(i) + "\"";
			if (i < legendValues.size() - 1) {
				strLegend += ",";
			}
		}
		strLegend += "), lty = c(1,1,1), pch = c(" + pointtypes[0] + ","
				+ pointtypes[1] + "," + pointtypes[2] + "));";
		out.write(strLegend);
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

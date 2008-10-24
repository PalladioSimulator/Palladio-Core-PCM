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
	private static final String PLOTPATH = PATH + "Script\\plot.eps";

	/**
	 * The RPATH variable stores the name of the R executable file.
	 */
	private static final String RPATH = "C:\\MyPrograms\\R\\R-2.7.2\\bin\\R.exe";

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

		// We need a MarkovTestHelper to perform an EMF model query:
		MarkovTestHelper helper = new MarkovTestHelper();

		// Declare some arrays to store the results:
		ArrayList<Double> inputValues = new ArrayList<Double>();
		ArrayList<Double> resultValues = new ArrayList<Double>();

		// Run a test series with stepwise changes of the failure probability of
		// the InternalAction:
		for (Double d = 0.0; d <= 0.1; d += 0.01) {

			// Store the input value:
			inputValues.add(d);

			// Load the temporary PCM instance from the given files:
			PCMInstance temporaryModel = new PCMInstance(temporaryProps);

			// Adjust the temporary PCM instance by changing the failure
			// probability of the InternalAction "interact with java
			// EntityManager":
			InternalAction action = (InternalAction) helper.getModelElement(
					temporaryModel.getRepository(), "_T1zY8NLaEduQ7qbNANXHPw");
			action.setFailureProbability(d.toString());

			// It is necessary to store the changes back to the model files
			// because EMF model element proxies won't be resolved to elements
			// already loaded into memory, but to elements newly created out of
			// the model files. The saving has to be done before any proxy
			// resolving takes place:
			temporaryModel.saveToFiles(MODELNAME);

			// Initialize a new Pcm2Markov Strategy:
			Pcm2MarkovStrategy strat = new Pcm2MarkovStrategy();

			// Transform the PCM instance to a Markov Chain instance:
			strat.transform(temporaryModel);

			// Solve the Markov Chain instance:
			strat.solve();

			// Store the result:
			resultValues.add(strat.getSolvedValue());
		}

		// Generate an R script to plot the results into a diagram:
		generateScript(inputValues, resultValues);

		// Run the R script:
		runR();
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
	private void generateScript(final ArrayList<Double> xValues,
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
		for (int i = 0; i < yValues.size(); i++) {
			out.write(yValues.get(i).toString());
			out.write((i == yValues.size() - 1) ? ")" : ", ");
		}
		out.newLine();

		// Generate an EPS file for the plot:
		out.write("postscript(\"" + PLOTPATH.replace("\\", "\\\\") + "\")");
		out.newLine();

		// Plot the diagram which built of xValues and yValues:
		out.write("plot(x,y)");
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

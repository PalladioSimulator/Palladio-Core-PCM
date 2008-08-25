package de.uka.ipd.sdq.pcmsolver.tests;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.WriterAppender;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.junit.Before;
import org.junit.Test;

import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;

/**
 * This test case examines the correctness of the PCM 2 Markov transformation
 * and the Markov Solver. A simple PCM instance is transformed into a Markov
 * Chain instance, which is then solved. The solved value is compared to the
 * known result.
 * 
 * @author brosch
 * 
 */
public class MarkovTest01 {

	/**
	 * The Properties instance holds the references to the PCM instance files.
	 */
	private Properties props = new Properties();

	/**
	 * This variable determines the expected accuracy of the result.
	 */
	private double accuracy;

	/**
	 * The PATH variable stores the local path to the MarkovSample01 PCM
	 * instance.
	 */
	private static final String PATH = "C:\\MyData\\Eclipse\\"
			+ "workspace_3_3_europa_PCMSource\\de.uka.ipd.sdq.pcmsolver\\"
			+ "src\\de\\uka\\ipd\\sdq\\pcmsolver\\tests\\MarkovSample01\\";

	/**
	 * Sets up the test configuration.
	 */
	@Before
	public void setUp() {

		// Set the file names of the PCM instance:
		props.setProperty("Filename_Allocation", PATH + "simple.allocation");
		props.setProperty("Filename_Repository", PATH + "simple.repository");
		props.setProperty("Filename_ResourceEnvironment", PATH
				+ "simple.resourceenvironment");
		props.setProperty("Filename_ResourceType", PATH
				+ "Palladio.resourcetype");
		props.setProperty("Filename_System", PATH + "simple.system");
		props.setProperty("Filename_UsageModel", PATH + "simple.usagemodel");
		props.setProperty("Storage_Path", PATH + "C:\\temp\\PCM");

		// Set the expected accuracy:
		accuracy = Math.pow(0.1, 12);
	}

	/**
	 * Tests the transformation to and solving of the Markov Chain.
	 */
	@Test
	public void runMarkovTransform() {

		// Load the PCM instance from the given files:
		PCMInstance model = new PCMInstance(props);

		// Initialize a new Pcm2Markov Strategy:
		Pcm2MarkovStrategy strat = new Pcm2MarkovStrategy();

		// Transform the PCM instance to a Markov Chain instance:
		strat.transform(model);

		// Solve the Markov Chain instance:
		strat.solve();

		// What is the result?
		double result = strat.getSolvedValue();

		// Calculate the expected result:
		double relMyInnerInternalAction = 0.99;
		double relMyInternalAction = 0.95;
		double[] loopExecutionCounts = new double[] { 2, 6, 10 };
		double[] loopExecutionProbabilities = new double[] { 0.5, 0.3, 0.2 };
		double expectedResult = 0;
		for (int i = 0; i < loopExecutionCounts.length; i++) {
			expectedResult += loopExecutionProbabilities[i]
					* Math
							.pow(relMyInnerInternalAction,
									loopExecutionCounts[i])
					* relMyInternalAction;
		}

		// Compare the expected result and the solved Markov Chain value:
		assertTrue(Math.abs(result - expectedResult) < accuracy);
	}

}

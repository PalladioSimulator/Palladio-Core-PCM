package de.uka.ipd.sdq.pcmsolver.tests;

import static org.junit.Assert.assertTrue;

import java.util.Properties;

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
public class MarkovTest02 {

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
			+ "src\\de\\uka\\ipd\\sdq\\pcmsolver\\tests\\MarkovSample02\\";

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
		double[] branchProbabilities01 = new double[] { 0.7, 0.3 };
		double[] branchReliabilities01 = new double[] { 0.99, 0.95 };
		double[] branchProbabilities02 = new double[] { 0.1, 0.9 };
		double[] branchReliabilities02 = new double[] { 0.9, 0.8 };
		double temporaryResult01 = 0;
		for (int i = 0; i < branchProbabilities01.length; i++) {
			temporaryResult01 += branchProbabilities01[i] * branchReliabilities01[i];
		}
		double temporaryResult02 = 0;
		for (int i = 0; i < branchProbabilities02.length; i++) {
			temporaryResult02 += branchProbabilities02[i] * branchReliabilities02[i];
		}
		double expectedResult = temporaryResult01 * temporaryResult02;

		// Compare the expected result and the solved Markov Chain value:
		assertTrue(Math.abs(result - expectedResult) < accuracy);
	}

}

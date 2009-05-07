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
public class MarkovTest04 {

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
			+ "src\\de\\uka\\ipd\\sdq\\pcmsolver\\tests\\MarkovSample04\\";

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
		props.setProperty("Storage_Path", PATH + "StoragePath");

		// Set the expected accuracy:
		accuracy = Math.pow(0.1, 12);
	}

	/**
	 * Tests the transformation to and solving of the Markov Chain.
	 * 
	 * @throws ParserException
	 */
	@Test
	public void runMarkovTransform() {

		// Load the PCM instance from the given files:
		PCMInstance model = new PCMInstance(props);

		// Specify the FailureProbability of the SystemExternalCall (this is, by
		// now, a hack):
		// MarkovSeffVisitor.sysExList = new ArrayList<String>();
		// MarkovSeffVisitor.sysExList.add("_x3m30I4AEd2gLOE4VNvlmQ");
		// MarkovSeffVisitor.failProbList = new ArrayList<String>();
		// MarkovSeffVisitor.failProbList.add("0.01");

		// Initialize a new Pcm2Markov Strategy:
		Pcm2MarkovStrategy strat = new Pcm2MarkovStrategy();

		// Transform the PCM instance to a Markov Chain instance:
		strat.transform(model);

		// Solve the Markov Chain instance:
		strat.solve();

		// What is the result?
		double result = strat.getSolvedValue();

		// Calculate the expected result:
		double expectedResult = 0.99;

		// Compare the expected result and the solved Markov Chain value:
		assertTrue(Math.abs(result - expectedResult) < accuracy);
	}
}

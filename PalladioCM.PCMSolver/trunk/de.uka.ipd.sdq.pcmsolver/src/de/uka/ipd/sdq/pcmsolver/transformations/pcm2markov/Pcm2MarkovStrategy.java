package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.concurrent.TimeUnit;

import markov.MarkovChain;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.markovsolver.MarkovSolver;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.visitors.UsageModelVisitor;

/**
 * This class performs a transformation from a PCM instance to a Markov Chain
 * instance, and solves the resulting Markov Chain instance.
 * 
 * @author brosch
 * 
 */
public class Pcm2MarkovStrategy implements SolverStrategy {

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(Pcm2MarkovStrategy.class
			.getName());

	/**
	 * The Markov Chain instance that results from the transformation of the PCM
	 * instance.
	 */
	private MarkovChain markovChain;

	/**
	 * The solving value of the resulting Markov Chain instance.
	 */
	private double solvedValue;

	/**
	 * The constructor.
	 */
	public Pcm2MarkovStrategy() {

		// Initialize the Markov Chain with a default value:
		markovChain = new MarkovBuilder().initNewMarkovChain("");
	}

	/**
	 * Retrieves the value that results from solving the Markov Chain instance.
	 * 
	 * @return the resulting value
	 */
	public double getSolvedValue() {
		return solvedValue;
	}

	/**
	 * Loads an already existing Markov Chain from a given XMI file. Not yet
	 * implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file
	 */
	@Override
	public void loadTransformedModel(final String fileName) {
	}

	/**
	 * Solves the Markov Chain which has been created as a result of the
	 * transformation or has been loaded from an XMI file.
	 */
	@Override
	public void solve() {

		// Solve the Markov Chain:
		solvedValue = new MarkovSolver().solve(markovChain);
	}

	/**
	 * Saves the Markov Chain resulting from the transformation into an XMI
	 * file. Not yet implemented.
	 * 
	 * @param fileName
	 *            the name of the XMI file to create
	 */
	@Override
	public void storeTransformedModel(final String fileName) {
	}

	/**
	 * Transforms a PCM instance into a Markov Chain instance. The
	 * transformation is performed in two steps. In the first step, parametric
	 * dependencies within the PCM instance are solved using the dependency
	 * solver. The resulting PCM instance is then transformed into a Markov
	 * Chain.
	 * 
	 * @param model
	 *            the input PCM instance
	 */
	@Override
	public void transform(final PCMInstance model) {

		// As a first step, solve parametric dependencies of the PCM instance:
		runDSolver(model);

		// Second, the PCM instance is transformed into a Markov Chain instance:
		runPcm2Markov(model);
	}

	/**
	 * Solves all parametric dependencies within a given PCM instance.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runDSolver(final PCMInstance model) {

		// Record the time consumed for solving parametric dependencies:
		long startTime = System.nanoTime();

		// The parametric dependencies are solved by using a visitor:
		UsageModelVisitor visitor = new UsageModelVisitor(model);

		try {

			// The dependency solver supports only solving a single
			// usage scenario (08-2008):
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);

			// Solve the PCM instance using the visitor:
			visitor.doSwitch(us.getScenarioBehaviour_UsageScenario());

		} catch (Exception e) {

			// The parametric dependencies could not be solved:
			logger.error("Solving of parametric dependencies caused Exception!"
					+ e.getMessage());
			e.printStackTrace();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger.debug("Solved parametric dependencies; Duration: " + duration
				+ " ms");
	}

	/**
	 * Transforms the given PCM instance into a Markov Chain instance. The PCM
	 * instance is assumed to have all parametric dependencies solved.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	private void runPcm2Markov(final PCMInstance model) {

		// Record the time consumed for creating the Markov Chain instance:
		long startTime = System.nanoTime();

		// The Markov Chain instance is created by using a visitor:
		MarkovUsageModelVisitor umVisit = new MarkovUsageModelVisitor(model);
		try {

			// The transformation supports only solving a single
			// usage scenario (08-2008):
			UsageScenario us = (UsageScenario) model.getUsageModel()
					.getUsageScenario_UsageModel().get(0);

			// Create the Markov Chain instance using the visitor:
			markovChain = (MarkovChain) umVisit.doSwitch(us
					.getScenarioBehaviour_UsageScenario());

		} catch (Exception e) {

			// The transformation did not succeed:
			logger.error("Usage Scenario caused Exception!" + e.getMessage());
			e.printStackTrace();
		}

		// Let the user know about the time consumed:
		long stopTime = System.nanoTime();
		long duration = TimeUnit.NANOSECONDS.toMillis(stopTime - startTime);
		logger
				.debug("Finished Markov Transform; Duration: " + duration
						+ " ms");
	}
}

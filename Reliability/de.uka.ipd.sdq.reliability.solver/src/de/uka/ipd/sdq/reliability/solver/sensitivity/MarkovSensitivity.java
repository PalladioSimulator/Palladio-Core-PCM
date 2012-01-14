package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.reliability.core.helper.EMFHelper;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;
import de.uka.ipd.sdq.sensitivity.SensitivityParameterVariation;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;

/**
 * Base class for (rudimentary) sensitivity analysis.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public abstract class MarkovSensitivity {

	/**
	 * Character used to separate entries in the sensitivity log file.
	 */
	private static final String LOG_ENTRY_SEPARATOR = "\\";

	/**
	 * The model on which sensitivity analysis is based.
	 */
	protected PCMInstance model;

	/**
	 * The current sensitivity analysis step.
	 */
	private int currentStepNumber = 0;

	/**
	 * Retrieves the current step number.
	 * 
	 * @return the current step number
	 */
	protected int getCurrentStepNumber() {
		return currentStepNumber;
	}

	/**
	 * Resets the current step number.
	 * 
	 */
	protected void resetCurrentStepNumber() {
		currentStepNumber = 1;
	}

	/**
	 * Increases the current step number.
	 * 
	 * @return indicates an overflow
	 */
	protected boolean increaseCurrentStepNumber() {
		if (currentStepNumber < numberOfSteps) {
			currentStepNumber++;
			return false;
		}
		return true;
	}

	/**
	 * Provides EMF utility functions.
	 */
	protected EMFHelper helper = new EMFHelper();

	/**
	 * Provides a writer to the log file.
	 */
	protected BufferedWriter logWriter = null;

	/**
	 * The name of this sensitivity (for logging).
	 */
	protected String name = null;

	/**
	 * The number of steps to take during sensitivity analysis.
	 */
	protected int numberOfSteps;

	/**
	 * The log file for sensitivity results.
	 */
	protected String resultLogfile = null;

	/**
	 * The variation of this sensitivity analysis.
	 */
	private SensitivityParameterVariation variation = null;

	/**
	 * Returns the double parameter variation.
	 * 
	 * @return the double parameter variation
	 */
	protected DoubleParameterVariation getDoubleVariation() {
		return (DoubleParameterVariation) variation;
	}

	/**
	 * Returns the string parameter sequence.
	 * 
	 * @return the string parameter sequence
	 */
	protected StringParameterSequence getStringSequence() {
		return (StringParameterSequence) variation;
	}

	/**
	 * A calculator for variations and steps during the sensitivity analysis.
	 */
	protected SensitivityCalculator calculator = new SensitivityCalculator();

	/**
	 * The constructor.
	 * 
	 * Only to be invoked by concrete sub classes.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param variation
	 *            the parameter variation
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	protected MarkovSensitivity(final String name,
			final SensitivityParameterVariation variation,
			final String resultLogFile) {
		this.name = name;
		this.variation = variation;
		this.numberOfSteps = calculator.calculateNumberOfSteps(variation);
		this.resultLogfile = resultLogFile;
	}

	/**
	 * The constructor.
	 * 
	 * Necessary because of the MultiSensitivity derivative.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 */
	protected MarkovSensitivity(final String name, final String resultLogFile) {
		this.name = name;
		this.resultLogfile = resultLogFile;
	}

	/**
	 * Finalizes the sensitivity analysis.
	 */
	public void finalize() {
		try {
			logWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves the model to be used for the next step in the sensitivity
	 * analysis.
	 * 
	 * @return the model
	 */
	public PCMInstance getNextModel() {

		// Check if there are still steps to perform:
		if (increaseCurrentStepNumber()) {
			return null;
		}

		// Perform the next step:
		if (!alterModel()) {
			return null;
		} else {
			return model;
		}
	}

	/**
	 * Initializes the sensitivity analysis.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	public void initialize(final PCMInstance model) {
		setModel(model);
		try {
			initLogFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Logs the results of the current sensitivity analysis step.
	 * 
	 * @param markovResults
	 *            the markov transformation results
	 */
	public void logResults(final List<MarkovTransformationResult> markovResults) {
		List<String> logResults = getLogSingleResults(markovResults);
		try {
			for (int index = 0; index < logResults.size(); index++) {
				logWriter.append(logResults.get(index) + LOG_ENTRY_SEPARATOR);
			}
			logWriter.append(System.getProperty("line.separator"));
			logWriter.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Initializes Markov result logging.
	 * 
	 * @throws IOException
	 */
	private void initLogFile() throws IOException {

		// Delete former file contents:
		new File(resultLogfile).delete();

		// Initialize the new log file:
		logWriter = new BufferedWriter(new FileWriter(resultLogfile, false));

		// Write headings:
		List<List<String>> headings = getLogHeadings();
		for (int lineNumber = 0; lineNumber < headings.size(); lineNumber++) {
			for (int index = 0; index < headings.get(lineNumber).size(); index++) {
				logWriter.append(headings.get(lineNumber).get(index)
						+ LOG_ENTRY_SEPARATOR);
			}
			logWriter.append(System.getProperty("line.separator"));
		}
		logWriter.flush();
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected abstract boolean alterModel();

	/**
	 * Builds the headings strings for logging.
	 * 
	 * @return the log headings strings
	 */
	protected List<List<String>> getLogHeadings() {

		// Create a result list:
		List<List<String>> resultList = getLogHeadingsMulti();
		for (UsageScenario scenario : model.getUsageModel()
				.getUsageScenario_UsageModel()) {
			resultList.get(0).add(
					"Success probability of UsageScenario \""
							+ scenario.getEntityName() + "\" <"
							+ scenario.getId() + ">");
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Builds the headings strings for logging.
	 * 
	 * @return the log headings strings
	 */
	protected abstract List<List<String>> getLogHeadingsMulti();

	/**
	 * Builds the results strings for sensitivity logging.
	 * 
	 * @param markovResults
	 *            the Markov transformation results
	 * @return the results strings
	 */
	protected List<String> getLogSingleResults(
			final List<MarkovTransformationResult> markovResults) {

		// Create a result list:
		List<String> resultList = getLogSingleResultsMulti();
		for (MarkovTransformationResult result : markovResults) {
			resultList
					.add(((Double) result.getSuccessProbability()).toString());
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Builds the results string for sensitivity logging.
	 * 
	 * @return the results strings
	 */
	protected abstract List<String> getLogSingleResultsMulti();

	/**
	 * Retrieves the PCM instance.
	 * 
	 * @return the PCM instance
	 */
	protected PCMInstance getModel() {
		return model;
	}

	/**
	 * Sets the PCM instance.
	 * 
	 * @param model
	 *            the PCM instance
	 */
	protected void setModel(final PCMInstance model) {
		this.model = model;
	}
}
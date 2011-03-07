package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.io.File;
import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

/**
 * Provides utility functions for reliability sensitivity analysis.
 * 
 * @author brosch
 * 
 */
public class SensitivityController {

	/**
	 * A logger to give detailed information about the sensitivity analysis.
	 */
	private static Logger logger = Logger.getLogger(SensitivityController.class
			.getName());

	/**
	 * Indicates if sensitivity analysis should be performed.
	 */
	private boolean sensitivityActive = false;

	/**
	 * Indicates if sensitivity analysis should be performed.
	 * 
	 * @return TRUE if sensitivity analysis should be performed.
	 */
	public boolean isSensitivityActive() {
		return sensitivityActive;
	}

	/**
	 * Determines the step count for sensitivity analysis.
	 */
	private int stepCount = 0;

	/**
	 * Gets the step count for sensitivity analysis.
	 * 
	 * @return the step count
	 */
	public int getStepCount() {
		return stepCount;
	}

	/**
	 * Temporary models directory.
	 */
	private File temporaryModelDir = null;

	/**
	 * Retrieves the temporary models directory.
	 * 
	 * @return the temporary models directory
	 */
	public File getTemporaryModelDir() {
		return temporaryModelDir;
	}

	/**
	 * The list of parameters for sensitivity analysis.
	 */
	private final ArrayList<SensitivityParameter> parameters = new ArrayList<SensitivityParameter>();

	/**
	 * Gets the list of parameters.
	 * 
	 * @return the list of parameters
	 */
	public ArrayList<SensitivityParameter> getParameters() {
		return parameters;
	}

	/**
	 * Creates sensitivity data out of a launch configuration.
	 * 
	 * @param configuration
	 *            launch configuration parameters.
	 */
	public SensitivityController(final ILaunchConfiguration configuration) {

		// Store configuration parameters:
		String elementURI = "";
		String strMin = "";
		String strMax = "";
		String strStep = "";
		String strPath = "";

		// Try to retrieve the settings from the given configuration:
		try {
			sensitivityActive = configuration.getAttribute(
					ConstantsContainer.SENSITIVITY_ACTIVE, false);
			elementURI = configuration.getAttribute(
					ConstantsContainer.VARIABLE_TEXT, "");
			strMin = configuration.getAttribute(
					ConstantsContainer.MINIMUM_TEXT, "");
			strMax = configuration.getAttribute(
					ConstantsContainer.MAXIMUM_TEXT, "");
			strStep = configuration.getAttribute(
					ConstantsContainer.STEP_WIDTH_TEXT, "");
			strPath = configuration.getAttribute(
					ConstantsContainer.TEMPORARY_MODELS_PATH, "");
		} catch (CoreException e) {

			// Defaults apply:
			sensitivityActive = false;
		}

		// Check if a sensitivity analysis shall be performed:
		if (!sensitivityActive) {
			return;
		}

		// Try to initialize the sensitivity parameter:
		if (!initializeParameter(elementURI, strMin, strMax, strStep)) {
			sensitivityActive = false;
			return;
		}

		// Try to determine the temporary model path:
		temporaryModelDir = new File(strPath);
		if (!temporaryModelDir.isDirectory()) {
			sensitivityActive = false;
			logger
					.warn("Path \""
							+ strPath
							+ "\" is not an existing Directory. Skipping sensitivity analysis");
		}

		// Inform the user:
		if (sensitivityActive) {
			logger.info("Sensitivity analysis activated");
		}
	}

	/**
	 * Initializes the sensitivity parameter from the given input data.
	 * 
	 * @param elementURI
	 *            the EMF model element URI
	 * @param strMin
	 *            the minimum value as a string
	 * @param strMax
	 *            the maximum value as a string
	 * @param strStep
	 *            the step as a string
	 * @return TRUE if the parameter could be successfully initialized
	 */
	private boolean initializeParameter(final String elementURI,
			final String strMin, final String strMax, final String strStep) {

		// Parse the sensitivity range and step:
		Double min;
		Double max;
		Double step;
		try {
			min = Double.parseDouble(strMin);
		} catch (NumberFormatException e) {
			logger.warn("Parsing error for sensitivity minimum value \""
					+ strMin + "\". Skipping sensitivity analysis");
			return false;
		}
		try {
			max = Double.parseDouble(strMax);
		} catch (NumberFormatException e) {
			logger.warn("Parsing error for sensitivity maximum value \""
					+ strMax + "\". Skipping sensitivity analysis");
			return false;
		}
		try {
			step = Double.parseDouble(strStep);
		} catch (NumberFormatException e) {
			logger.warn("Parsing error for sensitivity step value \"" + strStep
					+ "\". Skipping sensitivity analysis");
			return false;
		}

		// Check the given values:
		if ((min < 0.0) || (min > 1.0)) {
			logger
					.warn("Minimum sensitivity value ("
							+ min
							+ ") is not between 0 and 1. Skipping sensitivity analysis");
			return false;
		}
		if ((max < 0.0) || (max > 1.0)) {
			logger
					.warn("Maximum sensitivity value ("
							+ max
							+ ") is not between 0 and 1. Skipping sensitivity analysis");
			return false;
		}
		if (min > max) {
			logger.warn("Minimum sensitivity value (" + min
					+ ") is greater than maximum (" + max
					+ "). Skipping sensitivity analysis");
			return false;
		}

		// Create the new sensitivity parameter:
		SensitivityParameter parameter = new SensitivityParameter();
		parameter.setElementId(elementURI);
		for (Double d = min; d <= max; d += step) {
			parameter.getValues().add(d);
		}

		// Add the parameter to the list:
		parameters.add(parameter);

		// Adjust the sensitivity step count:
		if ((stepCount == 0) || (stepCount > parameter.getValues().size())) {
			stepCount = parameter.getValues().size();
		}

		// Return:
		return true;
	}
}

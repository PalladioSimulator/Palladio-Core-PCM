package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;

/**
 * Alters all MTTF values of hardware resources in the model.
 * 
 * @author brosch
 * 
 */
public class MTTFSensitivity extends MarkovSensitivity {

	/**
	 * Captures the current MTTF value.
	 */
	private double currentMTTF;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param firstValue
	 *            first value of sensitivity analysis
	 * @param lastValue
	 *            last value of sensitivity analysis
	 * @param numberOfSteps
	 *            number of steps of the analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public MTTFSensitivity(final String name, final double firstValue,
			final double lastValue, final int numberOfSteps,
			final String resultLogFile) {

		// Initialize basic variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);
	}

	/**
	 * The constructor.
	 * 
	 * Takes a list of values instead of a first and last value.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param list
	 *            the list of values
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public MTTFSensitivity(final String name, final List<Double> list,
			final String resultLogFile) {

		// Initialize basic variables:
		super(name, list, resultLogFile);
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		List<ProcessingResourceSpecification> specifications = getProcessingResourceSpecifications();
		if (specifications.size() == 0) {
			return false;
		}

		// Alter the parameter:
		setMTTF(specifications);

		// Everything ok:
		return true;
	}

	/**
	 * Builds the headings strings for logging.
	 * 
	 * @return the log headings strings
	 */
	protected List<List<String>> getLogHeadingsMulti() {

		// Create a result list:
		List<List<String>> resultList = new ArrayList<List<String>>();

		// Create the headings:
		ArrayList<String> headings = new ArrayList<String>();
		headings.add("Mean Time To Failure");
		resultList.add(headings);

		// Return the result:
		return resultList;
	}

	/**
	 * Builds the results strings for sensitivity logging.
	 * 
	 * @return the results strings
	 */
	protected List<String> getLogSingleResultsMulti() {

		// Create a result list:
		List<String> resultList = new ArrayList<String>();

		// Create the result strings:
		resultList.add(((Double) currentMTTF).toString());

		// Return the result:
		return resultList;
	}

	/**
	 * Retrieves the ProcessingResourceSpecifications that shall be altered
	 * during sensitivity analysis.
	 * 
	 * @return the relevant ProcessingResourceSpecifications
	 */
	List<ProcessingResourceSpecification> getProcessingResourceSpecifications() {

		// Declare result variable:
		ArrayList<ProcessingResourceSpecification> resultList = new ArrayList<ProcessingResourceSpecification>();

		// Retrieve the PCM resource environment:
		if (getModel().getResourceEnvironment() == null) {
			// No resource environment found!
			return null;
		}

		// Retrieve all resource specifications in all containers:
		ResourceContainer resourceContainer = null;
		EList<EObject> resourceContainers = helper.getElements(getModel()
				.getResourceEnvironment(), ResourceenvironmentFactory.eINSTANCE
				.createResourceContainer().eClass());
		for (EObject object : resourceContainers) {
			resourceContainer = (ResourceContainer) object;
			for (ProcessingResourceSpecification specification : resourceContainer
					.getActiveResourceSpecifications_ResourceContainer()) {
				resultList.add(specification);
			}
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Sets the MTTF value of the given processing resource specifications
	 * according to the current sensitivity analysis step.
	 * 
	 * @param specifications
	 *            the processing resource specifications
	 */
	void setMTTF(final List<ProcessingResourceSpecification> specifications) {

		// Determine the current failure probability:
		if (values == null) {
			currentMTTF = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentMTTF = values.get(getCurrentStepNumber() - 1);
		}

		// Iterate through all specifications:
		for (ProcessingResourceSpecification specification : specifications) {
			// Set the failure probability:
			specification.setMTTF(currentMTTF);
		}
	}
}
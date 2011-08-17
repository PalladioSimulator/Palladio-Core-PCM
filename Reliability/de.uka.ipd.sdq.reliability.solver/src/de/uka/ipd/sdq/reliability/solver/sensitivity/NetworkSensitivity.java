package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;

/**
 * Provides sensitivity support to alter the failure probabilities of all
 * communication links within the whole PCM Resource Environment.
 * 
 * @author brosch
 * 
 */
public class NetworkSensitivity extends MarkovSensitivity {

	/**
	 * Captures the current failure probability value.
	 */
	private double currentFailureProbability;

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
	public NetworkSensitivity(final String name, final double firstValue,
			final double lastValue, final int numberOfSteps,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);
	}

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param behaviourId
	 *            the id of the involved branch behaviour
	 * @param values
	 *            the values for the sensitivity analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public NetworkSensitivity(final String name, final List<Double> values,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, values, resultLogFile);
	}

	/**
	 * Retrieves all communication link resource specifications in the model.
	 * 
	 * @return the list of communication link resource specifications
	 */
	private List<CommunicationLinkResourceSpecification> getCommResources() {

		// Declare result list:
		List<CommunicationLinkResourceSpecification> resultList = new ArrayList<CommunicationLinkResourceSpecification>();

		// Retrieve the PCM Resource Environment:
		ResourceEnvironment resourceEnvironment = getModel()
				.getResourceEnvironment();
		if (resourceEnvironment == null) {
			// No repository found!
			return null;
		}

		// Search for the relevant BasicComponent:
		EList<EObject> commResources = helper.getElements(resourceEnvironment,
				ResourceenvironmentFactory.eINSTANCE
						.createCommunicationLinkResourceSpecification()
						.eClass());
		for (EObject object : commResources) {
			resultList.add((CommunicationLinkResourceSpecification) object);
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Sets the failure probability of the given comm resources according to the
	 * current sensitivity analysis step.
	 * 
	 * @param commResources
	 *            the comm resources
	 */
	private void setFailureProbability(
			final List<CommunicationLinkResourceSpecification> commResources) {

		// Determine the current failure probability:
		if (values == null) {
			currentFailureProbability = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentFailureProbability = values.get(getCurrentStepNumber() - 1);
		}

		// Set the failure probability:
		for (CommunicationLinkResourceSpecification commResource : commResources) {
			commResource.setFailureProbability(currentFailureProbability);
		}
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		List<CommunicationLinkResourceSpecification> commResources = getCommResources();
		if (commResources == null) {
			return false;
		}

		// Alter the parameter:
		setFailureProbability(commResources);

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
		headings.add("Network Failure Probabilities");
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
		resultList.add(((Double) currentFailureProbability).toString());

		// Return the result:
		return resultList;
	}
}
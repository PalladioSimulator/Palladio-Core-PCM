/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;

/**
 * This class provides rudimentary support for sensitivity analysis of a
 * hardware resource MTTF value.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class ResourceMTTFSensitivity extends MarkovSensitivity {

	/**
	 * Captures the current MTTF value.
	 */
	private double currentMTTF;

	/**
	 * The resource type to alter.
	 */
	private String processingResourceTypeId;

	/**
	 * The name of the resource type to alter.
	 */
	private String processingResourceTypeName;

	/**
	 * The resource container to alter.
	 */
	private String resourceContainerId;

	/**
	 * The name of the resource container to alter.
	 */
	private String resourceContainerName;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param resourceContainerId
	 *            the resource container to alter
	 * @param processingResourceTypeId
	 *            the resource type to alter
	 * @param firstValue
	 *            first value of sensitivity analysis
	 * @param lastValue
	 *            last value of sensitivity analysis
	 * @param numberOfSteps
	 *            number of steps of the analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ResourceMTTFSensitivity(final String name,
			final String resourceContainerId,
			final String processingResourceTypeId, final double firstValue,
			final double lastValue, final int numberOfSteps,
			final String resultLogFile) {

		// Initialize basic variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);

		// Further initializations:
		this.resourceContainerId = resourceContainerId;
		this.processingResourceTypeId = processingResourceTypeId;
	}

	/**
	 * The constructor.
	 * 
	 * Takes a list of values instead of a first and last value.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param resourceContainerId
	 *            the resource container to alter
	 * @param processingResourceTypeId
	 *            the resource type to alter
	 * @param list
	 *            the list of values
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ResourceMTTFSensitivity(final String name,
			final String resourceContainerId,
			final String processingResourceTypeId, final List<Double> list,
			final String resultLogFile) {

		// Initialize basic variables:
		super(name, list, resultLogFile);

		// Further initializations:
		this.resourceContainerId = resourceContainerId;
		this.processingResourceTypeId = processingResourceTypeId;
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		ProcessingResourceSpecification specification = getProcessingResourceSpecification();
		if (specification == null) {
			return false;
		}

		// Alter the parameter:
		setMTTF(specification);

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
		headings.add("Resource Container Name");
		headings.add("Resource Container ID");
		headings.add("Resource Type Name");
		headings.add("Resourcce Type ID");
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
		resultList.add(resourceContainerName);
		resultList.add(resourceContainerId);
		resultList.add(processingResourceTypeName);
		resultList.add(processingResourceTypeId);
		resultList.add(((Double) currentMTTF).toString());

		// Return the result:
		return resultList;
	}

	/**
	 * Retrieves the ProcessingResourceSpecification that shall be altered
	 * during sensitivity analysis.
	 * 
	 * @return the relevant ProcessingResourceSpecification
	 */
	ProcessingResourceSpecification getProcessingResourceSpecification() {

		// Retrieve the PCM resource environment:
		if (getModel().getResourceEnvironment() == null) {
			// No resource environment found!
			return null;
		}

		// Search for the relevant resource container:
		ResourceContainer resourceContainer = null;
		EList<EObject> resourceContainers = helper.getElements(getModel()
				.getResourceEnvironment(), ResourceenvironmentFactory.eINSTANCE
				.createResourceContainer().eClass());
		for (EObject object : resourceContainers) {
			if (((ResourceContainer) object).getId()
					.equals(resourceContainerId)) {
				resourceContainer = (ResourceContainer) object;
				break;
			}
		}
		if (resourceContainer == null) {
			// No corresponding resource container found!
			return null;
		}
		resourceContainerName = resourceContainer.getEntityName();

		// Search for the relevant processing resource specification:
		ProcessingResourceSpecification processingResourceSpecification = null;
		for (ProcessingResourceSpecification specification : resourceContainer
				.getActiveResourceSpecifications_ResourceContainer()) {
			if (specification
					.getActiveResourceType_ActiveResourceSpecification()
					.getId().equals(processingResourceTypeId)) {
				processingResourceSpecification = specification;
				processingResourceTypeName = specification
						.getActiveResourceType_ActiveResourceSpecification()
						.getEntityName();
				break;
			}
		}
		return processingResourceSpecification;
	}

	/**
	 * Sets the MTTF value of the given processing resource specification
	 * according to the current sensitivity analysis step.
	 * 
	 * @param specification
	 *            the processing resource specification
	 */
	void setMTTF(final ProcessingResourceSpecification specification) {

		// Determine the current failure probability:
		if (values == null) {
			currentMTTF = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentMTTF = values.get(getCurrentStepNumber() - 1);
		}

		// Set the failure probability:
		specification.setMTTF(currentMTTF);
	}
}

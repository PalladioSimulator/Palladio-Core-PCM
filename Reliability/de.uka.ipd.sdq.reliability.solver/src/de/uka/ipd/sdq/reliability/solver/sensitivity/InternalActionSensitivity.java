package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * This class provides rudimentary support for sensitivity analysis of an
 * internal action failure probability.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class InternalActionSensitivity extends MarkovSensitivity {

	/**
	 * Captures the current failure probability value.
	 */
	private double currentFailureProbability;

	/**
	 * The ID of the failure type.
	 */
	private String failureTypeId;

	/**
	 * The name of the failure type to alter.
	 */
	private String failureTypeName = null;

	/**
	 * The ID of the internal action to alter.
	 */
	private String internalActionId;

	/**
	 * The name of the internal action to alter.
	 */
	private String internalActionName = null;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param internalActionId
	 *            the id of the internal action to alter
	 * @param failureTypeId
	 *            the id of the failure type to alter
	 * @param variation
	 *            the parameter variation
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public InternalActionSensitivity(final String name,
			final String internalActionId, final String failureTypeId,
			final DoubleParameterVariation variation, final String resultLogFile) {

		// Initialize base variables:
		super(name, variation, resultLogFile);

		// Further initialization:
		this.internalActionId = internalActionId;
		this.failureTypeId = failureTypeId;
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		InternalFailureOccurrenceDescription description = getFailureOccurrenceDescription();
		if (description == null) {
			return false;
		}

		// Alter the parameter:
		setFailureProbability(description);

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
		headings.add("Internal Action Name");
		headings.add("Internal Action ID");
		headings.add("Failure Type Name");
		headings.add("Failure Type ID");
		headings.add("Failure Probability");
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
		resultList.add(internalActionName);
		resultList.add(internalActionId);
		resultList.add(failureTypeName);
		resultList.add(failureTypeId);
		resultList.add(((Double) currentFailureProbability).toString());

		// Return the result:
		return resultList;
	}

	/**
	 * Retrieves the FailureOccurrenceDescription that shall be altered during
	 * sensitivity analysis.
	 * 
	 * @return the relevant FailureOccurrenceDescription
	 */
	InternalFailureOccurrenceDescription getFailureOccurrenceDescription() {

		// Retrieve all FailureOccurrenceDescriptions in the PCM Repository:
		List<Repository> repositories = getModel().getRepositories();
		if (repositories.size() == 0) {
			// No repository found!
			return null;
		}

		// Search for the relevant internal action:
		InternalAction internalAction = null;
		for (Repository repository : repositories) {
			EList<EObject> internalActions = helper.getElements(repository,
					SeffFactory.eINSTANCE.createInternalAction().eClass());
			for (EObject action : internalActions) {
				if (((InternalAction) action).getId().equals(internalActionId)) {
					internalAction = (InternalAction) action;
					break;
				}
			}
		}
		if (internalAction == null) {
			// No corresponding internal action found!
			return null;
		}
		internalActionName = internalAction.getEntityName();

		// Search for the relevant failure occurrence description:
		InternalFailureOccurrenceDescription failureOccurrenceDescription = null;
		for (InternalFailureOccurrenceDescription description : internalAction
				.getInternalFailureOccurrenceDescriptions__InternalAction()) {
			if (description
					.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
					.getId().equals(failureTypeId)) {
				failureOccurrenceDescription = description;
				failureTypeName = description
						.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
						.getEntityName();
				break;
			}
		}
		return failureOccurrenceDescription;
	}

	/**
	 * Sets the failure probability of the given failure occurrence description
	 * according to the current sensitivity analysis step.
	 * 
	 * @param description
	 *            the failure occurrence description
	 */
	void setFailureProbability(
			final InternalFailureOccurrenceDescription description) {

		// Determine the current failure probability:
		currentFailureProbability = calculator.calculateCurrentDoubleValue(
				getDoubleVariation(), getCurrentStepNumber());

		// Set the failure probability:
		description.setFailureProbability(currentFailureProbability);
	}
}

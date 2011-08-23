package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

/**
 * Provides sensitivity support to alter the failure probabilities of all
 * internal actions within the whole PCM Repository.
 * 
 * @author brosch
 * 
 */
public class SoftwareSensitivity extends MarkovSensitivity {

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
	public SoftwareSensitivity(final String name, final double firstValue,
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
	public SoftwareSensitivity(final String name, final List<Double> values,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, values, resultLogFile);
	}

	/**
	 * Adjusts all Internal Action Failure Probabilities in the model. *
	 */
	private List<InternalAction> getInternalActions() {

		// Declare result list:
		List<InternalAction> resultList = new ArrayList<InternalAction>();

		// Retrieve all InternalActions in the PCM Repository:
		List<Repository> repositories = getModel().getRepositories();
		if (repositories.size() == 0) {
			// No repository found!
			return null;
		}

		// Search for the relevant BasicComponent:
		for (Repository repository : repositories) {
			EList<EObject> internalActions = helper.getElements(repository,
					SeffFactory.eINSTANCE.createInternalAction().eClass());
			for (EObject object : internalActions) {
				resultList.add((InternalAction) object);
			}
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Sets the failure probability of the given internal actions according to
	 * the current sensitivity analysis step.
	 * 
	 * @param internalActions
	 *            the internal actions
	 */
	private void setFailureProbability(
			final List<InternalAction> internalActions) {

		// Determine the current failure probability:
		if (values == null) {
			currentFailureProbability = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentFailureProbability = values.get(getCurrentStepNumber() - 1);
		}

		// Set the failure probability:
		for (InternalAction action : internalActions) {
			for (InternalFailureOccurrenceDescription description : action
					.getInternalFailureOccurrenceDescriptions__InternalAction()) {
				description.setFailureProbability(currentFailureProbability);
			}
		}
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		List<InternalAction> internalActions = getInternalActions();
		if (internalActions == null) {
			return false;
		}

		// Alter the parameter:
		setFailureProbability(internalActions);

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
		headings.add("Software Failure Probabilities");
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

/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.reliability.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;

/**
 * Provides sensitivity support to alter the branch probability of a
 * probabilistic branch transition.
 * 
 * @author brosch
 * 
 */
public class ProbabilisticBranchSensitivity extends MarkovSensitivity {

	/**
	 * Captures the current branch probability value.
	 */
	private double currentBranchProbability;

	/**
	 * The ID of the branch transition to alter.
	 */
	private String branchTransitionId;

	/**
	 * The name of the branch transition to alter.
	 */
	private String branchTransitionName = null;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param branchTransitionId
	 *            The id of the branch transition to alter
	 * @param firstValue
	 *            first value of sensitivity analysis
	 * @param lastValue
	 *            last value of sensitivity analysis
	 * @param numberOfSteps
	 *            number of steps of the analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ProbabilisticBranchSensitivity(final String name,
			final String branchTransitionId, final double firstValue,
			final double lastValue, final int numberOfSteps,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);

		// Further initialization:
		this.branchTransitionId = branchTransitionId;
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		ProbabilisticBranchTransition transition = getBranchTransition();
		if (transition == null) {
			return false;
		}

		// Alter the parameter:
		setBranchProbability(transition);

		// Everything ok:
		return true;
	}

	/**
	 * Retrieves the probabilistic branch transition that shall be altered
	 * during sensitivity analysis.
	 * 
	 * @return the relevant branch transition
	 */
	ProbabilisticBranchTransition getBranchTransition() {

		// Retrieve all BranchTransitions in the PCM Repository:
		List<Repository> repositories = getModel().getRepositories();
		if (repositories.size() == 0) {
			// No repository found!
			return null;
		}

		// Search for the relevant branch transition:
		ProbabilisticBranchTransition branchTransition = null;
		for (Repository repository : repositories) {
			EList<EObject> branchTransitions = helper.getElements(repository,
					SeffFactory.eINSTANCE.createProbabilisticBranchTransition()
							.eClass());
			for (EObject object : branchTransitions) {
				if (((ProbabilisticBranchTransition) object).getId().equals(
						branchTransitionId)) {
					branchTransition = (ProbabilisticBranchTransition) object;
					branchTransitionName = branchTransition.getEntityName();
					break;
				}
			}
		}
		return branchTransition;
	}

	/**
	 * Sets the branch probability of the given branch transition according to
	 * the current sensitivity analysis step.
	 * 
	 * @param transition
	 *            the branch transition
	 */
	void setBranchProbability(final ProbabilisticBranchTransition transition) {

		// Determine the current branch probability:
		currentBranchProbability = firstValue
				+ ((lastValue - firstValue) / (numberOfSteps - 1))
				* (getCurrentStepNumber() - 1);

		// Set the branch probability:
		transition.setBranchProbability(currentBranchProbability);
	}

	/**
	 * Builds the headings strings for logging.
	 * 
	 * @return the log headings strings
	 */
	protected List<List<String>> getLogHeadings() {

		// Create a result list:
		List<List<String>> resultList = getLogHeadingsMulti();
		resultList.get(0).add("Success Probability");

		// Return the result:
		return resultList;
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
		headings.add("Branch Transition Name");
		headings.add("Branch Transition ID");
		headings.add("Branch Probability");
		resultList.add(headings);

		// Return the result:
		return resultList;
	}

	/**
	 * Builds the results strings for sensitivity logging.
	 * 
	 * @param successProbability
	 *            success probability of the current sensitivity step
	 * @return the results strings
	 */
	protected List<String> getLogSingleResults(final double successProbability) {

		// Create a result list:
		List<String> resultList = getLogSingleResultsMulti();
		resultList.add(((Double) successProbability).toString());

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
		resultList.add(branchTransitionName);
		resultList.add(branchTransitionId);
		resultList.add(((Double) currentBranchProbability).toString());

		// Return the result:
		return resultList;
	}
}

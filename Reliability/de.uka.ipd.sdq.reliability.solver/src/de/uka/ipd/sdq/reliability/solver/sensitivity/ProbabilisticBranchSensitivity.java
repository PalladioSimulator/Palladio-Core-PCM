/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Provides sensitivity support to alter the branch probability of a
 * probabilistic branch transition.
 * 
 * @author brosch
 * 
 */
public class ProbabilisticBranchSensitivity extends MarkovSensitivity {

	/**
	 * The ID of the branch transition to alter.
	 */
	private String branchTransitionId;

	/**
	 * The name of the branch transition to alter.
	 */
	private String branchTransitionName = null;

	/**
	 * Captures the current branch probability value.
	 */
	private double currentBranchProbability;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param branchTransitionId
	 *            the id of the branch transition to alter
	 * @param variation
	 *            the parameter variation
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ProbabilisticBranchSensitivity(final String name,
			final String branchTransitionId,
			final DoubleParameterVariation variation, final String resultLogFile) {

		// Initialize base variables:
		super(name, variation, resultLogFile);

		// Further initialization:
		this.branchTransitionId = branchTransitionId;
	}

	/**
	 * Retrieves the probabilistic branch transition that shall be altered
	 * during sensitivity analysis.
	 * 
	 * @return the relevant branch transition
	 */
	private ProbabilisticBranchTransition getBranchTransition() {

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
	private void setBranchProbability(
			final ProbabilisticBranchTransition transition) {

		// Determine the current branch probability:
		currentBranchProbability = calculator.calculateCurrentDoubleValue(
				getDoubleVariation(), getCurrentStepNumber());

		// Set the branch probability:
		transition.setBranchProbability(currentBranchProbability);
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

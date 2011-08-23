/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;

/**
 * Provides sensitivity support to alter the branch probability of a
 * probabilistic usage branch transition.
 * 
 * @author brosch
 * 
 */
public class UsageBranchSensitivity extends MarkovSensitivity {

	/**
	 * The ID of the involved branch behaviour.
	 */
	private String behaviourId;

	/**
	 * The name of the involved branch behaviour.
	 */
	private String behaviourName = null;

	/**
	 * The ID of the usage branch to alter.
	 */
	private String branchId;

	/**
	 * The name of the usage branch to alter.
	 */
	private String branchName = null;

	/**
	 * Captures the current branch probability value.
	 */
	private double currentBranchProbability;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param branchId
	 *            the id of the usage branch to alter
	 * @param behaviourId
	 *            the id of the involved branch behaviour
	 * @param firstValue
	 *            first value of sensitivity analysis
	 * @param lastValue
	 *            last value of sensitivity analysis
	 * @param numberOfSteps
	 *            number of steps of the analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public UsageBranchSensitivity(final String name, final String branchId,
			final String behaviourId, final double firstValue,
			final double lastValue, final int numberOfSteps,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);

		// Further initialization:
		this.branchId = branchId;
		this.behaviourId = behaviourId;
	}

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param branchId
	 *            the id of the usage branch to alter
	 * @param behaviourId
	 *            the id of the involved branch behaviour
	 * @param values
	 *            the values for the sensitivity analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public UsageBranchSensitivity(final String name, final String branchId,
			final String behaviourId, final List<Double> values,
			final String resultLogFile) {

		// Initialize base variables:
		super(name, values, resultLogFile);

		// Further initialization:
		this.branchId = branchId;
		this.behaviourId = behaviourId;
	}

	/**
	 * Retrieves the probabilistic branch transition that shall be altered
	 * during sensitivity analysis.
	 * 
	 * @return the relevant branch transition
	 */
	private BranchTransition getBranchTransition() {

		// Retrieve all BranchTransitions in the PCM Repository:
		if (getModel().getUsageModel() == null) {
			// No repository found!
			return null;
		}

		// Search for the relevant branch:
		Branch branch = null;
		EList<EObject> branches = helper.getElements(
				getModel().getUsageModel(), UsagemodelFactory.eINSTANCE
						.createBranch().eClass());
		for (EObject object : branches) {
			if (((Branch) object).getId().equals(branchId)) {
				branch = (Branch) object;
				branchName = branch.getEntityName();
				break;
			}
		}
		if (branch == null) {
			return null;
		}

		// Search for the relevant branch transition:
		for (BranchTransition transition : branch.getBranchTransitions_Branch()) {
			if (transition.getBranchedBehaviour_BranchTransition().getId()
					.equals(behaviourId)) {
				behaviourName = transition
						.getBranchedBehaviour_BranchTransition()
						.getEntityName();
				return transition;
			}
		}

		// No corresponding transition found:
		return null;
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		BranchTransition transition = getBranchTransition();
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
		headings.add("Branch Name");
		headings.add("Branch ID");
		headings.add("Scenario Behaviour Name");
		headings.add("Scenario Behaviour ID");
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
		resultList.add(branchName);
		resultList.add(branchId);
		resultList.add(behaviourName);
		resultList.add(behaviourId);
		resultList.add(((Double) currentBranchProbability).toString());

		// Return the result:
		return resultList;
	}

	/**
	 * Sets the branch probability of the given branch transition according to
	 * the current sensitivity analysis step.
	 * 
	 * @param transition
	 *            the branch transition
	 */
	void setBranchProbability(final BranchTransition transition) {

		// Determine the current branch probability:
		if (values == null) {
			currentBranchProbability = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentBranchProbability = values.get(getCurrentStepNumber() - 1);
		}

		// Set the branch probability:
		transition.setBranchProbability(currentBranchProbability);
	}
}

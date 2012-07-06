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
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Provides sensitivity support to alter the branch probability of a probabilistic usage branch
 * transition.
 * 
 * @author brosch
 * 
 */
public class UsageBranchSensitivity extends MarkovSensitivity {

    /**
     * The base value.
     */
    private double baseValue;

    /**
     * The ID of the involved branch behaviour.
     */
    private String behaviourId;

    /**
     * The ID of the usage branch to alter.
     */
    private String branchId;

    /**
     * The affected probabilistic branch transition;
     */
    private BranchTransition transition = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param branchId
     *            the id of the usage branch to alter
     * @param behaviourId
     *            the id of the involved branch behaviour
     * @param variation
     *            the parameter variation
     */
    public UsageBranchSensitivity(final String name, final String branchId, final String behaviourId,
            final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);

        // Further initialization:
        this.branchId = branchId;
        this.behaviourId = behaviourId;
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Check validity:
        if (transition == null) {
            return false;
        }

        // Set the branch probability:
        transition.setBranchProbability(calculator.calculateCurrentDoubleValue(getDoubleVariation(),
                getCurrentStepNumber(), baseValue));

        // Everything ok:
        return true;
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {

        // Retrieve all BranchTransitions in the PCM Repository:
        if (getModel().getUsageModel() == null) {
            // No usage model found!
            logger.error("No PCM UsageModel found.");
            return;
        }

        // Search for the relevant branch:
        Branch branch = null;
        EList<EObject> branches = helper.getElements(getModel().getUsageModel(), UsagemodelFactory.eINSTANCE
                .createBranch().eClass());
        for (EObject object : branches) {
            if (((Branch) object).getId().equals(branchId)) {
                branch = (Branch) object;
                break;
            }
        }
        if (branch == null) {
            logger.error("No Branch with ID \"" + branchId + "\" found.");
            return;
        }

        // Search for the relevant branch transition:
        for (BranchTransition branchTransition : branch.getBranchTransitions_Branch()) {
            if (branchTransition.getBranchedBehaviour_BranchTransition().getId().equals(behaviourId)) {
                transition = branchTransition;
                baseValue = branchTransition.getBranchProbability();
                return;
            }
        }
        if (transition == null) {
            logger.error("No BranchTransition with associated behaviour ID \"" + behaviourId + "\" found.");
        }
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
        resultList.add(transition.getBranch_BranchTransition().getEntityName());
        resultList.add(branchId);
        resultList.add(transition.getBranchedBehaviour_BranchTransition().getEntityName());
        resultList.add(behaviourId);
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

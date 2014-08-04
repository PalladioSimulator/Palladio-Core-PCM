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
 * Provides sensitivity support to alter the branch probability of a probabilistic branch
 * transition.
 * 
 * @author brosch
 * 
 */
public class ProbabilisticBranchSensitivity extends MarkovSensitivity {

    /**
     * The base value.
     */
    private double baseValue;

    /**
     * The affected probabilistic branch transition;
     */
    private ProbabilisticBranchTransition transition = null;

    /**
     * The ID of the branch transition to alter.
     */
    private String transitionId;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param branchTransitionId
     *            the id of the branch transition to alter
     * @param variation
     *            the parameter variation
     */
    public ProbabilisticBranchSensitivity(final String name, final String branchTransitionId,
            final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);

        // Further initialization:
        this.transitionId = branchTransitionId;
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
        List<Repository> repositories = getModel().getRepositories();
        if (repositories.size() == 0) {
            // No repository found!
            LOGGER.error("No PCM Repositories found.");
            return;
        }

        // Search for the relevant branch transition:
        for (Repository repository : repositories) {
            EList<EObject> branchTransitions = helper.getElements(repository, SeffFactory.eINSTANCE
                    .createProbabilisticBranchTransition().eClass());
            for (EObject object : branchTransitions) {
                if (((ProbabilisticBranchTransition) object).getId().equals(transitionId)) {
                    transition = (ProbabilisticBranchTransition) object;
                    baseValue = ((ProbabilisticBranchTransition) object).getBranchProbability();
                    return;
                }
            }
        }
        if (transition == null) {
            LOGGER.error("Did not find any ProbabilisticBranchTransition with ID \"" + transitionId + "\"");
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
        resultList.add(transition.getEntityName());
        resultList.add(transitionId);
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

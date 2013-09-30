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
 * This class provides rudimentary support for sensitivity analysis of an internal action failure
 * probability.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class InternalActionSensitivity extends MarkovSensitivity {

    /**
     * The base value of this sensitivity.
     */
    private double baseValue;

    /**
     * The affected internal failure occurrence description.
     */
    private InternalFailureOccurrenceDescription description = null;

    /**
     * The ID of the failure type.
     */
    private String failureTypeId;

    /**
     * The ID of the internal action to alter.
     */
    private String internalActionId;

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
     */
    public InternalActionSensitivity(final String name, final String internalActionId, final String failureTypeId,
            final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);

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

        // Check validity:
        if (description == null) {
            return false;
        }

        // Set the failure probability:
        description.setFailureProbability(calculator.calculateCurrentDoubleValue(getDoubleVariation(),
                getCurrentStepNumber(), baseValue));

        // Everything ok:
        return true;
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {

        // Retrieve all FailureOccurrenceDescriptions in the PCM Repository:
        List<Repository> repositories = getModel().getRepositories();
        if (repositories.size() == 0) {
            // No repository found!
            logger.error("No PCM Repositories found.");
            return;
        }

        // Search for the relevant internal action:
        InternalAction internalAction = null;
        for (Repository repository : repositories) {
            EList<EObject> internalActions = helper.getElements(repository, SeffFactory.eINSTANCE
                    .createInternalAction().eClass());
            for (EObject action : internalActions) {
                if (((InternalAction) action).getId().equals(internalActionId)) {
                    internalAction = (InternalAction) action;
                    break;
                }
            }
            if (internalAction != null) {
                break;
            }
        }
        if (internalAction == null) {
            // No corresponding internal action found!
            logger.error("Did not find any InternalAction with ID \"" + internalActionId + "\"");
            return;
        }

        // Search for the relevant failure occurrence description:
        for (InternalFailureOccurrenceDescription occurrenceDescription : internalAction
                .getInternalFailureOccurrenceDescriptions__InternalAction()) {
            if (occurrenceDescription.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription().getId()
                    .equals(failureTypeId)) {
                description = occurrenceDescription;
                baseValue = occurrenceDescription.getFailureProbability();
            }
        }
        if (description == null) {
            logger.error("Did not find a FailureOccurrenceDescription for FailureType with ID \"" + failureTypeId
                    + "\"");
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
        resultList.add(description.getInternalAction__InternalFailureOccurrenceDescription().getEntityName());
        resultList.add(internalActionId);
        resultList.add(description.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
                .getEntityName());
        resultList.add(failureTypeId);
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

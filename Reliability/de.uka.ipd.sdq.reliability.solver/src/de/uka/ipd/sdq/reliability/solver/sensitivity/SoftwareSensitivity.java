package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Provides sensitivity support to alter the failure probabilities of all internal actions within
 * the whole PCM Repository.
 * 
 * @author brosch
 * 
 */
public class SoftwareSensitivity extends MarkovSensitivity {

    /**
     * The list of base values of this sensitivity.
     */
    private List<Double> baseValues = null;

    /**
     * The list of affected internal failure occurrence descriptions.
     */
    private List<InternalFailureOccurrenceDescription> descriptions = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param variation
     *            the parameter variation
     */
    public SoftwareSensitivity(final String name, final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Set the failure probability:
        for (int i = 0; i < descriptions.size(); i++) {
            descriptions.get(i).setFailureProbability(
                    calculator.calculateCurrentDoubleValue(getDoubleVariation(), getCurrentStepNumber(),
                            baseValues.get(i)));
        }

        // Everything ok:
        return true;
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {

        // Declare result lists:
        descriptions = new BasicEList<InternalFailureOccurrenceDescription>();
        baseValues = new ArrayList<Double>();

        // Retrieve all InternalActions in the PCM Repository:
        List<Repository> repositories = getModel().getRepositories();
        if (repositories.size() == 0) {
            // No repository found!
            logger.error("No PCM Repositories found.");
            return;
        }

        // Search for the relevant BasicComponent:
        for (Repository repository : repositories) {
            EList<EObject> internalActions = helper.getElements(repository, SeffFactory.eINSTANCE
                    .createInternalAction().eClass());
            for (EObject object : internalActions) {
                for (InternalFailureOccurrenceDescription description : ((InternalAction) object)
                        .getInternalFailureOccurrenceDescriptions__InternalAction()) {
                    descriptions.add(description);
                    baseValues.add(description.getFailureProbability());
                }
            }
        }
        if (descriptions.size() == 0) {
            logger.error("Did not find any FailureOccurrenceDescriptions " + "in the PCM Repository.");
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
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

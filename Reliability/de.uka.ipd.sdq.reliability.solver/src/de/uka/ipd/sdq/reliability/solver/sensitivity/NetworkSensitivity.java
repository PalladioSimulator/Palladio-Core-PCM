package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Provides sensitivity support to alter the failure probabilities of all communication links within
 * the whole PCM Resource Environment.
 * 
 * @author brosch
 * 
 */
public class NetworkSensitivity extends MarkovSensitivity {

    /**
     * The list of base values.
     */
    private List<Double> baseValues = null;

    /**
     * The list of affected communication link resource specifications.
     */
    private List<CommunicationLinkResourceSpecification> resources = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param variation
     *            the parameter variation
     */
    public NetworkSensitivity(final String name, final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Set the failure probabilities:
        for (int i = 0; i < resources.size(); i++) {
            resources.get(i).setFailureProbability(
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
        resources = new BasicEList<CommunicationLinkResourceSpecification>();
        baseValues = new ArrayList<Double>();

        // Retrieve the PCM Resource Environment:
        ResourceEnvironment resourceEnvironment = getModel().getResourceEnvironment();
        if (resourceEnvironment == null) {
            // No resource environment found!
            LOGGER.error("No PCM ResourceEnvironment found.");
            return;
        }

        // Search for the relevant BasicComponent:
        EList<EObject> commResources = helper.getElements(resourceEnvironment, ResourceenvironmentFactory.eINSTANCE
                .createCommunicationLinkResourceSpecification().eClass());
        for (EObject object : commResources) {
            resources.add((CommunicationLinkResourceSpecification) object);
            baseValues.add(((CommunicationLinkResourceSpecification) object).getFailureProbability());
        }
        if (resources.size() == 0) {
            LOGGER.error("Did not find any CommunicationLinkResourceSpecifications " + "in the PCM ResourceEnvironment");
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
        headings.add("Network Failure Probabilities");
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
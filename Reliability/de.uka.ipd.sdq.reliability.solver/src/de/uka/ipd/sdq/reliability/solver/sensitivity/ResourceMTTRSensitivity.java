package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * This class provides rudimentary support for sensitivity analysis of a hardware resource MTTR
 * value.
 * 
 * @author brosch
 * 
 */
public class ResourceMTTRSensitivity extends MarkovSensitivity {

    /**
     * The base value.
     */
    private double baseValue;

    /**
     * The resource type to alter.
     */
    private String processingResourceTypeId;

    /**
     * The resource container to alter.
     */
    private String resourceContainerId;

    /**
     * The affected processing resource specification.
     */
    private ProcessingResourceSpecification specification = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param resourceContainerId
     *            the resource container to alter
     * @param processingResourceTypeId
     *            the resource type to alter
     * @param variation
     *            the parameter variation
     */
    public ResourceMTTRSensitivity(final String name, final String resourceContainerId,
            final String processingResourceTypeId, final DoubleParameterVariation variation) {

        // Initialize basic variables:
        super(name, variation);

        // Further initializations:
        this.resourceContainerId = resourceContainerId;
        this.processingResourceTypeId = processingResourceTypeId;
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Check validity:
        if (specification == null) {
            return false;
        }

        // Set the failure probability:
        specification.setMTTR(calculator.calculateCurrentDoubleValue(getDoubleVariation(), getCurrentStepNumber(),
                baseValue));

        // Everything ok:
        return true;
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {

        // Retrieve the PCM resource environment:
        if (getModel().getResourceEnvironment() == null) {
            // No resource environment found!
            logger.error("No PCM ResourceEnvironment found.");
            return;
        }

        // Search for the relevant resource container:
        ResourceContainer resourceContainer = null;
        EList<EObject> resourceContainers = helper.getElements(getModel().getResourceEnvironment(),
                ResourceenvironmentFactory.eINSTANCE.createResourceContainer().eClass());
        for (EObject object : resourceContainers) {
            if (((ResourceContainer) object).getId().equals(resourceContainerId)) {
                resourceContainer = (ResourceContainer) object;
                break;
            }
        }
        if (resourceContainer == null) {
            // No corresponding resource container found!
            logger.error("Did not find any ResourceContainer with ID \"" + resourceContainerId + "\"");
            return;
        }

        // Search for the relevant processing resource specification:
        for (ProcessingResourceSpecification resourceSpecification : resourceContainer
                .getActiveResourceSpecifications_ResourceContainer()) {
            if (resourceSpecification.getActiveResourceType_ActiveResourceSpecification().getId()
                    .equals(processingResourceTypeId)) {
                specification = resourceSpecification;
                return;
            }
        }
        if (specification == null) {
            logger.error("Did not find any ProcessingResourceSpecification with ID \"" + processingResourceTypeId
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
        headings.add("Resource Container Name");
        headings.add("Resource Container ID");
        headings.add("Resource Type Name");
        headings.add("Resourcce Type ID");
        headings.add("Mean Time To Repair");
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
        resultList.add(specification.getResourceContainer_ProcessingResourceSpecification().getEntityName());
        resultList.add(resourceContainerId);
        resultList.add(specification.getActiveResourceType_ActiveResourceSpecification().getEntityName());
        resultList.add(processingResourceTypeId);
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

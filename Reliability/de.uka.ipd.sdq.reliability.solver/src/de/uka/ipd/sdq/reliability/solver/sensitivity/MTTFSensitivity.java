package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Alters all MTTF values of hardware resources in the model.
 * 
 * @author brosch
 * 
 */
public class MTTFSensitivity extends MarkovSensitivity {

    /**
     * The list of base values.
     */
    List<Double> baseValues = null;

    /**
     * The list of affected processing resource specifications.
     */
    List<ProcessingResourceSpecification> specifications = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param variation
     *            the parameter variation
     */
    public MTTFSensitivity(final String name, final DoubleParameterVariation variation) {

        // Initialize basic variables:
        super(name, variation);
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Iterate through all specifications:
        for (int i = 0; i < specifications.size(); i++) {
            // Set the failure probability:
            specifications.get(i).setMTTF(
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

        // Declare result variables:
        specifications = new BasicEList<ProcessingResourceSpecification>();
        baseValues = new ArrayList<Double>();

        // Retrieve the PCM resource environment:
        if (getModel().getResourceEnvironment() == null) {
            // No resource environment found!
            LOGGER.error("No PCM ResourceEnvironment found.");
            return;
        }

        // Retrieve all resource specifications in all containers:
        ResourceContainer resourceContainer = null;
        EList<EObject> resourceContainers = helper.getElements(getModel().getResourceEnvironment(),
                ResourceenvironmentFactory.eINSTANCE.createResourceContainer().eClass());
        for (EObject object : resourceContainers) {
            resourceContainer = (ResourceContainer) object;
            for (ProcessingResourceSpecification specification : resourceContainer
                    .getActiveResourceSpecifications_ResourceContainer()) {
                specifications.add(specification);
                baseValues.add(specification.getMTTF());
            }
        }
        if (specifications.size() == 0) {
            LOGGER.error("Did not find any ProcessingResourceSpecifications " + "in the PCM ResourceEnvironment");
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
        headings.add("Mean Time To Failure");
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
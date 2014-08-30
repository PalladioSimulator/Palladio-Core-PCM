/**
 * 
 */
package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;
import de.uka.ipd.sdq.sensitivity.StringParameterSequence;
import de.uka.ipd.sdq.sensitivity.VariableUsageType;
import de.uka.ipd.sdq.stoex.AbstractNamedReference;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.VariableReference;

/**
 * This class provides rudimentary support for sensitivity analysis of a system call variable usage.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class VariableUsageSensitivity extends MarkovSensitivity {

    /**
     * Property of the parameter to alter.
     */
    private VariableCharacterisationType characterisationType;

    /**
     * ID of the EntryLevelSystemCall or BasicComponent to alter.
     */
    private String elementId;

    /**
     * Name of the EntryLevelSystemCall or BasicComponent to alter.
     */
    private String elementName;

    /**
     * Qualified name of the modelled PCM parameter.
     */
    private String parameterName;

    /**
     * Type of parameter usage (input parameter for EntryLevelSystemCall or component parameter).
     */
    private VariableUsageType parameterType;

    /**
     * The affected random variable.
     */
    private PCMRandomVariable variable = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param elementId
     *            the ID of the EntryLevelSystemCall or BasicComponent to alter
     * @param parameterName
     *            the qualified name of the modelled PCM parameter
     * @param characterisationType
     *            the property of the parameter to alter
     * @param parameterType
     *            the type of parameter usage (input parameter for EntryLevelSystemCall or component
     *            parameter)
     * @param sequence
     *            the sequence of parameter value specifications
     */
    public VariableUsageSensitivity(final String name, final String elementId, final String parameterName,
            final VariableCharacterisationType characterisationType, VariableUsageType parameterType,
            final StringParameterSequence sequence) {

        // Initialize basic variables:
        super(name, sequence);

        // Further initializations:
        this.elementId = elementId;
        this.parameterName = parameterName;
        this.characterisationType = characterisationType;
        this.parameterType = parameterType;
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Check validity:
        if (variable == null) {
            return false;
        }

        // Set the failure probability:
        variable.setSpecification(calculator.calculateCurrentStringValue(getStringSequence(), getCurrentStepNumber()));

        // Everything ok:
        return true;
    }

    /**
     * Checks if a given parameter name is compliant with a given named reference.
     * 
     * @param reference
     *            the named reference
     * @param paramName
     *            the parameter name
     * @return TRUE if the parameter is compliant with the named reference
     */
    private boolean checkParameterName(final AbstractNamedReference reference, final String[] paramName, int index) {
        if (!reference.getReferenceName().equals(paramName[index])) {
            return false;
        }
        if (reference instanceof VariableReference) {
            return (paramName.length == index + 1);
        }
        return checkParameterName(((NamespaceReference) reference).getInnerReference_NamespaceReference(), paramName,
                index + 1);
    }

    /**
     * Model information extraction for BasicComponent configuration parameters.
     */
    private void extractComponentParameter() {

        // Retrieve all FailureOccurrenceDescriptions in the PCM Repository:
        List<Repository> repositories = getModel().getRepositories();
        if (repositories.size() == 0) {
            // No repository found!
            LOGGER.error("No PCM Repositories found.");
            return;
        }

        // Search for the relevant internal action:
        BasicComponent component = null;
        for (Repository repository : repositories) {
            EList<EObject> components = helper.getElements(repository, RepositoryFactory.eINSTANCE
                    .createBasicComponent().eClass());
            for (EObject object : components) {
                if (((BasicComponent) object).getId().equals(elementId)) {
                    component = (BasicComponent) object;
                    break;
                }
            }
            if (component != null) {
                break;
            }
        }
        if (component == null) {
            // No corresponding component found!
            LOGGER.error("No BasicComponent with ID \"" + elementId + "\" found.");
            return;
        }
        elementName = component.getEntityName();

        // Search for the relevant parameter specification:
        extractVariable(component.getComponentParameterUsage_ImplementationComponentType());
    }

    /**
     * Extracts the relevant sensitivity information from the given model.
     */
    protected void extractSensitivityInformation() {

        // Distinguish between input parameters for EntryLevelSystemCalls and
        // BasicComponent configuration parameters:
        switch (parameterType) {
        case SYSTEM_CALL_INPUT:
            extractSystemCallInput();
            return;
        case COMPONENT_CONFIGURATION:
            extractComponentParameter();
            return;
        }
    }

    /**
     * Model information extraction for EntryLevelSystemCall input parameters.
     */
    private void extractSystemCallInput() {

        // Retrieve the PCM usage model:
        if (getModel().getUsageModel() == null) {
            // No usage model found!
            LOGGER.error("No PCM UsageModel found.");
            return;
        }

        // Search for the relevant system call:
        EntryLevelSystemCall systemCall = null;
        EList<EObject> systemCalls = helper.getElements(getModel().getUsageModel(), UsagemodelFactory.eINSTANCE
                .createEntryLevelSystemCall().eClass());
        for (EObject object : systemCalls) {
            if (((EntryLevelSystemCall) object).getId().equals(elementId)) {
                systemCall = (EntryLevelSystemCall) object;
                break;
            }
        }
        if (systemCall == null) {
            // No corresponding system call found!
            LOGGER.error("No EntryLevelSystemCall with ID \"" + elementId + "\" found.");
            return;
        }
        elementName = systemCall.getEntityName();

        // Search for the relevant parameter specification:
        extractVariable(systemCall.getInputParameterUsages_EntryLevelSystemCall());
    }

    /**
     * Extracts the relevant random variable from a list of variable usages.
     * 
     * @param parameterUsages
     *            the variable usages
     */
    private void extractVariable(final EList<VariableUsage> parameterUsages) {
        for (VariableUsage usage : parameterUsages) {
            if (checkParameterName(usage.getNamedReference__VariableUsage(), parameterName.split("\\."), 0)) {
                for (VariableCharacterisation characterisation : usage.getVariableCharacterisation_VariableUsage()) {
                    if (characterisation.getType().equals(characterisationType)) {
                        variable = characterisation.getSpecification_VariableCharacterisation();
                        return;
                    }
                }
            }
        }
        if (variable == null) {
            LOGGER.error("Did not find any PCMRandomVariable for parameter \"" + parameterName + "."
                    + characterisationType.getName());
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

        // Determine element Name and ID headings:
        String elementNameHeader = null;
        String elementIDHeader = null;
        switch (parameterType) {
        case SYSTEM_CALL_INPUT:
            elementNameHeader = "System Call Name";
            elementIDHeader = "System Call ID";
            break;
        case COMPONENT_CONFIGURATION:
            elementNameHeader = "Component Name";
            elementIDHeader = "Component ID";
            break;
        }

        // Create the headings:
        ArrayList<String> headings = new ArrayList<String>();
        headings.add(elementNameHeader);
        headings.add(elementIDHeader);
        headings.add("Parameter Name");
        headings.add("Parameter Characterisation");
        headings.add("Parameter Specification");
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
        resultList.add(elementName);
        resultList.add(elementId);
        resultList.add(parameterName);
        resultList.add(characterisationType.getName());
        resultList.add(calculator.getCurrentLogEntry(getStringSequence(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

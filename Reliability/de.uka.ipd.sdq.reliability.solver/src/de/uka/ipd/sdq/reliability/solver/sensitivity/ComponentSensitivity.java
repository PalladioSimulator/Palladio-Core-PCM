package de.uka.ipd.sdq.reliability.solver.sensitivity;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.repository.RepositoryFactory;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour;
import de.uka.ipd.sdq.sensitivity.DoubleParameterVariation;

/**
 * Provides sensitivity support to alter the failure probabilities of all internal actions within
 * one component.
 * 
 * @author brosch
 * 
 */
public class ComponentSensitivity extends MarkovSensitivity {

    /**
     * The list of base values of this sensitivity.
     */
    private List<Double> baseValues = null;

    /**
     * The ID of the component to alter.
     */
    private String componentId = null;

    /**
     * The name of the component to alter.
     */
    private String componentName = null;

    /**
     * The list of affected internal failure occurrence descriptions.
     */
    private List<InternalFailureOccurrenceDescription> descriptions = null;

    /**
     * The constructor.
     * 
     * @param name
     *            the name of the sensitivity analysis
     * @param componentId
     *            the ID of the component to alter
     * @param variation
     *            the parameter variation
     */
    public ComponentSensitivity(final String name, final String componentId, final DoubleParameterVariation variation) {

        // Initialize base variables:
        super(name, variation);

        // Further initialization:
        this.componentId = componentId;
    }

    /**
     * Alters the model according to the next sensitivity analysis step.
     * 
     * @return indicates if the model could be successfully altered
     */
    protected boolean alterModel() {

        // Determine the current failure probability:
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

        // Declare the result variables:
        descriptions = new BasicEList<InternalFailureOccurrenceDescription>();
        baseValues = new ArrayList<Double>();

        // Retrieve the involved internal actions:
        List<InternalAction> internalActions = getInternalActions();
        if (internalActions == null) {
            LOGGER.error("Did not find any InternalActions for BasicComponent \"" + componentName + "\" <ID="
                    + componentId + ">");
            return;
        }

        // Build the list of internal failure occurrence descriptions:
        for (InternalAction action : internalActions) {
            for (InternalFailureOccurrenceDescription description : action
                    .getInternalFailureOccurrenceDescriptions__InternalAction()) {
                descriptions.add(description);
                baseValues.add(description.getFailureProbability());
            }
        }
    }

    /**
     * Retrieves the relevant basic component.
     * 
     * @return the basic component
     */
    private BasicComponent getBasicComponent() {

        // Retrieve all BasicComponents in the PCM Repository:
        List<Repository> repositories = getModel().getRepositories();
        if (repositories.size() == 0) {
            // No repository found!
            LOGGER.error("No PCM Repositories found.");
            return null;
        }

        // Search for the relevant BasicComponent:
        for (Repository repository : repositories) {
            EList<EObject> components = helper.getElements(repository, RepositoryFactory.eINSTANCE
                    .createBasicComponent().eClass());
            for (EObject object : components) {
                if (((BasicComponent) object).getId().equals(componentId)) {
                    componentName = ((BasicComponent) object).getEntityName();
                    return (BasicComponent) object;
                }
            }
        }

        // Nothing found:
        LOGGER.error("BasicComponent \"" + componentName + "\" <ID=" + componentId + "> not found.");
        return null;
    }

    /**
     * Retrieves the list of involved internal actions.
     * 
     * @return the list of internal actions
     */
    private List<InternalAction> getInternalActions() {

        // Retrieve the relevant BasicComponent:
        BasicComponent component = getBasicComponent();
        if (component == null) {
            return null;
        }

        // Build the list of internal actions over all SEFFs of the component:
        List<InternalAction> resultList = new BasicEList<InternalAction>();
        for (ServiceEffectSpecification specifiction : component.getServiceEffectSpecifications__BasicComponent()) {
            if (specifiction instanceof ResourceDemandingSEFF) {
                resultList.addAll(getInternalActionsForBehaviour((ResourceDemandingSEFF) specifiction));
            }
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the list of internal actions within the given behaviour.
     * 
     * @param behaviour
     *            the behaviour
     * @return the list of contained internal actions
     */
    private List<InternalAction> getInternalActionsForBehaviour(final ResourceDemandingBehaviour behaviour) {

        // Build the list of internal actions over all steps in the behaviour:
        List<InternalAction> resultList = new BasicEList<InternalAction>();
        for (AbstractAction action : behaviour.getSteps_Behaviour()) {
            if (action instanceof InternalAction) {
                resultList.add((InternalAction) action);
            } else if (action instanceof AbstractLoopAction) {
                resultList
                        .addAll(getInternalActionsForBehaviour(((AbstractLoopAction) action).getBodyBehaviour_Loop()));
            } else if (action instanceof BranchAction) {
                for (AbstractBranchTransition transition : ((BranchAction) action).getBranches_Branch()) {
                    resultList.addAll(getInternalActionsForBehaviour(transition.getBranchBehaviour_BranchTransition()));
                }
            } else if (action instanceof RecoveryAction) {
                for (RecoveryActionBehaviour recoveryBehaviour : ((RecoveryAction) action)
                        .getRecoveryActionBehaviours__RecoveryAction()) {
                    resultList.addAll(getInternalActionsForBehaviour(recoveryBehaviour));
                }
            } else if (action instanceof ForkAction) {
                if (((ForkAction) action).getAsynchronousForkedBehaviours_ForkAction() != null) {
                    for (ForkedBehaviour forkedBehaviour : ((ForkAction) action)
                            .getAsynchronousForkedBehaviours_ForkAction()) {
                        resultList.addAll(getInternalActionsForBehaviour(forkedBehaviour));
                    }
                }
                if (((ForkAction) action).getSynchronisingBehaviours_ForkAction() != null) {
                    for (ForkedBehaviour forkedBehaviour : ((ForkAction) action)
                            .getSynchronisingBehaviours_ForkAction()
                            .getSynchronousForkedBehaviours_SynchronisationPoint()) {
                        resultList.addAll(getInternalActionsForBehaviour(forkedBehaviour));
                    }
                }
            }
        }

        // Return the result:
        return resultList;
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
        headings.add("Component Name");
        headings.add("Component ID");
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
        resultList.add(componentName);
        resultList.add(componentId);
        resultList.add(calculator.getCurrentLogEntry(getDoubleVariation(), getCurrentStepNumber()));

        // Return the result:
        return resultList;
    }
}

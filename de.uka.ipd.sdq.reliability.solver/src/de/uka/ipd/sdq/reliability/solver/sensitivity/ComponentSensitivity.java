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
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour;

/**
 * Provides sensitivity support to alter the failure probabilities of all
 * internal actions within one component.
 * 
 * @author brosch
 * 
 */
public class ComponentSensitivity extends MarkovSensitivity {

	/**
	 * The ID of the component to alter.
	 */
	private String componentId;

	/**
	 * The name of the component to alter.
	 */
	private String componentName = null;

	/**
	 * Captures the current failure probability value.
	 */
	private double currentFailureProbability;

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param componentId
	 *            the ID of the component to alter
	 * @param firstValue
	 *            first value of sensitivity analysis
	 * @param lastValue
	 *            last value of sensitivity analysis
	 * @param numberOfSteps
	 *            number of steps of the analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ComponentSensitivity(final String name, final String componentId,
			final double firstValue, final double lastValue,
			final int numberOfSteps, final String resultLogFile) {

		// Initialize base variables:
		super(name, firstValue, lastValue, numberOfSteps, resultLogFile);

		// Further initialization:
		this.componentId = componentId;
	}

	/**
	 * The constructor.
	 * 
	 * @param name
	 *            the name of the sensitivity analysis
	 * @param componentId
	 *            the ID of the component to alter
	 * @param behaviourId
	 *            the id of the involved branch behaviour
	 * @param values
	 *            the values for the sensitivity analysis
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public ComponentSensitivity(final String name, final String componentId,
			final List<Double> values, final String resultLogFile) {

		// Initialize base variables:
		super(name, values, resultLogFile);

		// Further initialization:
		this.componentId = componentId;
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
			return null;
		}

		// Search for the relevant BasicComponent:
		for (Repository repository : repositories) {
			EList<EObject> components = helper
					.getElements(repository, RepositoryFactory.eINSTANCE
							.createBasicComponent().eClass());
			for (EObject object : components) {
				if (((BasicComponent) object).getId().equals(componentId)) {
					componentName = ((BasicComponent) object).getEntityName();
					return (BasicComponent) object;
				}
			}
		}

		// Nothing found:
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
		for (ServiceEffectSpecification specifiction : component
				.getServiceEffectSpecifications__BasicComponent()) {
			if (specifiction instanceof ResourceDemandingSEFF) {
				resultList
						.addAll(getInternalActionsForBehaviour((ResourceDemandingSEFF) specifiction));
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
	private List<InternalAction> getInternalActionsForBehaviour(
			final ResourceDemandingBehaviour behaviour) {

		// Build the list of internal actions over all steps in the behaviour:
		List<InternalAction> resultList = new BasicEList<InternalAction>();
		for (AbstractAction action : behaviour.getSteps_Behaviour()) {
			if (action instanceof InternalAction) {
				resultList.add((InternalAction) action);
			} else if (action instanceof AbstractLoopAction) {
				resultList
						.addAll(getInternalActionsForBehaviour(((AbstractLoopAction) action)
								.getBodyBehaviour_Loop()));
			} else if (action instanceof BranchAction) {
				for (AbstractBranchTransition transition : ((BranchAction) action)
						.getBranches_Branch()) {
					resultList.addAll(getInternalActionsForBehaviour(transition
							.getBranchBehaviour_BranchTransition()));
				}
			} else if (action instanceof RecoveryBlockAction) {
				for (RecoveryBlockAlternativeBehaviour recoveryBehaviour : ((RecoveryBlockAction) action)
						.getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction()) {
					resultList
							.addAll(getInternalActionsForBehaviour(recoveryBehaviour));
				}
			} else if (action instanceof ForkAction) {
				if (((ForkAction) action)
						.getAsynchronousForkedBehaviours_ForkAction() != null) {
					for (ForkedBehaviour forkedBehaviour : ((ForkAction) action)
							.getAsynchronousForkedBehaviours_ForkAction()) {
						resultList
								.addAll(getInternalActionsForBehaviour(forkedBehaviour));
					}
				}
				if (((ForkAction) action)
						.getSynchronisingBehaviours_ForkAction() != null) {
					for (ForkedBehaviour forkedBehaviour : ((ForkAction) action)
							.getSynchronisingBehaviours_ForkAction()
							.getSynchronousForkedBehaviours_SynchronisationPoint()) {
						resultList
								.addAll(getInternalActionsForBehaviour(forkedBehaviour));
					}
				}
			}
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Sets the failure probability of the given internal actions according to
	 * the current sensitivity analysis step.
	 * 
	 * @param internalActions
	 *            the internal actions
	 */
	private void setFailureProbability(
			final List<InternalAction> internalActions) {

		// Determine the current failure probability:
		if (values == null) {
			currentFailureProbability = firstValue
					+ ((lastValue - firstValue) / (numberOfSteps - 1))
					* (getCurrentStepNumber() - 1);
		} else {
			currentFailureProbability = values.get(getCurrentStepNumber() - 1);
		}

		// Set the failure probability:
		for (InternalAction action : internalActions) {
			for (InternalFailureOccurrenceDescription description : action
					.getInternalFailureOccurrenceDescriptions__InternalAction()) {
				description.setFailureProbability(currentFailureProbability);
			}
		}
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant parameter that shall be altered:
		List<InternalAction> internalActions = getInternalActions();
		if (internalActions == null) {
			return false;
		}

		// Alter the parameter:
		setFailureProbability(internalActions);

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
		resultList.add(((Double) currentFailureProbability).toString());

		// Return the result:
		return resultList;
	}
}

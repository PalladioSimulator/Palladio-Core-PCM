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
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelFactory;

/**
 * This class provides rudimentary support for sensitivity analysis of a system
 * call variable usage.
 * 
 * Further refactorings required.
 * 
 * @author brosch
 * 
 */
public class SystemCallSensitivity extends MarkovSensitivity {

	/**
	 * The current parameter specification.
	 */
	private String currentSpecification;

	/**
	 * The property of the input parameter to alter.
	 */
	private String parameterCharacterisation;

	/**
	 * The name of the input parameter to alter.
	 */
	private String parameterName;

	/**
	 * The specification of the input parameter to alter.
	 */
	private List<String> parameterSpecifications;

	/**
	 * The ID of the EntryLevelSystemCall to alter.
	 */
	private String systemCallId;

	/**
	 * The name of the EntryLevelSystemCall to alter.
	 */
	private String systemCallName;

	/**
	 * The constructor.
	 * 
	 * @param systemCallId
	 *            the ID of the EntryLevelSystemCall to alter
	 * @param parameterName
	 *            the name of the EntryLevelSystemCall to alter
	 * @param parameterCharacterisation
	 *            the property of the input parameter to alter
	 * @param parameterSpecifications
	 *            the Specification of the input parameter to alter
	 * @param resultLogFile
	 *            path where to log sensitivity analysis results
	 */
	public SystemCallSensitivity(final String name, final String systemCallId,
			final String parameterName, final String parameterCharacterisation,
			final List<String> parameterSpecifications,
			final String resultLogFile) {

		// Initialize basic variables:
		super(name, new ArrayList<Double>(), resultLogFile);

		// Further initializations:
		this.systemCallId = systemCallId;
		this.parameterName = parameterName;
		this.parameterCharacterisation = parameterCharacterisation;
		this.parameterSpecifications = parameterSpecifications;
		this.numberOfSteps = parameterSpecifications.size();
	}

	/**
	 * Retrieves the relevant random variable to be altered.
	 * 
	 * @return the random variable
	 */
	private PCMRandomVariable getRandomVariable() {

		// Retrieve the PCM usage model:
		if (getModel().getUsageModel() == null) {
			// No usage model found!
			return null;
		}

		// Search for the relevant system call:
		EntryLevelSystemCall systemCall = null;
		EList<EObject> systemCalls = helper.getElements(getModel()
				.getUsageModel(), UsagemodelFactory.eINSTANCE
				.createEntryLevelSystemCall().eClass());
		for (EObject object : systemCalls) {
			if (((EntryLevelSystemCall) object).getId().equals(systemCallId)) {
				systemCall = (EntryLevelSystemCall) object;
				break;
			}
		}
		if (systemCall == null) {
			// No corresponding system call found!
			return null;
		}
		systemCallName = systemCall.getEntityName();

		// Search for the relevant parameter specification:
		PCMRandomVariable specification = null;
		for (VariableUsage usage : systemCall
				.getInputParameterUsages_EntryLevelSystemCall()) {
			if (usage.getNamedReference__VariableUsage().getReferenceName()
					.equals(parameterName)) {
				// TODO: also enable fully qualified references
				// (with namespaces)
				for (VariableCharacterisation characterisation : usage
						.getVariableCharacterisation_VariableUsage()) {
					if (characterisation.getType().getLiteral().equals(
							parameterCharacterisation)) {
						specification = characterisation
								.getSpecification_VariableCharacterisation();
						break;
					}
				}
				if (specification != null) {
					break;
				}
			}
		}
		return specification;
	}

	/**
	 * Sets the current specification.
	 * 
	 * @param variable
	 *            the random variable to alter.
	 */
	private void setSpecification(final PCMRandomVariable variable) {

		// Determine the current failure probability:
		currentSpecification = parameterSpecifications
				.get(getCurrentStepNumber() - 1);

		// Set the failure probability:
		variable.setSpecification(currentSpecification);
	}

	/**
	 * Alters the model according to the next sensitivity analysis step.
	 * 
	 * @return indicates if the model could be successfully altered
	 */
	protected boolean alterModel() {

		// Retrieve the relevant random variable that shall be altered:
		PCMRandomVariable variable = getRandomVariable();
		if (variable == null) {
			return false;
		}

		// Alter the parameter:
		setSpecification(variable);

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
		headings.add("System Call Name");
		headings.add("System Call ID");
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
		resultList.add(systemCallName);
		resultList.add(systemCallId);
		resultList.add(parameterName);
		resultList.add(parameterCharacterisation);
		resultList.add(currentSpecification);

		// Return the result:
		return resultList;
	}
}

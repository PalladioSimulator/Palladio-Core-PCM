/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CoreFactoryImpl extends EFactoryImpl implements CoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CoreFactory init() {
		try {
			CoreFactory theCoreFactory = (CoreFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Capra/Core/1.0"); 
			if (theCoreFactory != null) {
				return theCoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CorePackage.COMMUNICATION_IDENTIFIER: return createCommunicationIdentifier();
			case CorePackage.DEMAND_ACTION: return createDemandAction();
			case CorePackage.DEMAND_IDENTIFIER: return createDemandIdentifier();
			case CorePackage.RESOURCE_USAGE: return createResourceUsage();
			case CorePackage.SUCCESSFUL_TERMINATION: return createSuccessfulTermination();
			case CorePackage.PROBABILISTIC_PREFIX: return createProbabilisticPrefix();
			case CorePackage.INTERNAL_SELECTOR: return createInternalSelector();
			case CorePackage.CHOICE: return createChoice();
			case CorePackage.EXTERNAL_SELECTOR: return createExternalSelector();
			case CorePackage.INPUT_EVENT_ACTION: return createInputEventAction();
			case CorePackage.OUTPUT_EVENT_ACTION: return createOutputEventAction();
			case CorePackage.COMMUNICATION_EVENT_ACTION: return createCommunicationEventAction();
			case CorePackage.BOUNDED_LOOP: return createBoundedLoop();
			case CorePackage.PARALLEL_COMPOSITION: return createParallelComposition();
			case CorePackage.RESTRICTION: return createRestriction();
			case CorePackage.RENAMING: return createRenaming();
			case CorePackage.MAPPING: return createMapping();
			case CorePackage.SILENT_IDENTIFIER: return createSilentIdentifier();
			case CorePackage.PROCESS_VARIABLE: return createProcessVariable();
			case CorePackage.PROCESS_VARIABLE_USAGE: return createProcessVariableUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationIdentifier createCommunicationIdentifier() {
		CommunicationIdentifierImpl communicationIdentifier = new CommunicationIdentifierImpl();
		return communicationIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandAction createDemandAction() {
		DemandActionImpl demandAction = new DemandActionImpl();
		return demandAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandIdentifier createDemandIdentifier() {
		DemandIdentifierImpl demandIdentifier = new DemandIdentifierImpl();
		return demandIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsage createResourceUsage() {
		ResourceUsageImpl resourceUsage = new ResourceUsageImpl();
		return resourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SuccessfulTermination createSuccessfulTermination() {
		SuccessfulTerminationImpl successfulTermination = new SuccessfulTerminationImpl();
		return successfulTermination;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilisticPrefix createProbabilisticPrefix() {
		ProbabilisticPrefixImpl probabilisticPrefix = new ProbabilisticPrefixImpl();
		return probabilisticPrefix;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalSelector createInternalSelector() {
		InternalSelectorImpl internalSelector = new InternalSelectorImpl();
		return internalSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Choice createChoice() {
		ChoiceImpl choice = new ChoiceImpl();
		return choice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalSelector createExternalSelector() {
		ExternalSelectorImpl externalSelector = new ExternalSelectorImpl();
		return externalSelector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputEventAction createInputEventAction() {
		InputEventActionImpl inputEventAction = new InputEventActionImpl();
		return inputEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OutputEventAction createOutputEventAction() {
		OutputEventActionImpl outputEventAction = new OutputEventActionImpl();
		return outputEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommunicationEventAction createCommunicationEventAction() {
		CommunicationEventActionImpl communicationEventAction = new CommunicationEventActionImpl();
		return communicationEventAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BoundedLoop createBoundedLoop() {
		BoundedLoopImpl boundedLoop = new BoundedLoopImpl();
		return boundedLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelComposition createParallelComposition() {
		ParallelCompositionImpl parallelComposition = new ParallelCompositionImpl();
		return parallelComposition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Restriction createRestriction() {
		RestrictionImpl restriction = new RestrictionImpl();
		return restriction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Renaming createRenaming() {
		RenamingImpl renaming = new RenamingImpl();
		return renaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Mapping createMapping() {
		MappingImpl mapping = new MappingImpl();
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SilentIdentifier createSilentIdentifier() {
		SilentIdentifierImpl silentIdentifier = new SilentIdentifierImpl();
		return silentIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariable createProcessVariable() {
		ProcessVariableImpl processVariable = new ProcessVariableImpl();
		return processVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessVariableUsage createProcessVariableUsage() {
		ProcessVariableUsageImpl processVariableUsage = new ProcessVariableUsageImpl();
		return processVariableUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CorePackage getCorePackage() {
		return (CorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CorePackage getPackage() {
		return CorePackage.eINSTANCE;
	}

} //CoreFactoryImpl

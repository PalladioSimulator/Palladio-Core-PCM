/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.impl;

import de.uka.ipd.sdq.pcm.designdecision.*;

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
public class designdecisionFactoryImpl extends EFactoryImpl implements designdecisionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static designdecisionFactory init() {
		try {
			designdecisionFactory thedesigndecisionFactory = (designdecisionFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/DesignDecision/1.0"); 
			if (thedesigndecisionFactory != null) {
				return thedesigndecisionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new designdecisionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionFactoryImpl() {
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
			case designdecisionPackage.EQUIVALENT_COMPONENTS: return createEquivalentComponents();
			case designdecisionPackage.AVAILABLE_SERVERS: return createAvailableServers();
			case designdecisionPackage.COMPONENT_CHOICE: return createComponentChoice();
			case designdecisionPackage.ALLOCATION_CHOICE: return createAllocationChoice();
			case designdecisionPackage.PROCESSING_RATE_CHOICE: return createProcessingRateChoice();
			case designdecisionPackage.PROCESSING_RATE_DECISION: return createProcessingRateDecision();
			case designdecisionPackage.ALLOCATION_DECISION: return createAllocationDecision();
			case designdecisionPackage.ASSEMBLED_COMPONENT_DECISION: return createAssembledComponentDecision();
			case designdecisionPackage.INTEGER_RANGE: return createIntegerRange();
			case designdecisionPackage.DOUBLE_RANGE: return createDoubleRange();
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_CHOICE: return createResourceContainerReplicationChoice();
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DECISION: return createResourceContainerReplicationDecision();
			case designdecisionPackage.GENOTYPE: return createGenotype();
			case designdecisionPackage.PROBLEM: return createProblem();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EquivalentComponents createEquivalentComponents() {
		EquivalentComponentsImpl equivalentComponents = new EquivalentComponentsImpl();
		return equivalentComponents;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailableServers createAvailableServers() {
		AvailableServersImpl availableServers = new AvailableServersImpl();
		return availableServers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentChoice createComponentChoice() {
		ComponentChoiceImpl componentChoice = new ComponentChoiceImpl();
		return componentChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationChoice createAllocationChoice() {
		AllocationChoiceImpl allocationChoice = new AllocationChoiceImpl();
		return allocationChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingRateChoice createProcessingRateChoice() {
		ProcessingRateChoiceImpl processingRateChoice = new ProcessingRateChoiceImpl();
		return processingRateChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingRateDecision createProcessingRateDecision() {
		ProcessingRateDecisionImpl processingRateDecision = new ProcessingRateDecisionImpl();
		return processingRateDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationDecision createAllocationDecision() {
		AllocationDecisionImpl allocationDecision = new AllocationDecisionImpl();
		return allocationDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssembledComponentDecision createAssembledComponentDecision() {
		AssembledComponentDecisionImpl assembledComponentDecision = new AssembledComponentDecisionImpl();
		return assembledComponentDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerRange createIntegerRange() {
		IntegerRangeImpl integerRange = new IntegerRangeImpl();
		return integerRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleRange createDoubleRange() {
		DoubleRangeImpl doubleRange = new DoubleRangeImpl();
		return doubleRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainerReplicationChoice createResourceContainerReplicationChoice() {
		ResourceContainerReplicationChoiceImpl resourceContainerReplicationChoice = new ResourceContainerReplicationChoiceImpl();
		return resourceContainerReplicationChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainerReplicationDecision createResourceContainerReplicationDecision() {
		ResourceContainerReplicationDecisionImpl resourceContainerReplicationDecision = new ResourceContainerReplicationDecisionImpl();
		return resourceContainerReplicationDecision;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Genotype createGenotype() {
		GenotypeImpl genotype = new GenotypeImpl();
		return genotype;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Problem createProblem() {
		ProblemImpl problem = new ProblemImpl();
		return problem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public designdecisionPackage getdesigndecisionPackage() {
		return (designdecisionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static designdecisionPackage getPackage() {
		return designdecisionPackage.eINSTANCE;
	}

} //designdecisionFactoryImpl

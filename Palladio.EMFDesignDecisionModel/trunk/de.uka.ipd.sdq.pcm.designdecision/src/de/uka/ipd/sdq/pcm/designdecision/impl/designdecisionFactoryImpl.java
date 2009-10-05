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
			case designdecisionPackage.ENUMERATION_CHOICE: return createEnumerationChoice();
			case designdecisionPackage.CONTINOUS_RANGE_CHOICE: return createContinousRangeChoice();
			case designdecisionPackage.PROCESSING_RATE_DEGREE: return createProcessingRateDegree();
			case designdecisionPackage.ALLOCATION_DEGREE: return createAllocationDegree();
			case designdecisionPackage.ASSEMBLED_COMPONENT_DEGREE: return createAssembledComponentDegree();
			case designdecisionPackage.DISCRETE_RANGE_CHOICE: return createDiscreteRangeChoice();
			case designdecisionPackage.RESOURCE_CONTAINER_REPLICATION_DEGREE: return createResourceContainerReplicationDegree();
			case designdecisionPackage.PROBLEM: return createProblem();
			case designdecisionPackage.CONNECTOR_CONFIG_DEGREE: return createConnectorConfigDegree();
			case designdecisionPackage.CANDIDATE: return createCandidate();
			case designdecisionPackage.CANDIDATES: return createCandidates();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationChoice createEnumerationChoice() {
		EnumerationChoiceImpl enumerationChoice = new EnumerationChoiceImpl();
		return enumerationChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContinousRangeChoice createContinousRangeChoice() {
		ContinousRangeChoiceImpl continousRangeChoice = new ContinousRangeChoiceImpl();
		return continousRangeChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProcessingRateDegree createProcessingRateDegree() {
		ProcessingRateDegreeImpl processingRateDegree = new ProcessingRateDegreeImpl();
		return processingRateDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationDegree createAllocationDegree() {
		AllocationDegreeImpl allocationDegree = new AllocationDegreeImpl();
		return allocationDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssembledComponentDegree createAssembledComponentDegree() {
		AssembledComponentDegreeImpl assembledComponentDegree = new AssembledComponentDegreeImpl();
		return assembledComponentDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiscreteRangeChoice createDiscreteRangeChoice() {
		DiscreteRangeChoiceImpl discreteRangeChoice = new DiscreteRangeChoiceImpl();
		return discreteRangeChoice;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceContainerReplicationDegree createResourceContainerReplicationDegree() {
		ResourceContainerReplicationDegreeImpl resourceContainerReplicationDegree = new ResourceContainerReplicationDegreeImpl();
		return resourceContainerReplicationDegree;
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
	public ConnectorConfigDegree createConnectorConfigDegree() {
		ConnectorConfigDegreeImpl connectorConfigDegree = new ConnectorConfigDegreeImpl();
		return connectorConfigDegree;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Candidate createCandidate() {
		CandidateImpl candidate = new CandidateImpl();
		return candidate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Candidates createCandidates() {
		CandidatesImpl candidates = new CandidatesImpl();
		return candidates;
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

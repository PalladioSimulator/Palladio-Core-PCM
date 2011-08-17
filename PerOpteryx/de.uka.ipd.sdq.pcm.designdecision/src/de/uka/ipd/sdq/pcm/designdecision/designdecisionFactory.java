/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage
 * @generated
 */
public interface designdecisionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	designdecisionFactory eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.impl.designdecisionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Enumeration Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Choice</em>'.
	 * @generated
	 */
	EnumerationChoice createEnumerationChoice();

	/**
	 * Returns a new object of class '<em>Continous Range Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continous Range Choice</em>'.
	 * @generated
	 */
	ContinousRangeChoice createContinousRangeChoice();

	/**
	 * Returns a new object of class '<em>Continuous Processing Rate Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Continuous Processing Rate Degree</em>'.
	 * @generated
	 */
	ContinuousProcessingRateDegree createContinuousProcessingRateDegree();

	/**
	 * Returns a new object of class '<em>Allocation Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation Degree</em>'.
	 * @generated
	 */
	AllocationDegree createAllocationDegree();

	/**
	 * Returns a new object of class '<em>Assembled Component Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assembled Component Degree</em>'.
	 * @generated
	 */
	AssembledComponentDegree createAssembledComponentDegree();

	/**
	 * Returns a new object of class '<em>Discrete Range Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discrete Range Choice</em>'.
	 * @generated
	 */
	DiscreteRangeChoice createDiscreteRangeChoice();

	/**
	 * Returns a new object of class '<em>Resource Container Replication Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Container Replication Degree</em>'.
	 * @generated
	 */
	ResourceContainerReplicationDegree createResourceContainerReplicationDegree();

	/**
	 * Returns a new object of class '<em>Problem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Problem</em>'.
	 * @generated
	 */
	Problem createProblem();

	/**
	 * Returns a new object of class '<em>Connector Config Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Connector Config Degree</em>'.
	 * @generated
	 */
	ConnectorConfigDegree createConnectorConfigDegree();

	/**
	 * Returns a new object of class '<em>Candidate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Candidate</em>'.
	 * @generated
	 */
	Candidate createCandidate();

	/**
	 * Returns a new object of class '<em>Candidates</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Candidates</em>'.
	 * @generated
	 */
	Candidates createCandidates();

	/**
	 * Returns a new object of class '<em>Feature Group Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Group Degree</em>'.
	 * @generated
	 */
	FeatureGroupDegree createFeatureGroupDegree();

	/**
	 * Returns a new object of class '<em>Feature Subset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Subset</em>'.
	 * @generated
	 */
	FeatureSubset createFeatureSubset();

	/**
	 * Returns a new object of class '<em>Optional Feature Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Optional Feature Degree</em>'.
	 * @generated
	 */
	OptionalFeatureDegree createOptionalFeatureDegree();

	/**
	 * Returns a new object of class '<em>Discrete Processing Rate Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Discrete Processing Rate Degree</em>'.
	 * @generated
	 */
	DiscreteProcessingRateDegree createDiscreteProcessingRateDegree();

	/**
	 * Returns a new object of class '<em>Capacity Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capacity Degree</em>'.
	 * @generated
	 */
	CapacityDegree createCapacityDegree();

	/**
	 * Returns a new object of class '<em>Scheduling Policy Degree</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Policy Degree</em>'.
	 * @generated
	 */
	SchedulingPolicyDegree createSchedulingPolicyDegree();

	/**
	 * Returns a new object of class '<em>Scheduling Policy Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scheduling Policy Choice</em>'.
	 * @generated
	 */
	SchedulingPolicyChoice createSchedulingPolicyChoice();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	designdecisionPackage getdesigndecisionPackage();

} //designdecisionFactory

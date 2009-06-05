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
	 * Returns a new object of class '<em>Equivalent Components</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equivalent Components</em>'.
	 * @generated
	 */
	EquivalentComponents createEquivalentComponents();

	/**
	 * Returns a new object of class '<em>Available Servers</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Available Servers</em>'.
	 * @generated
	 */
	AvailableServers createAvailableServers();

	/**
	 * Returns a new object of class '<em>Component Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Choice</em>'.
	 * @generated
	 */
	ComponentChoice createComponentChoice();

	/**
	 * Returns a new object of class '<em>Allocation Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation Choice</em>'.
	 * @generated
	 */
	AllocationChoice createAllocationChoice();

	/**
	 * Returns a new object of class '<em>Processing Rate Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Rate Choice</em>'.
	 * @generated
	 */
	ProcessingRateChoice createProcessingRateChoice();

	/**
	 * Returns a new object of class '<em>Processing Rate Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Processing Rate Decision</em>'.
	 * @generated
	 */
	ProcessingRateDecision createProcessingRateDecision();

	/**
	 * Returns a new object of class '<em>Allocation Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Allocation Decision</em>'.
	 * @generated
	 */
	AllocationDecision createAllocationDecision();

	/**
	 * Returns a new object of class '<em>Assembled Component Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assembled Component Decision</em>'.
	 * @generated
	 */
	AssembledComponentDecision createAssembledComponentDecision();

	/**
	 * Returns a new object of class '<em>Integer Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Range</em>'.
	 * @generated
	 */
	IntegerRange createIntegerRange();

	/**
	 * Returns a new object of class '<em>Double Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Range</em>'.
	 * @generated
	 */
	DoubleRange createDoubleRange();

	/**
	 * Returns a new object of class '<em>Resource Container Replication Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Container Replication Choice</em>'.
	 * @generated
	 */
	ResourceContainerReplicationChoice createResourceContainerReplicationChoice();

	/**
	 * Returns a new object of class '<em>Resource Container Replication Decision</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Container Replication Decision</em>'.
	 * @generated
	 */
	ResourceContainerReplicationDecision createResourceContainerReplicationDecision();

	/**
	 * Returns a new object of class '<em>Genotype</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Genotype</em>'.
	 * @generated
	 */
	Genotype createGenotype();

	/**
	 * Returns a new object of class '<em>Problem</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Problem</em>'.
	 * @generated
	 */
	Problem createProblem();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	designdecisionPackage getdesigndecisionPackage();

} //designdecisionFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.core.CorePackage
 * @generated
 */
public interface CoreFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CoreFactory eINSTANCE = de.uka.ipd.sdq.capra.core.impl.CoreFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Communication Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Identifier</em>'.
	 * @generated
	 */
	CommunicationIdentifier createCommunicationIdentifier();

	/**
	 * Returns a new object of class '<em>Demand Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demand Action</em>'.
	 * @generated
	 */
	DemandAction createDemandAction();

	/**
	 * Returns a new object of class '<em>Demand Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demand Identifier</em>'.
	 * @generated
	 */
	DemandIdentifier createDemandIdentifier();

	/**
	 * Returns a new object of class '<em>Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Usage</em>'.
	 * @generated
	 */
	ResourceUsage createResourceUsage();

	/**
	 * Returns a new object of class '<em>Successful Termination</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Successful Termination</em>'.
	 * @generated
	 */
	SuccessfulTermination createSuccessfulTermination();

	/**
	 * Returns a new object of class '<em>Probabilistic Prefix</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Probabilistic Prefix</em>'.
	 * @generated
	 */
	ProbabilisticPrefix createProbabilisticPrefix();

	/**
	 * Returns a new object of class '<em>Internal Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Selector</em>'.
	 * @generated
	 */
	InternalSelector createInternalSelector();

	/**
	 * Returns a new object of class '<em>Choice</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Choice</em>'.
	 * @generated
	 */
	Choice createChoice();

	/**
	 * Returns a new object of class '<em>External Selector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Selector</em>'.
	 * @generated
	 */
	ExternalSelector createExternalSelector();

	/**
	 * Returns a new object of class '<em>Input Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Input Event Action</em>'.
	 * @generated
	 */
	InputEventAction createInputEventAction();

	/**
	 * Returns a new object of class '<em>Output Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Output Event Action</em>'.
	 * @generated
	 */
	OutputEventAction createOutputEventAction();

	/**
	 * Returns a new object of class '<em>Communication Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Communication Event Action</em>'.
	 * @generated
	 */
	CommunicationEventAction createCommunicationEventAction();

	/**
	 * Returns a new object of class '<em>Bounded Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Bounded Loop</em>'.
	 * @generated
	 */
	BoundedLoop createBoundedLoop();

	/**
	 * Returns a new object of class '<em>Parallel Composition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Composition</em>'.
	 * @generated
	 */
	ParallelComposition createParallelComposition();

	/**
	 * Returns a new object of class '<em>Restriction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Restriction</em>'.
	 * @generated
	 */
	Restriction createRestriction();

	/**
	 * Returns a new object of class '<em>Renaming</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Renaming</em>'.
	 * @generated
	 */
	Renaming createRenaming();

	/**
	 * Returns a new object of class '<em>Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Mapping</em>'.
	 * @generated
	 */
	Mapping createMapping();

	/**
	 * Returns a new object of class '<em>Silent Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Silent Identifier</em>'.
	 * @generated
	 */
	SilentIdentifier createSilentIdentifier();

	/**
	 * Returns a new object of class '<em>Process Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Variable</em>'.
	 * @generated
	 */
	ProcessVariable createProcessVariable();

	/**
	 * Returns a new object of class '<em>Process Variable Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Variable Usage</em>'.
	 * @generated
	 */
	ProcessVariableUsage createProcessVariableUsage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CorePackage getCorePackage();

} //CoreFactory

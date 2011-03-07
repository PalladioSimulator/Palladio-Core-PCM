/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public interface SeffFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SeffFactory eINSTANCE = de.uka.ipd.sdq.pcm.seff.impl.SeffFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Stop Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stop Action</em>'.
	 * @generated
	 */
	StopAction createStopAction();

	/**
	 * Returns a new object of class '<em>Parametric Resource Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Resource Demand</em>'.
	 * @generated
	 */
	ParametricResourceDemand createParametricResourceDemand();

	/**
	 * Returns a new object of class '<em>Start Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Start Action</em>'.
	 * @generated
	 */
	StartAction createStartAction();

	/**
	 * Returns a new object of class '<em>Resource Demanding SEFF</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Demanding SEFF</em>'.
	 * @generated
	 */
	ResourceDemandingSEFF createResourceDemandingSEFF();

	/**
	 * Returns a new object of class '<em>Resource Demanding Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Demanding Behaviour</em>'.
	 * @generated
	 */
	ResourceDemandingBehaviour createResourceDemandingBehaviour();

	/**
	 * Returns a new object of class '<em>Release Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Release Action</em>'.
	 * @generated
	 */
	ReleaseAction createReleaseAction();

	/**
	 * Returns a new object of class '<em>Primitive Parametric Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Primitive Parametric Parameter Usage</em>'.
	 * @generated
	 */
	PrimitiveParametricParameterUsage createPrimitiveParametricParameterUsage();

	/**
	 * Returns a new object of class '<em>Loop Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Loop Action</em>'.
	 * @generated
	 */
	LoopAction createLoopAction();

	/**
	 * Returns a new object of class '<em>Iteration Count</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Count</em>'.
	 * @generated
	 */
	IterationCount createIterationCount();

	/**
	 * Returns a new object of class '<em>Internal Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Action</em>'.
	 * @generated
	 */
	InternalAction createInternalAction();

	/**
	 * Returns a new object of class '<em>Fork Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fork Action</em>'.
	 * @generated
	 */
	ForkAction createForkAction();

	/**
	 * Returns a new object of class '<em>External Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Call Action</em>'.
	 * @generated
	 */
	ExternalCallAction createExternalCallAction();

	/**
	 * Returns a new object of class '<em>Collection Parametric Parameter Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Collection Parametric Parameter Usage</em>'.
	 * @generated
	 */
	CollectionParametricParameterUsage createCollectionParametricParameterUsage();

	/**
	 * Returns a new object of class '<em>Branch Transition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch Transition</em>'.
	 * @generated
	 */
	BranchTransition createBranchTransition();

	/**
	 * Returns a new object of class '<em>Branch Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Branch Action</em>'.
	 * @generated
	 */
	BranchAction createBranchAction();

	/**
	 * Returns a new object of class '<em>Aquire Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Aquire Action</em>'.
	 * @generated
	 */
	AquireAction createAquireAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SeffPackage getSeffPackage();

} //SeffFactory

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelFactory
 * @model kind="package"
 * @generated
 */
public interface SimuComModelPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "simucom"; //$NON-NLS-1$

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://seq.ipd.uka.de/simucom"; //$NON-NLS-1$

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "simucom"; //$NON-NLS-1$

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimuComModelPackage eINSTANCE = de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedArchitectureImpl <em>Simulated Architecture</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedArchitectureImpl
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelPackageImpl#getSimulatedArchitecture()
	 * @generated
	 */
	int SIMULATED_ARCHITECTURE = 0;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ARCHITECTURE__COMPONENTS = 0;

	/**
	 * The number of structural features of the the '<em>Simulated Architecture</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_ARCHITECTURE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedComponentImpl <em>Simulated Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedComponentImpl
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelPackageImpl#getSimulatedComponent()
	 * @generated
	 */
	int SIMULATED_COMPONENT = 1;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_COMPONENT__METHODS = 0;

	/**
	 * The number of structural features of the the '<em>Simulated Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_COMPONENT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedMethodImpl <em>Simulated Method</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimulatedMethodImpl
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelPackageImpl#getSimulatedMethod()
	 * @generated
	 */
	int SIMULATED_METHOD = 2;

	/**
	 * The feature id for the '<em><b>Service Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_METHOD__SERVICE_EFFECT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_METHOD__NAME = 1;

	/**
	 * The number of structural features of the the '<em>Simulated Method</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMULATED_METHOD_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.simucom.model.simucom.impl.ServiceEffectImpl <em>Service Effect</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.ServiceEffectImpl
	 * @see de.uka.ipd.sdq.simucom.model.simucom.impl.SimuComModelPackageImpl#getServiceEffect()
	 * @generated
	 */
	int SERVICE_EFFECT = 3;

	/**
	 * The feature id for the '<em><b>Activity</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EFFECT__ACTIVITY = 0;

	/**
	 * The number of structural features of the the '<em>Service Effect</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EFFECT_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture <em>Simulated Architecture</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Architecture</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture
	 * @generated
	 */
	EClass getSimulatedArchitecture();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture#getComponents()
	 * @see #getSimulatedArchitecture()
	 * @generated
	 */
	EReference getSimulatedArchitecture_Components();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent <em>Simulated Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Component</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent
	 * @generated
	 */
	EClass getSimulatedComponent();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methods</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent#getMethods()
	 * @see #getSimulatedComponent()
	 * @generated
	 */
	EReference getSimulatedComponent_Methods();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod <em>Simulated Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simulated Method</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod
	 * @generated
	 */
	EClass getSimulatedMethod();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getServiceEffect <em>Service Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Service Effect</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getServiceEffect()
	 * @see #getSimulatedMethod()
	 * @generated
	 */
	EReference getSimulatedMethod_ServiceEffect();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod#getName()
	 * @see #getSimulatedMethod()
	 * @generated
	 */
	EAttribute getSimulatedMethod_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect <em>Service Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Effect</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect
	 * @generated
	 */
	EClass getServiceEffect();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect#getActivity <em>Activity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Activity</em>'.
	 * @see de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect#getActivity()
	 * @see #getServiceEffect()
	 * @generated
	 */
	EReference getServiceEffect_Activity();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SimuComModelFactory getSimuComModelFactory();

} //SimuComModelPackage

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.system;

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
 * @see de.uka.ipd.sdq.spa.system.SystemFactory
 * @model kind="package"
 * @generated
 */
public interface SystemPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "system";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Analytical/System/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spa.system";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SystemPackage eINSTANCE = de.uka.ipd.sdq.spa.system.impl.SystemPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.system.impl.SystemModelImpl <em>Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.system.impl.SystemModelImpl
	 * @see de.uka.ipd.sdq.spa.system.impl.SystemPackageImpl#getSystemModel()
	 * @generated
	 */
	int SYSTEM_MODEL = 0;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL__RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_MODEL_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.system.impl.BehaviourImpl <em>Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.system.impl.BehaviourImpl
	 * @see de.uka.ipd.sdq.spa.system.impl.SystemPackageImpl#getBehaviour()
	 * @generated
	 */
	int BEHAVIOUR = 1;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR__BEHAVIOUR = 2;

	/**
	 * The number of structural features of the '<em>Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEHAVIOUR_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.system.SystemModel <em>Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Model</em>'.
	 * @see de.uka.ipd.sdq.spa.system.SystemModel
	 * @generated
	 */
	EClass getSystemModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.system.SystemModel#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see de.uka.ipd.sdq.spa.system.SystemModel#getProcesses()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.system.SystemModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.uka.ipd.sdq.spa.system.SystemModel#getResources()
	 * @see #getSystemModel()
	 * @generated
	 */
	EReference getSystemModel_Resources();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.system.Behaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.system.Behaviour
	 * @generated
	 */
	EClass getBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.system.Behaviour#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.spa.system.Behaviour#getNumReplicas()
	 * @see #getBehaviour()
	 * @generated
	 */
	EAttribute getBehaviour_NumReplicas();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.system.Behaviour#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.system.Behaviour#getName()
	 * @see #getBehaviour()
	 * @generated
	 */
	EAttribute getBehaviour_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.system.Behaviour#getBehaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.system.Behaviour#getBehaviour()
	 * @see #getBehaviour()
	 * @generated
	 */
	EReference getBehaviour_Behaviour();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SystemFactory getSystemFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.system.impl.SystemModelImpl <em>Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.system.impl.SystemModelImpl
		 * @see de.uka.ipd.sdq.spa.system.impl.SystemPackageImpl#getSystemModel()
		 * @generated
		 */
		EClass SYSTEM_MODEL = eINSTANCE.getSystemModel();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_MODEL__PROCESSES = eINSTANCE.getSystemModel_Processes();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_MODEL__RESOURCES = eINSTANCE.getSystemModel_Resources();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.system.impl.BehaviourImpl <em>Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.system.impl.BehaviourImpl
		 * @see de.uka.ipd.sdq.spa.system.impl.SystemPackageImpl#getBehaviour()
		 * @generated
		 */
		EClass BEHAVIOUR = eINSTANCE.getBehaviour();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOUR__NUM_REPLICAS = eINSTANCE.getBehaviour_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEHAVIOUR__NAME = eINSTANCE.getBehaviour_Name();

		/**
		 * The meta object literal for the '<em><b>Behaviour</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEHAVIOUR__BEHAVIOUR = eINSTANCE.getBehaviour_Behaviour();

	}

} //SystemPackage

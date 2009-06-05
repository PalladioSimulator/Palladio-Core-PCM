/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa;

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
 * @see de.uka.ipd.sdq.spa.SpaFactory
 * @model kind="package"
 * @generated
 */
public interface SpaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "spa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/StochasticProcessAlgebra/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpaPackage eINSTANCE = de.uka.ipd.sdq.spa.impl.SpaPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.impl.ProcessBehaviourImpl <em>Process Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.impl.ProcessBehaviourImpl
	 * @see de.uka.ipd.sdq.spa.impl.SpaPackageImpl#getProcessBehaviour()
	 * @generated
	 */
	int PROCESS_BEHAVIOUR = 0;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_BEHAVIOUR__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_BEHAVIOUR__NAME = 1;

	/**
	 * The feature id for the '<em><b>Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_BEHAVIOUR__BEHAVIOUR = 2;

	/**
	 * The number of structural features of the '<em>Process Behaviour</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_BEHAVIOUR_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.impl.SPAModelImpl <em>SPA Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.impl.SPAModelImpl
	 * @see de.uka.ipd.sdq.spa.impl.SpaPackageImpl#getSPAModel()
	 * @generated
	 */
	int SPA_MODEL = 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPA_MODEL__PROCESSES = 0;

	/**
	 * The feature id for the '<em><b>Resources</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPA_MODEL__RESOURCES = 1;

	/**
	 * The number of structural features of the '<em>SPA Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SPA_MODEL_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.ProcessBehaviour <em>Process Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.ProcessBehaviour
	 * @generated
	 */
	EClass getProcessBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.ProcessBehaviour#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.spa.ProcessBehaviour#getNumReplicas()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EAttribute getProcessBehaviour_NumReplicas();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.ProcessBehaviour#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.ProcessBehaviour#getName()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EAttribute getProcessBehaviour_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.ProcessBehaviour#getBehaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.ProcessBehaviour#getBehaviour()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EReference getProcessBehaviour_Behaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.SPAModel <em>SPA Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPA Model</em>'.
	 * @see de.uka.ipd.sdq.spa.SPAModel
	 * @generated
	 */
	EClass getSPAModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.SPAModel#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see de.uka.ipd.sdq.spa.SPAModel#getProcesses()
	 * @see #getSPAModel()
	 * @generated
	 */
	EReference getSPAModel_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.SPAModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.uka.ipd.sdq.spa.SPAModel#getResources()
	 * @see #getSPAModel()
	 * @generated
	 */
	EReference getSPAModel_Resources();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SpaFactory getSpaFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.impl.ProcessBehaviourImpl <em>Process Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.impl.ProcessBehaviourImpl
		 * @see de.uka.ipd.sdq.spa.impl.SpaPackageImpl#getProcessBehaviour()
		 * @generated
		 */
		EClass PROCESS_BEHAVIOUR = eINSTANCE.getProcessBehaviour();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_BEHAVIOUR__NUM_REPLICAS = eINSTANCE.getProcessBehaviour_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_BEHAVIOUR__NAME = eINSTANCE.getProcessBehaviour_Name();

		/**
		 * The meta object literal for the '<em><b>Behaviour</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_BEHAVIOUR__BEHAVIOUR = eINSTANCE.getProcessBehaviour_Behaviour();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.impl.SPAModelImpl <em>SPA Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.impl.SPAModelImpl
		 * @see de.uka.ipd.sdq.spa.impl.SpaPackageImpl#getSPAModel()
		 * @generated
		 */
		EClass SPA_MODEL = eINSTANCE.getSPAModel();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPA_MODEL__PROCESSES = eINSTANCE.getSPAModel_Processes();

		/**
		 * The meta object literal for the '<em><b>Resources</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SPA_MODEL__RESOURCES = eINSTANCE.getSPAModel_Resources();

	}

} //SpaPackage

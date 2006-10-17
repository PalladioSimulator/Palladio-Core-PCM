/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.environment;

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
 * @see de.uka.ipd.sdq.spa.environment.EnvironmentFactory
 * @model kind="package"
 * @generated
 */
public interface EnvironmentPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "environment";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Analytical/Resources/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "spa.environment";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EnvironmentPackage eINSTANCE = de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.environment.impl.ProcessBehaviourImpl <em>Process Behaviour</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.environment.impl.ProcessBehaviourImpl
	 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getProcessBehaviour()
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.environment.impl.SPAModelImpl <em>SPA Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.environment.impl.SPAModelImpl
	 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getSPAModel()
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
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.environment.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.environment.impl.ResourceImpl
	 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.environment.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.environment.impl.PassiveResourceImpl
	 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getPassiveResource()
	 * @generated
	 */
	int PASSIVE_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NUM_REPLICAS = RESOURCE__NUM_REPLICAS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Passive Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.spa.environment.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.spa.environment.impl.ProcessingResourceImpl
	 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getProcessingResource()
	 * @generated
	 */
	int PROCESSING_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NUM_REPLICAS = RESOURCE__NUM_REPLICAS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Processing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.environment.ProcessBehaviour <em>Process Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.ProcessBehaviour
	 * @generated
	 */
	EClass getProcessBehaviour();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getNumReplicas()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EAttribute getProcessBehaviour_NumReplicas();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getName()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EAttribute getProcessBehaviour_Name();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getBehaviour <em>Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Behaviour</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.ProcessBehaviour#getBehaviour()
	 * @see #getProcessBehaviour()
	 * @generated
	 */
	EReference getProcessBehaviour_Behaviour();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.environment.SPAModel <em>SPA Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>SPA Model</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.SPAModel
	 * @generated
	 */
	EClass getSPAModel();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.environment.SPAModel#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Processes</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.SPAModel#getProcesses()
	 * @see #getSPAModel()
	 * @generated
	 */
	EReference getSPAModel_Processes();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.spa.environment.SPAModel#getResources <em>Resources</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Resources</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.SPAModel#getResources()
	 * @see #getSPAModel()
	 * @generated
	 */
	EReference getSPAModel_Resources();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.environment.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.environment.Resource#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.Resource#getNumReplicas()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_NumReplicas();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.spa.environment.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.environment.PassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.PassiveResource
	 * @generated
	 */
	EClass getPassiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.spa.environment.ProcessingResource <em>Processing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource</em>'.
	 * @see de.uka.ipd.sdq.spa.environment.ProcessingResource
	 * @generated
	 */
	EClass getProcessingResource();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	EnvironmentFactory getEnvironmentFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.environment.impl.ProcessBehaviourImpl <em>Process Behaviour</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.environment.impl.ProcessBehaviourImpl
		 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getProcessBehaviour()
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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.environment.impl.SPAModelImpl <em>SPA Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.environment.impl.SPAModelImpl
		 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getSPAModel()
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

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.environment.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.environment.impl.ResourceImpl
		 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NUM_REPLICAS = eINSTANCE.getResource_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.environment.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.environment.impl.PassiveResourceImpl
		 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getPassiveResource()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE = eINSTANCE.getPassiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.spa.environment.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.spa.environment.impl.ProcessingResourceImpl
		 * @see de.uka.ipd.sdq.spa.environment.impl.EnvironmentPackageImpl#getProcessingResource()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE = eINSTANCE.getProcessingResource();

	}

} //EnvironmentPackage

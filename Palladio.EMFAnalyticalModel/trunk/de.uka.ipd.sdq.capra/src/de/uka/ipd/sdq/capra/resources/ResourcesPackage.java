/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.resources;

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
 * @see de.uka.ipd.sdq.capra.resources.ResourcesFactory
 * @model kind="package"
 * @generated
 */
public interface ResourcesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "resources";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Resources/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "resources";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResourcesPackage eINSTANCE = de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.resources.impl.ResourceImpl <em>Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourceImpl
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getResource()
	 * @generated
	 */
	int RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.resources.impl.ActiveResourceImpl <em>Active Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.resources.impl.ActiveResourceImpl
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getActiveResource()
	 * @generated
	 */
	int ACTIVE_RESOURCE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Active Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.resources.impl.DelayResourceImpl <em>Delay Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.resources.impl.DelayResourceImpl
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getDelayResource()
	 * @generated
	 */
	int DELAY_RESOURCE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_RESOURCE__NAME = ACTIVE_RESOURCE__NAME;

	/**
	 * The number of structural features of the '<em>Delay Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELAY_RESOURCE_FEATURE_COUNT = ACTIVE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.resources.impl.ContentionResourceImpl <em>Contention Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.resources.impl.ContentionResourceImpl
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getContentionResource()
	 * @generated
	 */
	int CONTENTION_RESOURCE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE__NAME = RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE__CAPACITY = RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Contention Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTENTION_RESOURCE_FEATURE_COUNT = RESOURCE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.resources.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.resources.impl.ProcessingResourceImpl
	 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getProcessingResource()
	 * @generated
	 */
	int PROCESSING_RESOURCE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__NAME = CONTENTION_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__CAPACITY = CONTENTION_RESOURCE__CAPACITY;

	/**
	 * The feature id for the '<em><b>Scheduler</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE__SCHEDULER = CONTENTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Processing Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESSING_RESOURCE_FEATURE_COUNT = CONTENTION_RESOURCE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.resources.Resource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.Resource
	 * @generated
	 */
	EClass getResource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.resources.Resource#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.Resource#getName()
	 * @see #getResource()
	 * @generated
	 */
	EAttribute getResource_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.resources.DelayResource <em>Delay Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delay Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.DelayResource
	 * @generated
	 */
	EClass getDelayResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.resources.ActiveResource <em>Active Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Active Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.ActiveResource
	 * @generated
	 */
	EClass getActiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.resources.ContentionResource <em>Contention Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contention Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.ContentionResource
	 * @generated
	 */
	EClass getContentionResource();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.resources.ContentionResource#getCapacity <em>Capacity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Capacity</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.ContentionResource#getCapacity()
	 * @see #getContentionResource()
	 * @generated
	 */
	EAttribute getContentionResource_Capacity();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.resources.ProcessingResource <em>Processing Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Processing Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.ProcessingResource
	 * @generated
	 */
	EClass getProcessingResource();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.resources.ProcessingResource#getScheduler <em>Scheduler</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Scheduler</em>'.
	 * @see de.uka.ipd.sdq.capra.resources.ProcessingResource#getScheduler()
	 * @see #getProcessingResource()
	 * @generated
	 */
	EReference getProcessingResource_Scheduler();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResourcesFactory getResourcesFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.resources.impl.ResourceImpl <em>Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourceImpl
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getResource()
		 * @generated
		 */
		EClass RESOURCE = eINSTANCE.getResource();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE__NAME = eINSTANCE.getResource_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.resources.impl.DelayResourceImpl <em>Delay Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.resources.impl.DelayResourceImpl
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getDelayResource()
		 * @generated
		 */
		EClass DELAY_RESOURCE = eINSTANCE.getDelayResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.resources.impl.ActiveResourceImpl <em>Active Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.resources.impl.ActiveResourceImpl
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getActiveResource()
		 * @generated
		 */
		EClass ACTIVE_RESOURCE = eINSTANCE.getActiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.resources.impl.ContentionResourceImpl <em>Contention Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.resources.impl.ContentionResourceImpl
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getContentionResource()
		 * @generated
		 */
		EClass CONTENTION_RESOURCE = eINSTANCE.getContentionResource();

		/**
		 * The meta object literal for the '<em><b>Capacity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTENTION_RESOURCE__CAPACITY = eINSTANCE.getContentionResource_Capacity();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.resources.impl.ProcessingResourceImpl <em>Processing Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.resources.impl.ProcessingResourceImpl
		 * @see de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl#getProcessingResource()
		 * @generated
		 */
		EClass PROCESSING_RESOURCE = eINSTANCE.getProcessingResource();

		/**
		 * The meta object literal for the '<em><b>Scheduler</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESSING_RESOURCE__SCHEDULER = eINSTANCE.getProcessingResource_Scheduler();

	}

} //ResourcesPackage

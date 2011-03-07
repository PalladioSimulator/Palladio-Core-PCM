/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.extension;

import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

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
 * @see de.uka.ipd.sdq.capra.extension.ExtensionFactory
 * @model kind="package"
 * @generated
 */
public interface ExtensionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "extension";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Extensions/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capra.extension";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExtensionPackage eINSTANCE = de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.PassiveResourceImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getPassiveResource()
	 * @generated
	 */
	int PASSIVE_RESOURCE = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__NAME = ResourcesPackage.CONTENTION_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE__CAPACITY = ResourcesPackage.CONTENTION_RESOURCE__CAPACITY;

	/**
	 * The number of structural features of the '<em>Passive Resource</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSIVE_RESOURCE_FEATURE_COUNT = ResourcesPackage.CONTENTION_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.AcquireActionImpl <em>Acquire Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.AcquireActionImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getAcquireAction()
	 * @generated
	 */
	int ACQUIRE_ACTION = 1;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__NUMBER = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION__RESOURCE = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Acquire Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACQUIRE_ACTION_FEATURE_COUNT = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.ReleaseActionImpl <em>Release Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.ReleaseActionImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getReleaseAction()
	 * @generated
	 */
	int RELEASE_ACTION = 2;

	/**
	 * The feature id for the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__NUMBER = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION__RESOURCE = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Release Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELEASE_ACTION_FEATURE_COUNT = CorePackage.INSTANTANEOUS_ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.WeakSemaphoreImpl <em>Weak Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.WeakSemaphoreImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getWeakSemaphore()
	 * @generated
	 */
	int WEAK_SEMAPHORE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_SEMAPHORE__NAME = PASSIVE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_SEMAPHORE__CAPACITY = PASSIVE_RESOURCE__CAPACITY;

	/**
	 * The number of structural features of the '<em>Weak Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WEAK_SEMAPHORE_FEATURE_COUNT = PASSIVE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.StrongSemaphoreImpl <em>Strong Semaphore</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.StrongSemaphoreImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getStrongSemaphore()
	 * @generated
	 */
	int STRONG_SEMAPHORE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_SEMAPHORE__NAME = PASSIVE_RESOURCE__NAME;

	/**
	 * The feature id for the '<em><b>Capacity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_SEMAPHORE__CAPACITY = PASSIVE_RESOURCE__CAPACITY;

	/**
	 * The number of structural features of the '<em>Strong Semaphore</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRONG_SEMAPHORE_FEATURE_COUNT = PASSIVE_RESOURCE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.extension.impl.SchedulingStrategyImpl <em>Scheduling Strategy</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.extension.impl.SchedulingStrategyImpl
	 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getSchedulingStrategy()
	 * @generated
	 */
	int SCHEDULING_STRATEGY = 5;

	/**
	 * The number of structural features of the '<em>Scheduling Strategy</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULING_STRATEGY_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.PassiveResource <em>Passive Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Passive Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.PassiveResource
	 * @generated
	 */
	EClass getPassiveResource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.AcquireAction <em>Acquire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Acquire Action</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.AcquireAction
	 * @generated
	 */
	EClass getAcquireAction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.extension.AcquireAction#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.AcquireAction#getNumber()
	 * @see #getAcquireAction()
	 * @generated
	 */
	EAttribute getAcquireAction_Number();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.extension.AcquireAction#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.AcquireAction#getResource()
	 * @see #getAcquireAction()
	 * @generated
	 */
	EReference getAcquireAction_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.ReleaseAction <em>Release Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Release Action</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.ReleaseAction
	 * @generated
	 */
	EClass getReleaseAction();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getNumber <em>Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Number</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.ReleaseAction#getNumber()
	 * @see #getReleaseAction()
	 * @generated
	 */
	EAttribute getReleaseAction_Number();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.extension.ReleaseAction#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.ReleaseAction#getResource()
	 * @see #getReleaseAction()
	 * @generated
	 */
	EReference getReleaseAction_Resource();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.WeakSemaphore <em>Weak Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Weak Semaphore</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.WeakSemaphore
	 * @generated
	 */
	EClass getWeakSemaphore();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.StrongSemaphore <em>Strong Semaphore</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Strong Semaphore</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.StrongSemaphore
	 * @generated
	 */
	EClass getStrongSemaphore();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.extension.SchedulingStrategy <em>Scheduling Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Scheduling Strategy</em>'.
	 * @see de.uka.ipd.sdq.capra.extension.SchedulingStrategy
	 * @generated
	 */
	EClass getSchedulingStrategy();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExtensionFactory getExtensionFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.PassiveResourceImpl <em>Passive Resource</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.PassiveResourceImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getPassiveResource()
		 * @generated
		 */
		EClass PASSIVE_RESOURCE = eINSTANCE.getPassiveResource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.AcquireActionImpl <em>Acquire Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.AcquireActionImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getAcquireAction()
		 * @generated
		 */
		EClass ACQUIRE_ACTION = eINSTANCE.getAcquireAction();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACQUIRE_ACTION__NUMBER = eINSTANCE.getAcquireAction_Number();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACQUIRE_ACTION__RESOURCE = eINSTANCE.getAcquireAction_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.ReleaseActionImpl <em>Release Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.ReleaseActionImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getReleaseAction()
		 * @generated
		 */
		EClass RELEASE_ACTION = eINSTANCE.getReleaseAction();

		/**
		 * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELEASE_ACTION__NUMBER = eINSTANCE.getReleaseAction_Number();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELEASE_ACTION__RESOURCE = eINSTANCE.getReleaseAction_Resource();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.WeakSemaphoreImpl <em>Weak Semaphore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.WeakSemaphoreImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getWeakSemaphore()
		 * @generated
		 */
		EClass WEAK_SEMAPHORE = eINSTANCE.getWeakSemaphore();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.StrongSemaphoreImpl <em>Strong Semaphore</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.StrongSemaphoreImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getStrongSemaphore()
		 * @generated
		 */
		EClass STRONG_SEMAPHORE = eINSTANCE.getStrongSemaphore();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.extension.impl.SchedulingStrategyImpl <em>Scheduling Strategy</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.extension.impl.SchedulingStrategyImpl
		 * @see de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl#getSchedulingStrategy()
		 * @generated
		 */
		EClass SCHEDULING_STRATEGY = eINSTANCE.getSchedulingStrategy();

	}

} //ExtensionPackage

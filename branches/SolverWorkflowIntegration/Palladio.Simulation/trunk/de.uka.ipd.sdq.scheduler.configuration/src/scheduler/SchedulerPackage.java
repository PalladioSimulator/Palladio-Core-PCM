/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler;

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
 * @see scheduler.SchedulerFactory
 * @model kind="package"
 * @generated
 */
public interface SchedulerPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "scheduler";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/scheduler/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "scheduler";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SchedulerPackage eINSTANCE = scheduler.impl.SchedulerPackageImpl.init();

	/**
	 * The meta object id for the '{@link scheduler.impl.SchedulerLibraryImpl <em>Library</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SchedulerLibraryImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSchedulerLibrary()
	 * @generated
	 */
	int SCHEDULER_LIBRARY = 0;

	/**
	 * The feature id for the '<em><b>Scheduler Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION = 0;

	/**
	 * The number of structural features of the '<em>Library</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SCHEDULER_LIBRARY_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link scheduler.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see scheduler.impl.SystemConfigurationImpl
	 * @see scheduler.impl.SchedulerPackageImpl#getSystemConfiguration()
	 * @generated
	 */
	int SYSTEM_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Process Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION = 0;

	/**
	 * The feature id for the '<em><b>Active Resource Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION = 1;

	/**
	 * The feature id for the '<em><b>Passive Resource Configuration</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION = 2;

	/**
	 * The number of structural features of the '<em>System Configuration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_CONFIGURATION_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link scheduler.SchedulerLibrary <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Library</em>'.
	 * @see scheduler.SchedulerLibrary
	 * @generated
	 */
	EClass getSchedulerLibrary();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SchedulerLibrary#getSchedulerConfiguration <em>Scheduler Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Scheduler Configuration</em>'.
	 * @see scheduler.SchedulerLibrary#getSchedulerConfiguration()
	 * @see #getSchedulerLibrary()
	 * @generated
	 */
	EReference getSchedulerLibrary_SchedulerConfiguration();

	/**
	 * Returns the meta object for class '{@link scheduler.SystemConfiguration <em>System Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System Configuration</em>'.
	 * @see scheduler.SystemConfiguration
	 * @generated
	 */
	EClass getSystemConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SystemConfiguration#getProcessConfiguration <em>Process Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Process Configuration</em>'.
	 * @see scheduler.SystemConfiguration#getProcessConfiguration()
	 * @see #getSystemConfiguration()
	 * @generated
	 */
	EReference getSystemConfiguration_ProcessConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SystemConfiguration#getActiveResourceConfiguration <em>Active Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Active Resource Configuration</em>'.
	 * @see scheduler.SystemConfiguration#getActiveResourceConfiguration()
	 * @see #getSystemConfiguration()
	 * @generated
	 */
	EReference getSystemConfiguration_ActiveResourceConfiguration();

	/**
	 * Returns the meta object for the containment reference list '{@link scheduler.SystemConfiguration#getPassiveResourceConfiguration <em>Passive Resource Configuration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Passive Resource Configuration</em>'.
	 * @see scheduler.SystemConfiguration#getPassiveResourceConfiguration()
	 * @see #getSystemConfiguration()
	 * @generated
	 */
	EReference getSystemConfiguration_PassiveResourceConfiguration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SchedulerFactory getSchedulerFactory();

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
		 * The meta object literal for the '{@link scheduler.impl.SchedulerLibraryImpl <em>Library</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SchedulerLibraryImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSchedulerLibrary()
		 * @generated
		 */
		EClass SCHEDULER_LIBRARY = eINSTANCE.getSchedulerLibrary();

		/**
		 * The meta object literal for the '<em><b>Scheduler Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SCHEDULER_LIBRARY__SCHEDULER_CONFIGURATION = eINSTANCE.getSchedulerLibrary_SchedulerConfiguration();

		/**
		 * The meta object literal for the '{@link scheduler.impl.SystemConfigurationImpl <em>System Configuration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see scheduler.impl.SystemConfigurationImpl
		 * @see scheduler.impl.SchedulerPackageImpl#getSystemConfiguration()
		 * @generated
		 */
		EClass SYSTEM_CONFIGURATION = eINSTANCE.getSystemConfiguration();

		/**
		 * The meta object literal for the '<em><b>Process Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION__PROCESS_CONFIGURATION = eINSTANCE.getSystemConfiguration_ProcessConfiguration();

		/**
		 * The meta object literal for the '<em><b>Active Resource Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION__ACTIVE_RESOURCE_CONFIGURATION = eINSTANCE.getSystemConfiguration_ActiveResourceConfiguration();

		/**
		 * The meta object literal for the '<em><b>Passive Resource Configuration</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM_CONFIGURATION__PASSIVE_RESOURCE_CONFIGURATION = eINSTANCE.getSystemConfiguration_PassiveResourceConfiguration();

	}

} //SchedulerPackage

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler;

import de.uka.ipd.sdq.measurements.MeasurementsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see de.uka.ipd.sdq.measurements.scheduler.schedulerFactory
 * @model kind="package"
 * @generated
 */
public interface schedulerPackage extends EPackage {
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
	String eNS_URI = "http://sdq.ipd.uka.de/MeasurementsFramework/Scheduler/1.0";

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
	schedulerPackage eINSTANCE = de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl <em>Resource Strategy Measurement Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl
	 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getResourceStrategyMeasurementTask()
	 * @generated
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__ID = MeasurementsPackage.MACHINE_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__DESCRIPTION = MeasurementsPackage.MACHINE_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__NAME = MeasurementsPackage.MACHINE_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Machine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__MACHINE = MeasurementsPackage.MACHINE_TASK__MACHINE;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION = MeasurementsPackage.MACHINE_TASK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND = MeasurementsPackage.MACHINE_TASK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Resource Strategy Measurement Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_STRATEGY_MEASUREMENT_TASK_FEATURE_COUNT = MeasurementsPackage.MACHINE_TASK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.scheduler.impl.ParallelProcessTaskImpl <em>Parallel Process Task</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.scheduler.impl.ParallelProcessTaskImpl
	 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getParallelProcessTask()
	 * @generated
	 */
	int PARALLEL_PROCESS_TASK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_PROCESS_TASK__ID = MeasurementsPackage.PARALLEL_TASK__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_PROCESS_TASK__DESCRIPTION = MeasurementsPackage.PARALLEL_TASK__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_PROCESS_TASK__NAME = MeasurementsPackage.PARALLEL_TASK__NAME;

	/**
	 * The feature id for the '<em><b>Tasks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_PROCESS_TASK__TASKS = MeasurementsPackage.PARALLEL_TASK__TASKS;

	/**
	 * The number of structural features of the '<em>Parallel Process Task</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_PROCESS_TASK_FEATURE_COUNT = MeasurementsPackage.PARALLEL_TASK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand <em>Resource Strategy Demand</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand
	 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getResourceStrategyDemand()
	 * @generated
	 */
	int RESOURCE_STRATEGY_DEMAND = 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask <em>Resource Strategy Measurement Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Strategy Measurement Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask
	 * @generated
	 */
	EClass getResourceStrategyMeasurementTask();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Duration</em>'.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDuration()
	 * @see #getResourceStrategyMeasurementTask()
	 * @generated
	 */
	EAttribute getResourceStrategyMeasurementTask_Duration();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDemand <em>Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Demand</em>'.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask#getDemand()
	 * @see #getResourceStrategyMeasurementTask()
	 * @generated
	 */
	EAttribute getResourceStrategyMeasurementTask_Demand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask <em>Parallel Process Task</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Process Task</em>'.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask
	 * @generated
	 */
	EClass getParallelProcessTask();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand <em>Resource Strategy Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Resource Strategy Demand</em>'.
	 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand
	 * @generated
	 */
	EEnum getResourceStrategyDemand();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	schedulerFactory getschedulerFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl <em>Resource Strategy Measurement Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.scheduler.impl.ResourceStrategyMeasurementTaskImpl
		 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getResourceStrategyMeasurementTask()
		 * @generated
		 */
		EClass RESOURCE_STRATEGY_MEASUREMENT_TASK = eINSTANCE.getResourceStrategyMeasurementTask();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_STRATEGY_MEASUREMENT_TASK__DURATION = eINSTANCE.getResourceStrategyMeasurementTask_Duration();

		/**
		 * The meta object literal for the '<em><b>Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_STRATEGY_MEASUREMENT_TASK__DEMAND = eINSTANCE.getResourceStrategyMeasurementTask_Demand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.scheduler.impl.ParallelProcessTaskImpl <em>Parallel Process Task</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.scheduler.impl.ParallelProcessTaskImpl
		 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getParallelProcessTask()
		 * @generated
		 */
		EClass PARALLEL_PROCESS_TASK = eINSTANCE.getParallelProcessTask();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand <em>Resource Strategy Demand</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand
		 * @see de.uka.ipd.sdq.measurements.scheduler.impl.schedulerPackageImpl#getResourceStrategyDemand()
		 * @generated
		 */
		EEnum RESOURCE_STRATEGY_DEMAND = eINSTANCE.getResourceStrategyDemand();

	}

} //schedulerPackage

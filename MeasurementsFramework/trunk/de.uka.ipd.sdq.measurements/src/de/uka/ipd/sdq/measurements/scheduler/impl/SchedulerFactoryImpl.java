/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.measurements.scheduler.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.measurements.scheduler.ParallelProcessTask;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyDemand;
import de.uka.ipd.sdq.measurements.scheduler.ResourceStrategyMeasurementTask;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerFactory;
import de.uka.ipd.sdq.measurements.scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SchedulerFactoryImpl extends EFactoryImpl implements SchedulerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SchedulerFactory init() {
		try {
			SchedulerFactory theSchedulerFactory = (SchedulerFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/MeasurementsFramework/Scheduler/1.0"); 
			if (theSchedulerFactory != null) {
				return theSchedulerFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SchedulerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SchedulerPackage.RESOURCE_STRATEGY_MEASUREMENT_TASK: return createResourceStrategyMeasurementTask();
			case SchedulerPackage.PARALLEL_PROCESS_TASK: return createParallelProcessTask();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulerPackage.RESOURCE_STRATEGY_DEMAND:
				return createResourceStrategyDemandFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case SchedulerPackage.RESOURCE_STRATEGY_DEMAND:
				return convertResourceStrategyDemandToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceStrategyMeasurementTask createResourceStrategyMeasurementTask() {
		ResourceStrategyMeasurementTaskImpl resourceStrategyMeasurementTask = new ResourceStrategyMeasurementTaskImpl();
		return resourceStrategyMeasurementTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelProcessTask createParallelProcessTask() {
		ParallelProcessTaskImpl parallelProcessTask = new ParallelProcessTaskImpl();
		return parallelProcessTask;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceStrategyDemand createResourceStrategyDemandFromString(EDataType eDataType, String initialValue) {
		ResourceStrategyDemand result = ResourceStrategyDemand.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertResourceStrategyDemandToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SchedulerPackage getSchedulerPackage() {
		return (SchedulerPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SchedulerPackage getPackage() {
		return SchedulerPackage.eINSTANCE;
	}

} //SchedulerFactoryImpl

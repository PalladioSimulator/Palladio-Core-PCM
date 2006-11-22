/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.resultmodel.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResultModelFactoryImpl extends EFactoryImpl implements ResultModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ResultModelFactory init() {
		try {
			ResultModelFactory theResultModelFactory = (ResultModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/QueueingNetworkModel/ResultModel/1.0"); 
			if (theResultModelFactory != null) {
				return theResultModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ResultModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ResultModelPackage.QNM_RESULT_MODEL: return createQNMResultModel();
			case ResultModelPackage.TASK_RESOURCE_USAGE: return createTaskResourceUsage();
			case ResultModelPackage.RESOURCE_USAGE_TIME: return createResourceUsageTime();
			case ResultModelPackage.SERVICE_TIME_BREAK_DOWN: return createServiceTimeBreakDown();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case ResultModelPackage.MANAGED_PMF:
				return createManagedPMFFromString(eDataType, initialValue);
			case ResultModelPackage.MANAGED_PDF:
				return createManagedPDFFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case ResultModelPackage.MANAGED_PMF:
				return convertManagedPMFToString(eDataType, instanceValue);
			case ResultModelPackage.MANAGED_PDF:
				return convertManagedPDFToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNMResultModel createQNMResultModel() {
		QNMResultModelImpl qnmResultModel = new QNMResultModelImpl();
		return qnmResultModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskResourceUsage createTaskResourceUsage() {
		TaskResourceUsageImpl taskResourceUsage = new TaskResourceUsageImpl();
		return taskResourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsageTime createResourceUsageTime() {
		ResourceUsageTimeImpl resourceUsageTime = new ResourceUsageTimeImpl();
		return resourceUsageTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServiceTimeBreakDown createServiceTimeBreakDown() {
		ServiceTimeBreakDownImpl serviceTimeBreakDown = new ServiceTimeBreakDownImpl();
		return serviceTimeBreakDown;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPMF createManagedPMFFromString(EDataType eDataType, String initialValue) {
		return (ManagedPMF)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManagedPMFToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManagedPDF createManagedPDFFromString(EDataType eDataType, String initialValue) {
		return (ManagedPDF)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertManagedPDFToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultModelPackage getResultModelPackage() {
		return (ResultModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static ResultModelPackage getPackage() {
		return ResultModelPackage.eINSTANCE;
	}

} //ResultModelFactoryImpl

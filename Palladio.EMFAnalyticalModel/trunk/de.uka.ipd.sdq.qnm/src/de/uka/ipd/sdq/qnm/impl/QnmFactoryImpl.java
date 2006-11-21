/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.probfunction.math.ManagedPDF;

import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

import de.uka.ipd.sdq.qnm.*;

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
public class QnmFactoryImpl extends EFactoryImpl implements QnmFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QnmFactory init() {
		try {
			QnmFactory theQnmFactory = (QnmFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/QueueingNetworkModel/1.0"); 
			if (theQnmFactory != null) {
				return theQnmFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QnmFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QnmFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QnmPackage.QN_MODEL: return createQNModel();
			case QnmPackage.CUSTOMER: return createCustomer();
			case QnmPackage.DEVICE_SERVER: return createDeviceServer();
			case QnmPackage.LOGICAL_SERVER: return createLogicalServer();
			case QnmPackage.DEVICE_DEMAND: return createDeviceDemand();
			case QnmPackage.SEQUENTIAL_DEMAND: return createSequentialDemand();
			case QnmPackage.ALTERNATIVE_DEMAND: return createAlternativeDemand();
			case QnmPackage.ITERATIVE_DEMAND: return createIterativeDemand();
			case QnmPackage.PARALLEL_DEMAND: return createParallelDemand();
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
			case QnmPackage.MANAGED_PDF:
				return createManagedPDFFromString(eDataType, initialValue);
			case QnmPackage.MANAGED_PMF:
				return createManagedPMFFromString(eDataType, initialValue);
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
			case QnmPackage.MANAGED_PDF:
				return convertManagedPDFToString(eDataType, instanceValue);
			case QnmPackage.MANAGED_PMF:
				return convertManagedPMFToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNModel createQNModel() {
		QNModelImpl qnModel = new QNModelImpl();
		return qnModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Task createCustomer() {
		CustomerImpl customer = new CustomerImpl();
		return customer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceServer createDeviceServer() {
		DeviceServerImpl deviceServer = new DeviceServerImpl();
		return deviceServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalServer createLogicalServer() {
		LogicalServerImpl logicalServer = new LogicalServerImpl();
		return logicalServer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceDemand createDeviceDemand() {
		DeviceDemandImpl deviceDemand = new DeviceDemandImpl();
		return deviceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequentialDemand createSequentialDemand() {
		SequentialDemandImpl sequentialDemand = new SequentialDemandImpl();
		return sequentialDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeDemand createAlternativeDemand() {
		AlternativeDemandImpl alternativeDemand = new AlternativeDemandImpl();
		return alternativeDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeDemand createIterativeDemand() {
		IterativeDemandImpl iterativeDemand = new IterativeDemandImpl();
		return iterativeDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelDemand createParallelDemand() {
		ParallelDemandImpl parallelDemand = new ParallelDemandImpl();
		return parallelDemand;
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
	public QnmPackage getQnmPackage() {
		return (QnmPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static QnmPackage getPackage() {
		return QnmPackage.eINSTANCE;
	}

} //QnmFactoryImpl

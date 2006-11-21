/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult.impl;

import de.uka.ipd.sdq.qnm.qnResult.*;

import org.eclipse.emf.ecore.EClass;
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
public class QNResultFactoryImpl extends EFactoryImpl implements QNResultFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QNResultFactory init() {
		try {
			QNResultFactory theQNResultFactory = (QNResultFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/QueueingNetworkModel/QNResult/1.0"); 
			if (theQNResultFactory != null) {
				return theQNResultFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QNResultFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNResultFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case QNResultPackage.DEMAND_SERVER_USAGE: return createDemandServerUsage();
			case QNResultPackage.DEMAND_RESULT: return createDemandResult();
			case QNResultPackage.SERVER_RESULT: return createServerResult();
			case QNResultPackage.CUSTOMER_SERVER_USAGE: return createCustomerServerUsage();
			case QNResultPackage.CUSTOMER_RESULT: return createCustomerResult();
			case QNResultPackage.QN_RESULT_MODEL: return createQNResultModel();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandServerUsage createDemandServerUsage() {
		DemandServerUsageImpl demandServerUsage = new DemandServerUsageImpl();
		return demandServerUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DemandResult createDemandResult() {
		DemandResultImpl demandResult = new DemandResultImpl();
		return demandResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServerResult createServerResult() {
		ServerResultImpl serverResult = new ServerResultImpl();
		return serverResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerServerUsage createCustomerServerUsage() {
		CustomerServerUsageImpl customerServerUsage = new CustomerServerUsageImpl();
		return customerServerUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CustomerResult createCustomerResult() {
		CustomerResultImpl customerResult = new CustomerResultImpl();
		return customerResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNResultModel createQNResultModel() {
		QNResultModelImpl qnResultModel = new QNResultModelImpl();
		return qnResultModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNResultPackage getQNResultPackage() {
		return (QNResultPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static QNResultPackage getPackage() {
		return QNResultPackage.eINSTANCE;
	}

} //QNResultFactoryImpl

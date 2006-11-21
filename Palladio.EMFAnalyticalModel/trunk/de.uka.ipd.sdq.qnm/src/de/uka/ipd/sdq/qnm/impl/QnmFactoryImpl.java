/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.impl;

import de.uka.ipd.sdq.qnm.*;

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
			case QnmPackage.TASK: return createTask();
			case QnmPackage.SEQUENTIAL_RESOURCE_USAGE: return createSequentialResourceUsage();
			case QnmPackage.ALTERNATIVE_RESOURCE_USAGE: return createAlternativeResourceUsage();
			case QnmPackage.ITERATIVE_RESOURCE_USAGE: return createIterativeResourceUsage();
			case QnmPackage.PARALLEL_RESOURCE_USAGE: return createParallelResourceUsage();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
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
	public Task createTask() {
		TaskImpl task = new TaskImpl();
		return task;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SequentialResourceUsage createSequentialResourceUsage() {
		SequentialResourceUsageImpl sequentialResourceUsage = new SequentialResourceUsageImpl();
		return sequentialResourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AlternativeResourceUsage createAlternativeResourceUsage() {
		AlternativeResourceUsageImpl alternativeResourceUsage = new AlternativeResourceUsageImpl();
		return alternativeResourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterativeResourceUsage createIterativeResourceUsage() {
		IterativeResourceUsageImpl iterativeResourceUsage = new IterativeResourceUsageImpl();
		return iterativeResourceUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParallelResourceUsage createParallelResourceUsage() {
		ParallelResourceUsageImpl parallelResourceUsage = new ParallelResourceUsageImpl();
		return parallelResourceUsage;
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

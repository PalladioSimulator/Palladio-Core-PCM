/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.QNModel;

import de.uka.ipd.sdq.qnm.Task;

import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceResult;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResult;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>QNM Result Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getQnmodel <em>Qnmodel</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getResourceResults <em>Resource Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getTaskResults <em>Task Results</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getResourceUsageTimes <em>Resource Usage Times</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QNMResultModelImpl extends EObjectImpl implements QNMResultModel {
	/**
	 * The cached value of the '{@link #getQnmodel() <em>Qnmodel</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQnmodel()
	 * @generated
	 * @ordered
	 */
	protected QNModel qnmodel = null;

	/**
	 * The cached value of the '{@link #getResourceResults() <em>Resource Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceResults()
	 * @generated
	 * @ordered
	 */
	protected EList resourceResults = null;

	/**
	 * The cached value of the '{@link #getTaskResults() <em>Task Results</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskResults()
	 * @generated
	 * @ordered
	 */
	protected EList taskResults = null;

	/**
	 * The cached value of the '{@link #getTaskresourceusages() <em>Taskresourceusages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskresourceusages()
	 * @generated
	 * @ordered
	 */
	protected EList taskresourceusages = null;

	/**
	 * The cached value of the '{@link #getResourceUsageTimes() <em>Resource Usage Times</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResourceUsageTimes()
	 * @generated
	 * @ordered
	 */
	protected EList resourceUsageTimes = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected QNMResultModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultmodelPackage.Literals.QNM_RESULT_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNModel getQnmodel() {
		if (qnmodel != null && qnmodel.eIsProxy()) {
			InternalEObject oldQnmodel = (InternalEObject)qnmodel;
			qnmodel = (QNModel)eResolveProxy(oldQnmodel);
			if (qnmodel != oldQnmodel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL, oldQnmodel, qnmodel));
			}
		}
		return qnmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QNModel basicGetQnmodel() {
		return qnmodel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setQnmodel(QNModel newQnmodel) {
		QNModel oldQnmodel = qnmodel;
		qnmodel = newQnmodel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL, oldQnmodel, qnmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceResults() {
		if (resourceResults == null) {
			resourceResults = new EObjectContainmentEList(ResourceResult.class, this, ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS);
		}
		return resourceResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTaskResults() {
		if (taskResults == null) {
			taskResults = new EObjectContainmentEList(TaskResult.class, this, ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS);
		}
		return taskResults;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTaskresourceusages() {
		if (taskresourceusages == null) {
			taskresourceusages = new EObjectContainmentEList(TaskResourceUsage.class, this, ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES);
		}
		return taskresourceusages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceUsageTimes() {
		if (resourceUsageTimes == null) {
			resourceUsageTimes = new EObjectContainmentEList(ResourceUsageTime.class, this, ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES);
		}
		return resourceUsageTimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceUsageTime getTimeForResourceUsage(AbstractResourceUsage resourceUsage) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TaskResult getResultForTask(Task task) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceResult getResultForResource(Resource OwnedParameter1) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS:
				return ((InternalEList)getResourceResults()).basicRemove(otherEnd, msgs);
			case ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS:
				return ((InternalEList)getTaskResults()).basicRemove(otherEnd, msgs);
			case ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES:
				return ((InternalEList)getTaskresourceusages()).basicRemove(otherEnd, msgs);
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				return ((InternalEList)getResourceUsageTimes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL:
				if (resolve) return getQnmodel();
				return basicGetQnmodel();
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS:
				return getResourceResults();
			case ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS:
				return getTaskResults();
			case ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES:
				return getTaskresourceusages();
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				return getResourceUsageTimes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL:
				setQnmodel((QNModel)newValue);
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS:
				getResourceResults().clear();
				getResourceResults().addAll((Collection)newValue);
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS:
				getTaskResults().clear();
				getTaskResults().addAll((Collection)newValue);
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
				getTaskresourceusages().addAll((Collection)newValue);
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				getResourceUsageTimes().clear();
				getResourceUsageTimes().addAll((Collection)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL:
				setQnmodel((QNModel)null);
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS:
				getResourceResults().clear();
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS:
				getTaskResults().clear();
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
				return;
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				getResourceUsageTimes().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ResultmodelPackage.QNM_RESULT_MODEL__QNMODEL:
				return qnmodel != null;
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_RESULTS:
				return resourceResults != null && !resourceResults.isEmpty();
			case ResultmodelPackage.QNM_RESULT_MODEL__TASK_RESULTS:
				return taskResults != null && !taskResults.isEmpty();
			case ResultmodelPackage.QNM_RESULT_MODEL__TASKRESOURCEUSAGES:
				return taskresourceusages != null && !taskresourceusages.isEmpty();
			case ResultmodelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				return resourceUsageTimes != null && !resourceUsageTimes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QNMResultModelImpl
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.QNModel;

import de.uka.ipd.sdq.qnm.resultmodel.QNMResultModel;
import de.uka.ipd.sdq.qnm.resultmodel.ResourceUsageTime;
import de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage;
import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;

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
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.QNMResultModelImpl#getTaskResourceUsages <em>Task Resource Usages</em>}</li>
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
	 * The cached value of the '{@link #getTaskResourceUsages() <em>Task Resource Usages</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskResourceUsages()
	 * @generated
	 * @ordered
	 */
	protected EList taskResourceUsages = null;

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
		return ResultModelPackage.Literals.QNM_RESULT_MODEL;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultModelPackage.QNM_RESULT_MODEL__QNMODEL, oldQnmodel, qnmodel));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ResultModelPackage.QNM_RESULT_MODEL__QNMODEL, oldQnmodel, qnmodel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTaskResourceUsages() {
		if (taskResourceUsages == null) {
			taskResourceUsages = new EObjectContainmentEList(TaskResourceUsage.class, this, ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES);
		}
		return taskResourceUsages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getResourceUsageTimes() {
		if (resourceUsageTimes == null) {
			resourceUsageTimes = new EObjectContainmentEList(ResourceUsageTime.class, this, ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES);
		}
		return resourceUsageTimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES:
				return ((InternalEList)getTaskResourceUsages()).basicRemove(otherEnd, msgs);
			case ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
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
			case ResultModelPackage.QNM_RESULT_MODEL__QNMODEL:
				if (resolve) return getQnmodel();
				return basicGetQnmodel();
			case ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES:
				return getTaskResourceUsages();
			case ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
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
			case ResultModelPackage.QNM_RESULT_MODEL__QNMODEL:
				setQnmodel((QNModel)newValue);
				return;
			case ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES:
				getTaskResourceUsages().clear();
				getTaskResourceUsages().addAll((Collection)newValue);
				return;
			case ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
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
			case ResultModelPackage.QNM_RESULT_MODEL__QNMODEL:
				setQnmodel((QNModel)null);
				return;
			case ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES:
				getTaskResourceUsages().clear();
				return;
			case ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
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
			case ResultModelPackage.QNM_RESULT_MODEL__QNMODEL:
				return qnmodel != null;
			case ResultModelPackage.QNM_RESULT_MODEL__TASK_RESOURCE_USAGES:
				return taskResourceUsages != null && !taskResourceUsages.isEmpty();
			case ResultModelPackage.QNM_RESULT_MODEL__RESOURCE_USAGE_TIMES:
				return resourceUsageTimes != null && !resourceUsageTimes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //QNMResultModelImpl
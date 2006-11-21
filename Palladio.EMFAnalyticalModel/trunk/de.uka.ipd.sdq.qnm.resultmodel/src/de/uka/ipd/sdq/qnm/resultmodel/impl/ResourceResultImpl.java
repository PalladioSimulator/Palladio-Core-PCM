/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel.impl;

import de.uka.ipd.sdq.qnm.resultmodel.ResourceResult;
import de.uka.ipd.sdq.qnm.resultmodel.ResultmodelPackage;

import de.uka.ipd.sdq.qnm.resultmodel.TaskResourceUsage;

import de.uka.ipd.sdq.spa.resourcemodel.Resource;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl#getResource <em>Resource</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.resultmodel.impl.ResourceResultImpl#getTaskresourceusages <em>Taskresourceusages</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceResultImpl extends EObjectImpl implements ResourceResult {
	/**
	 * The cached value of the '{@link #getResource() <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResource()
	 * @generated
	 * @ordered
	 */
	protected Resource resource = null;

	/**
	 * The cached value of the '{@link #getTaskresourceusages() <em>Taskresourceusages</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTaskresourceusages()
	 * @generated
	 * @ordered
	 */
	protected EList taskresourceusages = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ResultmodelPackage.Literals.RESOURCE_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getResource() {
		if (resource != null && resource.eIsProxy()) {
			InternalEObject oldResource = (InternalEObject)resource;
			resource = (Resource)eResolveProxy(oldResource);
			if (resource != oldResource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultmodelPackage.RESOURCE_RESULT__RESOURCE, oldResource, resource));
			}
		}
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetResource() {
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResource(Resource newResource) {
		Resource oldResource = resource;
		resource = newResource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultmodelPackage.RESOURCE_RESULT__RESOURCE, oldResource, resource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getTaskresourceusages() {
		if (taskresourceusages == null) {
			taskresourceusages = new EObjectWithInverseResolvingEList(TaskResourceUsage.class, this, ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES, ResultmodelPackage.TASK_RESOURCE_USAGE__RESOURCE_RESULT);
		}
		return taskresourceusages;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				return ((InternalEList)getTaskresourceusages()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				return ((InternalEList)getTaskresourceusages()).basicRemove(otherEnd, msgs);
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
			case ResultmodelPackage.RESOURCE_RESULT__RESOURCE:
				if (resolve) return getResource();
				return basicGetResource();
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				return getTaskresourceusages();
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
			case ResultmodelPackage.RESOURCE_RESULT__RESOURCE:
				setResource((Resource)newValue);
				return;
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
				getTaskresourceusages().addAll((Collection)newValue);
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
			case ResultmodelPackage.RESOURCE_RESULT__RESOURCE:
				setResource((Resource)null);
				return;
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				getTaskresourceusages().clear();
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
			case ResultmodelPackage.RESOURCE_RESULT__RESOURCE:
				return resource != null;
			case ResultmodelPackage.RESOURCE_RESULT__TASKRESOURCEUSAGES:
				return taskresourceusages != null && !taskresourceusages.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ResourceResultImpl
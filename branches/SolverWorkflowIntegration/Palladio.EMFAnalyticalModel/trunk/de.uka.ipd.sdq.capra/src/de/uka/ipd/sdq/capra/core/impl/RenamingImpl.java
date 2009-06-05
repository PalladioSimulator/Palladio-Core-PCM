/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.Mapping;
import de.uka.ipd.sdq.capra.core.Renaming;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Renaming</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.RenamingImpl#getRenamedProcess <em>Renamed Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.RenamingImpl#getMapping <em>Mapping</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RenamingImpl extends OperatorImpl implements Renaming {
	/**
	 * The cached value of the '{@link #getRenamedProcess() <em>Renamed Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRenamedProcess()
	 * @generated
	 * @ordered
	 */
	protected CapraExpression renamedProcess;

	/**
	 * The cached value of the '{@link #getMapping() <em>Mapping</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMapping()
	 * @generated
	 * @ordered
	 */
	protected EList<Mapping> mapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RenamingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.RENAMING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapraExpression getRenamedProcess() {
		return renamedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRenamedProcess(CapraExpression newRenamedProcess, NotificationChain msgs) {
		CapraExpression oldRenamedProcess = renamedProcess;
		renamedProcess = newRenamedProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.RENAMING__RENAMED_PROCESS, oldRenamedProcess, newRenamedProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRenamedProcess(CapraExpression newRenamedProcess) {
		if (newRenamedProcess != renamedProcess) {
			NotificationChain msgs = null;
			if (renamedProcess != null)
				msgs = ((InternalEObject)renamedProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.RENAMING__RENAMED_PROCESS, null, msgs);
			if (newRenamedProcess != null)
				msgs = ((InternalEObject)newRenamedProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.RENAMING__RENAMED_PROCESS, null, msgs);
			msgs = basicSetRenamedProcess(newRenamedProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RENAMING__RENAMED_PROCESS, newRenamedProcess, newRenamedProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mapping> getMapping() {
		if (mapping == null) {
			mapping = new EObjectContainmentEList<Mapping>(Mapping.class, this, CorePackage.RENAMING__MAPPING);
		}
		return mapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.RENAMING__RENAMED_PROCESS:
				return basicSetRenamedProcess(null, msgs);
			case CorePackage.RENAMING__MAPPING:
				return ((InternalEList<?>)getMapping()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CorePackage.RENAMING__RENAMED_PROCESS:
				return getRenamedProcess();
			case CorePackage.RENAMING__MAPPING:
				return getMapping();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CorePackage.RENAMING__RENAMED_PROCESS:
				setRenamedProcess((CapraExpression)newValue);
				return;
			case CorePackage.RENAMING__MAPPING:
				getMapping().clear();
				getMapping().addAll((Collection<? extends Mapping>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CorePackage.RENAMING__RENAMED_PROCESS:
				setRenamedProcess((CapraExpression)null);
				return;
			case CorePackage.RENAMING__MAPPING:
				getMapping().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CorePackage.RENAMING__RENAMED_PROCESS:
				return renamedProcess != null;
			case CorePackage.RENAMING__MAPPING:
				return mapping != null && !mapping.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RenamingImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core.impl;

import de.uka.ipd.sdq.capra.core.CapraExpression;
import de.uka.ipd.sdq.capra.core.CommunicationIdentifier;
import de.uka.ipd.sdq.capra.core.CorePackage;
import de.uka.ipd.sdq.capra.core.Restriction;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Restriction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.RestrictionImpl#getRestrictedProcess <em>Restricted Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.impl.RestrictionImpl#getRestrictedIdentifiers <em>Restricted Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RestrictionImpl extends OperatorImpl implements Restriction {
	/**
	 * The cached value of the '{@link #getRestrictedProcess() <em>Restricted Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedProcess()
	 * @generated
	 * @ordered
	 */
	protected CapraExpression restrictedProcess;

	/**
	 * The cached value of the '{@link #getRestrictedIdentifiers() <em>Restricted Identifiers</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRestrictedIdentifiers()
	 * @generated
	 * @ordered
	 */
	protected EList<CommunicationIdentifier> restrictedIdentifiers;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RestrictionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CorePackage.Literals.RESTRICTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapraExpression getRestrictedProcess() {
		return restrictedProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRestrictedProcess(CapraExpression newRestrictedProcess, NotificationChain msgs) {
		CapraExpression oldRestrictedProcess = restrictedProcess;
		restrictedProcess = newRestrictedProcess;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CorePackage.RESTRICTION__RESTRICTED_PROCESS, oldRestrictedProcess, newRestrictedProcess);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRestrictedProcess(CapraExpression newRestrictedProcess) {
		if (newRestrictedProcess != restrictedProcess) {
			NotificationChain msgs = null;
			if (restrictedProcess != null)
				msgs = ((InternalEObject)restrictedProcess).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CorePackage.RESTRICTION__RESTRICTED_PROCESS, null, msgs);
			if (newRestrictedProcess != null)
				msgs = ((InternalEObject)newRestrictedProcess).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - CorePackage.RESTRICTION__RESTRICTED_PROCESS, null, msgs);
			msgs = basicSetRestrictedProcess(newRestrictedProcess, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CorePackage.RESTRICTION__RESTRICTED_PROCESS, newRestrictedProcess, newRestrictedProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CommunicationIdentifier> getRestrictedIdentifiers() {
		if (restrictedIdentifiers == null) {
			restrictedIdentifiers = new EObjectResolvingEList<CommunicationIdentifier>(CommunicationIdentifier.class, this, CorePackage.RESTRICTION__RESTRICTED_IDENTIFIERS);
		}
		return restrictedIdentifiers;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CorePackage.RESTRICTION__RESTRICTED_PROCESS:
				return basicSetRestrictedProcess(null, msgs);
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
			case CorePackage.RESTRICTION__RESTRICTED_PROCESS:
				return getRestrictedProcess();
			case CorePackage.RESTRICTION__RESTRICTED_IDENTIFIERS:
				return getRestrictedIdentifiers();
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
			case CorePackage.RESTRICTION__RESTRICTED_PROCESS:
				setRestrictedProcess((CapraExpression)newValue);
				return;
			case CorePackage.RESTRICTION__RESTRICTED_IDENTIFIERS:
				getRestrictedIdentifiers().clear();
				getRestrictedIdentifiers().addAll((Collection<? extends CommunicationIdentifier>)newValue);
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
			case CorePackage.RESTRICTION__RESTRICTED_PROCESS:
				setRestrictedProcess((CapraExpression)null);
				return;
			case CorePackage.RESTRICTION__RESTRICTED_IDENTIFIERS:
				getRestrictedIdentifiers().clear();
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
			case CorePackage.RESTRICTION__RESTRICTED_PROCESS:
				return restrictedProcess != null;
			case CorePackage.RESTRICTION__RESTRICTED_IDENTIFIERS:
				return restrictedIdentifiers != null && !restrictedIdentifiers.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //RestrictionImpl

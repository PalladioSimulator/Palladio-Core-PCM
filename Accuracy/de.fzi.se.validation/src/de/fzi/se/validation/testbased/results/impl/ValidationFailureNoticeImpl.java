/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results.impl;

import de.fzi.se.validation.testbased.results.ResultsPackage;
import de.fzi.se.validation.testbased.results.RunProtocol;
import de.fzi.se.validation.testbased.results.ValidationFailureNotice;

import de.fzi.se.validation.testbased.trace.TraceAction;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Validation Failure Notice</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl#getRunProtocol <em>Run Protocol</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl#getExpected <em>Expected</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ValidationFailureNoticeImpl extends IdentifierImpl implements ValidationFailureNotice {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExpected() <em>Expected</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExpected()
	 * @generated
	 * @ordered
	 */
	protected TraceAction expected;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidationFailureNoticeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ResultsPackage.Literals.VALIDATION_FAILURE_NOTICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.VALIDATION_FAILURE_NOTICE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RunProtocol getRunProtocol() {
		if (eContainerFeatureID() != ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL) return null;
		return (RunProtocol)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRunProtocol(RunProtocol newRunProtocol, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRunProtocol, ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRunProtocol(RunProtocol newRunProtocol) {
		if (newRunProtocol != eInternalContainer() || (eContainerFeatureID() != ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL && newRunProtocol != null)) {
			if (EcoreUtil.isAncestor(this, newRunProtocol))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRunProtocol != null)
				msgs = ((InternalEObject)newRunProtocol).eInverseAdd(this, ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES, RunProtocol.class, msgs);
			msgs = basicSetRunProtocol(newRunProtocol, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL, newRunProtocol, newRunProtocol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceAction getExpected() {
		if (expected != null && expected.eIsProxy()) {
			InternalEObject oldExpected = (InternalEObject)expected;
			expected = (TraceAction)eResolveProxy(oldExpected);
			if (expected != oldExpected) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED, oldExpected, expected));
			}
		}
		return expected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceAction basicGetExpected() {
		return expected;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExpected(TraceAction newExpected) {
		TraceAction oldExpected = expected;
		expected = newExpected;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED, oldExpected, expected));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRunProtocol((RunProtocol)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				return basicSetRunProtocol(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				return eInternalContainer().eInverseRemove(this, ResultsPackage.RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES, RunProtocol.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__DESCRIPTION:
				return getDescription();
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				return getRunProtocol();
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED:
				if (resolve) return getExpected();
				return basicGetExpected();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				setRunProtocol((RunProtocol)newValue);
				return;
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED:
				setExpected((TraceAction)newValue);
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
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				setRunProtocol((RunProtocol)null);
				return;
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED:
				setExpected((TraceAction)null);
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
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL:
				return getRunProtocol() != null;
			case ResultsPackage.VALIDATION_FAILURE_NOTICE__EXPECTED:
				return expected != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //ValidationFailureNoticeImpl

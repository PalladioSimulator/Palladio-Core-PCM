/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.qualityannotation.impl;

import de.fzi.se.quality.qualityannotation.Precision;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;
import de.fzi.se.quality.qualityannotation.RequiredElement;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>RE Precision</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getDefaultPrecisionNumberOfCalls <em>Default Precision Number Of Calls</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getDefaultPrecisionCallParameter <em>Default Precision Call Parameter</em>}</li>
 *   <li>{@link de.fzi.se.quality.qualityannotation.impl.REPrecisionImpl#getRequiredElement <em>Required Element</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class REPrecisionImpl extends IdentifierImpl implements REPrecision {
	/**
	 * The cached value of the '{@link #getDefaultPrecisionNumberOfCalls() <em>Default Precision Number Of Calls</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPrecisionNumberOfCalls()
	 * @generated
	 * @ordered
	 */
	protected Precision defaultPrecisionNumberOfCalls;

	/**
	 * The cached value of the '{@link #getDefaultPrecisionCallParameter() <em>Default Precision Call Parameter</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultPrecisionCallParameter()
	 * @generated
	 * @ordered
	 */
	protected Precision defaultPrecisionCallParameter;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected REPrecisionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return QualityAnnotationPackage.Literals.RE_PRECISION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precision getDefaultPrecisionNumberOfCalls() {
		return defaultPrecisionNumberOfCalls;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultPrecisionNumberOfCalls(Precision newDefaultPrecisionNumberOfCalls, NotificationChain msgs) {
		Precision oldDefaultPrecisionNumberOfCalls = defaultPrecisionNumberOfCalls;
		defaultPrecisionNumberOfCalls = newDefaultPrecisionNumberOfCalls;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, oldDefaultPrecisionNumberOfCalls, newDefaultPrecisionNumberOfCalls);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultPrecisionNumberOfCalls(Precision newDefaultPrecisionNumberOfCalls) {
		if (newDefaultPrecisionNumberOfCalls != defaultPrecisionNumberOfCalls) {
			NotificationChain msgs = null;
			if (defaultPrecisionNumberOfCalls != null)
				msgs = ((InternalEObject)defaultPrecisionNumberOfCalls).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, null, msgs);
			if (newDefaultPrecisionNumberOfCalls != null)
				msgs = ((InternalEObject)newDefaultPrecisionNumberOfCalls).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, null, msgs);
			msgs = basicSetDefaultPrecisionNumberOfCalls(newDefaultPrecisionNumberOfCalls, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS, newDefaultPrecisionNumberOfCalls, newDefaultPrecisionNumberOfCalls));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Precision getDefaultPrecisionCallParameter() {
		return defaultPrecisionCallParameter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultPrecisionCallParameter(Precision newDefaultPrecisionCallParameter, NotificationChain msgs) {
		Precision oldDefaultPrecisionCallParameter = defaultPrecisionCallParameter;
		defaultPrecisionCallParameter = newDefaultPrecisionCallParameter;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, oldDefaultPrecisionCallParameter, newDefaultPrecisionCallParameter);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultPrecisionCallParameter(Precision newDefaultPrecisionCallParameter) {
		if (newDefaultPrecisionCallParameter != defaultPrecisionCallParameter) {
			NotificationChain msgs = null;
			if (defaultPrecisionCallParameter != null)
				msgs = ((InternalEObject)defaultPrecisionCallParameter).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, null, msgs);
			if (newDefaultPrecisionCallParameter != null)
				msgs = ((InternalEObject)newDefaultPrecisionCallParameter).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, null, msgs);
			msgs = basicSetDefaultPrecisionCallParameter(newDefaultPrecisionCallParameter, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER, newDefaultPrecisionCallParameter, newDefaultPrecisionCallParameter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequiredElement getRequiredElement() {
		if (eContainerFeatureID() != QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT) return null;
		return (RequiredElement)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredElement(RequiredElement newRequiredElement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newRequiredElement, QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredElement(RequiredElement newRequiredElement) {
		if (newRequiredElement != eInternalContainer() || (eContainerFeatureID() != QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT && newRequiredElement != null)) {
			if (EcoreUtil.isAncestor(this, newRequiredElement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequiredElement != null)
				msgs = ((InternalEObject)newRequiredElement).eInverseAdd(this, QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION, RequiredElement.class, msgs);
			msgs = basicSetRequiredElement(newRequiredElement, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT, newRequiredElement, newRequiredElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequiredElement((RequiredElement)otherEnd, msgs);
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
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				return basicSetDefaultPrecisionNumberOfCalls(null, msgs);
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
				return basicSetDefaultPrecisionCallParameter(null, msgs);
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				return basicSetRequiredElement(null, msgs);
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
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.REQUIRED_ELEMENT__PRECISION, RequiredElement.class, msgs);
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
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				return getDefaultPrecisionNumberOfCalls();
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
				return getDefaultPrecisionCallParameter();
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				return getRequiredElement();
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
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				setDefaultPrecisionNumberOfCalls((Precision)newValue);
				return;
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
				setDefaultPrecisionCallParameter((Precision)newValue);
				return;
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				setRequiredElement((RequiredElement)newValue);
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
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				setDefaultPrecisionNumberOfCalls((Precision)null);
				return;
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
				setDefaultPrecisionCallParameter((Precision)null);
				return;
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				setRequiredElement((RequiredElement)null);
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
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				return defaultPrecisionNumberOfCalls != null;
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
				return defaultPrecisionCallParameter != null;
			case QualityAnnotationPackage.RE_PRECISION__REQUIRED_ELEMENT:
				return getRequiredElement() != null;
		}
		return super.eIsSet(featureID);
	}

} //REPrecisionImpl

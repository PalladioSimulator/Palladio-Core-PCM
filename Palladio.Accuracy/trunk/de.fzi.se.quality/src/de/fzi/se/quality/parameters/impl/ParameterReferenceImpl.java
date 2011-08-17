/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import de.fzi.se.quality.parameters.ParameterInstance;
import de.fzi.se.quality.parameters.ParameterReference;
import de.fzi.se.quality.parameters.ParametersPackage;

import de.fzi.se.quality.qualityannotation.CallParameterDeviation;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getParameterInstance <em>Parameter Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.impl.ParameterReferenceImpl#getCallParameterDeviation <em>Call Parameter Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ParameterReferenceImpl extends IdentifierImpl implements ParameterReference {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterReferenceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ParametersPackage.Literals.PARAMETER_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterInstance getParameterInstance() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE) return null;
		return (ParameterInstance)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameterInstance(ParameterInstance newParameterInstance, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParameterInstance, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterInstance(ParameterInstance newParameterInstance) {
		if (newParameterInstance != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE && newParameterInstance != null)) {
			if (EcoreUtil.isAncestor(this, newParameterInstance))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParameterInstance != null)
				msgs = ((InternalEObject)newParameterInstance).eInverseAdd(this, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
			msgs = basicSetParameterInstance(newParameterInstance, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE, newParameterInstance, newParameterInstance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallParameterDeviation getCallParameterDeviation() {
		if (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION) return null;
		return (CallParameterDeviation)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCallParameterDeviation(CallParameterDeviation newCallParameterDeviation, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newCallParameterDeviation, ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCallParameterDeviation(CallParameterDeviation newCallParameterDeviation) {
		if (newCallParameterDeviation != eInternalContainer() || (eContainerFeatureID() != ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION && newCallParameterDeviation != null)) {
			if (EcoreUtil.isAncestor(this, newCallParameterDeviation))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCallParameterDeviation != null)
				msgs = ((InternalEObject)newCallParameterDeviation).eInverseAdd(this, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE, CallParameterDeviation.class, msgs);
			msgs = basicSetCallParameterDeviation(newCallParameterDeviation, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION, newCallParameterDeviation, newCallParameterDeviation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParameterInstance((ParameterInstance)otherEnd, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCallParameterDeviation((CallParameterDeviation)otherEnd, msgs);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return basicSetParameterInstance(null, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				return basicSetCallParameterDeviation(null, msgs);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return eInternalContainer().eInverseRemove(this, ParametersPackage.PARAMETER_INSTANCE__PARAMETER_REFERENCE, ParameterInstance.class, msgs);
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				return eInternalContainer().eInverseRemove(this, QualityAnnotationPackage.CALL_PARAMETER_DEVIATION__PARAMETER_REFERENCE, CallParameterDeviation.class, msgs);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return getParameterInstance();
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				return getCallParameterDeviation();
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				setParameterInstance((ParameterInstance)newValue);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				setCallParameterDeviation((CallParameterDeviation)newValue);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				setParameterInstance((ParameterInstance)null);
				return;
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				setCallParameterDeviation((CallParameterDeviation)null);
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
			case ParametersPackage.PARAMETER_REFERENCE__PARAMETER_INSTANCE:
				return getParameterInstance() != null;
			case ParametersPackage.PARAMETER_REFERENCE__CALL_PARAMETER_DEVIATION:
				return getCallParameterDeviation() != null;
		}
		return super.eIsSet(featureID);
	}

} //ParameterReferenceImpl

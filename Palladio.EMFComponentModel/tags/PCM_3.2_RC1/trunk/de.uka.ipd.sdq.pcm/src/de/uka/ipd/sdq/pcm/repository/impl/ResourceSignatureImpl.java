/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceSignature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceSignatureImpl#getParameter__ResourceSignature <em>Parameter Resource Signature</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceSignatureImpl extends SignatureImpl implements ResourceSignature {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getParameter__ResourceSignature() <em>Parameter Resource Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameter__ResourceSignature()
	 * @generated
	 * @ordered
	 */
	protected Parameter parameter__ResourceSignature;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ResourceSignatureImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RepositoryPackage.Literals.RESOURCE_SIGNATURE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Parameter getParameter__ResourceSignature() {
		return parameter__ResourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter__ResourceSignature(Parameter newParameter__ResourceSignature, NotificationChain msgs) {
		Parameter oldParameter__ResourceSignature = parameter__ResourceSignature;
		parameter__ResourceSignature = newParameter__ResourceSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, oldParameter__ResourceSignature, newParameter__ResourceSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameter__ResourceSignature(Parameter newParameter__ResourceSignature) {
		if (newParameter__ResourceSignature != parameter__ResourceSignature) {
			NotificationChain msgs = null;
			if (parameter__ResourceSignature != null)
				msgs = ((InternalEObject)parameter__ResourceSignature).eInverseRemove(this, RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER, Parameter.class, msgs);
			if (newParameter__ResourceSignature != null)
				msgs = ((InternalEObject)newParameter__ResourceSignature).eInverseAdd(this, RepositoryPackage.PARAMETER__RESOURCE_SIGNATURE_PARAMETER, Parameter.class, msgs);
			msgs = basicSetParameter__ResourceSignature(newParameter__ResourceSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, newParameter__ResourceSignature, newParameter__ResourceSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				if (parameter__ResourceSignature != null)
					msgs = ((InternalEObject)parameter__ResourceSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, null, msgs);
				return basicSetParameter__ResourceSignature((Parameter)otherEnd, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				return basicSetParameter__ResourceSignature(null, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				return getParameter__ResourceSignature();
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				setParameter__ResourceSignature((Parameter)newValue);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				setParameter__ResourceSignature((Parameter)null);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				return parameter__ResourceSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceSignatureImpl

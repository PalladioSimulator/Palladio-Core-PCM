/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceInterface;
import de.uka.ipd.sdq.pcm.repository.ResourceSignature;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceSignatureImpl#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceSignatureImpl#getParmeter__ResourceSignature <em>Parmeter Resource Signature</em>}</li>
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
	 * The cached value of the '{@link #getParmeter__ResourceSignature() <em>Parmeter Resource Signature</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParmeter__ResourceSignature()
	 * @generated
	 * @ordered
	 */
	protected Variable parmeter__ResourceSignature;

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
	public ResourceInterface getResourceInterface__ResourceSignature() {
		if (eContainerFeatureID() != RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE) return null;
		return (ResourceInterface)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResourceInterface__ResourceSignature(ResourceInterface newResourceInterface__ResourceSignature, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newResourceInterface__ResourceSignature, RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResourceInterface__ResourceSignature(ResourceInterface newResourceInterface__ResourceSignature) {
		if (newResourceInterface__ResourceSignature != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE && newResourceInterface__ResourceSignature != null)) {
			if (EcoreUtil.isAncestor(this, newResourceInterface__ResourceSignature))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newResourceInterface__ResourceSignature != null)
				msgs = ((InternalEObject)newResourceInterface__ResourceSignature).eInverseAdd(this, RepositoryPackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE, ResourceInterface.class, msgs);
			msgs = basicSetResourceInterface__ResourceSignature(newResourceInterface__ResourceSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE, newResourceInterface__ResourceSignature, newResourceInterface__ResourceSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Variable getParmeter__ResourceSignature() {
		return parmeter__ResourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParmeter__ResourceSignature(Variable newParmeter__ResourceSignature, NotificationChain msgs) {
		Variable oldParmeter__ResourceSignature = parmeter__ResourceSignature;
		parmeter__ResourceSignature = newParmeter__ResourceSignature;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE, oldParmeter__ResourceSignature, newParmeter__ResourceSignature);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParmeter__ResourceSignature(Variable newParmeter__ResourceSignature) {
		if (newParmeter__ResourceSignature != parmeter__ResourceSignature) {
			NotificationChain msgs = null;
			if (parmeter__ResourceSignature != null)
				msgs = ((InternalEObject)parmeter__ResourceSignature).eInverseRemove(this, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, Variable.class, msgs);
			if (newParmeter__ResourceSignature != null)
				msgs = ((InternalEObject)newParmeter__ResourceSignature).eInverseAdd(this, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, Variable.class, msgs);
			msgs = basicSetParmeter__ResourceSignature(newParmeter__ResourceSignature, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE, newParmeter__ResourceSignature, newParmeter__ResourceSignature));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceInterface__ResourceSignature((ResourceInterface)otherEnd, msgs);
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				if (parmeter__ResourceSignature != null)
					msgs = ((InternalEObject)parmeter__ResourceSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE, null, msgs);
				return basicSetParmeter__ResourceSignature((Variable)otherEnd, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				return basicSetResourceInterface__ResourceSignature(null, msgs);
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				return basicSetParmeter__ResourceSignature(null, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				return eInternalContainer().eInverseRemove(this, RepositoryPackage.RESOURCE_INTERFACE__RESOURCE_SIGNATURES_RESOURCE_INTERFACE, ResourceInterface.class, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				return getResourceInterface__ResourceSignature();
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				return getParmeter__ResourceSignature();
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				setResourceInterface__ResourceSignature((ResourceInterface)newValue);
				return;
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				setParmeter__ResourceSignature((Variable)newValue);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				setResourceInterface__ResourceSignature((ResourceInterface)null);
				return;
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				setParmeter__ResourceSignature((Variable)null);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				return getResourceInterface__ResourceSignature() != null;
			case RepositoryPackage.RESOURCE_SIGNATURE__PARMETER_RESOURCE_SIGNATURE:
				return parmeter__ResourceSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceSignatureImpl

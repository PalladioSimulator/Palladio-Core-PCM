/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.ResourceInterface;
import de.uka.ipd.sdq.pcm.repository.ResourceSignature;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Resource Signature</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.ResourceSignatureImpl#getResourceInterface__ResourceSignature <em>Resource Interface Resource Signature</em>}</li>
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
	protected Variable parameter__ResourceSignature;

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
	public Variable getParameter__ResourceSignature() {
		return parameter__ResourceSignature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParameter__ResourceSignature(Variable newParameter__ResourceSignature, NotificationChain msgs) {
		Variable oldParameter__ResourceSignature = parameter__ResourceSignature;
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
	public void setParameter__ResourceSignature(Variable newParameter__ResourceSignature) {
		if (newParameter__ResourceSignature != parameter__ResourceSignature) {
			NotificationChain msgs = null;
			if (parameter__ResourceSignature != null)
				msgs = ((InternalEObject)parameter__ResourceSignature).eInverseRemove(this, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, Variable.class, msgs);
			if (newParameter__ResourceSignature != null)
				msgs = ((InternalEObject)newParameter__ResourceSignature).eInverseAdd(this, ParameterPackage.VARIABLE__RESOURCE_SIGNATURE_VARIABLE, Variable.class, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetResourceInterface__ResourceSignature((ResourceInterface)otherEnd, msgs);
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				if (parameter__ResourceSignature != null)
					msgs = ((InternalEObject)parameter__ResourceSignature).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE, null, msgs);
				return basicSetParameter__ResourceSignature((Variable)otherEnd, msgs);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__RESOURCE_INTERFACE_RESOURCE_SIGNATURE:
				setResourceInterface__ResourceSignature((ResourceInterface)newValue);
				return;
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				setParameter__ResourceSignature((Variable)newValue);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				setParameter__ResourceSignature((Variable)null);
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
			case RepositoryPackage.RESOURCE_SIGNATURE__PARAMETER_RESOURCE_SIGNATURE:
				return parameter__ResourceSignature != null;
		}
		return super.eIsSet(featureID);
	}

} //ResourceSignatureImpl

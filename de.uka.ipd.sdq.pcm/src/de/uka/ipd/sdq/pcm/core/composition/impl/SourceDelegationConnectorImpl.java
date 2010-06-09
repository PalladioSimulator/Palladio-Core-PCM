/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.SourceDelegationConnector;

import de.uka.ipd.sdq.pcm.repository.SourceRole;

import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Source Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getInnerSourceRole__SourceDelegationConnector <em>Inner Source Role Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getOuterSourceRole__SourceDelegationConnector <em>Outer Source Role Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getAssemblyContext__SourceDelegationConnector <em>Assembly Context Source Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SourceDelegationConnectorImpl#getParentStructure_SourceDelegationConnector <em>Parent Structure Source Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SourceDelegationConnectorImpl extends DelegationConnectorImpl implements SourceDelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getInnerSourceRole__SourceDelegationConnector() <em>Inner Source Role Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerSourceRole__SourceDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SourceRole innerSourceRole__SourceDelegationConnector;

	/**
	 * The cached value of the '{@link #getOuterSourceRole__SourceDelegationConnector() <em>Outer Source Role Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterSourceRole__SourceDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SourceRole outerSourceRole__SourceDelegationConnector;

	/**
	 * The cached value of the '{@link #getAssemblyContext__SourceDelegationConnector() <em>Assembly Context Source Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext__SourceDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext__SourceDelegationConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SourceDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.SOURCE_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole getInnerSourceRole__SourceDelegationConnector() {
		if (innerSourceRole__SourceDelegationConnector != null && innerSourceRole__SourceDelegationConnector.eIsProxy()) {
			InternalEObject oldInnerSourceRole__SourceDelegationConnector = (InternalEObject)innerSourceRole__SourceDelegationConnector;
			innerSourceRole__SourceDelegationConnector = (SourceRole)eResolveProxy(oldInnerSourceRole__SourceDelegationConnector);
			if (innerSourceRole__SourceDelegationConnector != oldInnerSourceRole__SourceDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR, oldInnerSourceRole__SourceDelegationConnector, innerSourceRole__SourceDelegationConnector));
			}
		}
		return innerSourceRole__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole basicGetInnerSourceRole__SourceDelegationConnector() {
		return innerSourceRole__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerSourceRole__SourceDelegationConnector(SourceRole newInnerSourceRole__SourceDelegationConnector) {
		SourceRole oldInnerSourceRole__SourceDelegationConnector = innerSourceRole__SourceDelegationConnector;
		innerSourceRole__SourceDelegationConnector = newInnerSourceRole__SourceDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR, oldInnerSourceRole__SourceDelegationConnector, innerSourceRole__SourceDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole getOuterSourceRole__SourceDelegationConnector() {
		if (outerSourceRole__SourceDelegationConnector != null && outerSourceRole__SourceDelegationConnector.eIsProxy()) {
			InternalEObject oldOuterSourceRole__SourceDelegationConnector = (InternalEObject)outerSourceRole__SourceDelegationConnector;
			outerSourceRole__SourceDelegationConnector = (SourceRole)eResolveProxy(oldOuterSourceRole__SourceDelegationConnector);
			if (outerSourceRole__SourceDelegationConnector != oldOuterSourceRole__SourceDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR, oldOuterSourceRole__SourceDelegationConnector, outerSourceRole__SourceDelegationConnector));
			}
		}
		return outerSourceRole__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole basicGetOuterSourceRole__SourceDelegationConnector() {
		return outerSourceRole__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterSourceRole__SourceDelegationConnector(SourceRole newOuterSourceRole__SourceDelegationConnector) {
		SourceRole oldOuterSourceRole__SourceDelegationConnector = outerSourceRole__SourceDelegationConnector;
		outerSourceRole__SourceDelegationConnector = newOuterSourceRole__SourceDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR, oldOuterSourceRole__SourceDelegationConnector, outerSourceRole__SourceDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext__SourceDelegationConnector() {
		if (assemblyContext__SourceDelegationConnector != null && assemblyContext__SourceDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext__SourceDelegationConnector = (InternalEObject)assemblyContext__SourceDelegationConnector;
			assemblyContext__SourceDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext__SourceDelegationConnector);
			if (assemblyContext__SourceDelegationConnector != oldAssemblyContext__SourceDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR, oldAssemblyContext__SourceDelegationConnector, assemblyContext__SourceDelegationConnector));
			}
		}
		return assemblyContext__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext__SourceDelegationConnector() {
		return assemblyContext__SourceDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext__SourceDelegationConnector(AssemblyContext newAssemblyContext__SourceDelegationConnector) {
		AssemblyContext oldAssemblyContext__SourceDelegationConnector = assemblyContext__SourceDelegationConnector;
		assemblyContext__SourceDelegationConnector = newAssemblyContext__SourceDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR, oldAssemblyContext__SourceDelegationConnector, assemblyContext__SourceDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_SourceDelegationConnector() {
		if (eContainerFeatureID() != CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_SourceDelegationConnector(ComposedStructure newParentStructure_SourceDelegationConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_SourceDelegationConnector, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_SourceDelegationConnector(ComposedStructure newParentStructure_SourceDelegationConnector) {
		if (newParentStructure_SourceDelegationConnector != eInternalContainer() || (eContainerFeatureID() != CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR && newParentStructure_SourceDelegationConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_SourceDelegationConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_SourceDelegationConnector != null)
				msgs = ((InternalEObject)newParentStructure_SourceDelegationConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_SourceDelegationConnector(newParentStructure_SourceDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR, newParentStructure_SourceDelegationConnector, newParentStructure_SourceDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_SourceDelegationConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				return basicSetParentStructure_SourceDelegationConnector(null, msgs);
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__SOURCE_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				if (resolve) return getInnerSourceRole__SourceDelegationConnector();
				return basicGetInnerSourceRole__SourceDelegationConnector();
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				if (resolve) return getOuterSourceRole__SourceDelegationConnector();
				return basicGetOuterSourceRole__SourceDelegationConnector();
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext__SourceDelegationConnector();
				return basicGetAssemblyContext__SourceDelegationConnector();
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				return getParentStructure_SourceDelegationConnector();
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				setInnerSourceRole__SourceDelegationConnector((SourceRole)newValue);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				setOuterSourceRole__SourceDelegationConnector((SourceRole)newValue);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
				setAssemblyContext__SourceDelegationConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				setParentStructure_SourceDelegationConnector((ComposedStructure)newValue);
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				setInnerSourceRole__SourceDelegationConnector((SourceRole)null);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				setOuterSourceRole__SourceDelegationConnector((SourceRole)null);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
				setAssemblyContext__SourceDelegationConnector((AssemblyContext)null);
				return;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				setParentStructure_SourceDelegationConnector((ComposedStructure)null);
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
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__INNER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				return innerSourceRole__SourceDelegationConnector != null;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__OUTER_SOURCE_ROLE_SOURCE_DELEGATION_CONNECTOR:
				return outerSourceRole__SourceDelegationConnector != null;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SOURCE_DELEGATION_CONNECTOR:
				return assemblyContext__SourceDelegationConnector != null;
			case CompositionPackage.SOURCE_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SOURCE_DELEGATION_CONNECTOR:
				return getParentStructure_SourceDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //SourceDelegationConnectorImpl

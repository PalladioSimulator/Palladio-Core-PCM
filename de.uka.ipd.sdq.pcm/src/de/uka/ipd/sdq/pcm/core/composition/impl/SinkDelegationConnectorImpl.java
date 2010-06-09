/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.SinkDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.impl.DelegationConnectorImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sink Delegation Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getInnerSinkRole__SinkDelegationConnector <em>Inner Sink Role Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getOuterSinkRole__SinkDelegationConnector <em>Outer Sink Role Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getAssemblyContext__SinkDelegationConnector <em>Assembly Context Sink Delegation Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.SinkDelegationConnectorImpl#getParentStructure_SinkDelegationConnector <em>Parent Structure Sink Delegation Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SinkDelegationConnectorImpl extends DelegationConnectorImpl implements SinkDelegationConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getInnerSinkRole__SinkDelegationConnector() <em>Inner Sink Role Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInnerSinkRole__SinkDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SinkRole innerSinkRole__SinkDelegationConnector;

	/**
	 * The cached value of the '{@link #getOuterSinkRole__SinkDelegationConnector() <em>Outer Sink Role Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOuterSinkRole__SinkDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected SinkRole outerSinkRole__SinkDelegationConnector;

	/**
	 * The cached value of the '{@link #getAssemblyContext__SinkDelegationConnector() <em>Assembly Context Sink Delegation Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext__SinkDelegationConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext__SinkDelegationConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SinkDelegationConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.SINK_DELEGATION_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkRole getInnerSinkRole__SinkDelegationConnector() {
		if (innerSinkRole__SinkDelegationConnector != null && innerSinkRole__SinkDelegationConnector.eIsProxy()) {
			InternalEObject oldInnerSinkRole__SinkDelegationConnector = (InternalEObject)innerSinkRole__SinkDelegationConnector;
			innerSinkRole__SinkDelegationConnector = (SinkRole)eResolveProxy(oldInnerSinkRole__SinkDelegationConnector);
			if (innerSinkRole__SinkDelegationConnector != oldInnerSinkRole__SinkDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR, oldInnerSinkRole__SinkDelegationConnector, innerSinkRole__SinkDelegationConnector));
			}
		}
		return innerSinkRole__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkRole basicGetInnerSinkRole__SinkDelegationConnector() {
		return innerSinkRole__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInnerSinkRole__SinkDelegationConnector(SinkRole newInnerSinkRole__SinkDelegationConnector) {
		SinkRole oldInnerSinkRole__SinkDelegationConnector = innerSinkRole__SinkDelegationConnector;
		innerSinkRole__SinkDelegationConnector = newInnerSinkRole__SinkDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR, oldInnerSinkRole__SinkDelegationConnector, innerSinkRole__SinkDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkRole getOuterSinkRole__SinkDelegationConnector() {
		if (outerSinkRole__SinkDelegationConnector != null && outerSinkRole__SinkDelegationConnector.eIsProxy()) {
			InternalEObject oldOuterSinkRole__SinkDelegationConnector = (InternalEObject)outerSinkRole__SinkDelegationConnector;
			outerSinkRole__SinkDelegationConnector = (SinkRole)eResolveProxy(oldOuterSinkRole__SinkDelegationConnector);
			if (outerSinkRole__SinkDelegationConnector != oldOuterSinkRole__SinkDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR, oldOuterSinkRole__SinkDelegationConnector, outerSinkRole__SinkDelegationConnector));
			}
		}
		return outerSinkRole__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SinkRole basicGetOuterSinkRole__SinkDelegationConnector() {
		return outerSinkRole__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOuterSinkRole__SinkDelegationConnector(SinkRole newOuterSinkRole__SinkDelegationConnector) {
		SinkRole oldOuterSinkRole__SinkDelegationConnector = outerSinkRole__SinkDelegationConnector;
		outerSinkRole__SinkDelegationConnector = newOuterSinkRole__SinkDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR, oldOuterSinkRole__SinkDelegationConnector, outerSinkRole__SinkDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext__SinkDelegationConnector() {
		if (assemblyContext__SinkDelegationConnector != null && assemblyContext__SinkDelegationConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext__SinkDelegationConnector = (InternalEObject)assemblyContext__SinkDelegationConnector;
			assemblyContext__SinkDelegationConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext__SinkDelegationConnector);
			if (assemblyContext__SinkDelegationConnector != oldAssemblyContext__SinkDelegationConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR, oldAssemblyContext__SinkDelegationConnector, assemblyContext__SinkDelegationConnector));
			}
		}
		return assemblyContext__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext__SinkDelegationConnector() {
		return assemblyContext__SinkDelegationConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext__SinkDelegationConnector(AssemblyContext newAssemblyContext__SinkDelegationConnector) {
		AssemblyContext oldAssemblyContext__SinkDelegationConnector = assemblyContext__SinkDelegationConnector;
		assemblyContext__SinkDelegationConnector = newAssemblyContext__SinkDelegationConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR, oldAssemblyContext__SinkDelegationConnector, assemblyContext__SinkDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposedStructure getParentStructure_SinkDelegationConnector() {
		if (eContainerFeatureID() != CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR) return null;
		return (ComposedStructure)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetParentStructure_SinkDelegationConnector(ComposedStructure newParentStructure_SinkDelegationConnector, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newParentStructure_SinkDelegationConnector, CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentStructure_SinkDelegationConnector(ComposedStructure newParentStructure_SinkDelegationConnector) {
		if (newParentStructure_SinkDelegationConnector != eInternalContainer() || (eContainerFeatureID() != CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR && newParentStructure_SinkDelegationConnector != null)) {
			if (EcoreUtil.isAncestor(this, newParentStructure_SinkDelegationConnector))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newParentStructure_SinkDelegationConnector != null)
				msgs = ((InternalEObject)newParentStructure_SinkDelegationConnector).eInverseAdd(this, CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
			msgs = basicSetParentStructure_SinkDelegationConnector(newParentStructure_SinkDelegationConnector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR, newParentStructure_SinkDelegationConnector, newParentStructure_SinkDelegationConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetParentStructure_SinkDelegationConnector((ComposedStructure)otherEnd, msgs);
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				return basicSetParentStructure_SinkDelegationConnector(null, msgs);
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				return eInternalContainer().eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__SINK_DELEGATION_CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class, msgs);
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				if (resolve) return getInnerSinkRole__SinkDelegationConnector();
				return basicGetInnerSinkRole__SinkDelegationConnector();
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				if (resolve) return getOuterSinkRole__SinkDelegationConnector();
				return basicGetOuterSinkRole__SinkDelegationConnector();
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
				if (resolve) return getAssemblyContext__SinkDelegationConnector();
				return basicGetAssemblyContext__SinkDelegationConnector();
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				return getParentStructure_SinkDelegationConnector();
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				setInnerSinkRole__SinkDelegationConnector((SinkRole)newValue);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				setOuterSinkRole__SinkDelegationConnector((SinkRole)newValue);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
				setAssemblyContext__SinkDelegationConnector((AssemblyContext)newValue);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				setParentStructure_SinkDelegationConnector((ComposedStructure)newValue);
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				setInnerSinkRole__SinkDelegationConnector((SinkRole)null);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				setOuterSinkRole__SinkDelegationConnector((SinkRole)null);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
				setAssemblyContext__SinkDelegationConnector((AssemblyContext)null);
				return;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				setParentStructure_SinkDelegationConnector((ComposedStructure)null);
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
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__INNER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				return innerSinkRole__SinkDelegationConnector != null;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__OUTER_SINK_ROLE_SINK_DELEGATION_CONNECTOR:
				return outerSinkRole__SinkDelegationConnector != null;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SINK_DELEGATION_CONNECTOR:
				return assemblyContext__SinkDelegationConnector != null;
			case CompositionPackage.SINK_DELEGATION_CONNECTOR__PARENT_STRUCTURE_SINK_DELEGATION_CONNECTOR:
				return getParentStructure_SinkDelegationConnector() != null;
		}
		return super.eIsSet(featureID);
	}

} //SinkDelegationConnectorImpl

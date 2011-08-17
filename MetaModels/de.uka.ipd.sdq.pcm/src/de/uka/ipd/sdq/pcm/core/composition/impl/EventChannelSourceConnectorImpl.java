/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Channel Source Connector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getSourceRole__EventChannelSourceRole <em>Source Role Event Channel Source Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getAssemblyContext__EventChannelSourceConnector <em>Assembly Context Event Channel Source Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventChannelSourceConnectorImpl extends ConnectorImpl implements EventChannelSourceConnector {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSourceRole__EventChannelSourceRole() <em>Source Role Event Channel Source Role</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSourceRole__EventChannelSourceRole()
	 * @generated
	 * @ordered
	 */
	protected SourceRole sourceRole__EventChannelSourceRole;

	/**
	 * The cached value of the '{@link #getAssemblyContext__EventChannelSourceConnector() <em>Assembly Context Event Channel Source Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAssemblyContext__EventChannelSourceConnector()
	 * @generated
	 * @ordered
	 */
	protected AssemblyContext assemblyContext__EventChannelSourceConnector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventChannelSourceConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole getSourceRole__EventChannelSourceRole() {
		if (sourceRole__EventChannelSourceRole != null && sourceRole__EventChannelSourceRole.eIsProxy()) {
			InternalEObject oldSourceRole__EventChannelSourceRole = (InternalEObject)sourceRole__EventChannelSourceRole;
			sourceRole__EventChannelSourceRole = (SourceRole)eResolveProxy(oldSourceRole__EventChannelSourceRole);
			if (sourceRole__EventChannelSourceRole != oldSourceRole__EventChannelSourceRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE, oldSourceRole__EventChannelSourceRole, sourceRole__EventChannelSourceRole));
			}
		}
		return sourceRole__EventChannelSourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole basicGetSourceRole__EventChannelSourceRole() {
		return sourceRole__EventChannelSourceRole;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSourceRole__EventChannelSourceRole(SourceRole newSourceRole__EventChannelSourceRole) {
		SourceRole oldSourceRole__EventChannelSourceRole = sourceRole__EventChannelSourceRole;
		sourceRole__EventChannelSourceRole = newSourceRole__EventChannelSourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE, oldSourceRole__EventChannelSourceRole, sourceRole__EventChannelSourceRole));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext getAssemblyContext__EventChannelSourceConnector() {
		if (assemblyContext__EventChannelSourceConnector != null && assemblyContext__EventChannelSourceConnector.eIsProxy()) {
			InternalEObject oldAssemblyContext__EventChannelSourceConnector = (InternalEObject)assemblyContext__EventChannelSourceConnector;
			assemblyContext__EventChannelSourceConnector = (AssemblyContext)eResolveProxy(oldAssemblyContext__EventChannelSourceConnector);
			if (assemblyContext__EventChannelSourceConnector != oldAssemblyContext__EventChannelSourceConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR, oldAssemblyContext__EventChannelSourceConnector, assemblyContext__EventChannelSourceConnector));
			}
		}
		return assemblyContext__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext__EventChannelSourceConnector() {
		return assemblyContext__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAssemblyContext__EventChannelSourceConnector(AssemblyContext newAssemblyContext__EventChannelSourceConnector) {
		AssemblyContext oldAssemblyContext__EventChannelSourceConnector = assemblyContext__EventChannelSourceConnector;
		assemblyContext__EventChannelSourceConnector = newAssemblyContext__EventChannelSourceConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR, oldAssemblyContext__EventChannelSourceConnector, assemblyContext__EventChannelSourceConnector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
				if (resolve) return getSourceRole__EventChannelSourceRole();
				return basicGetSourceRole__EventChannelSourceRole();
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
				if (resolve) return getAssemblyContext__EventChannelSourceConnector();
				return basicGetAssemblyContext__EventChannelSourceConnector();
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
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
				setSourceRole__EventChannelSourceRole((SourceRole)newValue);
				return;
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
				setAssemblyContext__EventChannelSourceConnector((AssemblyContext)newValue);
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
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
				setSourceRole__EventChannelSourceRole((SourceRole)null);
				return;
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
				setAssemblyContext__EventChannelSourceConnector((AssemblyContext)null);
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
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
				return sourceRole__EventChannelSourceRole != null;
			case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
				return assemblyContext__EventChannelSourceConnector != null;
		}
		return super.eIsSet(featureID);
	}

} //EventChannelSourceConnectorImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.composition.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSourceConnector;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Event Channel Source Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getSourceRole__EventChannelSourceRole <em>Source Role Event Channel Source Role</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getAssemblyContext__EventChannelSourceConnector <em>Assembly Context Event Channel Source Connector</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSourceConnectorImpl#getEventChannel__EventChannelSourceConnector <em>Event Channel Event Channel Source Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventChannelSourceConnectorImpl extends ConnectorImpl implements
		EventChannelSourceConnector {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached value of the '{@link #getSourceRole__EventChannelSourceRole() <em>Source Role Event Channel Source Role</em>}' reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
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
	 * The cached value of the '{@link #getEventChannel__EventChannelSourceConnector() <em>Event Channel Event Channel Source Connector</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEventChannel__EventChannelSourceConnector()
	 * @generated
	 * @ordered
	 */
	protected EventChannel eventChannel__EventChannelSourceConnector;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected EventChannelSourceConnectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CompositionPackage.Literals.EVENT_CHANNEL_SOURCE_CONNECTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SourceRole getSourceRole__EventChannelSourceRole() {
		if (sourceRole__EventChannelSourceRole != null
				&& ((EObject) sourceRole__EventChannelSourceRole).eIsProxy()) {
			InternalEObject oldSourceRole__EventChannelSourceRole = (InternalEObject) sourceRole__EventChannelSourceRole;
			sourceRole__EventChannelSourceRole = (SourceRole) eResolveProxy(oldSourceRole__EventChannelSourceRole);
			if (sourceRole__EventChannelSourceRole != oldSourceRole__EventChannelSourceRole) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
							oldSourceRole__EventChannelSourceRole,
							sourceRole__EventChannelSourceRole));
			}
		}
		return sourceRole__EventChannelSourceRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public SourceRole basicGetSourceRole__EventChannelSourceRole() {
		return sourceRole__EventChannelSourceRole;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSourceRole__EventChannelSourceRole(
			SourceRole newSourceRole__EventChannelSourceRole) {
		SourceRole oldSourceRole__EventChannelSourceRole = sourceRole__EventChannelSourceRole;
		sourceRole__EventChannelSourceRole = newSourceRole__EventChannelSourceRole;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE,
					oldSourceRole__EventChannelSourceRole,
					sourceRole__EventChannelSourceRole));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssemblyContext getAssemblyContext__EventChannelSourceConnector() {
		if (assemblyContext__EventChannelSourceConnector != null
				&& ((EObject) assemblyContext__EventChannelSourceConnector)
						.eIsProxy()) {
			InternalEObject oldAssemblyContext__EventChannelSourceConnector = (InternalEObject) assemblyContext__EventChannelSourceConnector;
			assemblyContext__EventChannelSourceConnector = (AssemblyContext) eResolveProxy(oldAssemblyContext__EventChannelSourceConnector);
			if (assemblyContext__EventChannelSourceConnector != oldAssemblyContext__EventChannelSourceConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
							oldAssemblyContext__EventChannelSourceConnector,
							assemblyContext__EventChannelSourceConnector));
			}
		}
		return assemblyContext__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AssemblyContext basicGetAssemblyContext__EventChannelSourceConnector() {
		return assemblyContext__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAssemblyContext__EventChannelSourceConnector(
			AssemblyContext newAssemblyContext__EventChannelSourceConnector) {
		AssemblyContext oldAssemblyContext__EventChannelSourceConnector = assemblyContext__EventChannelSourceConnector;
		assemblyContext__EventChannelSourceConnector = newAssemblyContext__EventChannelSourceConnector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR,
					oldAssemblyContext__EventChannelSourceConnector,
					assemblyContext__EventChannelSourceConnector));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventChannel getEventChannel__EventChannelSourceConnector() {
		if (eventChannel__EventChannelSourceConnector != null
				&& ((EObject) eventChannel__EventChannelSourceConnector)
						.eIsProxy()) {
			InternalEObject oldEventChannel__EventChannelSourceConnector = (InternalEObject) eventChannel__EventChannelSourceConnector;
			eventChannel__EventChannelSourceConnector = (EventChannel) eResolveProxy(oldEventChannel__EventChannelSourceConnector);
			if (eventChannel__EventChannelSourceConnector != oldEventChannel__EventChannelSourceConnector) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(
							this,
							Notification.RESOLVE,
							CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
							oldEventChannel__EventChannelSourceConnector,
							eventChannel__EventChannelSourceConnector));
			}
		}
		return eventChannel__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EventChannel basicGetEventChannel__EventChannelSourceConnector() {
		return eventChannel__EventChannelSourceConnector;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetEventChannel__EventChannelSourceConnector(
			EventChannel newEventChannel__EventChannelSourceConnector,
			NotificationChain msgs) {
		EventChannel oldEventChannel__EventChannelSourceConnector = eventChannel__EventChannelSourceConnector;
		eventChannel__EventChannelSourceConnector = newEventChannel__EventChannelSourceConnector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
					this,
					Notification.SET,
					CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
					oldEventChannel__EventChannelSourceConnector,
					newEventChannel__EventChannelSourceConnector);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEventChannel__EventChannelSourceConnector(
			EventChannel newEventChannel__EventChannelSourceConnector) {
		if (newEventChannel__EventChannelSourceConnector != eventChannel__EventChannelSourceConnector) {
			NotificationChain msgs = null;
			if (eventChannel__EventChannelSourceConnector != null)
				msgs = ((InternalEObject) eventChannel__EventChannelSourceConnector)
						.eInverseRemove(
								this,
								CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
								EventChannel.class, msgs);
			if (newEventChannel__EventChannelSourceConnector != null)
				msgs = ((InternalEObject) newEventChannel__EventChannelSourceConnector)
						.eInverseAdd(
								this,
								CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
								EventChannel.class, msgs);
			msgs = basicSetEventChannel__EventChannelSourceConnector(
					newEventChannel__EventChannelSourceConnector, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(
					this,
					Notification.SET,
					CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR,
					newEventChannel__EventChannelSourceConnector,
					newEventChannel__EventChannelSourceConnector));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			if (eventChannel__EventChannelSourceConnector != null)
				msgs = ((InternalEObject) eventChannel__EventChannelSourceConnector)
						.eInverseRemove(
								this,
								CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SOURCE_CONNECTOR_EVENT_CHANNEL,
								EventChannel.class, msgs);
			return basicSetEventChannel__EventChannelSourceConnector(
					(EventChannel) otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			return basicSetEventChannel__EventChannelSourceConnector(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
			if (resolve)
				return getSourceRole__EventChannelSourceRole();
			return basicGetSourceRole__EventChannelSourceRole();
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
			if (resolve)
				return getAssemblyContext__EventChannelSourceConnector();
			return basicGetAssemblyContext__EventChannelSourceConnector();
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			if (resolve)
				return getEventChannel__EventChannelSourceConnector();
			return basicGetEventChannel__EventChannelSourceConnector();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
			setSourceRole__EventChannelSourceRole((SourceRole) newValue);
			return;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
			setAssemblyContext__EventChannelSourceConnector((AssemblyContext) newValue);
			return;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			setEventChannel__EventChannelSourceConnector((EventChannel) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
			setSourceRole__EventChannelSourceRole((SourceRole) null);
			return;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
			setAssemblyContext__EventChannelSourceConnector((AssemblyContext) null);
			return;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			setEventChannel__EventChannelSourceConnector((EventChannel) null);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__SOURCE_ROLE_EVENT_CHANNEL_SOURCE_ROLE:
			return sourceRole__EventChannelSourceRole != null;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SOURCE_CONNECTOR:
			return assemblyContext__EventChannelSourceConnector != null;
		case CompositionPackage.EVENT_CHANNEL_SOURCE_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SOURCE_CONNECTOR:
			return eventChannel__EventChannelSourceConnector != null;
		}
		return super.eIsSet(featureID);
	}

} // EventChannelSourceConnectorImpl

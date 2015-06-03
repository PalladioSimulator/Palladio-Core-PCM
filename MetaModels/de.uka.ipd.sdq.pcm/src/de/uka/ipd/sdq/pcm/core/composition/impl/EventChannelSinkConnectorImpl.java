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

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.EventChannel;
import de.uka.ipd.sdq.pcm.core.composition.EventChannelSinkConnector;
import de.uka.ipd.sdq.pcm.repository.SinkRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Event Channel Sink Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getSinkRole__EventChannelSinkConnector
 * <em>Sink Role Event Channel Sink Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getFilterCondition__EventChannelSinkConnector
 * <em>Filter Condition Event Channel Sink Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getAssemblyContext__EventChannelSinkConnector
 * <em>Assembly Context Event Channel Sink Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.EventChannelSinkConnectorImpl#getEventChannel__EventChannelSinkConnector
 * <em>Event Channel Event Channel Sink Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventChannelSinkConnectorImpl extends ConnectorImpl implements EventChannelSinkConnector {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSinkRole__EventChannelSinkConnector()
     * <em>Sink Role Event Channel Sink Connector</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getSinkRole__EventChannelSinkConnector()
     * @generated
     * @ordered
     */
    protected SinkRole sinkRole__EventChannelSinkConnector;
    /**
     * The cached value of the '{@link #getFilterCondition__EventChannelSinkConnector()
     * <em>Filter Condition Event Channel Sink Connector</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getFilterCondition__EventChannelSinkConnector()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable filterCondition__EventChannelSinkConnector;
    /**
     * The cached value of the '{@link #getAssemblyContext__EventChannelSinkConnector()
     * <em>Assembly Context Event Channel Sink Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @see #getAssemblyContext__EventChannelSinkConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext assemblyContext__EventChannelSinkConnector;
    /**
     * The cached value of the '{@link #getEventChannel__EventChannelSinkConnector()
     * <em>Event Channel Event Channel Sink Connector</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getEventChannel__EventChannelSinkConnector()
     * @generated
     * @ordered
     */
    protected EventChannel eventChannel__EventChannelSinkConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EventChannelSinkConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.EVENT_CHANNEL_SINK_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SinkRole getSinkRole__EventChannelSinkConnector() {
        if (this.sinkRole__EventChannelSinkConnector != null && this.sinkRole__EventChannelSinkConnector.eIsProxy()) {
            final InternalEObject oldSinkRole__EventChannelSinkConnector = (InternalEObject) this.sinkRole__EventChannelSinkConnector;
            this.sinkRole__EventChannelSinkConnector = (SinkRole) this
                    .eResolveProxy(oldSinkRole__EventChannelSinkConnector);
            if (this.sinkRole__EventChannelSinkConnector != oldSinkRole__EventChannelSinkConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                            oldSinkRole__EventChannelSinkConnector, this.sinkRole__EventChannelSinkConnector));
                }
            }
        }
        return this.sinkRole__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SinkRole basicGetSinkRole__EventChannelSinkConnector() {
        return this.sinkRole__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSinkRole__EventChannelSinkConnector(final SinkRole newSinkRole__EventChannelSinkConnector) {
        final SinkRole oldSinkRole__EventChannelSinkConnector = this.sinkRole__EventChannelSinkConnector;
        this.sinkRole__EventChannelSinkConnector = newSinkRole__EventChannelSinkConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR,
                    oldSinkRole__EventChannelSinkConnector, this.sinkRole__EventChannelSinkConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PCMRandomVariable getFilterCondition__EventChannelSinkConnector() {
        return this.filterCondition__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetFilterCondition__EventChannelSinkConnector(
            final PCMRandomVariable newFilterCondition__EventChannelSinkConnector, NotificationChain msgs) {
        final PCMRandomVariable oldFilterCondition__EventChannelSinkConnector = this.filterCondition__EventChannelSinkConnector;
        this.filterCondition__EventChannelSinkConnector = newFilterCondition__EventChannelSinkConnector;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                    oldFilterCondition__EventChannelSinkConnector, newFilterCondition__EventChannelSinkConnector);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setFilterCondition__EventChannelSinkConnector(
            final PCMRandomVariable newFilterCondition__EventChannelSinkConnector) {
        if (newFilterCondition__EventChannelSinkConnector != this.filterCondition__EventChannelSinkConnector) {
            NotificationChain msgs = null;
            if (this.filterCondition__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) this.filterCondition__EventChannelSinkConnector).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            }
            if (newFilterCondition__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) newFilterCondition__EventChannelSinkConnector).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__EVENT_CHANNEL_SINK_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetFilterCondition__EventChannelSinkConnector(
                    newFilterCondition__EventChannelSinkConnector, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                    newFilterCondition__EventChannelSinkConnector, newFilterCondition__EventChannelSinkConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssemblyContext__EventChannelSinkConnector() {
        if (this.assemblyContext__EventChannelSinkConnector != null
                && this.assemblyContext__EventChannelSinkConnector.eIsProxy()) {
            final InternalEObject oldAssemblyContext__EventChannelSinkConnector = (InternalEObject) this.assemblyContext__EventChannelSinkConnector;
            this.assemblyContext__EventChannelSinkConnector = (AssemblyContext) this
                    .eResolveProxy(oldAssemblyContext__EventChannelSinkConnector);
            if (this.assemblyContext__EventChannelSinkConnector != oldAssemblyContext__EventChannelSinkConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                            oldAssemblyContext__EventChannelSinkConnector,
                            this.assemblyContext__EventChannelSinkConnector));
                }
            }
        }
        return this.assemblyContext__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssemblyContext__EventChannelSinkConnector() {
        return this.assemblyContext__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssemblyContext__EventChannelSinkConnector(
            final AssemblyContext newAssemblyContext__EventChannelSinkConnector) {
        final AssemblyContext oldAssemblyContext__EventChannelSinkConnector = this.assemblyContext__EventChannelSinkConnector;
        this.assemblyContext__EventChannelSinkConnector = newAssemblyContext__EventChannelSinkConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR,
                    oldAssemblyContext__EventChannelSinkConnector, this.assemblyContext__EventChannelSinkConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EventChannel getEventChannel__EventChannelSinkConnector() {
        if (this.eventChannel__EventChannelSinkConnector != null
                && this.eventChannel__EventChannelSinkConnector.eIsProxy()) {
            final InternalEObject oldEventChannel__EventChannelSinkConnector = (InternalEObject) this.eventChannel__EventChannelSinkConnector;
            this.eventChannel__EventChannelSinkConnector = (EventChannel) this
                    .eResolveProxy(oldEventChannel__EventChannelSinkConnector);
            if (this.eventChannel__EventChannelSinkConnector != oldEventChannel__EventChannelSinkConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                            oldEventChannel__EventChannelSinkConnector, this.eventChannel__EventChannelSinkConnector));
                }
            }
        }
        return this.eventChannel__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public EventChannel basicGetEventChannel__EventChannelSinkConnector() {
        return this.eventChannel__EventChannelSinkConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetEventChannel__EventChannelSinkConnector(
            final EventChannel newEventChannel__EventChannelSinkConnector, NotificationChain msgs) {
        final EventChannel oldEventChannel__EventChannelSinkConnector = this.eventChannel__EventChannelSinkConnector;
        this.eventChannel__EventChannelSinkConnector = newEventChannel__EventChannelSinkConnector;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                    oldEventChannel__EventChannelSinkConnector, newEventChannel__EventChannelSinkConnector);
            if (msgs == null) {
                msgs = notification;
            } else {
                msgs.add(notification);
            }
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setEventChannel__EventChannelSinkConnector(final EventChannel newEventChannel__EventChannelSinkConnector) {
        if (newEventChannel__EventChannelSinkConnector != this.eventChannel__EventChannelSinkConnector) {
            NotificationChain msgs = null;
            if (this.eventChannel__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) this.eventChannel__EventChannelSinkConnector).eInverseRemove(this,
                        CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                        EventChannel.class, msgs);
            }
            if (newEventChannel__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) newEventChannel__EventChannelSinkConnector).eInverseAdd(this,
                        CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                        EventChannel.class, msgs);
            }
            msgs = this.basicSetEventChannel__EventChannelSinkConnector(newEventChannel__EventChannelSinkConnector,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR,
                    newEventChannel__EventChannelSinkConnector, newEventChannel__EventChannelSinkConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            if (this.filterCondition__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) this.filterCondition__EventChannelSinkConnector)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                - CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR,
                                null, msgs);
            }
            return this.basicSetFilterCondition__EventChannelSinkConnector((PCMRandomVariable) otherEnd, msgs);
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            if (this.eventChannel__EventChannelSinkConnector != null) {
                msgs = ((InternalEObject) this.eventChannel__EventChannelSinkConnector).eInverseRemove(this,
                        CompositionPackage.EVENT_CHANNEL__EVENT_CHANNEL_SINK_CONNECTOR_EVENT_CHANNEL,
                        EventChannel.class, msgs);
            }
            return this.basicSetEventChannel__EventChannelSinkConnector((EventChannel) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.basicSetFilterCondition__EventChannelSinkConnector(null, msgs);
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.basicSetEventChannel__EventChannelSinkConnector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve) {
                return this.getSinkRole__EventChannelSinkConnector();
            }
            return this.basicGetSinkRole__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.getFilterCondition__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve) {
                return this.getAssemblyContext__EventChannelSinkConnector();
            }
            return this.basicGetAssemblyContext__EventChannelSinkConnector();
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            if (resolve) {
                return this.getEventChannel__EventChannelSinkConnector();
            }
            return this.basicGetEventChannel__EventChannelSinkConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setSinkRole__EventChannelSinkConnector((SinkRole) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setFilterCondition__EventChannelSinkConnector((PCMRandomVariable) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setAssemblyContext__EventChannelSinkConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setEventChannel__EventChannelSinkConnector((EventChannel) newValue);
            return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void eUnset(final int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setSinkRole__EventChannelSinkConnector((SinkRole) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setFilterCondition__EventChannelSinkConnector((PCMRandomVariable) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setAssemblyContext__EventChannelSinkConnector((AssemblyContext) null);
            return;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            this.setEventChannel__EventChannelSinkConnector((EventChannel) null);
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__SINK_ROLE_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.sinkRole__EventChannelSinkConnector != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__FILTER_CONDITION_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.filterCondition__EventChannelSinkConnector != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__ASSEMBLY_CONTEXT_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.assemblyContext__EventChannelSinkConnector != null;
        case CompositionPackage.EVENT_CHANNEL_SINK_CONNECTOR__EVENT_CHANNEL_EVENT_CHANNEL_SINK_CONNECTOR:
            return this.eventChannel__EventChannelSinkConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // EventChannelSinkConnectorImpl

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

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.repository.SinkRole;
import de.uka.ipd.sdq.pcm.repository.SourceRole;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Assembly Event Connector</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSinkRole__AssemblyEventConnector
 * <em>Sink Role Assembly Event Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSourceRole__AssemblyEventConnector
 * <em>Source Role Assembly Event Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSinkAssemblyContext__AssemblyEventConnector
 * <em>Sink Assembly Context Assembly Event Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl#getSourceAssemblyContext__AssemblyEventConnector
 * <em>Source Assembly Context Assembly Event Connector</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.core.composition.impl.AssemblyEventConnectorImpl#getFilterCondition__AssemblyEventConnector
 * <em>Filter Condition Assembly Event Connector</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class AssemblyEventConnectorImpl extends ConnectorImpl implements AssemblyEventConnector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSinkRole__AssemblyEventConnector()
     * <em>Sink Role Assembly Event Connector</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSinkRole__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected SinkRole sinkRole__AssemblyEventConnector;

    /**
     * The cached value of the '{@link #getSourceRole__AssemblyEventConnector()
     * <em>Source Role Assembly Event Connector</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getSourceRole__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected SourceRole sourceRole__AssemblyEventConnector;

    /**
     * The cached value of the ' {@link #getSinkAssemblyContext__AssemblyEventConnector()
     * <em>Sink Assembly Context Assembly Event Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSinkAssemblyContext__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext sinkAssemblyContext__AssemblyEventConnector;

    /**
     * The cached value of the ' {@link #getSourceAssemblyContext__AssemblyEventConnector()
     * <em>Source Assembly Context Assembly Event Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSourceAssemblyContext__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext sourceAssemblyContext__AssemblyEventConnector;

    /**
     * The cached value of the ' {@link #getFilterCondition__AssemblyEventConnector()
     * <em>Filter Condition Assembly Event Connector</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getFilterCondition__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable filterCondition__AssemblyEventConnector;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected AssemblyEventConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.ASSEMBLY_EVENT_CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SinkRole getSinkRole__AssemblyEventConnector() {
        if (this.sinkRole__AssemblyEventConnector != null
                && ((EObject) this.sinkRole__AssemblyEventConnector).eIsProxy()) {
            final InternalEObject oldSinkRole__AssemblyEventConnector = (InternalEObject) this.sinkRole__AssemblyEventConnector;
            this.sinkRole__AssemblyEventConnector = (SinkRole) this.eResolveProxy(oldSinkRole__AssemblyEventConnector);
            if (this.sinkRole__AssemblyEventConnector != oldSinkRole__AssemblyEventConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                            oldSinkRole__AssemblyEventConnector, this.sinkRole__AssemblyEventConnector));
                }
            }
        }
        return this.sinkRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SinkRole basicGetSinkRole__AssemblyEventConnector() {
        return this.sinkRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSinkRole__AssemblyEventConnector(final SinkRole newSinkRole__AssemblyEventConnector) {
        final SinkRole oldSinkRole__AssemblyEventConnector = this.sinkRole__AssemblyEventConnector;
        this.sinkRole__AssemblyEventConnector = newSinkRole__AssemblyEventConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                    oldSinkRole__AssemblyEventConnector, this.sinkRole__AssemblyEventConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SourceRole getSourceRole__AssemblyEventConnector() {
        if (this.sourceRole__AssemblyEventConnector != null
                && ((EObject) this.sourceRole__AssemblyEventConnector).eIsProxy()) {
            final InternalEObject oldSourceRole__AssemblyEventConnector = (InternalEObject) this.sourceRole__AssemblyEventConnector;
            this.sourceRole__AssemblyEventConnector = (SourceRole) this
                    .eResolveProxy(oldSourceRole__AssemblyEventConnector);
            if (this.sourceRole__AssemblyEventConnector != oldSourceRole__AssemblyEventConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                            oldSourceRole__AssemblyEventConnector, this.sourceRole__AssemblyEventConnector));
                }
            }
        }
        return this.sourceRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SourceRole basicGetSourceRole__AssemblyEventConnector() {
        return this.sourceRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceRole__AssemblyEventConnector(final SourceRole newSourceRole__AssemblyEventConnector) {
        final SourceRole oldSourceRole__AssemblyEventConnector = this.sourceRole__AssemblyEventConnector;
        this.sourceRole__AssemblyEventConnector = newSourceRole__AssemblyEventConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                    oldSourceRole__AssemblyEventConnector, this.sourceRole__AssemblyEventConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getSinkAssemblyContext__AssemblyEventConnector() {
        if (this.sinkAssemblyContext__AssemblyEventConnector != null
                && ((EObject) this.sinkAssemblyContext__AssemblyEventConnector).eIsProxy()) {
            final InternalEObject oldSinkAssemblyContext__AssemblyEventConnector = (InternalEObject) this.sinkAssemblyContext__AssemblyEventConnector;
            this.sinkAssemblyContext__AssemblyEventConnector = (AssemblyContext) this
                    .eResolveProxy(oldSinkAssemblyContext__AssemblyEventConnector);
            if (this.sinkAssemblyContext__AssemblyEventConnector != oldSinkAssemblyContext__AssemblyEventConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                            oldSinkAssemblyContext__AssemblyEventConnector,
                            this.sinkAssemblyContext__AssemblyEventConnector));
                }
            }
        }
        return this.sinkAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetSinkAssemblyContext__AssemblyEventConnector() {
        return this.sinkAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSinkAssemblyContext__AssemblyEventConnector(
            final AssemblyContext newSinkAssemblyContext__AssemblyEventConnector) {
        final AssemblyContext oldSinkAssemblyContext__AssemblyEventConnector = this.sinkAssemblyContext__AssemblyEventConnector;
        this.sinkAssemblyContext__AssemblyEventConnector = newSinkAssemblyContext__AssemblyEventConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                    oldSinkAssemblyContext__AssemblyEventConnector, this.sinkAssemblyContext__AssemblyEventConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AssemblyContext getSourceAssemblyContext__AssemblyEventConnector() {
        if (this.sourceAssemblyContext__AssemblyEventConnector != null
                && ((EObject) this.sourceAssemblyContext__AssemblyEventConnector).eIsProxy()) {
            final InternalEObject oldSourceAssemblyContext__AssemblyEventConnector = (InternalEObject) this.sourceAssemblyContext__AssemblyEventConnector;
            this.sourceAssemblyContext__AssemblyEventConnector = (AssemblyContext) this
                    .eResolveProxy(oldSourceAssemblyContext__AssemblyEventConnector);
            if (this.sourceAssemblyContext__AssemblyEventConnector != oldSourceAssemblyContext__AssemblyEventConnector) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                            oldSourceAssemblyContext__AssemblyEventConnector,
                            this.sourceAssemblyContext__AssemblyEventConnector));
                }
            }
        }
        return this.sourceAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetSourceAssemblyContext__AssemblyEventConnector() {
        return this.sourceAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSourceAssemblyContext__AssemblyEventConnector(
            final AssemblyContext newSourceAssemblyContext__AssemblyEventConnector) {
        final AssemblyContext oldSourceAssemblyContext__AssemblyEventConnector = this.sourceAssemblyContext__AssemblyEventConnector;
        this.sourceAssemblyContext__AssemblyEventConnector = newSourceAssemblyContext__AssemblyEventConnector;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                    oldSourceAssemblyContext__AssemblyEventConnector,
                    this.sourceAssemblyContext__AssemblyEventConnector));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getFilterCondition__AssemblyEventConnector() {
        return this.filterCondition__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFilterCondition__AssemblyEventConnector(
            final PCMRandomVariable newFilterCondition__AssemblyEventConnector, NotificationChain msgs) {
        final PCMRandomVariable oldFilterCondition__AssemblyEventConnector = this.filterCondition__AssemblyEventConnector;
        this.filterCondition__AssemblyEventConnector = newFilterCondition__AssemblyEventConnector;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                    oldFilterCondition__AssemblyEventConnector, newFilterCondition__AssemblyEventConnector);
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
    public void setFilterCondition__AssemblyEventConnector(
            final PCMRandomVariable newFilterCondition__AssemblyEventConnector) {
        if (newFilterCondition__AssemblyEventConnector != this.filterCondition__AssemblyEventConnector) {
            NotificationChain msgs = null;
            if (this.filterCondition__AssemblyEventConnector != null) {
                msgs = ((InternalEObject) this.filterCondition__AssemblyEventConnector).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            }
            if (newFilterCondition__AssemblyEventConnector != null) {
                msgs = ((InternalEObject) newFilterCondition__AssemblyEventConnector).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            }
            msgs = this.basicSetFilterCondition__AssemblyEventConnector(newFilterCondition__AssemblyEventConnector,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                    newFilterCondition__AssemblyEventConnector, newFilterCondition__AssemblyEventConnector));
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            if (this.filterCondition__AssemblyEventConnector != null) {
                msgs = ((InternalEObject) this.filterCondition__AssemblyEventConnector)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                                null, msgs);
            }
            return this.basicSetFilterCondition__AssemblyEventConnector((PCMRandomVariable) otherEnd, msgs);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return this.basicSetFilterCondition__AssemblyEventConnector(null, msgs);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve) {
                return this.getSinkRole__AssemblyEventConnector();
            }
            return this.basicGetSinkRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve) {
                return this.getSourceRole__AssemblyEventConnector();
            }
            return this.basicGetSourceRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve) {
                return this.getSinkAssemblyContext__AssemblyEventConnector();
            }
            return this.basicGetSinkAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve) {
                return this.getSourceAssemblyContext__AssemblyEventConnector();
            }
            return this.basicGetSourceAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return this.getFilterCondition__AssemblyEventConnector();
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            this.setSinkRole__AssemblyEventConnector((SinkRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            this.setSourceRole__AssemblyEventConnector((SourceRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            this.setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            this.setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            this.setFilterCondition__AssemblyEventConnector((PCMRandomVariable) newValue);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            this.setSinkRole__AssemblyEventConnector((SinkRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            this.setSourceRole__AssemblyEventConnector((SourceRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            this.setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            this.setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            this.setFilterCondition__AssemblyEventConnector((PCMRandomVariable) null);
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
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return this.sinkRole__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return this.sourceRole__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return this.sinkAssemblyContext__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return this.sourceAssemblyContext__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return this.filterCondition__AssemblyEventConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // AssemblyEventConnectorImpl

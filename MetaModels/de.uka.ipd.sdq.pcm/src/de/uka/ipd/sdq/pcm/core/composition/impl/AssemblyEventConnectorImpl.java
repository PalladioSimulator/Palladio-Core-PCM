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
     * The cached value of the '{@link #getSinkAssemblyContext__AssemblyEventConnector()
     * <em>Sink Assembly Context Assembly Event Connector</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getSinkAssemblyContext__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext sinkAssemblyContext__AssemblyEventConnector;

    /**
     * The cached value of the '{@link #getSourceAssemblyContext__AssemblyEventConnector()
     * <em>Source Assembly Context Assembly Event Connector</em>}' reference. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getSourceAssemblyContext__AssemblyEventConnector()
     * @generated
     * @ordered
     */
    protected AssemblyContext sourceAssemblyContext__AssemblyEventConnector;

    /**
     * The cached value of the '{@link #getFilterCondition__AssemblyEventConnector()
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
    public SinkRole getSinkRole__AssemblyEventConnector() {
        if (sinkRole__AssemblyEventConnector != null && ((EObject) sinkRole__AssemblyEventConnector).eIsProxy()) {
            InternalEObject oldSinkRole__AssemblyEventConnector = (InternalEObject) sinkRole__AssemblyEventConnector;
            sinkRole__AssemblyEventConnector = (SinkRole) eResolveProxy(oldSinkRole__AssemblyEventConnector);
            if (sinkRole__AssemblyEventConnector != oldSinkRole__AssemblyEventConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                            oldSinkRole__AssemblyEventConnector, sinkRole__AssemblyEventConnector));
            }
        }
        return sinkRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SinkRole basicGetSinkRole__AssemblyEventConnector() {
        return sinkRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSinkRole__AssemblyEventConnector(SinkRole newSinkRole__AssemblyEventConnector) {
        SinkRole oldSinkRole__AssemblyEventConnector = sinkRole__AssemblyEventConnector;
        sinkRole__AssemblyEventConnector = newSinkRole__AssemblyEventConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                    oldSinkRole__AssemblyEventConnector, sinkRole__AssemblyEventConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SourceRole getSourceRole__AssemblyEventConnector() {
        if (sourceRole__AssemblyEventConnector != null && ((EObject) sourceRole__AssemblyEventConnector).eIsProxy()) {
            InternalEObject oldSourceRole__AssemblyEventConnector = (InternalEObject) sourceRole__AssemblyEventConnector;
            sourceRole__AssemblyEventConnector = (SourceRole) eResolveProxy(oldSourceRole__AssemblyEventConnector);
            if (sourceRole__AssemblyEventConnector != oldSourceRole__AssemblyEventConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                            oldSourceRole__AssemblyEventConnector, sourceRole__AssemblyEventConnector));
            }
        }
        return sourceRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SourceRole basicGetSourceRole__AssemblyEventConnector() {
        return sourceRole__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSourceRole__AssemblyEventConnector(SourceRole newSourceRole__AssemblyEventConnector) {
        SourceRole oldSourceRole__AssemblyEventConnector = sourceRole__AssemblyEventConnector;
        sourceRole__AssemblyEventConnector = newSourceRole__AssemblyEventConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR,
                    oldSourceRole__AssemblyEventConnector, sourceRole__AssemblyEventConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext getSinkAssemblyContext__AssemblyEventConnector() {
        if (sinkAssemblyContext__AssemblyEventConnector != null
                && ((EObject) sinkAssemblyContext__AssemblyEventConnector).eIsProxy()) {
            InternalEObject oldSinkAssemblyContext__AssemblyEventConnector = (InternalEObject) sinkAssemblyContext__AssemblyEventConnector;
            sinkAssemblyContext__AssemblyEventConnector = (AssemblyContext) eResolveProxy(oldSinkAssemblyContext__AssemblyEventConnector);
            if (sinkAssemblyContext__AssemblyEventConnector != oldSinkAssemblyContext__AssemblyEventConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                            oldSinkAssemblyContext__AssemblyEventConnector, sinkAssemblyContext__AssemblyEventConnector));
            }
        }
        return sinkAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetSinkAssemblyContext__AssemblyEventConnector() {
        return sinkAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSinkAssemblyContext__AssemblyEventConnector(
            AssemblyContext newSinkAssemblyContext__AssemblyEventConnector) {
        AssemblyContext oldSinkAssemblyContext__AssemblyEventConnector = sinkAssemblyContext__AssemblyEventConnector;
        sinkAssemblyContext__AssemblyEventConnector = newSinkAssemblyContext__AssemblyEventConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                    oldSinkAssemblyContext__AssemblyEventConnector, sinkAssemblyContext__AssemblyEventConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext getSourceAssemblyContext__AssemblyEventConnector() {
        if (sourceAssemblyContext__AssemblyEventConnector != null
                && ((EObject) sourceAssemblyContext__AssemblyEventConnector).eIsProxy()) {
            InternalEObject oldSourceAssemblyContext__AssemblyEventConnector = (InternalEObject) sourceAssemblyContext__AssemblyEventConnector;
            sourceAssemblyContext__AssemblyEventConnector = (AssemblyContext) eResolveProxy(oldSourceAssemblyContext__AssemblyEventConnector);
            if (sourceAssemblyContext__AssemblyEventConnector != oldSourceAssemblyContext__AssemblyEventConnector) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                            oldSourceAssemblyContext__AssemblyEventConnector,
                            sourceAssemblyContext__AssemblyEventConnector));
            }
        }
        return sourceAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AssemblyContext basicGetSourceAssemblyContext__AssemblyEventConnector() {
        return sourceAssemblyContext__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setSourceAssemblyContext__AssemblyEventConnector(
            AssemblyContext newSourceAssemblyContext__AssemblyEventConnector) {
        AssemblyContext oldSourceAssemblyContext__AssemblyEventConnector = sourceAssemblyContext__AssemblyEventConnector;
        sourceAssemblyContext__AssemblyEventConnector = newSourceAssemblyContext__AssemblyEventConnector;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR,
                    oldSourceAssemblyContext__AssemblyEventConnector, sourceAssemblyContext__AssemblyEventConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMRandomVariable getFilterCondition__AssemblyEventConnector() {
        return filterCondition__AssemblyEventConnector;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetFilterCondition__AssemblyEventConnector(
            PCMRandomVariable newFilterCondition__AssemblyEventConnector, NotificationChain msgs) {
        PCMRandomVariable oldFilterCondition__AssemblyEventConnector = filterCondition__AssemblyEventConnector;
        filterCondition__AssemblyEventConnector = newFilterCondition__AssemblyEventConnector;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                    oldFilterCondition__AssemblyEventConnector, newFilterCondition__AssemblyEventConnector);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setFilterCondition__AssemblyEventConnector(PCMRandomVariable newFilterCondition__AssemblyEventConnector) {
        if (newFilterCondition__AssemblyEventConnector != filterCondition__AssemblyEventConnector) {
            NotificationChain msgs = null;
            if (filterCondition__AssemblyEventConnector != null)
                msgs = ((InternalEObject) filterCondition__AssemblyEventConnector).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            if (newFilterCondition__AssemblyEventConnector != null)
                msgs = ((InternalEObject) newFilterCondition__AssemblyEventConnector).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__ASSEMBLY_EVENT_CONNECTOR_FILTER_CONDITION,
                        PCMRandomVariable.class, msgs);
            msgs = basicSetFilterCondition__AssemblyEventConnector(newFilterCondition__AssemblyEventConnector, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                    newFilterCondition__AssemblyEventConnector, newFilterCondition__AssemblyEventConnector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            if (filterCondition__AssemblyEventConnector != null)
                msgs = ((InternalEObject) filterCondition__AssemblyEventConnector)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR,
                                null, msgs);
            return basicSetFilterCondition__AssemblyEventConnector((PCMRandomVariable) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return basicSetFilterCondition__AssemblyEventConnector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSinkRole__AssemblyEventConnector();
            return basicGetSinkRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSourceRole__AssemblyEventConnector();
            return basicGetSourceRole__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSinkAssemblyContext__AssemblyEventConnector();
            return basicGetSinkAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            if (resolve)
                return getSourceAssemblyContext__AssemblyEventConnector();
            return basicGetSourceAssemblyContext__AssemblyEventConnector();
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return getFilterCondition__AssemblyEventConnector();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSinkRole__AssemblyEventConnector((SinkRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSourceRole__AssemblyEventConnector((SourceRole) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) newValue);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            setFilterCondition__AssemblyEventConnector((PCMRandomVariable) newValue);
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
    public void eUnset(int featureID) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSinkRole__AssemblyEventConnector((SinkRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            setSourceRole__AssemblyEventConnector((SourceRole) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSinkAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            setSourceAssemblyContext__AssemblyEventConnector((AssemblyContext) null);
            return;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            setFilterCondition__AssemblyEventConnector((PCMRandomVariable) null);
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
    public boolean eIsSet(int featureID) {
        switch (featureID) {
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return sinkRole__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ROLE_ASSEMBLY_EVENT_CONNECTOR:
            return sourceRole__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SINK_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return sinkAssemblyContext__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__SOURCE_ASSEMBLY_CONTEXT_ASSEMBLY_EVENT_CONNECTOR:
            return sourceAssemblyContext__AssemblyEventConnector != null;
        case CompositionPackage.ASSEMBLY_EVENT_CONNECTOR__FILTER_CONDITION_ASSEMBLY_EVENT_CONNECTOR:
            return filterCondition__AssemblyEventConnector != null;
        }
        return super.eIsSet(featureID);
    }

} // AssemblyEventConnectorImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Event Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.EventTypeImpl#getParameter__EventType <em>Parameter Event Type</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.repository.impl.EventTypeImpl#getEventGroup__EventType <em>Event Group Event Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventTypeImpl extends SignatureImpl implements EventType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getParameter__EventType() <em>Parameter Event Type</em>}' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getParameter__EventType()
     * @generated
     * @ordered
     */
    protected Parameter parameter__EventType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EventTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EVENT_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EventGroup getEventGroup__EventType() {
        if (eContainerFeatureID() != RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE) return null;
        return (EventGroup)eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEventGroup__EventType(EventGroup newEventGroup__EventType, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject)newEventGroup__EventType, RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setEventGroup__EventType(EventGroup newEventGroup__EventType) {
        if (newEventGroup__EventType != eInternalContainer() || (eContainerFeatureID() != RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE && newEventGroup__EventType != null)) {
            if (EcoreUtil.isAncestor(this, (EObject)newEventGroup__EventType))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newEventGroup__EventType != null)
                msgs = ((InternalEObject)newEventGroup__EventType).eInverseAdd(this, RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP, EventGroup.class, msgs);
            msgs = basicSetEventGroup__EventType(newEventGroup__EventType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, newEventGroup__EventType, newEventGroup__EventType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public Parameter getParameter__EventType() {
        return parameter__EventType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter__EventType(Parameter newParameter__EventType, NotificationChain msgs) {
        Parameter oldParameter__EventType = parameter__EventType;
        parameter__EventType = newParameter__EventType;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, oldParameter__EventType, newParameter__EventType);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setParameter__EventType(Parameter newParameter__EventType) {
        if (newParameter__EventType != parameter__EventType) {
            NotificationChain msgs = null;
            if (parameter__EventType != null)
                msgs = ((InternalEObject)parameter__EventType).eInverseRemove(this, RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, Parameter.class, msgs);
            if (newParameter__EventType != null)
                msgs = ((InternalEObject)newParameter__EventType).eInverseAdd(this, RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, Parameter.class, msgs);
            msgs = basicSetParameter__EventType(newParameter__EventType, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, newParameter__EventType, newParameter__EventType));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                if (parameter__EventType != null)
                    msgs = ((InternalEObject)parameter__EventType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, null, msgs);
                return basicSetParameter__EventType((Parameter)otherEnd, msgs);
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                if (eInternalContainer() != null)
                    msgs = eBasicRemoveFromContainer(msgs);
                return basicSetEventGroup__EventType((EventGroup)otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                return basicSetParameter__EventType(null, msgs);
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                return basicSetEventGroup__EventType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                return eInternalContainer().eInverseRemove(this, RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP, EventGroup.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                return getParameter__EventType();
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                return getEventGroup__EventType();
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
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                setParameter__EventType((Parameter)newValue);
                return;
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                setEventGroup__EventType((EventGroup)newValue);
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
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                setParameter__EventType((Parameter)null);
                return;
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                setEventGroup__EventType((EventGroup)null);
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
            case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
                return parameter__EventType != null;
            case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
                return getEventGroup__EventType() != null;
        }
        return super.eIsSet(featureID);
    }

} // EventTypeImpl

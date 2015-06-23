/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.repository.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.palladiosimulator.pcm.repository.EventGroup;
import org.palladiosimulator.pcm.repository.EventType;
import org.palladiosimulator.pcm.repository.Parameter;
import org.palladiosimulator.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.EventTypeImpl#getParameter__EventType <em>Parameter Event Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.repository.impl.EventTypeImpl#getEventGroup__EventType <em>Event Group Event Type</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EventTypeImpl extends SignatureImpl implements EventType {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EventTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EVENT_TYPE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Parameter getParameter__EventType() {
        return (Parameter) eDynamicGet(RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE,
                RepositoryPackage.Literals.EVENT_TYPE__PARAMETER_EVENT_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetParameter__EventType(Parameter newParameter__EventType, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newParameter__EventType,
                RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParameter__EventType(Parameter newParameter__EventType) {
        eDynamicSet(RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE,
                RepositoryPackage.Literals.EVENT_TYPE__PARAMETER_EVENT_TYPE, newParameter__EventType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EventGroup getEventGroup__EventType() {
        return (EventGroup) eDynamicGet(RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE,
                RepositoryPackage.Literals.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEventGroup__EventType(EventGroup newEventGroup__EventType,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newEventGroup__EventType,
                RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEventGroup__EventType(EventGroup newEventGroup__EventType) {
        eDynamicSet(RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE,
                RepositoryPackage.Literals.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, newEventGroup__EventType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            Parameter parameter__EventType = getParameter__EventType();
            if (parameter__EventType != null)
                msgs = ((InternalEObject) parameter__EventType).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE - RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, null, msgs);
            return basicSetParameter__EventType((Parameter) otherEnd, msgs);
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetEventGroup__EventType((EventGroup) otherEnd, msgs);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return basicSetParameter__EventType(null, msgs);
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return basicSetEventGroup__EventType(null, msgs);
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
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return eInternalContainer().eInverseRemove(this, RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP,
                    EventGroup.class, msgs);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return getParameter__EventType();
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return getEventGroup__EventType();
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            setParameter__EventType((Parameter) newValue);
            return;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            setEventGroup__EventType((EventGroup) newValue);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            setParameter__EventType((Parameter) null);
            return;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            setEventGroup__EventType((EventGroup) null);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return getParameter__EventType() != null;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return getEventGroup__EventType() != null;
        }
        return super.eIsSet(featureID);
    }

} //EventTypeImpl

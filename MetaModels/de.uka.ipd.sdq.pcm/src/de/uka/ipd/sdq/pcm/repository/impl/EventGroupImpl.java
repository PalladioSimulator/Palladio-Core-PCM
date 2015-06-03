/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Event Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.repository.impl.EventGroupImpl#getEventTypes__EventGroup <em>Event
 * Types Event Group</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventGroupImpl extends InterfaceImpl implements EventGroup {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getEventTypes__EventGroup()
     * <em>Event Types Event Group</em>}' containment reference list. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #getEventTypes__EventGroup()
     * @generated
     * @ordered
     */
    protected EList<EventType> eventTypes__EventGroup;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EventGroupImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EVENT_GROUP;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public EList<EventType> getEventTypes__EventGroup() {
        if (this.eventTypes__EventGroup == null) {
            this.eventTypes__EventGroup = new EObjectContainmentWithInverseEList<EventType>(EventType.class, this,
                    RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP,
                    RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE);
        }
        return this.eventTypes__EventGroup;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getEventTypes__EventGroup()).basicAdd(
                    otherEnd, msgs);
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
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            return ((InternalEList<?>) this.getEventTypes__EventGroup()).basicRemove(otherEnd, msgs);
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
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            return this.getEventTypes__EventGroup();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            this.getEventTypes__EventGroup().clear();
            this.getEventTypes__EventGroup().addAll((Collection<? extends EventType>) newValue);
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
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            this.getEventTypes__EventGroup().clear();
            return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean eIsSet(final int featureID) {
        switch (featureID) {
        case RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP:
            return this.eventTypes__EventGroup != null && !this.eventTypes__EventGroup.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // EventGroupImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.repository.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.repository.EventGroup;
import de.uka.ipd.sdq.pcm.repository.EventType;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Event Type</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.EventTypeImpl#getParameter__EventType <em>Parameter
 * Event Type</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.repository.impl.EventTypeImpl#getEventGroup__EventType <em>Event Group
 * Event Type</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class EventTypeImpl extends SignatureImpl implements EventType {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getParameter__EventType() <em>Parameter Event Type</em>}'
     * containment reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameter__EventType()
     * @generated
     * @ordered
     */
    protected Parameter parameter__EventType;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected EventTypeImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return RepositoryPackage.Literals.EVENT_TYPE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EventGroup getEventGroup__EventType() {
        if (this.eContainerFeatureID() != RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE) {
            return null;
        }
        return (EventGroup) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetEventGroup__EventType(final EventGroup newEventGroup__EventType,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newEventGroup__EventType,
                RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setEventGroup__EventType(final EventGroup newEventGroup__EventType) {
        if (newEventGroup__EventType != this.eInternalContainer()
                || (this.eContainerFeatureID() != RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE && newEventGroup__EventType != null)) {
            if (EcoreUtil.isAncestor(this, newEventGroup__EventType)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newEventGroup__EventType != null) {
                msgs = ((InternalEObject) newEventGroup__EventType).eInverseAdd(this,
                        RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP, EventGroup.class, msgs);
            }
            msgs = this.basicSetEventGroup__EventType(newEventGroup__EventType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE, newEventGroup__EventType,
                    newEventGroup__EventType));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Parameter getParameter__EventType() {
        return this.parameter__EventType;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParameter__EventType(final Parameter newParameter__EventType,
            NotificationChain msgs) {
        final Parameter oldParameter__EventType = this.parameter__EventType;
        this.parameter__EventType = newParameter__EventType;
        if (this.eNotificationRequired()) {
            final ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, oldParameter__EventType,
                    newParameter__EventType);
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
    public void setParameter__EventType(final Parameter newParameter__EventType) {
        if (newParameter__EventType != this.parameter__EventType) {
            NotificationChain msgs = null;
            if (this.parameter__EventType != null) {
                msgs = ((InternalEObject) this.parameter__EventType).eInverseRemove(this,
                        RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, Parameter.class, msgs);
            }
            if (newParameter__EventType != null) {
                msgs = ((InternalEObject) newParameter__EventType).eInverseAdd(this,
                        RepositoryPackage.PARAMETER__EVENT_TYPE_PARAMETER, Parameter.class, msgs);
            }
            msgs = this.basicSetParameter__EventType(newParameter__EventType, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, newParameter__EventType,
                    newParameter__EventType));
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            if (this.parameter__EventType != null) {
                msgs = ((InternalEObject) this.parameter__EventType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE, null, msgs);
            }
            return this.basicSetParameter__EventType((Parameter) otherEnd, msgs);
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetEventGroup__EventType((EventGroup) otherEnd, msgs);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return this.basicSetParameter__EventType(null, msgs);
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return this.basicSetEventGroup__EventType(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.EVENT_GROUP__EVENT_TYPES_EVENT_GROUP, EventGroup.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return this.getParameter__EventType();
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return this.getEventGroup__EventType();
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            this.setParameter__EventType((Parameter) newValue);
            return;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            this.setEventGroup__EventType((EventGroup) newValue);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            this.setParameter__EventType((Parameter) null);
            return;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            this.setEventGroup__EventType((EventGroup) null);
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
        case RepositoryPackage.EVENT_TYPE__PARAMETER_EVENT_TYPE:
            return this.parameter__EventType != null;
        case RepositoryPackage.EVENT_TYPE__EVENT_GROUP_EVENT_TYPE:
            return this.getEventGroup__EventType() != null;
        }
        return super.eIsSet(featureID);
    }

} // EventTypeImpl

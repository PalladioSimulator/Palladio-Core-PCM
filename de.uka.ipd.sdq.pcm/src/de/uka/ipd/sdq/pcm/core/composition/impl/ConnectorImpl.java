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
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.Connector;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Connector</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.core.composition.impl.ConnectorImpl#getParentStructure__Connector
 * <em>Parent Structure Connector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ConnectorImpl extends EntityImpl implements Connector {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ConnectorImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return CompositionPackage.Literals.CONNECTOR;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ComposedStructure getParentStructure__Connector() {
        if (eContainerFeatureID() != CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR)
            return null;
        return (ComposedStructure) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetParentStructure__Connector(ComposedStructure newParentStructure__Connector,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newParentStructure__Connector,
                CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setParentStructure__Connector(ComposedStructure newParentStructure__Connector) {
        if (newParentStructure__Connector != eInternalContainer()
                || (eContainerFeatureID() != CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR && newParentStructure__Connector != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newParentStructure__Connector))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newParentStructure__Connector != null)
                msgs = ((InternalEObject) newParentStructure__Connector).eInverseAdd(this,
                        CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE, ComposedStructure.class,
                        msgs);
            msgs = basicSetParentStructure__Connector(newParentStructure__Connector, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR, newParentStructure__Connector,
                    newParentStructure__Connector));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetParentStructure__Connector((ComposedStructure) otherEnd, msgs);
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
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            return basicSetParentStructure__Connector(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            return eInternalContainer()
                    .eInverseRemove(this, CompositionPackage.COMPOSED_STRUCTURE__CONNECTORS_COMPOSED_STRUCTURE,
                            ComposedStructure.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            return getParentStructure__Connector();
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
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            setParentStructure__Connector((ComposedStructure) newValue);
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
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            setParentStructure__Connector((ComposedStructure) null);
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
        case CompositionPackage.CONNECTOR__PARENT_STRUCTURE_CONNECTOR:
            return getParentStructure__Connector() != null;
        }
        return super.eIsSet(featureID);
    }

} // ConnectorImpl

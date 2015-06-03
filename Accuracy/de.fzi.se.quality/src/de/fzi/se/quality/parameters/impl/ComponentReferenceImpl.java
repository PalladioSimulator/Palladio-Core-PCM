/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fzi.se.quality.parameters.ComponentInstance;
import de.fzi.se.quality.parameters.ComponentReference;
import de.fzi.se.quality.parameters.ParametersPackage;
import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.impl.ComponentReferenceImpl#getComponentInstance <em>
 * Component Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class ComponentReferenceImpl extends IdentifierImpl implements ComponentReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ComponentReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParametersPackage.Literals.COMPONENT_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ComponentInstance getComponentInstance() {
        if (this.eContainerFeatureID() != ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE) {
            return null;
        }
        return (ComponentInstance) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetComponentInstance(final ComponentInstance newComponentInstance,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newComponentInstance,
                ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setComponentInstance(final ComponentInstance newComponentInstance) {
        if (newComponentInstance != this.eInternalContainer()
                || (this.eContainerFeatureID() != ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE && newComponentInstance != null)) {
            if (EcoreUtil.isAncestor(this, newComponentInstance)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newComponentInstance != null) {
                msgs = ((InternalEObject) newComponentInstance).eInverseAdd(this,
                        ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, ComponentInstance.class, msgs);
            }
            msgs = this.basicSetComponentInstance(newComponentInstance, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE, newComponentInstance,
                    newComponentInstance));
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetComponentInstance((ComponentInstance) otherEnd, msgs);
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            return this.basicSetComponentInstance(null, msgs);
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            return this.eInternalContainer().eInverseRemove(this,
                    ParametersPackage.COMPONENT_INSTANCE__COMPONENT_REFERENCE, ComponentInstance.class, msgs);
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            return this.getComponentInstance();
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            this.setComponentInstance((ComponentInstance) newValue);
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            this.setComponentInstance((ComponentInstance) null);
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
        case ParametersPackage.COMPONENT_REFERENCE__COMPONENT_INSTANCE:
            return this.getComponentInstance() != null;
        }
        return super.eIsSet(featureID);
    }

} // ComponentReferenceImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

import de.fzi.se.quality.parameters.impl.ComponentReferenceImpl;
import de.fzi.se.quality.parameters.pcm.PCMComponentReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentReferenceImpl#getBasicComponent <em>
 * Basic Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMComponentReferenceImpl extends ComponentReferenceImpl implements PCMComponentReference {

    /**
     * The cached value of the '{@link #getBasicComponent() <em>Basic Component</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getBasicComponent()
     * @generated
     * @ordered
     */
    protected BasicComponent basicComponent;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMComponentReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_COMPONENT_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BasicComponent getBasicComponent() {
        if (this.basicComponent != null && this.basicComponent.eIsProxy()) {
            final InternalEObject oldBasicComponent = (InternalEObject) this.basicComponent;
            this.basicComponent = (BasicComponent) this.eResolveProxy(oldBasicComponent);
            if (this.basicComponent != oldBasicComponent) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT, oldBasicComponent, this.basicComponent));
                }
            }
        }
        return this.basicComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public BasicComponent basicGetBasicComponent() {
        return this.basicComponent;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setBasicComponent(final BasicComponent newBasicComponent) {
        final BasicComponent oldBasicComponent = this.basicComponent;
        this.basicComponent = newBasicComponent;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT, oldBasicComponent, this.basicComponent));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
            if (resolve) {
                return this.getBasicComponent();
            }
            return this.basicGetBasicComponent();
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
        case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
            this.setBasicComponent((BasicComponent) newValue);
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
        case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
            this.setBasicComponent((BasicComponent) null);
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
        case PCMPackage.PCM_COMPONENT_REFERENCE__BASIC_COMPONENT:
            return this.basicComponent != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMComponentReferenceImpl

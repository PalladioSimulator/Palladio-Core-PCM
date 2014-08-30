/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;

import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Sub System Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl#getSubsystem <em>
 * Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SubSystemReferenceImpl extends MinimalEObjectImpl.Container implements SubSystemReference {
    /**
     * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSubsystem()
     * @generated
     * @ordered
     */
    protected SubSystem subsystem;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected SubSystemReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SUB_SYSTEM_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public SubSystem getSubsystem() {
        if (this.subsystem != null && ((EObject) this.subsystem).eIsProxy()) {
            final InternalEObject oldSubsystem = (InternalEObject) this.subsystem;
            this.subsystem = (SubSystem) this.eResolveProxy(oldSubsystem);
            if (this.subsystem != oldSubsystem) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM, oldSubsystem, this.subsystem));
                }
            }
        }
        return this.subsystem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public SubSystem basicGetSubsystem() {
        return this.subsystem;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSubsystem(final SubSystem newSubsystem) {
        final SubSystem oldSubsystem = this.subsystem;
        this.subsystem = newSubsystem;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM, oldSubsystem, this.subsystem));
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
            if (resolve) {
                return this.getSubsystem();
            }
            return this.basicGetSubsystem();
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
            this.setSubsystem((SubSystem) newValue);
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
            this.setSubsystem((SubSystem) null);
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
        case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
            return this.subsystem != null;
        }
        return super.eIsSet(featureID);
    }

} // SubSystemReferenceImpl

/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.subsystem.SubSystem;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Sub System Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.SubSystemReferenceImpl#getSubsystem <em>Subsystem</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class SubSystemReferenceImpl extends MinimalEObjectImpl.Container implements SubSystemReference {
    /**
     * The cached value of the '{@link #getSubsystem() <em>Subsystem</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSubsystem()
     * @generated
     * @ordered
     */
    protected SubSystem subsystem;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SubSystemReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.SUB_SYSTEM_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubSystem getSubsystem() {
        if (subsystem != null && subsystem.eIsProxy()) {
            InternalEObject oldSubsystem = (InternalEObject)subsystem;
            subsystem = (SubSystem)eResolveProxy(oldSubsystem);
            if (subsystem != oldSubsystem) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM, oldSubsystem, subsystem));
            }
        }
        return subsystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SubSystem basicGetSubsystem() {
        return subsystem;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSubsystem(SubSystem newSubsystem) {
        SubSystem oldSubsystem = subsystem;
        subsystem = newSubsystem;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM, oldSubsystem, subsystem));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
                if (resolve) return getSubsystem();
                return basicGetSubsystem();
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
                setSubsystem((SubSystem)newValue);
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
                setSubsystem((SubSystem)null);
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
            case PcmmeasuringpointPackage.SUB_SYSTEM_REFERENCE__SUBSYSTEM:
                return subsystem != null;
        }
        return super.eIsSet(featureID);
    }

} //SubSystemReferenceImpl

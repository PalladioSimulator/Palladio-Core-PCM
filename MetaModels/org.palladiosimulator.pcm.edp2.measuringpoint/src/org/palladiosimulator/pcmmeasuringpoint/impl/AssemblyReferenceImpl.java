/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assembly Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl#getAssembly <em>Assembly</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssemblyReferenceImpl extends MinimalEObjectImpl.Container implements AssemblyReference {
    /**
     * The cached value of the '{@link #getAssembly() <em>Assembly</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getAssembly()
     * @generated
     * @ordered
     */
    protected AssemblyContext assembly;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AssemblyReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssembly() {
        if (assembly != null && assembly.eIsProxy()) {
            InternalEObject oldAssembly = (InternalEObject)assembly;
            assembly = (AssemblyContext)eResolveProxy(oldAssembly);
            if (assembly != oldAssembly) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY, oldAssembly, assembly));
            }
        }
        return assembly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext basicGetAssembly() {
        return assembly;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssembly(AssemblyContext newAssembly) {
        AssemblyContext oldAssembly = assembly;
        assembly = newAssembly;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY, oldAssembly, assembly));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                if (resolve) return getAssembly();
                return basicGetAssembly();
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
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                setAssembly((AssemblyContext)newValue);
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
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                setAssembly((AssemblyContext)null);
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
            case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
                return assembly != null;
        }
        return super.eIsSet(featureID);
    }

} //AssemblyReferenceImpl

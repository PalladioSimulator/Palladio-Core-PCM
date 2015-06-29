/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.internal.cdo.CDOObjectImpl;
import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Assembly Reference</b></em>
 * '. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.palladiosimulator.pcmmeasuringpoint.impl.AssemblyReferenceImpl#getAssembly <em>
 * Assembly</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AssemblyReferenceImpl extends CDOObjectImpl implements AssemblyReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected AssemblyReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AssemblyContext getAssembly() {
        return (AssemblyContext) this.eDynamicGet(PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public AssemblyContext basicGetAssembly() {
        return (AssemblyContext) this.eDynamicGet(PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAssembly(final AssemblyContext newAssembly) {
        this.eDynamicSet(PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY,
                PcmmeasuringpointPackage.Literals.ASSEMBLY_REFERENCE__ASSEMBLY, newAssembly);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
            if (resolve) {
                return this.getAssembly();
            }
            return this.basicGetAssembly();
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
            this.setAssembly((AssemblyContext) newValue);
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
            this.setAssembly((AssemblyContext) null);
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
        switch (featureID)
        {
        case PcmmeasuringpointPackage.ASSEMBLY_REFERENCE__ASSEMBLY:
            return this.basicGetAssembly() != null;
        }
        return super.eIsSet(featureID);
    }

} // AssemblyReferenceImpl

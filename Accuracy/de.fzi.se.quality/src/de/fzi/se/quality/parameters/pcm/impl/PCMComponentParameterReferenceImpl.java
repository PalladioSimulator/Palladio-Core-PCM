/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm.impl;

import org.eclipse.emf.ecore.EClass;

import de.fzi.se.quality.parameters.pcm.PCMComponentParameterReference;
import de.fzi.se.quality.parameters.pcm.PCMPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Component Parameter Reference</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getImplementationComponentType
 * <em>Implementation Component Type</em>}</li>
 * <li>
 * {@link de.fzi.se.quality.parameters.pcm.impl.PCMComponentParameterReferenceImpl#getVariableUsage
 * <em>Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PCMComponentParameterReferenceImpl extends PCMParameterReferenceImpl implements
PCMComponentParameterReference {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected PCMComponentParameterReferenceImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ImplementationComponentType getImplementationComponentType() {
        return (ImplementationComponentType) this.eDynamicGet(
                PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ImplementationComponentType basicGetImplementationComponentType() {
        return (ImplementationComponentType) this.eDynamicGet(
                PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setImplementationComponentType(final ImplementationComponentType newImplementationComponentType) {
        this.eDynamicSet(PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE,
                newImplementationComponentType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public VariableUsage getVariableUsage() {
        return (VariableUsage) this.eDynamicGet(PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public VariableUsage basicGetVariableUsage() {
        return (VariableUsage) this.eDynamicGet(PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setVariableUsage(final VariableUsage newVariableUsage) {
        this.eDynamicSet(PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE,
                PCMPackage.Literals.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE, newVariableUsage);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            if (resolve) {
                return this.getImplementationComponentType();
            }
            return this.basicGetImplementationComponentType();
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            if (resolve) {
                return this.getVariableUsage();
            }
            return this.basicGetVariableUsage();
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            this.setImplementationComponentType((ImplementationComponentType) newValue);
            return;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            this.setVariableUsage((VariableUsage) newValue);
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            this.setImplementationComponentType((ImplementationComponentType) null);
            return;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            this.setVariableUsage((VariableUsage) null);
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
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__IMPLEMENTATION_COMPONENT_TYPE:
            return this.basicGetImplementationComponentType() != null;
        case PCMPackage.PCM_COMPONENT_PARAMETER_REFERENCE__VARIABLE_USAGE:
            return this.basicGetVariableUsage() != null;
        }
        return super.eIsSet(featureID);
    }

} // PCMComponentParameterReferenceImpl

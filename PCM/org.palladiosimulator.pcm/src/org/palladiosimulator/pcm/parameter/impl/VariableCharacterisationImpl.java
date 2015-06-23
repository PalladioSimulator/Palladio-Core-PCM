/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.parameter.impl;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.core.PCMRandomVariable;

import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableCharacterisationType;
import org.palladiosimulator.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Characterisation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableCharacterisationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableCharacterisationImpl#getSpecification_VariableCharacterisation <em>Specification Variable Characterisation</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableCharacterisationImpl#getVariableUsage_VariableCharacterisation <em>Variable Usage Variable Characterisation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableCharacterisationImpl extends CDOObjectImpl implements VariableCharacterisation {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getType() <em>Type</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getType()
     * @generated
     * @ordered
     */
    protected static final VariableCharacterisationType TYPE_EDEFAULT = VariableCharacterisationType.STRUCTURE;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableCharacterisationImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParameterPackage.Literals.VARIABLE_CHARACTERISATION;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected int eStaticFeatureCount() {
        return 0;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariableCharacterisationType getType() {
        return (VariableCharacterisationType) eDynamicGet(ParameterPackage.VARIABLE_CHARACTERISATION__TYPE,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__TYPE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setType(VariableCharacterisationType newType) {
        eDynamicSet(ParameterPackage.VARIABLE_CHARACTERISATION__TYPE,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__TYPE, newType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PCMRandomVariable getSpecification_VariableCharacterisation() {
        return (PCMRandomVariable) eDynamicGet(
                ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSpecification_VariableCharacterisation(
            PCMRandomVariable newSpecification_VariableCharacterisation, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newSpecification_VariableCharacterisation,
                ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpecification_VariableCharacterisation(PCMRandomVariable newSpecification_VariableCharacterisation) {
        eDynamicSet(ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION,
                newSpecification_VariableCharacterisation);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public VariableUsage getVariableUsage_VariableCharacterisation() {
        return (VariableUsage) eDynamicGet(
                ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION, true,
                true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetVariableUsage_VariableCharacterisation(
            VariableUsage newVariableUsage_VariableCharacterisation, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newVariableUsage_VariableCharacterisation,
                ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setVariableUsage_VariableCharacterisation(VariableUsage newVariableUsage_VariableCharacterisation) {
        eDynamicSet(ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION,
                ParameterPackage.Literals.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION,
                newVariableUsage_VariableCharacterisation);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            PCMRandomVariable specification_VariableCharacterisation = getSpecification_VariableCharacterisation();
            if (specification_VariableCharacterisation != null)
                msgs = ((InternalEObject) specification_VariableCharacterisation).eInverseRemove(this,
                        EOPPOSITE_FEATURE_BASE
                                - ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION,
                        null, msgs);
            return basicSetSpecification_VariableCharacterisation((PCMRandomVariable) otherEnd, msgs);
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetVariableUsage_VariableCharacterisation((VariableUsage) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            return basicSetSpecification_VariableCharacterisation(null, msgs);
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            return basicSetVariableUsage_VariableCharacterisation(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            return eInternalContainer().eInverseRemove(this,
                    ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE, VariableUsage.class,
                    msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ParameterPackage.VARIABLE_CHARACTERISATION__TYPE:
            return getType();
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            return getSpecification_VariableCharacterisation();
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            return getVariableUsage_VariableCharacterisation();
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
        case ParameterPackage.VARIABLE_CHARACTERISATION__TYPE:
            setType((VariableCharacterisationType) newValue);
            return;
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            setSpecification_VariableCharacterisation((PCMRandomVariable) newValue);
            return;
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            setVariableUsage_VariableCharacterisation((VariableUsage) newValue);
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
        case ParameterPackage.VARIABLE_CHARACTERISATION__TYPE:
            setType(TYPE_EDEFAULT);
            return;
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            setSpecification_VariableCharacterisation((PCMRandomVariable) null);
            return;
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            setVariableUsage_VariableCharacterisation((VariableUsage) null);
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
        case ParameterPackage.VARIABLE_CHARACTERISATION__TYPE:
            return getType() != TYPE_EDEFAULT;
        case ParameterPackage.VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION:
            return getSpecification_VariableCharacterisation() != null;
        case ParameterPackage.VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION:
            return getVariableUsage_VariableCharacterisation() != null;
        }
        return super.eIsSet(featureID);
    }

} //VariableCharacterisationImpl

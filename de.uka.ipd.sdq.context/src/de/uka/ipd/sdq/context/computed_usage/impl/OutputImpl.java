/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.Output;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Output</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.OutputImpl#getParameterCharacterisations_Output
 * <em>Parameter Characterisations Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutputImpl extends EObjectImpl implements Output {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The cached value of the '{@link #getParameterCharacterisations_Output()
     * <em>Parameter Characterisations Output</em>}' containment reference list. <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * 
     * @see #getParameterCharacterisations_Output()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> parameterCharacterisations_Output;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected OutputImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.OUTPUT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<VariableUsage> getParameterCharacterisations_Output() {
        if (parameterCharacterisations_Output == null) {
            parameterCharacterisations_Output = new EObjectContainmentEList<VariableUsage>(VariableUsage.class, this,
                    ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT);
        }
        return parameterCharacterisations_Output;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT:
            return ((InternalEList<?>) getParameterCharacterisations_Output()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT:
            return getParameterCharacterisations_Output();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT:
            getParameterCharacterisations_Output().clear();
            getParameterCharacterisations_Output().addAll((Collection<? extends VariableUsage>) newValue);
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
        case ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT:
            getParameterCharacterisations_Output().clear();
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
        case ComputedUsagePackage.OUTPUT__PARAMETER_CHARACTERISATIONS_OUTPUT:
            return parameterCharacterisations_Output != null && !parameterCharacterisations_Output.isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // OutputImpl

/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_usage.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.ExternalCallOutput;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Call Output</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl#getParameterCharacterisations_ExternalCallOutput
 * <em>Parameter Characterisations External Call Output</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_usage.impl.ExternalCallOutputImpl#getExternalCallAction_ExternalCallOutput
 * <em>External Call Action External Call Output</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalCallOutputImpl extends EObjectImpl implements ExternalCallOutput {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The cached value of the '{@link #getParameterCharacterisations_ExternalCallOutput()
     * <em>Parameter Characterisations External Call Output</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getParameterCharacterisations_ExternalCallOutput()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> parameterCharacterisations_ExternalCallOutput;

    /**
     * The cached value of the '{@link #getExternalCallAction_ExternalCallOutput()
     * <em>External Call Action External Call Output</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getExternalCallAction_ExternalCallOutput()
     * @generated
     * @ordered
     */
    protected ExternalCallAction externalCallAction_ExternalCallOutput;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ExternalCallOutputImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ComputedUsagePackage.Literals.EXTERNAL_CALL_OUTPUT;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EList<VariableUsage> getParameterCharacterisations_ExternalCallOutput() {
        if (parameterCharacterisations_ExternalCallOutput == null) {
            parameterCharacterisations_ExternalCallOutput = new EObjectContainmentEList<VariableUsage>(
                    VariableUsage.class, this,
                    ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT);
        }
        return parameterCharacterisations_ExternalCallOutput;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ExternalCallAction getExternalCallAction_ExternalCallOutput() {
        if (externalCallAction_ExternalCallOutput != null && externalCallAction_ExternalCallOutput.eIsProxy()) {
            InternalEObject oldExternalCallAction_ExternalCallOutput = (InternalEObject) externalCallAction_ExternalCallOutput;
            externalCallAction_ExternalCallOutput = (ExternalCallAction) eResolveProxy(oldExternalCallAction_ExternalCallOutput);
            if (externalCallAction_ExternalCallOutput != oldExternalCallAction_ExternalCallOutput) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT,
                            oldExternalCallAction_ExternalCallOutput, externalCallAction_ExternalCallOutput));
            }
        }
        return externalCallAction_ExternalCallOutput;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ExternalCallAction basicGetExternalCallAction_ExternalCallOutput() {
        return externalCallAction_ExternalCallOutput;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setExternalCallAction_ExternalCallOutput(ExternalCallAction newExternalCallAction_ExternalCallOutput) {
        ExternalCallAction oldExternalCallAction_ExternalCallOutput = externalCallAction_ExternalCallOutput;
        externalCallAction_ExternalCallOutput = newExternalCallAction_ExternalCallOutput;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT,
                    oldExternalCallAction_ExternalCallOutput, externalCallAction_ExternalCallOutput));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT:
            return ((InternalEList<?>) getParameterCharacterisations_ExternalCallOutput()).basicRemove(otherEnd, msgs);
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
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT:
            return getParameterCharacterisations_ExternalCallOutput();
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT:
            if (resolve)
                return getExternalCallAction_ExternalCallOutput();
            return basicGetExternalCallAction_ExternalCallOutput();
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
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT:
            getParameterCharacterisations_ExternalCallOutput().clear();
            getParameterCharacterisations_ExternalCallOutput().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT:
            setExternalCallAction_ExternalCallOutput((ExternalCallAction) newValue);
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
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT:
            getParameterCharacterisations_ExternalCallOutput().clear();
            return;
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT:
            setExternalCallAction_ExternalCallOutput((ExternalCallAction) null);
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
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__PARAMETER_CHARACTERISATIONS_EXTERNAL_CALL_OUTPUT:
            return parameterCharacterisations_ExternalCallOutput != null
                    && !parameterCharacterisations_ExternalCallOutput.isEmpty();
        case ComputedUsagePackage.EXTERNAL_CALL_OUTPUT__EXTERNAL_CALL_ACTION_EXTERNAL_CALL_OUTPUT:
            return externalCallAction_ExternalCallOutput != null;
        }
        return super.eIsSet(featureID);
    }

} // ExternalCallOutputImpl

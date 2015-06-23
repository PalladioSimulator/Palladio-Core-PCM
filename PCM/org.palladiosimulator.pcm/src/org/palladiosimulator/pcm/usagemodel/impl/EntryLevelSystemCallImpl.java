/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.usagemodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.palladiosimulator.pcm.parameter.VariableUsage;
import org.palladiosimulator.pcm.repository.OperationProvidedRole;
import org.palladiosimulator.pcm.repository.OperationSignature;
import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Entry Level System Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>
 * {@link org.palladiosimulator.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getProvidedRole_EntryLevelSystemCall
 * <em>Provided Role Entry Level System Call</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOperationSignature__EntryLevelSystemCall
 * <em>Operation Signature Entry Level System Call</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOutputParameterUsages_EntryLevelSystemCall
 * <em>Output Parameter Usages Entry Level System Call</em>}</li>
 * <li>{@link org.palladiosimulator.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getPriority
 * <em>Priority</em>}</li>
 * <li>
 * {@link org.palladiosimulator.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getInputParameterUsages_EntryLevelSystemCall
 * <em>Input Parameter Usages Entry Level System Call</em>}</li>
 * </ul>
 *
 * @generated
 */
public class EntryLevelSystemCallImpl extends AbstractUserActionImpl implements EntryLevelSystemCall {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected static final int PRIORITY_EDEFAULT = 0;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected EntryLevelSystemCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationProvidedRole getProvidedRole_EntryLevelSystemCall() {
        return (OperationProvidedRole) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationProvidedRole basicGetProvidedRole_EntryLevelSystemCall() {
        return (OperationProvidedRole) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, false, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setProvidedRole_EntryLevelSystemCall(final OperationProvidedRole newProvidedRole_EntryLevelSystemCall) {
        this.eDynamicSet(UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL,
                newProvidedRole_EntryLevelSystemCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public OperationSignature getOperationSignature__EntryLevelSystemCall() {
        return (OperationSignature) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, true,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public OperationSignature basicGetOperationSignature__EntryLevelSystemCall() {
        return (OperationSignature) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, false,
                true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setOperationSignature__EntryLevelSystemCall(
            final OperationSignature newOperationSignature__EntryLevelSystemCall) {
        this.eDynamicSet(UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL,
                newOperationSignature__EntryLevelSystemCall);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getOutputParameterUsages_EntryLevelSystemCall() {
        return (EList<VariableUsage>) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int getPriority() {
        return (Integer) this.eDynamicGet(UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY, true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setPriority(final int newPriority) {
        this.eDynamicSet(UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY, newPriority);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    @SuppressWarnings("unchecked")
    public EList<VariableUsage> getInputParameterUsages_EntryLevelSystemCall() {
        return (EList<VariableUsage>) this.eDynamicGet(
                UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                true, true);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                                UsagemodelValidator.ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "EntryLevelSystemCallMustReferenceProvidedRoleOfASystem",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EntryLevelSystemCallSignatureMustMatchItsProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        // TODO: implement this method
        // -> specify the condition that violates the invariant
        // -> verify the details of the diagnostic, including severity and message
        // Ensure that you remove @generated or mark it @generated NOT
        if (false) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(Diagnostic.ERROR, UsagemodelValidator.DIAGNOSTIC_SOURCE,
                                UsagemodelValidator.ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic",
                                        new Object[] { "EntryLevelSystemCallSignatureMustMatchItsProvidedRole",
                                                EObjectValidator.getObjectLabel(this, context) }),
                        new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID,
            final NotificationChain msgs) {
        switch (featureID) {
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getOutputParameterUsages_EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this
                    .getInputParameterUsages_EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
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
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return ((InternalEList<?>) this.getOutputParameterUsages_EntryLevelSystemCall()).basicRemove(otherEnd,
                    msgs);
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return ((InternalEList<?>) this.getInputParameterUsages_EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
            if (resolve) {
                return this.getProvidedRole_EntryLevelSystemCall();
            }
            return this.basicGetProvidedRole_EntryLevelSystemCall();
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
            if (resolve) {
                return this.getOperationSignature__EntryLevelSystemCall();
            }
            return this.basicGetOperationSignature__EntryLevelSystemCall();
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return this.getOutputParameterUsages_EntryLevelSystemCall();
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
            return this.getPriority();
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return this.getInputParameterUsages_EntryLevelSystemCall();
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
    public void eSet(final int featureID, final Object newValue) {
        switch (featureID) {
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
            this.setProvidedRole_EntryLevelSystemCall((OperationProvidedRole) newValue);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
            this.setOperationSignature__EntryLevelSystemCall((OperationSignature) newValue);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            this.getOutputParameterUsages_EntryLevelSystemCall().clear();
            this.getOutputParameterUsages_EntryLevelSystemCall().addAll((Collection<? extends VariableUsage>) newValue);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
            this.setPriority((Integer) newValue);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            this.getInputParameterUsages_EntryLevelSystemCall().clear();
            this.getInputParameterUsages_EntryLevelSystemCall().addAll((Collection<? extends VariableUsage>) newValue);
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
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
            this.setProvidedRole_EntryLevelSystemCall((OperationProvidedRole) null);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
            this.setOperationSignature__EntryLevelSystemCall((OperationSignature) null);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            this.getOutputParameterUsages_EntryLevelSystemCall().clear();
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
            this.setPriority(PRIORITY_EDEFAULT);
            return;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            this.getInputParameterUsages_EntryLevelSystemCall().clear();
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
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
            return this.basicGetProvidedRole_EntryLevelSystemCall() != null;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
            return this.basicGetOperationSignature__EntryLevelSystemCall() != null;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return !this.getOutputParameterUsages_EntryLevelSystemCall().isEmpty();
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
            return this.getPriority() != PRIORITY_EDEFAULT;
        case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
            return !this.getInputParameterUsages_EntryLevelSystemCall().isEmpty();
        }
        return super.eIsSet(featureID);
    }

} // EntryLevelSystemCallImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 */
package org.palladiosimulator.pcm.parameter.impl;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.emf.internal.cdo.CDOObjectImpl;

import org.palladiosimulator.pcm.core.composition.AssemblyContext;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;

import org.palladiosimulator.pcm.parameter.ParameterPackage;
import org.palladiosimulator.pcm.parameter.VariableCharacterisation;
import org.palladiosimulator.pcm.parameter.VariableUsage;

import org.palladiosimulator.pcm.qosannotations.QosannotationsPackage;
import org.palladiosimulator.pcm.qosannotations.SpecifiedOutputParameterAbstraction;

import org.palladiosimulator.pcm.seff.CallAction;
import org.palladiosimulator.pcm.seff.CallReturnAction;
import org.palladiosimulator.pcm.seff.SeffPackage;
import org.palladiosimulator.pcm.seff.SetVariableAction;
import org.palladiosimulator.pcm.seff.SynchronisationPoint;

import org.palladiosimulator.pcm.usagemodel.EntryLevelSystemCall;
import org.palladiosimulator.pcm.usagemodel.UsagemodelPackage;
import org.palladiosimulator.pcm.usagemodel.UserData;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getUserData_VariableUsage <em>User Data Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getCallAction__VariableUsage <em>Call Action Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getSynchronisationPoint_VariableUsage <em>Synchronisation Point Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getCallReturnAction__VariableUsage <em>Call Return Action Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getSetVariableAction_VariableUsage <em>Set Variable Action Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage <em>Specified Output Parameter Abstraction expected External Outputs Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getAssemblyContext__VariableUsage <em>Assembly Context Variable Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getEntryLevelSystemCall_InputParameterUsage <em>Entry Level System Call Input Parameter Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getEntryLevelSystemCall_OutputParameterUsage <em>Entry Level System Call Output Parameter Usage</em>}</li>
 *   <li>{@link org.palladiosimulator.pcm.parameter.impl.VariableUsageImpl#getNamedReference__VariableUsage <em>Named Reference Variable Usage</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VariableUsageImpl extends CDOObjectImpl implements VariableUsage {

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected VariableUsageImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return ParameterPackage.Literals.VARIABLE_USAGE;
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
    @SuppressWarnings("unchecked")
    public EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage() {
        return (EList<VariableCharacterisation>) eDynamicGet(
                ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public UserData getUserData_VariableUsage() {
        return (UserData) eDynamicGet(ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetUserData_VariableUsage(UserData newUserData_VariableUsage,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newUserData_VariableUsage,
                ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setUserData_VariableUsage(UserData newUserData_VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE, newUserData_VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CallAction getCallAction__VariableUsage() {
        return (CallAction) eDynamicGet(ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCallAction__VariableUsage(CallAction newCallAction__VariableUsage,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newCallAction__VariableUsage,
                ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCallAction__VariableUsage(CallAction newCallAction__VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE, newCallAction__VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SynchronisationPoint getSynchronisationPoint_VariableUsage() {
        return (SynchronisationPoint) eDynamicGet(ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSynchronisationPoint_VariableUsage(
            SynchronisationPoint newSynchronisationPoint_VariableUsage, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newSynchronisationPoint_VariableUsage,
                ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSynchronisationPoint_VariableUsage(SynchronisationPoint newSynchronisationPoint_VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE,
                newSynchronisationPoint_VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public CallReturnAction getCallReturnAction__VariableUsage() {
        return (CallReturnAction) eDynamicGet(ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetCallReturnAction__VariableUsage(
            CallReturnAction newCallReturnAction__VariableUsage, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newCallReturnAction__VariableUsage,
                ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setCallReturnAction__VariableUsage(CallReturnAction newCallReturnAction__VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE,
                newCallReturnAction__VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SetVariableAction getSetVariableAction_VariableUsage() {
        return (SetVariableAction) eDynamicGet(ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSetVariableAction_VariableUsage(
            SetVariableAction newSetVariableAction_VariableUsage, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newSetVariableAction_VariableUsage,
                ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSetVariableAction_VariableUsage(SetVariableAction newSetVariableAction_VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE,
                newSetVariableAction_VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public SpecifiedOutputParameterAbstraction getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() {
        return (SpecifiedOutputParameterAbstraction) eDynamicGet(
                ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE,
                true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(
            SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage,
            NotificationChain msgs) {
        msgs = eBasicSetContainer(
                (InternalEObject) newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage,
                ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE,
                msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(
            SpecifiedOutputParameterAbstraction newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage) {
        eDynamicSet(
                ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE,
                newSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AssemblyContext getAssemblyContext__VariableUsage() {
        return (AssemblyContext) eDynamicGet(ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetAssemblyContext__VariableUsage(AssemblyContext newAssemblyContext__VariableUsage,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newAssemblyContext__VariableUsage,
                ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setAssemblyContext__VariableUsage(AssemblyContext newAssemblyContext__VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE,
                newAssemblyContext__VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EntryLevelSystemCall getEntryLevelSystemCall_InputParameterUsage() {
        return (EntryLevelSystemCall) eDynamicGet(
                ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEntryLevelSystemCall_InputParameterUsage(
            EntryLevelSystemCall newEntryLevelSystemCall_InputParameterUsage, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newEntryLevelSystemCall_InputParameterUsage,
                ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntryLevelSystemCall_InputParameterUsage(
            EntryLevelSystemCall newEntryLevelSystemCall_InputParameterUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE,
                newEntryLevelSystemCall_InputParameterUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EntryLevelSystemCall getEntryLevelSystemCall_OutputParameterUsage() {
        return (EntryLevelSystemCall) eDynamicGet(
                ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetEntryLevelSystemCall_OutputParameterUsage(
            EntryLevelSystemCall newEntryLevelSystemCall_OutputParameterUsage, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newEntryLevelSystemCall_OutputParameterUsage,
                ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEntryLevelSystemCall_OutputParameterUsage(
            EntryLevelSystemCall newEntryLevelSystemCall_OutputParameterUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE,
                newEntryLevelSystemCall_OutputParameterUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public AbstractNamedReference getNamedReference__VariableUsage() {
        return (AbstractNamedReference) eDynamicGet(ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, true, true);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetNamedReference__VariableUsage(
            AbstractNamedReference newNamedReference__VariableUsage, NotificationChain msgs) {
        msgs = eDynamicInverseAdd((InternalEObject) newNamedReference__VariableUsage,
                ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setNamedReference__VariableUsage(AbstractNamedReference newNamedReference__VariableUsage) {
        eDynamicSet(ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE,
                ParameterPackage.Literals.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE,
                newNamedReference__VariableUsage);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) getVariableCharacterisation_VariableUsage())
                    .basicAdd(otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetUserData_VariableUsage((UserData) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetCallAction__VariableUsage((CallAction) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetSynchronisationPoint_VariableUsage((SynchronisationPoint) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetCallReturnAction__VariableUsage((CallReturnAction) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetSetVariableAction_VariableUsage((SetVariableAction) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(
                    (SpecifiedOutputParameterAbstraction) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetAssemblyContext__VariableUsage((AssemblyContext) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetEntryLevelSystemCall_InputParameterUsage((EntryLevelSystemCall) otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall) otherEnd, msgs);
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
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            return ((InternalEList<?>) getVariableCharacterisation_VariableUsage()).basicRemove(otherEnd, msgs);
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            return basicSetUserData_VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            return basicSetCallAction__VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            return basicSetSynchronisationPoint_VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            return basicSetCallReturnAction__VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            return basicSetSetVariableAction_VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            return basicSetSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            return basicSetAssemblyContext__VariableUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            return basicSetEntryLevelSystemCall_InputParameterUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            return basicSetEntryLevelSystemCall_OutputParameterUsage(null, msgs);
        case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
            return basicSetNamedReference__VariableUsage(null, msgs);
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
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.USER_DATA__USER_DATA_PARAMETER_USAGES_USER_DATA, UserData.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this, SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION,
                    CallAction.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.SYNCHRONISATION_POINT__OUTPUT_PARAMETER_USAGE_SYNCHRONISATION_POINT,
                    SynchronisationPoint.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION, CallReturnAction.class,
                    msgs);
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.SET_VARIABLE_ACTION__LOCAL_VARIABLE_USAGES_SET_VARIABLE_ACTION, SetVariableAction.class,
                    msgs);
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    QosannotationsPackage.SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION__EXPECTED_EXTERNAL_OUTPUTS_SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION,
                    SpecifiedOutputParameterAbstraction.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    CompositionPackage.ASSEMBLY_CONTEXT__CONFIG_PARAMETER_USAGES_ASSEMBLY_CONTEXT,
                    AssemblyContext.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                    EntryLevelSystemCall.class, msgs);
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            return eInternalContainer().eInverseRemove(this,
                    UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL,
                    EntryLevelSystemCall.class, msgs);
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
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            return getVariableCharacterisation_VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            return getUserData_VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            return getCallAction__VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            return getSynchronisationPoint_VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            return getCallReturnAction__VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            return getSetVariableAction_VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            return getAssemblyContext__VariableUsage();
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            return getEntryLevelSystemCall_InputParameterUsage();
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            return getEntryLevelSystemCall_OutputParameterUsage();
        case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
            return getNamedReference__VariableUsage();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            getVariableCharacterisation_VariableUsage().clear();
            getVariableCharacterisation_VariableUsage()
                    .addAll((Collection<? extends VariableCharacterisation>) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            setUserData_VariableUsage((UserData) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            setCallAction__VariableUsage((CallAction) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            setSynchronisationPoint_VariableUsage((SynchronisationPoint) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            setCallReturnAction__VariableUsage((CallReturnAction) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            setSetVariableAction_VariableUsage((SetVariableAction) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(
                    (SpecifiedOutputParameterAbstraction) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            setAssemblyContext__VariableUsage((AssemblyContext) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            setEntryLevelSystemCall_InputParameterUsage((EntryLevelSystemCall) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            setEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall) newValue);
            return;
        case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
            setNamedReference__VariableUsage((AbstractNamedReference) newValue);
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
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            getVariableCharacterisation_VariableUsage().clear();
            return;
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            setUserData_VariableUsage((UserData) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            setCallAction__VariableUsage((CallAction) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            setSynchronisationPoint_VariableUsage((SynchronisationPoint) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            setCallReturnAction__VariableUsage((CallReturnAction) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            setSetVariableAction_VariableUsage((SetVariableAction) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            setSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(
                    (SpecifiedOutputParameterAbstraction) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            setAssemblyContext__VariableUsage((AssemblyContext) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            setEntryLevelSystemCall_InputParameterUsage((EntryLevelSystemCall) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            setEntryLevelSystemCall_OutputParameterUsage((EntryLevelSystemCall) null);
            return;
        case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
            setNamedReference__VariableUsage((AbstractNamedReference) null);
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
        case ParameterPackage.VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE:
            return !getVariableCharacterisation_VariableUsage().isEmpty();
        case ParameterPackage.VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE:
            return getUserData_VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE:
            return getCallAction__VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE:
            return getSynchronisationPoint_VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE:
            return getCallReturnAction__VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE:
            return getSetVariableAction_VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE:
            return getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE:
            return getAssemblyContext__VariableUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE:
            return getEntryLevelSystemCall_InputParameterUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE:
            return getEntryLevelSystemCall_OutputParameterUsage() != null;
        case ParameterPackage.VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE:
            return getNamedReference__VariableUsage() != null;
        }
        return super.eIsSet(featureID);
    }

} //VariableUsageImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.usagemodel.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Entry Level System Call</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getProvidedRole_EntryLevelSystemCall <em>Provided Role Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOperationSignature__EntryLevelSystemCall <em>Operation Signature Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getOutputParameterUsages_EntryLevelSystemCall <em>Output Parameter Usages Entry Level System Call</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getPriority <em>Priority</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.usagemodel.impl.EntryLevelSystemCallImpl#getInputParameterUsages_EntryLevelSystemCall <em>Input Parameter Usages Entry Level System Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryLevelSystemCallImpl extends AbstractUserActionImpl implements EntryLevelSystemCall {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getProvidedRole_EntryLevelSystemCall() <em>Provided Role Entry Level System Call</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getProvidedRole_EntryLevelSystemCall()
     * @generated
     * @ordered
     */
    protected OperationProvidedRole providedRole_EntryLevelSystemCall;

    /**
     * The cached value of the '{@link #getOperationSignature__EntryLevelSystemCall() <em>Operation Signature Entry Level System Call</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getOperationSignature__EntryLevelSystemCall()
     * @generated
     * @ordered
     */
    protected OperationSignature operationSignature__EntryLevelSystemCall;

    /**
     * The cached value of the '{@link #getOutputParameterUsages_EntryLevelSystemCall()
     * <em>Output Parameter Usages Entry Level System Call</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getOutputParameterUsages_EntryLevelSystemCall()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> outputParameterUsages_EntryLevelSystemCall;

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
     * The cached value of the '{@link #getPriority() <em>Priority</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getPriority()
     * @generated
     * @ordered
     */
    protected int priority = PRIORITY_EDEFAULT;

    /**
     * The cached value of the '{@link #getInputParameterUsages_EntryLevelSystemCall()
     * <em>Input Parameter Usages Entry Level System Call</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getInputParameterUsages_EntryLevelSystemCall()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> inputParameterUsages_EntryLevelSystemCall;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected EntryLevelSystemCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<VariableUsage> getInputParameterUsages_EntryLevelSystemCall() {
        if (inputParameterUsages_EntryLevelSystemCall == null) {
            inputParameterUsages_EntryLevelSystemCall = new EObjectContainmentWithInverseEList<VariableUsage>(VariableUsage.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE);
        }
        return inputParameterUsages_EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getPriority() {
        return priority;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setPriority(int newPriority) {
        int oldPriority = priority;
        priority = newPriority;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY, oldPriority, priority));
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Entry Level System Call Must Reference Provided Role Of ASystem</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole.oclIsTypeOf(pcm::system::System)";

    /**
     * The cached OCL invariant for the '{@link #EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Entry Level System Call Must Reference Provided Role Of ASystem</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean EntryLevelSystemCallMustReferenceProvidedRoleOfASystem(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL);
            try {
                ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         UsagemodelValidator.DIAGNOSTIC_SOURCE,
                         UsagemodelValidator.ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_MUST_REFERENCE_PROVIDED_ROLE_OF_ASYSTEM,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EntryLevelSystemCallMustReferenceProvidedRoleOfASystem", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EntryLevelSystemCallSignatureMustMatchItsProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Entry Level System Call Signature Must Match Its Provided Role</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #EntryLevelSystemCallSignatureMustMatchItsProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.providedRole_EntryLevelSystemCall.providedInterface__OperationProvidedRole.signatures__OperationInterface->includes(self.operationSignature__EntryLevelSystemCall)";

    /**
     * The cached OCL invariant for the '{@link #EntryLevelSystemCallSignatureMustMatchItsProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Entry Level System Call Signature Must Match Its Provided Role</em>}' invariant operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #EntryLevelSystemCallSignatureMustMatchItsProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean EntryLevelSystemCallSignatureMustMatchItsProvidedRole(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(UsagemodelPackage.Literals.ENTRY_LEVEL_SYSTEM_CALL);
            try {
                ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         UsagemodelValidator.DIAGNOSTIC_SOURCE,
                         UsagemodelValidator.ENTRY_LEVEL_SYSTEM_CALL__ENTRY_LEVEL_SYSTEM_CALL_SIGNATURE_MUST_MATCH_ITS_PROVIDED_ROLE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "EntryLevelSystemCallSignatureMustMatchItsProvidedRole", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationProvidedRole getProvidedRole_EntryLevelSystemCall() {
        if (providedRole_EntryLevelSystemCall != null && ((EObject)providedRole_EntryLevelSystemCall).eIsProxy()) {
            InternalEObject oldProvidedRole_EntryLevelSystemCall = (InternalEObject)providedRole_EntryLevelSystemCall;
            providedRole_EntryLevelSystemCall = (OperationProvidedRole)eResolveProxy(oldProvidedRole_EntryLevelSystemCall);
            if (providedRole_EntryLevelSystemCall != oldProvidedRole_EntryLevelSystemCall) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldProvidedRole_EntryLevelSystemCall, providedRole_EntryLevelSystemCall));
            }
        }
        return providedRole_EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationProvidedRole basicGetProvidedRole_EntryLevelSystemCall() {
        return providedRole_EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setProvidedRole_EntryLevelSystemCall(OperationProvidedRole newProvidedRole_EntryLevelSystemCall) {
        OperationProvidedRole oldProvidedRole_EntryLevelSystemCall = providedRole_EntryLevelSystemCall;
        providedRole_EntryLevelSystemCall = newProvidedRole_EntryLevelSystemCall;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL, oldProvidedRole_EntryLevelSystemCall, providedRole_EntryLevelSystemCall));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature getOperationSignature__EntryLevelSystemCall() {
        if (operationSignature__EntryLevelSystemCall != null && ((EObject)operationSignature__EntryLevelSystemCall).eIsProxy()) {
            InternalEObject oldOperationSignature__EntryLevelSystemCall = (InternalEObject)operationSignature__EntryLevelSystemCall;
            operationSignature__EntryLevelSystemCall = (OperationSignature)eResolveProxy(oldOperationSignature__EntryLevelSystemCall);
            if (operationSignature__EntryLevelSystemCall != oldOperationSignature__EntryLevelSystemCall) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldOperationSignature__EntryLevelSystemCall, operationSignature__EntryLevelSystemCall));
            }
        }
        return operationSignature__EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature basicGetOperationSignature__EntryLevelSystemCall() {
        return operationSignature__EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setOperationSignature__EntryLevelSystemCall(
            OperationSignature newOperationSignature__EntryLevelSystemCall) {
        OperationSignature oldOperationSignature__EntryLevelSystemCall = operationSignature__EntryLevelSystemCall;
        operationSignature__EntryLevelSystemCall = newOperationSignature__EntryLevelSystemCall;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL, oldOperationSignature__EntryLevelSystemCall, operationSignature__EntryLevelSystemCall));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<VariableUsage> getOutputParameterUsages_EntryLevelSystemCall() {
        if (outputParameterUsages_EntryLevelSystemCall == null) {
            outputParameterUsages_EntryLevelSystemCall = new EObjectContainmentWithInverseEList<VariableUsage>(VariableUsage.class, this, UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL, ParameterPackage.VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE);
        }
        return outputParameterUsages_EntryLevelSystemCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutputParameterUsages_EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputParameterUsages_EntryLevelSystemCall()).basicAdd(otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return ((InternalEList<?>)getOutputParameterUsages_EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return ((InternalEList<?>)getInputParameterUsages_EntryLevelSystemCall()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
                if (resolve) return getProvidedRole_EntryLevelSystemCall();
                return basicGetProvidedRole_EntryLevelSystemCall();
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
                if (resolve) return getOperationSignature__EntryLevelSystemCall();
                return basicGetOperationSignature__EntryLevelSystemCall();
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return getOutputParameterUsages_EntryLevelSystemCall();
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
                return getPriority();
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return getInputParameterUsages_EntryLevelSystemCall();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @SuppressWarnings("unchecked")
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
                setProvidedRole_EntryLevelSystemCall((OperationProvidedRole)newValue);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
                setOperationSignature__EntryLevelSystemCall((OperationSignature)newValue);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                getOutputParameterUsages_EntryLevelSystemCall().clear();
                getOutputParameterUsages_EntryLevelSystemCall().addAll((Collection<? extends VariableUsage>)newValue);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
                setPriority((Integer)newValue);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                getInputParameterUsages_EntryLevelSystemCall().clear();
                getInputParameterUsages_EntryLevelSystemCall().addAll((Collection<? extends VariableUsage>)newValue);
                return;
        }
        super.eSet(featureID, newValue);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public void eUnset(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
                setProvidedRole_EntryLevelSystemCall((OperationProvidedRole)null);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
                setOperationSignature__EntryLevelSystemCall((OperationSignature)null);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                getOutputParameterUsages_EntryLevelSystemCall().clear();
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
                setPriority(PRIORITY_EDEFAULT);
                return;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                getInputParameterUsages_EntryLevelSystemCall().clear();
                return;
        }
        super.eUnset(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean eIsSet(int featureID) {
        switch (featureID) {
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PROVIDED_ROLE_ENTRY_LEVEL_SYSTEM_CALL:
                return providedRole_EntryLevelSystemCall != null;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OPERATION_SIGNATURE_ENTRY_LEVEL_SYSTEM_CALL:
                return operationSignature__EntryLevelSystemCall != null;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__OUTPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return outputParameterUsages_EntryLevelSystemCall != null && !outputParameterUsages_EntryLevelSystemCall.isEmpty();
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__PRIORITY:
                return priority != PRIORITY_EDEFAULT;
            case UsagemodelPackage.ENTRY_LEVEL_SYSTEM_CALL__INPUT_PARAMETER_USAGES_ENTRY_LEVEL_SYSTEM_CALL:
                return inputParameterUsages_EntryLevelSystemCall != null && !inputParameterUsages_EntryLevelSystemCall.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (priority: ");
        result.append(priority);
        result.append(')');
        return result.toString();
    }

    /**
     * The cached environment for evaluating OCL expressions.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // EntryLevelSystemCallImpl

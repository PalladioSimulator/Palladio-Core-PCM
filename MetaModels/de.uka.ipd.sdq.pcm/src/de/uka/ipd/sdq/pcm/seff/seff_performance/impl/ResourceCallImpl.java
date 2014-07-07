/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.impl;

import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.core.entity.ResourceRequiredRole;
import de.uka.ipd.sdq.pcm.resourcetype.ResourceSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.CallActionImpl;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ResourceCall;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.util.SeffPerformanceValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object ' <em><b>Resource Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ResourceCallImpl#getAction__ResourceCall
 * <em>Action Resource Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ResourceCallImpl#getResourceRequiredRole__ResourceCall
 * <em>Resource Required Role Resource Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ResourceCallImpl#getSignature__ResourceCall
 * <em>Signature Resource Call</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ResourceCallImpl#getNumberOfCalls__ResourceCall
 * <em>Number Of Calls Resource Call</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceCallImpl extends CallActionImpl implements ResourceCall {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getResourceRequiredRole__ResourceCall()
     * <em>Resource Required Role Resource Call</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getResourceRequiredRole__ResourceCall()
     * @generated
     * @ordered
     */
    protected ResourceRequiredRole resourceRequiredRole__ResourceCall;

    /**
     * The cached value of the '{@link #getSignature__ResourceCall()
     * <em>Signature Resource Call</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSignature__ResourceCall()
     * @generated
     * @ordered
     */
    protected ResourceSignature signature__ResourceCall;

    /**
     * The cached value of the '{@link #getNumberOfCalls__ResourceCall()
     * <em>Number Of Calls Resource Call</em>}' containment reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @see #getNumberOfCalls__ResourceCall()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable numberOfCalls__ResourceCall;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ResourceCallImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPerformancePackage.Literals.RESOURCE_CALL;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AbstractInternalControlFlowAction getAction__ResourceCall() {
        if (eContainerFeatureID() != SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL)
            return null;
        return (AbstractInternalControlFlowAction) eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetAction__ResourceCall(AbstractInternalControlFlowAction newAction__ResourceCall,
            NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newAction__ResourceCall,
                SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setAction__ResourceCall(AbstractInternalControlFlowAction newAction__ResourceCall) {
        if (newAction__ResourceCall != eInternalContainer()
                || (eContainerFeatureID() != SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL && newAction__ResourceCall != null)) {
            if (EcoreUtil.isAncestor(this, (EObject) newAction__ResourceCall))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAction__ResourceCall != null)
                msgs = ((InternalEObject) newAction__ResourceCall).eInverseAdd(this,
                        SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION,
                        AbstractInternalControlFlowAction.class, msgs);
            msgs = basicSetAction__ResourceCall(newAction__ResourceCall, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL, newAction__ResourceCall,
                    newAction__ResourceCall));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceRequiredRole getResourceRequiredRole__ResourceCall() {
        if (resourceRequiredRole__ResourceCall != null && ((EObject) resourceRequiredRole__ResourceCall).eIsProxy()) {
            InternalEObject oldResourceRequiredRole__ResourceCall = (InternalEObject) resourceRequiredRole__ResourceCall;
            resourceRequiredRole__ResourceCall = (ResourceRequiredRole) eResolveProxy(oldResourceRequiredRole__ResourceCall);
            if (resourceRequiredRole__ResourceCall != oldResourceRequiredRole__ResourceCall) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL,
                            oldResourceRequiredRole__ResourceCall, resourceRequiredRole__ResourceCall));
            }
        }
        return resourceRequiredRole__ResourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceRequiredRole basicGetResourceRequiredRole__ResourceCall() {
        return resourceRequiredRole__ResourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setResourceRequiredRole__ResourceCall(ResourceRequiredRole newResourceRequiredRole__ResourceCall) {
        ResourceRequiredRole oldResourceRequiredRole__ResourceCall = resourceRequiredRole__ResourceCall;
        resourceRequiredRole__ResourceCall = newResourceRequiredRole__ResourceCall;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL,
                    oldResourceRequiredRole__ResourceCall, resourceRequiredRole__ResourceCall));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceSignature getSignature__ResourceCall() {
        if (signature__ResourceCall != null && ((EObject) signature__ResourceCall).eIsProxy()) {
            InternalEObject oldSignature__ResourceCall = (InternalEObject) signature__ResourceCall;
            signature__ResourceCall = (ResourceSignature) eResolveProxy(oldSignature__ResourceCall);
            if (signature__ResourceCall != oldSignature__ResourceCall) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL, oldSignature__ResourceCall,
                            signature__ResourceCall));
            }
        }
        return signature__ResourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ResourceSignature basicGetSignature__ResourceCall() {
        return signature__ResourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setSignature__ResourceCall(ResourceSignature newSignature__ResourceCall) {
        ResourceSignature oldSignature__ResourceCall = signature__ResourceCall;
        signature__ResourceCall = newSignature__ResourceCall;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL, oldSignature__ResourceCall,
                    signature__ResourceCall));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public PCMRandomVariable getNumberOfCalls__ResourceCall() {
        return numberOfCalls__ResourceCall;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetNumberOfCalls__ResourceCall(PCMRandomVariable newNumberOfCalls__ResourceCall,
            NotificationChain msgs) {
        PCMRandomVariable oldNumberOfCalls__ResourceCall = numberOfCalls__ResourceCall;
        numberOfCalls__ResourceCall = newNumberOfCalls__ResourceCall;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL,
                    oldNumberOfCalls__ResourceCall, newNumberOfCalls__ResourceCall);
            if (msgs == null)
                msgs = notification;
            else
                msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void setNumberOfCalls__ResourceCall(PCMRandomVariable newNumberOfCalls__ResourceCall) {
        if (newNumberOfCalls__ResourceCall != numberOfCalls__ResourceCall) {
            NotificationChain msgs = null;
            if (numberOfCalls__ResourceCall != null)
                msgs = ((InternalEObject) numberOfCalls__ResourceCall).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            if (newNumberOfCalls__ResourceCall != null)
                msgs = ((InternalEObject) newNumberOfCalls__ResourceCall).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__RESOURCE_CALL_PCM_RANDOM_VARIABLE, PCMRandomVariable.class,
                        msgs);
            msgs = basicSetNumberOfCalls__ResourceCall(newNumberOfCalls__ResourceCall, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL,
                    newNumberOfCalls__ResourceCall, newNumberOfCalls__ResourceCall));
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ResourceSignatureBelongsToResourceRequiredRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Resource Signature Belongs To Resource Required Role</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ResourceSignatureBelongsToResourceRequiredRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.resourceRequiredRole__ResourceCall.requiredResourceInterface__ResourceRequiredRole.resourceSignatures__ResourceInterface->includes(self.signature__ResourceCall)";

    /**
     * The cached OCL invariant for the '
     * {@link #ResourceSignatureBelongsToResourceRequiredRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Resource Signature Belongs To Resource Required Role</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ResourceSignatureBelongsToResourceRequiredRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ResourceSignatureBelongsToResourceRequiredRole(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.RESOURCE_CALL);
            try {
                RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.RESOURCE_CALL__RESOURCE_SIGNATURE_BELONGS_TO_RESOURCE_REQUIRED_ROLE,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "ResourceSignatureBelongsToResourceRequiredRole",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ResourceRequiredRoleMustBeReferencedByComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Resource Required Role Must Be Referenced By Component</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ResourceRequiredRoleMustBeReferencedByComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.oclAsType(ecore::EObject)->closure(eContainer())->select( entity | entity.oclIsKindOf(pcm::core::entity::ResourceInterfaceRequiringEntity)).oclAsType(pcm::core::entity::ResourceInterfaceRequiringEntity).resourceRequiredRoles__ResourceInterfaceRequiringEntity->includes(self.resourceRequiredRole__ResourceCall)";

    /**
     * The cached OCL invariant for the '
     * {@link #ResourceRequiredRoleMustBeReferencedByComponent(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Resource Required Role Must Be Referenced By Component</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #ResourceRequiredRoleMustBeReferencedByComponent(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean ResourceRequiredRoleMustBeReferencedByComponent(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.RESOURCE_CALL);
            try {
                RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(
                RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                        SeffPerformanceValidator.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_COMPONENT,
                        EcorePlugin.INSTANCE.getString(
                                "_UI_GenericInvariant_diagnostic",
                                new Object[] { "ResourceRequiredRoleMustBeReferencedByComponent",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Role Combination Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.action__ResourceCall.resourceCall__Action->select(call | call.resourceRequiredRole__ResourceCall=self.resourceRequiredRole__ResourceCall and call.signature__ResourceCall=self.signature__ResourceCall)->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Signature Role Combination Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public boolean SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction(
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.RESOURCE_CALL);
            try {
                SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                                SeffPerformanceValidator.RESOURCE_CALL__SIGNATURE_ROLE_COMBINATION_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION,
                                EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                        "SignatureRoleCombinationMustBeUniqueWithinAbstractInternalControlFlowAction",
                                        EObjectValidator.getObjectLabel(this, context) }), new Object[] { this }));
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
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetAction__ResourceCall((AbstractInternalControlFlowAction) otherEnd, msgs);
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            if (numberOfCalls__ResourceCall != null)
                msgs = ((InternalEObject) numberOfCalls__ResourceCall).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
                        - SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL, null, msgs);
            return basicSetNumberOfCalls__ResourceCall((PCMRandomVariable) otherEnd, msgs);
        }
        return super.eInverseAdd(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            return basicSetAction__ResourceCall(null, msgs);
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            return basicSetNumberOfCalls__ResourceCall(null, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
        switch (eContainerFeatureID()) {
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_CALL_ACTION,
                    AbstractInternalControlFlowAction.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public Object eGet(int featureID, boolean resolve, boolean coreType) {
        switch (featureID) {
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            return getAction__ResourceCall();
        case SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL:
            if (resolve)
                return getResourceRequiredRole__ResourceCall();
            return basicGetResourceRequiredRole__ResourceCall();
        case SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL:
            if (resolve)
                return getSignature__ResourceCall();
            return basicGetSignature__ResourceCall();
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            return getNumberOfCalls__ResourceCall();
        }
        return super.eGet(featureID, resolve, coreType);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public void eSet(int featureID, Object newValue) {
        switch (featureID) {
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            setAction__ResourceCall((AbstractInternalControlFlowAction) newValue);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL:
            setResourceRequiredRole__ResourceCall((ResourceRequiredRole) newValue);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL:
            setSignature__ResourceCall((ResourceSignature) newValue);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            setNumberOfCalls__ResourceCall((PCMRandomVariable) newValue);
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
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            setAction__ResourceCall((AbstractInternalControlFlowAction) null);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL:
            setResourceRequiredRole__ResourceCall((ResourceRequiredRole) null);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL:
            setSignature__ResourceCall((ResourceSignature) null);
            return;
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            setNumberOfCalls__ResourceCall((PCMRandomVariable) null);
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
        case SeffPerformancePackage.RESOURCE_CALL__ACTION_RESOURCE_CALL:
            return getAction__ResourceCall() != null;
        case SeffPerformancePackage.RESOURCE_CALL__RESOURCE_REQUIRED_ROLE_RESOURCE_CALL:
            return resourceRequiredRole__ResourceCall != null;
        case SeffPerformancePackage.RESOURCE_CALL__SIGNATURE_RESOURCE_CALL:
            return signature__ResourceCall != null;
        case SeffPerformancePackage.RESOURCE_CALL__NUMBER_OF_CALLS_RESOURCE_CALL:
            return numberOfCalls__ResourceCall != null;
        }
        return super.eIsSet(featureID);
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ResourceCallImpl

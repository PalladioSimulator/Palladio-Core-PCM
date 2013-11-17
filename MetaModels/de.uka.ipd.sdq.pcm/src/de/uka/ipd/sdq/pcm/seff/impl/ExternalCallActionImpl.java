/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.CallAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>External Call Action</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getInputVariableUsages__CallAction <em>Input Variable Usages Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getReturnVariableUsage__CallReturnAction <em>Return Variable Usage Call Return Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getFailureTypes_FailureHandlingEntity <em>Failure Types Failure Handling Entity</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getCalledService_ExternalService <em>Called Service External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getRole_ExternalService <em>Role External Service</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ExternalCallActionImpl#getRetryCount <em>Retry Count</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExternalCallActionImpl extends AbstractActionImpl implements ExternalCallAction {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getInputVariableUsages__CallAction() <em>Input Variable Usages Call Action</em>}' containment reference list.
     * <!-- begin-user-doc
     * --> <!-- end-user-doc -->
     * @see #getInputVariableUsages__CallAction()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> inputVariableUsages__CallAction;

    /**
     * The cached value of the '{@link #getReturnVariableUsage__CallReturnAction()
     * <em>Return Variable Usage Call Return Action</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getReturnVariableUsage__CallReturnAction()
     * @generated
     * @ordered
     */
    protected EList<VariableUsage> returnVariableUsage__CallReturnAction;

    /**
     * The cached value of the '{@link #getFailureTypes_FailureHandlingEntity() <em>Failure Types Failure Handling Entity</em>}' reference list.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getFailureTypes_FailureHandlingEntity()
     * @generated
     * @ordered
     */
    protected EList<FailureType> failureTypes_FailureHandlingEntity;

    /**
     * The cached value of the '{@link #getCalledService_ExternalService() <em>Called Service External Service</em>}' reference.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #getCalledService_ExternalService()
     * @generated
     * @ordered
     */
    protected OperationSignature calledService_ExternalService;

    /**
     * The cached value of the '{@link #getRole_ExternalService() <em>Role External Service</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #getRole_ExternalService()
     * @generated
     * @ordered
     */
    protected OperationRequiredRole role_ExternalService;

    /**
     * The default value of the '{@link #getRetryCount() <em>Retry Count</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRetryCount()
     * @generated
     * @ordered
     */
    protected static final int RETRY_COUNT_EDEFAULT = 0;

    /**
     * The cached value of the '{@link #getRetryCount() <em>Retry Count</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getRetryCount()
     * @generated
     * @ordered
     */
    protected int retryCount = RETRY_COUNT_EDEFAULT;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    protected ExternalCallActionImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.EXTERNAL_CALL_ACTION;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<VariableUsage> getInputVariableUsages__CallAction() {
        if (inputVariableUsages__CallAction == null) {
            inputVariableUsages__CallAction = new EObjectContainmentWithInverseEList<VariableUsage>(VariableUsage.class, this, SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION, ParameterPackage.VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE);
        }
        return inputVariableUsages__CallAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<VariableUsage> getReturnVariableUsage__CallReturnAction() {
        if (returnVariableUsage__CallReturnAction == null) {
            returnVariableUsage__CallReturnAction = new EObjectContainmentWithInverseEList<VariableUsage>(VariableUsage.class, this, SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION, ParameterPackage.VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE);
        }
        return returnVariableUsage__CallReturnAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public EList<FailureType> getFailureTypes_FailureHandlingEntity() {
        if (failureTypes_FailureHandlingEntity == null) {
            failureTypes_FailureHandlingEntity = new EObjectResolvingEList<FailureType>(FailureType.class, this, SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY);
        }
        return failureTypes_FailureHandlingEntity;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature getCalledService_ExternalService() {
        if (calledService_ExternalService != null && calledService_ExternalService.eIsProxy()) {
            InternalEObject oldCalledService_ExternalService = (InternalEObject)calledService_ExternalService;
            calledService_ExternalService = (OperationSignature)eResolveProxy(oldCalledService_ExternalService);
            if (calledService_ExternalService != oldCalledService_ExternalService) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE, oldCalledService_ExternalService, calledService_ExternalService));
            }
        }
        return calledService_ExternalService;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationSignature basicGetCalledService_ExternalService() {
        return calledService_ExternalService;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setCalledService_ExternalService(OperationSignature newCalledService_ExternalService) {
        OperationSignature oldCalledService_ExternalService = calledService_ExternalService;
        calledService_ExternalService = newCalledService_ExternalService;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE, oldCalledService_ExternalService, calledService_ExternalService));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationRequiredRole getRole_ExternalService() {
        if (role_ExternalService != null && role_ExternalService.eIsProxy()) {
            InternalEObject oldRole_ExternalService = (InternalEObject)role_ExternalService;
            role_ExternalService = (OperationRequiredRole)eResolveProxy(oldRole_ExternalService);
            if (role_ExternalService != oldRole_ExternalService) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(this, Notification.RESOLVE, SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE, oldRole_ExternalService, role_ExternalService));
            }
        }
        return role_ExternalService;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public OperationRequiredRole basicGetRole_ExternalService() {
        return role_ExternalService;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRole_ExternalService(OperationRequiredRole newRole_ExternalService) {
        OperationRequiredRole oldRole_ExternalService = role_ExternalService;
        role_ExternalService = newRole_ExternalService;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE, oldRole_ExternalService, role_ExternalService));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public void setRetryCount(int newRetryCount) {
        int oldRetryCount = retryCount;
        retryCount = newRetryCount;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, SeffPackage.EXTERNAL_CALL_ACTION__RETRY_COUNT, oldRetryCount, retryCount));
    }

    /**
     * The cached OCL expression body for the '{@link #SignatureBelongsToRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Signature Belongs To Role</em>}' operation.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @see #SignatureBelongsToRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.role_ExternalService.requiredInterface__OperationRequiredRole.signatures__OperationInterface->includes(self.calledService_ExternalService)";

    /**
     * The cached OCL invariant for the '{@link #SignatureBelongsToRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Signature Belongs To Role</em>}' invariant operation.
     * <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * @see #SignatureBelongsToRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean SignatureBelongsToRole(DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.EXTERNAL_CALL_ACTION);
            try {
                SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(SIGNATURE_BELONGS_TO_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         SeffValidator.DIAGNOSTIC_SOURCE,
                         SeffValidator.EXTERNAL_CALL_ACTION__SIGNATURE_BELONGS_TO_ROLE,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "SignatureBelongsToRole", EObjectValidator.getObjectLabel(this, context) }),
                         new Object [] { this }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #OperationRequiredRoleMustBeReferencedByContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Operation Required Role Must Be Referenced By Container</em>}' operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #OperationRequiredRoleMustBeReferencedByContainer(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.oclAsType(ecore::EObject)->closure(eContainer())->select( entity | entity.oclIsKindOf(pcm::core::entity::InterfaceRequiringEntity)).oclAsType(pcm::core::entity::InterfaceRequiringEntity).requiredRoles_InterfaceRequiringEntity->includes(self.role_ExternalService)";

    /**
     * The cached OCL invariant for the '
     * {@link #OperationRequiredRoleMustBeReferencedByContainer(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Operation Required Role Must Be Referenced By Container</em>}' invariant operation. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #OperationRequiredRoleMustBeReferencedByContainer(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    public boolean OperationRequiredRoleMustBeReferencedByContainer(DiagnosticChain diagnostics,
            Map<Object, Object> context) {
        if (OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.EXTERNAL_CALL_ACTION);
            try {
                OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper.createInvariant(OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            }
            catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add
                    (new BasicDiagnostic
                        (Diagnostic.ERROR,
                         SeffValidator.DIAGNOSTIC_SOURCE,
                         SeffValidator.EXTERNAL_CALL_ACTION__OPERATION_REQUIRED_ROLE_MUST_BE_REFERENCED_BY_CONTAINER,
                         EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] { "OperationRequiredRoleMustBeReferencedByContainer", EObjectValidator.getObjectLabel(this, context) }),
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
    @SuppressWarnings("unchecked")
    @Override
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getInputVariableUsages__CallAction()).basicAdd(otherEnd, msgs);
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                return ((InternalEList<InternalEObject>)(InternalEList<?>)getReturnVariableUsage__CallReturnAction()).basicAdd(otherEnd, msgs);
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
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return ((InternalEList<?>)getInputVariableUsages__CallAction()).basicRemove(otherEnd, msgs);
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                return ((InternalEList<?>)getReturnVariableUsage__CallReturnAction()).basicRemove(otherEnd, msgs);
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
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return getInputVariableUsages__CallAction();
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                return getReturnVariableUsage__CallReturnAction();
            case SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY:
                return getFailureTypes_FailureHandlingEntity();
            case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
                if (resolve) return getCalledService_ExternalService();
                return basicGetCalledService_ExternalService();
            case SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE:
                if (resolve) return getRole_ExternalService();
                return basicGetRole_ExternalService();
            case SeffPackage.EXTERNAL_CALL_ACTION__RETRY_COUNT:
                return getRetryCount();
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
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                getInputVariableUsages__CallAction().clear();
                getInputVariableUsages__CallAction().addAll((Collection<? extends VariableUsage>)newValue);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                getReturnVariableUsage__CallReturnAction().clear();
                getReturnVariableUsage__CallReturnAction().addAll((Collection<? extends VariableUsage>)newValue);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY:
                getFailureTypes_FailureHandlingEntity().clear();
                getFailureTypes_FailureHandlingEntity().addAll((Collection<? extends FailureType>)newValue);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
                setCalledService_ExternalService((OperationSignature)newValue);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE:
                setRole_ExternalService((OperationRequiredRole)newValue);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__RETRY_COUNT:
                setRetryCount((Integer)newValue);
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
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                getInputVariableUsages__CallAction().clear();
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                getReturnVariableUsage__CallReturnAction().clear();
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY:
                getFailureTypes_FailureHandlingEntity().clear();
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
                setCalledService_ExternalService((OperationSignature)null);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE:
                setRole_ExternalService((OperationRequiredRole)null);
                return;
            case SeffPackage.EXTERNAL_CALL_ACTION__RETRY_COUNT:
                setRetryCount(RETRY_COUNT_EDEFAULT);
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
            case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION:
                return inputVariableUsages__CallAction != null && !inputVariableUsages__CallAction.isEmpty();
            case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION:
                return returnVariableUsage__CallReturnAction != null && !returnVariableUsage__CallReturnAction.isEmpty();
            case SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY:
                return failureTypes_FailureHandlingEntity != null && !failureTypes_FailureHandlingEntity.isEmpty();
            case SeffPackage.EXTERNAL_CALL_ACTION__CALLED_SERVICE_EXTERNAL_SERVICE:
                return calledService_ExternalService != null;
            case SeffPackage.EXTERNAL_CALL_ACTION__ROLE_EXTERNAL_SERVICE:
                return role_ExternalService != null;
            case SeffPackage.EXTERNAL_CALL_ACTION__RETRY_COUNT:
                return retryCount != RETRY_COUNT_EDEFAULT;
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
        if (baseClass == CallAction.class) {
            switch (derivedFeatureID) {
                case SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION: return SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
                default: return -1;
            }
        }
        if (baseClass == CallReturnAction.class) {
            switch (derivedFeatureID) {
                case SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION: return SeffPackage.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION;
                default: return -1;
            }
        }
        if (baseClass == FailureHandlingEntity.class) {
            switch (derivedFeatureID) {
                case SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY: return SeffReliabilityPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES_FAILURE_HANDLING_ENTITY;
                default: return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
        if (baseClass == CallAction.class) {
            switch (baseFeatureID) {
                case SeffPackage.CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION: return SeffPackage.EXTERNAL_CALL_ACTION__INPUT_VARIABLE_USAGES_CALL_ACTION;
                default: return -1;
            }
        }
        if (baseClass == CallReturnAction.class) {
            switch (baseFeatureID) {
                case SeffPackage.CALL_RETURN_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION: return SeffPackage.EXTERNAL_CALL_ACTION__RETURN_VARIABLE_USAGE_CALL_RETURN_ACTION;
                default: return -1;
            }
        }
        if (baseClass == FailureHandlingEntity.class) {
            switch (baseFeatureID) {
                case SeffReliabilityPackage.FAILURE_HANDLING_ENTITY__FAILURE_TYPES_FAILURE_HANDLING_ENTITY: return SeffPackage.EXTERNAL_CALL_ACTION__FAILURE_TYPES_FAILURE_HANDLING_ENTITY;
                default: return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * @generated
     */
    @Override
    public String toString() {
        if (eIsProxy()) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (retryCount: ");
        result.append(retryCount);
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

} // ExternalCallActionImpl

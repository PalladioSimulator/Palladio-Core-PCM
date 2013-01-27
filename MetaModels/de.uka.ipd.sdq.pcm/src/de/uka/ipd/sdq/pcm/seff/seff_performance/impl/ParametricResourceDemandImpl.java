/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.resourcetype.ProcessingResourceType;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.util.SeffPerformanceValidator;
import java.util.Map;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Parametric Resource Demand</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ParametricResourceDemandImpl#getSpecification_ParametericResourceDemand
 * <em>Specification Parameteric Resource Demand</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ParametricResourceDemandImpl#getRequiredResource_ParametricResourceDemand
 * <em>Required Resource Parametric Resource Demand</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.seff_performance.impl.ParametricResourceDemandImpl#getAction_ParametricResourceDemand
 * <em>Action Parametric Resource Demand</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class ParametricResourceDemandImpl extends EObjectImpl implements ParametricResourceDemand {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached value of the '{@link #getSpecification_ParametericResourceDemand()
     * <em>Specification Parameteric Resource Demand</em>}' containment reference. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #getSpecification_ParametericResourceDemand()
     * @generated
     * @ordered
     */
    protected PCMRandomVariable specification_ParametericResourceDemand;

    /**
     * The cached value of the '{@link #getRequiredResource_ParametricResourceDemand()
     * <em>Required Resource Parametric Resource Demand</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @see #getRequiredResource_ParametricResourceDemand()
     * @generated
     * @ordered
     */
    protected ProcessingResourceType requiredResource_ParametricResourceDemand;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected ParametricResourceDemandImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPerformancePackage.Literals.PARAMETRIC_RESOURCE_DEMAND;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public PCMRandomVariable getSpecification_ParametericResourceDemand() {
        return specification_ParametericResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetSpecification_ParametericResourceDemand(
            PCMRandomVariable newSpecification_ParametericResourceDemand, NotificationChain msgs) {
        PCMRandomVariable oldSpecification_ParametericResourceDemand = specification_ParametericResourceDemand;
        specification_ParametericResourceDemand = newSpecification_ParametericResourceDemand;
        if (eNotificationRequired()) {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND,
                    oldSpecification_ParametericResourceDemand, newSpecification_ParametericResourceDemand);
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
    public void setSpecification_ParametericResourceDemand(PCMRandomVariable newSpecification_ParametericResourceDemand) {
        if (newSpecification_ParametericResourceDemand != specification_ParametericResourceDemand) {
            NotificationChain msgs = null;
            if (specification_ParametericResourceDemand != null)
                msgs = ((InternalEObject) specification_ParametericResourceDemand).eInverseRemove(this,
                        CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            if (newSpecification_ParametericResourceDemand != null)
                msgs = ((InternalEObject) newSpecification_ParametericResourceDemand).eInverseAdd(this,
                        CorePackage.PCM_RANDOM_VARIABLE__PARAMETRIC_RESOURCE_DEMAND_PCM_RANDOM_VARIABLE,
                        PCMRandomVariable.class, msgs);
            msgs = basicSetSpecification_ParametericResourceDemand(newSpecification_ParametericResourceDemand, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND,
                    newSpecification_ParametericResourceDemand, newSpecification_ParametericResourceDemand));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceType getRequiredResource_ParametricResourceDemand() {
        if (requiredResource_ParametricResourceDemand != null && requiredResource_ParametricResourceDemand.eIsProxy()) {
            InternalEObject oldRequiredResource_ParametricResourceDemand = (InternalEObject) requiredResource_ParametricResourceDemand;
            requiredResource_ParametricResourceDemand = (ProcessingResourceType) eResolveProxy(oldRequiredResource_ParametricResourceDemand);
            if (requiredResource_ParametricResourceDemand != oldRequiredResource_ParametricResourceDemand) {
                if (eNotificationRequired())
                    eNotify(new ENotificationImpl(
                            this,
                            Notification.RESOLVE,
                            SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND,
                            oldRequiredResource_ParametricResourceDemand, requiredResource_ParametricResourceDemand));
            }
        }
        return requiredResource_ParametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ProcessingResourceType basicGetRequiredResource_ParametricResourceDemand() {
        return requiredResource_ParametricResourceDemand;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setRequiredResource_ParametricResourceDemand(
            ProcessingResourceType newRequiredResource_ParametricResourceDemand) {
        ProcessingResourceType oldRequiredResource_ParametricResourceDemand = requiredResource_ParametricResourceDemand;
        requiredResource_ParametricResourceDemand = newRequiredResource_ParametricResourceDemand;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND,
                    oldRequiredResource_ParametricResourceDemand, requiredResource_ParametricResourceDemand));
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AbstractInternalControlFlowAction getAction_ParametricResourceDemand() {
        if (eContainerFeatureID() != SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND)
            return null;
        return (AbstractInternalControlFlowAction) eContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public NotificationChain basicSetAction_ParametricResourceDemand(
            AbstractInternalControlFlowAction newAction_ParametricResourceDemand, NotificationChain msgs) {
        msgs = eBasicSetContainer((InternalEObject) newAction_ParametricResourceDemand,
                SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void setAction_ParametricResourceDemand(AbstractInternalControlFlowAction newAction_ParametricResourceDemand) {
        if (newAction_ParametricResourceDemand != eInternalContainer()
                || (eContainerFeatureID() != SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND && newAction_ParametricResourceDemand != null)) {
            if (EcoreUtil.isAncestor(this, newAction_ParametricResourceDemand))
                throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
            NotificationChain msgs = null;
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            if (newAction_ParametricResourceDemand != null)
                msgs = ((InternalEObject) newAction_ParametricResourceDemand).eInverseAdd(this,
                        SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION,
                        AbstractInternalControlFlowAction.class, msgs);
            msgs = basicSetAction_ParametricResourceDemand(newAction_ParametricResourceDemand, msgs);
            if (msgs != null)
                msgs.dispatch();
        } else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND,
                    newAction_ParametricResourceDemand, newAction_ParametricResourceDemand));
    }

    /**
     * The cached OCL expression body for the '
     * {@link #DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Demanded Processing Resource Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.action_ParametricResourceDemand.resourceDemand_Action->select(prd | prd.requiredResource_ParametricResourceDemand=self.requiredResource_ParametricResourceDemand)->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Demanded Processing Resource Must Be Unique Within Abstract Internal Control Flow Action</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public boolean DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction(
            DiagnosticChain diagnostics, Map<Object, Object> context) {
        if (DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPerformancePackage.Literals.PARAMETRIC_RESOURCE_DEMAND);
            try {
                DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                .check(this)) {
            if (diagnostics != null) {
                diagnostics
                        .add(new BasicDiagnostic(
                                Diagnostic.ERROR,
                                SeffPerformanceValidator.DIAGNOSTIC_SOURCE,
                                SeffPerformanceValidator.PARAMETRIC_RESOURCE_DEMAND__DEMANDED_PROCESSING_RESOURCE_MUST_BE_UNIQUE_WITHIN_ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION,
                                EcorePlugin.INSTANCE
                                        .getString(
                                                "_UI_GenericInvariant_diagnostic",
                                                new Object[] {
                                                        "DemandedProcessingResourceMustBeUniqueWithinAbstractInternalControlFlowAction",
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
    public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            if (specification_ParametericResourceDemand != null)
                msgs = ((InternalEObject) specification_ParametericResourceDemand)
                        .eInverseRemove(
                                this,
                                EOPPOSITE_FEATURE_BASE
                                        - SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND,
                                null, msgs);
            return basicSetSpecification_ParametericResourceDemand((PCMRandomVariable) otherEnd, msgs);
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            if (eInternalContainer() != null)
                msgs = eBasicRemoveFromContainer(msgs);
            return basicSetAction_ParametricResourceDemand((AbstractInternalControlFlowAction) otherEnd, msgs);
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            return basicSetSpecification_ParametericResourceDemand(null, msgs);
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            return basicSetAction_ParametricResourceDemand(null, msgs);
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            return eInternalContainer().eInverseRemove(this,
                    SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION__RESOURCE_DEMAND_ACTION,
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            return getSpecification_ParametericResourceDemand();
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            if (resolve)
                return getRequiredResource_ParametricResourceDemand();
            return basicGetRequiredResource_ParametricResourceDemand();
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            return getAction_ParametricResourceDemand();
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            setSpecification_ParametericResourceDemand((PCMRandomVariable) newValue);
            return;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            setRequiredResource_ParametricResourceDemand((ProcessingResourceType) newValue);
            return;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            setAction_ParametricResourceDemand((AbstractInternalControlFlowAction) newValue);
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            setSpecification_ParametericResourceDemand((PCMRandomVariable) null);
            return;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            setRequiredResource_ParametricResourceDemand((ProcessingResourceType) null);
            return;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            setAction_ParametricResourceDemand((AbstractInternalControlFlowAction) null);
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
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__SPECIFICATION_PARAMETERIC_RESOURCE_DEMAND:
            return specification_ParametericResourceDemand != null;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__REQUIRED_RESOURCE_PARAMETRIC_RESOURCE_DEMAND:
            return requiredResource_ParametricResourceDemand != null;
        case SeffPerformancePackage.PARAMETRIC_RESOURCE_DEMAND__ACTION_PARAMETRIC_RESOURCE_DEMAND:
            return getAction_ParametricResourceDemand() != null;
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

} // ParametricResourceDemandImpl

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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.OCL;

import de.uka.ipd.sdq.identifier.impl.IdentifierImpl;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.util.SeffValidator;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Resource Demanding SEFF</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getSeffTypeID <em>Seff Type ID
 * </em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getDescribedService__SEFF <em>
 * Described Service SEFF</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getBasicComponent_ServiceEffectSpecification
 * <em>Basic Component Service Effect Specification</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getAbstractLoopAction_ResourceDemandingBehaviour
 * <em>Abstract Loop Action Resource Demanding Behaviour</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getAbstractBranchTransition_ResourceDemandingBehaviour
 * <em>Abstract Branch Transition Resource Demanding Behaviour</em>}</li>
 * <li>{@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getSteps_Behaviour <em>Steps
 * Behaviour</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.pcm.seff.impl.ResourceDemandingSEFFImpl#getResourceDemandingInternalBehaviours
 * <em>Resource Demanding Internal Behaviours</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ResourceDemandingSEFFImpl extends IdentifierImpl implements ResourceDemandingSEFF {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The default value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSeffTypeID()
     * @generated
     * @ordered
     */
    protected static final String SEFF_TYPE_ID_EDEFAULT = "1";

    /**
     * The cached value of the '{@link #getSeffTypeID() <em>Seff Type ID</em>}' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSeffTypeID()
     * @generated
     * @ordered
     */
    protected String seffTypeID = SEFF_TYPE_ID_EDEFAULT;

    /**
     * The cached value of the '{@link #getDescribedService__SEFF() <em>Described Service SEFF</em>}
     * ' reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getDescribedService__SEFF()
     * @generated
     * @ordered
     */
    protected Signature describedService__SEFF;

    /**
     * The cached value of the '{@link #getSteps_Behaviour() <em>Steps Behaviour</em>}' containment
     * reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getSteps_Behaviour()
     * @generated
     * @ordered
     */
    protected EList<AbstractAction> steps_Behaviour;

    /**
     * The cached value of the ' {@link #getResourceDemandingInternalBehaviours()
     * <em>Resource Demanding Internal Behaviours</em>}' containment reference list. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #getResourceDemandingInternalBehaviours()
     * @generated
     * @ordered
     */
    protected EList<ResourceDemandingInternalBehaviour> resourceDemandingInternalBehaviours;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    protected ResourceDemandingSEFFImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    protected EClass eStaticClass() {
        return SeffPackage.Literals.RESOURCE_DEMANDING_SEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String getSeffTypeID() {
        return this.seffTypeID;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setSeffTypeID(final String newSeffTypeID) {
        final String oldSeffTypeID = this.seffTypeID;
        this.seffTypeID = newSeffTypeID;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID, oldSeffTypeID, this.seffTypeID));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Signature getDescribedService__SEFF() {
        if (this.describedService__SEFF != null && ((EObject) this.describedService__SEFF).eIsProxy()) {
            final InternalEObject oldDescribedService__SEFF = (InternalEObject) this.describedService__SEFF;
            this.describedService__SEFF = (Signature) this.eResolveProxy(oldDescribedService__SEFF);
            if (this.describedService__SEFF != oldDescribedService__SEFF) {
                if (this.eNotificationRequired()) {
                    this.eNotify(new ENotificationImpl(this, Notification.RESOLVE,
                            SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF, oldDescribedService__SEFF,
                            this.describedService__SEFF));
                }
            }
        }
        return this.describedService__SEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public Signature basicGetDescribedService__SEFF() {
        return this.describedService__SEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setDescribedService__SEFF(final Signature newDescribedService__SEFF) {
        final Signature oldDescribedService__SEFF = this.describedService__SEFF;
        this.describedService__SEFF = newDescribedService__SEFF;
        if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF, oldDescribedService__SEFF,
                    this.describedService__SEFF));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public BasicComponent getBasicComponent_ServiceEffectSpecification() {
        if (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION) {
            return null;
        }
        return (BasicComponent) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetBasicComponent_ServiceEffectSpecification(
            final BasicComponent newBasicComponent_ServiceEffectSpecification, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newBasicComponent_ServiceEffectSpecification,
                SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setBasicComponent_ServiceEffectSpecification(
            final BasicComponent newBasicComponent_ServiceEffectSpecification) {
        if (newBasicComponent_ServiceEffectSpecification != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION && newBasicComponent_ServiceEffectSpecification != null)) {
            if (EcoreUtil.isAncestor(this, newBasicComponent_ServiceEffectSpecification)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newBasicComponent_ServiceEffectSpecification != null) {
                msgs = ((InternalEObject) newBasicComponent_ServiceEffectSpecification).eInverseAdd(this,
                        RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT,
                        BasicComponent.class, msgs);
            }
            msgs = this.basicSetBasicComponent_ServiceEffectSpecification(newBasicComponent_ServiceEffectSpecification,
                    msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION,
                    newBasicComponent_ServiceEffectSpecification, newBasicComponent_ServiceEffectSpecification));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractLoopAction getAbstractLoopAction_ResourceDemandingBehaviour() {
        if (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR) {
            return null;
        }
        return (AbstractLoopAction) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetAbstractLoopAction_ResourceDemandingBehaviour(
            final AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour, NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newAbstractLoopAction_ResourceDemandingBehaviour,
                SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAbstractLoopAction_ResourceDemandingBehaviour(
            final AbstractLoopAction newAbstractLoopAction_ResourceDemandingBehaviour) {
        if (newAbstractLoopAction_ResourceDemandingBehaviour != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractLoopAction_ResourceDemandingBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, newAbstractLoopAction_ResourceDemandingBehaviour)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newAbstractLoopAction_ResourceDemandingBehaviour != null) {
                msgs = ((InternalEObject) newAbstractLoopAction_ResourceDemandingBehaviour).eInverseAdd(this,
                        SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, AbstractLoopAction.class, msgs);
            }
            msgs = this.basicSetAbstractLoopAction_ResourceDemandingBehaviour(
                    newAbstractLoopAction_ResourceDemandingBehaviour, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR,
                    newAbstractLoopAction_ResourceDemandingBehaviour, newAbstractLoopAction_ResourceDemandingBehaviour));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public AbstractBranchTransition getAbstractBranchTransition_ResourceDemandingBehaviour() {
        if (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR) {
            return null;
        }
        return (AbstractBranchTransition) this.eInternalContainer();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    public NotificationChain basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
            final AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour,
            NotificationChain msgs) {
        msgs = this.eBasicSetContainer((InternalEObject) newAbstractBranchTransition_ResourceDemandingBehaviour,
                SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR, msgs);
        return msgs;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public void setAbstractBranchTransition_ResourceDemandingBehaviour(
            final AbstractBranchTransition newAbstractBranchTransition_ResourceDemandingBehaviour) {
        if (newAbstractBranchTransition_ResourceDemandingBehaviour != this.eInternalContainer()
                || (this.eContainerFeatureID() != SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR && newAbstractBranchTransition_ResourceDemandingBehaviour != null)) {
            if (EcoreUtil.isAncestor(this, newAbstractBranchTransition_ResourceDemandingBehaviour)) {
                throw new IllegalArgumentException("Recursive containment not allowed for " + this.toString());
            }
            NotificationChain msgs = null;
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            if (newAbstractBranchTransition_ResourceDemandingBehaviour != null) {
                msgs = ((InternalEObject) newAbstractBranchTransition_ResourceDemandingBehaviour).eInverseAdd(this,
                        SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
                        AbstractBranchTransition.class, msgs);
            }
            msgs = this.basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
                    newAbstractBranchTransition_ResourceDemandingBehaviour, msgs);
            if (msgs != null) {
                msgs.dispatch();
            }
        } else if (this.eNotificationRequired()) {
            this.eNotify(new ENotificationImpl(this, Notification.SET,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR,
                    newAbstractBranchTransition_ResourceDemandingBehaviour,
                    newAbstractBranchTransition_ResourceDemandingBehaviour));
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<AbstractAction> getSteps_Behaviour() {
        if (this.steps_Behaviour == null) {
            this.steps_Behaviour = new EObjectContainmentWithInverseEList<AbstractAction>(AbstractAction.class, this,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR,
                    SeffPackage.ABSTRACT_ACTION__RESOURCE_DEMANDING_BEHAVIOUR_ABSTRACT_ACTION);
        }
        return this.steps_Behaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EList<ResourceDemandingInternalBehaviour> getResourceDemandingInternalBehaviours() {
        if (this.resourceDemandingInternalBehaviours == null) {
            this.resourceDemandingInternalBehaviours = new EObjectContainmentWithInverseEList<ResourceDemandingInternalBehaviour>(
                    ResourceDemandingInternalBehaviour.class,
                    this,
                    SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS,
                    SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR__RESOURCE_DEMANDING_SEFF_RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR);
        }
        return this.resourceDemandingInternalBehaviours;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Signature Must Belong To Interface Referenced By Provided Role</em>}'
     * operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "if self.describedService__SEFF.oclIsKindOf(pcm::repository::OperationSignature) then\n"
            + "	self.basicComponent_ServiceEffectSpecification.providedRoles_InterfaceProvidingEntity->exists(p | p.oclIsKindOf(pcm::repository::OperationProvidedRole) and (p.oclAsType(pcm::repository::OperationProvidedRole).providedInterface__OperationProvidedRole = self.describedService__SEFF.oclAsType(pcm::repository::OperationSignature).interface__OperationSignature))\n"
            + "else\n"
            + "	if self.describedService__SEFF.oclIsKindOf(pcm::repository::EventType) then\n"
            + "		self.basicComponent_ServiceEffectSpecification.providedRoles_InterfaceProvidingEntity->exists(p | p.oclIsKindOf(pcm::repository::SinkRole) and (p.oclAsType(pcm::repository::SinkRole).eventGroup__SinkRole = self.describedService__SEFF.oclAsType(pcm::repository::EventType).eventGroup__EventType))\n"
            + "	else\n" + "		true\n" + "	endif\n" + "endif";

    /**
     * The cached OCL invariant for the '
     * {@link #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Referenced Signature Must Belong To Interface Referenced By Provided Role</em>}'
     * invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole(final DiagnosticChain diagnostics,
            final Map<Object, Object> context) {
        if (REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.SERVICE_EFFECT_SPECIFICATION);
            try {
                REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.SERVICE_EFFECT_SPECIFICATION__REFERENCED_SIGNATURE_MUST_BELONG_TO_INTERFACE_REFERENCED_BY_PROVIDED_ROLE,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "ReferencedSignatureMustBelongToInterfaceReferencedByProvidedRole",
                                EObjectValidator.getObjectLabel(this, context)
                        }), new Object[] {
                            this
                        }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactly One Stop Action</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StopAction))->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactly One Stop Action</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #ExactlyOneStopAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ExactlyOneStopAction(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
            try {
                EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EXACTLY_ONE_STOP_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_STOP_ACTION, EcorePlugin.INSTANCE
                        .getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "ExactlyOneStopAction", EObjectValidator.getObjectLabel(this, context)
                        }), new Object[] {
                    this
                }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactly One Start Action</em>}' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "self.steps_Behaviour->select(s|s.oclIsTypeOf(StartAction))->size() = 1";

    /**
     * The cached OCL invariant for the '
     * {@link #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Exactly One Start Action</em>}' invariant operation. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @see #ExactlyOneStartAction(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean ExactlyOneStartAction(final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
            try {
                EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV.createQuery(EXACTLY_ONE_START_ACTION__DIAGNOSTIC_CHAIN_MAP__EOCL_INV).check(this)) {
            if (diagnostics != null) {
                diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR, SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EXACTLY_ONE_START_ACTION, EcorePlugin.INSTANCE
                        .getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "ExactlyOneStartAction", EObjectValidator.getObjectLabel(this, context)
                        }), new Object[] {
                    this
                }));
            }
            return false;
        }
        return true;
    }

    /**
     * The cached OCL expression body for the '
     * {@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}
     * ' operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static final String EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP = "not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).predecessor_AbstractAction.oclIsUndefined()) and not self.steps_Behaviour->select(s|not s.oclIsTypeOf(StartAction) and not s.oclIsTypeOf(StopAction))->exists(a|a.oclAsType(AbstractAction).successor_AbstractAction.oclIsUndefined())";

    /**
     * The cached OCL invariant for the '
     * {@link #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
     * <em>Each Action Except Start Actionand Stop Action Must Hhave APredecessor And Successor</em>}
     * ' invariant operation. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(org.eclipse.emf.common.util.DiagnosticChain,
     *      java.util.Map)
     * @generated
     * @ordered
     */
    protected static Constraint EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public boolean EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor(
            final DiagnosticChain diagnostics, final Map<Object, Object> context) {
        if (EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV == null) {
            final OCL.Helper helper = EOCL_ENV.createOCLHelper();
            helper.setContext(SeffPackage.Literals.RESOURCE_DEMANDING_BEHAVIOUR);
            try {
                EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV = helper
                        .createInvariant(EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_EXP);
            } catch (final ParserException pe) {
                throw new UnsupportedOperationException(pe.getLocalizedMessage());
            }
        }
        if (!EOCL_ENV
                .createQuery(
                        EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR__DIAGNOSTIC_CHAIN_MAP__EOCL_INV)
                        .check(this)) {
            if (diagnostics != null) {
                diagnostics
                .add(new BasicDiagnostic(
                        Diagnostic.ERROR,
                        SeffValidator.DIAGNOSTIC_SOURCE,
                        SeffValidator.RESOURCE_DEMANDING_BEHAVIOUR__EACH_ACTION_EXCEPT_START_ACTIONAND_STOP_ACTION_MUST_HHAVE_APREDECESSOR_AND_SUCCESSOR,
                        EcorePlugin.INSTANCE.getString("_UI_GenericInvariant_diagnostic", new Object[] {
                                "EachActionExceptStartActionandStopActionMustHhaveAPredecessorAndSuccessor",
                                EObjectValidator.getObjectLabel(this, context)
                        }), new Object[] {
                            this
                        }));
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
    public NotificationChain eInverseAdd(final InternalEObject otherEnd, final int featureID, NotificationChain msgs) {
        switch (featureID) {
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetBasicComponent_ServiceEffectSpecification((BasicComponent) otherEnd, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction) otherEnd, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            if (this.eInternalContainer() != null) {
                msgs = this.eBasicRemoveFromContainer(msgs);
            }
            return this.basicSetAbstractBranchTransition_ResourceDemandingBehaviour(
                    (AbstractBranchTransition) otherEnd, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getSteps_Behaviour()).basicAdd(otherEnd,
                    msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            return ((InternalEList<InternalEObject>) (InternalEList<?>) this.getResourceDemandingInternalBehaviours())
                    .basicAdd(otherEnd, msgs);
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
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.basicSetBasicComponent_ServiceEffectSpecification(null, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.basicSetAbstractLoopAction_ResourceDemandingBehaviour(null, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.basicSetAbstractBranchTransition_ResourceDemandingBehaviour(null, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            return ((InternalEList<?>) this.getSteps_Behaviour()).basicRemove(otherEnd, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            return ((InternalEList<?>) this.getResourceDemandingInternalBehaviours()).basicRemove(otherEnd, msgs);
        }
        return super.eInverseRemove(otherEnd, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public NotificationChain eBasicRemoveFromContainerFeature(final NotificationChain msgs) {
        switch (this.eContainerFeatureID()) {
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.eInternalContainer().eInverseRemove(this,
                    RepositoryPackage.BASIC_COMPONENT__SERVICE_EFFECT_SPECIFICATIONS_BASIC_COMPONENT,
                    BasicComponent.class, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this,
                    SeffPackage.ABSTRACT_LOOP_ACTION__BODY_BEHAVIOUR_LOOP, AbstractLoopAction.class, msgs);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.eInternalContainer().eInverseRemove(this,
                    SeffPackage.ABSTRACT_BRANCH_TRANSITION__BRANCH_BEHAVIOUR_BRANCH_TRANSITION,
                    AbstractBranchTransition.class, msgs);
        }
        return super.eBasicRemoveFromContainerFeature(msgs);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public Object eGet(final int featureID, final boolean resolve, final boolean coreType) {
        switch (featureID) {
        case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
            return this.getSeffTypeID();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
            if (resolve) {
                return this.getDescribedService__SEFF();
            }
            return this.basicGetDescribedService__SEFF();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.getBasicComponent_ServiceEffectSpecification();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getAbstractLoopAction_ResourceDemandingBehaviour();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getAbstractBranchTransition_ResourceDemandingBehaviour();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            return this.getSteps_Behaviour();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            return this.getResourceDemandingInternalBehaviours();
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
        case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
            this.setSeffTypeID((String) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
            this.setDescribedService__SEFF((Signature) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            this.setBasicComponent_ServiceEffectSpecification((BasicComponent) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            this.getSteps_Behaviour().clear();
            this.getSteps_Behaviour().addAll((Collection<? extends AbstractAction>) newValue);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            this.getResourceDemandingInternalBehaviours().clear();
            this.getResourceDemandingInternalBehaviours().addAll(
                    (Collection<? extends ResourceDemandingInternalBehaviour>) newValue);
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
        case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
            this.setSeffTypeID(SEFF_TYPE_ID_EDEFAULT);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
            this.setDescribedService__SEFF((Signature) null);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            this.setBasicComponent_ServiceEffectSpecification((BasicComponent) null);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setAbstractLoopAction_ResourceDemandingBehaviour((AbstractLoopAction) null);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            this.setAbstractBranchTransition_ResourceDemandingBehaviour((AbstractBranchTransition) null);
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            this.getSteps_Behaviour().clear();
            return;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            this.getResourceDemandingInternalBehaviours().clear();
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
        case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
            return SEFF_TYPE_ID_EDEFAULT == null ? this.seffTypeID != null : !SEFF_TYPE_ID_EDEFAULT
                    .equals(this.seffTypeID);
        case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
            return this.describedService__SEFF != null;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
            return this.getBasicComponent_ServiceEffectSpecification() != null;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getAbstractLoopAction_ResourceDemandingBehaviour() != null;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
            return this.getAbstractBranchTransition_ResourceDemandingBehaviour() != null;
        case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
            return this.steps_Behaviour != null && !this.steps_Behaviour.isEmpty();
        case SeffPackage.RESOURCE_DEMANDING_SEFF__RESOURCE_DEMANDING_INTERNAL_BEHAVIOURS:
            return this.resourceDemandingInternalBehaviours != null
                    && !this.resourceDemandingInternalBehaviours.isEmpty();
        }
        return super.eIsSet(featureID);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eBaseStructuralFeatureID(final int derivedFeatureID, final Class<?> baseClass) {
        if (baseClass == ServiceEffectSpecification.class) {
            switch (derivedFeatureID) {
            case SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID:
                return SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID;
            case SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF:
                return SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF;
            case SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
                return SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceDemandingBehaviour.class) {
            switch (derivedFeatureID) {
            case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
            case SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
            case SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR;
            default:
                return -1;
            }
        }
        return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public int eDerivedStructuralFeatureID(final int baseFeatureID, final Class<?> baseClass) {
        if (baseClass == ServiceEffectSpecification.class) {
            switch (baseFeatureID) {
            case SeffPackage.SERVICE_EFFECT_SPECIFICATION__SEFF_TYPE_ID:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__SEFF_TYPE_ID;
            case SeffPackage.SERVICE_EFFECT_SPECIFICATION__DESCRIBED_SERVICE_SEFF:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__DESCRIBED_SERVICE_SEFF;
            case SeffPackage.SERVICE_EFFECT_SPECIFICATION__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__BASIC_COMPONENT_SERVICE_EFFECT_SPECIFICATION;
            default:
                return -1;
            }
        }
        if (baseClass == ResourceDemandingBehaviour.class) {
            switch (baseFeatureID) {
            case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_LOOP_ACTION_RESOURCE_DEMANDING_BEHAVIOUR;
            case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__ABSTRACT_BRANCH_TRANSITION_RESOURCE_DEMANDING_BEHAVIOUR;
            case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR__STEPS_BEHAVIOUR:
                return SeffPackage.RESOURCE_DEMANDING_SEFF__STEPS_BEHAVIOUR;
            default:
                return -1;
            }
        }
        return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public String toString() {
        if (this.eIsProxy()) {
            return super.toString();
        }

        final StringBuffer result = new StringBuffer(super.toString());
        result.append(" (seffTypeID: ");
        result.append(this.seffTypeID);
        result.append(')');
        return result.toString();
    }

    /**
     * The cached environment for evaluating OCL expressions. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     *
     * @generated
     * @ordered
     */
    protected static final OCL EOCL_ENV = OCL.newInstance();

} // ResourceDemandingSEFFImpl

/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CallReturnAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.InternalCallAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.SeffFactory;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SeffFactoryImpl extends EFactoryImpl implements SeffFactory {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * Creates the default factory implementation. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static SeffFactory init() {
        try {
            final SeffFactory theSeffFactory = (SeffFactory) EPackage.Registry.INSTANCE
                    .getEFactory(SeffPackage.eNS_URI);
            if (theSeffFactory != null) {
                return theSeffFactory;
            }
        } catch (final Exception exception) {
            EcorePlugin.INSTANCE.log(exception);
        }
        return new SeffFactoryImpl();
    }

    /**
     * Creates an instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SeffFactoryImpl() {
        super();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EObject create(final EClass eClass) {
        switch (eClass.getClassifierID()) {
        case SeffPackage.STOP_ACTION:
            return this.createStopAction();
        case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR:
            return this.createResourceDemandingBehaviour();
        case SeffPackage.BRANCH_ACTION:
            return this.createBranchAction();
        case SeffPackage.START_ACTION:
            return this.createStartAction();
        case SeffPackage.RESOURCE_DEMANDING_SEFF:
            return this.createResourceDemandingSEFF();
        case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR:
            return this.createResourceDemandingInternalBehaviour();
        case SeffPackage.RELEASE_ACTION:
            return this.createReleaseAction();
        case SeffPackage.LOOP_ACTION:
            return this.createLoopAction();
        case SeffPackage.FORK_ACTION:
            return this.createForkAction();
        case SeffPackage.FORKED_BEHAVIOUR:
            return this.createForkedBehaviour();
        case SeffPackage.SYNCHRONISATION_POINT:
            return this.createSynchronisationPoint();
        case SeffPackage.EXTERNAL_CALL_ACTION:
            return this.createExternalCallAction();
        case SeffPackage.CALL_RETURN_ACTION:
            return this.createCallReturnAction();
        case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION:
            return this.createProbabilisticBranchTransition();
        case SeffPackage.ACQUIRE_ACTION:
            return this.createAcquireAction();
        case SeffPackage.COLLECTION_ITERATOR_ACTION:
            return this.createCollectionIteratorAction();
        case SeffPackage.GUARDED_BRANCH_TRANSITION:
            return this.createGuardedBranchTransition();
        case SeffPackage.SET_VARIABLE_ACTION:
            return this.createSetVariableAction();
        case SeffPackage.INTERNAL_CALL_ACTION:
            return this.createInternalCallAction();
        case SeffPackage.EMIT_EVENT_ACTION:
            return this.createEmitEventAction();
        case SeffPackage.INTERNAL_ACTION:
            return this.createInternalAction();
        default:
            throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
        }
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StopAction createStopAction() {
        final StopActionImpl stopAction = new StopActionImpl();
        return stopAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingBehaviour createResourceDemandingBehaviour() {
        final ResourceDemandingBehaviourImpl resourceDemandingBehaviour = new ResourceDemandingBehaviourImpl();
        return resourceDemandingBehaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public BranchAction createBranchAction() {
        final BranchActionImpl branchAction = new BranchActionImpl();
        return branchAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public StartAction createStartAction() {
        final StartActionImpl startAction = new StartActionImpl();
        return startAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingSEFF createResourceDemandingSEFF() {
        final ResourceDemandingSEFFImpl resourceDemandingSEFF = new ResourceDemandingSEFFImpl();
        return resourceDemandingSEFF;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceDemandingInternalBehaviour createResourceDemandingInternalBehaviour() {
        final ResourceDemandingInternalBehaviourImpl resourceDemandingInternalBehaviour = new ResourceDemandingInternalBehaviourImpl();
        return resourceDemandingInternalBehaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ReleaseAction createReleaseAction() {
        final ReleaseActionImpl releaseAction = new ReleaseActionImpl();
        return releaseAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public LoopAction createLoopAction() {
        final LoopActionImpl loopAction = new LoopActionImpl();
        return loopAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InternalAction createInternalAction() {
        final InternalActionImpl internalAction = new InternalActionImpl();
        return internalAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ForkAction createForkAction() {
        final ForkActionImpl forkAction = new ForkActionImpl();
        return forkAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ForkedBehaviour createForkedBehaviour() {
        final ForkedBehaviourImpl forkedBehaviour = new ForkedBehaviourImpl();
        return forkedBehaviour;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SynchronisationPoint createSynchronisationPoint() {
        final SynchronisationPointImpl synchronisationPoint = new SynchronisationPointImpl();
        return synchronisationPoint;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ExternalCallAction createExternalCallAction() {
        final ExternalCallActionImpl externalCallAction = new ExternalCallActionImpl();
        return externalCallAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CallReturnAction createCallReturnAction() {
        final CallReturnActionImpl callReturnAction = new CallReturnActionImpl();
        return callReturnAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ProbabilisticBranchTransition createProbabilisticBranchTransition() {
        final ProbabilisticBranchTransitionImpl probabilisticBranchTransition = new ProbabilisticBranchTransitionImpl();
        return probabilisticBranchTransition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public AcquireAction createAcquireAction() {
        final AcquireActionImpl acquireAction = new AcquireActionImpl();
        return acquireAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CollectionIteratorAction createCollectionIteratorAction() {
        final CollectionIteratorActionImpl collectionIteratorAction = new CollectionIteratorActionImpl();
        return collectionIteratorAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public GuardedBranchTransition createGuardedBranchTransition() {
        final GuardedBranchTransitionImpl guardedBranchTransition = new GuardedBranchTransitionImpl();
        return guardedBranchTransition;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SetVariableAction createSetVariableAction() {
        final SetVariableActionImpl setVariableAction = new SetVariableActionImpl();
        return setVariableAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public InternalCallAction createInternalCallAction() {
        final InternalCallActionImpl internalCallAction = new InternalCallActionImpl();
        return internalCallAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EmitEventAction createEmitEventAction() {
        final EmitEventActionImpl emitEventAction = new EmitEventActionImpl();
        return emitEventAction;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public SeffPackage getSeffPackage() {
        return (SeffPackage) this.getEPackage();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @deprecated
     * @generated
     */
    @Deprecated
    public static SeffPackage getPackage() {
        return SeffPackage.eINSTANCE;
    }

} // SeffFactoryImpl

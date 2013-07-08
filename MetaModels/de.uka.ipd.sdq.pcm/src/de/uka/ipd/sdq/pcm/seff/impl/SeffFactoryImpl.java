/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.impl;

import de.uka.ipd.sdq.pcm.seff.*;
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
 * @generated
 */
public class SeffFactoryImpl extends EFactoryImpl implements SeffFactory {
    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public static SeffFactory init() {
		try {
			SeffFactory theSeffFactory = (SeffFactory)EPackage.Registry.INSTANCE.getEFactory(SeffPackage.eNS_URI);
			if (theSeffFactory != null) {
				return theSeffFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SeffFactoryImpl();
	}

    /**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public SeffFactoryImpl() {
		super();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    @Override
    public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SeffPackage.STOP_ACTION: return createStopAction();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR: return createResourceDemandingBehaviour();
			case SeffPackage.BRANCH_ACTION: return createBranchAction();
			case SeffPackage.START_ACTION: return createStartAction();
			case SeffPackage.RESOURCE_DEMANDING_SEFF: return createResourceDemandingSEFF();
			case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR: return createResourceDemandingInternalBehaviour();
			case SeffPackage.RELEASE_ACTION: return createReleaseAction();
			case SeffPackage.LOOP_ACTION: return createLoopAction();
			case SeffPackage.FORK_ACTION: return createForkAction();
			case SeffPackage.FORKED_BEHAVIOUR: return createForkedBehaviour();
			case SeffPackage.SYNCHRONISATION_POINT: return createSynchronisationPoint();
			case SeffPackage.EXTERNAL_CALL_ACTION: return createExternalCallAction();
			case SeffPackage.CALL_RETURN_ACTION: return createCallReturnAction();
			case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION: return createProbabilisticBranchTransition();
			case SeffPackage.ACQUIRE_ACTION: return createAcquireAction();
			case SeffPackage.COLLECTION_ITERATOR_ACTION: return createCollectionIteratorAction();
			case SeffPackage.GUARDED_BRANCH_TRANSITION: return createGuardedBranchTransition();
			case SeffPackage.SET_VARIABLE_ACTION: return createSetVariableAction();
			case SeffPackage.INTERNAL_CALL_ACTION: return createInternalCallAction();
			case SeffPackage.EMIT_EVENT_ACTION: return createEmitEventAction();
			case SeffPackage.INTERNAL_ACTION: return createInternalAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public StopAction createStopAction() {
		StopActionImpl stopAction = new StopActionImpl();
		return stopAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDemandingBehaviour createResourceDemandingBehaviour() {
		ResourceDemandingBehaviourImpl resourceDemandingBehaviour = new ResourceDemandingBehaviourImpl();
		return resourceDemandingBehaviour;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public BranchAction createBranchAction() {
		BranchActionImpl branchAction = new BranchActionImpl();
		return branchAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public StartAction createStartAction() {
		StartActionImpl startAction = new StartActionImpl();
		return startAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDemandingSEFF createResourceDemandingSEFF() {
		ResourceDemandingSEFFImpl resourceDemandingSEFF = new ResourceDemandingSEFFImpl();
		return resourceDemandingSEFF;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ResourceDemandingInternalBehaviour createResourceDemandingInternalBehaviour() {
		ResourceDemandingInternalBehaviourImpl resourceDemandingInternalBehaviour = new ResourceDemandingInternalBehaviourImpl();
		return resourceDemandingInternalBehaviour;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ReleaseAction createReleaseAction() {
		ReleaseActionImpl releaseAction = new ReleaseActionImpl();
		return releaseAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public LoopAction createLoopAction() {
		LoopActionImpl loopAction = new LoopActionImpl();
		return loopAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public InternalAction createInternalAction() {
		InternalActionImpl internalAction = new InternalActionImpl();
		return internalAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ForkAction createForkAction() {
		ForkActionImpl forkAction = new ForkActionImpl();
		return forkAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ForkedBehaviour createForkedBehaviour() {
		ForkedBehaviourImpl forkedBehaviour = new ForkedBehaviourImpl();
		return forkedBehaviour;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public SynchronisationPoint createSynchronisationPoint() {
		SynchronisationPointImpl synchronisationPoint = new SynchronisationPointImpl();
		return synchronisationPoint;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ExternalCallAction createExternalCallAction() {
		ExternalCallActionImpl externalCallAction = new ExternalCallActionImpl();
		return externalCallAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CallReturnAction createCallReturnAction() {
		CallReturnActionImpl callReturnAction = new CallReturnActionImpl();
		return callReturnAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public ProbabilisticBranchTransition createProbabilisticBranchTransition() {
		ProbabilisticBranchTransitionImpl probabilisticBranchTransition = new ProbabilisticBranchTransitionImpl();
		return probabilisticBranchTransition;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public AcquireAction createAcquireAction() {
		AcquireActionImpl acquireAction = new AcquireActionImpl();
		return acquireAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public CollectionIteratorAction createCollectionIteratorAction() {
		CollectionIteratorActionImpl collectionIteratorAction = new CollectionIteratorActionImpl();
		return collectionIteratorAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public GuardedBranchTransition createGuardedBranchTransition() {
		GuardedBranchTransitionImpl guardedBranchTransition = new GuardedBranchTransitionImpl();
		return guardedBranchTransition;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public SetVariableAction createSetVariableAction() {
		SetVariableActionImpl setVariableAction = new SetVariableActionImpl();
		return setVariableAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public InternalCallAction createInternalCallAction() {
		InternalCallActionImpl internalCallAction = new InternalCallActionImpl();
		return internalCallAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public EmitEventAction createEmitEventAction() {
		EmitEventActionImpl emitEventAction = new EmitEventActionImpl();
		return emitEventAction;
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
    public SeffPackage getSeffPackage() {
		return (SeffPackage)getEPackage();
	}

    /**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
    @Deprecated
    public static SeffPackage getPackage() {
		return SeffPackage.eINSTANCE;
	}

} // SeffFactoryImpl

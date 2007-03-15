/**
 * <copyright>
 * </copyright>
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

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SeffFactoryImpl extends EFactoryImpl implements SeffFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SeffFactory init() {
		try {
			SeffFactory theSeffFactory = (SeffFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/PalladioComponentModel/SEFF/1.0"); 
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SeffPackage.STOP_ACTION: return createStopAction();
			case SeffPackage.PARAMETRIC_RESOURCE_DEMAND: return createParametricResourceDemand();
			case SeffPackage.START_ACTION: return createStartAction();
			case SeffPackage.RESOURCE_DEMANDING_SEFF: return createResourceDemandingSEFF();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR: return createResourceDemandingBehaviour();
			case SeffPackage.RELEASE_ACTION: return createReleaseAction();
			case SeffPackage.LOOP_ACTION: return createLoopAction();
			case SeffPackage.ITERATION_COUNT: return createIterationCount();
			case SeffPackage.INTERNAL_ACTION: return createInternalAction();
			case SeffPackage.FORK_ACTION: return createForkAction();
			case SeffPackage.EXTERNAL_CALL_ACTION: return createExternalCallAction();
			case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION: return createProbabilisticBranchTransition();
			case SeffPackage.BRANCH_ACTION: return createBranchAction();
			case SeffPackage.AQUIRE_ACTION: return createAquireAction();
			case SeffPackage.BRANCH_CONDITION: return createBranchCondition();
			case SeffPackage.COLLECTION_ITERATOR_ACTION: return createCollectionIteratorAction();
			case SeffPackage.GUARDED_BRANCH_TRANSITION: return createGuardedBranchTransition();
			case SeffPackage.SET_VARIABLE_ACTION: return createSetVariableAction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StopAction createStopAction() {
		StopActionImpl stopAction = new StopActionImpl();
		return stopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParametricResourceDemand createParametricResourceDemand() {
		ParametricResourceDemandImpl parametricResourceDemand = new ParametricResourceDemandImpl();
		return parametricResourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StartAction createStartAction() {
		StartActionImpl startAction = new StartActionImpl();
		return startAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingSEFF createResourceDemandingSEFF() {
		ResourceDemandingSEFFImpl resourceDemandingSEFF = new ResourceDemandingSEFFImpl();
		return resourceDemandingSEFF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemandingBehaviour createResourceDemandingBehaviour() {
		ResourceDemandingBehaviourImpl resourceDemandingBehaviour = new ResourceDemandingBehaviourImpl();
		return resourceDemandingBehaviour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReleaseAction createReleaseAction() {
		ReleaseActionImpl releaseAction = new ReleaseActionImpl();
		return releaseAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopAction createLoopAction() {
		LoopActionImpl loopAction = new LoopActionImpl();
		return loopAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationCount createIterationCount() {
		IterationCountImpl iterationCount = new IterationCountImpl();
		return iterationCount;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InternalAction createInternalAction() {
		InternalActionImpl internalAction = new InternalActionImpl();
		return internalAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ForkAction createForkAction() {
		ForkActionImpl forkAction = new ForkActionImpl();
		return forkAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalCallAction createExternalCallAction() {
		ExternalCallActionImpl externalCallAction = new ExternalCallActionImpl();
		return externalCallAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ProbabilisticBranchTransition createProbabilisticBranchTransition() {
		ProbabilisticBranchTransitionImpl probabilisticBranchTransition = new ProbabilisticBranchTransitionImpl();
		return probabilisticBranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchAction createBranchAction() {
		BranchActionImpl branchAction = new BranchActionImpl();
		return branchAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AquireAction createAquireAction() {
		AquireActionImpl aquireAction = new AquireActionImpl();
		return aquireAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchCondition createBranchCondition() {
		BranchConditionImpl branchCondition = new BranchConditionImpl();
		return branchCondition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectionIteratorAction createCollectionIteratorAction() {
		CollectionIteratorActionImpl collectionIteratorAction = new CollectionIteratorActionImpl();
		return collectionIteratorAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GuardedBranchTransition createGuardedBranchTransition() {
		GuardedBranchTransitionImpl guardedBranchTransition = new GuardedBranchTransitionImpl();
		return guardedBranchTransition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SetVariableAction createSetVariableAction() {
		SetVariableActionImpl setVariableAction = new SetVariableActionImpl();
		return setVariableAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffPackage getSeffPackage() {
		return (SeffPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SeffPackage getPackage() {
		return SeffPackage.eINSTANCE;
	}

} //SeffFactoryImpl

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
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SeffPackage.STOP_ACTION: return createStopAction();
			case SeffPackage.PARAMETRIC_RESOURCE_DEMAND: return createParametricResourceDemand();
			case SeffPackage.START_ACTION: return createStartAction();
			case SeffPackage.RESOURCE_DEMANDING_SEFF: return createResourceDemandingSEFF();
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR: return createResourceDemandingBehaviour();
			case SeffPackage.RELEASE_ACTION: return createReleaseAction();
			case SeffPackage.PRIMITIVE_PARAMETRIC_PARAMETER_USAGE: return createPrimitiveParametricParameterUsage();
			case SeffPackage.LOOP_ACTION: return createLoopAction();
			case SeffPackage.ITERATION_COUNT: return createIterationCount();
			case SeffPackage.INTERNAL_ACTION: return createInternalAction();
			case SeffPackage.FORK_ACTION: return createForkAction();
			case SeffPackage.EXTERNAL_CALL_ACTION: return createExternalCallAction();
			case SeffPackage.COLLECTION_PARAMETRIC_PARAMETER_USAGE: return createCollectionParametricParameterUsage();
			case SeffPackage.BRANCH_TRANSITION: return createBranchTransition();
			case SeffPackage.BRANCH_ACTION: return createBranchAction();
			case SeffPackage.AQUIRE_ACTION: return createAquireAction();
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
	public PrimitiveParametricParameterUsage createPrimitiveParametricParameterUsage() {
		PrimitiveParametricParameterUsageImpl primitiveParametricParameterUsage = new PrimitiveParametricParameterUsageImpl();
		return primitiveParametricParameterUsage;
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
	public CollectionParametricParameterUsage createCollectionParametricParameterUsage() {
		CollectionParametricParameterUsageImpl collectionParametricParameterUsage = new CollectionParametricParameterUsageImpl();
		return collectionParametricParameterUsage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchTransition createBranchTransition() {
		BranchTransitionImpl branchTransition = new BranchTransitionImpl();
		return branchTransition;
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
	public SeffPackage getSeffPackage() {
		return (SeffPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static SeffPackage getPackage() {
		return SeffPackage.eINSTANCE;
	}

} //SeffFactoryImpl

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.util;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.seff.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public class SeffAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SeffPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = SeffPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch the delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SeffSwitch modelSwitch =
		new SeffSwitch() {
			public Object caseStopAction(StopAction object) {
				return createStopActionAdapter();
			}
			public Object caseAbstractResourceDemandingAction(AbstractResourceDemandingAction object) {
				return createAbstractResourceDemandingActionAdapter();
			}
			public Object caseAbstractAction(AbstractAction object) {
				return createAbstractActionAdapter();
			}
			public Object caseParametricResourceDemand(ParametricResourceDemand object) {
				return createParametricResourceDemandAdapter();
			}
			public Object caseStartAction(StartAction object) {
				return createStartActionAdapter();
			}
			public Object caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
				return createResourceDemandingSEFFAdapter();
			}
			public Object caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
				return createResourceDemandingBehaviourAdapter();
			}
			public Object caseParametricParameterUsage(ParametricParameterUsage object) {
				return createParametricParameterUsageAdapter();
			}
			public Object caseReleaseAction(ReleaseAction object) {
				return createReleaseActionAdapter();
			}
			public Object casePrimitiveParametricParameterUsage(PrimitiveParametricParameterUsage object) {
				return createPrimitiveParametricParameterUsageAdapter();
			}
			public Object caseLoopAction(LoopAction object) {
				return createLoopActionAdapter();
			}
			public Object caseIterationCount(IterationCount object) {
				return createIterationCountAdapter();
			}
			public Object caseInternalAction(InternalAction object) {
				return createInternalActionAdapter();
			}
			public Object caseForkAction(ForkAction object) {
				return createForkActionAdapter();
			}
			public Object caseExternalCallAction(ExternalCallAction object) {
				return createExternalCallActionAdapter();
			}
			public Object caseCollectionParametricParameterUsage(CollectionParametricParameterUsage object) {
				return createCollectionParametricParameterUsageAdapter();
			}
			public Object caseBranchTransition(BranchTransition object) {
				return createBranchTransitionAdapter();
			}
			public Object caseBranchAction(BranchAction object) {
				return createBranchActionAdapter();
			}
			public Object caseAquireAction(AquireAction object) {
				return createAquireActionAdapter();
			}
			public Object caseServiceEffectSpecification(ServiceEffectSpecification object) {
				return createServiceEffectSpecificationAdapter();
			}
			public Object caseIdentifier(Identifier object) {
				return createIdentifierAdapter();
			}
			public Object caseEntity(Entity object) {
				return createEntityAdapter();
			}
			public Object caseRandomVariable(RandomVariable object) {
				return createRandomVariableAdapter();
			}
			public Object defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	public Adapter createAdapter(Notifier target) {
		return (Adapter)modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.StopAction <em>Stop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.StopAction
	 * @generated
	 */
	public Adapter createStopActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction <em>Abstract Resource Demanding Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction
	 * @generated
	 */
	public Adapter createAbstractResourceDemandingActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction
	 * @generated
	 */
	public Adapter createAbstractActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand <em>Parametric Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand
	 * @generated
	 */
	public Adapter createParametricResourceDemandAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.StartAction <em>Start Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.StartAction
	 * @generated
	 */
	public Adapter createStartActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF <em>Resource Demanding SEFF</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
	 * @generated
	 */
	public Adapter createResourceDemandingSEFFAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour <em>Resource Demanding Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
	 * @generated
	 */
	public Adapter createResourceDemandingBehaviourAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage <em>Parametric Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage
	 * @generated
	 */
	public Adapter createParametricParameterUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction <em>Release Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ReleaseAction
	 * @generated
	 */
	public Adapter createReleaseActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage <em>Primitive Parametric Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage
	 * @generated
	 */
	public Adapter createPrimitiveParametricParameterUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.LoopAction <em>Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.LoopAction
	 * @generated
	 */
	public Adapter createLoopActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.IterationCount <em>Iteration Count</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.IterationCount
	 * @generated
	 */
	public Adapter createIterationCountAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.InternalAction <em>Internal Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.InternalAction
	 * @generated
	 */
	public Adapter createInternalActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ForkAction <em>Fork Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ForkAction
	 * @generated
	 */
	public Adapter createForkActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction <em>External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction
	 * @generated
	 */
	public Adapter createExternalCallActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage <em>Collection Parametric Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.CollectionParametricParameterUsage
	 * @generated
	 */
	public Adapter createCollectionParametricParameterUsageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.BranchTransition <em>Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.BranchTransition
	 * @generated
	 */
	public Adapter createBranchTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.BranchAction <em>Branch Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.BranchAction
	 * @generated
	 */
	public Adapter createBranchActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.AquireAction <em>Aquire Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.AquireAction
	 * @generated
	 */
	public Adapter createAquireActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification <em>Service Effect Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
	 * @generated
	 */
	public Adapter createServiceEffectSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.identifier.Identifier
	 * @generated
	 */
	public Adapter createIdentifierAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity <em>Entity</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.core.entity.Entity
	 * @generated
	 */
	public Adapter createEntityAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable <em>Random Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable
	 * @generated
	 */
	public Adapter createRandomVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //SeffAdapterFactory

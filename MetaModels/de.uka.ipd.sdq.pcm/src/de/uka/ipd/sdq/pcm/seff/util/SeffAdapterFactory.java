/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.identifier.Identifier;
import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.core.entity.NamedElement;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CallAction;
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
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter
 * <code>createXXX</code> method for each class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public class SeffAdapterFactory extends AdapterFactoryImpl {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    protected static SeffPackage modelPackage;

    /**
     * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SeffAdapterFactory() {
        if (modelPackage == null) {
            modelPackage = SeffPackage.eINSTANCE;
        }
    }

    /**
     * Returns whether this factory is applicable for the type of the object. <!-- begin-user-doc
     * --> This implementation returns <code>true</code> if the object is either the model's package
     * or is an instance object of the model. <!-- end-user-doc -->
     * 
     * @return whether this factory is applicable for the type of the object.
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object object) {
        if (object == modelPackage) {
            return true;
        }
        if (object instanceof EObject) {
            return ((EObject) object).eClass().getEPackage() == modelPackage;
        }
        return false;
    }

    /**
     * The switch that delegates to the <code>createXXX</code> methods. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     */
    protected SeffSwitch<Adapter> modelSwitch = new SeffSwitch<Adapter>() {
        @Override
        public Adapter caseStopAction(StopAction object) {
            return createStopActionAdapter();
        }

        @Override
        public Adapter caseAbstractInternalControlFlowAction(AbstractInternalControlFlowAction object) {
            return createAbstractInternalControlFlowActionAdapter();
        }

        @Override
        public Adapter caseAbstractAction(AbstractAction object) {
            return createAbstractActionAdapter();
        }

        @Override
        public Adapter caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
            return createResourceDemandingBehaviourAdapter();
        }

        @Override
        public Adapter caseAbstractLoopAction(AbstractLoopAction object) {
            return createAbstractLoopActionAdapter();
        }

        @Override
        public Adapter caseAbstractBranchTransition(AbstractBranchTransition object) {
            return createAbstractBranchTransitionAdapter();
        }

        @Override
        public Adapter caseBranchAction(BranchAction object) {
            return createBranchActionAdapter();
        }

        @Override
        public Adapter caseCallAction(CallAction object) {
            return createCallActionAdapter();
        }

        @Override
        public Adapter caseStartAction(StartAction object) {
            return createStartActionAdapter();
        }

        @Override
        public Adapter caseServiceEffectSpecification(ServiceEffectSpecification object) {
            return createServiceEffectSpecificationAdapter();
        }

        @Override
        public Adapter caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
            return createResourceDemandingSEFFAdapter();
        }

        @Override
        public Adapter caseResourceDemandingInternalBehaviour(ResourceDemandingInternalBehaviour object) {
            return createResourceDemandingInternalBehaviourAdapter();
        }

        @Override
        public Adapter caseReleaseAction(ReleaseAction object) {
            return createReleaseActionAdapter();
        }

        @Override
        public Adapter caseLoopAction(LoopAction object) {
            return createLoopActionAdapter();
        }

        @Override
        public Adapter caseForkAction(ForkAction object) {
            return createForkActionAdapter();
        }

        @Override
        public Adapter caseForkedBehaviour(ForkedBehaviour object) {
            return createForkedBehaviourAdapter();
        }

        @Override
        public Adapter caseSynchronisationPoint(SynchronisationPoint object) {
            return createSynchronisationPointAdapter();
        }

        @Override
        public Adapter caseExternalCallAction(ExternalCallAction object) {
            return createExternalCallActionAdapter();
        }

        @Override
        public Adapter caseCallReturnAction(CallReturnAction object) {
            return createCallReturnActionAdapter();
        }

        @Override
        public Adapter caseProbabilisticBranchTransition(ProbabilisticBranchTransition object) {
            return createProbabilisticBranchTransitionAdapter();
        }

        @Override
        public Adapter caseAcquireAction(AcquireAction object) {
            return createAcquireActionAdapter();
        }

        @Override
        public Adapter caseCollectionIteratorAction(CollectionIteratorAction object) {
            return createCollectionIteratorActionAdapter();
        }

        @Override
        public Adapter caseGuardedBranchTransition(GuardedBranchTransition object) {
            return createGuardedBranchTransitionAdapter();
        }

        @Override
        public Adapter caseSetVariableAction(SetVariableAction object) {
            return createSetVariableActionAdapter();
        }

        @Override
        public Adapter caseInternalCallAction(InternalCallAction object) {
            return createInternalCallActionAdapter();
        }

        @Override
        public Adapter caseEmitEventAction(EmitEventAction object) {
            return createEmitEventActionAdapter();
        }

        @Override
        public Adapter caseInternalAction(InternalAction object) {
            return createInternalActionAdapter();
        }

        @Override
        public Adapter caseIdentifier(Identifier object) {
            return createIdentifierAdapter();
        }

        @Override
        public Adapter caseNamedElement(NamedElement object) {
            return createNamedElementAdapter();
        }

        @Override
        public Adapter caseEntity(Entity object) {
            return createEntityAdapter();
        }

        @Override
        public Adapter caseFailureHandlingEntity(FailureHandlingEntity object) {
            return createFailureHandlingEntityAdapter();
        }

        @Override
        public Adapter defaultCase(EObject object) {
            return createEObjectAdapter();
        }
    };

    /**
     * Creates an adapter for the <code>target</code>. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param target
     *            the object to adapt.
     * @return the adapter for the <code>target</code>.
     * @generated
     */
    @Override
    public Adapter createAdapter(Notifier target) {
        return modelSwitch.doSwitch((EObject) target);
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.StopAction
     * <em>Stop Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.StopAction
     * @generated
     */
    public Adapter createStopActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction
     * <em>Abstract Internal Control Flow Action</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction
     * @generated
     */
    public Adapter createAbstractInternalControlFlowActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction
     * <em>Abstract Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.AbstractAction
     * @generated
     */
    public Adapter createAbstractActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
     * <em>Resource Demanding Behaviour</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour
     * @generated
     */
    public Adapter createResourceDemandingBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.AbstractLoopAction <em>Abstract Loop Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.AbstractLoopAction
     * @generated
     */
    public Adapter createAbstractLoopActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition <em>Abstract Branch Transition</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition
     * @generated
     */
    public Adapter createAbstractBranchTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.BranchAction
     * <em>Branch Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.BranchAction
     * @generated
     */
    public Adapter createBranchActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.StartAction
     * <em>Start Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.StartAction
     * @generated
     */
    public Adapter createStartActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF <em>Resource Demanding SEFF</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
     * @generated
     */
    public Adapter createResourceDemandingSEFFAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour
     * <em>Resource Demanding Internal Behaviour</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ResourceDemandingInternalBehaviour
     * @generated
     */
    public Adapter createResourceDemandingInternalBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ReleaseAction
     * <em>Release Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ReleaseAction
     * @generated
     */
    public Adapter createReleaseActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.LoopAction
     * <em>Loop Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.LoopAction
     * @generated
     */
    public Adapter createLoopActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.InternalAction
     * <em>Internal Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.InternalAction
     * @generated
     */
    public Adapter createInternalActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ForkAction
     * <em>Fork Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ForkAction
     * @generated
     */
    public Adapter createForkActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour
     * <em>Forked Behaviour</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ForkedBehaviour
     * @generated
     */
    public Adapter createForkedBehaviourAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.SynchronisationPoint <em>Synchronisation Point</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.SynchronisationPoint
     * @generated
     */
    public Adapter createSynchronisationPointAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ExternalCallAction <em>External Call Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ExternalCallAction
     * @generated
     */
    public Adapter createExternalCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.CallReturnAction <em>Call Return Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.CallReturnAction
     * @generated
     */
    public Adapter createCallReturnActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.CallAction
     * <em>Call Action</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.CallAction
     * @generated
     */
    public Adapter createCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity
     * <em>Failure Handling Entity</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity
     * @generated
     */
    public Adapter createFailureHandlingEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
     * <em>Probabilistic Branch Transition</em>}'. <!-- begin-user-doc --> This default
     * implementation returns null so that we can easily ignore cases; it's useful to ignore a case
     * when inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
     * @generated
     */
    public Adapter createProbabilisticBranchTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.AcquireAction
     * <em>Acquire Action</em>}'. <!-- begin-user-doc --> This default implementation returns null
     * so that we can easily ignore cases; it's useful to ignore a case when inheritance will catch
     * all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.AcquireAction
     * @generated
     */
    public Adapter createAcquireActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction <em>Collection Iterator Action</em>}
     * '. <!-- begin-user-doc --> This default implementation returns null so that we can easily
     * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway.
     * <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
     * @generated
     */
    public Adapter createCollectionIteratorActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition <em>Guarded Branch Transition</em>}'.
     * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
     * @generated
     */
    public Adapter createGuardedBranchTransitionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.SetVariableAction <em>Set Variable Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.SetVariableAction
     * @generated
     */
    public Adapter createSetVariableActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.InternalCallAction <em>Internal Call Action</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.InternalCallAction
     * @generated
     */
    public Adapter createInternalCallActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.seff.EmitEventAction
     * <em>Emit Event Action</em>}'. <!-- begin-user-doc --> This default implementation returns
     * null so that we can easily ignore cases; it's useful to ignore a case when inheritance will
     * catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.EmitEventAction
     * @generated
     */
    public Adapter createEmitEventActionAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
     * <em>Service Effect Specification</em>}'. <!-- begin-user-doc --> This default implementation
     * returns null so that we can easily ignore cases; it's useful to ignore a case when
     * inheritance will catch all the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
     * @generated
     */
    public Adapter createServiceEffectSpecificationAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.identifier.Identifier
     * <em>Identifier</em>}'. <!-- begin-user-doc --> This default implementation returns null so
     * that we can easily ignore cases; it's useful to ignore a case when inheritance will catch all
     * the cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.identifier.Identifier
     * @generated
     */
    public Adapter createIdentifierAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '
     * {@link de.uka.ipd.sdq.pcm.core.entity.NamedElement <em>Named Element</em>}'. <!--
     * begin-user-doc --> This default implementation returns null so that we can easily ignore
     * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
     * end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.NamedElement
     * @generated
     */
    public Adapter createNamedElementAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for an object of class '{@link de.uka.ipd.sdq.pcm.core.entity.Entity
     * <em>Entity</em>}'. <!-- begin-user-doc --> This default implementation returns null so that
     * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the
     * cases anyway. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @see de.uka.ipd.sdq.pcm.core.entity.Entity
     * @generated
     */
    public Adapter createEntityAdapter() {
        return null;
    }

    /**
     * Creates a new adapter for the default case. <!-- begin-user-doc --> This default
     * implementation returns null. <!-- end-user-doc -->
     * 
     * @return the new adapter.
     * @generated
     */
    public Adapter createEObjectAdapter() {
        return null;
    }

} // SeffAdapterFactory

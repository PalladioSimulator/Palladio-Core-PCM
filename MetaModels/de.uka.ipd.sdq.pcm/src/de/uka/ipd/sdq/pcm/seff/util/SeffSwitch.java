/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage
 * @generated
 */
public class SeffSwitch<T> {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static SeffPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SeffSwitch() {
		if (modelPackage == null) {
			modelPackage = SeffPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case SeffPackage.STOP_ACTION: {
				StopAction stopAction = (StopAction)theEObject;
				T result = caseStopAction(stopAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(stopAction);
				if (result == null) result = caseAbstractAction(stopAction);
				if (result == null) result = caseEntity(stopAction);
				if (result == null) result = caseIdentifier(stopAction);
				if (result == null) result = caseNamedElement(stopAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.ABSTRACT_INTERNAL_CONTROL_FLOW_ACTION: {
				AbstractInternalControlFlowAction abstractInternalControlFlowAction = (AbstractInternalControlFlowAction)theEObject;
				T result = caseAbstractInternalControlFlowAction(abstractInternalControlFlowAction);
				if (result == null) result = caseAbstractAction(abstractInternalControlFlowAction);
				if (result == null) result = caseEntity(abstractInternalControlFlowAction);
				if (result == null) result = caseIdentifier(abstractInternalControlFlowAction);
				if (result == null) result = caseNamedElement(abstractInternalControlFlowAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.ABSTRACT_ACTION: {
				AbstractAction abstractAction = (AbstractAction)theEObject;
				T result = caseAbstractAction(abstractAction);
				if (result == null) result = caseEntity(abstractAction);
				if (result == null) result = caseIdentifier(abstractAction);
				if (result == null) result = caseNamedElement(abstractAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.RESOURCE_DEMANDING_BEHAVIOUR: {
				ResourceDemandingBehaviour resourceDemandingBehaviour = (ResourceDemandingBehaviour)theEObject;
				T result = caseResourceDemandingBehaviour(resourceDemandingBehaviour);
				if (result == null) result = caseIdentifier(resourceDemandingBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.ABSTRACT_LOOP_ACTION: {
				AbstractLoopAction abstractLoopAction = (AbstractLoopAction)theEObject;
				T result = caseAbstractLoopAction(abstractLoopAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(abstractLoopAction);
				if (result == null) result = caseAbstractAction(abstractLoopAction);
				if (result == null) result = caseEntity(abstractLoopAction);
				if (result == null) result = caseIdentifier(abstractLoopAction);
				if (result == null) result = caseNamedElement(abstractLoopAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.ABSTRACT_BRANCH_TRANSITION: {
				AbstractBranchTransition abstractBranchTransition = (AbstractBranchTransition)theEObject;
				T result = caseAbstractBranchTransition(abstractBranchTransition);
				if (result == null) result = caseEntity(abstractBranchTransition);
				if (result == null) result = caseIdentifier(abstractBranchTransition);
				if (result == null) result = caseNamedElement(abstractBranchTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.BRANCH_ACTION: {
				BranchAction branchAction = (BranchAction)theEObject;
				T result = caseBranchAction(branchAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(branchAction);
				if (result == null) result = caseAbstractAction(branchAction);
				if (result == null) result = caseEntity(branchAction);
				if (result == null) result = caseIdentifier(branchAction);
				if (result == null) result = caseNamedElement(branchAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.CALL_ACTION: {
				CallAction callAction = (CallAction)theEObject;
				T result = caseCallAction(callAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.START_ACTION: {
				StartAction startAction = (StartAction)theEObject;
				T result = caseStartAction(startAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(startAction);
				if (result == null) result = caseAbstractAction(startAction);
				if (result == null) result = caseEntity(startAction);
				if (result == null) result = caseIdentifier(startAction);
				if (result == null) result = caseNamedElement(startAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.SERVICE_EFFECT_SPECIFICATION: {
				ServiceEffectSpecification serviceEffectSpecification = (ServiceEffectSpecification)theEObject;
				T result = caseServiceEffectSpecification(serviceEffectSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.RESOURCE_DEMANDING_SEFF: {
				ResourceDemandingSEFF resourceDemandingSEFF = (ResourceDemandingSEFF)theEObject;
				T result = caseResourceDemandingSEFF(resourceDemandingSEFF);
				if (result == null) result = caseServiceEffectSpecification(resourceDemandingSEFF);
				if (result == null) result = caseResourceDemandingBehaviour(resourceDemandingSEFF);
				if (result == null) result = caseIdentifier(resourceDemandingSEFF);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.RESOURCE_DEMANDING_INTERNAL_BEHAVIOUR: {
				ResourceDemandingInternalBehaviour resourceDemandingInternalBehaviour = (ResourceDemandingInternalBehaviour)theEObject;
				T result = caseResourceDemandingInternalBehaviour(resourceDemandingInternalBehaviour);
				if (result == null) result = caseResourceDemandingBehaviour(resourceDemandingInternalBehaviour);
				if (result == null) result = caseIdentifier(resourceDemandingInternalBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.RELEASE_ACTION: {
				ReleaseAction releaseAction = (ReleaseAction)theEObject;
				T result = caseReleaseAction(releaseAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(releaseAction);
				if (result == null) result = caseAbstractAction(releaseAction);
				if (result == null) result = caseEntity(releaseAction);
				if (result == null) result = caseIdentifier(releaseAction);
				if (result == null) result = caseNamedElement(releaseAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.LOOP_ACTION: {
				LoopAction loopAction = (LoopAction)theEObject;
				T result = caseLoopAction(loopAction);
				if (result == null) result = caseAbstractLoopAction(loopAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(loopAction);
				if (result == null) result = caseAbstractAction(loopAction);
				if (result == null) result = caseEntity(loopAction);
				if (result == null) result = caseIdentifier(loopAction);
				if (result == null) result = caseNamedElement(loopAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.FORK_ACTION: {
				ForkAction forkAction = (ForkAction)theEObject;
				T result = caseForkAction(forkAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(forkAction);
				if (result == null) result = caseAbstractAction(forkAction);
				if (result == null) result = caseEntity(forkAction);
				if (result == null) result = caseIdentifier(forkAction);
				if (result == null) result = caseNamedElement(forkAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.FORKED_BEHAVIOUR: {
				ForkedBehaviour forkedBehaviour = (ForkedBehaviour)theEObject;
				T result = caseForkedBehaviour(forkedBehaviour);
				if (result == null) result = caseResourceDemandingBehaviour(forkedBehaviour);
				if (result == null) result = caseIdentifier(forkedBehaviour);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.SYNCHRONISATION_POINT: {
				SynchronisationPoint synchronisationPoint = (SynchronisationPoint)theEObject;
				T result = caseSynchronisationPoint(synchronisationPoint);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.EXTERNAL_CALL_ACTION: {
				ExternalCallAction externalCallAction = (ExternalCallAction)theEObject;
				T result = caseExternalCallAction(externalCallAction);
				if (result == null) result = caseAbstractAction(externalCallAction);
				if (result == null) result = caseCallReturnAction(externalCallAction);
				if (result == null) result = caseFailureHandlingEntity(externalCallAction);
				if (result == null) result = caseEntity(externalCallAction);
				if (result == null) result = caseCallAction(externalCallAction);
				if (result == null) result = caseIdentifier(externalCallAction);
				if (result == null) result = caseNamedElement(externalCallAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.CALL_RETURN_ACTION: {
				CallReturnAction callReturnAction = (CallReturnAction)theEObject;
				T result = caseCallReturnAction(callReturnAction);
				if (result == null) result = caseCallAction(callReturnAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.PROBABILISTIC_BRANCH_TRANSITION: {
				ProbabilisticBranchTransition probabilisticBranchTransition = (ProbabilisticBranchTransition)theEObject;
				T result = caseProbabilisticBranchTransition(probabilisticBranchTransition);
				if (result == null) result = caseAbstractBranchTransition(probabilisticBranchTransition);
				if (result == null) result = caseEntity(probabilisticBranchTransition);
				if (result == null) result = caseIdentifier(probabilisticBranchTransition);
				if (result == null) result = caseNamedElement(probabilisticBranchTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.ACQUIRE_ACTION: {
				AcquireAction acquireAction = (AcquireAction)theEObject;
				T result = caseAcquireAction(acquireAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(acquireAction);
				if (result == null) result = caseAbstractAction(acquireAction);
				if (result == null) result = caseEntity(acquireAction);
				if (result == null) result = caseIdentifier(acquireAction);
				if (result == null) result = caseNamedElement(acquireAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.COLLECTION_ITERATOR_ACTION: {
				CollectionIteratorAction collectionIteratorAction = (CollectionIteratorAction)theEObject;
				T result = caseCollectionIteratorAction(collectionIteratorAction);
				if (result == null) result = caseAbstractLoopAction(collectionIteratorAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(collectionIteratorAction);
				if (result == null) result = caseAbstractAction(collectionIteratorAction);
				if (result == null) result = caseEntity(collectionIteratorAction);
				if (result == null) result = caseIdentifier(collectionIteratorAction);
				if (result == null) result = caseNamedElement(collectionIteratorAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.GUARDED_BRANCH_TRANSITION: {
				GuardedBranchTransition guardedBranchTransition = (GuardedBranchTransition)theEObject;
				T result = caseGuardedBranchTransition(guardedBranchTransition);
				if (result == null) result = caseAbstractBranchTransition(guardedBranchTransition);
				if (result == null) result = caseEntity(guardedBranchTransition);
				if (result == null) result = caseIdentifier(guardedBranchTransition);
				if (result == null) result = caseNamedElement(guardedBranchTransition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.SET_VARIABLE_ACTION: {
				SetVariableAction setVariableAction = (SetVariableAction)theEObject;
				T result = caseSetVariableAction(setVariableAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(setVariableAction);
				if (result == null) result = caseAbstractAction(setVariableAction);
				if (result == null) result = caseEntity(setVariableAction);
				if (result == null) result = caseIdentifier(setVariableAction);
				if (result == null) result = caseNamedElement(setVariableAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.INTERNAL_CALL_ACTION: {
				InternalCallAction internalCallAction = (InternalCallAction)theEObject;
				T result = caseInternalCallAction(internalCallAction);
				if (result == null) result = caseCallAction(internalCallAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(internalCallAction);
				if (result == null) result = caseAbstractAction(internalCallAction);
				if (result == null) result = caseEntity(internalCallAction);
				if (result == null) result = caseIdentifier(internalCallAction);
				if (result == null) result = caseNamedElement(internalCallAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.EMIT_EVENT_ACTION: {
				EmitEventAction emitEventAction = (EmitEventAction)theEObject;
				T result = caseEmitEventAction(emitEventAction);
				if (result == null) result = caseAbstractAction(emitEventAction);
				if (result == null) result = caseCallAction(emitEventAction);
				if (result == null) result = caseEntity(emitEventAction);
				if (result == null) result = caseIdentifier(emitEventAction);
				if (result == null) result = caseNamedElement(emitEventAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case SeffPackage.INTERNAL_ACTION: {
				InternalAction internalAction = (InternalAction)theEObject;
				T result = caseInternalAction(internalAction);
				if (result == null) result = caseAbstractInternalControlFlowAction(internalAction);
				if (result == null) result = caseAbstractAction(internalAction);
				if (result == null) result = caseEntity(internalAction);
				if (result == null) result = caseIdentifier(internalAction);
				if (result == null) result = caseNamedElement(internalAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stop Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stop Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStopAction(StopAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Internal Control Flow Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Internal Control Flow Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractInternalControlFlowAction(AbstractInternalControlFlowAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractAction(AbstractAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Demanding Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceDemandingBehaviour(ResourceDemandingBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Loop Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Loop Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractLoopAction(AbstractLoopAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstract Branch Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstract Branch Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractBranchTransition(AbstractBranchTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Branch Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Branch Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBranchAction(BranchAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Start Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Start Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStartAction(StartAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Demanding SEFF</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Demanding SEFF</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceDemandingSEFF(ResourceDemandingSEFF object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource Demanding Internal Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource Demanding Internal Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResourceDemandingInternalBehaviour(ResourceDemandingInternalBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Release Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Release Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReleaseAction(ReleaseAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Loop Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Loop Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoopAction(LoopAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalAction(InternalAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fork Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fork Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForkAction(ForkAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Forked Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Forked Behaviour</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseForkedBehaviour(ForkedBehaviour object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synchronisation Point</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synchronisation Point</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynchronisationPoint(SynchronisationPoint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>External Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>External Call Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExternalCallAction(ExternalCallAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Return Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Return Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallReturnAction(CallReturnAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallAction(CallAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Failure Handling Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Failure Handling Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFailureHandlingEntity(FailureHandlingEntity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Probabilistic Branch Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Probabilistic Branch Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbabilisticBranchTransition(ProbabilisticBranchTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Acquire Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Acquire Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAcquireAction(AcquireAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collection Iterator Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collection Iterator Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectionIteratorAction(CollectionIteratorAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guarded Branch Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guarded Branch Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuardedBranchTransition(GuardedBranchTransition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Set Variable Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Set Variable Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSetVariableAction(SetVariableAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Call Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Call Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalCallAction(InternalCallAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Emit Event Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Emit Event Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmitEventAction(EmitEventAction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Effect Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Effect Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceEffectSpecification(ServiceEffectSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIdentifier(Identifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntity(Entity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //SeffSwitch

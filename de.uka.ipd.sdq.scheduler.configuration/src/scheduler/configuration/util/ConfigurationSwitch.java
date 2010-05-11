/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration.util;

import de.uka.ipd.sdq.identifier.Identifier;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import scheduler.configuration.*;

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
 * @see scheduler.configuration.ConfigurationPackage
 * @generated
 */
public class ConfigurationSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ConfigurationPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfigurationSwitch() {
		if (modelPackage == null) {
			modelPackage = ConfigurationPackage.eINSTANCE;
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
			case ConfigurationPackage.DYNAMIC_PRIORITY_BOOST_CONFIGURATIOIN: {
				DynamicPriorityBoostConfiguratioin dynamicPriorityBoostConfiguratioin = (DynamicPriorityBoostConfiguratioin)theEObject;
				T result = caseDynamicPriorityBoostConfiguratioin(dynamicPriorityBoostConfiguratioin);
				if (result == null) result = casePriorityBoostConfiguration(dynamicPriorityBoostConfiguratioin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PRIORITY_BOOST_CONFIGURATION: {
				PriorityBoostConfiguration priorityBoostConfiguration = (PriorityBoostConfiguration)theEObject;
				T result = casePriorityBoostConfiguration(priorityBoostConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.LOAD_BALANCING: {
				LoadBalancing loadBalancing = (LoadBalancing)theEObject;
				T result = caseLoadBalancing(loadBalancing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.MULTIPLE_QUEUE_CONFIGURATION: {
				MultipleQueueConfiguration multipleQueueConfiguration = (MultipleQueueConfiguration)theEObject;
				T result = caseMultipleQueueConfiguration(multipleQueueConfiguration);
				if (result == null) result = caseQueueingConfiguration(multipleQueueConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.QUEUEING_CONFIGURATION: {
				QueueingConfiguration queueingConfiguration = (QueueingConfiguration)theEObject;
				T result = caseQueueingConfiguration(queueingConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.QUANTUM_TIME_SLICE_CONFIGURATION: {
				QuantumTimeSliceConfiguration quantumTimeSliceConfiguration = (QuantumTimeSliceConfiguration)theEObject;
				T result = caseQuantumTimeSliceConfiguration(quantumTimeSliceConfiguration);
				if (result == null) result = caseTimeSliceConfiguration(quantumTimeSliceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.TIME_SLICE_CONFIGURATION: {
				TimeSliceConfiguration timeSliceConfiguration = (TimeSliceConfiguration)theEObject;
				T result = caseTimeSliceConfiguration(timeSliceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PREEMPTION_CONFIGURATION: {
				PreemptionConfiguration preemptionConfiguration = (PreemptionConfiguration)theEObject;
				T result = casePreemptionConfiguration(preemptionConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PRIORITY_CONFIGURATION: {
				PriorityConfiguration priorityConfiguration = (PriorityConfiguration)theEObject;
				T result = casePriorityConfiguration(priorityConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PRIORITY_RANGE: {
				PriorityRange priorityRange = (PriorityRange)theEObject;
				T result = casePriorityRange(priorityRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PRIORITY_DEPENDENT_TIME_SLICE_CONFIGURATION: {
				PriorityDependentTimeSliceConfiguration priorityDependentTimeSliceConfiguration = (PriorityDependentTimeSliceConfiguration)theEObject;
				T result = casePriorityDependentTimeSliceConfiguration(priorityDependentTimeSliceConfiguration);
				if (result == null) result = caseTimeSliceConfiguration(priorityDependentTimeSliceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.ACTIVE_RESOURCE_CONFIGURATION: {
				ActiveResourceConfiguration activeResourceConfiguration = (ActiveResourceConfiguration)theEObject;
				T result = caseActiveResourceConfiguration(activeResourceConfiguration);
				if (result == null) result = caseIdentifier(activeResourceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PASSIVE_RESOURCE_CONFIGURATION: {
				PassiveResourceConfiguration passiveResourceConfiguration = (PassiveResourceConfiguration)theEObject;
				T result = casePassiveResourceConfiguration(passiveResourceConfiguration);
				if (result == null) result = caseIdentifier(passiveResourceConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.STATIC_PRIORITY_BOOST: {
				StaticPriorityBoost staticPriorityBoost = (StaticPriorityBoost)theEObject;
				T result = caseStaticPriorityBoost(staticPriorityBoost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.PROCESS_CONFIGURATION: {
				ProcessConfiguration processConfiguration = (ProcessConfiguration)theEObject;
				T result = caseProcessConfiguration(processConfiguration);
				if (result == null) result = caseIdentifier(processConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.SINGLE_QUEUE_CONFIGURATION: {
				SingleQueueConfiguration singleQueueConfiguration = (SingleQueueConfiguration)theEObject;
				T result = caseSingleQueueConfiguration(singleQueueConfiguration);
				if (result == null) result = caseQueueingConfiguration(singleQueueConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.STATIC_PRIORITY_BOOST_CONFIGURATION: {
				StaticPriorityBoostConfiguration staticPriorityBoostConfiguration = (StaticPriorityBoostConfiguration)theEObject;
				T result = caseStaticPriorityBoostConfiguration(staticPriorityBoostConfiguration);
				if (result == null) result = casePriorityBoostConfiguration(staticPriorityBoostConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.SCHEDULER_CONFIGURATION: {
				SchedulerConfiguration schedulerConfiguration = (SchedulerConfiguration)theEObject;
				T result = caseSchedulerConfiguration(schedulerConfiguration);
				if (result == null) result = caseIdentifier(schedulerConfiguration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ConfigurationPackage.STARVATION_BOOST: {
				StarvationBoost starvationBoost = (StarvationBoost)theEObject;
				T result = caseStarvationBoost(starvationBoost);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Dynamic Priority Boost Configuratioin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Dynamic Priority Boost Configuratioin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDynamicPriorityBoostConfiguratioin(DynamicPriorityBoostConfiguratioin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Boost Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Boost Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityBoostConfiguration(PriorityBoostConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load Balancing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load Balancing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoadBalancing(LoadBalancing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Multiple Queue Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Multiple Queue Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMultipleQueueConfiguration(MultipleQueueConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Queueing Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Queueing Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQueueingConfiguration(QueueingConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Quantum Time Slice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Quantum Time Slice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseQuantumTimeSliceConfiguration(QuantumTimeSliceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Slice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Slice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeSliceConfiguration(TimeSliceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Preemption Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Preemption Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePreemptionConfiguration(PreemptionConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityConfiguration(PriorityConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityRange(PriorityRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Priority Dependent Time Slice Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Priority Dependent Time Slice Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePriorityDependentTimeSliceConfiguration(PriorityDependentTimeSliceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Active Resource Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Active Resource Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActiveResourceConfiguration(ActiveResourceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Passive Resource Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Passive Resource Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassiveResourceConfiguration(PassiveResourceConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Priority Boost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Priority Boost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticPriorityBoost(StaticPriorityBoost object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Process Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Process Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessConfiguration(ProcessConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Queue Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Queue Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleQueueConfiguration(SingleQueueConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Static Priority Boost Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Static Priority Boost Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStaticPriorityBoostConfiguration(StaticPriorityBoostConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scheduler Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scheduler Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSchedulerConfiguration(SchedulerConfiguration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Starvation Boost</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Starvation Boost</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStarvationBoost(StarvationBoost object) {
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

} //ConfigurationSwitch

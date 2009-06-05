/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package LqnCore.util;

import LqnCore.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

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
 * @see LqnCore.LqnCorePackage
 * @generated
 */
public class LqnCoreSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static LqnCorePackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LqnCoreSwitch() {
		if (modelPackage == null) {
			modelPackage = LqnCorePackage.eINSTANCE;
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
			case LqnCorePackage.ACTIVITY_DEF_BASE: {
				ActivityDefBase activityDefBase = (ActivityDefBase)theEObject;
				T result = caseActivityDefBase(activityDefBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_DEF_TYPE: {
				ActivityDefType activityDefType = (ActivityDefType)theEObject;
				T result = caseActivityDefType(activityDefType);
				if (result == null) result = caseActivityDefBase(activityDefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_GRAPH_BASE: {
				ActivityGraphBase activityGraphBase = (ActivityGraphBase)theEObject;
				T result = caseActivityGraphBase(activityGraphBase);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_LIST_TYPE: {
				ActivityListType activityListType = (ActivityListType)theEObject;
				T result = caseActivityListType(activityListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_LOOP_LIST_TYPE: {
				ActivityLoopListType activityLoopListType = (ActivityLoopListType)theEObject;
				T result = caseActivityLoopListType(activityLoopListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_LOOP_TYPE: {
				ActivityLoopType activityLoopType = (ActivityLoopType)theEObject;
				T result = caseActivityLoopType(activityLoopType);
				if (result == null) result = caseActivityType(activityLoopType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_MAKING_CALL_TYPE: {
				ActivityMakingCallType activityMakingCallType = (ActivityMakingCallType)theEObject;
				T result = caseActivityMakingCallType(activityMakingCallType);
				if (result == null) result = caseMakingCallType(activityMakingCallType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_OR_TYPE: {
				ActivityOrType activityOrType = (ActivityOrType)theEObject;
				T result = caseActivityOrType(activityOrType);
				if (result == null) result = caseActivityType(activityOrType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_PHASES_TYPE: {
				ActivityPhasesType activityPhasesType = (ActivityPhasesType)theEObject;
				T result = caseActivityPhasesType(activityPhasesType);
				if (result == null) result = caseActivityDefBase(activityPhasesType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ACTIVITY_TYPE: {
				ActivityType activityType = (ActivityType)theEObject;
				T result = caseActivityType(activityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.AND_JOIN_LIST_TYPE: {
				AndJoinListType andJoinListType = (AndJoinListType)theEObject;
				T result = caseAndJoinListType(andJoinListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ASYNCH_CALL_TYPE: {
				AsynchCallType asynchCallType = (AsynchCallType)theEObject;
				T result = caseAsynchCallType(asynchCallType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.BIND_TYPE: {
				BindType bindType = (BindType)theEObject;
				T result = caseBindType(bindType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.CALL_LIST_TYPE: {
				CallListType callListType = (CallListType)theEObject;
				T result = caseCallListType(callListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.DOCUMENT_ROOT: {
				DocumentRoot documentRoot = (DocumentRoot)theEObject;
				T result = caseDocumentRoot(documentRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ENTRY_ACTIVITY_DEF_TYPE: {
				EntryActivityDefType entryActivityDefType = (EntryActivityDefType)theEObject;
				T result = caseEntryActivityDefType(entryActivityDefType);
				if (result == null) result = caseActivityDefBase(entryActivityDefType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ENTRY_ACTIVITY_GRAPH: {
				EntryActivityGraph entryActivityGraph = (EntryActivityGraph)theEObject;
				T result = caseEntryActivityGraph(entryActivityGraph);
				if (result == null) result = caseActivityGraphBase(entryActivityGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ENTRY_MAKING_CALL_TYPE: {
				EntryMakingCallType entryMakingCallType = (EntryMakingCallType)theEObject;
				T result = caseEntryMakingCallType(entryMakingCallType);
				if (result == null) result = caseMakingCallType(entryMakingCallType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.ENTRY_TYPE: {
				EntryType entryType = (EntryType)theEObject;
				T result = caseEntryType(entryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.FIRST_PLOT_TYPE: {
				FirstPlotType firstPlotType = (FirstPlotType)theEObject;
				T result = caseFirstPlotType(firstPlotType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.HISTOGRAM_BIN_TYPE: {
				HistogramBinType histogramBinType = (HistogramBinType)theEObject;
				T result = caseHistogramBinType(histogramBinType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.IN_PORT_TYPE: {
				InPortType inPortType = (InPortType)theEObject;
				T result = caseInPortType(inPortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.INTERFACE_TYPE: {
				InterfaceType interfaceType = (InterfaceType)theEObject;
				T result = caseInterfaceType(interfaceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.LQN_CORE_TYPE: {
				LqnCoreType lqnCoreType = (LqnCoreType)theEObject;
				T result = caseLqnCoreType(lqnCoreType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.LQN_MODEL_TYPE: {
				LqnModelType lqnModelType = (LqnModelType)theEObject;
				T result = caseLqnModelType(lqnModelType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.MAKING_CALL_TYPE: {
				MakingCallType makingCallType = (MakingCallType)theEObject;
				T result = caseMakingCallType(makingCallType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OR_LIST_TYPE: {
				OrListType orListType = (OrListType)theEObject;
				T result = caseOrListType(orListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OUT_PORT_TYPE: {
				OutPortType outPortType = (OutPortType)theEObject;
				T result = caseOutPortType(outPortType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OUTPUT_DISTRIBUTION_TYPE: {
				OutputDistributionType outputDistributionType = (OutputDistributionType)theEObject;
				T result = caseOutputDistributionType(outputDistributionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OUTPUT_ENTRY_DISTRIBUTION_TYPE: {
				OutputEntryDistributionType outputEntryDistributionType = (OutputEntryDistributionType)theEObject;
				T result = caseOutputEntryDistributionType(outputEntryDistributionType);
				if (result == null) result = caseOutputDistributionType(outputEntryDistributionType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OUTPUT_RESULT_FORWARDING_AND_JOIN_DELAY: {
				OutputResultForwardingANDJoinDelay outputResultForwardingANDJoinDelay = (OutputResultForwardingANDJoinDelay)theEObject;
				T result = caseOutputResultForwardingANDJoinDelay(outputResultForwardingANDJoinDelay);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.OUTPUT_RESULT_TYPE: {
				OutputResultType outputResultType = (OutputResultType)theEObject;
				T result = caseOutputResultType(outputResultType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PARAMETER_TYPE: {
				ParameterType parameterType = (ParameterType)theEObject;
				T result = caseParameterType(parameterType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PARA_TYPE: {
				ParaType paraType = (ParaType)theEObject;
				T result = caseParaType(paraType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PHASE_ACTIVITIES: {
				PhaseActivities phaseActivities = (PhaseActivities)theEObject;
				T result = casePhaseActivities(phaseActivities);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PLOT_CONTROL_TYPE: {
				PlotControlType plotControlType = (PlotControlType)theEObject;
				T result = casePlotControlType(plotControlType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PLOT_TYPE: {
				PlotType plotType = (PlotType)theEObject;
				T result = casePlotType(plotType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PORT_BINDING_TYPE: {
				PortBindingType portBindingType = (PortBindingType)theEObject;
				T result = casePortBindingType(portBindingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PRAGMA_TYPE: {
				PragmaType pragmaType = (PragmaType)theEObject;
				T result = casePragmaType(pragmaType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PRECEDENCE_TYPE: {
				PrecedenceType precedenceType = (PrecedenceType)theEObject;
				T result = casePrecedenceType(precedenceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PROCESSOR_BINDING_TYPE: {
				ProcessorBindingType processorBindingType = (ProcessorBindingType)theEObject;
				T result = caseProcessorBindingType(processorBindingType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.PROCESSOR_TYPE: {
				ProcessorType processorType = (ProcessorType)theEObject;
				T result = caseProcessorType(processorType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.REPLY_ACTIVITY_TYPE: {
				ReplyActivityType replyActivityType = (ReplyActivityType)theEObject;
				T result = caseReplyActivityType(replyActivityType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.REPLY_ENTRY_TYPE: {
				ReplyEntryType replyEntryType = (ReplyEntryType)theEObject;
				T result = caseReplyEntryType(replyEntryType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RESULT_CONF95_TYPE: {
				ResultConf95Type resultConf95Type = (ResultConf95Type)theEObject;
				T result = caseResultConf95Type(resultConf95Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RESULT_CONF95_TYPE1: {
				ResultConf95Type1 resultConf95Type1 = (ResultConf95Type1)theEObject;
				T result = caseResultConf95Type1(resultConf95Type1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RESULT_CONF99_TYPE: {
				ResultConf99Type resultConf99Type = (ResultConf99Type)theEObject;
				T result = caseResultConf99Type(resultConf99Type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RESULT_CONF99_TYPE1: {
				ResultConf99Type1 resultConf99Type1 = (ResultConf99Type1)theEObject;
				T result = caseResultConf99Type1(resultConf99Type1);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RESULT_GENERAL_TYPE: {
				ResultGeneralType resultGeneralType = (ResultGeneralType)theEObject;
				T result = caseResultGeneralType(resultGeneralType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.RUN_CONTROL_TYPE: {
				RunControlType runControlType = (RunControlType)theEObject;
				T result = caseRunControlType(runControlType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.SERVICE_TYPE: {
				ServiceType serviceType = (ServiceType)theEObject;
				T result = caseServiceType(serviceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.SINGLE_ACTIVITY_LIST_TYPE: {
				SingleActivityListType singleActivityListType = (SingleActivityListType)theEObject;
				T result = caseSingleActivityListType(singleActivityListType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.SLOT_TYPE: {
				SlotType slotType = (SlotType)theEObject;
				T result = caseSlotType(slotType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.SOLVER_PARAMS_TYPE: {
				SolverParamsType solverParamsType = (SolverParamsType)theEObject;
				T result = caseSolverParamsType(solverParamsType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.SYNCH_CALL_TYPE: {
				SynchCallType synchCallType = (SynchCallType)theEObject;
				T result = caseSynchCallType(synchCallType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.TASK_ACTIVITY_GRAPH: {
				TaskActivityGraph taskActivityGraph = (TaskActivityGraph)theEObject;
				T result = caseTaskActivityGraph(taskActivityGraph);
				if (result == null) result = caseActivityGraphBase(taskActivityGraph);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case LqnCorePackage.TASK_TYPE: {
				TaskType taskType = (TaskType)theEObject;
				T result = caseTaskType(taskType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Def Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Def Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityDefBase(ActivityDefBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Def Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Def Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityDefType(ActivityDefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Graph Base</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Graph Base</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityGraphBase(ActivityGraphBase object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityListType(ActivityListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Loop List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Loop List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityLoopListType(ActivityLoopListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Loop Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Loop Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityLoopType(ActivityLoopType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Making Call Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Making Call Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityMakingCallType(ActivityMakingCallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Or Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Or Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityOrType(ActivityOrType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Phases Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Phases Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityPhasesType(ActivityPhasesType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Activity Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Activity Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActivityType(ActivityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Join List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Join List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndJoinListType(AndJoinListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Asynch Call Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Asynch Call Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAsynchCallType(AsynchCallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bind Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bind Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBindType(BindType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Call List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Call List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCallListType(CallListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Document Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDocumentRoot(DocumentRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Activity Def Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Activity Def Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryActivityDefType(EntryActivityDefType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Activity Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Activity Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryActivityGraph(EntryActivityGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Making Call Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Making Call Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryMakingCallType(EntryMakingCallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryType(EntryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>First Plot Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>First Plot Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFirstPlotType(FirstPlotType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Histogram Bin Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Histogram Bin Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistogramBinType(HistogramBinType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>In Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>In Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInPortType(InPortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceType(InterfaceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLqnCoreType(LqnCoreType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lqn Model Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lqn Model Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLqnModelType(LqnModelType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Making Call Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Making Call Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMakingCallType(MakingCallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrListType(OrListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Out Port Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Out Port Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutPortType(OutPortType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Distribution Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Distribution Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputDistributionType(OutputDistributionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Entry Distribution Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Entry Distribution Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputEntryDistributionType(OutputEntryDistributionType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Result Forwarding AND Join Delay</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Result Forwarding AND Join Delay</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputResultForwardingANDJoinDelay(OutputResultForwardingANDJoinDelay object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Output Result Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Output Result Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOutputResultType(OutputResultType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterType(ParameterType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Para Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Para Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParaType(ParaType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Phase Activities</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Phase Activities</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePhaseActivities(PhaseActivities object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plot Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plot Control Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlotControlType(PlotControlType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Plot Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Plot Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlotType(PlotType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Port Binding Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Port Binding Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePortBindingType(PortBindingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Pragma Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Pragma Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePragmaType(PragmaType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Precedence Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Precedence Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePrecedenceType(PrecedenceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Binding Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Binding Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorBindingType(ProcessorBindingType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Processor Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProcessorType(ProcessorType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reply Activity Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reply Activity Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplyActivityType(ReplyActivityType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reply Entry Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reply Entry Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplyEntryType(ReplyEntryType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Conf95 Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Conf95 Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultConf95Type(ResultConf95Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Conf95 Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Conf95 Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultConf95Type1(ResultConf95Type1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Conf99 Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Conf99 Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultConf99Type(ResultConf99Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result Conf99 Type1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result Conf99 Type1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultConf99Type1(ResultConf99Type1 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Result General Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Result General Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResultGeneralType(ResultGeneralType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Run Control Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Run Control Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRunControlType(RunControlType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Service Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Service Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServiceType(ServiceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Single Activity List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Single Activity List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSingleActivityListType(SingleActivityListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Slot Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Slot Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSlotType(SlotType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Solver Params Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Solver Params Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSolverParamsType(SolverParamsType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Synch Call Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Synch Call Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSynchCallType(SynchCallType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Activity Graph</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Activity Graph</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskActivityGraph(TaskActivityGraph object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Task Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTaskType(TaskType object) {
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

} //LqnCoreSwitch

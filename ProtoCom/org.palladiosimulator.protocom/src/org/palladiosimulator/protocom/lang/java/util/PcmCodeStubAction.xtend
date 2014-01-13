package org.palladiosimulator.protocom.lang.java.util

import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.LoopAction
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
import de.uka.ipd.sdq.pcm.seff.SetVariableAction
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop

/**
 * Defines templates for actions of both kinds: SEFF actions and user actions.
 * 
 * TODO: Remove programming language and technology-depend source from this class
 * and use template methods instead. Also move it to .lang then.
 * 
 * @author Sebastian Lehrig
 */
class PcmCodeStubAction extends PcmAction {

	/**
	 * No idea. We didn't implement this for the last ProtoCom either.
	 * FIXME Implement this as it is a crucial part of the bahavior (lehrig)
	 */
	dispatch override String action(CollectionIteratorAction action) {
		'''
			'''
	}

	/**
	 * LoopAction is transformed into a simple FOR statement.
	 */
	dispatch override String action(LoopAction action) {
		'''
			// TODO Configure maxIterationCount 
			int maxIterationCount«JavaNames::javaVariableName(action.id)» = 1;
			
			for (int iterationCount«JavaNames::javaVariableName(action.id)» = 0; iterationCount«JavaNames::
				javaVariableName(action.id)» < maxIterationCount«JavaNames::javaVariableName(action.id)»; iterationCount«JavaNames::
				javaVariableName(action.id)» ++) {
				«actions(action.bodyBehaviour_Loop.steps_Behaviour.findStart)»
			}
		'''
	}

	/**
	 * ExternalCallAction calls a remote service.
	 * 
	 * TODO: Move exception handling to RMI tech.
	 */
	dispatch override String action(ExternalCallAction action) {
		'''
			{
				try {
					// TODO Initialize parameters
					«PcmCommons::callStub(action.calledService_ExternalService, action.calledService_ExternalService,
				"myContext.getRole" + JavaNames::javaName(action.role_ExternalService) + "().",
				action.inputVariableUsages__CallAction, action.returnVariableUsage__CallReturnAction)»
				} catch (java.rmi.RemoteException e) {
					// TODO: add logging
					
				} finally {
					ctx.getStack().removeStackFrame();
				}
						
			}
		'''
	}

	/**
	 * Currently, InteralActions are removed for stubs.
	 */
	dispatch override String action(InternalAction action) {
		'''
			'''
	}

	/**
	 * BranchAction is implemented as an IF condition. A BranchAction may have two different transition types:
	 * ProbabilisticBranchTransition and GuardedBranchTransition. For code stubs, they are both treated as a
	 * normal if-else-if-else series. 
	 */
	dispatch override String action(BranchAction action) {
		'''
			// TODO Set condition.
			Boolean condition = true;
			«FOR branch : action.branches_Branch SEPARATOR " else "»
				«branchTransition(action, branch)»
			«ENDFOR»
		'''
	}

	/**
	 * Branch transition for ProbabilisticBranchTransition entities. Handled like GuardedBranchTransition for code stubs.
	 */
	dispatch override branchTransition(BranchAction action, ProbabilisticBranchTransition transition) {
		'''
			if (condition) {
				«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
			}
		'''
	}

	/**
	 * Branch transition for GuardedBranchTransition.
	 */
	dispatch override branchTransition(BranchAction action, GuardedBranchTransition transition) {
		'''
			if (condition) {
				«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
			}
		'''
	}

	/**
	 * TODO Check whether SetVariableAction is needed.
	 */
	dispatch override String action(SetVariableAction action) {
	}

	/**
	 * A ForkAction spawns a new thread for each defined behavior. These should be processed asynchronously in parallel.
	 * Please note that manually spawning new threads is discouraged on certain middlewares (like JavaEE)!
	 * 
	 * TODO Check whether ForkAction is needed.
	 */
	dispatch override String action(ForkAction action) {
		'''
			'''
	}

	/**
	 * EntryLevelSystemCall is an user action which calls a system service from an usage scenario.
	 */
	dispatch override String userAction(EntryLevelSystemCall userAction) {
		'''
			try {
				// EntryLevelSystemCall!
				«PcmCommons::call(
				userAction.operationSignature__EntryLevelSystemCall,
				null,
				JavaNames::portMemberVar(userAction.providedRole_EntryLevelSystemCall) + ".",
				userAction.inputParameterUsages_EntryLevelSystemCall,
				null
			)»
											
			} catch (java.rmi.RemoteException e) {
				// TODO: Logger!
				
			}
		'''
	}

	/**
	 * Loop actions are transformed into a simple FOR statement.
	 */
	dispatch override String userAction(Loop userAction) {
		'''
			// TODO Configure maxIterationCount 
			int maxIterationCount«JavaNames::javaVariableName(userAction.id)» = 1;
			
			for (int iterationCount_«JavaNames::javaVariableName(userAction.id)» = 0; 
				iterationCount_«JavaNames::javaVariableName(userAction.id)» < maxIterationCount_«JavaNames::
				javaVariableName(userAction.id)»; iterationCount_«JavaNames::javaVariableName(userAction.id)» ++) {
				«userActions(userAction.bodyBehaviour_Loop.actions_ScenarioBehaviour.findUserStart)»
			} 
		'''
	}

	/**
	 * UserActions only have probabilistic transitions. That might even make sense for test generation 
	 * for code stubs. Therefore, This might be added here.
	 * 
	 * TODO Branch user actions are currently not generated with code stubs. AS probabilities make sense here the ctx object might be useful. In any case, for test generation, user actions should be included in future.
	 */
	dispatch override String userAction(Branch userAction) {
		'''
			double u«JavaNames::javaVariableName(userAction.id)» = ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
			double sum«JavaNames::javaVariableName(userAction.id)» = 0;
			
			«FOR transition : userAction.branchTransitions_Branch»
				if (sum«JavaNames::javaVariableName(userAction.id)» <= u«JavaNames::javaVariableName(userAction.id)» && u«JavaNames::
				javaVariableName(userAction.id)» < sum«JavaNames::javaVariableName(userAction.id)» + «transition.
				branchProbability») {
					«userActions(transition.branchedBehaviour_BranchTransition.actions_ScenarioBehaviour.findUserStart)»
				}	
				sum«JavaNames::javaVariableName(userAction.id)» += «transition.branchProbability»;	
			«ENDFOR»
		'''
	}
}

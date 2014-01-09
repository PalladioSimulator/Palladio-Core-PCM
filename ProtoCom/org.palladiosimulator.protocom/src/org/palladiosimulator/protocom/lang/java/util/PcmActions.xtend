package org.palladiosimulator.protocom.lang.java.util

import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
import de.uka.ipd.sdq.pcm.seff.LoopAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.AcquireAction
import de.uka.ipd.sdq.pcm.seff.ReleaseAction
import de.uka.ipd.sdq.pcm.seff.SetVariableAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.usagemodel.Start
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.Delay

/**
 * Defines templates for actions of both kinds: SEFF actions and user actions.
 * 
 * TODO: Remove programming language and technology-depend source from this class
 * and use template methods instead. Also move it to .lang then.
 * 
 * @author Thomas Zolynski
 */
class PcmActions {
	/**
	 * Follows the action path and calls "action" for each action in it.
	 * Note that actions do not branch! Branching is solved by a BranchAction, therefore 
	 * at most one successor is given at any time.
	 */
	static def String actions(AbstractAction action) {
		'''		
		/*
		 * «action.class.simpleName» («action»)
		 */
		«action.action»

		«IF (!StopAction.isInstance(action))»
			«actions(action.successor_AbstractAction)»
		«ENDIF»
		'''
	}

	/**
	 * StartAction. Should be empty, I guess.
	 */
	static dispatch def String action(StartAction action) {
		'''
		'''
	}

	/**
	 * StopAction. Nothing to see here either.
	 */
	static dispatch def String action(StopAction action) {
		'''
		'''
	}

	/**
	 * No idea. We didn't implement this for the last ProtoCom either.
	 */
	static dispatch def String action(CollectionIteratorAction action) {
		'''
		'''
	}

	/**
	 * LoopAction is transformed into a simple FOR statement.
	 */
	static dispatch def String action(LoopAction action) {
		'''
		int maxIterationCount«JavaNames::javaVariableName(action.id)» = ctx.evaluate("«JavaNames::specificationString(action.iterationCount_LoopAction.specification)»", Integer.class);
		
		for (int iterationCount«JavaNames::javaVariableName(action.id)» = 0; iterationCount«JavaNames::javaVariableName(action.id)» < maxIterationCount«JavaNames::javaVariableName(action.id)»; iterationCount«JavaNames::javaVariableName(action.id)» ++) {
			«actions(action.bodyBehaviour_Loop.steps_Behaviour.findStart)»
		}
		'''
	}

	/**
	 * ExternalCallAction calls a remote service.
	 * 
	 * TODO: Move exception handling to RMI tech.
	 * TODO? Extract stackframe implementation.
	 */
	static dispatch def String action(ExternalCallAction action) {
		'''
		{
			try {
				// Start Simulate an external call
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
				// prepare stackframe
				de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
						
				«PcmCommons::call(action.calledService_ExternalService, action.calledService_ExternalService, 
					"myContext.getRole"+JavaNames::javaName(action.role_ExternalService)+"().",
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
	 * InteralAction uses a load generator to simulate CPU/HDD usage.
	 * Note that ProtoCom does NOT use InfrastructureCalls from the PCM model, since these 
	 * should be reflected by the underlying middleware and OS!
	 */
	static dispatch def String action(InternalAction action) {
		'''
		«FOR resourceDemand : action.resourceDemand_Action»
			{
				double demand = ctx.evaluate("«JavaNames::specificationString(resourceDemand.specification_ParametericResourceDemand.specification)»", Double.class);
				
				«IF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase.matches("cpu")»
					org.palladiosimulator.protocom.framework.strategies.DemandConsumerStrategiesRegistry.singleton().getStrategyFor(org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum.CPU).consume(demand);
				«ELSEIF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase.matches("hdd")»
					org.palladiosimulator.protocom.framework.strategies.DemandConsumerStrategiesRegistry.singleton().getStrategyFor(org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum.HDD).consume(demand);
				«ELSEIF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase().matches("delay")»
					org.palladiosimulator.protocom.framework.AbstractResourceEnvironment.performDelay(demand);
				«ELSE»
					throw new java.lang.UnsupportedOperationException("Resourcetype not yet supported in prototype");
				«ENDIF»
			}
		«ENDFOR»
		'''
	}

	/**
	 * BranchAction is implemented as an IF condition. A BranchAction may have two different transition types:
	 * ProbabilisticBranchTransition and GuardedBranchTransition.
	 */
	static dispatch def String action(BranchAction action) {
		'''
		«IF ProbabilisticBranchTransition.isInstance(action.branches_Branch.get(0))»
			double u«JavaNames::javaVariableName(action.id)» = (Double) ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
			double sum«JavaNames::javaVariableName(action.id)» = 0;
			
			«FOR branch : action.branches_Branch»
				«branchTransition(action, branch)»
			«ENDFOR»
		«ELSE»
			«FOR branch : action.branches_Branch SEPARATOR " else "»
				«branchTransition(action, branch)»
			«ENDFOR»
		«ENDIF»
		'''
	}
	
	/**
	 * Branch transition for ProbabilisticBranchTransition entities.
	 */
	def dispatch static branchTransition(BranchAction action, ProbabilisticBranchTransition transition) {
		'''
		if (sum«JavaNames::javaVariableName(action.id)» <= u«JavaNames::javaVariableName(action.id)» && u«JavaNames::javaVariableName(action.id)» < sum«JavaNames::javaVariableName(action.id)» + «transition.branchProbability») {
			«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
		}
		'''
	}
	
	/**
	 * Branch transition for GuardedBranchTransition.
	 */
	def dispatch static branchTransition(BranchAction action, GuardedBranchTransition transition) {
		'''
		if (ctx.evaluate("«JavaNames::specificationString(transition.branchCondition_GuardedBranchTransition.specification)»", Boolean.class) == true) {
			«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
		}
		'''
	}

	/**
	 * AcquireAction is mapped to the acquire method of Java Collection's semaphore implementation.
	 */
	static dispatch def String action(AcquireAction action) {
		'''
		try {
			//logger.debug("Acquiring passive resource «JavaNames::javaString(action.passiveresource_AcquireAction.entityName)»");
			passive_resource_«JavaNames::javaVariableName(action.passiveresource_AcquireAction.entityName)».acquire();
		} catch (InterruptedException e) {
			//logger.error("Should never happen: Acquire of semaphore «JavaNames::javaString(action.passiveresource_AcquireAction.entityName)» interrupted");
			java.lang.System.exit(-1);
		}
		'''
	}

	/**
	 * ReleaseAction is mapped to the release method of Java Collection's semaphore implementation.
	 */
	static dispatch def String action(ReleaseAction action) {
		'''
		// Release «action.passiveResource_ReleaseAction»
		//logger.debug("Releasing passive resource «JavaNames::javaString(action.passiveResource_ReleaseAction.entityName)»");
		passive_resource_«JavaNames::javaVariableName(action.passiveResource_ReleaseAction.entityName)».release();
		'''
	}

	static dispatch def String action(SetVariableAction action) {
	}

	/**
	 * A ForkAction spawns a new thread for each defined behavior. These should be processed asynchronously in parallel.
	 * Please note that manually spawning new threads is discouraged on certain middlewares (like JavaEE)!
	 */
	static dispatch def String action(ForkAction action) {
		'''
		'''		
	}
	
	
	/**
	 * Follows the user action path and calls "userAction" for each action in it.
	 * Note that actions do not branch! Branching is solved by a Branch action, therefore 
	 * at most one successor is given at any time.
	 */
	static def String userActions(AbstractUserAction userAction) {
		'''
		/*
		 * «userAction.class.simpleName» («userAction»)
		 */
		«userAction(userAction)»
		
		«IF !Stop.isInstance(userAction)»
			«userActions(userAction.successor)»
		«ENDIF»
		'''
	}
	
	/**
	 * EntryLevelSystemCall is an user action which calls a system service from an usage scenario.
	 */
	static dispatch def String userAction(EntryLevelSystemCall userAction) {
		'''
		try {
			ctx.getStack().createAndPushNewStackFrame();
			
			// EntryLevelSystemCall!
			«PcmCommons::call(	userAction.operationSignature__EntryLevelSystemCall,  
								null,  
								JavaNames::portMemberVar(userAction.providedRole_EntryLevelSystemCall)  + ".",
								userAction.inputParameterUsages_EntryLevelSystemCall, 
								null
							)»
										
		} catch (java.rmi.RemoteException e) {
			// TODO: Logger!
			
		} finally {
			ctx.getStack().removeStackFrame();		
		}
		'''
	}
	
	static dispatch def String userAction(Delay userAction) {
		''''''
	}
	
	static dispatch def String userAction(Start userAction) {
		'''
		ctx.getStack().createAndPushNewStackFrame();
		'''
	}
	
	static dispatch def String userAction(Stop userAction) {
		'''
		ctx.getStack().removeStackFrame();
		'''
	}
	
	/**
	 * Loop actions are transformed into a simple FOR statement.
	 */
	static dispatch def String userAction(Loop userAction) {
		'''
		for (int iterationCount_«JavaNames::javaVariableName(userAction.id)» = 0, maxIterationCount_«JavaNames::javaVariableName(userAction.id)» = ctx.evaluate("«JavaNames::specificationString(userAction.loopIteration_Loop.specification)»", Integer.class); 
			iterationCount_«JavaNames::javaVariableName(userAction.id)» < maxIterationCount_«JavaNames::javaVariableName(userAction.id)»; iterationCount_«JavaNames::javaVariableName(userAction.id)» ++) {
			«userActions(userAction.bodyBehaviour_Loop.actions_ScenarioBehaviour.findUserStart)»
		} 
		'''
	}
	
	/**
	 * UserActions only have probabilistic transitions.
	 */
	static dispatch def String userAction(Branch userAction) {
		'''
		double u«JavaNames::javaVariableName(userAction.id)» = ctx.evaluate("DoublePDF[(1;1.0)]", Double.class);
		double sum«JavaNames::javaVariableName(userAction.id)» = 0;
		
		«FOR transition : userAction.branchTransitions_Branch»
			if (sum«JavaNames::javaVariableName(userAction.id)» <= u«JavaNames::javaVariableName(userAction.id)» && u«JavaNames::javaVariableName(userAction.id)» < sum«JavaNames::javaVariableName(userAction.id)» + «transition.branchProbability») {
				«userActions(transition.branchedBehaviour_BranchTransition.actions_ScenarioBehaviour.findUserStart)»
			}	
			sum«JavaNames::javaVariableName(userAction.id)» += «transition.branchProbability»;	
		«ENDFOR»
		'''
	}	

	/**
	 * Helper method to find the first StartAction in a list of actions.
	 */
	static def StartAction findStart(Iterable<AbstractAction> actions) {
		actions.findFirst[StartAction.isInstance(it)] as StartAction
	}
	
	/**
	 * And another helper method, since Actions and UserActions are *obviously* so
	 * different that they cannot have a common supertype...
	 */
	static def Start findUserStart(Iterable<AbstractUserAction> actions) {
		actions.findFirst[Start.isInstance(it)] as Start
	}
}

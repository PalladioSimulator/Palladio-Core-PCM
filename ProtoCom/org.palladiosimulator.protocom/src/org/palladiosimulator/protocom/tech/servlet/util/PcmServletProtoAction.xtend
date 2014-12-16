package org.palladiosimulator.protocom.tech.servlet.util

import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.LoopAction
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition
import de.uka.ipd.sdq.pcm.seff.SetVariableAction
import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.lang.java.util.PcmCommons
import de.uka.ipd.sdq.pcm.seff.ReleaseAction
import de.uka.ipd.sdq.pcm.seff.AcquireAction

/**
 * FIXME: Copied from PcmProtoAction and PcmAction. Only temporary.
 */
class PcmServletProtoAction {
	protected val frameworkBase = "org.palladiosimulator.protocom.framework.java.ee"
	
	def String actions(AbstractAction action) {
		'''		
		/*
		 * «action.class.simpleName» («action»)
		 */
		«action(action)»

		«IF (!StopAction.isInstance(action))»
			«actions(action.successor_AbstractAction)»
		«ENDIF»
		'''
	}
	
	/**
	 * ExternalCallAction calls a remote service.
	 * 
	 * TODO: Move exception handling to RMI tech.
	 */
	dispatch def String action(ExternalCallAction action) {
		'''
		{
			try {
				// Start Simulate an external call
				// de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();
				// prepare stackframe
				// de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();
				ctx.getStack().createAndPushNewStackFrame();
				
				«PcmCommons::call(action.calledService_ExternalService, action.calledService_ExternalService, 
					"context.getPortFor" + JavaNames::javaName(action.role_ExternalService)+"().",
					action.inputVariableUsages__CallAction, action.returnVariableUsage__CallReturnAction)»
			} catch (java.lang.Exception e) {
				// TODO: add logging
				
			} finally {
				ctx.getStack().removeStackFrame();
			}
		}
		'''
	}
	
	
	//
	
	/**
	 * StartAction. Should be empty, I guess.
	 */
	dispatch def String action(StartAction action) {
		'''
		'''
	}

	/**
	 * StopAction. Nothing to see here either.
	 */
	dispatch def String action(StopAction action) {
		'''
		'''
	}
	
	/**
	 * No idea. We didn't implement this for the last ProtoCom either.
	 * FIXME Implement this as it is a crucial part of the bahavior (lehrig)
	 */
	dispatch def String action(CollectionIteratorAction action) {
		'''
		'''
	}

	/**
	 * LoopAction is transformed into a simple FOR statement.
	 */
	dispatch def String action(LoopAction action) {
		'''
		int maxIterationCount«JavaNames::javaVariableName(action.id)» = ctx.evaluate("«JavaNames::specificationString(action.iterationCount_LoopAction.specification)»", Integer.class);
		
		for (int iterationCount«JavaNames::javaVariableName(action.id)» = 0; iterationCount«JavaNames::javaVariableName(action.id)» < maxIterationCount«JavaNames::javaVariableName(action.id)»; iterationCount«JavaNames::javaVariableName(action.id)» ++) {
			«actions(action.bodyBehaviour_Loop.steps_Behaviour.findStart)»
		}
		'''
	}

	/**
	 * InteralAction uses a load generator to simulate CPU/HDD usage.
	 * Note that ProtoCom does NOT use InfrastructureCalls from the PCM model, because these 
	 * should be reflected by the underlying middleware and OS!
	 */
	dispatch def String action(InternalAction action) {
		'''
		«FOR resourceDemand : action.resourceDemand_Action»
			{
				double demand = ctx.evaluate("«JavaNames::specificationString(resourceDemand.specification_ParametericResourceDemand.specification)»", Double.class);
				
				«IF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase.matches("cpu")»
					«frameworkBase».prototype.StrategiesRegistry.getInstance().getStrategy(org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ResourceTypeEnum.CPU).consume(demand);
				«ELSEIF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase.matches("hdd")»
					«frameworkBase».prototype.StrategiesRegistry.getInstance().getStrategy(org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ResourceTypeEnum.HDD).consume(demand);
				«ELSEIF resourceDemand.requiredResource_ParametricResourceDemand.entityName.toLowerCase().matches("delay")»
					// org.palladiosimulator.protocom.framework.AbstractResourceEnvironment.performDelay(demand);
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
	dispatch def String action(BranchAction action) {
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
	dispatch def branchTransition(BranchAction action, ProbabilisticBranchTransition transition) {
		'''
		if (sum«JavaNames::javaVariableName(action.id)» <= u«JavaNames::javaVariableName(action.id)» && u«JavaNames::javaVariableName(action.id)» < sum«JavaNames::javaVariableName(action.id)» + «transition.branchProbability») {
			«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
		}
		'''
	}
	
	/**
	 * Branch transition for GuardedBranchTransition.
	 */
	dispatch def branchTransition(BranchAction action, GuardedBranchTransition transition) {
		'''
		if (ctx.evaluate("«JavaNames::specificationString(transition.branchCondition_GuardedBranchTransition.specification)»", Boolean.class) == true) {
			«actions(transition.branchBehaviour_BranchTransition.steps_Behaviour.findStart)»
		}
		'''
	}

	/**
	 * TODO Check whether SetVariableAction is needed.
	 */
	dispatch def String action(SetVariableAction action) {
	}

	/**
	 * A ForkAction spawns a new thread for each defined behavior. These should be processed asynchronously in parallel.
	 * Please note that manually spawning new threads is discouraged on certain middlewares (like JavaEE)!
	 * 
	 * TODO Check whether ForkAction is needed.
	 */
	dispatch def String action(ForkAction action) {
		'''
		'''		
	}
	
	/**
	 * AcquireAction is mapped to the acquire method of Java Collection's semaphore implementation.
	 */
	dispatch def String action(AcquireAction action) {
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
	dispatch def String action(ReleaseAction action) {
		'''
		// Release «action.passiveResource_ReleaseAction»
		//logger.debug("Releasing passive resource «JavaNames::javaString(action.passiveResource_ReleaseAction.entityName)»");
		passive_resource_«JavaNames::javaVariableName(action.passiveResource_ReleaseAction.entityName)».release();
		'''
	}
	
	/**
	 * Helper method to find the first StartAction in a list of actions.
	 */
	static def StartAction findStart(Iterable<AbstractAction> actions) {
		actions.findFirst[StartAction.isInstance(it)] as StartAction
	}
}

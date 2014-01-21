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
import de.uka.ipd.sdq.pcm.seff.EmitEventAction

/**
 * Abstract class for implementing PCM actions, i.e., the behavior of components as specified
 * via SEFFs. Refinements of this class could, for instance, add simulate stack frames for performance
 * prototypes or provide code stub generation.
 * 
 * @author Sebastian Lehrig
 */
abstract class PcmAction {
	/**
	 * Follows the action path and calls "action" for each action in it.
	 * Note that actions do not branch! Branching is solved by a BranchAction, therefore 
	 * at most one successor is given at any time.
	 */
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
		'''
	}

	/**
	 * ExternalCallAction calls a remote service.
	 *
	 */
	dispatch def String action(ExternalCallAction action) {
		'''
		'''
	}

	/**
	 * InteralAction uses a load generator to simulate CPU/HDD usage.
	 * Note that ProtoCom does NOT use InfrastructureCalls from the PCM model, because these 
	 * should be reflected by the underlying middleware and OS!
	 */
	dispatch def String action(InternalAction action) {
		'''
		'''
	}

	/**
	 * BranchAction is implemented as an IF condition. A BranchAction may have two different transition types:
	 * ProbabilisticBranchTransition and GuardedBranchTransition.
	 */
	dispatch def String action(BranchAction action) {
		'''
		'''
	}
	
	
	
	/**
	 * Branch transition for ProbabilisticBranchTransition entities.
	 */
	dispatch def branchTransition(BranchAction action, ProbabilisticBranchTransition transition) {
		'''
		'''
	}
	
	/**
	 * Branch transition for GuardedBranchTransition.
	 */
	dispatch def branchTransition(BranchAction action, GuardedBranchTransition transition) {
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

	dispatch def String action(SetVariableAction action) {
	}

	/**
	 * A ForkAction spawns a new thread for each defined behavior. These should be processed asynchronously in parallel.
	 * Please note that manually spawning new threads is discouraged on certain middlewares (like JavaEE)!
	 */
	dispatch def String action(ForkAction action) {
		'''
		'''		
	}
	
	/**
	 * TODO Think about EmitEventAction. JMS?
	 */
	dispatch def String action(EmitEventAction action) {
		'''
		// FIXME: Add EmitEventAction.
		'''
	}
	
	/**
	 * Follows the user action path and calls "userAction" for each action in it.
	 * Note that actions do not branch! Branching is solved by a Branch action, therefore 
	 * at most one successor is given at any time.
	 */
	def String userActions(AbstractUserAction userAction) {
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
	dispatch def String userAction(EntryLevelSystemCall userAction) {
		'''
		'''
	}
	
	/**
	 * FIXME Implement and test this action with Thread.sleep
	 */
	dispatch def String userAction(Delay userAction) {
		''''''
	}
	
	dispatch def String userAction(Start userAction) {
		'''
		'''
	}
	
	dispatch def String userAction(Stop userAction) {
		'''
		'''
	}
	
	/**
	 * Loop actions are transformed into a simple FOR statement.
	 */
	dispatch def String userAction(Loop userAction) {
		'''
		'''
	}
	
	/**
	 * UserActions only have probabilistic transitions.
	 */
	dispatch def String userAction(Branch userAction) {
		'''
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
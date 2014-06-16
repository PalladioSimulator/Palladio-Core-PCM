package org.palladiosimulator.protocom.lang.java.util

import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector
import de.uka.ipd.sdq.pcm.core.composition.DelegationConnector
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.RequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.SinkRole

/**
 * Templates for external (service) calls.
 * Converted from PCM's OCL statements.
 * 
 * @author Thomas Zolynski
 */
class PcmCalls {
	
	/*
	 * Query System Calls.
	 */
	
	static def Iterable<EntryLevelSystemCall> querySystemCalls(ScenarioBehaviour scenBe) {
		val results = newLinkedList
	
		results += scenBe.actions_ScenarioBehaviour.filter[EntryLevelSystemCall.isInstance(it)].map[it as EntryLevelSystemCall]
		results += scenBe.querySystemCallsInLoops
		results += scenBe.querySystemCallsInBraches
		
  		results.toSet
  	}
	
	static def Iterable<EntryLevelSystemCall> querySystemCallsInLoops(ScenarioBehaviour sb) {
		// scenBe.actions_ScenarioBehaviour.typeSelect(Loop).collect(l|querySystemCalls(l.bodyBehaviour_Loop)).flatten();
		sb.actions_ScenarioBehaviour.filter[Loop.isInstance(it)].map[it as Loop].map[it.bodyBehaviour_Loop.querySystemCalls].flatten
	}

	
	static def Iterable<EntryLevelSystemCall> querySystemCallsInBraches(ScenarioBehaviour scenBe) {
		// scenBe.actions_ScenarioBehaviour.typeSelect(Branch).collect(b|b.branchTransitions_Branch.branchedBehaviour_BranchTransition.querySystemCalls()).flatten();
		scenBe.actions_ScenarioBehaviour.filter[Branch.isInstance(it)].map[it as Branch].map[it.branchTransitions_Branch].flatten.map[it.branchedBehaviour_BranchTransition.querySystemCalls].flatten
	}
	
	static def Iterable<System> getSystemsFromCalls(Iterable<EntryLevelSystemCall> calls) {
		calls.map[providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole].map[it as System].toSet    //  collect(c|(System)c.providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole).toSet();
	}
	
	
	/*
	 * Query Ports. 
	 */
	 
	static def portQuery(OperationRequiredRole role, ComposedStructure s, AssemblyContext ctx) {
		if (hasConnector(s, ctx, role)) {
			val connector = getConnector(s, ctx, role) as AssemblyConnector
			
//			if (System.isInstance(s)) {
//				'''my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)».getComponent().«JavaNames::portGetter(connector.providedRole_AssemblyConnector)»()'''
//				'''(«JavaNames::fqn(role.requiredInterface__OperationRequiredRole)») my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)»'''
//			} else {
//				'''my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)».«JavaNames::portGetter(connector.providedRole_AssemblyConnector)»()'''
				'''(«JavaNames::fqn(role.requiredInterface__OperationRequiredRole)») my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)»'''
//			}
		}
	}
		
//	static dispatch def portQuery(OperationProvidedRole role, ComposedStructure s, AssemblyContext ctx) {
//		if (hasConnector(s, ctx, role)) {
//			val connector = getConnector(s, ctx, role) as AssemblyConnector
//			
//			if (System.isInstance(s)) {
////				'''my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)».getComponent().«JavaNames::portGetter(connector.providedRole_AssemblyConnector)»()'''
//				'''(«JavaNames::fqn(role.requiredInterface__OperationRequiredRole)») my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)»'''
//			} else {
////				'''my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)».«JavaNames::portGetter(connector.providedRole_AssemblyConnector)»()'''
//				'''(«JavaNames::fqn(role.requiredInterface__OperationRequiredRole)») my«JavaNames::javaName(connector.providingAssemblyContext_AssemblyConnector)»'''
//			}
//		}	
//	}
		
		
	/*
	 * Connectors.
	 */
	
	static def getConnector(ComposedStructure cs, AssemblyContext context, OperationRequiredRole role) {
  		 connectors(cs).filter[con | test(con, context, role)].get(0)
  		 
//     connectors(s).select(con|test(con,ctx,r)).get(0);
	}
	
	static def hasConnector(ComposedStructure cs, AssemblyContext context, OperationRequiredRole role) {
		// TODO: guess what?
		true
	}
	
	static def connectors(ComposedStructure s) {
   		s.connectors__ComposedStructure.filter[!DelegationConnector.isInstance(it)]
	}

	static dispatch def boolean test(AssemblyConnector c, AssemblyContext ctx, RequiredRole r) {
		c.requiredRole_AssemblyConnector.id == r.id && c.requiringAssemblyContext_AssemblyConnector.id == ctx.id;
	}
	
	static dispatch def boolean test(AssemblyInfrastructureConnector c, AssemblyContext ctx, InfrastructureRequiredRole r) {
		c.requiredRole__AssemblyInfrastructureConnector.id == r.id && c.requiringAssemblyContext__AssemblyInfrastructureConnector.id == ctx.id;
	}

	static dispatch def boolean test(AssemblyInfrastructureConnector c, AssemblyContext ctx, OperationRequiredRole r) {
		c.requiredRole__AssemblyInfrastructureConnector.id == r.id && c.requiringAssemblyContext__AssemblyInfrastructureConnector.id == ctx.id;
	}

	static dispatch def boolean test(AssemblyEventConnector c, AssemblyContext ctx, SinkRole r) {
		c.sinkRole__AssemblyEventConnector.id == r && c.sourceAssemblyContext__AssemblyEventConnector.id == ctx.id;
	}
	
	static dispatch def boolean test(DelegationConnector c, AssemblyContext ctx, SinkRole r) {
		false
	}	
	
}
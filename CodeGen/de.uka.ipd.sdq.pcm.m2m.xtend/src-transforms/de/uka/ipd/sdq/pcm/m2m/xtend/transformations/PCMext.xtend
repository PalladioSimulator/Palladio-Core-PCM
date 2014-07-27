package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.core.composition.AssemblyEventConnector
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.composition.Connector
import de.uka.ipd.sdq.pcm.core.composition.DelegationConnector
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector
import de.uka.ipd.sdq.pcm.core.composition.RequiredDelegationConnector
import de.uka.ipd.sdq.pcm.core.entity.Entity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.parameter.VariableUsage
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.repository.RequiredRole
import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.repository.SinkRole
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition
import de.uka.ipd.sdq.pcm.seff.AbstractLoopAction
import de.uka.ipd.sdq.pcm.seff.BranchAction
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.ForkAction
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour
import de.uka.ipd.sdq.pcm.seff.InternalAction
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF
import de.uka.ipd.sdq.pcm.seff.StartAction
import de.uka.ipd.sdq.pcm.seff.StopAction
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint
import de.uka.ipd.sdq.pcm.subsystem.SubSystem
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.transformations.Helper
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction
import de.uka.ipd.sdq.pcm.usagemodel.Branch
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall
import de.uka.ipd.sdq.pcm.usagemodel.Loop
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour
import de.uka.ipd.sdq.pcm.usagemodel.Stop
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import de.uka.ipd.sdq.stoex.AbstractNamedReference
import de.uka.ipd.sdq.stoex.NamespaceReference
import de.uka.ipd.sdq.stoex.VariableReference
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn
import java.util.ArrayList
import java.util.Collection
import java.util.HashSet
import java.util.List
import java.util.Set
import org.eclipse.emf.ecore.EObject

@ModelIn(#[
	"pcm.completions.Completion",
	"pcm.core.composition.*",
	"pcm.core.entity.Entity",
	"pcm.core.entity.InterfaceProvidingEntity",
	"pcm.core.entity.InterfaceProvidingRequiringEntity",
	"pcm.parameter.VariableUsage",
	"pcm.repository.BasicComponent",
	"pcm.repository.CompositeComponent",
	"pcm.repository.InfrastructureProvidedRole",
	"pcm.repository.InfrastructureRequiredRole",
	"pcm.repository.OperationProvidedRole",
	"pcm.repository.OperationRequiredRole",
	"pcm.repository.ProvidedRole",
	"pcm.repository.RepositoryComponent",
	"pcm.repository.RequiredRole",
	"pcm.repository.Signature",
	"pcm.repository.SinkRole",
	"pcm.seff.AbstractAction",
	"pcm.seff.StopAction",
	"pcm.seff.AbstractBranchTransition",
	"pcm.seff.AbstractLoopAction",
	"pcm.seff.BranchAction",
	"pcm.seff.ExternalCallAction",
	"pcm.seff.ForkAction",
	"pcm.seff.ForkedBehaviour",
	"pcm.seff.InternalAction",
	"pcm.seff.ResourceDemandingSEFF",
	"pcm.seff.StartAction",
	"pcm.seff.SynchronisationPoint",
	"pcm.subsystem.SubSystem",
	"pcm.system.System",
	"pcm.usagemodel.AbstractUserAction",
	"pcm.usagemodel.Branch",
	"pcm.usagemodel.EntryLevelSystemCall",
	"pcm.usagemodel.Loop",
	"pcm.usagemodel.ScenarioBehaviour",
	"pcm.usagemodel.Stop",
	"pcm.usagemodel.UsageScenario",
	"stoex.AbstractNamedReference",
	"stoex.NamespaceReference",
	"stoex.VariableReference"
])
class PCMext {
	def findStart(List<AbstractAction> actions) {
		actions.filter(typeof(StartAction)).head
	}

	// select Connectors only, no DelegationConnectors
	def connectors(ComposedStructure s) {
		s.connectors__ComposedStructure.filter[connector|!(connector instanceof DelegationConnector)]
	}

	def dispatch test(Connector conn, AssemblyContext ctx, RequiredRole r) {

		// This should never be called
		false
	}

	def dispatch test(AssemblyConnector c, AssemblyContext ctx, RequiredRole r) {
		c.requiredRole_AssemblyConnector.id.equals(r.id) &&
			c.requiringAssemblyContext_AssemblyConnector.id.equals(ctx.id)
	}

	def dispatch test(AssemblyInfrastructureConnector c, AssemblyContext ctx, InfrastructureRequiredRole r) {
		c.requiredRole__AssemblyInfrastructureConnector.id.equals(r.id) &&
			c.requiringAssemblyContext__AssemblyInfrastructureConnector.id.equals(ctx.id)
	}

	def dispatch test(AssemblyEventConnector c, AssemblyContext ctx, SinkRole r) {
		c.sinkRole__AssemblyEventConnector.id.equals(r.id) &&
			c.sourceAssemblyContext__AssemblyEventConnector.id.equals(ctx.id)
	}

	def hasConnector(ComposedStructure s, AssemblyContext ctx, RequiredRole r) {
		connectors(s).filter[con|test(con, ctx, r)].size == 1
	}

	def getConnector(ComposedStructure s, AssemblyContext ctx, RequiredRole r) {
		connectors(s).filter[con|test(con, ctx, r)].head
	}

	def hasProvidedDelegationConnector(ComposedStructure s, ProvidedRole p) {
		s.connectors__ComposedStructure.filter(typeof(ProvidedDelegationConnector)).filter[dc|
			dc.outerProvidedRole_ProvidedDelegationConnector == p].size == 1
	}

	def getProvidedDelegationConnector(ComposedStructure s, ProvidedRole p) {
		s.connectors__ComposedStructure.filter(typeof(ProvidedDelegationConnector)).filter[dc|
			dc.outerProvidedRole_ProvidedDelegationConnector == p].head
	}

	def hasRequiredDelegationConnector(ComposedStructure s, AssemblyContext ctx, RequiredRole r) {
		s.connectors__ComposedStructure.filter(typeof(RequiredDelegationConnector)).filter[dc|
			dc.innerRequiredRole_RequiredDelegationConnector == r].size == 1
	}

	def getRequiredDelegationConnector(ComposedStructure s, AssemblyContext ctx, RequiredRole r) {
		s.connectors__ComposedStructure.filter(typeof(RequiredDelegationConnector)).filter[dc|
			dc.innerRequiredRole_RequiredDelegationConnector == r].head
	}

	def hasProvidedInfrastructureDelegationConnector(ComposedStructure s, InfrastructureProvidedRole p) {
		s.connectors__ComposedStructure.filter(typeof(ProvidedDelegationConnector)).filter[dc|
			dc.outerProvidedRole_ProvidedDelegationConnector == p].size == 1
	}

	def getProvidedInfrastructureDelegationConnector(ComposedStructure s, InfrastructureProvidedRole p) {
		s.connectors__ComposedStructure.filter(typeof(ProvidedDelegationConnector)).filter[dc|
			dc.outerProvidedRole_ProvidedDelegationConnector == p].head
	}

	def hasRequiredInfrastructureDelegationConnector(ComposedStructure s, InfrastructureRequiredRole r) {
		s.connectors__ComposedStructure.filter(typeof(RequiredDelegationConnector)).filter[dc|
			dc.innerRequiredRole_RequiredDelegationConnector == r].size == 1
	}

	def getRequiredInfrastructureDelegationConnector(ComposedStructure s, InfrastructureRequiredRole r) {
		s.connectors__ComposedStructure.filter(typeof(RequiredDelegationConnector)).filter[dc|
			dc.innerRequiredRole_RequiredDelegationConnector == r].head
	}

	def List<EntryLevelSystemCall> querySystemCallsInLoops(ScenarioBehaviour scenBe) {
		scenBe.actions_ScenarioBehaviour.filter(typeof(Loop)).map[l|querySystemCalls(l.bodyBehaviour_Loop)].flatten().
			toList
	}

	def List<EntryLevelSystemCall> querySystemCallsInBranches(ScenarioBehaviour scenBe) {

		// TODO: test if translated correctly		
		scenBe.actions_ScenarioBehaviour.filter(typeof(Branch)).map[branchTransitions_Branch].flatten.map[
			querySystemCalls(it.branchedBehaviour_BranchTransition)].flatten.toList
	}

	def dispatch List<EntryLevelSystemCall> querySystemCalls(ScenarioBehaviour scenBe) {
		val result = new ArrayList<EntryLevelSystemCall>

		result.addAll(scenBe.actions_ScenarioBehaviour.filter(typeof(EntryLevelSystemCall)))
		result.addAll(scenBe.querySystemCallsInLoops)
		result.addAll(scenBe.querySystemCallsInBranches)

		result
	}

	def Set<System> getSystemsFromCalls(Collection<EntryLevelSystemCall> calls) {
		calls.map[c|c.providedRole_EntryLevelSystemCall.providingEntity_ProvidedRole as System].toSet
	}

	def dispatch List<EntryLevelSystemCall> querySystemCalls(UsageScenario us) {
		querySystemCalls(us.scenarioBehaviour_UsageScenario)
	}

	def dispatch String getID(VariableReference vr) {
		vr.referenceName
	}

	def dispatch String getID(AbstractNamedReference nsr) {
		'this is never called'
	}

	def dispatch String getID(NamespaceReference nsr) {
		nsr.referenceName + '.' + nsr.innerReference_NamespaceReference.getID
	}

	def parameterUsageLHS(VariableUsage vu) {
		vu.namedReference__VariableUsage.getID
	}

	def dispatch boolean isInnerReference(VariableReference vr) {
		vr.referenceName == "INNER"
	}

	def dispatch boolean isInnerReference(AbstractNamedReference nsr) {
		false
	}

	def dispatch boolean isInnerReference(NamespaceReference nsr) {
		nsr.referenceName == "INNER" || nsr.innerReference_NamespaceReference.isInnerReference() == true
	}

	def dispatch Set<Entity> collectRepositories(System s) {
		val result = new HashSet<Entity>

		result.addAll(
			s.assemblyContexts__ComposedStructure.map[encapsulatedComponent__AssemblyContext.collectRepositories].
				flatten)
		result.addAll(
			s.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole)).map[it.collectRepositories].
				flatten)
		result.addAll(
			s.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole)).map[it.collectRepositories].
				flatten)
		result.addAll(
			s.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole)).map[
				it.collectRepositories].flatten)
		result.addAll(
			s.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole)).map[
				it.collectRepositories].flatten)

		result
	}

	def dispatch Set<Entity> collectRepositories(OperationProvidedRole pr) {
		newHashSet(pr.providedInterface__OperationProvidedRole.repository__Interface as Entity)
	}

	def dispatch Set<Entity> collectRepositories(InfrastructureProvidedRole pr) {
		newHashSet(pr.providedInterface__InfrastructureProvidedRole.repository__Interface as Entity)
	}

	def dispatch Set<Entity> collectRepositories(OperationRequiredRole rr) {
		newHashSet(rr.requiredInterface__OperationRequiredRole.repository__Interface as Entity)
	}

	def dispatch Set<Entity> collectRepositories(InfrastructureRequiredRole rr) {
		newHashSet(rr.requiredInterface__InfrastructureRequiredRole.repository__Interface as Entity)
	}

	def dispatch Set<Entity> collectRepositories(RepositoryComponent pct) {
		newHashSet(pct.repository__RepositoryComponent as Entity)
	}

	def dispatch Set<Entity> collectRepositories(CompositeComponent cc) {
		val result = newHashSet(cc.repository__RepositoryComponent as Entity)
		result.addAll(
			cc.assemblyContexts__ComposedStructure.map[encapsulatedComponent__AssemblyContext.collectRepositories].
				flatten)
		result
	}

	def dispatch Set<Entity> collectRepositories(InterfaceProvidingRequiringEntity pct) {
		null
	}

	def hasSEFF(Signature service, RepositoryComponent c) {
		if (c instanceof BasicComponent)
			(c as BasicComponent).serviceEffectSpecifications__BasicComponent.filter[describedService__SEFF == service].
				size > 0
		else
			false
	}

	def getSEFF(Signature service, RepositoryComponent c) {
		(c as BasicComponent).serviceEffectSpecifications__BasicComponent.filter[e|e.describedService__SEFF == service].
			head
	}

	def Set<Completion> getAllCompletions(ComposedStructure s) {
		val Set<Completion> result = new HashSet<Completion>

		result.addAll(
			s.assemblyContexts__ComposedStructure.map[encapsulatedComponent__AssemblyContext].filter(typeof(Completion)))

		result.addAll(
			s.assemblyContexts__ComposedStructure.map[encapsulatedComponent__AssemblyContext].filter(
				typeof(ComposedStructure)).filter(comp|comp != null && !(comp instanceof Completion)).map[allCompletions].
				flatten)

		result
	}

	def AbstractAction findStopAction(AbstractAction a) {
		if (a instanceof StopAction)
			a
		else if (a.successor_AbstractAction != null)
			findStopAction(a.successor_AbstractAction)
		else
			null
	}

	def AbstractUserAction findStop(AbstractUserAction a) {
		if (a instanceof Stop)
			a
		else if (a.successor != null)
			findStop(a.successor)
		else
			null
	}

	def List<InterfaceProvidingEntity> getProvidingEntities(List<ProvidedRole> pr) {
		getProvidingEntitiesRecursive(pr, 0)
	}

	def List<InterfaceProvidingEntity> getProvidingEntitiesRecursive(List<ProvidedRole> pr, int i) {
		if (i < pr.size)
			if (getProvidingEntitiesRecursive(pr, i + 1).contains(pr.get(i).providingEntity_ProvidedRole))
				getProvidingEntitiesRecursive(pr, i + 1)
			else {
				val result = getProvidingEntitiesRecursive(pr, i + 1)
				result.add(pr.get(i).providingEntity_ProvidedRole)
				result
			}
		else
			emptyList
	}

	def BasicComponent findContainerComponent(EObject o) {
		if (o instanceof BasicComponent)
			o as BasicComponent
		else
			o.eContainer.findContainerComponent
	}

	def <T> List<T> uniqueIterable(Iterable<T> s) {
		val result = <T>newArrayList()
		for (T t : s) {
			if (result != null && !result.contains(t)) {
				result.add(t)
			} else {
				//do nothing
			}
		}

		//Didn't work with the new Xtend version, NullPointerException was thrown
		//		s.filterNull.forall [
		//			if (result != null && !result.contains(it)) {
		//					result.add(it)
		//				} else {
		//					//do nothing
		//				}
		//		]
		return result
	}

	def String getParentSubsystemsIdConcatenationFor(System s, ComposedStructure toMatch) {
		s.getParentIdConcatenationFor(toMatch).split(" ").last();
	}

	// Polymorphic switch: Execute getParentIdConcatenationFor for SubSystems and Systems.
	def private dispatch String getParentIdConcatenationFor(RepositoryComponent s, ComposedStructure toMatch) {
		""
	}

	def private dispatch String getParentIdConcatenationFor(System s, ComposedStructure toMatch) {
		s.getSystemParentIdConcatenationFor(toMatch)
	}

	def private dispatch String getParentIdConcatenationFor(SubSystem s, ComposedStructure toMatch) {
		s.getSystemParentIdConcatenationFor(toMatch)
	}

	def private String getSystemParentIdConcatenationFor(ComposedStructure s, ComposedStructure toMatch) {
		s.assemblyContexts__ComposedStructure.map[ac|ac.encapsulatedComponent__AssemblyContext.matchID(toMatch) + ac.id].
			findFirst[s2|s2.contains(toMatch.id)]
	}

	def private String matchID(RepositoryComponent s, ComposedStructure toMatch) {
		if (s.id.contains(toMatch.id))
			toMatch.id + " "
		else
			s.getParentIdConcatenationFor(toMatch)
	}

	// recursive query for ExternalCallActions within a RD-SEFF
	def dispatch List<ExternalCallAction> queryExternalCallActions(AbstractAction a, List<ExternalCallAction> result) {
		if (a.successor_AbstractAction != null)
			queryExternalCallActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(ExternalCallAction a, List<ExternalCallAction> result) {
		if (a.successor_AbstractAction != null) {
			result.add(a)
			queryExternalCallActions(a.successor_AbstractAction, result)
		} else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(BranchAction a, List<ExternalCallAction> result) {
		queryExternalCallActions(a.branches_Branch, result)

		if (a.successor_AbstractAction != null)
			queryExternalCallActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(List<AbstractBranchTransition> list,
		List<ExternalCallAction> result) {

		if (list.size > 0) {
			queryExternalCallActions(list.head.branchBehaviour_BranchTransition.steps_Behaviour.findStart(), result)
			queryExternalCallActions(list.tail.toList, result)
		} else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(AbstractLoopAction a, List<ExternalCallAction> result) {
		queryExternalCallActions(a.bodyBehaviour_Loop.steps_Behaviour.findStart(), result)
		if (a.successor_AbstractAction != null)
			queryExternalCallActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(ForkAction a, List<ExternalCallAction> result) {
		queryExternalCallActionsForkedBehaviour(a.asynchronousForkedBehaviours_ForkAction, result)

		if (a.synchronisingBehaviours_ForkAction != null)
			queryExternalCallActions(a.synchronisingBehaviours_ForkAction, result)

		//		else
		//			emptyList
		if (a.successor_AbstractAction != null)
			queryExternalCallActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(SynchronisationPoint p,
		List<ExternalCallAction> result) {
		queryExternalCallActionsForkedBehaviour(p.synchronousForkedBehaviours_SynchronisationPoint, result)
	}

	def List<ExternalCallAction> queryExternalCallActionsForkedBehaviour(List<ForkedBehaviour> list,
		List<ExternalCallAction> result) {
		if (list.size > 0) {
			queryExternalCallActions(list.head, result)
			queryExternalCallActionsForkedBehaviour(list.tail.toList, result)
		} else
			result
	}

	def dispatch List<ExternalCallAction> queryExternalCallActions(ForkedBehaviour b, List<ExternalCallAction> result) {
		queryExternalCallActions(b.steps_Behaviour.findStart(), result);
	}

	// recursive query for InternalActions within a RD-SEFF
	def dispatch List<InternalAction> queryInternalActions(AbstractAction a, List<InternalAction> result) {
		if (a.successor_AbstractAction != null)
			queryInternalActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(InternalAction a, List<InternalAction> result) {
		if (a.successor_AbstractAction != null) {
			val newResult = newArrayList(a)
			newResult.addAll(result)
			queryInternalActions(a.successor_AbstractAction, newResult)
		} else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(BranchAction a, List<InternalAction> result) {
		queryInternalActions(a.branches_Branch, result)

		if (a.successor_AbstractAction != null)
			queryInternalActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(List<AbstractBranchTransition> list,
		List<InternalAction> result) {
		if (list.size > 0) {
			queryInternalActions(list.head.branchBehaviour_BranchTransition.steps_Behaviour.findStart(), result)
			queryInternalActions(list.tail.toList, result)
		} else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(AbstractLoopAction a, List<InternalAction> result) {
		queryInternalActions(a.bodyBehaviour_Loop.steps_Behaviour.findStart(), result)

		if (a.successor_AbstractAction != null)
			queryInternalActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(ForkAction a, List<InternalAction> result) {
		queryInternalActionsForkedBehaviour(a.asynchronousForkedBehaviours_ForkAction, result)

		if (a.synchronisingBehaviours_ForkAction != null)
			queryInternalActions(a.synchronisingBehaviours_ForkAction, result)

		if (a.successor_AbstractAction != null)
			queryInternalActions(a.successor_AbstractAction, result)
		else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(SynchronisationPoint p, List<InternalAction> result) {
		queryInternalActionsForkedBehaviour(p.synchronousForkedBehaviours_SynchronisationPoint, result)
	}

	def List<InternalAction> queryInternalActionsForkedBehaviour(List<ForkedBehaviour> list, List<InternalAction> result) {
		if (list.size > 0) {
			queryInternalActions(list.head, result)
			queryInternalActionsForkedBehaviour(list.tail.toList, result)
		} else
			result
	}

	def dispatch List<InternalAction> queryInternalActions(ForkedBehaviour b, List<InternalAction> result) {
		queryInternalActions(b.steps_Behaviour.findStart(), result)
	}

	def ResourceDemandingSEFF getRdseff(AbstractAction action) {
		Helper::getRdseff(action)
	}
}

package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.entity.Entity
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction
import de.uka.ipd.sdq.pcm.seff.InternalAction
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn
import java.util.Set
import org.eclipse.emf.ecore.EObject

@ModelIn(#[
	"pcm.core.entity.Entity",
	"pcm.repository.BasicComponent",
	"pcm.repository.InfrastructureSignature",
	"pcm.repository.OperationSignature",
	"pcm.repository.RepositoryComponent",
	"pcm.seff.ExternalCallAction",
	"pcm.seff.InternalAction"
])
class SensorsExt {
	@Inject extension PCMext
	@Inject extension JavaNamesExt

	def String externalCallActionDescription(OperationSignature os, Object call) {
		"Call "+os.interface__OperationSignature.entityName+"."+os.javaSignature()+" <Component: "+
			(call as EObject).findContainerComponent().entityName+", AssemblyCtx: \"+this.assemblyContextID+\", CallID: "+
			(call as ExternalCallAction).id+">";
	}
	
	def String internalActionDescription(InfrastructureSignature os, Object call) {
		"Call "+os.infrastructureInterface__InfrastructureSignature.entityName+"."+
		os.javaSignature()+" <Component: "+(call as EObject).findContainerComponent().entityName+
		", AssemblyCtx: \"+this.assemblyContextID+\", CallID: "+(call as InternalAction).id+">";
	}
	 
	def String entryLevelSystemCallActionDescription(OperationSignature os, Object call) {
		"Call_"+os.javaSignature()+" <EntryLevelSystemCall id: "+(call as Entity).id+" >"; 
	}	
	
	def String entryLevelSystemCallActionDescription(InfrastructureSignature os, Object call) {
		"Call_"+os.javaSignature()+" <EntryLevelSystemCall id: "+(call as Entity).id+" >"; 
	}
	
	def Set<ExternalCallAction> getExternalCallActions(BasicComponent component) {
		val result = <ExternalCallAction>newHashSet
		
		component.serviceEffectSpecifications__BasicComponent.forEach [
			result.addAll(it.eAllContents.filter(typeof(ExternalCallAction)).toList)
		]
			
		result
//	  component.serviceEffectSpecifications__BasicComponent.collect(e|e.eAllContents.select(action|ExternalCallAction.isInstance(action))).flatten();
	}	  
	
	def String seffDescription(OperationSignature os, RepositoryComponent component) { 
		"SEFF "+os.interface__OperationSignature.entityName+"."+os.javaSignature()+" <Component: "+
		component.entityName+", AssemblyCtx: \"+this.assemblyContextID+\">";
	}
	  
	def String seffDescription(InfrastructureSignature os, RepositoryComponent component) { 
		"SEFF "+os.infrastructureInterface__InfrastructureSignature.entityName+"."+os.javaSignature()+
	  " <Component: "+component.entityName+", AssemblyCtx: \"+this.assemblyContextID+\">";
	}
}
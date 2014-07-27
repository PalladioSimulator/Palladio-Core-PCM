package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.entity.Entity
import de.uka.ipd.sdq.pcm.parameter.VariableUsage
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.seff.seff_performance.InfrastructureCall
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn
import java.util.List

@ModelIn(#[
	"pcm.core.entity.Entity",
	"pcm.parameter.VariableUsage",
	"pcm.repository.InfrastructureSignature",
	"pcm.repository.OperationSignature",
	"pcm.seff.seff_performance.InfrastructureCall"
])
abstract class CallsXpt {
	@Inject extension JavaNamesExt
	@Inject extension JavaCoreXpt

//-----------------------------------
// Templates for the call to an external method
// An instance of a port can be passed as prefix
// The list of parameter usages characterises the paramter contents
// ----------------------------------
	def call(OperationSignature signature, Entity call, String prefix, List<VariableUsage> parameterUsages, List<VariableUsage> outParameterUsages) '''
		«signature.preCallTM(call, prefix, parameterUsages)»
		«prefix»«signature.javaSignature»
			(«signature.parameterUsageListTM»);
		«signature.postCallTM(call, prefix, outParameterUsages)»
	'''

	def call(InfrastructureCall infraCall, Entity call) '''
		{ //CALL SCOPE: this scope is needed if the same service is called multiple times in one SEFF. Otherwise there is a duplicate local variable definition.
	    long numberOfCalls = ctx.evaluate("«infraCall.numberOfCalls__InfrastructureCall.specification.specificationString»",Double.class).longValue();
		for (long callNumber = 0; callNumber < numberOfCalls; callNumber++) {
		«val prefix = "myContext.getRole"+infraCall.requiredRole__InfrastructureCall.javaName+"()."»
		«infraCall.signature__InfrastructureCall.preCallTM(call, prefix, infraCall.inputVariableUsages__CallAction)»
	   	«prefix»«infraCall.signature__InfrastructureCall.javaSignature»
		   	(«infraCall.signature__InfrastructureCall.parameterUsageListTM»);
		«infraCall.signature__InfrastructureCall.postCallTM(call, prefix)»
		}
	} // END CALL SCOPE
	'''
	
	// ----------------------------------
	// Template method for code to be executed before
	// an external call
	// ----------------------------------
	def void preCallTM(OperationSignature signature, Entity call, String prefix, List<VariableUsage> parameterUsages) 
	
	def void preCallTM(InfrastructureSignature signature, Entity call, String prefix, List<VariableUsage> parameterUsages)
	
	// ----------------------------------
	// Template method for code to be executed after
	// an external call
	// ----------------------------------
	def void postCallTM(OperationSignature signature, Entity call, String prefix, List<VariableUsage> outParameterUsages)
	
	def void postCallTM(InfrastructureSignature signature, Entity call, String prefix)
}
package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaCoreXpt
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ProvidedPortsXpt
import de.uka.ipd.sdq.pcm.repository.ProvidedRole
import de.uka.ipd.sdq.pcm.repository.Interface
import de.uka.ipd.sdq.pcm.repository.Signature

class SimProvidedPortsXpt extends ProvidedPortsXpt {
	@Inject extension JavaNamesExt
	@Inject extension JavaCoreXpt
	
	def dispatch portDelegationDelegatingCall(OperationSignature os) '''
		return myComponent.«os.interface__OperationSignature.javaName().toFirstLower()»_«os.javaSignature()»(
		     «os.parameterUsageListTM»);
	'''
	
	def dispatch portDelegationDelegatingCall(InfrastructureSignature is) '''
		return myComponent.«is.infrastructureInterface__InfrastructureSignature.javaName().toFirstLower()»_«is.javaSignature()»(
		     «is.parameterUsageListTM»);
	'''
	
	def dispatch composedStructurePortDelegationDelegatingCall(OperationSignature os, ComposedProvidingRequiringEntity cs) '''
		//logger.debug("Entering port of composed structure «cs.entityName»");
		«cs.prePortCode»
		«os.returnTypeTM» result = myInnerPort.«os.javaSignature()»(
		     «os.parameterUsageListTM»);
		«cs.postPortCode»
		return result;
	'''
	
	def dispatch composedStructurePortDelegationDelegatingCall(InfrastructureSignature is, ComposedProvidingRequiringEntity cs) '''
		//logger.debug("Entering port of composed structure «cs.entityName»");
		«cs.prePortCode»
		«is.returnTypeTM» result = myInnerPort.«is.javaSignature()»(
		     «is.parameterUsageListTM»);
		«cs.postPortCode»
		return result;
	'''
	
	def dispatch prePortCode(ComposedProvidingRequiringEntity cpre) '''
	'''
	
	def dispatch prePortCode(Completion c) '''
		ctx.setEvaluationMode(de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode.RETURN_DEFAULT_ON_NOT_FOUND);
	'''
	
	def dispatch postPortCode(ComposedProvidingRequiringEntity cpre) '''
	'''
	
	def dispatch postPortCode(Completion c) '''
		ctx.setEvaluationMode(de.uka.ipd.sdq.simucomframework.variables.stoexvisitor.VariableMode.EXCEPTION_ON_NOT_FOUND);
	'''
	
	def dispatch componentPortHelperMethods(OperationProvidedRole opr) '''
		     public String getComponentAssemblyContextID() {
		     	return this.myComponent.getAssemblyContextID();
		     }
	'''
	
	def dispatch componentPortHelperMethods(InfrastructureProvidedRole ipr) '''
		     public String getComponentAssemblyContextID() {
		     	return this.myComponent.getAssemblyContextID();
		     }
	'''
	
	def dispatch composedComponentPortHelperMethods(OperationInterface oi) '''
		     public String getComponentAssemblyContextID() {
		     	return this.myInnerPort.getComponentAssemblyContextID();
		     }
	'''
	
	def dispatch composedComponentPortHelperMethods(InfrastructureInterface ii) '''
		     public String getComponentAssemblyContextID() {
		     	return this.myInnerPort.getComponentAssemblyContextID();
		     }
	'''
	
	def dispatch dummyComponentPortHelperMethod(OperationInterface oi) '''
				public String getComponentAssemblyContextID() {
					return "";
				}
	'''
	
	def dispatch dummyComponentPortHelperMethod(InfrastructureInterface ii) '''
				public String getComponentAssemblyContextID() {
					return "";
				}
	'''
	
	// overwrite template methods
	override componentPortHelperMethodsTM(ProvidedRole role) {
		componentPortHelperMethods(role)
	}

	override composedComponentPortHelperMethodsTM(Interface iface) {
		composedComponentPortHelperMethods(iface)
	}
	
	override portDelegationDelegatingCallTM(Signature signature) {
		portDelegationDelegatingCall(signature)
	}
	
	override composedStructurePortDelegationDelegatingCallTM(Signature signature, ComposedProvidingRequiringEntity cs) {
		composedStructurePortDelegationDelegatingCall(signature, cs)
	}
	
}
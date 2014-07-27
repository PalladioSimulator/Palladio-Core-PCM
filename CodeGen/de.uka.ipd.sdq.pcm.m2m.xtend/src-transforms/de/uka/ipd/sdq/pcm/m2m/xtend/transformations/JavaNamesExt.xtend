package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.pcm.allocation.Allocation
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.entity.Entity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceRequiringEntity
import de.uka.ipd.sdq.pcm.reliability.FailureType
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.system.System
import de.uka.ipd.sdq.pcm.transformations.Helper
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.completions.Completion",
	"pcm.allocation.Allocation",
	"pcm.core.composition.ComposedStructure",
	"pcm.core.entity.Entity",
	"pcm.core.entity.InterfaceProvidingEntity",
	"pcm.core.entity.InterfaceRequiringEntity",
	"pcm.reliability.FailureType",
	"pcm.system.System",
	"pcm.usagemodel.UsageScenario",
	"pcm.repository.*"
])
class JavaNamesExt {
	def removeAllSpecialChars(String s) {
		Helper::removeAllSpecialChars(s)
	}
	
	// Generate a java name by replacing all characters which are not java conform
	def javaName(Entity e) {
    	e.entityName.replaceAll('"','_').replaceAll(' ','_').replaceAll("<","_")
    	            .replaceAll(">","_").replaceAll(":","_").replaceAll("\\.","_")
    	            .replaceAll("\\,","_").replaceAll("\\+","_").replaceAll("-","_")
    	            .replaceAll("\\(","_").replaceAll("\\)","_");
	}
	
	def javaString(String s) {
		s.replaceAll('"','\\\\"').replaceAll(' ','_')
		 .replaceAll("<","_").replaceAll(">","_")
		 .replaceAll(":","_").replaceAll("\\.","_")
	}
	
	def javaVariableName(String s) {
		s.replaceAll('"','_').replaceAll(' ','_').replaceAll("<","_")
		 .replaceAll(">","_").replaceAll(":","_").replaceAll("\\.","_")
		 .replaceAll("\\,","_").replaceAll("\\+","_").replaceAll("-","__")
		 .replaceAll("\\(","_").replaceAll("\\)","_")
	}
	
	def specificationString(String s) {
		s.replaceAll('"', '\\\\"').removeAllSpecialChars
	}
	
	def javaSignature(OperationSignature s) {
		// Ignore Java conventions and use user supplied name (s.serviceName.toFirstLower();)
		s.entityName + s.posInInterface(0)
	}
	
	// TODO: Disable in Code Generations!
	def String posInInterface(OperationSignature s, int pos) {
		if (s.interface__OperationSignature.signatures__OperationInterface.get(pos) == s)
			pos.toString
		else
			s.posInInterface(pos + 1)
	}
	
	def String javaSignature(InfrastructureSignature s) {
		// Ignore Java conventions and use user supplied name (s.serviceName.toFirstLower();)
		s.entityName + s.posInInterface(0)
	}
	
	def String posInInterface(InfrastructureSignature s, int pos) {
		if (s.infrastructureInterface__InfrastructureSignature.infrastructureSignatures__InfrastructureInterface.get(pos) == s)
			pos.toString
		else
			s.posInInterface(pos + 1)
	}

	// ID of a single port class
	def dispatch portClassName(OperationProvidedRole r) {
		r.providedInterface__OperationProvidedRole.javaName+"_"+r.providingEntity_ProvidedRole.javaName
	}

	// ID of a single port class
	def dispatch portClassName(InfrastructureProvidedRole r) {
		r.providedInterface__InfrastructureProvidedRole.javaName+"_"+r.providingEntity_ProvidedRole.javaName
	}
	
	// Name of the class containing the interfaces of the required roles
	def contextClassName(InterfaceRequiringEntity c) {
		c.javaName+"Context"
	}

	def contextInterfaceName(InterfaceRequiringEntity c) {
		"I"+c.javaName+"Context"
	}

	// ID of a member variable used in the main component implementation to store the singleton port
	// instance
	def dispatch portMemberVar(OperationProvidedRole r) {
		"m_port"+r.javaName
	}

	def dispatch portMemberVar(InfrastructureProvidedRole r) {
		"m_port"+r.javaName
	}

	// Name of the getter Method used to get the singleton port instances
	// of the provided ports
	def dispatch portGetterName(OperationProvidedRole r) {
		"getPort"+r.javaName
	}

	def dispatch portGetterName(InfrastructureProvidedRole r) {
		"getPort"+r.javaName
	}

	// Name of the main class implementing a system
	def className(ComposedStructure s) {
		s.javaName
	}
	
	def fqnAllocationContextPackage(Allocation a) {
		a.system_Allocation.implementationPackage+".allocation"
	}

	def fqnAllocationContextClass(Allocation a) {
		a.javaName+"RuntimeContext"
	}

	def fqnAllocationContext(Allocation a) {
		a.fqnAllocationContextPackage+"."+a.fqnAllocationContextClass
	}
	
	// ------------------- FQNs (full qualified names) -------------------
	def dispatch fqn(Entity e) {
		"Should never be called"
	}
	
	def dispatch fqn(OperationInterface i) {
		i.implementationPackage+"."+i.javaName
	}
	
	def dispatch fqn(InfrastructureInterface i) {
		i.implementationPackage+"."+i.javaName
	}

	def dispatch fqn(RepositoryComponent c) {
		c.implementationPackage+"."+c.javaName
	}

	def dispatch fqn(System s) {
		s.implementationPackage+"."+s.javaName
	}

	// Completion should be matched by RepositoryComponent
//	def dispatch fqn(Completion s) {
//		s.implementationPackage+"."+s.javaName
//	}
	
	def dispatch fqn(UsageScenario us) {
		us.implementationPackage+"."+us.javaName
	}
	
	def fqnContextPackage(Entity c) {
		c.implementationPackage+".contexts"
	}
	
	def fqnContext(InterfaceRequiringEntity c) {
		c.fqnContextPackage+"."+c.contextClassName
	}

	def fqnContextInterface(InterfaceRequiringEntity c) {
		c.fqnContextPackage+".I"+c.contextClassName
	}

	def dispatch fqnPortPackage(OperationProvidedRole pr) {
		pr.providingEntity_ProvidedRole.implementationPackage+".ports"
	}

	def dispatch fqnPortPackage(InfrastructureProvidedRole pr) {
		pr.providingEntity_ProvidedRole.implementationPackage+".ports"
	}
	
	def dispatch fqnPort(OperationProvidedRole pr) {
		pr.providingEntity_ProvidedRole.implementationPackage+".ports."+pr.portClassName
	}

	def dispatch fqnPort(InfrastructureProvidedRole pr) {
		pr.providingEntity_ProvidedRole.implementationPackage+".ports."+pr.portClassName
	}

	def beanName(RepositoryComponent c) {
		c.javaName+"Bean"
	}

	def fqnInterface(InterfaceProvidingEntity c) {
		c.implementationPackage+".I"+c.javaName
	}
	
	def interfaceName(InterfaceProvidingEntity c) {
		"I"+c.javaName
	}	

	def dispatch dummyComponentName(OperationRequiredRole rr) {
		rr.requiredInterface__OperationRequiredRole.javaName+"Dummy"
	}

	def dispatch dummyComponentName(InfrastructureRequiredRole rr) {
		rr.requiredInterface__InfrastructureRequiredRole.javaName+"Dummy"
	}

	def dispatch fqnDummyComponentPackage(OperationRequiredRole rr) {
		"dummies"
	}

	def dispatch fqnDummyComponentPackage(InfrastructureRequiredRole rr) {
		"dummies"
	}

	def dispatch fqnDummyComponent(OperationRequiredRole rr) {
		rr.fqnDummyComponentPackage+"."+rr.dummyComponentName
	}

	def dispatch fqnDummyComponent(InfrastructureRequiredRole rr) {
		rr.fqnDummyComponentPackage+"."+rr.dummyComponentName
	}
	
	// Base package of a generated system   
	def String basePackageName(Entity s) {
	   s.javaName().toLowerCase();
	}
	
	def dispatch implementationPackage(Entity e) {
		"should never be called!";
	}

	// Base package of the implementation of an interface
	def dispatch implementationPackage(OperationInterface i) {
	   i.repository__Interface.basePackageName();
	}
	
	def dispatch implementationPackage(InfrastructureInterface i) {
	   i.repository__Interface.basePackageName();
	}
	   
	// Base package of the implementation of a system
	def dispatch implementationPackage(System s) {
	   s.basePackageName()+".impl";
	}
	  
	// Base package of the implementation of a system
	def dispatch implementationPackage(Completion s) {
	   s.basePackageName()+".impl";
	}
	  
	// Base package of the implementation of a system
	def dispatch implementationPackage(UsageScenario u) {
	   u.basePackageName()+".impl";
	}
	      
	// Package name of the implementation classes implementing a component     
	def dispatch implementationPackage(RepositoryComponent c) {
	   c.repository__RepositoryComponent.basePackageName()+".impl";
	   
	   }
	
	def dispatch implementationPackage(FailureType ft) {
		ft.repository__FailureType.basePackageName()+".exceptions";
	}
	
	def fqnToDirectoryPath(String fqn) {
		fqn.replaceAll("\\.","/");
	}

	def getFileName(Entity e) {
		e.implementationPackage().fqnToDirectoryPath()+"/"+e.javaName()+".java";
 	}
}
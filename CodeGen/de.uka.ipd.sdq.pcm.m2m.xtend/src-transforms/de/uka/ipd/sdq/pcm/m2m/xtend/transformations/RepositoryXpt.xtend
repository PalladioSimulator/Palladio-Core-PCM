package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.repository.Repository
import de.uka.ipd.sdq.pcm.repository.OperationInterface
import de.uka.ipd.sdq.pcm.repository.InfrastructureInterface
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.subsystem.SubSystem
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess

abstract class RepositoryXpt {
	@Inject M2TFileSystemAccess fsa

	@Inject extension ComposedStructureXpt
	@Inject extension ContextPatternXpt
	@Inject extension JavaCoreXpt
	@Inject extension JavaNamesExt
	@Inject extension ProvidedPortsXpt
	
	// Generate code for a single repository
	// This means:
	// - Generate all Interfaces
	// - Generate all components
	// - Generate all datatypes (POJO only)
	def void root(Repository repo) {
		repo.interfaces__Repository.filter(typeof(OperationInterface)).forEach[it.interfaceFile]
		repo.interfaces__Repository.filter(typeof(InfrastructureInterface)).forEach[it.interfaceFile]
		repo.components__Repository.forEach[it.componentRoot]
	}
	
	def dispatch void interfaceFile(OperationInterface oi) {
		val fileName = oi.getFileName() // TODO «FILE this.getFileName() ***INTERFACES***»
		val fileContent = '''
			«oi.interfaceHeader»

			{
				«oi.interfaceHelperMethodsDeclarationTM»
				«FOR iface : oi.signatures__OperationInterface SEPARATOR ";"»«iface.operationSignature»«ENDFOR»;
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def dispatch void interfaceFile(InfrastructureInterface ii) {
		val fileName = ii.getFileName // TODO: «FILE this.getFileName() INTERFACES» 
		val fileContent = '''
			«ii.interfaceHeader»

			{
				«ii.interfaceHelperMethodsDeclarationTM»
				«FOR iface : ii.infrastructureSignatures__InfrastructureInterface SEPARATOR ";"»«iface.infrastructureSignature»«ENDFOR»;
			}
		'''

		fsa.generateFile(fileName, fileContent)
	}

	def dispatch interfaceHeader(OperationInterface oi) '''
	   package «oi.repository__Interface.basePackageName()»;

	   public interface «oi.javaName()»
	'''
	
	def dispatch interfaceHeader(InfrastructureInterface ii) '''
	   package «ii.repository__Interface.basePackageName()»;

	   public interface «ii.javaName()»
	'''
	
	def CharSequence interfaceHelperMethodsDeclarationTM(OperationInterface oi)
	
	def CharSequence interfaceHelperMethodsDeclarationTM(InfrastructureInterface ii)
	
	def dispatch void componentRoot(RepositoryComponent rc) {
	  /* FIXME: There seems to be a bug in xPand 0.7.2 that calls this template for SubSystems 
	  (It should call ComponentRoot FOR SubSystem). See Bug 523. Revisit this again when a new XPand is available. 
	  Note: it does not even work to compare IF this.metaType == subsystem::SubSystem, because it cannot find the 
	  type subsystem::SubSystem at runtime.*/
	  /* TODO: Check if right translation (metatype) */
	  if (rc instanceof SubSystem)
	    /*ERROR "OAW GENERATION ERROR [m2t_transforms/repository.xpt]: Caught wrongly expanded SubSystem "+this.entityName +"(type "+this.metaType+") in DEFINE ComponentRoot FOR RepositoryComponent."*/
	    (rc as SubSystem).compositeComponentRoot
	  else
	    rc.componentImplementation
	}
	
	def dispatch void componentRoot(CompositeComponent cc) {
	   cc.compositeComponentRoot
	}
	
	def dispatch void componentRoot(SubSystem ss) {
	   ss.compositeComponentRoot
	}
	
	def void compositeComponentRoot(ComposedProvidingRequiringEntity cpre) {
		/* Handles CompositeComponents and SubSystems */
		val fileName = cpre.getFileName()
		val fileContent = '''
			«cpre.composedStructureStart»
			«cpre.providedPorts»
			«cpre.requiredInterfaces»
			«cpre.composedStructureEnd»

			«/*
			I guess this line is generating additional overhead, the components inside a CC should be generated already
			«EXPAND m2t_transforms::repository::ComponentRoot FOREACH this.assemblyContexts_ComposedStructure.encapsulatedComponent_AssemblyContext»
			*/»
		'''

		fsa.generateFile(fileName, fileContent)
	}
}
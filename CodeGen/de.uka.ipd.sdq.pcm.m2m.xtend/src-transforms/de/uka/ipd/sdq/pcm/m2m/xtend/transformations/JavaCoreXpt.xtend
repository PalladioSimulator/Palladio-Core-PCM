package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.m2m.xtend.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureSignature
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationSignature
import de.uka.ipd.sdq.pcm.repository.Parameter
import de.uka.ipd.sdq.pcm.repository.RepositoryComponent
import de.uka.ipd.sdq.pcm.repository.Signature
import de.uka.ipd.sdq.pcm.seff.AbstractAction
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification
import de.uka.ipd.sdq.pcm.seff.StopAction
import de.uka.ipd.sdq.pcm.subsystem.SubSystem
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"pcm.repository.*",
	"pcm.core.entity.InterfaceProvidingEntity",
	"pcm.core.entity.InterfaceProvidingRequiringEntity",
	"pcm.seff.AbstractAction",
	"pcm.seff.ServiceEffektSpecification",
	"pcm.seff.StopAction",
	"pcm.subsytem.Subsystem"
])
abstract class JavaCoreXpt {
	@Inject M2TFileSystemAccess fsa
	
	@Inject extension JavaNamesExt
	@Inject extension DataTypesXpt
	@Inject extension SEFFBodyXpt
	@Inject extension ProvidedPortsXpt
	@Inject extension ContextPatternXpt
	
	def classHeader(RepositoryComponent component) '''
		public class «component.javaName»
	'''
	
	def operationSignature(OperationSignature signature) '''
		«signature.returnTypeTM»
		«signature.javaSignature»
		( «signature.parameterListTM» )
	'''	

	def infrastructureSignature(InfrastructureSignature signature) '''
		«signature.returnTypeTM»
		«signature.javaSignature»
		( «signature.parameterListTM» )
	'''	

	def dispatch returnType(OperationSignature signature) '''
		«IF signature.returnType__OperationSignature != null»
			«signature.returnType__OperationSignature.dataType»
		«ELSE»
			void
		«ENDIF»
	'''

	def dispatch returnType(InfrastructureSignature signature)'''
		void
	'''
	//Abstract methods for returnType and ParameterList that must be overwritten 
	def CharSequence returnTypeTM(OperationSignature signature)

	def CharSequence returnTypeTM(InfrastructureSignature signature)

	def CharSequence parameterListTM(Signature signature)

	def CharSequence parameterUsageListTM(Signature signature)
	
	def parameter(Parameter param) '''
		«IF param.dataType__Parameter != null»
			«param.dataType__Parameter.dataType»
		«ELSE»
			void
		«ENDIF»
		«param.parameterName»
	'''
	
	def parameterUse(Parameter param) '''
		«param.parameterName»
	'''

	//-----
	// Generate method implementations by traversing the SEFF
	def CharSequence componentService(ServiceEffectSpecification seff)

	def dispatch componentServiceSignature(OperationSignature signature) '''
		«signature.returnTypeTM»
			«signature.interface__OperationSignature.javaName.toFirstLower»_«signature.javaSignature»
				(«signature.parameterListTM»)
	'''

	def dispatch componentServiceSignature(InfrastructureSignature signature) '''
		«signature.returnTypeTM»
			«signature.infrastructureInterface__InfrastructureSignature.javaName.toFirstLower»_«signature.javaSignature»
				(«signature.parameterListTM»)
	'''

	def CharSequence componentServiceTM(OperationSignature signature, RepositoryComponent component) 

	def CharSequence componentServiceTM(InfrastructureSignature signature, RepositoryComponent component)

	def String actions(AbstractAction action) '''
		«action.action»
		«IF !(action instanceof StopAction)»
			«action.successor_AbstractAction.actions»
		«ENDIF»
	'''
	//-----
	
	//-----
	// Polymorphic switch to generate different thing for {Basic,Complete and Provides}-Types and for
	// ComposedStructure
	def dispatch componentImplementation(RepositoryComponent component) '''
		« /* ERROR "OAW GENERATION ERROR [m2t_transforms/java_core.xpt]: " + this.entityName +"(type "+this.metaType+") is an unknown RepositoryComponent type. Fix the transformations or contact the developers." */ »
	'''

	def dispatch componentImplementation(ImplementationComponentType component) '''
		«component.componentImplementationForImplComponentTypesAndSubSystems»
	'''

	def dispatch componentImplementation(SubSystem system) '''
		«system.componentImplementationForImplComponentTypesAndSubSystems»
	'''

	def componentImplementationForImplComponentTypesAndSubSystems(RepositoryComponent component) {
		val fileName = component.fileName
		val fileContent = '''
			«component.componentImplementationInterface»
			«component.componentPackage»
			
			«component.classHeader»
			«component.superClassesTM»
			implements «component.fqnInterface»
			{
				«component.componentConstructorTM»
				«component.providedPorts»
				«component.requiredInterfaces»
				«component.innerImplementation»
				«component.specificImplementationPartTM»
			}
			«component.componentImplementationChildClassTM»
		'''
		
		fsa.generateFile(fileName, fileContent)
	}

	def componentPackage(RepositoryComponent component) '''
		package «component.implementationPackage»;
	'''

	def componentImplementationInterface(InterfaceProvidingEntity entity) {
		val fileName = entity.fqnInterface.fqnToDirectoryPath+'.java'
		val fileContent = '''
			«entity.contentImplementationInterfaceHeader»
			{
				«entity.componentHelperMethodsDeclarationTM»
				«entity.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole)).
					map[providedInterface__OperationProvidedRole.signatures__OperationInterface].
					flatten.map[it.componentServiceSignature].join(";")»;
				«entity.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole)).
					map[providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface].
					flatten.map[it.componentServiceSignature].join(";")»;
				«FOR providedRole:entity.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole))»
					«providedRole.portGetterDefinition»
				«ENDFOR»
				«FOR providedRole:entity.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole))»
					«providedRole.portGetterDefinition»
				«ENDFOR»
				«IF (entity instanceof InterfaceProvidingRequiringEntity)»
					«{
						val requiringEntity = entity as InterfaceProvidingRequiringEntity
						requiringEntity.componentContextSetterDefinition
					}»
				«ENDIF»
				«IF (entity instanceof RepositoryComponent)»
					«{
						val requiringEntity = entity as RepositoryComponent
					 	requiringEntity.specificImplementationPartForInterfaceTM
					}»
				«ENDIF»
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}
	
	def contentImplementationInterfaceHeader(InterfaceProvidingEntity entity) '''
		package «entity.implementationPackage»;
		
		public interface «entity.interfaceName»
	'''

	def CharSequence componentHelperMethodsDeclarationTM(InterfaceProvidingEntity entity)

	def CharSequence componentImplementationChildClassTM(RepositoryComponent component)

	def CharSequence specificImplementationPartTM(RepositoryComponent component) 

	// Add some component methods also to the generated java interface to access it via EJB lookup.
	def CharSequence specificImplementationPartForInterfaceTM(RepositoryComponent component)
	
	def CharSequence superClassesTM(RepositoryComponent component) 
	
	def CharSequence innerImplementation(RepositoryComponent component)
	
	def innerImplementation(BasicComponent component) '''
		«FOR iface:component.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole)).
			map[providedInterface__OperationProvidedRole.signatures__OperationInterface].flatten»
			«componentServiceTM(iface, component)»
		«ENDFOR»
		«FOR iface:component.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole)).
			map[providedInterface__InfrastructureProvidedRole.infrastructureSignatures__InfrastructureInterface].flatten»
			«componentServiceTM(iface, component)»
		«ENDFOR»
	'''
	
	def CharSequence innerImplementation(CompositeComponent component)

	def CharSequence componentConstructorTM(RepositoryComponent component)

	def CharSequence containerAvailabilityCheckTM(OperationSignature signature)

	def CharSequence contextTypeTM(AbstractAction action)
}
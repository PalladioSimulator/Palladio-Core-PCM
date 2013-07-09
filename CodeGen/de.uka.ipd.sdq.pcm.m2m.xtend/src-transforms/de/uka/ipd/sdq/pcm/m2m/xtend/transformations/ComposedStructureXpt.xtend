package de.uka.ipd.sdq.pcm.m2m.xtend.transformations

import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.core.entity.InterfaceProvidingEntity
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.repository.InfrastructureProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole
import de.uka.ipd.sdq.pcm.repository.InfrastructureRequiredRole
import de.uka.ipd.sdq.pcm.core.composition.AssemblyConnector
import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.pcm.core.composition.AssemblyInfrastructureConnector
import com.google.inject.Inject

class ComposedStructureXpt {
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension DelegatorClassXpt
	
	//-------------------------------------
	// Generate the "implementation" of a 
	// composed structure by creating an instance 
	// of all components in their respective child
	// assembly contexts
	//-------------------------------------
	def composedStructureStart(ComposedProvidingRequiringEntity entity) '''
		package «entity.implementationPackage»;

		public class «entity.className» 
		{
			private static org.apache.log4j.Logger logger = 
				org.apache.log4j.Logger.getLogger(«entity.className».class.getName());
		«entity.constructor»
		«entity.innerImplementation»
	'''
	
	def constructor(ComposedProvidingRequiringEntity entity) '''
		«/* Create constructor without closing curly brace */»
		«entity.composedPREConstructorStartTM»

			«/* This is still inside the constructor. */»
			logger.info("Creating composed structure «entity.entityName»");
			«entity.allChildMemberVarInit»
		      
			«IF entity instanceof InterfaceProvidingEntity»
				/* And finally, my ports */
				«FOR role : entity.providedRoles_InterfaceProvidingEntity.filter(typeof(OperationProvidedRole))»
					«role.portInit(entity)»
				«ENDFOR»
				«FOR role : entity.providedRoles_InterfaceProvidingEntity.filter(typeof(InfrastructureProvidedRole))»
					«role.portInit(entity)»
				«ENDFOR»
			«ENDIF»
		} «/* End constructor */»
	'''
	
	def composedPREConstructorStartTM(ComposedProvidingRequiringEntity entity) '''
	   «/* default constructor */»
	   public «entity.className()»() {
	'''
	
	def composedStructureEnd(ComposedStructure entity) '''
	   }
	'''
	
	//--------------------------------------
	// Template method to override the standard parameters
	// which can be passed to component child instances of
	// a composed structure
	//--------------------------------------
	def componentConstructorParametersTM(AssemblyContext obj) '''
		/* Add Parameters here */
	'''
	
	//--------------------------------------
	// Generate a member variable storing a component instance for a given
	// assembly context
	//--------------------------------------
	def childMemberVar(AssemblyContext ac) '''
	   protected 
	      «ac.encapsulatedComponent__AssemblyContext.fqn()» 
	         my«ac.javaName()» = null;
	'''
	
	def allChildMemberVarInit(ComposedProvidingRequiringEntity entity) '''
		«FOR context : entity.assemblyContexts__ComposedStructure»«context.childMemberVarInitTM»«ENDFOR»
	'''
	
	
	def childMemberVarInitTM(AssemblyContext context) '''
	   my«context.javaName()» = new «context.encapsulatedComponent__AssemblyContext.fqn()»
	         	(«context.componentConstructorParametersTM»);
	'''
	
	def innerImplementation(ComposedStructure cs) '''
		// Composed child components member variables
		«FOR context : cs.assemblyContexts__ComposedStructure»«context.childMemberVar»«ENDFOR»

		/**
		* Inner Structure initialisation
		*/
		private void initInnerComponents() {
	
			/* First, initialise composite child structures */
			«FOR child : cs.assemblyContexts__ComposedStructure.filter[c|c.encapsulatedComponent__AssemblyContext instanceof ComposedStructure]»
				init«child.javaName()»();
			«ENDFOR»
			/* Then initialise basic components */
			«FOR child : cs.assemblyContexts__ComposedStructure.filter[c|!(c.encapsulatedComponent__AssemblyContext instanceof ComposedStructure)]»
				init«child.javaName()»();
			«ENDFOR»
		}
	
		«FOR context : cs.assemblyContexts__ComposedStructure»«init(context, cs)»«ENDFOR»
		/**
		* Inner Structure initialisation end
		*/
	'''
	
	def dispatch portInit(OperationProvidedRole role, ComposedStructure cs) '''
	«role.portMemberVar()» = new «role.fqnPort()»(
			«IF cs.hasProvidedDelegationConnector(role)»
				my«cs.getProvidedDelegationConnector(role).assemblyContext_ProvidedDelegationConnector.javaName()».
				«cs.getProvidedDelegationConnector(role).innerProvidedRole_ProvidedDelegationConnector.portGetterName()»()
			«ELSE»
			   null
			«ENDIF»
			);
	'''
	
	def dispatch portInit(InfrastructureProvidedRole role, ComposedStructure cs) '''
		«role.portMemberVar()» = new «role.fqnPort()»(
				«IF cs.hasProvidedDelegationConnector(role)»
					my«cs.getProvidedDelegationConnector(role).assemblyContext_ProvidedDelegationConnector.javaName()».
					«cs.getProvidedDelegationConnector(role).innerProvidedRole_ProvidedDelegationConnector.portGetterName()»()
				«ELSE»
				   null
				«ENDIF»
				);
	'''
	
	def init(AssemblyContext context, ComposedStructure s) '''
		private void init«context.javaName()»() {
			«context.encapsulatedComponent__AssemblyContext.fqnContext()» context = new «context.encapsulatedComponent__AssemblyContext.fqnContext()»(
			«FOR role : context.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole)) SEPARATOR ","»
			«portQuery(role, s, context)»
			«ENDFOR»
			«IF context.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole)).size > 0»
				«IF context.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter(typeof(OperationRequiredRole)).size > 0»,
				«ENDIF»
				«FOR role : context.encapsulatedComponent__AssemblyContext.requiredRoles_InterfaceRequiringEntity.filter(typeof(InfrastructureRequiredRole)) SEPARATOR ","»
				«portQuery(role, s, context)»
				«ENDFOR»
			«ENDIF»
			);
			«childInitTM(context, s)»
			my«context.javaName()».setContext(context);
		}
	'''
	
	def childInitTM(AssemblyContext context, ComposedStructure s) '''
	'''
	
	// -----------------------------------
	// Get the right port to bind
	// If the component is unbound, a null pointer is generated
	// -----------------------------------
	def dispatch portQuery(OperationRequiredRole role, ComposedStructure s, AssemblyContext ctx) '''
		«IF hasConnector(s,ctx,role)»
			«val connector = (getConnector(s, ctx, role) as AssemblyConnector)»
				/* From Connector «connector.id» */
				my«connector.providingAssemblyContext_AssemblyConnector.javaName()».«connector.providedRole_AssemblyConnector.portGetterName()»()
		«ELSE» 
			«IF hasRequiredDelegationConnector(s,ctx,role)»
				«IF (s instanceof Completion)»
					«role.requiredInterface__OperationRequiredRole.delegatorClass(s.javaName()+"Delegator")»
					new «role.requiredInterface__OperationRequiredRole.implementationPackage()».delegates.«s.javaName()+"Delegator"»«role.requiredInterface__OperationRequiredRole.javaName()»
					(
				«ENDIF»
				«val connector2 = getRequiredDelegationConnector(s,ctx,role)»
					this.myContext.getRole«connector2.outerRequiredRole_RequiredDelegationConnector.javaName()»()
				«IF (s instanceof Completion)»
					)
				«ENDIF»
		    «ELSE»
				null
		    «ENDIF» 
	    «ENDIF»
	'''
	
	def dispatch portQuery(InfrastructureRequiredRole role, ComposedStructure s, AssemblyContext ctx) '''
		«IF hasConnector(s,ctx,role)»
			«val connector = (getConnector(s,ctx,role) as AssemblyInfrastructureConnector)»
				/* From Connector «connector.id» */
				my«connector.providingAssemblyContext__AssemblyInfrastructureConnector.javaName()».«connector.providedRole__AssemblyInfrastructureConnector.portGetterName()»()
		«ELSE» 
			«IF hasRequiredDelegationConnector(s,ctx,role)»
				«IF (s instanceof Completion)»
					«role.requiredInterface__InfrastructureRequiredRole.delegatorClass(s.javaName()+"Delegator")»
					new «role.requiredInterface__InfrastructureRequiredRole.implementationPackage()».delegates.«s.javaName()+"Delegator"»«role.requiredInterface__InfrastructureRequiredRole.javaName()»
					(
				«ENDIF»
				«val connector2 = getRequiredDelegationConnector(s,ctx,role)»
					this.myContext.getRole«connector2.outerRequiredRole_RequiredDelegationConnector.javaName()»()
				«IF (s instanceof Completion)»
					)
				«ENDIF»
		   «ELSE»
				null
		   «ENDIF» 
	    «ENDIF»
	'''
}
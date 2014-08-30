package de.uka.ipd.sdq.pcm.m2m.xtend.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.completions.Completion
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.core.composition.ComposedStructure
import de.uka.ipd.sdq.pcm.core.entity.ComposedProvidingRequiringEntity
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.ComposedStructureXpt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.m2m.xtend.transformations.PCMext
import de.uka.ipd.sdq.pcm.repository.BasicComponent
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.subsystem.SubSystem
import de.uka.ipd.sdq.pcm.system.System
import edu.kit.student.dwerle.xtendfw.annotations.ModelIn

@ModelIn(#[
	"completions.Completion",
	"pcm.core.composition.AssemblyContext",
	"pcm.core.composition.ComposedStructure",
	"pcm.core.entity.ComposedProvidingRequiringEntity",
	"pcm.repository.BasicComponent",
	"pcm.repository.CompositeComponent",
	"pcm.subsystem.SubSystem",
	"pcm.system.System"
])
class SimComposedStructureXpt extends ComposedStructureXpt {
	@Inject extension PCMext
	@Inject extension JavaNamesExt
	
	override childInitTM(AssemblyContext ac, ComposedStructure s) '''
		context.setUserData(this.myContext.getUserData());
		  
		«IF ac.encapsulatedComponent__AssemblyContext instanceof BasicComponent»
		//Initialize Component Parameters
		de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> componentStackFrame = 
			new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>();
		«FOR pu : ac.configParameterUsages__AssemblyContext»
			«FOR vc : pu.variableCharacterisation_VariableUsage»
				componentStackFrame.addValue("«pu.parameterUsageLHS()+'.'+vc.type.toString()»",
				   	new de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy("«vc.specification_VariableCharacterisation.specification.specificationString()»",
				   	new de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object>()));
			«ENDFOR»
		«ENDFOR»
		
		// possibly overwrite some with user data if this AssemblyContext is meant
		this.myContext.getUserData().overwriteParametersForAssemblyContext(my«ac.javaName()».getAssemblyContext().getId(), componentStackFrame);
		
		my«ac.javaName()».setComponentFrame(componentStackFrame);
		«ENDIF»
	'''
	
	def composedPREConstructorStart(ComposedProvidingRequiringEntity cpre) '''
		private de.uka.ipd.sdq.pcm.core.composition.AssemblyContext assemblyContext = null;
		
	public de.uka.ipd.sdq.pcm.core.composition.AssemblyContext getAssemblyContext() {
		return this.assemblyContext;
	}	
		
		private de.uka.ipd.sdq.simucomframework.model.SimuComModel model;
		
		private de.uka.ipd.sdq.simucomframework.model.SimuComModel getModel() {
			return model;
		}
	
«««		open curly brace here, is closed in main define.
		«IF cpre instanceof System»
		public «cpre.className()»(de.uka.ipd.sdq.simucomframework.model.SimuComModel model) {
		this.model = model; 
		«ELSE»
		public «cpre.className()» (String assemblyContextURI, de.uka.ipd.sdq.simucomframework.model.SimuComModel model) {
		    /* The assembly context contains this Assembly Context's id plus potentially Assembly Context's ids of its parents in the system. */
			this.assemblyContext = (de.uka.ipd.sdq.pcm.core.composition.AssemblyContext) org.palladiosimulator.commons.emfutils.EMFLoadHelper.loadModel(assemblyContextURI);
			
			this.model = model;
					
			logger.info("Creating composed structure «cpre.entityName» with AssemblyContextID " + assemblyContext.getId());
		«ENDIF»
«««		Do not close curly brace here.
	'''
	
	private def childMemberVarInit(AssemblyContext ac) '''
		my«ac.javaName()» = new «ac.encapsulatedComponent__AssemblyContext.fqn()»
		      	(«ac.componentConstructorParametersTM», model);
	'''
	
	// overwritten template methods
	
	override composedPREConstructorStartTM(ComposedProvidingRequiringEntity entity) {
		composedPREConstructorStart(entity)
	}
	
	override componentConstructorParametersTM(AssemblyContext obj) {
		if ((obj.parentStructure__AssemblyContext instanceof CompositeComponent)
		  ||(obj.parentStructure__AssemblyContext instanceof SubSystem)
		  ||(obj.parentStructure__AssemblyContext instanceof Completion)
		  ||(obj.parentStructure__AssemblyContext instanceof System))
			'''"«obj.id»" + this.assemblyContext.getId()'''
		else
			'''this.assemblyContext'''
	}
	
	override childMemberVarInitTM(AssemblyContext context) {
		childMemberVarInit(context)
	}
	
	override composedStructureEnd(ComposedStructure entity) '''
	   }
	'''
	
}
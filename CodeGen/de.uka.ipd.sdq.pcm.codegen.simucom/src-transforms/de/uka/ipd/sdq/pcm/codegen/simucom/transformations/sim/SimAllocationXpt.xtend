package de.uka.ipd.sdq.pcm.codegen.simucom.transformations.sim

import com.google.inject.Inject
import de.uka.ipd.sdq.pcm.allocation.Allocation
import de.uka.ipd.sdq.pcm.allocation.AllocationContext
import de.uka.ipd.sdq.pcm.core.composition.AssemblyContext
import de.uka.ipd.sdq.pcm.codegen.simucom.helper.M2TFileSystemAccess
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.AllocationXpt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.JavaNamesExt
import de.uka.ipd.sdq.pcm.codegen.simucom.transformations.PCMext
import de.uka.ipd.sdq.pcm.repository.CompositeComponent
import de.uka.ipd.sdq.pcm.subsystem.SubSystem
import de.uka.ipd.sdq.pcm.system.System
import javax.annotation.processing.Completion

class SimAllocationXpt extends AllocationXpt {
	@Inject extension M2TFileSystemAccess fsa
	
	@Inject extension JavaNamesExt
	@Inject extension PCMext
	@Inject extension SimResourcesXpt
	
	//------------------------------
	// Allocation Context
	// 1.) Generate a simulated resource environment
	// 2.) Generate a context class which can be queried
	//     to retrieve the resource container of the component in the 
	//     current context
	//------------------------------
	def allocation(Allocation a) {
		a.targetResourceEnvironment_Allocation.resourceEnvironmentRoot
	
		val fileName = a.fqnAllocationContext.fqnToDirectoryPath+".java"
		val fileContent = '''
			package «a.fqnAllocationContextPackage()»;
			 
			public class «a.fqnAllocationContextClass()» 
			extends de.uka.ipd.sdq.simucomframework.Context {
				public «a.fqnAllocationContextClass()»(de.uka.ipd.sdq.simucomframework.model.SimuComModel myModel) {
					super(myModel);
				}
				
				protected void initialiseAssemblyContextLookup() {
					«FOR context : a.allocationContexts_Allocation»
						«context.assemblyContextLink(a.system_Allocation)»
					«ENDFOR»
				}
			}
		'''
		
		fsa.generateFile(fileName, fileContent)
	}

	// The following rule assumes the current 1:1 relationship between allocation context and
	// assembly context!
	// Additionally, it assumes that a SubSystem is only used once in the system (it will cause an error if 
	// it is used multiple times and the inner components are directly allocated.
	def assemblyContextLink(AllocationContext context, System system) '''
		
		«val fullAssemblyContextID =
			if ((context.assemblyContext_AllocationContext.parentStructure__AssemblyContext instanceof SubSystem)
				|| (context.assemblyContext_AllocationContext.parentStructure__AssemblyContext instanceof Completion))
					context.assemblyContext_AllocationContext.id + system.getParentSubsystemsIdConcatenationFor(
						(context.assemblyContext_AllocationContext.parentStructure__AssemblyContext) as SubSystem
					)
			else
				context.assemblyContext_AllocationContext.id
		»
		linkAssemblyContextAndResourceContainer("«fullAssemblyContextID»","«context.resourceContainer_AllocationContext.id»");
		
		
		«IF (context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext instanceof CompositeComponent) 
		|| (context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext instanceof SubSystem)
		|| (context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext instanceof Completion)»
			«FOR assemblyContext : (context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext as CompositeComponent).assemblyContexts__ComposedStructure»
				«assemblyContext.compositeAllocation(context, fullAssemblyContextID, system)»
			«ENDFOR»
		«ENDIF»
	'''

	def String compositeAllocation(AssemblyContext context, AllocationContext allocCxt, String parentid, System system) '''
«««		Store this context id (1) alone and (2) together with parent id and then
«««		recursively call this definition for the child components.  
«««		Thus, all combinations of subsystems, composite components and basic components are 
«««		hopefully covered. 
«««		TODO: Some combinations might be superfluous and could be excluded here. 
«««		But test throurouhly with also composite components inside nested subsystems... «ENDREM»
		linkAssemblyContextAndResourceContainer("«context.id»"+"«parentid»","«allocCxt.resourceContainer_AllocationContext.id»");
		«IF (context.encapsulatedComponent__AssemblyContext instanceof CompositeComponent)
		|| (context.encapsulatedComponent__AssemblyContext instanceof SubSystem)
		|| (context.encapsulatedComponent__AssemblyContext instanceof Completion)»
			«FOR assemblyContext : (context.encapsulatedComponent__AssemblyContext as CompositeComponent).assemblyContexts__ComposedStructure»
				«assemblyContext.compositeAllocation(allocCxt, context.id + parentid, system)»
			«ENDFOR»
			«FOR assemblyContext : (context.encapsulatedComponent__AssemblyContext as CompositeComponent).assemblyContexts__ComposedStructure»
				«assemblyContext.compositeAllocation(allocCxt, context.id, system)»
			«ENDFOR»
		«ENDIF»
	'''

	// overwritten template methods
	override allocationTM(Allocation allocation) {
		allocation(allocation)
		
		// return type String
		// TODO: check if return type of TM can be changed to void 
		""
	}
	
}
package org.palladiosimulator.protocom.tech.servlet.allocation

import org.palladiosimulator.protocom.tech.servlet.ServletClass
import de.uka.ipd.sdq.pcm.allocation.Allocation
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames

class ServletAllocationStorage extends ServletClass<Allocation> {
	protected val frameworkBase = "org.palladiosimulator.protocom.framework.java.ee"
	
	new(Allocation pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		//'''«frameworkBase».legacy.AbstractAllocationStorage'''
	}
	
	override packageName() {
		"main"
	}
	
	override compilationUnitName() {
		"ComponentAllocation"
	}
	
	override methods() {
		val allocations = pcmEntity.allocationContexts_Allocation.filter[e | e.assemblyContext_AllocationContext != null]
		var i = 0
		
		#[
			new JMethod()
				.withVisibilityModifier("public")
				.withStaticModifier
				.withName("init")
				.withImplementation('''
					«frameworkBase».prototype.Prototype prototype = «frameworkBase».prototype.Prototype.getInstance();
					«frameworkBase».prototype.Allocation[] allocations = new «frameworkBase».prototype.Allocation[«allocations.length»];
					
					«FOR context : allocations»
						allocations[«i++»] = new «frameworkBase».prototype.Allocation("«context.resourceContainer_AllocationContext.id»", «JavaNames::fqn(context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext)».class, "«context.assemblyContext_AllocationContext.id»");
					«ENDFOR»
					
					prototype.setAllocations(allocations);
				''')
			
			/*new JMethod()
				.withName("initContainerTemplate")
				.withImplementation('''
					String container;
					String containerId;
					Class<?> component;
					String assemblyContext;
					
					«FOR context : pcmEntity.allocationContexts_Allocation.filter[i | i.assemblyContext_AllocationContext != null] SEPARATOR '\n'»
						containerId = "«context.resourceContainer_AllocationContext.id»";
						container = "«context.resourceContainer_AllocationContext.entityName»";
						component = «JavaNames::fqn(context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext)».class;
						assemblyContext = "«context.assemblyContext_AllocationContext.id»";
						saveContainerComponent(containerId, container, component, assemblyContext);
					«ENDFOR»
				''')*/
		]
	}
	
	override filePath() {
		"/src/main/ComponentAllocation.java"
	}	
}

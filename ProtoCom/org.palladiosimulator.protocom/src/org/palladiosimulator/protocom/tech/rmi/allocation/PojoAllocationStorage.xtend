package org.palladiosimulator.protocom.tech.rmi.allocation

import de.uka.ipd.sdq.pcm.allocation.Allocation
import org.palladiosimulator.protocom.lang.java.impl.JMethod
import org.palladiosimulator.protocom.lang.java.util.JavaNames
import org.palladiosimulator.protocom.tech.rmi.PojoClass

/**
 * @author Thomas Zolynski, Sebastian Lehrig
 */
class PojoAllocationStorage extends PojoClass<Allocation> {
	
	new(Allocation pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		"org.palladiosimulator.protocom.framework.AbstractAllocationStorage"
	}
	
	override packageName() {
		"ProtoComBootstrap"
	}
	
	override compilationUnitName() {
		"AllocationStorage"
	}
	
	override methods() {
		#[
			new JMethod()
				.withName("initContainerTemplate")
				.withImplementation('''
					String container;
					String containerId;
					Class<?> component;
					String assemblyContext;
					
					«FOR context : pcmEntity.allocationContexts_Allocation»
						containerId = "«context.resourceContainer_AllocationContext.id»";
						container = "«context.resourceContainer_AllocationContext.entityName»";
						component = «JavaNames::fqn(context.assemblyContext_AllocationContext.encapsulatedComponent__AssemblyContext)».class;
						assemblyContext = "«context.assemblyContext_AllocationContext.id»";
						saveContainerComponent(containerId, container, component, assemblyContext);
					«ENDFOR»
					''')		
		]
	}

	override filePath() {
		"ProtoComBootstrap/AllocationStorage.java"
	}
	
	
	
}
package org.palladiosimulator.protocom.tech.servlet.resourceenvironment

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.tech.ConceptMapping

// TODO: Inherit from ServletClass? No => ResourceEnvironment not a subclass of Entity
class ServletResourceEnvironment extends ConceptMapping<ResourceEnvironment> implements IJClass {
	protected val frameworkBase = "org.palladiosimulator.protocom.framework.jee.servlet"
	
	new(ResourceEnvironment pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
		// '''«frameworkBase».allocation.AllocationStorage'''
	}
	
	override packageName() {
		"main"
	}
	
	override compilationUnitName() {
		"ResourceEnvironment"
	}
	
	override constructors() {
		newLinkedList
	}
	
	override annotations() {
		newLinkedList
	}
	
	override interfaces() {
		newLinkedList
	}
	
	override methods() {
		newLinkedList
	}
	
	override fields() {
		newLinkedList
	}
	
	override filePath() {
		"src/main/ResourceEnvironment.java"
	}
	
	override projectName() {
	}	
}

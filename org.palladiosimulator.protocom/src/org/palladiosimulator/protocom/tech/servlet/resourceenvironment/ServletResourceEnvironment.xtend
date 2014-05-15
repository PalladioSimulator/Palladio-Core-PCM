package org.palladiosimulator.protocom.tech.servlet.resourceenvironment

import org.palladiosimulator.protocom.tech.ConceptMapping
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment
import org.palladiosimulator.protocom.lang.java.IJClass

// TODO: Inherit from ServletClass?
class ServletResourceEnvironment extends ConceptMapping<ResourceEnvironment> implements IJClass {
	new(ResourceEnvironment pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
	}
	
	override constructors() {
		newLinkedList
	}
	
	override packageName() {
		"Bootstrap"
	}
	
	override compilationUnitName() {
		"ResourceEnvironment"
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
		"src/Bootstrap/ResourceEnvironment.java"
	}
	
	override projectName() {
	}	
}

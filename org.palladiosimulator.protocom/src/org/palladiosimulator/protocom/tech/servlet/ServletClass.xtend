package org.palladiosimulator.protocom.tech.servlet

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.tech.ConceptMapping
import org.palladiosimulator.protocom.lang.java.IJClass
import org.palladiosimulator.protocom.lang.java.util.JavaNames

/**
 * @author Christian Klaussner
 */
class ServletClass<E extends Entity> extends ConceptMapping<E> implements IJClass {
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override superClass() {
	}
	
	override constructors() {
		newLinkedList
	}
	
	override packageName() {
		JavaNames::implementationPackage(pcmEntity)
	}
	
	override compilationUnitName() {
		JavaNames::javaName(pcmEntity)
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
		JavaNames::getFileName(pcmEntity)
	}
	
	override projectName() {
	}	
}

package com.palladio_simulator.protocom.tech.rmi

import com.palladio_simulator.protocom.tech.ConceptMapping
import com.palladio_simulator.protocom.lang.java.IJClass
import com.palladio_simulator.protocom.lang.java.util.JavaNames
import de.uka.ipd.sdq.pcm.core.entity.Entity

/**
 * Common super type for all provider creating Java classes. Defines default values
 * for all templates.
 * 
 * @author Thomas Zolynski
 */
abstract class PojoClass<E extends Entity> extends ConceptMapping<E> implements IJClass {
	
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
	
}
package org.palladiosimulator.protocom.tech.iiop

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.lang.xml.IJeeFacetCoreXml
import org.palladiosimulator.protocom.tech.ConceptMapping

class JavaEEIIOPFacetCoreFile <E extends Entity> extends ConceptMapping<E> implements IJeeFacetCoreXml{
	
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override runtimeName() {
	}
	
	override fixedFacet() {
		newLinkedList
	}
	
	override installedFacet() {
		newHashMap
	}
	
	override filePath() {
	}
	
	override projectName() {
	}
	
}